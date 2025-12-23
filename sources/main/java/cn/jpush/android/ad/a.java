package cn.jpush.android.ad;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JNotifyActivity;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.acse.ottn.l3;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okio.Utf8;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f3425a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static LinkedHashMap<String, String> f3426b = new LinkedHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static String f3427c;

    /* renamed from: d, reason: collision with root package name */
    private static Boolean f3428d;

    /* renamed from: e, reason: collision with root package name */
    private static String f3429e;

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f3430f;

    /* renamed from: g, reason: collision with root package name */
    private static final byte[] f3431g;

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f3432h;

    /* renamed from: i, reason: collision with root package name */
    private static String f3433i;

    /* renamed from: j, reason: collision with root package name */
    private static Class<?> f3434j;

    /* renamed from: k, reason: collision with root package name */
    private static Method f3435k;

    /* renamed from: l, reason: collision with root package name */
    private static String f3436l;

    /* renamed from: m, reason: collision with root package name */
    private static String f3437m;

    public static int a(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        try {
            String[] split = str.split("[._]");
            String[] split2 = str2.split("[._]");
            if (split.length > split2.length) {
                split2 = (String[]) Arrays.copyOf(split2, split.length);
            } else if (split.length < split2.length) {
                split = (String[]) Arrays.copyOf(split, split2.length);
            }
            for (int i6 = 0; i6 < split.length; i6++) {
                long parseLong = (TextUtils.isEmpty(split[i6]) ? 0L : Long.parseLong(split[i6])) - (TextUtils.isEmpty(split2[i6]) ? 0L : Long.parseLong(split2[i6]));
                if (parseLong > 0) {
                    return 1;
                }
                if (parseLong < 0) {
                    return -1;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return str.compareTo(str2);
        }
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(f3427c)) {
            return f3427c;
        }
        try {
            f3427c = context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0)).toString();
        } catch (Throwable unused) {
        }
        return f3427c;
    }

    public static String c() {
        if (!TextUtils.isEmpty(f3437m)) {
            return f3437m;
        }
        try {
            f3437m = Build.MANUFACTURER;
        } catch (Throwable unused) {
        }
        return f3437m;
    }

    private static String d() {
        if (!TextUtils.isEmpty(f3433i)) {
            return f3433i;
        }
        String e6 = e("ro.vivo.os.build.display.id");
        f3433i = e6;
        return e6;
    }

    public static String e(Context context, String str) {
        return context.getPackageName() + "." + str;
    }

    public static void f(Context context) {
        b(context, (String) null);
    }

    static {
        f3425a.add("image/png");
        f3425a.add("image/jpg");
        f3425a.add("image/jpeg");
        f3425a.add("image/webp");
        f3427c = "";
        f3430f = new byte[]{105, 120, 117, 66, 79, 112, 108, 56, 102, 85, 66, 114, 97, 98, Utf8.REPLACEMENT_BYTE, 103, 69, 123, 91, 115, 101, 68, 73, 119, 111, 101};
        f3431g = new byte[]{83, 124, 124, 87, 125, 92, 79, 110, 78, Byte.MAX_VALUE, 125, 85, 97, 122, 107, 115, 98, 67};
        f3432h = new byte[]{123, 115, 101, 122, 65, 111, 105, 69, 114, 66, 73, 105, 124, 83, Byte.MAX_VALUE, 81, 66, 117, 109, 114};
        f3433i = "";
        f3436l = "android.permission.POST_NOTIFICATIONS";
        f3437m = "";
    }

    public static Intent a(Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            try {
                String string = bundle.getString("intent_action");
                if (!TextUtils.isEmpty(string)) {
                    intent.setAction(string);
                }
                Uri uri = (Uri) bundle.getParcelable("intent_data");
                if (uri != null) {
                    intent.setData(uri);
                }
                String[] stringArray = bundle.getStringArray("intent_categories");
                if (stringArray != null && stringArray.length > 0) {
                    for (String str : stringArray) {
                        intent.addCategory(str);
                    }
                }
                Parcelable parcelable = bundle.getParcelable("intent_component");
                if (parcelable != null) {
                    intent.setComponent((ComponentName) parcelable);
                }
                intent.putExtras(bundle);
                intent.setFlags(bundle.getInt("intent_flags"));
                String string2 = bundle.getString("intent_package");
                if (!TextUtils.isEmpty(string2)) {
                    intent.setPackage(string2);
                }
                String string3 = bundle.getString("intent_type");
                if (!TextUtils.isEmpty(string3)) {
                    intent.setType(string3);
                }
            } catch (Throwable unused) {
            }
        }
        return intent;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            int indexOf = str.indexOf("?");
            if (indexOf > 0) {
                str = str.substring(0, indexOf);
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
            }
            return str.substring(str.lastIndexOf("."));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void c(WebSettings webSettings) {
        webSettings.setAllowFileAccess(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDomStorageEnabled(true);
        b(webSettings);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setCacheMode(2);
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);
    }

    public static String d(Context context) {
        if (!TextUtils.isEmpty(f3429e)) {
            return f3429e;
        }
        try {
            f3429e = i.a(JPushConstants.getAppContext(context));
        } catch (Throwable th) {
            Logger.ww("AndroidUtil", "#unexcepted - getCurProcessName failed:" + th.getMessage());
        }
        return f3429e;
    }

    public static String e(String str) {
        return b(str, "");
    }

    private static boolean f(String str) {
        try {
            return f3425a.contains(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Intent g(Context context) {
        Throwable th;
        Intent intent;
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                Logger.ww("AndroidUtil", "The package with the given name cannot be found!");
                return null;
            }
            intent = packageManager.getLaunchIntentForPackage(packageName);
            try {
                if (intent == null) {
                    Logger.ww("AndroidUtil", "Can't get launch intent for this package!");
                    return null;
                }
                intent.addFlags(268435456);
                return intent;
            } catch (Throwable th2) {
                th = th2;
                Logger.w("AndroidUtil", "getLaunchIntent error:" + th.getMessage());
                return intent;
            }
        } catch (Throwable th3) {
            th = th3;
            intent = null;
        }
    }

    public static boolean h(Context context) {
        Logger.dd("AndroidUtil", "action:checkValidManifest");
        if (!a(context, (Class<?>) PushActivity.class)) {
            Logger.ww("AndroidUtil", "AndroidManifest.xml missing required activity: " + PushActivity.class.getCanonicalName());
            Logger.ww("AndroidUtil", "You will unable to use rich push type.");
        }
        if (!a(context, (Class<?>) PopWinActivity.class)) {
            Logger.ww("AndroidUtil", "AndroidManifest.xml missing activity: " + PopWinActivity.class.getCanonicalName());
            Logger.ww("AndroidUtil", "You will unable to use pop-window rich push type.");
        }
        if (!d(context, "cn.jpush.android.ui.PushActivity")) {
            Logger.w("AndroidUtil", "AndroidManifest.xml missing required intent filter for PushActivity: cn.jpush.android.ui.PushActivity");
        }
        if (!i(context)) {
            return false;
        }
        if (!TextUtils.isEmpty(JPushConstants.getMessageReceiverClass(context))) {
            return true;
        }
        Logger.ke("AndroidUtil", "AndroidManifest.xml missing required receiver: please custom receiver extends JPushMessageReceiver. Otherwise no service");
        return false;
    }

    public static boolean i(Context context) {
        if (context != null) {
            try {
                String packageName = context.getPackageName();
                PackageManager packageManager = context.getPackageManager();
                ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent(context, (Class<?>) JNotifyActivity.class), 0);
                if (resolveActivity == null) {
                    Logger.ke("AndroidUtil", "AndroidManifest.xml missing required activity: " + JNotifyActivity.class.getCanonicalName() + ", Otherwise no service");
                    return false;
                }
                if (JCoreHelper.getJCoreSDKVersionInt() < 336 && JPushConstants.SDK_VERSION_CODE >= 483) {
                    Logger.ke("AndroidUtil", "JPush current version is " + JPushConstants.SDK_VERSION_CODE + "，must use JCore 336 or higher.");
                }
                if (context.getResources().getIdentifier("JPushTheme", ResIdentify.RES_TYPE_STYLE, packageName) != resolveActivity.activityInfo.theme) {
                    Logger.ke("AndroidUtil", "JNotifyActivity theme must use android:theme=\\\"@style/JPushTheme\\\">\\n\" ,and the JPushTheme name not confused keep it. Otherwise no service");
                    return false;
                }
                Intent intent = new Intent();
                intent.setAction("cn.jpush.android.intent.JNotifyActivity");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addCategory(context.getPackageName());
                if (packageManager.resolveActivity(intent, 0) != null) {
                    return true;
                }
                Logger.ke("AndroidUtil", "AndroidManifest.xml activity JNotifyActivity Action Must be <action android:name=\"cn.jpush.android.intent.JNotifyActivity\" />");
                Logger.ke("AndroidUtil", "AndroidManifest.xml activity JNotifyActivity Action Must be <category android:name=\"android.intent.category.DEFAULT\" />");
                Logger.ke("AndroidUtil", "AndroidManifest.xml activity JNotifyActivity Action Must be <category android:name=\"${applicationId}\" />\n");
                Logger.ke("AndroidUtil", "AndroidManifest.xml activity JNotifyActivity not set <data>. Otherwise no service");
                return false;
            } catch (Throwable th) {
                Logger.kd("AndroidUtil", "checkJNotifyActivity error:" + th.getMessage());
            }
        }
        return false;
    }

    public static boolean j(Context context) {
        return JPushConstants.isForeGround == 0;
    }

    public static Activity k(Context context) {
        if (context != null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", null).invoke(null, null);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(invoke);
                if (map == null) {
                    Logger.w("AndroidUtil", "get current activities for currentActivityThread, activities is null");
                    return null;
                }
                for (Object obj : map.values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                        declaredField3.setAccessible(true);
                        Activity activity = (Activity) declaredField3.get(obj);
                        if (activity == null) {
                            Logger.w("AndroidUtil", "[getCurrentActivity] activity is null");
                            return null;
                        }
                        if (activity.getPackageName().equals(context.getPackageName())) {
                            Logger.d("AndroidUtil", "getCurrentActivity: " + activity.getLocalClassName());
                            return activity;
                        }
                        Logger.w("AndroidUtil", "current activity packageName: " + activity.getPackageName() + ", appPackageName: " + context.getPackageName());
                        return null;
                    }
                }
            } catch (Throwable th) {
                Logger.w("AndroidUtil", "[getCurrentActivity] error: " + th.getMessage());
            }
        }
        return null;
    }

    public static void l(Context context) {
        String str;
        boolean areNotificationsEnabled;
        if (context instanceof Activity) {
            try {
                LinkedList linkedList = new LinkedList();
                int i6 = Build.VERSION.SDK_INT;
                if (i6 >= 33) {
                    linkedList.add(f3436l);
                    areNotificationsEnabled = ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
                    if (!areNotificationsEnabled) {
                        Logger.ww("AndroidUtil", "request " + f3436l + "，need go to settings and turn on app notification switch");
                    }
                } else {
                    Logger.d("AndroidUtil", " Build.VERSION.SDK_INT:" + i6 + " < 33, not need to request POST_NOTIFICATIONS");
                }
                List<String> a6 = a(context, linkedList);
                if (a6 != null && !a6.isEmpty()) {
                    Logger.v("AndroidUtil", "lackPermissions:" + a6);
                    Class.forName("android.app.Activity").getDeclaredMethod("requestPermissions", String[].class, Integer.TYPE).invoke(context, a6.toArray(new String[a6.size()]), 1);
                    return;
                }
                return;
            } catch (Exception e6) {
                str = "#unexcepted - requestRequiredPermission e:" + e6;
            }
        } else {
            str = "[requestRequiredPermission] context must instanceof Activity";
        }
        Logger.ww("AndroidUtil", str);
    }

    public static Intent a(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent parseUri = Intent.parseUri(str, i6);
        Intent intent = new Intent(parseUri);
        parseUri.addCategory("android.intent.category.BROWSABLE");
        parseUri.setComponent(null);
        parseUri.setSelector(null);
        return intent;
    }

    public static String b(String str, String str2) {
        try {
            if (f3434j == null) {
                f3434j = Class.forName("android.os.SystemProperties");
            }
            if (f3435k == null) {
                f3435k = f3434j.getMethod(l3.f4736f, String.class, String.class);
            }
            return (String) f3435k.invoke(null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static void c(String str, String str2) {
        try {
            if (f3426b.containsKey(str)) {
                return;
            }
            f3426b.put(str, str2);
        } catch (Throwable unused) {
        }
    }

    public static String d(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        return a(str.getBytes());
    }

    public static void e(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String d6 = d(context);
                String packageName = context.getPackageName();
                if (d6 == null || packageName == null || packageName.equals(d6)) {
                    return;
                }
                WebView.setDataDirectorySuffix(d6);
                Logger.d("AndroidUtil", "setDataDirectorySuffix =" + d6);
            }
        } catch (Throwable th) {
            Logger.e("AndroidUtil", "fixWebViewProcess e:" + th);
        }
    }

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        int i6;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            Logger.w("AndroidUtil", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            i6 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            packageInfo = JCoreHelper.getPackageInfo(context, str, i6);
        } catch (Throwable th) {
            Logger.ww("AndroidUtil", "hasComponent error:" + th.getMessage());
        }
        if (packageInfo == null) {
            return null;
        }
        ComponentInfo[] componentInfoArr = i6 != 1 ? i6 != 2 ? i6 != 4 ? i6 != 8 ? null : packageInfo.providers : packageInfo.services : packageInfo.receivers : packageInfo.activities;
        if (componentInfoArr == null) {
            return null;
        }
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (cls.isAssignableFrom(Class.forName(componentInfo.name, false, cls.getClassLoader()))) {
                return componentInfo;
            }
        }
        return null;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b6 : bArr) {
            a(stringBuffer, b6);
        }
        return stringBuffer.toString();
    }

    public static boolean c(Context context) {
        if (f3428d == null) {
            f3428d = Boolean.valueOf(context.getPackageName().equals(d(context)));
        }
        return f3428d.booleanValue();
    }

    public static boolean d(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            return packageManager.resolveActivity(intent, 0) != null;
        } catch (Throwable th) {
            Logger.dd("AndroidUtil", "hasActivityIntentFilter error:" + th.getMessage());
            return true;
        }
    }

    public static Bundle a(Intent intent) {
        Bundle bundle = new Bundle();
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    bundle.putString("intent_action", action);
                }
                Uri data = intent.getData();
                if (data != null) {
                    bundle.putParcelable("intent_data", data);
                }
                Set<String> categories = intent.getCategories();
                if (categories != null && categories.size() > 0) {
                    bundle.putStringArray("intent_categories", (String[]) categories.toArray(new String[0]));
                }
                ComponentName component = intent.getComponent();
                if (component != null) {
                    bundle.putParcelable("intent_component", component);
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    bundle.putAll(extras);
                }
                bundle.putInt("intent_flags", intent.getFlags());
                String str = intent.getPackage();
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("intent_package", str);
                }
                String type = intent.getType();
                if (!TextUtils.isEmpty(type)) {
                    bundle.putString("intent_type", type);
                }
            } catch (Throwable unused) {
            }
        }
        return bundle;
    }

    public static List<String> b(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    String str2 = activityInfo.name;
                    if (!TextUtils.isEmpty(str2) && (TextUtils.isEmpty(str) || packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) == 0)) {
                        arrayList.add(str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static boolean c(Context context, String str) {
        return (TextUtils.isEmpty(str) || JCoreHelper.getPackageInfo(context, str, 0) == null) ? false : true;
    }

    public static String a(String str) {
        try {
            String str2 = f3426b.get(str);
            f3426b.remove(str);
            return str2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b(Context context, String str) {
        try {
            Intent g6 = g(context);
            if (g6 != null) {
                if (!TextUtils.isEmpty(str)) {
                    g6.putExtra(JThirdPlatFormInterface.KEY_EXTRA, str);
                }
                context.startActivity(g6);
            }
        } catch (Throwable th) {
            Logger.dd("AndroidUtil", "startMainActivity error:" + th.getMessage());
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.trim();
        boolean matches = trim.matches("^[http|https]+://.*");
        if (!matches) {
            Logger.w("AndroidUtil", "Invalid url - " + trim);
        }
        return matches;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(l.f3480a);
            messageDigest.update(bArr);
            return b(messageDigest.digest());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void b(WebSettings webSettings) {
        try {
            Class.forName(d.b(f3430f)).getMethod(d.b(f3432h), Boolean.TYPE).invoke(webSettings, Boolean.TRUE);
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "something is wrong:" + th.getMessage());
        }
    }

    private static List<String> a(Context context, List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!a(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean b() {
        try {
            String d6 = d();
            Logger.d("AndroidUtil", "vivoVersion:" + d6);
            if (!Build.MANUFACTURER.equalsIgnoreCase("vivo") && !d6.startsWith("Funtouch")) {
                String e6 = e("ro.iqoo.os.build.display.id");
                Logger.d("AndroidUtil", "iqooMonsterUI:" + e6);
                if (e6 == null) {
                    return false;
                }
                if (TextUtils.isEmpty(e6.trim())) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(Context context, Intent intent, String str) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(action) || JPushInterface.ACTION_NOTIFICATION_OPENED.equals(action)) {
            List<String> b6 = b(context, intent, str);
            if (b6 == null || b6.isEmpty()) {
                Logger.ww("AndroidUtil", "sendBroadcast failed again: receiver not found, action:" + intent.getAction());
                return;
            }
            for (String str2 : b6) {
                try {
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setComponent(new ComponentName(context.getPackageName(), str2));
                    if (TextUtils.isEmpty(str)) {
                        context.sendBroadcast(intent2);
                    } else {
                        context.sendBroadcast(intent2, str);
                    }
                } catch (Exception e6) {
                    Logger.ww("AndroidUtil", "sendBroadcast failed again:" + e6.getMessage() + ", action:" + intent.getAction());
                }
            }
        }
    }

    public static boolean b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        Logger.d("AndroidUtil", "try d:" + str2);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.getPackageManager().resolveActivity(intent, 0) != null;
    }

    public static void a(WebSettings webSettings) {
        try {
            Logger.d("AndroidUtil", "fix.");
            webSettings.setAllowFileAccess(false);
            Class.forName(d.b(f3430f)).getMethod(d.b(f3431g), Boolean.TYPE).invoke(webSettings, Boolean.TRUE);
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "something is wrong:" + th.getMessage());
        }
    }

    public static void a(final WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
            webView.getSettings().setMixedContentMode(0);
        } catch (Throwable th) {
            Logger.e("AndroidUtil", "fixSecure failed, error:" + th);
            webView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: cn.jpush.android.ad.a.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    WebSettings settings = webView.getSettings();
                    if (settings != null) {
                        try {
                            Method declaredMethod = settings.getClass().getDeclaredMethod("removeJavascriptInterface", String.class);
                            if (declaredMethod != null) {
                                declaredMethod.invoke(webView, "searchBoxJavaBridge_");
                                declaredMethod.invoke(webView, "accessibility");
                                declaredMethod.invoke(webView, "accessibilityTraversal");
                            }
                        } catch (Throwable th2) {
                            Logger.e("AndroidUtil", "removeJavascriptInterface failed, error:" + th2);
                        }
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        }
    }

    private static void a(StringBuffer stringBuffer, byte b6) {
        stringBuffer.append("0123456789ABCDEF".charAt((b6 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b6 & 15));
    }

    public static boolean a() {
        boolean z5;
        try {
            z5 = Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "isSdcardExist exception: " + th);
            z5 = false;
        }
        if (!z5) {
            Logger.d("AndroidUtil", "SDCard is not mounted");
        }
        return z5;
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean a(Context context, Class<?> cls) {
        if (context != null) {
            try {
                boolean z5 = context.getPackageManager().resolveActivity(new Intent(context, cls), 0) != null;
                return !z5 ? a(context, context.getPackageName(), cls) != null : z5;
            } catch (Throwable th) {
                Logger.dd("AndroidUtil", "hasActivityResolves error:" + th.getMessage());
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "AndroidUtil"
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L19
            r3 = 23
            r4 = 1
            if (r2 < r3) goto L38
            android.content.pm.ApplicationInfo r2 = r5.getApplicationInfo()     // Catch: java.lang.Throwable -> L19
            int r2 = r2.targetSdkVersion     // Catch: java.lang.Throwable -> L19
            if (r2 < r3) goto L1b
            int r5 = androidx.core.app.q.a(r5, r6)     // Catch: java.lang.Throwable -> L19
            if (r5 != 0) goto L39
            goto L38
        L19:
            r5 = move-exception
            goto L55
        L1b:
            java.lang.String r6 = cn.jiguang.bz.k1.a(r6)     // Catch: java.lang.Throwable -> L19
            if (r6 != 0) goto L22
            goto L36
        L22:
            java.lang.String r2 = "appops"
            java.lang.Object r2 = r5.getSystemService(r2)     // Catch: java.lang.Throwable -> L19
            android.app.AppOpsManager r2 = (android.app.AppOpsManager) r2     // Catch: java.lang.Throwable -> L19
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Throwable -> L19
            int r5 = cn.jiguang.bz.l1.a(r2, r6, r5)     // Catch: java.lang.Throwable -> L19
            if (r5 != 0) goto L35
            r1 = 1
        L35:
            r4 = r1
        L36:
            r1 = r4
            goto L39
        L38:
            r1 = 1
        L39:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L19
            r5.<init>()     // Catch: java.lang.Throwable -> L19
            java.lang.String r6 = "use "
            r5.append(r6)     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L48
            java.lang.String r6 = " had current permission,no need to request"
            goto L4a
        L48:
            java.lang.String r6 = " need to request permission"
        L4a:
            r5.append(r6)     // Catch: java.lang.Throwable -> L19
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L19
            cn.jpush.android.helper.Logger.w(r0, r5)     // Catch: java.lang.Throwable -> L19
            return r1
        L55:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "checkPermission error:"
            r6.append(r2)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            cn.jpush.android.helper.Logger.w(r0, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ad.a.a(android.content.Context, java.lang.String):boolean");
    }

    public static boolean a(Context context, String str, String str2) {
        if (c(context, str)) {
            return true;
        }
        Logger.d("AndroidUtil", "p not:" + str);
        try {
            return b(context, str, str2);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str, boolean z5) {
        HttpURLConnection httpURLConnection;
        String contentType;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable unused) {
            }
            try {
                contentType = httpURLConnection.getContentType();
                Logger.v("AndroidUtil", "httpGetIconBytes contentType:" + contentType);
            } catch (Throwable unused2) {
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return false;
            }
        } catch (Throwable unused3) {
        }
        if (f(contentType)) {
            if (z5) {
                c(str, contentType);
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused4) {
            }
            return true;
        }
        Logger.ke("AndroidUtil", "only support suffix jpg/jpeg/png!! current type=" + contentType);
        httpURLConnection.disconnect();
        return false;
    }
}
