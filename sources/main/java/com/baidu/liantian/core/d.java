package com.baidu.liantian.core;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.liantian.LiantianReceiver;
import com.baidu.liantian.ac.Callback;
import com.baidu.liantian.ac.U;
import com.baidu.liantian.rp.Report;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.kuaishou.weapon.p0.t;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static Context f10403b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f10404c;

    /* renamed from: e, reason: collision with root package name */
    public static List<Integer> f10405e = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private static d f10406g;

    /* renamed from: h, reason: collision with root package name */
    private static int f10407h;

    /* renamed from: a, reason: collision with root package name */
    public com.baidu.liantian.e f10408a;

    /* renamed from: d, reason: collision with root package name */
    com.baidu.liantian.a.a f10409d;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f10410f = false;

    public static d a() {
        return f10406g;
    }

    public final void b() {
        boolean z5;
        try {
            List<ApkInfo> a6 = this.f10409d.a();
            Objects.toString(a6);
            com.baidu.liantian.b.a();
            final List<Integer> q5 = this.f10408a.q();
            List<Integer> p5 = this.f10408a.p();
            for (int i6 = 0; i6 < p5.size(); i6++) {
                if (!q5.contains(p5.get(i6))) {
                    q5.add(p5.get(i6));
                }
            }
            Collections.sort(a6, new Comparator<ApkInfo>() { // from class: com.baidu.liantian.core.d.2
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ApkInfo apkInfo, ApkInfo apkInfo2) {
                    int i7;
                    ApkInfo apkInfo3 = apkInfo;
                    ApkInfo apkInfo4 = apkInfo2;
                    int i8 = apkInfo3.priority;
                    if (i8 == -1 && apkInfo4.priority != -1) {
                        return 1;
                    }
                    if ((i8 != -1 && apkInfo4.priority == -1) || i8 < (i7 = apkInfo4.priority)) {
                        return -1;
                    }
                    if (i8 > i7) {
                        return 1;
                    }
                    List list = q5;
                    int indexOf = (list == null || !list.contains(Integer.valueOf(apkInfo3.key))) ? -1 : q5.indexOf(Integer.valueOf(apkInfo3.key));
                    List list2 = q5;
                    int indexOf2 = (list2 == null || !list2.contains(Integer.valueOf(apkInfo4.key))) ? -1 : q5.indexOf(Integer.valueOf(apkInfo4.key));
                    if (indexOf != -1 && indexOf2 == -1) {
                        return -1;
                    }
                    if ((indexOf != -1 || indexOf2 == -1) && indexOf <= indexOf2) {
                        return indexOf < indexOf2 ? -1 : 0;
                    }
                    return 1;
                }
            });
            for (ApkInfo apkInfo : a6) {
                g a7 = g.a();
                if ((a7 != null ? a7.d(apkInfo.packageName) : null) == null) {
                    if (this.f10409d.g(apkInfo.key) == 3) {
                        com.baidu.liantian.b.a();
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (this.f10408a.d() && z5) {
                        File file = new File(f10403b.getFilesDir(), ".b_liantian");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(apkInfo.pkgPath);
                        File file3 = new File(file, apkInfo.key + "-" + apkInfo.versionName);
                        if (!com.baidu.liantian.b.e.a(file3)) {
                            com.baidu.liantian.b.e.a(file2, file3);
                        }
                        com.baidu.liantian.c.a(f10403b, apkInfo.key, file2, file3);
                    } else {
                        File file4 = new File(f10403b.getFilesDir(), ".b_liantian");
                        if (file4.exists()) {
                            File file5 = new File(file4, apkInfo.key + "-" + apkInfo.versionName);
                            if (com.baidu.liantian.b.e.a(file5)) {
                                com.baidu.liantian.c.a(file5);
                                file5.delete();
                                file5.getAbsolutePath();
                                com.baidu.liantian.b.a();
                            }
                        }
                    }
                    a(apkInfo.key, apkInfo.versionName, null);
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public final boolean c() {
        this.f10409d.d();
        this.f10410f = true;
        return c(f10403b);
    }

    private d(Context context) {
        com.baidu.liantian.b.a();
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        f10403b = origApplicationContext;
        this.f10409d = com.baidu.liantian.a.a.a(origApplicationContext);
        this.f10408a = new com.baidu.liantian.e(f10403b);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            try {
                if (f10406g == null) {
                    f10406g = new d(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
                dVar = f10406g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    private boolean c(Context context) {
        try {
            g a6 = g.a(context);
            if (a6 == null) {
                return false;
            }
            if (a6.d("com.baidu.liantian.x18") != null) {
                return true;
            }
            if (this.f10409d == null) {
                this.f10409d = com.baidu.liantian.a.a.a(f10403b);
            }
            ApkInfo c6 = this.f10409d.c("com.baidu.liantian.x18");
            Objects.toString(c6);
            com.baidu.liantian.b.a();
            if (c6 != null) {
                if (this.f10408a.d()) {
                    File file = new File(f10403b.getFilesDir(), ".b_liantian");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(c6.pkgPath);
                    File file3 = new File(file, c6.key + "-" + c6.versionName);
                    if (!com.baidu.liantian.b.e.a(file3)) {
                        com.baidu.liantian.b.e.a(file2, file3);
                    }
                    com.baidu.liantian.c.a(f10403b, c6.key, file2, file3);
                }
                if (a(c6.key, c6.versionName, null)) {
                    return true;
                }
            }
            return a6.d("com.baidu.liantian.x18") != null;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return false;
        }
    }

    public final synchronized void a(final Callback callback) {
        String str;
        try {
            com.baidu.liantian.b.e.d(f10403b);
            com.baidu.liantian.b.a();
            if (this.f10410f) {
                if (callback != null) {
                    callback.onEnd(new Object[0]);
                }
                return;
            }
            this.f10410f = true;
            com.baidu.liantian.e eVar = this.f10408a;
            eVar.f10459c.putString("ssv", "3.1.6.7");
            eVar.f10459c.commit();
            Report.getInstance(f10403b).n();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme(WiseOpenHianalyticsData.UNION_PACKAGE);
            f10403b.registerReceiver(new LiantianReceiver(), intentFilter);
            com.baidu.liantian.b.b.a(f10403b);
            for (ApkInfo apkInfo : this.f10409d.a()) {
                try {
                    str = f10403b.getFilesDir().getCanonicalPath();
                } catch (IOException unused) {
                    com.baidu.liantian.b.e.a();
                    str = null;
                }
                if (str != null) {
                    apkInfo.dataDir = str + "/.liantian_" + apkInfo.key;
                    StringBuilder sb = new StringBuilder();
                    sb.append(apkInfo.dataDir);
                    sb.append("/lib");
                    com.baidu.liantian.b.e.d(sb.toString());
                }
            }
            new Thread() { // from class: com.baidu.liantian.core.d.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    try {
                        super.run();
                        d.this.f10409d.d();
                        com.baidu.liantian.b.a();
                        d.this.f10408a.a();
                        com.baidu.liantian.b.a();
                        if (!d.this.f10408a.a()) {
                            com.baidu.liantian.e eVar2 = d.this.f10408a;
                            eVar2.f10459c.putBoolean("iio", true);
                            eVar2.f10459c.commit();
                        } else {
                            com.baidu.liantian.a.a aVar = d.this.f10409d;
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("n", (Integer) 0);
                            try {
                                aVar.f10334c.update("tbchliantian", contentValues, "n=-1", null);
                            } catch (Throwable unused2) {
                                com.baidu.liantian.b.e.a();
                            }
                        }
                        new U(d.f10403b, 1, false).start();
                        Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.onEnd(new Object[0]);
                        }
                    } catch (Throwable unused3) {
                        com.baidu.liantian.b.e.a();
                    }
                }
            }.start();
        } catch (Throwable unused2) {
            com.baidu.liantian.b.e.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a0, code lost:
    
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r9, java.lang.String r10, java.lang.String r11, android.content.pm.PackageInfo r12) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.core.d.a(int, java.lang.String, java.lang.String, android.content.pm.PackageInfo):void");
    }

    public final void b(Context context) {
        int i6;
        String str;
        PackageInfo packageInfo;
        ApkInfo apkInfo;
        String str2 = "n";
        try {
            if (this.f10408a.f10457a.getBoolean("lpcf", false)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(com.baidu.liantian.b.e.a(context, "liantian_local.cfg", "local"));
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i7);
                String optString = optJSONObject.optString("pkgname");
                String optString2 = optJSONObject.optString("version");
                int optInt = optJSONObject.optInt("id");
                if (optInt > 0) {
                    arrayList.add(Integer.valueOf(optInt));
                }
                String optString3 = optJSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && optInt > 0) {
                    String lowerCase = optString3.toLowerCase();
                    ApkInfo apkInfo2 = new ApkInfo();
                    apkInfo2.packageName = optString;
                    apkInfo2.versionName = optString2;
                    apkInfo2.key = optInt;
                    apkInfo2.apkMD5 = lowerCase;
                    hashMap.put(Integer.valueOf(optInt), apkInfo2);
                }
            }
            this.f10408a.a(arrayList);
            if (hashMap.size() <= 0) {
                this.f10408a.s();
                return;
            }
            String str3 = com.baidu.liantian.b.e.b() + "p/1/pio";
            JSONArray jSONArray2 = new JSONArray();
            for (ApkInfo apkInfo3 : hashMap.values()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.umeng.analytics.pro.d.S, apkInfo3.packageName);
                jSONObject.put(t.f36152m, apkInfo3.apkMD5);
                jSONObject.put(t.f36143d, apkInfo3.key);
                jSONObject.put("v", apkInfo3.versionName);
                jSONArray2.put(jSONObject);
            }
            String jSONArray3 = jSONArray2.toString();
            com.baidu.liantian.b.a();
            String a6 = com.baidu.liantian.b.h.a(context, str3, jSONArray3);
            com.baidu.liantian.b.a();
            JSONArray jSONArray4 = new JSONArray(a6);
            if (jSONArray4.length() > 0) {
                this.f10408a.s();
            }
            int i8 = 0;
            while (i8 < jSONArray4.length()) {
                JSONObject optJSONObject2 = jSONArray4.optJSONObject(i8);
                int optInt2 = optJSONObject2.optInt("errno");
                int optInt3 = optJSONObject2.optInt(t.f36143d);
                if (optInt2 == 1) {
                    try {
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("detail");
                        packageInfo = new PackageInfo();
                        packageInfo.packageName = optJSONObject3.optString("p");
                        packageInfo.versionName = optJSONObject3.optString("v");
                        ApplicationInfo applicationInfo = new ApplicationInfo();
                        String optString4 = optJSONObject3.optString(str2);
                        applicationInfo.className = optString4;
                        if (!TextUtils.isEmpty(optString4) && applicationInfo.className.startsWith(".")) {
                            applicationInfo.className = packageInfo.packageName + applicationInfo.className;
                        }
                        applicationInfo.theme = optJSONObject3.optInt(bi.aL);
                        packageInfo.applicationInfo = applicationInfo;
                        JSONArray optJSONArray = optJSONObject3.optJSONArray("a");
                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                            i6 = i8;
                            str = str2;
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            int i9 = 0;
                            while (i9 < optJSONArray.length()) {
                                try {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i9);
                                    if (jSONObject2 != null) {
                                        ActivityInfo activityInfo = new ActivityInfo();
                                        i6 = i8;
                                        try {
                                            String optString5 = jSONObject2.optString(str2);
                                            activityInfo.name = optString5;
                                            if (TextUtils.isEmpty(optString5) || !activityInfo.name.startsWith(".")) {
                                                str = str2;
                                            } else {
                                                StringBuilder sb = new StringBuilder();
                                                str = str2;
                                                try {
                                                    sb.append(packageInfo.packageName);
                                                    sb.append(activityInfo.name);
                                                    activityInfo.name = sb.toString();
                                                } catch (Throwable unused) {
                                                    try {
                                                        com.baidu.liantian.b.e.a();
                                                        i9++;
                                                        i8 = i6;
                                                        str2 = str;
                                                    } catch (Throwable unused2) {
                                                        com.baidu.liantian.b.e.a();
                                                        packageInfo = null;
                                                        apkInfo = (ApkInfo) hashMap.get(Integer.valueOf(optInt3));
                                                        if (apkInfo != null) {
                                                            a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, packageInfo);
                                                        }
                                                        i8 = i6 + 1;
                                                        str2 = str;
                                                    }
                                                }
                                            }
                                            activityInfo.packageName = packageInfo.packageName;
                                            activityInfo.theme = jSONObject2.optInt(bi.aL);
                                            activityInfo.labelRes = jSONObject2.optInt(t.f36143d);
                                            if (!TextUtils.isEmpty(activityInfo.name)) {
                                                arrayList2.add(activityInfo);
                                            }
                                        } catch (Throwable unused3) {
                                            str = str2;
                                            com.baidu.liantian.b.e.a();
                                            i9++;
                                            i8 = i6;
                                            str2 = str;
                                        }
                                    } else {
                                        i6 = i8;
                                        str = str2;
                                    }
                                } catch (Throwable unused4) {
                                    i6 = i8;
                                }
                                i9++;
                                i8 = i6;
                                str2 = str;
                            }
                            i6 = i8;
                            str = str2;
                            if (arrayList2.size() > 0) {
                                packageInfo.activities = (ActivityInfo[]) arrayList2.toArray(new ActivityInfo[arrayList2.size()]);
                            }
                        }
                    } catch (Throwable unused5) {
                        i6 = i8;
                        str = str2;
                    }
                    apkInfo = (ApkInfo) hashMap.get(Integer.valueOf(optInt3));
                    if (apkInfo != null && packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName)) {
                        a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, packageInfo);
                    }
                } else {
                    i6 = i8;
                    str = str2;
                }
                i8 = i6 + 1;
                str2 = str;
            }
        } catch (Throwable unused6) {
            com.baidu.liantian.b.e.a();
        }
    }

    public final synchronized boolean a(int i6, String str, PackageInfo packageInfo) {
        return a(i6, str, false, packageInfo);
    }

    private synchronized boolean a(int i6, String str, boolean z5, PackageInfo packageInfo) {
        String str2;
        String str3;
        try {
            com.baidu.liantian.b.a();
            if (z5 && this.f10409d.c(i6) != 1) {
                return false;
            }
            ApkInfo a6 = this.f10409d.a(i6);
            if (a6 == null) {
                com.baidu.liantian.b.a();
                HashMap hashMap = new HashMap();
                hashMap.put("0", 1);
                hashMap.put("1", String.valueOf(i6));
                hashMap.put("2", str);
                if (!z5) {
                    com.baidu.liantian.b.e.a(f10403b, "1003105", hashMap);
                }
                return false;
            }
            File file = new File(a6.pkgPath);
            file.getAbsolutePath();
            com.baidu.liantian.b.a();
            if (!com.baidu.liantian.b.e.a(file)) {
                com.baidu.liantian.b.a();
                this.f10409d.f(i6);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("0", 3);
                hashMap2.put("1", String.valueOf(i6));
                hashMap2.put("2", str);
                if (!z5) {
                    com.baidu.liantian.b.e.a(f10403b, "1003105", hashMap2);
                }
                return false;
            }
            if (packageInfo != null) {
                a6.cloudPkgInfo = packageInfo;
            }
            g a7 = g.a(StubApp.getOrigApplicationContext(f10403b.getApplicationContext()));
            com.baidu.liantian.b.a();
            if (!a7.a(a6, false)) {
                this.f10409d.f(i6);
                a7.a(a6.pkgPath);
                HashMap hashMap3 = new HashMap();
                hashMap3.put("0", 4);
                hashMap3.put("1", String.valueOf(i6));
                hashMap3.put("2", str);
                if (!z5) {
                    com.baidu.liantian.b.e.a(f10403b, "1003105", hashMap3);
                }
                com.baidu.liantian.b.a();
                return false;
            }
            com.baidu.liantian.b.a();
            try {
                String[] g6 = com.baidu.liantian.b.e.g(f10403b);
                if (g6 != null && g6.length == 2 && !TextUtils.isEmpty(g6[0]) && !TextUtils.isEmpty(g6[1])) {
                    str2 = g6[0];
                    str3 = g6[1];
                } else {
                    str2 = com.baidu.liantian.b.e.f10345d;
                    str3 = com.baidu.liantian.b.e.f10346e;
                }
                com.baidu.liantian.b.a();
                a6 = a7.c(a6.pkgPath);
                f fVar = (f) a6.classLoader;
                Class<?> a8 = fVar.a("com.baidu.liantian.engine.EngineImpl");
                if (a8 == null) {
                    com.baidu.liantian.b.a();
                    Class<?> a9 = fVar.a("java.lang.String");
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("0", 9);
                    hashMap4.put("1", String.valueOf(i6));
                    hashMap4.put("2", str);
                    hashMap4.put("3", Base64.encodeToString(("classloader=" + fVar + ",StringClass=" + a9).getBytes(), 0).replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\t", "").replace("\r", ""));
                    if (!z5) {
                        com.baidu.liantian.b.e.a(f10403b, "1003105", hashMap4);
                    }
                    this.f10409d.f(i6);
                    return false;
                }
                Object invoke = a8.getDeclaredMethod("getInstance", Context.class).invoke(a8, f10403b);
                Objects.toString(invoke);
                com.baidu.liantian.b.a();
                try {
                    com.baidu.liantian.b.e.a(invoke, "setSecurityVerifyInfo", (Class<?>[]) new Class[]{String.class, String.class}, str2, str3);
                } catch (Throwable unused) {
                    com.baidu.liantian.b.e.a();
                }
                if (!((Boolean) com.baidu.liantian.b.e.a(invoke, "init", (Class<?>[]) new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.valueOf(this.f10408a.o()))).booleanValue()) {
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("0", 6);
                    hashMap5.put("1", String.valueOf(i6));
                    hashMap5.put("2", str);
                    if (!z5) {
                        com.baidu.liantian.b.e.a(f10403b, "1003105", hashMap5);
                    }
                    this.f10409d.f(i6);
                    a7.a(a6.pkgPath);
                    com.baidu.liantian.b.a();
                    return false;
                }
                a6.initStatus = 1;
                a6.apkParseSuc = 1;
                this.f10409d.a(a6);
                com.baidu.liantian.b.a();
                int g7 = this.f10409d.g(a6.key);
                com.baidu.liantian.b.a();
                if (g7 < 3 && g7 != -1) {
                    this.f10409d.b(a6.key, g7 + 1);
                }
                HashMap hashMap6 = new HashMap();
                hashMap6.put("0", 0);
                hashMap6.put("1", Integer.valueOf(i6));
                hashMap6.put("2", str);
                if (!z5) {
                    com.baidu.liantian.b.e.a(f10403b, "1003105", hashMap6);
                }
                com.baidu.liantian.b.e.c(f10403b);
                return true;
            } catch (Throwable th) {
                try {
                    com.baidu.liantian.b.b();
                    this.f10409d.f(i6);
                    String a10 = com.baidu.liantian.b.i.a(f10403b, com.baidu.liantian.b.a(th), a6.packageName);
                    a7.a(a6.pkgPath);
                    HashMap hashMap7 = new HashMap();
                    hashMap7.put("0", 7);
                    hashMap7.put("1", String.valueOf(i6));
                    hashMap7.put("2", str);
                    hashMap7.put("3", Base64.encodeToString(a10.getBytes(), 0).replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\t", "").replace("\r", ""));
                    if (!z5) {
                        com.baidu.liantian.b.e.a(f10403b, "1003105", hashMap7);
                    }
                } catch (Throwable unused2) {
                    com.baidu.liantian.b.e.a();
                }
                return false;
            }
        } catch (Throwable unused3) {
            com.baidu.liantian.b.e.a();
            return false;
        }
    }

    private static void b(String str) {
        g a6;
        ApkInfo d6;
        com.baidu.liantian.b.a();
        try {
            if (!TextUtils.isEmpty(str) && (a6 = g.a()) != null && (d6 = a6.d(str)) != null) {
                Class<?> a7 = ((f) d6.classLoader).a("com.baidu.liantian.engine.EngineImpl");
                Object invoke = a7.getDeclaredMethod("getInstance", Context.class).invoke(a7, f10403b);
                if (invoke == null) {
                    return;
                }
                Objects.toString(com.baidu.liantian.b.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                com.baidu.liantian.b.a();
                a6.b(str);
            }
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.liantian.b.b();
        }
    }

    public final boolean a(ApkInfo apkInfo, String str) {
        File file;
        String str2;
        String str3;
        ApkInfo apkInfo2 = apkInfo;
        Objects.toString(apkInfo2);
        com.baidu.liantian.b.a();
        if (apkInfo2 == null) {
            return false;
        }
        File file2 = new File(apkInfo2.pkgPath);
        try {
        } catch (Throwable th) {
            th = th;
            file = file2;
        }
        try {
            if (!com.baidu.liantian.b.e.a(file2)) {
                com.baidu.liantian.b.a();
                HashMap hashMap = new HashMap();
                hashMap.put("0", 1);
                StringBuilder sb = new StringBuilder();
                sb.append(apkInfo2.key);
                hashMap.put("1", sb.toString());
                hashMap.put("2", apkInfo2.versionName);
                StringBuilder sb2 = new StringBuilder("nowTime:");
                sb2.append(System.currentTimeMillis());
                sb2.append(", nowFileInfo: path=");
                sb2.append(file2.getAbsolutePath());
                sb2.append(", exists=");
                sb2.append(file2.exists());
                sb2.append(", canRead=");
                sb2.append(file2.canRead());
                sb2.append(", isFile=");
                sb2.append(file2.isFile());
                sb2.append(",length");
                sb2.append(file2.length());
                sb2.append(" - ");
                sb2.append(str);
                hashMap.put("3", Base64.encodeToString(sb2.toString().getBytes(), 0).replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\t", "").replace("\r", ""));
                com.baidu.liantian.b.e.a(f10403b, "1003106", hashMap);
                return false;
            }
            file = file2;
            if (!this.f10409d.b(apkInfo2.key)) {
                this.f10409d.a(apkInfo2);
            }
            g a6 = g.a(StubApp.getOrigApplicationContext(f10403b.getApplicationContext()));
            this.f10409d.a(apkInfo2.key, 1);
            b(apkInfo2.packageName);
            if (!a6.a(apkInfo2, true)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("0", 2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(apkInfo2.key);
                hashMap2.put("1", sb3.toString());
                hashMap2.put("2", apkInfo2.versionName);
                com.baidu.liantian.b.e.a(f10403b, "1003106", hashMap2);
                com.baidu.liantian.b.a();
                com.baidu.liantian.c.a(file);
                file.delete();
                a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                this.f10409d.a(apkInfo2.key, 0);
                return false;
            }
            String[] g6 = com.baidu.liantian.b.e.g(f10403b);
            if (g6 != null && g6.length == 2 && !TextUtils.isEmpty(g6[0]) && !TextUtils.isEmpty(g6[1])) {
                str2 = g6[0];
                str3 = g6[1];
            } else {
                str2 = com.baidu.liantian.b.e.f10345d;
                str3 = com.baidu.liantian.b.e.f10346e;
            }
            apkInfo2 = a6.c(apkInfo2.pkgPath);
            if (apkInfo2 == null) {
                return false;
            }
            f fVar = (f) apkInfo2.classLoader;
            Class<?> a7 = fVar.a("com.baidu.liantian.engine.EngineImpl");
            if (a7 == null) {
                com.baidu.liantian.b.a();
                Class<?> a8 = fVar.a("java.lang.String");
                HashMap hashMap3 = new HashMap();
                hashMap3.put("0", 6);
                StringBuilder sb4 = new StringBuilder();
                sb4.append(apkInfo2.key);
                hashMap3.put("1", sb4.toString());
                hashMap3.put("2", apkInfo2.versionName);
                hashMap3.put("3", Base64.encodeToString(("classloader=" + fVar + ",StringClass=" + a8).getBytes(), 0).replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\t", "").replace("\r", ""));
                com.baidu.liantian.b.e.a(f10403b, "1003106", hashMap3);
                com.baidu.liantian.c.a(file);
                file.delete();
                this.f10409d.a(apkInfo2.key, 0);
                return false;
            }
            String str4 = str3;
            Object invoke = a7.getDeclaredMethod("getInstance", Context.class).invoke(a7, f10403b);
            try {
                com.baidu.liantian.b.e.a(invoke, "setSecurityVerifyInfo", (Class<?>[]) new Class[]{String.class, String.class}, str2, str4);
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
            if (!((Boolean) com.baidu.liantian.b.e.a(invoke, "init", (Class<?>[]) new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.valueOf(this.f10408a.o()))).booleanValue()) {
                com.baidu.liantian.b.a();
                com.baidu.liantian.c.a(file);
                b(apkInfo2.packageName);
                file.delete();
                a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                this.f10409d.a(apkInfo2.key, 0);
                HashMap hashMap4 = new HashMap();
                hashMap4.put("0", 4);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(apkInfo2.key);
                hashMap4.put("1", sb5.toString());
                hashMap4.put("2", apkInfo2.versionName);
                com.baidu.liantian.b.e.a(f10403b, "1003106", hashMap4);
                return false;
            }
            if (apkInfo2.isMem) {
                com.baidu.liantian.c.a(file);
                file.delete();
                com.baidu.liantian.b.e.d(apkInfo2.dataDir);
                List<Integer> list = g.f10438b;
                if (list != null) {
                    list.add(Integer.valueOf(apkInfo2.key));
                }
            }
            com.baidu.liantian.b.a();
            try {
                ApkInfo a9 = this.f10409d.a(apkInfo2.key);
                Objects.toString(a9);
                com.baidu.liantian.b.a();
                File file3 = (a9 == null || a9.versionName.equals(apkInfo2.versionName)) ? null : new File(a9.pkgPath);
                apkInfo2.initStatus = 1;
                apkInfo2.apkParseSuc = 1;
                if (this.f10409d.a(apkInfo2) > 0 && file3 != null && file3.exists()) {
                    com.baidu.liantian.c.a(file3);
                    file3.delete();
                    com.baidu.liantian.b.a();
                }
                this.f10409d.a(apkInfo2.key, 0);
                com.baidu.liantian.b.a();
                com.baidu.liantian.b.e.c(f10403b);
                HashMap hashMap5 = new HashMap();
                hashMap5.put("0", 0);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(apkInfo2.key);
                hashMap5.put("1", sb6.toString());
                hashMap5.put("2", apkInfo2.versionName);
                com.baidu.liantian.b.e.a(f10403b, "1003106", hashMap5);
                return true;
            } catch (Throwable unused2) {
                com.baidu.liantian.b.e.a();
                return true;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                th.getMessage();
                com.baidu.liantian.b.a();
                com.baidu.liantian.c.a(file);
                b(apkInfo2.packageName);
                file.delete();
                a(apkInfo2.key, apkInfo2.versionName, true, (PackageInfo) null);
                this.f10409d.a(apkInfo2.key, 0);
                HashMap hashMap6 = new HashMap();
                hashMap6.put("0", 5);
                StringBuilder sb7 = new StringBuilder();
                sb7.append(apkInfo2.key);
                hashMap6.put("1", sb7.toString());
                hashMap6.put("2", apkInfo2.versionName);
                hashMap6.put("3", Base64.encodeToString(com.baidu.liantian.b.a(th).getBytes(), 0).replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\t", "").replace("\r", ""));
                com.baidu.liantian.b.e.a(f10403b, "1003106", hashMap6);
                return false;
            } catch (Throwable unused3) {
                com.baidu.liantian.b.e.a();
                return false;
            }
        }
    }

    public final void a(final int i6, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            com.baidu.liantian.b.a();
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.toString(i6));
            hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
            hashMap.put("2", "0");
            com.baidu.liantian.b.e.a(f10403b, "1003136", hashMap);
            if (!TextUtils.isEmpty(str)) {
                new Thread() { // from class: com.baidu.liantian.core.d.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        boolean z5;
                        super.run();
                        try {
                            Callback callback2 = callback;
                            if (callback2 != null) {
                                callback2.onBegin(new Object[0]);
                            }
                            boolean d6 = d.this.f10409d.d(i6);
                            com.baidu.liantian.b.a();
                            if (d6) {
                                long currentTimeMillis = System.currentTimeMillis();
                                while (d.this.f10409d.d(i6) && System.currentTimeMillis() - currentTimeMillis < 10000) {
                                    com.baidu.liantian.b.a();
                                    SystemClock.sleep(300L);
                                }
                            }
                            com.baidu.liantian.b.a();
                            if (d.this.f10409d.d(i6)) {
                                Callback callback3 = callback;
                                if (callback3 != null) {
                                    callback3.onError(3);
                                    return;
                                }
                                return;
                            }
                            ApkInfo apkInfo = null;
                            if (!d.this.f10410f) {
                                d.a(3);
                                d.this.a((Callback) null);
                            }
                            g a6 = g.a(StubApp.getOrigApplicationContext(d.f10403b.getApplicationContext()));
                            long currentTimeMillis2 = System.currentTimeMillis();
                            while (System.currentTimeMillis() - currentTimeMillis2 <= 120000) {
                                com.baidu.liantian.b.a();
                                apkInfo = d.this.f10409d.a(i6);
                                if (apkInfo != null) {
                                    if (a6.d(apkInfo.packageName) == null) {
                                        if (apkInfo.initStatus == -1) {
                                            break;
                                        }
                                    } else {
                                        z5 = true;
                                        break;
                                    }
                                }
                                SystemClock.sleep(1000L);
                            }
                            z5 = false;
                            if (!z5) {
                                Callback callback4 = callback;
                                if (callback4 != null) {
                                    callback4.onError(4);
                                    return;
                                }
                                return;
                            }
                            Class<?> a7 = ((f) a6.d(apkInfo.packageName).classLoader).a("com.baidu.liantian.engine.EngineImpl");
                            Object a8 = com.baidu.liantian.b.e.a(a7.getDeclaredMethod("getInstance", Context.class).invoke(a7, d.f10403b), str, (Class<?>[]) clsArr, objArr);
                            try {
                                Objects.toString(a8);
                                com.baidu.liantian.b.a();
                            } catch (Throwable unused) {
                                com.baidu.liantian.b.e.a();
                            }
                            Callback callback5 = callback;
                            if (callback5 != null) {
                                callback5.onEnd(a8);
                            }
                        } catch (IllegalAccessException e6) {
                            e6.getMessage();
                            com.baidu.liantian.b.b();
                            Callback callback6 = callback;
                            if (callback6 != null) {
                                callback6.onError(2);
                            }
                        } catch (IllegalArgumentException e7) {
                            e7.getMessage();
                            com.baidu.liantian.b.b();
                            Callback callback7 = callback;
                            if (callback7 != null) {
                                callback7.onError(2);
                            }
                        } catch (NoSuchMethodException e8) {
                            e8.getMessage();
                            com.baidu.liantian.b.b();
                            Callback callback8 = callback;
                            if (callback8 != null) {
                                callback8.onError(2);
                            }
                        } catch (InvocationTargetException e9) {
                            e9.getMessage();
                            com.baidu.liantian.b.b();
                            Callback callback9 = callback;
                            if (callback9 != null) {
                                callback9.onError(2);
                            }
                        } catch (Throwable th) {
                            th.getMessage();
                            com.baidu.liantian.b.b();
                            Callback callback10 = callback;
                            if (callback10 != null) {
                                callback10.onError(3);
                            }
                        }
                    }
                }.start();
            } else if (callback != null) {
                callback.onError(1);
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public final Pair<Integer, Object> a(int i6, String str, Class<?>[] clsArr, Object... objArr) {
        com.baidu.liantian.b.a();
        HashMap hashMap = new HashMap();
        hashMap.put("0", Integer.toString(i6));
        hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
        hashMap.put("2", "1");
        com.baidu.liantian.b.e.a(f10403b, "1003136", hashMap);
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(1, null);
        }
        try {
            boolean d6 = this.f10409d.d(i6);
            com.baidu.liantian.b.a();
            if (d6) {
                return new Pair<>(3, null);
            }
            if (!this.f10410f) {
                return new Pair<>(3, null);
            }
            g a6 = g.a();
            if (a6 == null) {
                return new Pair<>(3, null);
            }
            ApkInfo a7 = this.f10409d.a(i6);
            if (a7 != null && a6.d(a7.packageName) != null) {
                Class<?> a8 = ((f) a6.d(a7.packageName).classLoader).a("com.baidu.liantian.engine.EngineImpl");
                Object a9 = com.baidu.liantian.b.e.a(a8.getDeclaredMethod("getInstance", Context.class).invoke(a8, f10403b), str, clsArr, objArr);
                try {
                    Objects.toString(a9);
                    com.baidu.liantian.b.a();
                } catch (Throwable unused) {
                    com.baidu.liantian.b.e.a();
                }
                return new Pair<>(0, a9);
            }
            return new Pair<>(4, null);
        } catch (IllegalAccessException e6) {
            e6.getMessage();
            com.baidu.liantian.b.b();
            return new Pair<>(2, null);
        } catch (IllegalArgumentException e7) {
            e7.getMessage();
            com.baidu.liantian.b.b();
            return new Pair<>(2, null);
        } catch (NoSuchMethodException e8) {
            e8.getMessage();
            com.baidu.liantian.b.b();
            return new Pair<>(2, null);
        } catch (InvocationTargetException e9) {
            e9.getMessage();
            com.baidu.liantian.b.b();
            return new Pair<>(2, null);
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.liantian.b.b();
            return new Pair<>(3, null);
        }
    }

    public final void a(final String str) {
        try {
            com.baidu.liantian.b.a();
            new Thread() { // from class: com.baidu.liantian.core.d.4
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    super.run();
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            final g a6 = g.a(StubApp.getOrigApplicationContext(d.f10403b.getApplicationContext()));
                            Objects.toString(a6);
                            com.baidu.liantian.b.a();
                            if (a6 != null) {
                                final ApkInfo d6 = a6.d(str);
                                Objects.toString(d6);
                                com.baidu.liantian.b.a();
                                if (d6 == null) {
                                    ApkInfo c6 = d.this.f10409d.c(str);
                                    d dVar = d.this;
                                    String str2 = str;
                                    String str3 = c6.pkgPath;
                                    try {
                                        dVar.f10409d.a(str2);
                                        File file = new File(str3);
                                        file.getAbsolutePath();
                                        file.exists();
                                        com.baidu.liantian.b.a();
                                        if (file.exists()) {
                                            com.baidu.liantian.c.a(file);
                                            file.delete();
                                            file.getAbsolutePath();
                                            com.baidu.liantian.b.a();
                                            return;
                                        }
                                        return;
                                    } catch (Throwable unused) {
                                        com.baidu.liantian.b.e.a();
                                        return;
                                    }
                                }
                                Class<?> a7 = ((f) d6.classLoader).a("com.baidu.liantian.engine.EngineImpl");
                                Object invoke = a7.getDeclaredMethod("getInstance", Context.class).invoke(a7, d.f10403b);
                                Objects.toString(invoke);
                                com.baidu.liantian.b.a();
                                if (invoke != null) {
                                    System.currentTimeMillis();
                                    com.baidu.liantian.b.a();
                                    new Timer().schedule(new TimerTask() { // from class: com.baidu.liantian.core.d.4.1
                                        @Override // java.util.TimerTask, java.lang.Runnable
                                        public final void run() {
                                            System.currentTimeMillis();
                                            com.baidu.liantian.b.a();
                                            a6.b(str);
                                            d.this.f10409d.a(str);
                                            com.baidu.liantian.b.e.c(d.f10403b);
                                            File file2 = new File(d6.pkgPath);
                                            file2.getAbsolutePath();
                                            file2.exists();
                                            com.baidu.liantian.b.a();
                                            if (file2.exists()) {
                                                com.baidu.liantian.c.a(file2);
                                                file2.delete();
                                                file2.getAbsolutePath();
                                                com.baidu.liantian.b.a();
                                            }
                                        }
                                    }, TTAdConstant.AD_MAX_EVENT_TIME);
                                    Objects.toString(com.baidu.liantian.b.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                                    com.baidu.liantian.b.a();
                                    a6.b(str);
                                    d.this.f10409d.a(str);
                                    com.baidu.liantian.b.e.c(d.f10403b);
                                    File file2 = new File(d6.pkgPath);
                                    file2.getAbsolutePath();
                                    file2.exists();
                                    com.baidu.liantian.b.a();
                                    if (file2.exists()) {
                                        com.baidu.liantian.c.a(file2);
                                        file2.delete();
                                        file2.getAbsolutePath();
                                        com.baidu.liantian.b.a();
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                        com.baidu.liantian.b.b();
                    }
                }
            }.start();
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public static void a(int i6) {
        if (f10407h == 0) {
            f10407h = i6;
        }
    }
}
