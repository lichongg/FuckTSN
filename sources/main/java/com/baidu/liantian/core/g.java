package com.baidu.liantian.core;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.liantian.LiantianReceiver;
import com.kuaishou.weapon.p0.t;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class g {

    /* renamed from: e, reason: collision with root package name */
    private static g f10439e;

    /* renamed from: f, reason: collision with root package name */
    private static Application f10440f;

    /* renamed from: c, reason: collision with root package name */
    private String f10443c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10444d;

    /* renamed from: g, reason: collision with root package name */
    private static Random f10441g = new Random();

    /* renamed from: b, reason: collision with root package name */
    public static List<Integer> f10438b = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private Map<String, ApkInfo> f10445h = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public Map<String, ApkInfo> f10442a = new ConcurrentHashMap();

    /* renamed from: i, reason: collision with root package name */
    private Map<String, LiantianReceiver> f10446i = new HashMap();

    public static g a(Context context) {
        if (f10439e == null) {
            f10440f = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext());
            f10439e = new g();
        }
        return f10439e;
    }

    public final synchronized void b(h hVar) {
        try {
            if (hVar.f10450d == null) {
                return;
            }
            ApkInfo apkInfo = this.f10442a.get(hVar.f10447a);
            if (apkInfo != null && apkInfo.intentFilters != null) {
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < apkInfo.intentFilters.size(); i6++) {
                    if (hVar.a(apkInfo.intentFilters.get(i6))) {
                        arrayList.add(Integer.valueOf(i6));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    List<h> list = apkInfo.intentFilters;
                    if (list != null) {
                        try {
                            list.remove(intValue);
                        } catch (Throwable unused) {
                            com.baidu.liantian.b.e.a();
                        }
                    }
                }
                List<h> list2 = apkInfo.intentFilters;
                if (list2 != null && list2.size() == 0) {
                    apkInfo.intentFilters = null;
                }
            }
            String a6 = a(hVar.f10450d);
            com.baidu.liantian.b.a();
            if (!TextUtils.isEmpty(a6) && !"android.intent.action.PACKAGE_REMOVED__package".equals(a6)) {
                for (ApkInfo apkInfo2 : b()) {
                    List<h> list3 = apkInfo2.intentFilters;
                    if (list3 != null && list3.size() > 0) {
                        Iterator<h> it2 = apkInfo2.intentFilters.iterator();
                        while (it2.hasNext()) {
                            String a7 = a(it2.next().f10450d);
                            if (!TextUtils.isEmpty(a7) && a7.equals(a6)) {
                                com.baidu.liantian.b.a();
                                return;
                            }
                        }
                    }
                }
                com.baidu.liantian.b.a();
                f10440f.unregisterReceiver(this.f10446i.get(a6));
                this.f10446i.remove(a6);
            }
        } catch (Throwable unused2) {
            com.baidu.liantian.b.e.a();
        }
    }

    private static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable th) {
            th.toString();
            return false;
        }
    }

    public final ApkInfo c(String str) {
        try {
            return this.f10445h.get(str);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return null;
        }
    }

    public final ApkInfo d(String str) {
        try {
            return this.f10442a.get(str);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return null;
        }
    }

    public static g a() {
        return f10439e;
    }

    public final synchronized void a(h hVar) {
        try {
            if (hVar.f10450d == null) {
                return;
            }
            ApkInfo apkInfo = this.f10442a.get(hVar.f10447a);
            if (apkInfo != null) {
                if (apkInfo.intentFilters == null) {
                    apkInfo.intentFilters = new ArrayList();
                }
                for (int i6 = 0; i6 < apkInfo.intentFilters.size(); i6++) {
                    if (hVar.a(apkInfo.intentFilters.get(i6))) {
                        return;
                    }
                }
                apkInfo.intentFilters.add(hVar);
                String a6 = a(hVar.f10450d);
                com.baidu.liantian.b.a();
                if (!TextUtils.isEmpty(a6) && !a6.equals("____")) {
                    if (!this.f10446i.keySet().contains(a6) && !"android.intent.action.PACKAGE_REMOVED__package".equals(a6)) {
                        LiantianReceiver liantianReceiver = new LiantianReceiver();
                        try {
                            f10440f.registerReceiver(liantianReceiver, hVar.f10450d);
                        } catch (Throwable unused) {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException unused2) {
                                com.baidu.liantian.b.e.a();
                            }
                            f10440f.registerReceiver(liantianReceiver, hVar.f10450d);
                        }
                        this.f10446i.put(a6, liantianReceiver);
                    }
                }
            }
        } catch (Throwable unused3) {
            com.baidu.liantian.b.e.a();
        }
    }

    private static String a(IntentFilter intentFilter) {
        if (intentFilter == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int countActions = intentFilter.countActions();
            if (countActions > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < countActions; i6++) {
                    try {
                        String action = intentFilter.getAction(i6);
                        if (!TextUtils.isEmpty(action)) {
                            arrayList.add(action);
                        }
                    } catch (Throwable unused) {
                        com.baidu.liantian.b.e.a();
                    }
                }
                if (arrayList.size() > 0) {
                    Collections.sort(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            int countCategories = intentFilter.countCategories();
            if (countCategories > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i7 = 0; i7 < countCategories; i7++) {
                    try {
                        String category = intentFilter.getCategory(i7);
                        if (!TextUtils.isEmpty(category)) {
                            arrayList2.add(category);
                        }
                    } catch (Throwable unused2) {
                        com.baidu.liantian.b.e.a();
                    }
                }
                if (arrayList2.size() > 0) {
                    Collections.sort(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        sb.append((String) it2.next());
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            if (intentFilter.countDataTypes() > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (int i8 = 0; i8 < countCategories; i8++) {
                    try {
                        String dataType = intentFilter.getDataType(i8);
                        if (!TextUtils.isEmpty(dataType)) {
                            arrayList3.add(dataType);
                        }
                    } catch (Throwable unused3) {
                        com.baidu.liantian.b.e.a();
                    }
                }
                if (arrayList3.size() > 0) {
                    Collections.sort(arrayList3);
                    Iterator it3 = arrayList3.iterator();
                    while (it3.hasNext()) {
                        sb.append((String) it3.next());
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            int countDataSchemes = intentFilter.countDataSchemes();
            if (countDataSchemes > 0) {
                ArrayList arrayList4 = new ArrayList();
                for (int i9 = 0; i9 < countDataSchemes; i9++) {
                    try {
                        String dataScheme = intentFilter.getDataScheme(i9);
                        if (!TextUtils.isEmpty(dataScheme)) {
                            arrayList4.add(dataScheme);
                        }
                    } catch (Throwable unused4) {
                        com.baidu.liantian.b.e.a();
                    }
                }
                if (arrayList4.size() > 0) {
                    Collections.sort(arrayList4);
                    Iterator it4 = arrayList4.iterator();
                    while (it4.hasNext()) {
                        sb.append((String) it4.next());
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            return sb.toString();
        } catch (Throwable unused5) {
            return "";
        }
    }

    public final List<ApkInfo> b() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = this.f10442a.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(this.f10442a.get(it.next()));
            }
            return arrayList;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            try {
                return new ArrayList();
            } catch (Throwable unused2) {
                com.baidu.liantian.b.e.a();
                return null;
            }
        }
    }

    public final boolean b(String str) {
        ApkInfo apkInfo = this.f10442a.get(str);
        if (apkInfo == null) {
            return false;
        }
        this.f10445h.remove(apkInfo.pkgPath);
        this.f10442a.remove(str);
        com.baidu.liantian.b.e.d(apkInfo.dataDir);
        Application application = f10440f;
        if (application != null) {
            com.baidu.liantian.b.e.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
        }
        this.f10445h.size();
        com.baidu.liantian.b.a();
        this.f10442a.size();
        com.baidu.liantian.b.a();
        return true;
    }

    public final boolean a(ApkInfo apkInfo, boolean z5) {
        System.currentTimeMillis();
        this.f10444d = z5;
        this.f10443c = apkInfo.versionName;
        boolean a6 = a(apkInfo);
        System.currentTimeMillis();
        com.baidu.liantian.b.a();
        return a6;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x020e A[Catch: all -> 0x0127, TRY_LEAVE, TryCatch #1 {all -> 0x0127, blocks: (B:25:0x0073, B:27:0x007b, B:36:0x011d, B:37:0x012b, B:42:0x0131, B:44:0x0138, B:46:0x0140, B:48:0x0148, B:49:0x0187, B:51:0x018f, B:53:0x0199, B:55:0x019d, B:57:0x01a1, B:59:0x01ab, B:62:0x01b2, B:64:0x01bd, B:65:0x01fc, B:67:0x020e, B:70:0x01c7, B:72:0x01d1, B:73:0x01db, B:75:0x01e1, B:76:0x01e9, B:77:0x01f3, B:78:0x0269, B:79:0x030c, B:80:0x0313, B:81:0x014c, B:83:0x015a, B:85:0x0162, B:87:0x016a, B:89:0x0177, B:91:0x017f, B:93:0x0314, B:94:0x031b, B:29:0x007e, B:31:0x0086, B:33:0x008e, B:34:0x0115, B:35:0x011c), top: B:24:0x0073, outer: #2, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean a(com.baidu.liantian.core.ApkInfo r8) {
        /*
            Method dump skipped, instructions count: 944
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.core.g.a(com.baidu.liantian.core.ApkInfo):boolean");
    }

    private static PackageInfo a(String str, String str2) {
        try {
            String str3 = com.baidu.liantian.b.e.b() + "p/1/pdl";
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.analytics.pro.d.S, str);
            jSONObject.put(t.f36152m, str2);
            jSONArray.put(jSONObject);
            String jSONArray2 = jSONArray.toString();
            com.baidu.liantian.b.a();
            String a6 = com.baidu.liantian.b.h.a(f10440f, str3, jSONArray2, false);
            com.baidu.liantian.b.a();
            JSONArray jSONArray3 = new JSONArray(a6);
            if (jSONArray3.length() <= 0) {
                return null;
            }
            JSONObject optJSONObject = jSONArray3.optJSONObject(0);
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.packageName = optJSONObject.optString("p");
            packageInfo.versionName = optJSONObject.optString("v");
            ApplicationInfo applicationInfo = new ApplicationInfo();
            String optString = optJSONObject.optString("n");
            applicationInfo.className = optString;
            if (!TextUtils.isEmpty(optString) && applicationInfo.className.startsWith(".")) {
                applicationInfo.className = packageInfo.packageName + applicationInfo.className;
            }
            applicationInfo.theme = optJSONObject.optInt(bi.aL);
            packageInfo.applicationInfo = applicationInfo;
            JSONArray optJSONArray = optJSONObject.optJSONArray("a");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    try {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i6);
                        if (jSONObject2 != null) {
                            ActivityInfo activityInfo = new ActivityInfo();
                            String optString2 = jSONObject2.optString("n");
                            activityInfo.name = optString2;
                            if (!TextUtils.isEmpty(optString2) && activityInfo.name.startsWith(".")) {
                                activityInfo.name = packageInfo.packageName + activityInfo.name;
                            }
                            activityInfo.packageName = packageInfo.packageName;
                            activityInfo.theme = jSONObject2.optInt(bi.aL);
                            activityInfo.labelRes = jSONObject2.optInt(t.f36143d);
                            if (!TextUtils.isEmpty(activityInfo.name)) {
                                arrayList.add(activityInfo);
                            }
                        }
                    } catch (Throwable unused) {
                        com.baidu.liantian.b.e.a();
                    }
                }
                if (arrayList.size() > 0) {
                    packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                }
            }
            return packageInfo;
        } catch (Throwable unused2) {
            com.baidu.liantian.b.e.a();
            return null;
        }
    }

    private static boolean a(ApkInfo apkInfo, String str) {
        try {
            com.baidu.liantian.b.a();
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Application application = (Application) apkInfo.classLoader.loadClass(str).newInstance();
            com.baidu.liantian.f.a((Class<?>) Application.class, f10440f, application);
            a(application, f10440f);
            application.onCreate();
            return true;
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.liantian.b.b();
            return false;
        }
    }

    private void a(ApkInfo apkInfo, String str, String str2) {
        HashSet hashSet = new HashSet();
        a(apkInfo, str, hashSet, new StringBuilder(), true, false);
        String str3 = ":" + System.getProperty("java.library.path");
        String str4 = "";
        if (Build.VERSION.SDK_INT >= 25) {
            str3 = "";
        }
        String str5 = Build.CPU_ABI;
        if (hashSet.contains(str5)) {
            String str6 = str + "/" + str5;
            String str7 = null;
            try {
                String str8 = Build.CPU_ABI2;
                if (hashSet.contains(str8)) {
                    str7 = str + "/" + str8;
                }
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
            if (str7 != null) {
                str4 = str6 + ":" + str7 + str3;
            } else {
                str4 = str6 + str3;
            }
        } else {
            try {
                String str9 = Build.CPU_ABI2;
                if (hashSet.contains(str9)) {
                    str4 = str + "/" + str9 + str3;
                }
            } catch (Throwable unused2) {
                com.baidu.liantian.b.e.a();
            }
        }
        if (TextUtils.isEmpty(str4) && (("armeabi-v7a".equals(Build.CPU_ABI) && hashSet.contains("armeabi")) || ("armeabi-v7a".equals(Build.CPU_ABI2) && hashSet.contains("armeabi")))) {
            str4 = str + "/armeabi" + str3;
        }
        apkInfo.libPath = str4;
        PathClassLoader pathClassLoader = new PathClassLoader(apkInfo.hostContext.getPackageResourcePath(), g.class.getClassLoader());
        com.baidu.liantian.b.a();
        try {
            String absolutePath = new File(str2, "apkDex").getAbsolutePath();
            com.baidu.liantian.b.e.d(absolutePath);
            e(absolutePath);
            f fVar = new f(apkInfo.pkgPath, absolutePath, str4, pathClassLoader);
            apkInfo.classLoader = fVar;
            Class<?> loadClass = fVar.loadClass("com.baidu.liantian.engine.EngineImpl");
            Objects.toString(loadClass);
            com.baidu.liantian.b.a();
            if (loadClass == null || TextUtils.isEmpty(loadClass.getName())) {
                throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
            }
        } finally {
            com.baidu.liantian.b.a();
        }
    }

    public final boolean a(String str) {
        ApkInfo apkInfo = this.f10445h.get(str);
        if (apkInfo == null) {
            return false;
        }
        this.f10445h.remove(str);
        this.f10442a.remove(apkInfo.packageName);
        com.baidu.liantian.b.e.d(apkInfo.dataDir);
        Application application = f10440f;
        if (application == null) {
            return true;
        }
        com.baidu.liantian.b.e.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
        return true;
    }

    private static void a(Application application, Context context) {
        Class<?> cls = context.getClass();
        for (Class<Application> cls2 = Application.class; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField("mBase");
                declaredField.setAccessible(true);
                if (declaredField.getType().isAssignableFrom(cls)) {
                    declaredField.set(application, context);
                }
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:15|(1:177)(17:20|21|22|23|(1:174)(5:25|(2:27|(1:29))(1:173)|30|(1:42)(2:32|(2:34|(1:38)))|40)|43|44|45|46|47|48|49|50|51|(3:53|54|(1:56)(1:57))|58|59)|60|61|(1:141)(14:66|67|68|69|70|(3:71|72|(4:74|75|76|78)(1:117))|118|119|120|121|122|123|124|125)|86|87|40|12|13) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:(6:(1:174)(5:25|(2:27|(1:29))(1:173)|30|(1:42)(2:32|(2:34|(1:38)))|40)|50|51|(3:53|54|(1:56)(1:57))|58|59)|45|46|47|48|49) */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x025a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x025b, code lost:
    
        r14 = r24;
        r8 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0271 A[Catch: all -> 0x00e8, EOFException -> 0x027b, ZipException -> 0x0285, TryCatch #3 {all -> 0x00e8, blocks: (B:13:0x00a4, B:15:0x00aa, B:17:0x00bc, B:20:0x00c4, B:23:0x00ce, B:25:0x00d7, B:27:0x00dd, B:30:0x0102, B:32:0x010a, B:34:0x0110, B:36:0x0116, B:43:0x0121, B:46:0x0128, B:49:0x016a, B:51:0x017c, B:84:0x0269, B:88:0x0271, B:90:0x0277, B:176:0x00c9), top: B:12:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0355  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.baidu.liantian.core.ApkInfo r21, java.lang.String r22, java.util.HashSet<java.lang.String> r23, java.lang.StringBuilder r24, boolean r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 915
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.core.g.a(com.baidu.liantian.core.ApkInfo, java.lang.String, java.util.HashSet, java.lang.StringBuilder, boolean, boolean):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:5|(1:91)(9:10|11|12|13|(1:87)(5:15|(1:20)|72|(1:86)(3:74|75|(2:77|(1:82))(1:85))|60)|21|(3:22|23|(1:25)(1:26))|27|28)|29|30|(8:35|36|37|(3:38|39|(1:41)(1:42))|43|(1:45)|46|47)|58|59|60) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x015f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0160, code lost:
    
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.baidu.liantian.core.ApkInfo r17, java.lang.String r18, java.lang.String r19, java.util.HashSet<java.lang.String> r20, byte[] r21, java.lang.StringBuilder r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.core.g.a(com.baidu.liantian.core.ApkInfo, java.lang.String, java.lang.String, java.util.HashSet, byte[], java.lang.StringBuilder, boolean, boolean):void");
    }
}
