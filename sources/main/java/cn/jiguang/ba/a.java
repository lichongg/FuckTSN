package cn.jiguang.ba;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.bz.p;
import cn.jiguang.bz.q;
import cn.jiguang.bz.w;
import cn.jiguang.internal.JConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f1877a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f1878b;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f1879c;

    /* renamed from: d, reason: collision with root package name */
    private static Pair<String, Long> f1880d;

    /* renamed from: e, reason: collision with root package name */
    private static final ArrayList<String> f1881e;

    /* renamed from: f, reason: collision with root package name */
    private static final ArrayList<String> f1882f;

    /* renamed from: g, reason: collision with root package name */
    private static final ArrayList<String> f1883g;

    /* renamed from: h, reason: collision with root package name */
    private static final ArrayList<String> f1884h;

    public static long a(PackageInfo packageInfo) {
        long longVersionCode;
        if (Build.VERSION.SDK_INT < 28) {
            return b(packageInfo);
        }
        longVersionCode = packageInfo.getLongVersionCode();
        return longVersionCode;
    }

    private static long b(PackageInfo packageInfo) {
        return packageInfo.versionCode;
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f1881e = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        f1882f = arrayList2;
        ArrayList<String> arrayList3 = new ArrayList<>();
        f1883g = arrayList3;
        ArrayList<String> arrayList4 = new ArrayList<>();
        f1884h = arrayList4;
        arrayList2.add(com.kuaishou.weapon.p0.g.f36041a);
        arrayList2.add(com.kuaishou.weapon.p0.g.f36042b);
        arrayList4.add("com.huawei.android.launcher.permission.CHANGE_BADGE");
        arrayList4.add("com.vivo.notification.permission.BADGE_ICON");
        arrayList4.add("com.hihonor.android.launcher.permission.CHANGE_BADGE");
        arrayList3.add("android.permission.CHANGE_WIFI_STATE");
        arrayList3.add("android.permission.VIBRATE");
        arrayList3.add("android.permission.WAKE_LOCK");
        arrayList3.add(com.kuaishou.weapon.p0.g.f36050j);
        arrayList.add(com.kuaishou.weapon.p0.g.f36047g);
        arrayList.add(com.kuaishou.weapon.p0.g.f36048h);
        arrayList.add("android.permission.ACCESS_LOCATION_EXTRA_COMMANDS");
        arrayList.add(com.kuaishou.weapon.p0.g.f36044d);
    }

    public static String a(Context context) {
        try {
            if (f1879c == null && !TextUtils.isEmpty(JConstants.APP_KEY)) {
                return JConstants.APP_KEY;
            }
        } catch (Throwable unused) {
            f1879c = Boolean.FALSE;
        }
        b(context);
        return f1877a;
    }

    public static String b(Context context) {
        String str;
        Bundle bundle;
        if (!TextUtils.isEmpty(f1877a)) {
            return f1877a;
        }
        if (TextUtils.isEmpty(f1877a)) {
            try {
                if (context != null) {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                        str = "";
                    } else {
                        str = a(bundle, "JPUSH_APPKEY");
                        if (!TextUtils.isEmpty(str)) {
                            str = str.toLowerCase(Locale.getDefault());
                        }
                    }
                    if (!TextUtils.isEmpty("") && !TextUtils.isEmpty(str)) {
                        String lowerCase = "".toLowerCase(Locale.getDefault());
                        if (!lowerCase.contains(str)) {
                            cn.jiguang.bb.f.d("CheckManifestHelper", "[key-step]appkey " + str + " not in limitAppkeys:" + lowerCase);
                            cn.jiguang.bb.f.l("CheckManifestHelper", "[key-step]You use the customized sdk, but your appkey not in valid appkey list. If you want to enable it, please contact us.");
                        }
                    }
                    f1877a = str;
                } else {
                    cn.jiguang.bb.f.c("CheckManifestHelper", "[getAppKey] context is null");
                }
            } catch (Throwable unused) {
            }
        }
        return f1877a;
    }

    public static String c(Context context) {
        StringBuilder sb;
        Bundle bundle;
        if (f1878b == null && context != null) {
            try {
                String c6 = cn.jiguang.d.a.c(context);
                f1878b = c6;
                if (c6 != null) {
                    sb = new StringBuilder();
                    sb.append("get option channel - ");
                    sb.append(f1878b);
                } else {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                        String a6 = a(bundle, "JPUSH_CHANNEL");
                        f1878b = a6;
                        if (!TextUtils.isEmpty(a6)) {
                            f1878b = w.b(f1878b);
                        }
                    }
                    sb = new StringBuilder();
                    sb.append("manifest:channel - ");
                    sb.append(f1878b);
                }
                cn.jiguang.bb.f.d("CheckManifestHelper", sb.toString());
            } catch (Throwable unused) {
            }
        }
        return f1878b;
    }

    public static Pair<String, Long> d(Context context) {
        if (f1880d == null) {
            try {
                PackageInfo a6 = p.a(context, 0);
                if (a6 != null) {
                    String str = a6.versionName;
                    byte[] bytes = str.getBytes("UTF-8");
                    if (bytes.length > 30) {
                        str = new String(bytes, 0, 30);
                    }
                    f1880d = new Pair<>(str, Long.valueOf(a(a6)));
                } else {
                    cn.jiguang.bb.f.d("CheckManifestHelper", "NO versionCode or versionName defined in manifest.");
                }
            } catch (Throwable unused) {
                cn.jiguang.bb.f.d("CheckManifestHelper", "NO versionCode or versionName defined in manifest.");
            }
        }
        return f1880d;
    }

    public static String a(Bundle bundle, String str) {
        Object obj;
        if (bundle == null || (obj = bundle.get(str)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static int e(Context context) {
        String a6 = a(context);
        if (TextUtils.isEmpty(a6)) {
            cn.jiguang.bb.f.n("CheckManifestHelper", "errorcode:10001,metadata: JCore appKey - not defined in manifest");
            cn.jiguang.bz.a.a(context, " 未在manifest中配置AppKey", -1);
            return 10001;
        }
        if (a6.length() != 24) {
            cn.jiguang.bb.f.n("CheckManifestHelper", "errorcode:1008,Invalid appKey : " + a6 + ", Please get your Appkey from JIGUANG web console!");
            cn.jiguang.bz.a.a(context, " AppKey:" + a6 + " 是无效的AppKey,请确认与JIGUANG web端的AppKey一致", -1);
            return 1008;
        }
        return 0;
    }

    public static int f(Context context) {
        c(context);
        if (c.a().g() || c.a().f()) {
            String str = context.getPackageName() + cn.jiguang.a.a.f1443a;
            if (!q.b(context, str)) {
                cn.jiguang.bb.f.m("CheckManifestHelper", "The permission should be defined - " + str);
                return 1001;
            }
            f1882f.add(str);
        }
        Iterator<String> it = f1882f.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!q.a(context, next)) {
                cn.jiguang.bb.f.m("CheckManifestHelper", "The permissoin is required - " + next);
                return 1002;
            }
        }
        Iterator<String> it2 = f1883g.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!q.b(context, next2)) {
                cn.jiguang.bb.f.i("CheckManifestHelper", "We recommend you add the permission - " + next2);
            }
        }
        Iterator<String> it3 = f1884h.iterator();
        while (it3.hasNext()) {
            String next3 = it3.next();
            if (!q.b(context, next3)) {
                cn.jiguang.bb.f.k("CheckManifestHelper", "We recommend you add the permission - " + next3 + ",Otherwise set badge number will failed");
            }
        }
        Iterator<String> it4 = f1881e.iterator();
        while (it4.hasNext()) {
            String next4 = it4.next();
            if (!q.b(context, next4)) {
                cn.jiguang.bb.f.i("CheckManifestHelper", "We recommend you add the permission - " + next4 + ", otherwise you can not locate the devices.");
            }
        }
        return 0;
    }

    public static void a(Context context, String str) {
        f1878b = str;
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.O().a((cn.jiguang.e.a<String>) str)});
        c(context);
    }
}
