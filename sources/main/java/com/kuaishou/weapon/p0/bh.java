package com.kuaishou.weapon.p0;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.acse.ottn.l3;
import com.google.android.material.timepicker.TimeModel;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class bh {

    /* renamed from: a, reason: collision with root package name */
    private static String f35764a;

    /* renamed from: b, reason: collision with root package name */
    private static String f35765b;

    public static String a() {
        return null;
    }

    public static String b(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Mo().Mc());
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String c(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Mo().Mc());
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String d(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Mo().Mh());
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String e(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Mo().getIccId());
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String f(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Mo().Md());
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static boolean g(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
    }

    public static boolean h(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
    }

    public static String i(Context context) {
        try {
            List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
            StringBuilder sb = new StringBuilder();
            Iterator<InputMethodInfo> it = inputMethodList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getId());
                sb.append(";");
            }
            if (TextUtils.isEmpty(sb)) {
                return bi.f35770c;
            }
            String sb2 = sb.toString();
            return sb2.endsWith(";") ? sb2.substring(0, sb2.length() - 1) : sb2;
        } catch (Exception unused) {
            return bi.f35771d;
        }
    }

    public static String j(Context context) {
        List<InputMethodInfo> enabledInputMethodList;
        ActivityInfo activityInfo;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
                if (string == null) {
                    string = "null";
                }
                String str = "1=" + string + ";";
                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
                if (inputMethodManager != null && (enabledInputMethodList = inputMethodManager.getEnabledInputMethodList()) != null) {
                    str = str + "2=";
                    int i6 = -1;
                    for (InputMethodInfo inputMethodInfo : enabledInputMethodList) {
                        String packageName = inputMethodInfo.getPackageName();
                        if (packageName == null) {
                            packageName = "null";
                        }
                        String settingsActivity = inputMethodInfo.getSettingsActivity();
                        if (settingsActivity == null) {
                            settingsActivity = "null";
                        }
                        if (packageManager != null) {
                            try {
                                if (!packageName.equals("null") && !settingsActivity.equals("null") && (activityInfo = packageManager.getActivityInfo(new ComponentName(packageName, settingsActivity), 0)) != null) {
                                    i6 = activityInfo.launchMode;
                                }
                            } catch (Exception unused) {
                            }
                        }
                        str = str + packageName + "-" + settingsActivity + "-" + String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i6)) + ";";
                    }
                }
                return str;
            } catch (Throwable unused2) {
            }
        }
        return "";
    }

    public static String k(Context context) {
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
                return bi.f35772e;
            }
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
            return TextUtils.isEmpty(string) ? bi.f35770c : string;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String l(android.content.Context r5) {
        /*
            java.lang.String r0 = "accessibility"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.view.accessibility.AccessibilityManager r5 = (android.view.accessibility.AccessibilityManager) r5
            r0 = 0
            if (r5 != 0) goto Lc
            return r0
        Lc:
            java.util.List r5 = r5.getInstalledAccessibilityServiceList()     // Catch: java.lang.Exception -> L43
            if (r5 == 0) goto L44
            int r1 = r5.size()     // Catch: java.lang.Exception -> L43
            if (r1 <= 0) goto L44
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L43
            r1.<init>()     // Catch: java.lang.Exception -> L43
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L41
        L21:
            boolean r2 = r5.hasNext()     // Catch: java.lang.Exception -> L41
            if (r2 == 0) goto L45
            java.lang.Object r2 = r5.next()     // Catch: java.lang.Exception -> L41
            android.accessibilityservice.AccessibilityServiceInfo r2 = (android.accessibilityservice.AccessibilityServiceInfo) r2     // Catch: java.lang.Exception -> L41
            java.lang.String r2 = a(r2)     // Catch: java.lang.Exception -> L41
            int r3 = r1.indexOf(r2)     // Catch: java.lang.Exception -> L41
            r4 = -1
            if (r3 != r4) goto L21
            r1.append(r2)     // Catch: java.lang.Exception -> L41
            java.lang.String r2 = "|"
            r1.append(r2)     // Catch: java.lang.Exception -> L41
            goto L21
        L41:
            goto L45
        L43:
        L44:
            r1 = r0
        L45:
            if (r1 != 0) goto L48
            return r0
        L48:
            int r5 = r1.length()
            if (r5 <= 0) goto L57
            int r5 = r1.length()
            int r5 = r5 + (-1)
            r1.deleteCharAt(r5)
        L57:
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bh.l(android.content.Context):java.lang.String");
    }

    public static String m(Context context) {
        StringBuilder sb;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        StringBuilder sb2 = null;
        if (accessibilityManager == null) {
            return null;
        }
        try {
            if (!accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) == null || enabledAccessibilityServiceList.size() <= 0) {
                sb = null;
            } else {
                sb = new StringBuilder();
                try {
                    Iterator<AccessibilityServiceInfo> it = enabledAccessibilityServiceList.iterator();
                    while (it.hasNext()) {
                        String a6 = a(it.next());
                        if (sb.indexOf(a6) == -1) {
                            sb.append(a6);
                            sb.append(Logger.f33116c);
                        }
                    }
                } catch (Exception unused) {
                    sb2 = sb;
                    sb = sb2;
                    return sb.toString();
                }
            }
        } catch (Exception unused2) {
        }
        if (sb == null) {
            return null;
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '|') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(l3.f4736f, String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String g() {
        try {
            return c(com.kwad.sdk.e.b.Mo().getIp());
        } catch (Throwable unused) {
            return bi.f35770c;
        }
    }

    public static String h() {
        try {
            return c(com.kwad.sdk.e.b.Mo().Me());
        } catch (Throwable unused) {
            return bi.f35770c;
        }
    }

    public static String n(Context context) {
        return bi.f35771d;
    }

    public static String o(Context context) {
        return bi.f35770c;
    }

    public static String p(Context context) {
        return bi.f35768a;
    }

    public static String q(Context context) {
        try {
            if (TextUtils.isEmpty(f35764a)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                f35765b = (String) packageInfo.applicationInfo.loadLabel(context.getPackageManager());
                f35764a = packageInfo.versionName;
            }
        } catch (Throwable unused) {
        }
        return f35764a;
    }

    public static String r(Context context) {
        return f35765b;
    }

    public static String v(Context context) {
        return bi.f35770c;
    }

    public static String x(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            PackageManager packageManager = context.getPackageManager();
            String[] strArr = {"android.hardware.camera", "android.hardware.camera.autofocus", "android.hardware.camera.flash", "android.hardware.location", "android.hardware.location.gps", "android.hardware.location.network", "android.hardware.microphone", "android.hardware.sensor.compass", "android.hardware.sensor.accelerometer", "android.hardware.sensor.light", "android.hardware.sensor.proximity", "android.hardware.telephony", "android.hardware.telephony.cdma", "android.hardware.telephony.gsm", "android.hardware.touchscreen", "android.hardware.touchscreen.multitouch", "android.hardware.touchscreen.multitouch.distinct", "android.hardware.camera.front", "android.hardware.wifi", "android.hardware.bluetooth", "android.hardware.nfc", "android.hardware.fingerprint", "android.hardware.biometrics.face", "android.hardware.screen.portrait", "android.hardware.screen.landscape", "android.hardware.faketouch", "android.hardware.audio.output"};
            for (int i6 = 0; i6 < 27; i6++) {
                if (packageManager.hasSystemFeature(strArr[i6])) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static String y(Context context) {
        Iterator<String> keys;
        try {
            StringBuilder sb = new StringBuilder();
            JSONObject z5 = z(context);
            if (z5 != null && (keys = z5.keys()) != null) {
                String str = "";
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = z5.getString(next);
                    sb.append(str);
                    str = ";";
                    sb.append(next);
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(string);
                }
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static JSONObject z(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = WeaponHI.sUserId;
            String m6 = m();
            String str2 = WeaponHI.sChannel;
            String l6 = l();
            String k6 = k();
            String str3 = "";
            jSONObject.put("userId", TextUtils.isEmpty(str) ? "" : URLEncoder.encode(str, "UTF-8"));
            jSONObject.put("platform", TextUtils.isEmpty(m6) ? "" : URLEncoder.encode(m6, "UTF-8"));
            jSONObject.put("channel", TextUtils.isEmpty(str2) ? "" : URLEncoder.encode(str2, "UTF-8"));
            if (!h.a(context, "re_po_rt").e("a1_p_s_p_s")) {
                jSONObject.put("mod", "");
                jSONObject.put("sysver", "");
                return jSONObject;
            }
            jSONObject.put("mod", TextUtils.isEmpty(l6) ? "" : URLEncoder.encode(l6, "UTF-8"));
            if (!TextUtils.isEmpty(k6)) {
                str3 = URLEncoder.encode(k6, "UTF-8");
            }
            jSONObject.put("sysver", str3);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(Context context, int i6) {
        try {
            if (i6 == 1) {
                return c(com.kwad.sdk.e.b.Mo().Mf());
            }
            return c(com.kwad.sdk.e.b.Mo().Mc());
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static double c() {
        try {
            String c6 = c(com.kwad.sdk.e.b.Mo().getLocation());
            if (!TextUtils.isEmpty(c6) && !c6.startsWith("RISK")) {
                return new JSONObject(c6).getDouble("longitude");
            }
            return -1.0d;
        } catch (Throwable unused) {
            return -1.0d;
        }
    }

    public static String d() {
        try {
            String c6 = c(com.kwad.sdk.e.b.Mo().Mk());
            if (!TextUtils.isEmpty(c6) && !c6.startsWith("RISK")) {
                JSONObject jSONObject = new JSONObject(c6);
                return jSONObject.getString("cellId") + ", " + jSONObject.getString("lac");
            }
            return c6;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String e() {
        try {
            String c6 = c(com.kwad.sdk.e.b.Mo().Mm());
            if (!TextUtils.isEmpty(c6)) {
                c6.startsWith("RISK");
            }
            return c6;
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static JSONArray f() {
        try {
            String c6 = c(com.kwad.sdk.e.b.Mo().Ml());
            if (!TextUtils.isEmpty(c6) && !c6.startsWith("RISK")) {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray(c6);
                for (int i6 = 0; i6 < jSONArray2.length(); i6++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("1", jSONArray2.getJSONObject(i6).getString("ssid"));
                    jSONObject.put("2", jSONArray2.getJSONObject(i6).getString("bssid"));
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String s(Context context) {
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            return "";
        }
    }

    @TargetApi(23)
    public static int t(Context context) {
        try {
            String c6 = c(com.kwad.sdk.e.b.Mo().Mi());
            if (!TextUtils.isEmpty(c6) && !c6.startsWith("RISK")) {
                return Integer.parseInt(c6);
            }
            return -1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    @TargetApi(22)
    public static int u(Context context) {
        try {
            String c6 = c(com.kwad.sdk.e.b.Mo().Mj());
            if (!TextUtils.isEmpty(c6) && !c6.startsWith("RISK")) {
                return Integer.parseInt(c6);
            }
            return -1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String w(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Mo().getOaid());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context) {
        try {
            return c(com.kwad.sdk.e.b.Mo().Mc());
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            if (method != null) {
                return method;
            }
        } catch (Throwable unused) {
        }
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException unused2) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static String a(Context context, int i6) {
        try {
            if (i6 == 1) {
                return c(com.kwad.sdk.e.b.Mo().Mf());
            }
            return c(com.kwad.sdk.e.b.Mo().Mc());
        } catch (Throwable unused) {
            return bi.f35771d;
        }
    }

    public static String c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(str);
            int i6 = jSONObject.getInt("errorCode");
            if (i6 == 0) {
                return jSONObject.getString("value");
            }
            if (i6 == 3) {
                return bi.f35770c;
            }
            if (i6 == 1) {
                return bi.f35768a;
            }
            return bi.f35771d;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String k() {
        return "ANDROID_" + Build.VERSION.RELEASE;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method b6 = b(cls, str, clsArr);
            try {
                b6.setAccessible(true);
                return b6;
            } catch (Throwable unused) {
                return b6;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static double b() {
        try {
            String c6 = c(com.kwad.sdk.e.b.Mo().getLocation());
            if (!TextUtils.isEmpty(c6) && !c6.startsWith("RISK")) {
                return new JSONObject(c6).getDouble("latitude");
            }
            return -1.0d;
        } catch (Throwable unused) {
            return -1.0d;
        }
    }

    private static String a(AccessibilityServiceInfo accessibilityServiceInfo) {
        String id = accessibilityServiceInfo.getId();
        int lastIndexOf = id.lastIndexOf("/");
        return lastIndexOf > 0 ? id.substring(0, lastIndexOf) : id;
    }

    public static String i() {
        try {
            Locale locale = Locale.getDefault();
            return locale.getLanguage() + "-" + locale.getCountry();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String l() {
        return Build.MANUFACTURER + "(" + Build.MODEL + ")";
    }

    public static void a(final Context context, String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || h.a(context, "re_po_rt").c(df.br, 1) == 0) {
            return;
        }
        try {
            JSONObject a6 = new cm(str, ck.f35879l).a(context);
            if (map == null || map.size() <= 0) {
                a6.put("module_section", new JSONObject());
            } else {
                a6.put("module_section", new JSONObject(map));
            }
            final String jSONObject = a6.toString();
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.bh.1
                @Override // java.lang.Runnable
                public final void run() {
                    cp.a(context, jSONObject);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static int b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return new JSONObject(str).getBoolean("userSet") ? 1 : 0;
        } catch (Throwable unused) {
            return -2;
        }
    }

    private static String m() {
        return "ANDROID_PHONE";
    }

    public static String j() {
        Locale locale;
        LocaleList localeList;
        if (Build.VERSION.SDK_INT >= 24) {
            localeList = LocaleList.getDefault();
            locale = localeList.get(0);
        } else {
            locale = Locale.getDefault();
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    public static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
