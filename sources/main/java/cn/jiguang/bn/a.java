package cn.jiguang.bn;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import cn.jiguang.bb.f;
import cn.jiguang.bz.p;
import cn.jiguang.bz.w;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: t, reason: collision with root package name */
    private static volatile a f2366t;

    /* renamed from: u, reason: collision with root package name */
    private static final Object f2367u = new Object();

    /* renamed from: v, reason: collision with root package name */
    private static String f2368v;

    /* renamed from: a, reason: collision with root package name */
    public String f2369a;

    /* renamed from: b, reason: collision with root package name */
    public String f2370b;

    /* renamed from: c, reason: collision with root package name */
    public String f2371c;

    /* renamed from: d, reason: collision with root package name */
    public String f2372d;

    /* renamed from: e, reason: collision with root package name */
    public String f2373e;

    /* renamed from: f, reason: collision with root package name */
    public String f2374f;

    /* renamed from: g, reason: collision with root package name */
    public int f2375g;

    /* renamed from: h, reason: collision with root package name */
    public String f2376h;

    /* renamed from: i, reason: collision with root package name */
    public String f2377i;

    /* renamed from: j, reason: collision with root package name */
    public String f2378j;

    /* renamed from: k, reason: collision with root package name */
    public String f2379k;

    /* renamed from: l, reason: collision with root package name */
    public String f2380l;

    /* renamed from: m, reason: collision with root package name */
    public String f2381m;

    /* renamed from: n, reason: collision with root package name */
    public String f2382n;

    /* renamed from: o, reason: collision with root package name */
    public String f2383o;

    /* renamed from: p, reason: collision with root package name */
    public String f2384p;

    /* renamed from: q, reason: collision with root package name */
    public String f2385q;

    /* renamed from: r, reason: collision with root package name */
    public String f2386r;

    /* renamed from: s, reason: collision with root package name */
    private transient AtomicBoolean f2387s = new AtomicBoolean(false);

    public static a a(Context context) {
        if (f2366t == null) {
            synchronized (f2367u) {
                try {
                    if (f2366t == null) {
                        f2366t = new a(context);
                    }
                } finally {
                }
            }
        }
        return f2366t;
    }

    public static void b(Context context) {
        f2366t = null;
        a(context);
    }

    private String a(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    private void c(Context context) {
        if (this.f2387s.get() || context == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a(cn.jiguang.bz.a.a().D(context)));
        sb.append(",");
        int i6 = Build.VERSION.SDK_INT;
        sb.append(i6);
        this.f2370b = sb.toString();
        this.f2371c = cn.jiguang.bz.a.a().y(context);
        if (cn.jiguang.g.a.a().e(2001)) {
            this.f2372d = w.a("gsm.version.baseband", "baseband");
        }
        this.f2380l = cn.jiguang.bz.a.a().B(context);
        this.f2382n = cn.jiguang.bz.a.a().z(context);
        this.f2376h = cn.jiguang.bz.a.a().k(context);
        this.f2377i = cn.jiguang.bz.a.a().o(context);
        this.f2378j = " ";
        this.f2373e = a(Build.DEVICE);
        this.f2379k = a(cn.jiguang.bz.a.a().t(context));
        this.f2381m = a(cn.jiguang.bz.a.a().v(context));
        this.f2369a = d(context);
        this.f2374f = cn.jiguang.d.a.h(context);
        this.f2375g = cn.jiguang.bz.a.d(context) ? 1 : 0;
        this.f2383o = cn.jiguang.bz.a.a().e(context, "");
        this.f2384p = cn.jiguang.bz.a.a().d(context, "");
        this.f2385q = i6 + "";
        this.f2386r = context.getApplicationInfo().targetSdkVersion + "";
        this.f2387s.set(true);
    }

    private static String d(Context context) {
        if (f2368v == null) {
            try {
                PackageInfo a6 = p.a(context, 0);
                if (a6 != null) {
                    String str = a6.versionName;
                    byte[] bytes = str.getBytes("UTF-8");
                    if (bytes.length > 30) {
                        str = new String(bytes, 0, 30);
                    }
                    f2368v = str;
                } else {
                    f.d("DeviceInfo", "NO versionName defined in manifest.");
                }
            } catch (Throwable unused) {
                f.d("DeviceInfo", "NO versionName defined in manifest.");
            }
        }
        String str2 = f2368v;
        return str2 == null ? "" : str2;
    }

    private a(Context context) {
        c(context);
    }
}
