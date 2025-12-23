package com.pansoul.fucktsn.hooks;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Hook 签名生成方法，完整分析签名算法
 * 针对 360 加固，需要等待 Application.attach 后再 Hook
 */
public class SignatureHook {
    private static final String TAG = "FuckTSN-Sign";
    private static final AtomicBoolean transformHooked = new AtomicBoolean(false);
    private static final AtomicBoolean deviceHooked = new AtomicBoolean(false);
    private static final AtomicBoolean jniHooked = new AtomicBoolean(false);

    public static void hook(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedBridge.log(TAG + " 开始设置签名 Hook (360加固兼容模式)...");
        
        // 方案1: Hook Application.attach，等待 360 加固解密完成
        XposedHelpers.findAndHookMethod(
            Application.class,
            "attach",
            Context.class,
            new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    Context context = (Context) param.args[0];
                    ClassLoader classLoader = context.getClassLoader();
                    XposedBridge.log(TAG + " Application.attach 完成，ClassLoader: " + classLoader.getClass().getName());
                    
                    // 保存 Context 供后续使用
                    appContext = context;
                    mainHandler = new Handler(Looper.getMainLooper());
                    
                    // 恢复上次登录账号的设备指纹
                    restoreLastAccountFingerprint(context);
                    
                    // 延迟一点再尝试 Hook，确保类已加载
                    tryHookWithClassLoader(classLoader);
                }
            }
        );
        
        // 方案2: 同时监听 ClassLoader.loadClass
        XC_MethodHook loadClassCallback = new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                String className = (String) param.args[0];
                Class<?> clazz = (Class<?>) param.getResult();
                if (clazz == null) return;
                
                // 检测 360 加固的 DexClassLoader
                if (className.contains("StubApp") || className.contains("qihoo")) {
                    XposedBridge.log(TAG + " 检测到 360 加固类: " + className);
                }
                
                // Hook Transform 类
                if ("com.google.android.datatransport.Transform".equals(className)) {
                    if (transformHooked.compareAndSet(false, true)) {
                        XposedBridge.log(TAG + " [loadClass] 检测到 Transform 类!");
                        hookTransformClass(clazz);
                    }
                }
                
                // Hook x.b 类 (JNI 包装类)
                if ("x.b".equals(className)) {
                    if (jniHooked.compareAndSet(false, true)) {
                        XposedBridge.log(TAG + " [loadClass] 检测到 x.b 类!");
                        hookJniClass(clazz);
                    }
                }
            }
        };
        
        // Hook 所有 loadClass 方法
        XposedHelpers.findAndHookMethod(ClassLoader.class, "loadClass", String.class, loadClassCallback);
        XposedHelpers.findAndHookMethod(ClassLoader.class, "loadClass", String.class, boolean.class, loadClassCallback);
        
        XposedBridge.log(TAG + " Hook 设置完成，等待 360 加固解密...");
    }
    
    /**
     * 使用指定的 ClassLoader 尝试 Hook
     */
    private static void tryHookWithClassLoader(ClassLoader classLoader) {
        XposedBridge.log(TAG + " 尝试使用 ClassLoader Hook: " + classLoader);
        
        // 尝试 Hook x.b (JNI 包装类)
        try {
            Class<?> jniClass = XposedHelpers.findClass("x.b", classLoader);
            if (jniClass != null && jniHooked.compareAndSet(false, true)) {
                XposedBridge.log(TAG + " [attach] x.b 类已找到!");
                hookJniClass(jniClass);
            }
        } catch (Throwable t) {
            XposedBridge.log(TAG + " [attach] x.b 类未找到: " + t.getMessage());
        }
        
        // 尝试 Hook Transform
        try {
            Class<?> transformClass = XposedHelpers.findClass(
                "com.google.android.datatransport.Transform", classLoader);
            if (transformClass != null && transformHooked.compareAndSet(false, true)) {
                XposedBridge.log(TAG + " [attach] Transform 类已找到!");
                hookTransformClass(transformClass);
            }
        } catch (Throwable t) {
            XposedBridge.log(TAG + " [attach] Transform 类未找到: " + t.getMessage());
        }
        
        // 尝试 Hook AndroidDevice
        try {
            Class<?> deviceClass = XposedHelpers.findClass(
                "com.bxkj.base.v2.common.utils.f", classLoader);
            if (deviceClass != null && deviceHooked.compareAndSet(false, true)) {
                XposedBridge.log(TAG + " [attach] AndroidDevice 类已找到!");
                hookDeviceClass(deviceClass);
            }
        } catch (Throwable t) {
            XposedBridge.log(TAG + " [attach] AndroidDevice 类未找到: " + t.getMessage());
        }
        
        // Hook OkHttp 响应，拦截 /auth/oauth/token 获取当前登录账号
        hookOkHttpResponse(classLoader);
    }
    
    private static final AtomicBoolean okHttpHooked = new AtomicBoolean(false);
    private static Context appContext = null;
    private static Handler mainHandler = null;
    private static boolean selfCheckPassed = false;
    private static String lastCheckResult = null;
    
    // 自检场景标记
    private static final int CHECK_SCENE_NORMAL = 0;      // 普通请求
    private static final int CHECK_SCENE_START_RUN = 1;   // 开始跑步
    private static final int CHECK_SCENE_SUBMIT_RUN = 2;  // 提交跑步
    private static int pendingCheckScene = CHECK_SCENE_NORMAL;
    
    /**
     * Hook OkHttp 响应，拦截登录/刷新 token 的响应，获取当前登录账号
     */
    private static void hookOkHttpResponse(ClassLoader classLoader) {
        if (!okHttpHooked.compareAndSet(false, true)) return;
        
        try {
            // Hook RealCall.getResponseWithInterceptorChain() 的返回值
            // 或者 Hook Response.body().string()
            
            // 方案: Hook okhttp3.ResponseBody.string()
            Class<?> responseBodyClass = XposedHelpers.findClass("okhttp3.ResponseBody", classLoader);
            
            XposedBridge.hookAllMethods(responseBodyClass, "string", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    String body = (String) param.getResult();
                    if (body == null || body.isEmpty()) return;
                    
                    // 检查是否是 token 响应（包含 access_token 和 username）
                    if (body.contains("\"access_token\"") && body.contains("\"username\"")) {
                        try {
                            JSONObject json = new JSONObject(body);
                            String username = json.optString("username", "");
                            
                            if (!username.isEmpty()) {
                                XposedBridge.log(TAG + " [Token响应] 检测到登录账号: " + username);
                                
                                // 自动切换到该账号的设备指纹
                                switchToAccountFingerprint(username);
                            }
                        } catch (Exception e) {
                            // 忽略解析错误
                        }
                    }
                }
            });
            
            XposedBridge.log(TAG + " [OkHttp] ResponseBody.string() Hook 成功!");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " [OkHttp] Hook 失败: " + t.getMessage());
        }
    }
    
    /**
     * 切换到指定账号的设备指纹
     */
    private static void switchToAccountFingerprint(String username) {
        if (appContext == null) {
            XposedBridge.log(TAG + " [切换] appContext 为空，无法切换");
            return;
        }
        
        try {
            SharedPreferences prefs = appContext.getSharedPreferences("account_list", Context.MODE_PRIVATE);
            String accountsJson = prefs.getString("accounts", "[]");
            
            if (accountsJson == null || accountsJson.equals("[]")) {
                XposedBridge.log(TAG + " [切换] 没有保存的账号");
                return;
            }
            
            JSONArray accounts = new JSONArray(accountsJson);
            
            for (int i = 0; i < accounts.length(); i++) {
                JSONObject account = accounts.getJSONObject(i);
                String accountId = account.optString("account", "");
                
                if (accountId.equals(username)) {
                    String uniqueCode = account.optString("uniqueCode", "");
                    String model = account.optString("model", "");
                    
                    if (!uniqueCode.isEmpty()) {
                        currentUniqueCode = uniqueCode;
                        currentModel = model;
                        applyModel();
                        
                        // 保存为上次登录账号
                        SharedPreferences appPrefs = appContext.getSharedPreferences("app_config", Context.MODE_PRIVATE);
                        appPrefs.edit().putString("last_account", username).apply();
                        
                        XposedBridge.log(TAG + " [切换]  已自动切换到账号 " + username + " 的设备指纹");
                        XposedBridge.log(TAG + " [切换] uniqueCode: " + uniqueCode);
                        XposedBridge.log(TAG + " [切换] model: " + model);
                        
                        // 重置自检状态，下次请求时重新检查
                        lastCheckResult = null;
                    } else {
                        XposedBridge.log(TAG + " [切换] 账号 " + username + " 没有保存 uniqueCode");
                    }
                    return;
                }
            }
            
            XposedBridge.log(TAG + " [切换] 未找到账号 " + username + " 的设备指纹记录");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " [切换] 切换失败: " + t.getMessage());
        }
    }
    
    /**
     * Hook Transform 类的所有签名方法
     */
    private static void hookTransformClass(Class<?> transformClass) {
        XposedBridge.log(TAG + " Transform 类已加载，开始 Hook...");
        
        try {
            // Hook Transform.v(context, token, timestamp) - 最常用的签名方法
            XposedBridge.hookAllMethods(transformClass, "v", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    String token = (String) param.args[1];
                    String timestamp = (String) param.args[2];
                    XposedBridge.log(TAG + " ====== Transform.v() ======");
                    XposedBridge.log(TAG + " [输入] token=" + token);
                    XposedBridge.log(TAG + " [输入] timestamp=" + timestamp);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    String sign = (String) param.getResult();
                    XposedBridge.log(TAG + " [输出] sign=" + sign);
                    XposedBridge.log(TAG + " ============================");
                }
            });

            // Hook Transform.u(context, appId, token, timestamp)
            XposedBridge.hookAllMethods(transformClass, "u", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    String appId = (String) param.args[1];
                    String token = (String) param.args[2];
                    String timestamp = (String) param.args[3];
                    XposedBridge.log(TAG + " ====== Transform.u() ======");
                    XposedBridge.log(TAG + " [输入] appId=" + appId);
                    XposedBridge.log(TAG + " [输入] token=" + token);
                    XposedBridge.log(TAG + " [输入] timestamp=" + timestamp);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    String sign = (String) param.getResult();
                    XposedBridge.log(TAG + " [输出] sign=" + sign);
                }
            });

            // Hook Transform.s(context, token, timestamp, data) - 加密数据
            XposedBridge.hookAllMethods(transformClass, "s", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    String token = (String) param.args[1];
                    String timestamp = (String) param.args[2];
                    String data = (String) param.args[3];
                    
                    // 检测是否是跑步提交请求
                    if (data != null && data.contains("\"sportType\"") && data.contains("\"sportTime\"") && data.contains("\"sportRange\"")) {
                        XposedBridge.log(TAG + " [检测] 发现跑步提交请求");
                        pendingCheckScene = CHECK_SCENE_SUBMIT_RUN;
                        lastCheckResult = null; // 重置以强制显示 Toast
                    }
                    
                    // 替换 data 中的 model 和 uniqueCode
                    String modifiedData = replaceDeviceInfo(data);
                    if (!modifiedData.equals(data)) {
                        param.args[3] = modifiedData;
                        data = modifiedData;
                    }
                    
                    XposedBridge.log(TAG + " ====== Transform.s() 加密数据 ======");
                    XposedBridge.log(TAG + " [输入] token=" + token);
                    XposedBridge.log(TAG + " [输入] timestamp=" + timestamp);
                    // 分段打印完整 data
                    logLongString(TAG + " [输入] data", data);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    String[] result = (String[]) param.getResult();
                    if (result != null && result.length >= 2) {
                        XposedBridge.log(TAG + " [输出] key=" + result[0]);
                        // 分段打印完整 param
                        logLongString(TAG + " [输出] param", result[1]);
                    }
                }
            });

            // Hook Transform.t(context, encryptedData, key) - 解密数据
            XposedBridge.hookAllMethods(transformClass, "t", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    String encryptedData = (String) param.args[1];
                    String key = (String) param.args[2];
                    XposedBridge.log(TAG + " ====== Transform.t() 解密数据 ======");
                    XposedBridge.log(TAG + " [输入] key=" + key);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    String result = (String) param.getResult();
                    // 分段打印完整解密结果
                    logLongString(TAG + " [输出] decrypted", result);
                }
            });

            // Hook Transform.a(context) - 获取签名MD5
            XposedBridge.hookAllMethods(transformClass, "a", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    Object result = param.getResult();
                    if (result instanceof String) {
                        XposedBridge.log(TAG + " Transform.a() signatureMD5=" + result);
                    }
                }
            });

            // Hook Transform.x(context) - 可能是 uniqueCode
            XposedBridge.hookAllMethods(transformClass, "x", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    String result = (String) param.getResult();
                    XposedBridge.log(TAG + " Transform.x() result=" + result);
                }
            });

            XposedBridge.log(TAG + " Transform 所有方法 Hook 成功!");
            
        } catch (Exception e) {
            XposedBridge.log(TAG + " Hook Transform 失败: " + e.getMessage());
        }
    }
    
    /**
     * 当前账号的 uniqueCode（由 AccountQuickSelectHook 设置）
     */
    public static String currentUniqueCode = null;
    
    /**
     * 当前账号的设备型号（由 AccountQuickSelectHook 设置）
     * 格式: "Xiaomi-M2012K11AC" 或 "M2012K11AC"
     */
    public static String currentModel = null;
    
    /**
     * 应用设备型号到 Build.MODEL
     * 使用反射修改 final 字段
     */
    public static void applyModel() {
        if (currentModel != null && !currentModel.isEmpty()) {
            try {
                String manufacturer = currentModel;
                String actualModel = currentModel;
                
                if (currentModel.contains("-")) {
                    int dashIndex = currentModel.indexOf("-");
                    manufacturer = currentModel.substring(0, dashIndex);
                    actualModel = currentModel.substring(dashIndex + 1);
                }
                
                // 使用反射修改 final 字段
                setFinalStaticField(android.os.Build.class, "MANUFACTURER", manufacturer);
                setFinalStaticField(android.os.Build.class, "MODEL", actualModel);
                
                XposedBridge.log(TAG + " [Model] 已应用: " + manufacturer + " / " + actualModel);
                XposedBridge.log(TAG + " [Model] 验证: Build.MODEL=" + android.os.Build.MODEL);
            } catch (Throwable t) {
                XposedBridge.log(TAG + " [Model] 应用失败: " + t.getMessage());
            }
        }
    }
    
    /**
     * 修改 final static 字段
     * 兼容 Android 高版本
     */
    private static void setFinalStaticField(Class<?> clazz, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        
        try {
            // 方法1: 尝试移除 final 修饰符（Android 低版本）
            java.lang.reflect.Field modifiersField = java.lang.reflect.Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~java.lang.reflect.Modifier.FINAL);
            field.set(null, value);
        } catch (NoSuchFieldException e) {
            // 方法2: Android 高版本使用 Unsafe（如果可用）
            try {
                Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
                java.lang.reflect.Field unsafeField = unsafeClass.getDeclaredField("theUnsafe");
                unsafeField.setAccessible(true);
                Object unsafe = unsafeField.get(null);
                
                java.lang.reflect.Method objectFieldOffset = unsafeClass.getMethod("staticFieldOffset", java.lang.reflect.Field.class);
                java.lang.reflect.Method putObject = unsafeClass.getMethod("putObject", Object.class, long.class, Object.class);
                java.lang.reflect.Method staticFieldBase = unsafeClass.getMethod("staticFieldBase", java.lang.reflect.Field.class);
                
                long offset = (Long) objectFieldOffset.invoke(unsafe, field);
                Object base = staticFieldBase.invoke(unsafe, field);
                putObject.invoke(unsafe, base, offset, value);
            } catch (Exception e2) {
                // 方法3: 直接使用 XposedHelpers
                XposedHelpers.setStaticObjectField(clazz, fieldName, value);
            }
        }
    }
    
    /**
     * 清除设备信息缓存（在切换账号时调用）
     * 清除 com.bxkj.base.v2.common.utils.d 类的静态字段（uniqueCode 缓存）
     * 注意：反编译后字段名可能是 b 或 f16664b，需要尝试多个名称
     */
    public static void clearDeviceCache(ClassLoader classLoader) {
        try {
            Class<?> deviceClass = XposedHelpers.findClass("com.bxkj.base.v2.common.utils.f", classLoader);
            
            // 尝试多个可能的字段名
            String[] fieldNames = {"f16890b", "b", "uniqueCode", "mUniqueCode"};
            boolean cleared = false;
            
            for (String fieldName : fieldNames) {
                try {
                    XposedHelpers.setStaticObjectField(deviceClass, fieldName, "");
                    XposedBridge.log(TAG + " [清除] uniqueCode 缓存已清除 (字段: " + fieldName + ")");
                    cleared = true;
                    break;
                } catch (Throwable ignored) {
                    // 继续尝试下一个字段名
                }
            }
            
            if (!cleared) {
                // 如果都失败了，尝试遍历所有静态 String 字段
                for (java.lang.reflect.Field field : deviceClass.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) 
                        && field.getType() == String.class) {
                        try {
                            field.setAccessible(true);
                            String value = (String) field.get(null);
                            if (value != null && value.length() == 32) {  // MD5 长度
                                field.set(null, "");
                                XposedBridge.log(TAG + " [清除] uniqueCode 缓存已清除 (字段: " + field.getName() + ", 原值: " + value + ")");
                                cleared = true;
                                break;
                            }
                        } catch (Throwable ignored) {}
                    }
                }
            }
            
            if (!cleared) {
                XposedBridge.log(TAG + " [清除] 未找到 uniqueCode 缓存字段");
            }
        } catch (Throwable t) {
            XposedBridge.log(TAG + " [清除] 清除缓存失败: " + t.getMessage());
        }
    }
    
    /**
     * 恢复上次登录账号的设备指纹
     * 从 SharedPreferences 读取账号列表，找到有 token 的账号（表示已登录），应用其设备指纹
     */
    private static void restoreLastAccountFingerprint(Context context) {
        try {
            XposedBridge.log(TAG + " [恢复] 开始恢复设备指纹...");
            
            // 读取账号列表
            SharedPreferences prefs = context.getSharedPreferences("account_list", Context.MODE_PRIVATE);
            String accountsJson = prefs.getString("accounts", "[]");
            
            XposedBridge.log(TAG + " [恢复] 账号列表长度: " + (accountsJson != null ? accountsJson.length() : 0));
            
            if (accountsJson == null || accountsJson.equals("[]")) {
                XposedBridge.log(TAG + " [恢复] 没有保存的账号");
                return;
            }
            
            JSONArray accounts = new JSONArray(accountsJson);
            XposedBridge.log(TAG + " [恢复] 找到 " + accounts.length() + " 个账号");
            
            // 读取 App 的登录状态，找到当前登录的账号
            SharedPreferences appPrefs = context.getSharedPreferences("app_config", Context.MODE_PRIVATE);
            String lastAccount = appPrefs.getString("last_account", null);
            XposedBridge.log(TAG + " [恢复] 上次登录账号: " + lastAccount);
            
            // 如果没有记录上次账号，尝试使用第一个有 uniqueCode 的账号
            JSONObject targetAccount = null;
            
            for (int i = 0; i < accounts.length(); i++) {
                JSONObject account = accounts.getJSONObject(i);
                String accountId = account.optString("account", "");
                String uniqueCode = account.optString("uniqueCode", "");
                
                XposedBridge.log(TAG + " [恢复] 检查账号: " + accountId + ", uniqueCode: " + (uniqueCode.isEmpty() ? "无" : uniqueCode.substring(0, 8) + "..."));
                
                if (lastAccount != null && accountId.equals(lastAccount)) {
                    targetAccount = account;
                    XposedBridge.log(TAG + " [恢复] 匹配到上次登录账号: " + accountId);
                    break;
                }
                
                // 如果没有 lastAccount，使用第一个有 uniqueCode 的账号
                if (targetAccount == null && !uniqueCode.isEmpty()) {
                    targetAccount = account;
                }
            }
            
            if (targetAccount != null) {
                String account = targetAccount.optString("account", "");
                String model = targetAccount.optString("model", "");
                String uniqueCode = targetAccount.optString("uniqueCode", "");
                
                if (!uniqueCode.isEmpty()) {
                    currentUniqueCode = uniqueCode;
                    currentModel = model;
                    applyModel();
                    
                    XposedBridge.log(TAG + " [恢复]  已恢复账号 " + account + " 的设备指纹");
                    XposedBridge.log(TAG + " [恢复] uniqueCode: " + uniqueCode);
                    XposedBridge.log(TAG + " [恢复] model: " + model);
                    
                    // 重置自检状态
                    lastCheckResult = null;
                } else {
                    XposedBridge.log(TAG + " [恢复] 账号 " + account + " 没有 uniqueCode");
                }
            } else {
                XposedBridge.log(TAG + " [恢复] 没有找到有效的账号设备指纹");
            }
        } catch (Throwable t) {
            XposedBridge.log(TAG + " [恢复] 恢复设备指纹失败: " + t.getMessage());
            t.printStackTrace();
        }
    }
    
    /**
     * Hook AndroidDevice 类获取 uniqueCode
     */
    private static void hookDeviceClass(Class<?> deviceClass) {
        XposedBridge.log(TAG + " AndroidDevice 类已加载，开始 Hook...");
        
        try {
            XposedBridge.hookAllMethods(deviceClass, "d", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    // 如果有设置的 uniqueCode，直接返回它
                    if (currentUniqueCode != null && !currentUniqueCode.isEmpty()) {
                        param.setResult(currentUniqueCode);
                    }
                }
                
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    String uniqueCode = (String) param.getResult();
                    XposedBridge.log(TAG + " AndroidDevice.d() uniqueCode=" + uniqueCode);
                    
                    // 自检：验证返回的 uniqueCode 是否与期望值一致
                    performSelfCheck(uniqueCode);
                }
            });
            XposedBridge.log(TAG + " AndroidDevice.d() Hook 成功!");
        } catch (Exception e) {
            XposedBridge.log(TAG + " Hook AndroidDevice 失败: " + e.getMessage());
        }
    }
    
    /**
     * Hook x.b 类 (JNI 包装类，调用 Transform)
     * 这个类的方法会调用 Transform 的 native 方法
     */
    private static void hookJniClass(Class<?> jniClass) {
        XposedBridge.log(TAG + " x.b (JNI) 类已加载，开始 Hook...");
        
        try {
            // x.b.e(context, token, timestamp) -> Transform.v() 生成签名
            XposedBridge.hookAllMethods(jniClass, "e", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    String token = (String) param.args[1];
                    String timestamp = (String) param.args[2];
                    XposedBridge.log(TAG + " ====== x.b.e() 生成签名 ======");
                    XposedBridge.log(TAG + " [输入] token=" + token);
                    XposedBridge.log(TAG + " [输入] timestamp=" + timestamp);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    String sign = (String) param.getResult();
                    XposedBridge.log(TAG + " [输出] sign=" + sign);
                    XposedBridge.log(TAG + " ================================");
                }
            });
            
            // x.b.b(context, token, timestamp, data) -> Transform.s() 加密数据
            XposedBridge.hookAllMethods(jniClass, "b", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (param.args.length >= 4 && param.args[3] instanceof String) {
                        String token = (String) param.args[1];
                        String timestamp = (String) param.args[2];
                        String data = (String) param.args[3];
                        
                        // 替换 data 中的 model 和 uniqueCode
                        String modifiedData = replaceDeviceInfo(data);
                        if (!modifiedData.equals(data)) {
                            param.args[3] = modifiedData;
                            data = modifiedData;
                        }
                        
                        XposedBridge.log(TAG + " ====== x.b.b() 加密数据 ======");
                        XposedBridge.log(TAG + " [输入] token=" + token);
                        XposedBridge.log(TAG + " [输入] timestamp=" + timestamp);
                        // 分段打印完整 data
                        logLongString(TAG + " [输入] data", data);
                    }
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    Object result = param.getResult();
                    if (result instanceof String[]) {
                        String[] arr = (String[]) result;
                        if (arr.length >= 2) {
                            XposedBridge.log(TAG + " [输出] key=" + arr[0]);
                            // 分段打印完整 param
                            logLongString(TAG + " [输出] param", arr[1]);
                        }
                    }
                }
            });
            
            // x.b.a(context, encryptedData, key) -> Transform.t() 解密数据
            XposedBridge.hookAllMethods(jniClass, "a", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (param.args.length >= 3 && param.args[1] instanceof String && param.args[2] instanceof String) {
                        String key = (String) param.args[2];
                        XposedBridge.log(TAG + " ====== x.b.a() 解密数据 ======");
                        XposedBridge.log(TAG + " [输入] key=" + key);
                    }
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    Object result = param.getResult();
                    if (result instanceof String) {
                        String decrypted = (String) result;
                        // 分段打印完整解密结果
                        logLongString(TAG + " [输出] decrypted", decrypted);
                    }
                }
            });
            
            XposedBridge.log(TAG + " x.b (JNI) 所有方法 Hook 成功!");
            
        } catch (Exception e) {
            XposedBridge.log(TAG + " Hook x.b 失败: " + e.getMessage());
        }
    }
    
    /**
     * 替换 JSON 数据中的 model 和 uniqueCode
     */
    private static String replaceDeviceInfo(String data) {
        if (data == null || data.isEmpty()) return data;
        if (currentModel == null && currentUniqueCode == null) return data;
        
        String result = data;
        
        try {
            // 替换 model（格式: "model":"xxx"）
            if (currentModel != null && !currentModel.isEmpty()) {
                String actualModel = currentModel;
                if (currentModel.contains("-")) {
                    actualModel = currentModel.substring(currentModel.indexOf("-") + 1);
                }
                // 使用正则替换 "model":"任意值"
                result = result.replaceAll("\"model\":\"[^\"]*\"", "\"model\":\"" + actualModel + "\"");
            }
            
            // 替换 uniqueCode（格式: "uniqueCode":"xxx"）
            if (currentUniqueCode != null && !currentUniqueCode.isEmpty()) {
                result = result.replaceAll("\"uniqueCode\":\"[^\"]*\"", "\"uniqueCode\":\"" + currentUniqueCode + "\"");
                // 同时替换 deviceId（environment 里的）
                result = result.replaceAll("\"deviceId\":\"[^\"]*\"", "\"deviceId\":\"" + currentUniqueCode + "\"");
            }
            
            if (!result.equals(data)) {
                XposedBridge.log(TAG + " [替换] 已替换设备信息");
            }
        } catch (Exception e) {
            XposedBridge.log(TAG + " [替换] 失败: " + e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 执行自检：验证 uniqueCode 和 model 是否与期望值一致
     * 根据场景显示不同的提示信息
     */
    private static void performSelfCheck(String actualUniqueCode) {
        if (currentUniqueCode == null || currentUniqueCode.isEmpty()) {
            // 没有设置期望值，跳过自检
            return;
        }
        
        // 获取当前场景并重置
        int currentScene = pendingCheckScene;
        pendingCheckScene = CHECK_SCENE_NORMAL;
        
        // 检查 uniqueCode
        boolean uniqueCodeMatch = currentUniqueCode.equals(actualUniqueCode);
        
        // 检查 model
        String expectedModel = currentModel;
        if (expectedModel != null && expectedModel.contains("-")) {
            expectedModel = expectedModel.substring(expectedModel.indexOf("-") + 1);
        }
        String actualModel = android.os.Build.MODEL;
        boolean modelMatch = (expectedModel == null) || expectedModel.equals(actualModel);
        
        // 生成简洁的检查结果
        String checkResult;
        if (uniqueCodeMatch && modelMatch) {
            checkResult = "FuckTsn:设备指纹自检通过";
            selfCheckPassed = true;
        } else {
            checkResult = "FuckTsn:设备指纹自检失败";
            selfCheckPassed = false;
        }
        
        // 只在结果变化时显示 Toast（避免重复提示）
        if (!checkResult.equals(lastCheckResult)) {
            lastCheckResult = checkResult;
            XposedBridge.log(TAG + " [自检] " + checkResult);
            showToast(checkResult, selfCheckPassed);
        }
    }
    
    /**
     * 标记开始跑步场景，触发自检
     */
    public static void markStartRunScene() {
        pendingCheckScene = CHECK_SCENE_START_RUN;
        lastCheckResult = null; // 重置以强制显示 Toast
        XposedBridge.log(TAG + " [场景] 标记开始跑步");
        // 主动触发自检，不等待下一次 AndroidDevice.b() 调用
        if (currentUniqueCode != null && !currentUniqueCode.isEmpty()) {
            performSelfCheck(currentUniqueCode);
        }
    }
    
    /**
     * 在主线程显示 Toast
     */
    private static void showToast(final String message, final boolean success) {
        if (appContext == null || mainHandler == null) {
            XposedBridge.log(TAG + " [Toast] Context 或 Handler 为空，无法显示 Toast");
            return;
        }
        
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    Toast toast = Toast.makeText(appContext, message, Toast.LENGTH_LONG);
                    toast.show();
                } catch (Throwable t) {
                    XposedBridge.log(TAG + " [Toast] 显示失败: " + t.getMessage());
                }
            }
        });
    }
    
    /**
     * 分段打印长字符串，避免 logcat 截断
     */
    private static void logLongString(String prefix, String str) {
        if (str == null) {
            XposedBridge.log(prefix + "=null");
            return;
        }
        
        int len = str.length();
        XposedBridge.log(prefix + " (长度=" + len + "):");
        
        // 每段 800 字符
        int chunkSize = 800;
        for (int i = 0; i < len; i += chunkSize) {
            int end = Math.min(i + chunkSize, len);
            XposedBridge.log(prefix + "[" + i + "-" + end + "]: " + str.substring(i, end));
        }
    }
}
