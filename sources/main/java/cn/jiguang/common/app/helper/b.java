package cn.jiguang.common.app.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.bz.j;
import cn.jiguang.bz.l;
import cn.jiguang.bz.p;
import cn.jiguang.bz.q;
import cn.jiguang.bz.v;
import cn.jiguang.bz.w;
import cn.jiguang.bz.y;
import cn.jiguang.m.c;
import cn.jiguang.q.d;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.common.primitives.SignedBytes;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"PackageManagerGetSignatures"})
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: i, reason: collision with root package name */
    private static Map<String, cn.jiguang.common.app.entity.b> f2891i;

    /* renamed from: k, reason: collision with root package name */
    private static List<PackageInfo> f2893k;

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f2886d = {102, 124, 16, 76, 112, 123, 98, 49, SignedBytes.MAX_POWER_OF_TWO, 65, 122, 99, 119, 118, 85};

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f2887e = {111, 115, 101, 121, 78, 106, 124, 119, 125, 92, 69, 125, 88, 119, 114, 91, 65, 126, 109, 101};

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap<String, Signature[]> f2888f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private static final HashMap<String, String> f2889g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private static String f2890h = "JAppHelper";

    /* renamed from: j, reason: collision with root package name */
    private static List<cn.jiguang.common.app.entity.b> f2892j = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public static int f2883a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static int f2884b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static int f2885c = 2;

    public static int a(ApplicationInfo applicationInfo) {
        if (applicationInfo == null) {
            return -1;
        }
        try {
            int i6 = applicationInfo.flags;
            if ((i6 & 1) != 0) {
                return (i6 & 128) != 0 ? 2 : 1;
            }
            String a6 = cn.jiguang.bz.a.a(applicationInfo);
            if (TextUtils.isEmpty(a6)) {
                return -1;
            }
            return (a6.startsWith("/system/") || a6.startsWith("/vendor/") || a6.startsWith("/product/") || !a6.contains(applicationInfo.packageName)) ? 3 : 0;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i(f2890h, "getAppInstalledType throwable:" + th.getMessage());
            return -1;
        }
    }

    public static int b(Context context, String str) {
        int i6 = 0;
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setClassName(str, c.a.f3101e);
            int i7 = packageManager.resolveService(intent, 0) != null ? 2 : 0;
            try {
                Intent intent2 = new Intent();
                intent2.setClassName(str, c.a.f3102f);
                if (packageManager.resolveService(intent2, 0) != null) {
                    i7++;
                }
                Intent intent3 = new Intent();
                intent3.setClassName(str, c.a.f3103g);
                return packageManager.resolveService(intent3, 0) != null ? i7 + 4 : i7;
            } catch (Throwable th) {
                th = th;
                i6 = i7;
                cn.jiguang.bb.f.i(f2890h, "filterThirdSdk throwable:" + th.getMessage());
                return i6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int c() {
        return (Build.VERSION.SDK_INT >= 28 ? 134217792 : 64) | 4100;
    }

    private static PackageInfo d(Context context, String str) {
        int i6 = Build.VERSION.SDK_INT >= 28 ? 134217792 : 64;
        PackageInfo a6 = p.a(context, str, i6);
        if (a6 != null) {
            return a6;
        }
        int indexOf = str.indexOf(":");
        if (indexOf <= 0) {
            return null;
        }
        return p.a(context, str.substring(0, indexOf), i6);
    }

    private static String e(String str) {
        return Pattern.compile("\n|\r|\r\n|\n\r|\t").matcher(str).replaceAll("");
    }

    public static ApplicationInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i(f2890h, "getApplicationInfo throwable:" + th.getMessage());
            return null;
        }
    }

    public static String b(String str) {
        try {
            return f2889g.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static cn.jiguang.common.app.entity.b c(Context context, String str) {
        cn.jiguang.common.app.entity.b bVar;
        PackageInfo d6 = d(context, str);
        if (d6 == null) {
            return null;
        }
        try {
            a(context);
            cn.jiguang.common.app.entity.b bVar2 = new cn.jiguang.common.app.entity.b();
            bVar2.f2828b = d6.packageName;
            bVar2.f2830d = d6.versionCode;
            bVar2.f2829c = d6.versionName;
            bVar2.f2831e = a(d6.applicationInfo);
            bVar2.f2832f = b(context, str);
            bVar2.f2836j = cn.jiguang.bz.a.a(d6);
            bVar2.f2837k = d6.lastUpdateTime;
            Map<String, cn.jiguang.common.app.entity.b> map = f2891i;
            if (map != null && map.containsKey(bVar2.f2828b) && (bVar = f2891i.get(bVar2.f2828b)) != null && bVar.equals(bVar2)) {
                bVar2.f2827a = bVar.f2827a;
            }
            bVar2.f2833g = a(context, d6, v.f2786a);
            bVar2.f2834h = a(context, d6, v.f2787b);
            bVar2.f2835i = a(context, d6, v.f2788c);
            if (bVar2.f2827a == null) {
                bVar2.f2827a = d(d6.applicationInfo.loadLabel(context.getPackageManager()).toString());
                Map<String, cn.jiguang.common.app.entity.b> map2 = f2891i;
                if (map2 != null) {
                    map2.put(bVar2.f2828b, bVar2);
                }
            }
            return bVar2;
        } catch (Throwable th) {
            try {
                cn.jiguang.bb.f.i(f2890h, "getAppInfoFromPackage throwable:" + th.getMessage());
                return null;
            } finally {
                System.gc();
            }
        }
    }

    private static String d(String str) {
        String str2;
        StringBuilder sb;
        String str3;
        if (!TextUtils.isEmpty(str)) {
            String e6 = e(str);
            try {
                byte[] bytes = str.getBytes();
                if (bytes.length > 30) {
                    return e6.substring(0, new String(bytes, 0, 30, "UTF-8").length());
                }
            } catch (UnsupportedEncodingException e7) {
                e = e7;
                str2 = f2890h;
                sb = new StringBuilder();
                str3 = "getAppName exception:";
                sb.append(str3);
                sb.append(e.getMessage());
                cn.jiguang.bb.f.i(str2, sb.toString());
                return str;
            } catch (Throwable th) {
                e = th;
                str2 = f2890h;
                sb = new StringBuilder();
                str3 = "getAppName throwable:";
                sb.append(str3);
                sb.append(e.getMessage());
                cn.jiguang.bb.f.i(str2, sb.toString());
                return str;
            }
        }
        return str;
    }

    private static List<cn.jiguang.common.app.entity.b> e(Context context) {
        cn.jiguang.common.app.entity.b bVar;
        HashMap hashMap = new HashMap();
        List<cn.jiguang.common.app.entity.d> a6 = c.a(context, 1);
        if (a6 == null) {
            return new ArrayList(hashMap.values());
        }
        Map<String, cn.jiguang.common.app.entity.b> a7 = a(context);
        for (cn.jiguang.common.app.entity.d dVar : a6) {
            if (a7 != null) {
                String str = dVar.f2848d;
                int indexOf = str.indexOf(":");
                if (indexOf > 0) {
                    str = str.substring(0, indexOf);
                }
                bVar = a7.get(str);
            } else {
                bVar = null;
            }
            if (bVar == null || TextUtils.isEmpty(bVar.f2828b)) {
                bVar = c(context, dVar.f2848d);
            }
            if (bVar != null) {
                hashMap.put(bVar.f2828b, bVar);
            }
        }
        return new ArrayList(hashMap.values());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.List] */
    public static Object a(Context context, boolean z5, Object obj) {
        int i6;
        int i7;
        if (cn.jiguang.g.a.a().g(1100)) {
            cn.jiguang.bb.f.c(f2890h, "not allowed to get applist");
            i6 = -3;
        } else if (d(context)) {
            List<cn.jiguang.common.app.entity.b> a6 = a(context, true, false);
            if (a6 != null && a6.size() > 0) {
                ArrayList<cn.jiguang.common.app.entity.b> arrayList = new ArrayList();
                if (z5) {
                    arrayList.addAll(a6);
                } else {
                    for (cn.jiguang.common.app.entity.b bVar : a6) {
                        if (bVar != null && ((i7 = bVar.f2831e) == 0 || i7 == 3)) {
                            arrayList.add(bVar);
                        }
                    }
                }
                if (obj instanceof List) {
                    obj = (List) obj;
                    for (cn.jiguang.common.app.entity.b bVar2 : arrayList) {
                        if (bVar2 != null && !TextUtils.isEmpty(bVar2.f2828b)) {
                            obj.add(bVar2.f2828b);
                        }
                    }
                }
                return obj;
            }
            cn.jiguang.bb.f.c(f2890h, "get third applist failed");
            i6 = -1;
        } else {
            cn.jiguang.bb.f.i(f2890h, "no QUERY_ALL_PACKAGES permission, can not get third applist");
            i6 = -2;
        }
        return Integer.valueOf(i6);
    }

    private static String b(List<cn.jiguang.common.app.entity.b> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (cn.jiguang.common.app.entity.b bVar : list) {
            sb.append(bVar.f2828b);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(bVar.f2827a);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(bVar.f2830d);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(bVar.f2829c);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(bVar.f2831e);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(bVar.f2832f);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(bVar.f2833g);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(bVar.f2834h);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(bVar.f2835i);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(bVar.f2836j);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(bVar.f2837k);
            sb.append("&&");
        }
        return sb.toString();
    }

    public static List<cn.jiguang.common.app.entity.b> c(Context context) {
        return e(context);
    }

    public static boolean d(Context context) {
        if (context == null) {
            cn.jiguang.bb.f.i(f2890h, "[hasQueryAllPackagesPermission] context is null");
            return false;
        }
        try {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 < 30 || context.getApplicationInfo().targetSdkVersion < 30 || q.b(context, "android.permission.QUERY_ALL_PACKAGES")) {
                return true;
            }
            cn.jiguang.bb.f.c(f2890h, "current sdk code: " + i6 + ", no permission: QUERY_ALL_PACKAGES");
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a(Context context, PackageInfo packageInfo, String str) {
        Signature[] signatureArr;
        try {
            String str2 = packageInfo.packageName;
            HashMap<String, Signature[]> hashMap = f2888f;
            if (hashMap.containsKey(str2)) {
                signatureArr = hashMap.get(str2);
            } else {
                signatureArr = a(context, packageInfo);
                if (signatureArr != null && signatureArr.length > 0) {
                    hashMap.put(str2, signatureArr);
                }
            }
            if (signatureArr != null && signatureArr.length != 0) {
                byte[] digest = MessageDigest.getInstance(str).digest(signatureArr[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (int i6 = 0; i6 < digest.length; i6++) {
                    String upperCase = Integer.toHexString(digest[i6] & 255).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(upperCase);
                    if (i6 < digest.length - 1) {
                        sb.append(":");
                    }
                }
                return sb.toString();
            }
            return "";
        } catch (Throwable th) {
            cn.jiguang.bb.f.i(f2890h, "getSign fail, error is " + th.getMessage());
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<cn.jiguang.common.app.entity.b> c(Context context, boolean z5, boolean z6) {
        return b(context, z5, z6, false);
    }

    public static String a(Collection<cn.jiguang.common.app.entity.b> collection) {
        StringBuilder sb = new StringBuilder();
        for (cn.jiguang.common.app.entity.b bVar : collection) {
            sb.append(bVar.f2828b);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(bVar.f2836j);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(bVar.f2837k);
            sb.append("&&");
        }
        return sb.toString();
    }

    private static Map<String, cn.jiguang.common.app.entity.b> c(String str) {
        String[] split;
        cn.jiguang.common.app.entity.b bVar;
        String str2;
        if (w.a(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String[] split2 = str.split("&&");
        int length = split2.length;
        char c6 = 0;
        int i6 = 0;
        while (i6 < length) {
            String str3 = split2[i6];
            if (str3 != null) {
                try {
                    split = str3.split(ContainerUtils.FIELD_DELIMITER);
                } catch (Throwable th) {
                    th = th;
                }
                if (split.length == 9) {
                    bVar = new cn.jiguang.common.app.entity.b();
                    bVar.f2828b = split[c6];
                    bVar.f2827a = split[1];
                    bVar.f2830d = Integer.parseInt(split[2]);
                    bVar.f2829c = split[3];
                    bVar.f2831e = Integer.parseInt(split[4]);
                    bVar.f2832f = Integer.parseInt(split[5]);
                    bVar.f2833g = split[6];
                    bVar.f2834h = split[7];
                    bVar.f2835i = split[8];
                    str2 = bVar.f2828b;
                } else if (split.length == 6) {
                    bVar = new cn.jiguang.common.app.entity.b();
                    bVar.f2828b = split[c6];
                    bVar.f2827a = split[1];
                    bVar.f2830d = Integer.parseInt(split[2]);
                    bVar.f2829c = split[3];
                    bVar.f2831e = Integer.parseInt(split[4]);
                    bVar.f2832f = Integer.parseInt(split[5]);
                    str2 = bVar.f2828b;
                } else {
                    if (split.length == 11) {
                        try {
                            cn.jiguang.common.app.entity.b bVar2 = new cn.jiguang.common.app.entity.b();
                            bVar2.f2828b = split[0];
                            bVar2.f2827a = split[1];
                            bVar2.f2830d = Integer.parseInt(split[2]);
                            bVar2.f2829c = split[3];
                            bVar2.f2831e = Integer.parseInt(split[4]);
                            bVar2.f2832f = Integer.parseInt(split[5]);
                            bVar2.f2833g = split[6];
                            bVar2.f2834h = split[7];
                            bVar2.f2835i = split[8];
                            bVar2.f2836j = Long.parseLong(split[9]);
                            bVar2.f2837k = Long.parseLong(split[10]);
                            hashMap.put(bVar2.f2828b, bVar2);
                        } catch (Throwable th2) {
                            th = th2;
                            cn.jiguang.bb.f.i(f2890h, "parse appinfo error:" + th);
                            i6++;
                            c6 = 0;
                        }
                    }
                    i6++;
                    c6 = 0;
                }
                hashMap.put(str2, bVar);
            }
            i6++;
            c6 = 0;
        }
        return hashMap;
    }

    public static ArrayList<JSONArray> a(JSONArray jSONArray) {
        String str;
        StringBuilder sb;
        String str2;
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                ArrayList<JSONArray> arrayList = new ArrayList<>();
                int i6 = 0;
                for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i7);
                    if (optJSONObject != null && optJSONObject.length() != 0) {
                        int length = optJSONObject.toString().getBytes("UTF-8").length;
                        i6 += length;
                        if (i6 > 102400) {
                            if (jSONArray2.length() > 0) {
                                arrayList.add(jSONArray2);
                            }
                            jSONArray2 = new JSONArray();
                            jSONArray2.put(optJSONObject);
                            i6 = length;
                        } else {
                            jSONArray2.put(optJSONObject);
                        }
                    }
                }
                if (jSONArray2.length() > 0) {
                    arrayList.add(jSONArray2);
                }
                return arrayList;
            } catch (UnsupportedEncodingException e6) {
                e = e6;
                str = f2890h;
                sb = new StringBuilder();
                str2 = "partition exception:";
                sb.append(str2);
                sb.append(e.getMessage());
                cn.jiguang.bb.f.i(str, sb.toString());
                return null;
            } catch (Throwable th) {
                e = th;
                str = f2890h;
                sb = new StringBuilder();
                str2 = "partition throwable:";
                sb.append(str2);
                sb.append(e.getMessage());
                cn.jiguang.bb.f.i(str, sb.toString());
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        cn.jiguang.bw.a.a().f((java.lang.Object) 2046);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<cn.jiguang.common.app.entity.b> b(android.content.Context r2, boolean r3, boolean r4, boolean r5) {
        /*
            boolean r0 = d(r2)
            if (r0 != 0) goto L15
            if (r4 == 0) goto L15
            cn.jiguang.bw.a r0 = cn.jiguang.bw.a.a()
            r1 = 2067(0x813, float:2.896E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.f(r1)
        L15:
            android.content.pm.PackageManager r0 = r2.getPackageManager()     // Catch: java.lang.Throwable -> L42
            java.util.List r5 = a(r2, r5)     // Catch: java.lang.Throwable -> L42
            if (r5 == 0) goto L2e
            boolean r1 = r5.isEmpty()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L26
            goto L2e
        L26:
            java.util.List r2 = a(r2, r0, r5, r3)     // Catch: java.lang.Throwable -> L42
            java.lang.System.gc()
            return r2
        L2e:
            if (r4 == 0) goto L3d
            cn.jiguang.bw.a r2 = cn.jiguang.bw.a.a()     // Catch: java.lang.Throwable -> L42
            r3 = 2046(0x7fe, float:2.867E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L42
            r2.f(r3)     // Catch: java.lang.Throwable -> L42
        L3d:
            java.lang.System.gc()
            r2 = 0
            return r2
        L42:
            r2 = move-exception
            java.lang.System.gc()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.common.app.helper.b.b(android.content.Context, boolean, boolean, boolean):java.util.List");
    }

    public static List<PackageInfo> a() {
        List<PackageInfo> list = f2893k;
        return list == null ? new ArrayList() : list;
    }

    public static Set<cn.jiguang.common.app.entity.b> b(Context context) {
        String e6 = j.e("bal.catch");
        if (TextUtils.isEmpty(e6)) {
            return null;
        }
        return a(e6);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0083 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:41:0x0003, B:3:0x0013, B:5:0x002b, B:8:0x0032, B:9:0x0038, B:11:0x003e, B:13:0x004a, B:18:0x0053, B:23:0x0062, B:25:0x006e, B:30:0x0083, B:31:0x008a, B:33:0x007d, B:17:0x008d, B:38:0x0091), top: B:40:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<android.content.pm.PackageInfo> a(android.content.Context r7, int r8, boolean r9) {
        /*
            r0 = 0
            if (r9 != 0) goto L13
            cn.jiguang.g.a r1 = cn.jiguang.g.a.a()     // Catch: java.lang.Throwable -> L10
            r2 = 1109(0x455, float:1.554E-42)
            boolean r1 = r1.e(r2)     // Catch: java.lang.Throwable -> L10
            if (r1 == 0) goto Lc0
            goto L13
        L10:
            r7 = move-exception
            goto La6
        L13:
            java.lang.String r1 = cn.jiguang.common.app.helper.b.f2890h     // Catch: java.lang.Throwable -> L10
            java.lang.String r2 = "start to getInstalledApps by shell "
            cn.jiguang.bb.f.c(r1, r2)     // Catch: java.lang.Throwable -> L10
            byte[] r1 = cn.jiguang.common.app.helper.b.f2886d     // Catch: java.lang.Throwable -> L10
            java.lang.String r1 = cn.jiguang.bz.l.b(r1)     // Catch: java.lang.Throwable -> L10
            java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch: java.lang.Throwable -> L10
            r2 = 1
            java.util.List r1 = cn.jiguang.v.c.a(r1, r2)     // Catch: java.lang.Throwable -> L10
            if (r1 == 0) goto L91
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L10
            if (r2 == 0) goto L32
            goto L91
        L32:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L10
            r2.<init>()     // Catch: java.lang.Throwable -> L10
            r3 = 0
        L38:
            int r4 = r1.size()     // Catch: java.lang.Throwable -> L10
            if (r3 >= r4) goto L90
            java.lang.Object r4 = r1.get(r3)     // Catch: java.lang.Throwable -> L10
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L10
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L10
            if (r5 != 0) goto L8d
            java.lang.String r5 = "package:"
            boolean r5 = r4.startsWith(r5)     // Catch: java.lang.Throwable -> L10
            if (r5 != 0) goto L53
            goto L8d
        L53:
            r5 = 8
            java.lang.String r4 = r4.substring(r5)     // Catch: java.lang.Throwable -> L10
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L10
            if (r5 == 0) goto L60
            goto L8d
        L60:
            if (r9 != 0) goto L7d
            cn.jiguang.g.a r5 = cn.jiguang.g.a.a()     // Catch: java.lang.Throwable -> L10
            r6 = 1105(0x451, float:1.548E-42)
            boolean r5 = r5.g(r6)     // Catch: java.lang.Throwable -> L10
            if (r5 != 0) goto L7b
            cn.jiguang.g.a r5 = cn.jiguang.g.a.a()     // Catch: java.lang.Throwable -> L10
            r6 = 1100(0x44c, float:1.541E-42)
            boolean r5 = r5.g(r6)     // Catch: java.lang.Throwable -> L10
            if (r5 != 0) goto L7b
            goto L7d
        L7b:
            r5 = r0
            goto L81
        L7d:
            android.content.pm.PackageInfo r5 = cn.jiguang.bz.p.a(r7, r4, r8)     // Catch: java.lang.Throwable -> L10
        L81:
            if (r5 != 0) goto L8a
            android.content.pm.PackageInfo r5 = new android.content.pm.PackageInfo     // Catch: java.lang.Throwable -> L10
            r5.<init>()     // Catch: java.lang.Throwable -> L10
            r5.packageName = r4     // Catch: java.lang.Throwable -> L10
        L8a:
            r2.add(r5)     // Catch: java.lang.Throwable -> L10
        L8d:
            int r3 = r3 + 1
            goto L38
        L90:
            return r2
        L91:
            java.lang.String r7 = cn.jiguang.common.app.helper.b.f2890h     // Catch: java.lang.Throwable -> L10
            java.lang.String r8 = "execute command pm list package failed"
            cn.jiguang.bb.f.i(r7, r8)     // Catch: java.lang.Throwable -> L10
            cn.jiguang.bw.a r7 = cn.jiguang.bw.a.a()     // Catch: java.lang.Throwable -> L10
            r8 = 2085(0x825, float:2.922E-42)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L10
            r7.f(r8)     // Catch: java.lang.Throwable -> L10
            return r0
        La6:
            java.lang.String r8 = cn.jiguang.common.app.helper.b.f2890h
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "getInstalledPackagesByShell throwable:"
            r9.append(r1)
            java.lang.String r7 = r7.getMessage()
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            cn.jiguang.bb.f.i(r8, r7)
        Lc0:
            cn.jiguang.bw.a r7 = cn.jiguang.bw.a.a()
            r8 = 2045(0x7fd, float:2.866E-42)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.f(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.common.app.helper.b.a(android.content.Context, int, boolean):java.util.List");
    }

    private static List<cn.jiguang.common.app.entity.b> a(Context context, PackageManager packageManager, List<PackageInfo> list, boolean z5) {
        a(context);
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            try {
                PackageInfo packageInfo = list.get(i6);
                int a6 = a(packageInfo.applicationInfo);
                if (z5 || a6 == 0 || a6 == 3) {
                    cn.jiguang.common.app.entity.b bVar = new cn.jiguang.common.app.entity.b();
                    String str = packageInfo.packageName;
                    bVar.f2828b = str;
                    bVar.f2829c = packageInfo.versionName;
                    bVar.f2830d = packageInfo.versionCode;
                    bVar.f2831e = a6;
                    bVar.f2832f = b(context, str);
                    bVar.f2836j = cn.jiguang.bz.a.a(packageInfo);
                    bVar.f2837k = packageInfo.lastUpdateTime;
                    bVar.f2838l = packageInfo.requestedPermissions;
                    String a7 = a(context, packageInfo, v.f2786a);
                    String a8 = a(context, packageInfo, v.f2787b);
                    String a9 = a(context, packageInfo, v.f2788c);
                    Map<String, cn.jiguang.common.app.entity.b> map = f2891i;
                    if (map != null && map.containsKey(bVar.f2828b)) {
                        cn.jiguang.common.app.entity.b bVar2 = f2891i.get(bVar.f2828b);
                        if (bVar2 != null && bVar2.equals(bVar)) {
                            bVar.f2827a = bVar2.f2827a;
                        }
                        if (bVar2 != null) {
                            if (TextUtils.equals(a7, bVar2.f2833g)) {
                                a7 = "1";
                            }
                            if (TextUtils.equals(a8, bVar2.f2834h)) {
                                a8 = "1";
                            }
                            if (TextUtils.equals(a9, bVar2.f2835i)) {
                                a9 = "1";
                            }
                        }
                    }
                    bVar.f2833g = a7;
                    bVar.f2834h = a8;
                    bVar.f2835i = a9;
                    if (bVar.f2827a == null) {
                        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                        if (applicationInfo != null) {
                            bVar.f2827a = applicationInfo.loadLabel(packageManager).toString();
                        }
                        Map<String, cn.jiguang.common.app.entity.b> map2 = f2891i;
                        if (map2 != null) {
                            map2.put(bVar.f2828b, bVar);
                        }
                    }
                    arrayList.add(bVar);
                }
            } catch (Throwable unused) {
            }
        }
        System.gc();
        String b6 = b(arrayList);
        if (!w.a(b6)) {
            String b7 = y.b(b6);
            cn.jiguang.m.b.b(context, 1100, System.currentTimeMillis());
            j.a("ban.catch", b7);
        }
        if (arrayList.size() > 0) {
            cn.jiguang.bw.a.a().f((Object) 2068);
        }
        cn.jiguang.bb.f.c(f2890h, "fillAppInfo app list size is " + arrayList.size());
        return arrayList;
    }

    private static List<PackageInfo> a(Context context, boolean z5) {
        List<PackageInfo> a6;
        List<PackageInfo> list;
        int c6 = c();
        try {
            cn.jiguang.bi.b.a().a(context, 35, 0, "start to get");
            PackageManager packageManager = context.getPackageManager();
            int i6 = f2885c;
            int i7 = f2884b;
            Class<?> cls = Integer.TYPE;
            if (i6 == i7) {
                cn.jiguang.bw.a.a().f((Object) 2074);
                cn.jiguang.bb.f.c(f2890h, "getInstalledApps by shell ");
                a6 = a(context, c6, z5);
                cn.jiguang.h.b.a().a(cn.jiguang.h.b.f2977a);
                cn.jiguang.bw.a.a().f((Object) 2076);
                if (a6 == null && (z5 || cn.jiguang.g.a.a().e(1108))) {
                    cn.jiguang.bb.f.c(f2890h, "getInstalledApps by api，shell  pkgs is null");
                    cn.jiguang.h.b.a().a(cn.jiguang.h.b.f2978b);
                    cn.jiguang.bw.a.a().f((Object) 2075);
                    a6 = (List) packageManager.getClass().getDeclaredMethod(l.b(f2887e), cls).invoke(packageManager, Integer.valueOf(c()));
                }
            } else {
                cn.jiguang.bw.a.a().f((Object) 2073);
                if (!z5 && !cn.jiguang.g.a.a().e(1108)) {
                    list = null;
                    a6 = list;
                    if (a6 != null || a6.size() == 1) {
                        cn.jiguang.bb.f.c(f2890h, "getInstalledApps by shell, api pkgs is null");
                        cn.jiguang.h.b.a().a(cn.jiguang.h.b.f2977a);
                        cn.jiguang.bw.a.a().f((Object) 2076);
                        a6 = a(context, c6, z5);
                    }
                }
                cn.jiguang.bb.f.c(f2890h, "getInstalledApps by api  ");
                cn.jiguang.h.b.a().a(cn.jiguang.h.b.f2978b);
                cn.jiguang.bw.a.a().f((Object) 2075);
                list = (List) packageManager.getClass().getDeclaredMethod(l.b(f2887e), cls).invoke(packageManager, Integer.valueOf(c()));
                a6 = list;
                if (a6 != null) {
                }
                cn.jiguang.bb.f.c(f2890h, "getInstalledApps by shell, api pkgs is null");
                cn.jiguang.h.b.a().a(cn.jiguang.h.b.f2977a);
                cn.jiguang.bw.a.a().f((Object) 2076);
                a6 = a(context, c6, z5);
            }
        } catch (Throwable unused) {
            cn.jiguang.bb.f.c(f2890h, "getInstalledApps by shell throwable");
            cn.jiguang.h.b.a().a(cn.jiguang.h.b.f2977a);
            a6 = a(context, c6, z5);
            cn.jiguang.bw.a.a().f((Object) 2076);
        }
        f2893k = a6;
        return a6;
    }

    public static synchronized List<cn.jiguang.common.app.entity.b> a(Context context, boolean z5, boolean z6) {
        List<cn.jiguang.common.app.entity.b> a6;
        synchronized (b.class) {
            a6 = a(context, z5, z6, false);
        }
        return a6;
    }

    public static synchronized List<cn.jiguang.common.app.entity.b> a(final Context context, final boolean z5, final boolean z6, boolean z7) {
        synchronized (b.class) {
            List<cn.jiguang.common.app.entity.b> arrayList = new ArrayList<>();
            if (z7) {
                return b(context, z5, z6, z7);
            }
            Object a6 = cn.jiguang.q.d.a(context, 1100, 1800000L, 86400000L, z7, new d.b() { // from class: cn.jiguang.common.app.helper.b.1
                @Override // cn.jiguang.q.d.b
                public Object a() {
                    return b.c(context, z5, z6);
                }

                @Override // cn.jiguang.q.d.b
                public Object b() {
                    ArrayList arrayList2 = new ArrayList();
                    Map<String, cn.jiguang.common.app.entity.b> a7 = b.a(context);
                    if (a7 != null && !a7.isEmpty()) {
                        Iterator<Map.Entry<String, cn.jiguang.common.app.entity.b>> it = a7.entrySet().iterator();
                        while (it.hasNext()) {
                            cn.jiguang.common.app.entity.b value = it.next().getValue();
                            if (value != null) {
                                arrayList2.add(value);
                            }
                        }
                    }
                    return arrayList2;
                }

                @Override // cn.jiguang.q.d.b
                public void a(Object obj) {
                    if (obj instanceof List) {
                        List unused = b.f2892j = (List) obj;
                    }
                }

                @Override // cn.jiguang.q.d.b
                public void b(Object obj) {
                }

                @Override // cn.jiguang.q.d.b
                public Object c() {
                    return b.f2892j;
                }
            });
            if (a6 instanceof List) {
                arrayList = (List) a6;
            }
            return arrayList;
        }
    }

    public static synchronized Map<String, cn.jiguang.common.app.entity.b> a(Context context) {
        Map<String, cn.jiguang.common.app.entity.b> map;
        synchronized (b.class) {
            try {
                if (f2891i == null) {
                    String e6 = j.e("ban.catch");
                    if (!w.a(e6)) {
                        f2891i = c(y.a(e6));
                    }
                }
                map = f2891i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return map;
    }

    public static Set<cn.jiguang.common.app.entity.b> a(String str) {
        HashSet hashSet = new HashSet();
        String[] split = str.split("&&");
        if (split != null && split.length != 0) {
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        cn.jiguang.common.app.entity.b bVar = new cn.jiguang.common.app.entity.b();
                        String[] split2 = str2.split(ContainerUtils.FIELD_DELIMITER);
                        int length = split2.length;
                        if (length == 1) {
                            bVar.f2828b = split2[0];
                        } else if (length == 2) {
                            bVar.f2828b = split2[0];
                            bVar.f2836j = Long.valueOf(split2[1]).longValue();
                        } else if (length == 3) {
                            bVar.f2828b = split2[0];
                            bVar.f2836j = Long.valueOf(split2[1]).longValue();
                            bVar.f2837k = Long.valueOf(split2[2]).longValue();
                        }
                        hashSet.add(bVar);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return hashSet;
    }

    public static boolean a(int i6, String str) {
        if (i6 != 1 && i6 != 2 && i6 != 3) {
            return false;
        }
        cn.jiguang.bb.f.i(f2890h, "the " + str + " app is system app,need dealAction all apps,to executeMovementAction JAppAll");
        return true;
    }

    public static Signature[] a(Context context, PackageInfo packageInfo) {
        SigningInfo signingInfo;
        SigningInfo signingInfo2;
        SigningInfo signingInfo3;
        boolean hasMultipleSigners;
        SigningInfo signingInfo4;
        SigningInfo signingInfo5;
        Signature[] signatureArr = null;
        if (Build.VERSION.SDK_INT > 28) {
            signingInfo = packageInfo.signingInfo;
            if (signingInfo == null) {
                if (cn.jiguang.g.a.a().g(1100)) {
                    return null;
                }
                packageInfo = p.a(context, packageInfo.packageName, AMapEngineUtils.HALF_MAX_P20_WIDTH, !cn.jiguang.g.a.a().g(1105));
            }
            if (packageInfo != null) {
                signingInfo2 = packageInfo.signingInfo;
                if (signingInfo2 != null) {
                    signingInfo3 = packageInfo.signingInfo;
                    hasMultipleSigners = signingInfo3.hasMultipleSigners();
                    if (hasMultipleSigners) {
                        signingInfo5 = packageInfo.signingInfo;
                        signatureArr = signingInfo5.getApkContentsSigners();
                    } else {
                        signingInfo4 = packageInfo.signingInfo;
                        signatureArr = signingInfo4.getSigningCertificateHistory();
                    }
                }
            }
        } else {
            if (packageInfo.signatures == null) {
                if (cn.jiguang.g.a.a().g(1100)) {
                    return null;
                }
                packageInfo = p.a(context, packageInfo.packageName, 64, !cn.jiguang.g.a.a().g(1105));
            }
            if (packageInfo != null) {
                signatureArr = packageInfo.signatures;
            }
        }
        if (packageInfo != null) {
            HashMap<String, String> hashMap = f2889g;
            if (!hashMap.containsKey(packageInfo.packageName)) {
                hashMap.put(packageInfo.packageName, cn.jiguang.bz.a.a(packageInfo) + ContainerUtils.FIELD_DELIMITER + packageInfo.lastUpdateTime);
            }
        }
        return signatureArr;
    }
}
