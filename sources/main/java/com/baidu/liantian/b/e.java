package com.baidu.liantian.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Message;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.liantian.LiantianProvider;
import com.baidu.liantian.LiantianReceiver;
import com.baidu.liantian.LiantianService;
import com.baidu.liantian.ac.F;
import com.baidu.liantian.ac.U;
import com.baidu.liantian.jni.Asc;
import com.baidu.liantian.rp.Report;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f10342a = false;

    /* renamed from: b, reason: collision with root package name */
    public static String f10343b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f10344c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f10345d = "1000001";

    /* renamed from: e, reason: collision with root package name */
    public static String f10346e = "0a2ff98dd00fdca15fcdbc895fc09e6b";

    /* renamed from: f, reason: collision with root package name */
    public static LiantianReceiver f10347f = null;

    /* renamed from: g, reason: collision with root package name */
    public static Map<String, String> f10348g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private static String f10349h = "";

    /* renamed from: i, reason: collision with root package name */
    private static String f10350i = "";

    /* renamed from: j, reason: collision with root package name */
    private static int f10351j = -1;

    public static void a() {
        com.baidu.liantian.b.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r4) {
        /*
            java.lang.String r0 = com.baidu.liantian.b.e.f10349h     // Catch: java.lang.Throwable -> L56
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L56
            if (r0 != 0) goto Lb
            java.lang.String r4 = com.baidu.liantian.b.e.f10349h     // Catch: java.lang.Throwable -> L56
            return r4
        Lb:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56
            r0.<init>()     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = r4.getPackageName()     // Catch: java.lang.Throwable -> L56
            r0.append(r1)     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = ".liantian.ac.provider"
            r0.append(r1)     // Catch: java.lang.Throwable -> L56
            android.content.pm.PackageManager r1 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = r0.toString()     // Catch: java.lang.Throwable -> L35
            r3 = 0
            android.content.pm.ProviderInfo r1 = r1.resolveContentProvider(r2, r3)     // Catch: java.lang.Throwable -> L35
            if (r1 == 0) goto L39
            boolean r2 = r1.multiprocess     // Catch: java.lang.Throwable -> L36
            r3 = 1
            if (r2 == r3) goto L39
            java.lang.String r2 = r1.processName     // Catch: java.lang.Throwable -> L36
            com.baidu.liantian.b.e.f10349h = r2     // Catch: java.lang.Throwable -> L36
            goto L39
        L35:
            r1 = 0
        L36:
            com.baidu.liantian.b.c()     // Catch: java.lang.Throwable -> L56
        L39:
            if (r1 != 0) goto L59
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L52
            java.lang.Class<com.baidu.liantian.LiantianProvider> r1 = com.baidu.liantian.LiantianProvider.class
            java.lang.String r1 = r1.getCanonicalName()     // Catch: java.lang.Throwable -> L52
            java.lang.String r4 = b(r4, r0, r1)     // Catch: java.lang.Throwable -> L52
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L52
            if (r0 != 0) goto L59
            com.baidu.liantian.b.e.f10349h = r4     // Catch: java.lang.Throwable -> L52
            goto L59
        L52:
            com.baidu.liantian.b.c()     // Catch: java.lang.Throwable -> L56
            goto L59
        L56:
            com.baidu.liantian.b.c()
        L59:
            java.lang.String r4 = com.baidu.liantian.b.e.f10349h
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.e.b(android.content.Context):java.lang.String");
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str));
    }

    public static void d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            d(file2.getAbsolutePath());
                        } else {
                            file2.delete();
                            file2.getAbsolutePath();
                            com.baidu.liantian.b.a();
                        }
                    }
                }
                file.delete();
                file.getAbsolutePath();
                com.baidu.liantian.b.a();
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    public static String e(String str) {
        try {
            int length = str.length();
            int i6 = 0;
            while (i6 < length && (str.charAt(i6) <= ' ' || str.charAt(i6) == 160)) {
                i6++;
            }
            return i6 > 0 ? str.substring(i6) : str;
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return "";
        }
    }

    public static boolean f(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return false;
        }
    }

    public static String[] g(Context context) {
        String[] split;
        String[] split2;
        String str = f10343b;
        String str2 = f10344c;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.baidu.liantian.b.a();
            return new String[]{str, str2};
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String b6 = new com.baidu.liantian.e(context).b();
            if (!TextUtils.isEmpty(b6) && (split = b6.split("-")) != null && split.length == 2) {
                com.baidu.liantian.b.a();
                return split;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String string = new com.baidu.liantian.e(context).f10457a.getString("svi", "");
            if (!TextUtils.isEmpty(string) && (split2 = string.split("-")) != null && split2.length == 2) {
                com.baidu.liantian.b.a();
                return split2;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.baidu.liantian.b.a();
            str = f10345d;
            str2 = f10346e;
        }
        return new String[]{str, str2};
    }

    public static String[] h(Context context) {
        if (!TextUtils.isEmpty(f10343b) && !TextUtils.isEmpty(f10344c)) {
            return new String[]{f10343b, f10344c};
        }
        String b6 = new com.baidu.liantian.e(context).b();
        if (TextUtils.isEmpty(b6)) {
            return null;
        }
        String[] split = b6.split("-");
        if (split == null || split.length != 2) {
            return new String[2];
        }
        f10343b = split[0];
        f10344c = split[1];
        return split;
    }

    public static int m(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                if (activeNetworkInfo.getType() == 1) {
                    return 4;
                }
                if (activeNetworkInfo.getType() != 0) {
                    return -2;
                }
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                    case 4:
                        return 1;
                    case 5:
                    case 6:
                        return 2;
                    case 7:
                        return 1;
                    case 8:
                    case 9:
                    case 10:
                        return 2;
                    case 11:
                        return 1;
                    case 12:
                        return 2;
                    case 13:
                        return 3;
                    case 14:
                    case 15:
                        return 2;
                    default:
                        return 5;
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.PublicKey a(android.content.pm.PackageInfo r1, java.lang.String r2) {
        /*
            android.content.pm.Signature[] r1 = r1.signatures
            if (r1 == 0) goto L14
            int r0 = r1.length
            if (r0 <= 0) goto L14
            r0 = 0
            r1 = r1[r0]
            if (r1 == 0) goto L14
            java.security.PublicKey r1 = com.baidu.liantian.b.d.a(r1)     // Catch: java.lang.Throwable -> L11
            goto L15
        L11:
            com.baidu.liantian.b.c()
        L14:
            r1 = 0
        L15:
            if (r1 != 0) goto L1b
            java.security.PublicKey r1 = com.baidu.liantian.b.d.a(r2)
        L1b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.e.a(android.content.pm.PackageInfo, java.lang.String):java.security.PublicKey");
    }

    public static void i(Context context) {
        Map<String, Integer> g6;
        try {
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            String c6 = eVar.c();
            com.baidu.liantian.b.a();
            if (TextUtils.isEmpty(c6) || (g6 = g(c6)) == null || g6.size() <= 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            int i6 = 0;
            while (true) {
                String str = "";
                if (i6 >= 15) {
                    a(context, "1003137", hashMap);
                    eVar.a("");
                    return;
                }
                Integer num = g6.get(Integer.toString(i6));
                String num2 = Integer.toString(i6);
                if (num != null) {
                    str = num.toString();
                }
                hashMap.put(num2, str);
                i6++;
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    public static void j(Context context) {
        PackageInfo packageInfo;
        String str;
        String str2;
        byte[] encoded;
        try {
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            String e6 = eVar.e();
            long f6 = eVar.f();
            if (TextUtils.isEmpty(e6) && f6 == 0) {
                return;
            }
            String packageName = context.getPackageName();
            JSONArray jSONArray = new JSONArray(e6);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            } catch (Throwable unused) {
                com.baidu.liantian.b.c();
                packageInfo = null;
            }
            if (packageInfo != null) {
                str2 = packageInfo.applicationInfo.sourceDir;
                PublicKey a6 = a(packageInfo, str2);
                if (a6 == null || (encoded = a6.getEncoded()) == null) {
                    str = "";
                } else {
                    a(context, encoded);
                    str = o.a(Base64.encodeToString(encoded, 0).replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\r", ""));
                    com.baidu.liantian.b.a();
                }
            } else {
                str = "";
                str2 = str;
            }
            boolean z5 = false;
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                String optString = optJSONObject.optString("p");
                String optString2 = optJSONObject.optString("s");
                if (packageName.equals(optString) && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(optString2)) {
                    z5 = true;
                }
            }
            com.baidu.liantian.b.a();
            eVar.f10459c.putBoolean("hac", z5);
            eVar.f10459c.commit();
            if (z5) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("0", packageName);
            hashMap.put("1", str);
            if (TextUtils.isEmpty(str2)) {
                hashMap.put("2", "");
            } else {
                File file = new File(str2);
                if (file.exists()) {
                    hashMap.put("2", o.a(file));
                } else {
                    hashMap.put("2", "");
                }
            }
            a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "1003120", hashMap);
        } catch (Throwable unused2) {
            com.baidu.liantian.b.c();
        }
    }

    public static void k(Context context) {
        com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
        long currentTimeMillis = System.currentTimeMillis();
        long j6 = eVar.f10457a.getLong("se_ae_fd", 0L);
        if (j6 == 0) {
            j6 = System.currentTimeMillis();
            eVar.k();
        }
        if (currentTimeMillis - j6 <= 86400000) {
            eVar.c(eVar.n() + 1);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("0", Integer.valueOf(eVar.n() + 1));
        eVar.c(0);
        eVar.k();
        a(context, "1003119", hashMap);
    }

    public static String l(Context context) {
        String str;
        try {
            str = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
        } catch (Throwable unused) {
            str = "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = g.e(context);
            }
            return Asc.fai(str, g(context)[0], context.getPackageName());
        } catch (Throwable unused2) {
            com.baidu.liantian.b.c();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00fe A[Catch: Exception -> 0x010c, TRY_ENTER, TryCatch #0 {Exception -> 0x010c, blocks: (B:3:0x000b, B:7:0x0014, B:10:0x001c, B:13:0x0026, B:16:0x002e, B:19:0x0038, B:22:0x0042, B:25:0x004c, B:28:0x0056, B:31:0x0069, B:34:0x0073, B:37:0x0086, B:39:0x00a3, B:41:0x00ab, B:44:0x00b4, B:47:0x00ca, B:50:0x00fe, B:53:0x0106, B:55:0x00be), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0106 A[Catch: Exception -> 0x010c, TRY_LEAVE, TryCatch #0 {Exception -> 0x010c, blocks: (B:3:0x000b, B:7:0x0014, B:10:0x001c, B:13:0x0026, B:16:0x002e, B:19:0x0038, B:22:0x0042, B:25:0x004c, B:28:0x0056, B:31:0x0069, B:34:0x0073, B:37:0x0086, B:39:0x00a3, B:41:0x00ab, B:44:0x00b4, B:47:0x00ca, B:50:0x00fe, B:53:0x0106, B:55:0x00be), top: B:2:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject n(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.e.n(android.content.Context):org.json.JSONObject");
    }

    public static int o(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e6) {
            e6.toString();
            com.baidu.liantian.b.a();
            com.baidu.liantian.b.c();
            networkInfo = null;
        }
        if (networkInfo == null) {
            com.baidu.liantian.b.a();
            return 0;
        }
        if (1 == networkInfo.getType()) {
            return 2;
        }
        networkInfo.getType();
        return 1;
    }

    public static void p(Context context) {
        PackageInfo packageInfo;
        try {
            String str = b() + "p/1/prt";
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put(com.umeng.analytics.pro.d.S, packageName);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            } catch (Throwable unused) {
                com.baidu.liantian.b.c();
                packageInfo = null;
            }
            if (packageInfo != null) {
                PublicKey a6 = a(packageInfo, packageInfo.applicationInfo.sourceDir);
                if (a6 != null) {
                    byte[] encoded = a6.getEncoded();
                    if (encoded != null) {
                        a(context, encoded);
                        jSONObject.put(CommonNetImpl.SM, o.a(Base64.encodeToString(encoded, 0).replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\r", "")));
                        com.baidu.liantian.b.a();
                    }
                } else {
                    jSONObject.put(CommonNetImpl.SM, "");
                }
            } else {
                jSONObject.put(CommonNetImpl.SM, "");
            }
            String jSONObject2 = jSONObject.toString();
            com.baidu.liantian.b.a();
            String a7 = h.a(context, str, jSONObject2, false);
            com.baidu.liantian.b.a();
            if (a7 != null) {
                JSONObject jSONObject3 = new JSONObject(a7);
                JSONArray optJSONArray = jSONObject3.optJSONArray("product");
                long optLong = jSONObject3.optLong("pt");
                if (optJSONArray != null && optLong > 0) {
                    new com.baidu.liantian.e(context).a(optJSONArray.toString(), optLong);
                }
                if (optLong > 0) {
                    j(context);
                }
            }
        } catch (Throwable unused2) {
            com.baidu.liantian.b.c();
        }
    }

    public static void q(Context context) {
        try {
            f10348g.clear();
            String e6 = new com.baidu.liantian.e(context).e();
            com.baidu.liantian.b.a();
            if (TextUtils.isEmpty(e6)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(e6);
            HashMap hashMap = new HashMap();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                String optString = optJSONObject.optString("p");
                String optString2 = optJSONObject.optString("s");
                com.baidu.liantian.b.a();
                hashMap.put(optString, optString2);
            }
            for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
                String str = packageInfo.packageName;
                com.baidu.liantian.b.a();
                if (hashMap.keySet().contains(str) && !str.equals(context.getPackageName())) {
                    String str2 = (String) hashMap.get(str);
                    com.baidu.liantian.b.a();
                    String str3 = packageInfo.applicationInfo.sourceDir;
                    com.baidu.liantian.b.a();
                    PublicKey a6 = a(packageInfo, str3);
                    com.baidu.liantian.b.a();
                    if (a6 != null) {
                        byte[] encoded = a6.getEncoded();
                        com.baidu.liantian.b.a();
                        if (encoded != null) {
                            a(context, encoded);
                            String a7 = o.a(Base64.encodeToString(encoded, 0).replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\r", ""));
                            com.baidu.liantian.b.a();
                            if (!TextUtils.isEmpty(a7) && a7.equals(str2)) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(com.umeng.analytics.pro.d.S, str);
                                jSONObject.put("av", packageInfo.versionName);
                                jSONObject.put(CommonNetImpl.SM, a7);
                                jSONObject.put(com.kuaishou.weapon.p0.t.f36161v, Build.MODEL);
                                jSONObject.put("al", String.valueOf(Build.VERSION.SDK_INT));
                                f10348g.put(str, jSONObject.toString());
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    public static void c(Context context) {
        try {
            Report report = Report.getInstance(context);
            JSONObject jSONObject = new JSONObject();
            com.baidu.liantian.a.a a6 = com.baidu.liantian.a.a.a(context);
            Map<Integer, String> b6 = a6.b();
            jSONObject.put("0", b6.keySet());
            jSONObject.put("1", b6.values());
            jSONObject.toString();
            com.baidu.liantian.b.a();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("1003003", jSONObject);
            jSONObject2.put("0", jSONObject3);
            Map<Integer, String> c6 = a6.c();
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = c6.values().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONArray.put("com.baidu.liantian");
            jSONArray.toString();
            com.baidu.liantian.b.a();
            jSONObject2.put("2", jSONArray);
            report.w(jSONObject2.toString());
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.liantian.b.b();
        }
    }

    private static String r(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Exception e6) {
            e6.printStackTrace();
            return "1.0.0";
        }
    }

    public static String a(Class<?> cls) {
        try {
            if (cls.getCanonicalName().equals(Integer.TYPE.getCanonicalName())) {
                return Integer.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Boolean.TYPE.getCanonicalName())) {
                return Boolean.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Character.TYPE.getCanonicalName())) {
                return Character.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Byte.TYPE.getCanonicalName())) {
                return Byte.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Short.TYPE.getCanonicalName())) {
                return Short.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Long.TYPE.getCanonicalName())) {
                return Long.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Float.TYPE.getCanonicalName())) {
                return Float.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Double.TYPE.getCanonicalName())) {
                return Double.class.getCanonicalName();
            }
            return null;
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return null;
        }
    }

    public static void f(String str) {
        Map<String, Integer> map;
        try {
            Context context = com.baidu.liantian.core.d.f10403b;
            if (context == null) {
                return;
            }
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            String c6 = eVar.c();
            if (TextUtils.isEmpty(c6)) {
                map = new HashMap<>();
                map.put(str, 1);
            } else {
                Map<String, Integer> g6 = g(c6);
                if (g6 != null && g6.size() > 0) {
                    if (g6.get(str) != null) {
                        g6.put(str, Integer.valueOf(g6.get(str).intValue() + 1));
                    } else {
                        g6.put(str, 1);
                    }
                }
                map = g6;
            }
            if (map == null || map.size() <= 0) {
                return;
            }
            eVar.a(new JSONObject(map).toString());
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && 1 == activeNetworkInfo.getType();
    }

    private static String h(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                String a6 = a(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                return a6;
            } catch (Throwable unused2) {
                try {
                    com.baidu.liantian.b.c();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable unused5) {
            fileInputStream = null;
        }
    }

    private static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str2).exists()) {
            return false;
        }
        try {
            Runtime.getRuntime().exec("chmod " + str + " " + str2 + com.snail.antifake.deviceid.e.f37542d).waitFor();
            return true;
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return false;
        }
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(f10350i)) {
                f10350i = a(Process.myPid());
            }
            return !str.equals(f10350i);
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return false;
        }
    }

    public static void d(Context context) {
        com.baidu.liantian.b.a();
        if (TextUtils.isEmpty("3.1.6.7")) {
            return;
        }
        Report report = Report.getInstance(context);
        try {
            c(context);
            report.i("liantian", "com.baidu.liantian", "3.1.6.7", "1003003", "1003002");
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.liantian.b.b();
        }
    }

    private static String b(Context context, String str, String str2) {
        XmlResourceParser openXmlResourceParser;
        int next;
        String attributeValue;
        String str3;
        String canonicalName;
        try {
            String str4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            openXmlResourceParser = assetManager.openXmlResourceParser(((Integer) AssetManager.class.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str4)).intValue(), "AndroidManifest.xml");
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
        if (openXmlResourceParser != null) {
            do {
                next = openXmlResourceParser.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2 && openXmlResourceParser.getName().equals("manifest") && (attributeValue = openXmlResourceParser.getAttributeValue(null, WiseOpenHianalyticsData.UNION_PACKAGE)) != null && attributeValue.length() != 0) {
                int length = attributeValue.length();
                int i6 = 0;
                boolean z5 = false;
                boolean z6 = true;
                while (true) {
                    if (i6 < length) {
                        char charAt = attributeValue.charAt(i6);
                        if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                            z6 = false;
                        } else if (z6 || ((charAt < '0' || charAt > '9') && charAt != '_')) {
                            if (charAt != '.') {
                                str3 = "bad character '" + charAt + "'";
                                break;
                            }
                            z5 = true;
                            z6 = true;
                        }
                        i6++;
                    } else {
                        str3 = z5 ? null : "must have at least one '.' separator";
                    }
                }
                if (str3 != null && !FaceEnvironment.OS.equals(attributeValue)) {
                    return null;
                }
                if (str2.equals(com.umeng.analytics.pro.d.M)) {
                    canonicalName = LiantianProvider.class.getCanonicalName();
                } else if (str2.equals("service")) {
                    canonicalName = LiantianService.class.getCanonicalName();
                } else {
                    canonicalName = str2.equals(SocialConstants.PARAM_RECEIVER) ? LiantianReceiver.class.getCanonicalName() : null;
                }
                com.baidu.liantian.b.a();
                while (true) {
                    int next2 = openXmlResourceParser.next();
                    if (next2 == 1) {
                        break;
                    }
                    if (next2 == 2) {
                        String name = openXmlResourceParser.getName();
                        if (com.umeng.analytics.pro.d.M.equals(name)) {
                            try {
                                if (openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", CommonNetImpl.NAME).equals(canonicalName)) {
                                    String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "multiprocess");
                                    if (!TextUtils.isEmpty(attributeValue2) && "true".equals(attributeValue2.toLowerCase())) {
                                        return null;
                                    }
                                    String attributeValue3 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "authorities");
                                    if (TextUtils.isEmpty(attributeValue3) || !str.equals(attributeValue3)) {
                                        return null;
                                    }
                                    String attributeValue4 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", UMModuleRegister.PROCESS);
                                    if (!TextUtils.isEmpty(attributeValue4)) {
                                        if (!attributeValue4.startsWith(":")) {
                                            return attributeValue4;
                                        }
                                        return context.getPackageName() + attributeValue4;
                                    }
                                    return context.getPackageName();
                                }
                            } catch (Throwable unused2) {
                                com.baidu.liantian.b.c();
                            }
                        } else if ("service".equals(name)) {
                            try {
                                String attributeValue5 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", CommonNetImpl.NAME);
                                if (!TextUtils.isEmpty(attributeValue5) && attributeValue5.equals(canonicalName)) {
                                    String attributeValue6 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", UMModuleRegister.PROCESS);
                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                        if (!attributeValue6.startsWith(":")) {
                                            return attributeValue6;
                                        }
                                        return context.getPackageName() + attributeValue6;
                                    }
                                    return context.getPackageName();
                                }
                            } catch (Throwable unused3) {
                                com.baidu.liantian.b.c();
                            }
                        } else if (SocialConstants.PARAM_RECEIVER.equals(name)) {
                            try {
                                String attributeValue7 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", CommonNetImpl.NAME);
                                if (!TextUtils.isEmpty(attributeValue7) && attributeValue7.equals(canonicalName)) {
                                    String attributeValue8 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", UMModuleRegister.PROCESS);
                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                        if (!attributeValue8.startsWith(":")) {
                                            return attributeValue8;
                                        }
                                        return context.getPackageName() + attributeValue8;
                                    }
                                    return context.getPackageName();
                                }
                            } catch (Throwable unused4) {
                                com.baidu.liantian.b.c();
                            }
                        } else {
                            continue;
                        }
                        com.baidu.liantian.b.c();
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static Class<?> a(String str) {
        try {
            if (str.contains(Integer.class.getCanonicalName())) {
                return Integer.TYPE;
            }
            if (str.contains(Boolean.class.getCanonicalName())) {
                return Boolean.TYPE;
            }
            if (str.contains(Character.class.getCanonicalName())) {
                return Character.TYPE;
            }
            if (str.contains(Byte.class.getCanonicalName())) {
                return Byte.TYPE;
            }
            if (str.contains(Short.class.getCanonicalName())) {
                return Short.TYPE;
            }
            if (str.contains(Long.class.getCanonicalName())) {
                return Long.TYPE;
            }
            if (str.contains(Float.class.getCanonicalName())) {
                return Float.TYPE;
            }
            if (str.contains(Double.class.getCanonicalName())) {
                return Double.TYPE;
            }
            return null;
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return null;
        }
    }

    public static boolean c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                for (int i6 = 0; i6 < split.length && i6 < split2.length; i6++) {
                    int intValue = Integer.valueOf(split[i6]).intValue() - Integer.valueOf(split2[i6]).intValue();
                    if (intValue != 0) {
                        return intValue > 0;
                    }
                }
                if (split.length > split2.length) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static Map<String, Integer> g(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, (Integer) jSONObject.get(next));
            }
            return hashMap;
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return null;
        }
    }

    public static void d(Context context, String str) {
        String str2 = "";
        com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("0");
                if (optJSONObject != null) {
                    String str3 = "";
                    while (optJSONObject.keys().hasNext()) {
                        str3 = String.valueOf(optJSONObject.keys().next());
                        if (!TextUtils.isEmpty(str3)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        String optString = optJSONObject.optString(str3);
                        eVar.f10462f.putString("al_da" + str3, optString);
                        eVar.f10462f.commit();
                    }
                }
            } catch (Throwable unused) {
                com.baidu.liantian.b.c();
            }
            try {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("1");
                if (optJSONObject2 != null) {
                    while (optJSONObject2.keys().hasNext()) {
                        str2 = String.valueOf(optJSONObject2.keys().next());
                        if (!TextUtils.isEmpty(str2)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String optString2 = optJSONObject2.optString(str2);
                        eVar.f10462f.putString("in_da" + str2, optString2);
                        eVar.f10462f.commit();
                    }
                }
            } catch (Throwable unused2) {
                com.baidu.liantian.b.c();
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("2");
                if (optJSONArray != null) {
                    optJSONArray.toString();
                    com.baidu.liantian.b.a();
                    eVar.f10462f.putString("li_pk_s", optJSONArray.toString());
                    eVar.f10462f.commit();
                }
            } catch (Throwable unused3) {
                com.baidu.liantian.b.c();
            }
        } catch (Throwable unused4) {
            com.baidu.liantian.b.c();
        }
    }

    public static void c(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            System.currentTimeMillis();
            eVar.f10461e.getInt("re_net_ty", 2);
            JSONObject optJSONObject = jSONObject.optJSONObject("Common_section");
            long optLong = optJSONObject.optLong("0");
            String optString = optJSONObject.optString(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
            int optInt = optJSONObject.optInt("5");
            int optInt2 = optJSONObject.optInt("6");
            int optInt3 = optJSONObject.optInt("7");
            int optInt4 = optJSONObject.optInt(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            String optString2 = optJSONObject.optString(Constants.VIA_REPORT_TYPE_SET_AVATAR, "");
            if (optInt2 == 0) {
                optInt2 = 1;
            }
            com.baidu.liantian.rp.c.a aVar = new com.baidu.liantian.rp.c.a();
            aVar.f10483d = str;
            aVar.f10481b = optString;
            aVar.f10486g = optInt;
            aVar.f10482c = 3;
            aVar.f10484e = optLong;
            aVar.f10485f = optInt2;
            aVar.f10487h = optInt3;
            aVar.f10488i = optInt4;
            aVar.f10489j = optString2;
            f a6 = f.a(context);
            Message message = new Message();
            message.what = 1;
            message.obj = aVar;
            a6.f10354a.a(message);
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    public static void a(String str, String str2) {
        f10343b = str;
        f10344c = str2;
    }

    public static boolean a(Context context) {
        try {
            String b6 = b(context);
            if (TextUtils.isEmpty(f10350i)) {
                f10350i = a(Process.myPid());
            }
            if (TextUtils.isEmpty(b6)) {
                return context.getPackageName().equals(f10350i);
            }
            return b6.equals(f10350i);
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return false;
        }
    }

    public static synchronized boolean a(Context context, boolean z5) {
        boolean a6;
        synchronized (e.class) {
            try {
                int i6 = f10351j;
                if (i6 != -1) {
                    return i6 == 1;
                }
                String b6 = b(context);
                if (TextUtils.isEmpty(b6)) {
                    a6 = a(context, context.getPackageName(), true, z5);
                } else {
                    a6 = a(context, b6, false, z5);
                }
                if (a6) {
                    f10351j = 1;
                } else {
                    f10351j = 0;
                }
                return a6;
            } catch (Throwable unused) {
                com.baidu.liantian.b.c();
                return false;
            }
        }
    }

    public static String c() {
        Calendar calendar = Calendar.getInstance();
        int i6 = calendar.get(1);
        int i7 = calendar.get(2);
        int i8 = calendar.get(5);
        StringBuilder sb = new StringBuilder();
        sb.append(i6);
        sb.append(i7);
        sb.append(i8);
        return sb.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:0|1|(2:2|3)|(3:50|51|(13:53|6|7|(2:9|(9:11|12|(2:14|(1:16))(6:(2:43|(1:45))|18|(1:20)|(4:27|(1:(1:35)(1:(1:37)))(1:30)|(1:32)|33)|38|39)|17|18|(0)|(6:22|27|(0)|(0)(0)|(0)|33)|38|39))|48|12|(0)(0)|17|18|(0)|(0)|38|39))|5|6|7|(0)|48|12|(0)(0)|17|18|(0)|(0)|38|39) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007f, code lost:
    
        com.baidu.liantian.b.c();
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0061 A[Catch: all -> 0x007f, TRY_ENTER, TryCatch #3 {all -> 0x007f, blocks: (B:14:0x0061, B:43:0x0071), top: B:12:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0053 A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #2 {all -> 0x005d, blocks: (B:7:0x0032, B:9:0x0053), top: B:6:0x0032 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r9, java.lang.String r10, boolean r11, boolean r12) {
        /*
            r0 = 1
            r1 = 0
            r2 = 0
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Throwable -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L30
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L30
            java.lang.String r5 = r9.getPackageName()     // Catch: java.lang.Throwable -> L30
            java.lang.Class<com.baidu.liantian.LiantianService> r6 = com.baidu.liantian.LiantianService.class
            java.lang.String r6 = r6.getCanonicalName()     // Catch: java.lang.Throwable -> L30
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L30
            r3.setComponent(r4)     // Catch: java.lang.Throwable -> L30
            android.content.pm.PackageManager r4 = r9.getPackageManager()     // Catch: java.lang.Throwable -> L30
            android.content.pm.ResolveInfo r3 = r4.resolveService(r3, r2)     // Catch: java.lang.Throwable -> L30
            if (r3 == 0) goto L31
            android.content.pm.ServiceInfo r4 = r3.serviceInfo     // Catch: java.lang.Throwable -> L31
            java.lang.String r4 = r4.processName     // Catch: java.lang.Throwable -> L31
            boolean r4 = r10.equals(r4)     // Catch: java.lang.Throwable -> L31
            if (r4 == 0) goto L31
            r4 = 1
            goto L32
        L30:
            r3 = r1
        L31:
            r4 = 0
        L32:
            android.content.Intent r5 = new android.content.Intent     // Catch: java.lang.Throwable -> L5d
            r5.<init>()     // Catch: java.lang.Throwable -> L5d
            android.content.ComponentName r6 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L5d
            java.lang.String r7 = r9.getPackageName()     // Catch: java.lang.Throwable -> L5d
            java.lang.Class<com.baidu.liantian.LiantianReceiver> r8 = com.baidu.liantian.LiantianReceiver.class
            java.lang.String r8 = r8.getCanonicalName()     // Catch: java.lang.Throwable -> L5d
            r6.<init>(r7, r8)     // Catch: java.lang.Throwable -> L5d
            r5.setComponent(r6)     // Catch: java.lang.Throwable -> L5d
            android.content.pm.PackageManager r5 = r9.getPackageManager()     // Catch: java.lang.Throwable -> L5d
            android.content.pm.ActivityInfo r1 = r5.getReceiverInfo(r6, r2)     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L5e
            java.lang.String r5 = r1.processName     // Catch: java.lang.Throwable -> L5d
            boolean r5 = r10.equals(r5)     // Catch: java.lang.Throwable -> L5d
            if (r5 == 0) goto L5e
            r5 = 1
            goto L5f
        L5d:
        L5e:
            r5 = 0
        L5f:
            if (r3 != 0) goto L6f
            java.lang.String r1 = "service"
            java.lang.String r1 = b(r9, r10, r1)     // Catch: java.lang.Throwable -> L7f
            boolean r1 = r10.equals(r1)     // Catch: java.lang.Throwable -> L7f
            if (r1 == 0) goto L82
            r4 = 1
            goto L82
        L6f:
            if (r1 != 0) goto L82
            java.lang.String r1 = "receiver"
            java.lang.String r1 = b(r9, r10, r1)     // Catch: java.lang.Throwable -> L7f
            boolean r1 = r10.equals(r1)     // Catch: java.lang.Throwable -> L7f
            if (r1 == 0) goto L82
            r5 = 1
            goto L82
        L7f:
            com.baidu.liantian.b.c()
        L82:
            java.lang.String r1 = com.baidu.liantian.b.e.f10350i
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L94
            int r1 = android.os.Process.myPid()
            java.lang.String r1 = a(r1)
            com.baidu.liantian.b.e.f10350i = r1
        L94:
            if (r12 == 0) goto Ld7
            java.lang.String r12 = com.baidu.liantian.b.e.f10350i
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto Ld7
            if (r5 == 0) goto La4
            if (r4 == 0) goto La4
            if (r11 == 0) goto Ld7
        La4:
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.lang.String r12 = "0"
            if (r5 != 0) goto Lb8
            if (r4 != 0) goto Lb8
            r0 = 2
            java.lang.String r0 = java.lang.Integer.toString(r0)
            r10.put(r12, r0)
            goto Lcb
        Lb8:
            if (r4 != 0) goto Lc2
            java.lang.String r0 = java.lang.Integer.toString(r0)
            r10.put(r12, r0)
            goto Lcb
        Lc2:
            if (r5 != 0) goto Lcb
            java.lang.String r0 = java.lang.Integer.toString(r2)
            r10.put(r12, r0)
        Lcb:
            if (r11 == 0) goto Ld2
            java.lang.String r11 = "1"
            r10.put(r11, r12)
        Ld2:
            java.lang.String r11 = "1003140"
            a(r9, r11, r10)
        Ld7:
            r9 = r5 & r4
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.e.a(android.content.Context, java.lang.String, boolean, boolean):boolean");
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        a(new File(str), new File(str2));
    }

    public static String b() {
        try {
            return new String(F.getInstance().ad(Base64.decode(n.f10376a, 0), "30212102dicudiab".getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        if (file == null || file2 == null || !a(file)) {
            return;
        }
        if (file2.exists()) {
            file2.delete();
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable unused) {
                fileOutputStream = null;
            }
        } catch (Throwable unused2) {
            fileOutputStream = null;
        }
        try {
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, read);
                    }
                }
                fileOutputStream.flush();
                file.getAbsolutePath();
                file2.getAbsolutePath();
                com.baidu.liantian.b.a();
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    e6.getMessage();
                    com.baidu.liantian.b.b();
                }
            } catch (Throwable unused3) {
                fileInputStream2 = fileInputStream;
                try {
                    com.baidu.liantian.b.c();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e7) {
                            e7.getMessage();
                            com.baidu.liantian.b.b();
                        }
                    }
                    if (fileOutputStream == null) {
                        return;
                    }
                    fileOutputStream.close();
                } finally {
                }
            }
            fileOutputStream.close();
        } catch (IOException e8) {
            e8.getMessage();
            com.baidu.liantian.b.b();
        }
    }

    public static String b(Context context, String str) {
        String str2;
        try {
            str2 = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
        } catch (Throwable unused) {
            str2 = "";
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = g.e(context);
            }
            return Asc.fai(str2, str, context.getPackageName());
        } catch (Throwable unused2) {
            com.baidu.liantian.b.c();
            return "";
        }
    }

    public static boolean a(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0;
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        Method method;
        if (obj != null && !TextUtils.isEmpty(str)) {
            if (clsArr != null && objArr != null && clsArr.length != objArr.length) {
                com.baidu.liantian.b.a();
                throw new NoSuchMethodException("paramTypes or args fail");
            }
            Method[] declaredMethods = obj.getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i6];
                if (a(method, str, clsArr)) {
                    break;
                }
                i6++;
            }
            if (method != null) {
                return method.invoke(obj, objArr);
            }
            com.baidu.liantian.b.a();
            throw new NoSuchMethodException("cannot find method in target methodName=" + str);
        }
        com.baidu.liantian.b.a();
        throw new NoSuchMethodException("object=" + obj + ", methodName=" + str);
    }

    private static boolean a(Method method, String str, Class<?>[] clsArr) {
        if (!str.equals(method.getName())) {
            return false;
        }
        com.baidu.liantian.b.a();
        Class<?>[] parameterTypes = method.getParameterTypes();
        if ((parameterTypes != null && parameterTypes.length != 0) || (clsArr != null && clsArr.length != 0)) {
            if ((clsArr == null || clsArr.length == 0) && parameterTypes != null && parameterTypes.length > 0) {
                com.baidu.liantian.b.a();
                return false;
            }
            if ((parameterTypes == null || parameterTypes.length == 0) && clsArr != null && clsArr.length > 0) {
                com.baidu.liantian.b.a();
                return false;
            }
            if (parameterTypes.length != clsArr.length) {
                com.baidu.liantian.b.a();
                return false;
            }
            for (int i6 = 0; i6 < parameterTypes.length; i6++) {
                if (parameterTypes[i6] != clsArr[i6]) {
                    com.baidu.liantian.b.a();
                    return false;
                }
            }
            com.baidu.liantian.b.a();
            return true;
        }
        com.baidu.liantian.b.a();
        return true;
    }

    public static void a(String str, boolean z5) {
        d("771", str);
        com.baidu.liantian.b.a();
        if (z5) {
            d("771", new File(str).getParentFile().getAbsolutePath());
            com.baidu.liantian.b.a();
        }
    }

    public static void a(Context context, String str, Map<String, Object> map) {
        String str2;
        if (TextUtils.isEmpty(str) || !com.baidu.liantian.core.d.f10404c) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "");
            jSONObject2.put("2", "");
            String[] g6 = g(context);
            if (g6 != null && g6.length == 2 && !TextUtils.isEmpty(g6[0]) && !TextUtils.isEmpty(g6[1])) {
                str2 = g6[0];
            } else {
                str2 = f10345d;
            }
            jSONObject2.put("3", str2);
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", "liantian");
            jSONObject2.put("9", "3.1.6.7");
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, str);
            jSONObject.put("Common_section", jSONObject2);
            if (map.size() > 0) {
                jSONObject.put("Module_section", new JSONObject(map));
            } else {
                jSONObject.put("Module_section", new JSONObject());
            }
            Report report = Report.getInstance(context);
            String jSONObject3 = jSONObject.toString();
            com.baidu.liantian.b.a();
            report.s(jSONObject3);
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        r3.getMessage();
        com.baidu.liantian.b.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        if (r2 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        if (r2 != null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            java.util.Properties r1 = new java.util.Properties     // Catch: java.lang.Throwable -> L3f
            r1.<init>()     // Catch: java.lang.Throwable -> L3f
            r2 = 0
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
            java.io.InputStream r2 = r3.open(r4)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
            r1.load(r2)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
            java.lang.String r0 = r1.getProperty(r5)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
            if (r2 == 0) goto L42
        L19:
            r2.close()     // Catch: java.io.IOException -> L1d java.lang.Throwable -> L3f
            goto L42
        L1d:
            r3 = move-exception
            r3.getMessage()     // Catch: java.lang.Throwable -> L3f
            com.baidu.liantian.b.b()     // Catch: java.lang.Throwable -> L3f
            goto L42
        L25:
            r3 = move-exception
            goto L31
        L27:
            r3 = move-exception
            r3.getMessage()     // Catch: java.lang.Throwable -> L25
            com.baidu.liantian.b.b()     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L42
            goto L19
        L31:
            if (r2 == 0) goto L3e
            r2.close()     // Catch: java.io.IOException -> L37 java.lang.Throwable -> L3f
            goto L3e
        L37:
            r4 = move-exception
            r4.getMessage()     // Catch: java.lang.Throwable -> L3f
            com.baidu.liantian.b.b()     // Catch: java.lang.Throwable -> L3f
        L3e:
            throw r3     // Catch: java.lang.Throwable -> L3f
        L3f:
            com.baidu.liantian.b.c()
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.e.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean a(Context context, int i6) {
        if (i6 != 1 || e(context)) {
            return true;
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (f10347f == null) {
            f10347f = new LiantianReceiver().a();
        }
        StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(f10347f, intentFilter);
        f10342a = true;
        return false;
    }

    public static boolean a(Context context, String str) {
        PackageInfo packageInfo;
        PublicKey a6;
        try {
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            String e6 = eVar.e();
            long f6 = eVar.f();
            if (TextUtils.isEmpty(e6) && f6 == 0) {
                return false;
            }
            JSONArray jSONArray = new JSONArray(e6);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            } catch (Throwable unused) {
                com.baidu.liantian.b.c();
                packageInfo = null;
            }
            if (packageInfo == null || (a6 = a(packageInfo, packageInfo.applicationInfo.sourceDir)) == null) {
                return true;
            }
            byte[] encoded = a6.getEncoded();
            String str2 = "";
            if (encoded != null) {
                a(context, encoded);
                str2 = o.a(Base64.encodeToString(encoded, 0).replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\r", ""));
                com.baidu.liantian.b.a();
            }
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                String optString = optJSONObject.optString("p");
                String optString2 = optJSONObject.optString("s");
                if (str.equals(optString) && !TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(optString2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused2) {
            com.baidu.liantian.b.c();
            return true;
        }
    }

    public static void a(Context context, byte[] bArr) {
        try {
            String[] g6 = g(context);
            if (g6 == null || g6.length != 2) {
                return;
            }
            if (TextUtils.isEmpty(g6[0]) || TextUtils.isEmpty(g6[1]) || !"200080".equals(g6[0]) || !context.getPackageName().equals("com.baidu.BaiduMap") || bArr == null) {
                return;
            }
            for (int i6 = 0; i6 < bArr.length; i6++) {
                bArr[i6] = (byte) (bArr[i6] ^ 246);
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a(Context context, com.baidu.liantian.rp.a.a aVar, String str, boolean z5) {
        return a(context, aVar.f10469a, aVar.f10471c, z5 ? aVar.f10472d : aVar.f10473e, str);
    }

    private static String a(int i6) {
        String str;
        try {
            str = h(String.format("/proc/%d/cmdline", Integer.valueOf(i6)));
        } catch (Exception unused) {
            str = null;
        }
        try {
            return !TextUtils.isEmpty(str) ? str.trim() : str;
        } catch (Exception unused2) {
            com.baidu.liantian.b.c();
            return str;
        }
    }

    private static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        boolean z5 = true;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (z5) {
                    z5 = false;
                } else {
                    sb.append('\n');
                }
                sb.append(readLine);
            } else {
                return sb.toString();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x013d A[Catch: all -> 0x014e, TRY_ENTER, TryCatch #5 {all -> 0x014e, blocks: (B:6:0x003d, B:9:0x0043, B:10:0x0056, B:14:0x00be, B:15:0x00c6, B:17:0x0106, B:20:0x013d, B:23:0x0141, B:35:0x00c2, B:38:0x0052), top: B:5:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0141 A[Catch: all -> 0x014e, TRY_LEAVE, TryCatch #5 {all -> 0x014e, blocks: (B:6:0x003d, B:9:0x0043, B:10:0x0056, B:14:0x00be, B:15:0x00c6, B:17:0x0106, B:20:0x013d, B:23:0x0141, B:35:0x00c2, B:38:0x0052), top: B:5:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2 A[Catch: all -> 0x014e, TryCatch #5 {all -> 0x014e, blocks: (B:6:0x003d, B:9:0x0043, B:10:0x0056, B:14:0x00be, B:15:0x00c6, B:17:0x0106, B:20:0x013d, B:23:0x0141, B:35:0x00c2, B:38:0x0052), top: B:5:0x003d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.content.Context r17, org.json.JSONObject r18) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.e.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        com.baidu.liantian.rp.a.a aVar;
        f.a(context).a();
        f a6 = f.a(context);
        Message message = new Message();
        message.what = 8;
        a6.f10354a.a(message);
        com.baidu.liantian.rp.a.a aVar2 = new com.baidu.liantian.rp.a.a();
        aVar2.f10469a = str;
        aVar2.f10470b = str2;
        aVar2.f10471c = str3;
        aVar2.f10472d = str4;
        aVar2.f10473e = str5;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            return;
        }
        com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
        List<com.baidu.liantian.rp.a.a> w5 = eVar.w();
        if (w5 == null) {
            eVar.a(aVar2);
        } else if (!w5.contains(aVar2)) {
            eVar.a(aVar2);
        } else {
            int indexOf = w5.indexOf(aVar2);
            if (indexOf != -1 && (aVar = w5.get(indexOf)) != null) {
                eVar.f10462f.putString("re_con", eVar.f10461e.getString("re_con", "").replace(com.baidu.liantian.rp.a.a.a(aVar), com.baidu.liantian.rp.a.a.a(aVar2)));
                eVar.f10462f.commit();
            }
            f.a(context).b();
            return;
        }
        String str6 = aVar2.f10473e;
        if (!eVar.f10461e.getBoolean("re_net_ins_" + str6, false)) {
            f a7 = f.a(context);
            Message message2 = new Message();
            message2.what = 3;
            message2.obj = aVar2;
            a7.f10354a.a(message2);
        }
        f.a(context).b();
        f.a(context).c();
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "0");
            jSONObject2.put("2", "0");
            String[] g6 = g(context);
            if (g6 == null || g6.length != 2) {
                jSONObject2.put("3", f10345d);
            } else {
                jSONObject2.put("3", g6[0]);
            }
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", str);
            jSONObject2.put("9", str2);
            jSONObject2.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, str3);
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(str4)) {
                try {
                    jSONObject3 = new JSONObject(str4);
                } catch (Exception unused) {
                    com.baidu.liantian.b.c();
                }
            }
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONObject3);
        } catch (Throwable unused2) {
            com.baidu.liantian.b.c();
        }
        return jSONObject;
    }

    public static void a(Context context, long j6) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, new Intent("com.b.r.p"), AMapEngineUtils.HALF_MAX_P20_WIDTH);
        try {
            alarmManager.cancel(broadcast);
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
        try {
            alarmManager.set(0, System.currentTimeMillis() + j6, broadcast);
        } catch (Throwable unused2) {
            com.baidu.liantian.b.c();
        }
    }

    public static String a(byte[] bArr) {
        String str = "";
        for (byte b6 : bArr) {
            String hexString = Integer.toHexString(b6 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }

    public static void a(Context context, Intent intent) {
        try {
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false) && f10348g.containsKey(schemeSpecificPart)) {
                f10348g.remove(schemeSpecificPart);
                new U(context, 4, false).start();
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }
}
