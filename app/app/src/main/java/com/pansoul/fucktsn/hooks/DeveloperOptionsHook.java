package com.pansoul.fucktsn.hooks;

import android.provider.Settings;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import java.util.HashSet;
import java.util.Set;

public class DeveloperOptionsHook extends BaseHook {

    // 用于记录已经Hook过的类,避免重复Hook
    private final Set<String> hookedClasses = new HashSet<>();

    public DeveloperOptionsHook() {
        super("开发者选项检测绕过");
    }

    @Override
    protected void hook(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        
        // Hook 1: Settings.Secure.getInt() - 开发者选项检测
        hookDeveloperSettings();
        
        // Hook 5: Location.isFromMockProvider() - Mock Provider 检测
        hookLocationMockProvider();
        
        // Hook 6: PackageManager.getInstalledPackages() - 隐藏虚拟定位应用
        hookPackageManager();
        
        // 使用 ClassLoader 监听来应对 360 加固（延迟加载的类）
        hookClassLoaderForDelayedClasses(lpparam);
    }
    
    /**
     * Hook ClassLoader.loadClass 来捕获 360 加固延迟加载的安全检测类
     */
    private void hookClassLoaderForDelayedClasses(XC_LoadPackage.LoadPackageParam lpparam) {
        log("开始监听ClassLoader以应对360加固...");
        
        XposedHelpers.findAndHookMethod(
                ClassLoader.class,
                "loadClass",
                String.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        String className = (String) param.args[0];
                        
                        // 只处理目标应用的类
                        if (!className.startsWith("com.bxkj.student")) {
                            return;
                        }
                        
                        // 避免重复Hook
                        if (hookedClasses.contains(className)) {
                            return;
                        }
                        
                        try {
                            Class<?> clazz = (Class<?>) param.getResult();
                            if (clazz == null) {
                                return;
                            }
                            
                            // 标记为已处理
                            hookedClasses.add(className);
                            
                            // 根据类名判断要Hook的内容
                            if (className.equals("com.bxkj.student.v2.ui.sports.safe.b")) {
                                hookSettingSafeClass(clazz);
                            } else if (className.equals("com.bxkj.student.v2.ui.sports.safe.a")) {
                                hookMockUtilsClass(clazz);
                            } else if (className.equals("com.bxkj.student.run.app.utils.n$a")) {
                                hookOldMockLocationUtilsClass(clazz);
                            }
                            
                        } catch (Throwable t) {
                            // 忽略错误,继续处理其他类
                        }
                    }
                }
        );
        
        log("ClassLoader监听已设置");
    }
    
    private void hookDeveloperSettings() {
        try {
            log("正在Hook Settings.Secure.getInt()...");
            XposedHelpers.findAndHookMethod(
                    Settings.Secure.class,
                    "getInt",
                    android.content.ContentResolver.class,
                    String.class,
                    int.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            String key = (String) param.args[1];
                            if ("development_settings_enabled".equals(key)) {
                                // 不输出日志，避免跑步时日志过多
                                param.setResult(0);
                            }
                        }
                    }
            );
            log("✓ Settings.Secure.getInt() Hook完成");
        } catch (Throwable t) {
            log("✗ Settings.Secure.getInt() Hook失败: " + t.getMessage());
        }
    }
    
    /**
     * Hook SettingSafe 类（通过 ClassLoader 监听调用）
     */
    private void hookSettingSafeClass(Class<?> clazz) {
        try {
            XposedHelpers.findAndHookMethod(
                    clazz,
                    "b",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            log("[ClassLoader拦截] SettingSafe.b() 开发者检测 -> 返回false");
                            param.setResult(false);
                        }
                    }
            );
            log("✓ SettingSafe.b() Hook完成: " + clazz.getName());
        } catch (Throwable t) {
            log("✗ SettingSafe.b() Hook失败: " + t.getMessage());
        }
    }
    
    /**
     * Hook MockUtils 类（通过 ClassLoader 监听调用）
     */
    private void hookMockUtilsClass(Class<?> clazz) {
        try {
            // Hook MockUtils.a() - ACCESS_MOCK_LOCATION 权限检测
            XposedHelpers.findAndHookMethod(
                    clazz,
                    "a",
                    android.content.Context.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            log("[ClassLoader拦截] MockUtils.a() 权限检测 -> 返回false");
                            param.setResult(false);
                        }
                    }
            );
            
            // Hook MockUtils.c() - 虚拟定位应用列表检测
            XposedHelpers.findAndHookMethod(
                    clazz,
                    "c",
                    android.content.Context.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            log("[ClassLoader拦截] MockUtils.c() 应用列表检测 -> 返回空列表");
                            param.setResult(new java.util.ArrayList<String>());
                        }
                    }
            );
            
            log("✓ MockUtils Hook完成: " + clazz.getName());
        } catch (Throwable t) {
            log("✗ MockUtils Hook失败: " + t.getMessage());
        }
    }
    
    private void hookLocationMockProvider() {
        try {
            log("正在Hook Location.isFromMockProvider()...");
            XposedHelpers.findAndHookMethod(
                    android.location.Location.class,
                    "isFromMockProvider",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            // 检查调用栈，只拦截来自目标应用的调用
                            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                            for (StackTraceElement element : stackTrace) {
                                if (element.getClassName().startsWith("com.bxkj.student")) {
                                    // 不输出日志，避免跑步时日志过多
                                    param.setResult(false);
                                    return;
                                }
                            }
                        }
                    }
            );
            log("✓ Location.isFromMockProvider() Hook完成");
        } catch (Throwable t) {
            log("✗ Location.isFromMockProvider() Hook失败: " + t.getMessage());
        }
    }
    
    /**
     * Hook 老版本 MockLocationUtils 类（通过 ClassLoader 监听调用）
     */
    private void hookOldMockLocationUtilsClass(Class<?> clazz) {
        try {
            // Hook n$a.c(Context) - 检测已安装应用是否在黑名单中
            XposedHelpers.findAndHookMethod(
                    clazz,
                    "c",
                    android.content.Context.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            log("[ClassLoader拦截] MockLocationUtils.c() 黑名单检测 -> 返回false");
                            param.setResult(false);
                        }
                    }
            );
            
            // Hook n$a.d(Location, Context) - 检测 Location.isFromMockProvider()
            XposedHelpers.findAndHookMethod(
                    clazz,
                    "d",
                    android.location.Location.class,
                    android.content.Context.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            // 不输出日志，避免跑步时日志过多
                            param.setResult(false);
                        }
                    }
            );
            
            log("✓ 老版本 MockLocationUtils Hook完成: " + clazz.getName());
        } catch (Throwable t) {
            log("✗ 老版本 MockLocationUtils Hook失败: " + t.getMessage());
        }
    }
    
    /**
     * Hook PackageManager.getInstalledPackages() - 隐藏虚拟定位应用
     */
    private void hookPackageManager() {
        try {
            log("正在Hook ApplicationPackageManager.getInstalledPackages()...");
            
            // Hook ApplicationPackageManager (实现类)
            Class<?> applicationPackageManagerClass = XposedHelpers.findClass(
                    "android.app.ApplicationPackageManager",
                    ClassLoader.getSystemClassLoader()
            );
            
            XposedHelpers.findAndHookMethod(
                    applicationPackageManagerClass,
                    "getInstalledPackages",
                    int.class,
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            // 检查调用栈，只拦截来自目标应用的调用
                            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                            boolean shouldFilter = false;
                            for (StackTraceElement element : stackTrace) {
                                if (element.getClassName().startsWith("com.bxkj.student")) {
                                    shouldFilter = true;
                                    break;
                                }
                            }
                            
                            if (shouldFilter && param.getResult() != null) {
                                @SuppressWarnings("unchecked")
                                java.util.List<android.content.pm.PackageInfo> packages = 
                                    (java.util.List<android.content.pm.PackageInfo>) param.getResult();
                                
                                // 黑名单：需要隐藏的应用包名
                                java.util.Set<String> blacklist = new java.util.HashSet<>();
                                blacklist.add("com.lerist.fakelocation");
                                blacklist.add("top.a1024bytes.mockloc.ca.pro");
                                blacklist.add("com.qgwapp.shadowside");
                                blacklist.add("net.superal");
                                blacklist.add("com.deniu.deniu");
                                blacklist.add("com.deniu.multi");
                                blacklist.add("com.txy.anywhere");
                                blacklist.add("de.robv.android.xposed.installer");
                                blacklist.add("github.tornaco.xposedmoduletest");
                                blacklist.add("org.lsposed.manager");
                                blacklist.add("io.github.lsposed.manager");
                                
                                // 过滤掉黑名单中的应用
                                java.util.List<android.content.pm.PackageInfo> filtered = 
                                    new java.util.ArrayList<>();
                                int removedCount = 0;
                                for (android.content.pm.PackageInfo pkg : packages) {
                                    if (!blacklist.contains(pkg.packageName)) {
                                        filtered.add(pkg);
                                    } else {
                                        removedCount++;
                                    }
                                }
                                
                                if (removedCount > 0) {
                                    log("[拦截] PackageManager.getInstalledPackages() -> 隐藏了 " + removedCount + " 个虚拟定位应用");
                                    param.setResult(filtered);
                                }
                            }
                        }
                    }
            );
            log("✓ ApplicationPackageManager.getInstalledPackages() Hook完成");
        } catch (Throwable t) {
            log("✗ ApplicationPackageManager Hook失败: " + t.getMessage());
            
            // 备用方案：直接Hook PackageManager.getInstalledApplications
            try {
                log("尝试备用方案: Hook getInstalledApplications...");
                Class<?> applicationPackageManagerClass = XposedHelpers.findClass(
                        "android.app.ApplicationPackageManager",
                        ClassLoader.getSystemClassLoader()
                );
                
                XposedHelpers.findAndHookMethod(
                        applicationPackageManagerClass,
                        "getInstalledApplications",
                        int.class,
                        new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                                boolean shouldFilter = false;
                                for (StackTraceElement element : stackTrace) {
                                    if (element.getClassName().startsWith("com.bxkj.student")) {
                                        shouldFilter = true;
                                        break;
                                    }
                                }
                                
                                if (shouldFilter && param.getResult() != null) {
                                    @SuppressWarnings("unchecked")
                                    java.util.List<android.content.pm.ApplicationInfo> apps = 
                                        (java.util.List<android.content.pm.ApplicationInfo>) param.getResult();
                                    
                                    java.util.Set<String> blacklist = new java.util.HashSet<>();
                                    blacklist.add("com.lerist.fakelocation");
                                    blacklist.add("top.a1024bytes.mockloc.ca.pro");
                                    blacklist.add("com.qgwapp.shadowside");
                                    blacklist.add("net.superal");
                                    blacklist.add("com.deniu.deniu");
                                    blacklist.add("com.deniu.multi");
                                    blacklist.add("com.txy.anywhere");
                                    blacklist.add("de.robv.android.xposed.installer");
                                    blacklist.add("github.tornaco.xposedmoduletest");
                                    blacklist.add("org.lsposed.manager");
                                    blacklist.add("io.github.lsposed.manager");
                                    
                                    java.util.List<android.content.pm.ApplicationInfo> filtered = 
                                        new java.util.ArrayList<>();
                                    int removedCount = 0;
                                    for (android.content.pm.ApplicationInfo app : apps) {
                                        if (!blacklist.contains(app.packageName)) {
                                            filtered.add(app);
                                        } else {
                                            removedCount++;
                                        }
                                    }
                                    
                                    if (removedCount > 0) {
                                        log("[拦截] PackageManager.getInstalledApplications() -> 隐藏了 " + removedCount + " 个虚拟定位应用");
                                        param.setResult(filtered);
                                    }
                                }
                            }
                        }
                );
                log("✓ 备用方案 getInstalledApplications Hook完成");
            } catch (Throwable t2) {
                log("✗ 备用方案也失败: " + t2.getMessage());
            }
        }
    }
}

