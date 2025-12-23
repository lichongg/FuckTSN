package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class bn {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10745a = "mobads_builds";

    /* renamed from: b, reason: collision with root package name */
    public static final String f10746b = "brand_period";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10747c = "version_period";

    /* renamed from: d, reason: collision with root package name */
    public static final long f10748d = 604800000;

    /* renamed from: e, reason: collision with root package name */
    public static final long f10749e = 172800000;

    /* renamed from: f, reason: collision with root package name */
    public static final String f10750f = "sdk_int";

    /* renamed from: g, reason: collision with root package name */
    public static final String f10751g = "sdk";

    /* renamed from: h, reason: collision with root package name */
    public static final String f10752h = "release";

    /* renamed from: i, reason: collision with root package name */
    public static final String f10753i = "model";

    /* renamed from: j, reason: collision with root package name */
    public static final String f10754j = "brand";

    /* renamed from: k, reason: collision with root package name */
    public static final String f10755k = "netopera";

    /* renamed from: l, reason: collision with root package name */
    public static final String f10756l = "tags";

    /* renamed from: m, reason: collision with root package name */
    private int f10757m;

    /* renamed from: n, reason: collision with root package name */
    private String f10758n;

    /* renamed from: o, reason: collision with root package name */
    private String f10759o;

    /* renamed from: p, reason: collision with root package name */
    private String f10760p;

    /* renamed from: q, reason: collision with root package name */
    private String f10761q;

    /* renamed from: r, reason: collision with root package name */
    private String f10762r;

    /* renamed from: s, reason: collision with root package name */
    private String f10763s;

    /* renamed from: t, reason: collision with root package name */
    private Context f10764t;

    /* renamed from: u, reason: collision with root package name */
    private SharedPreferences f10765u;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final bn f10766a = new bn(null);

        private a() {
        }
    }

    /* synthetic */ bn(bo boVar) {
        this();
    }

    public static bn a(Context context) {
        a.f10766a.b(context);
        return a.f10766a;
    }

    public void b(Context context) {
        if (this.f10764t != null || context == null) {
            if (a.f10766a == null) {
                bc.a(context);
                return;
            }
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f10764t = origApplicationContext;
        try {
            if (this.f10765u == null) {
                this.f10765u = origApplicationContext.getSharedPreferences(f10745a, 0);
                h();
            }
        } catch (Throwable th) {
            bu.a().c(th.getMessage());
        }
    }

    public String c() {
        return this.f10759o;
    }

    private bn() {
        this.f10757m = 0;
        this.f10758n = "";
        this.f10759o = "";
        this.f10760p = "";
        this.f10761q = "";
        this.f10762r = "";
        this.f10763s = "";
    }

    private int c(String str) {
        try {
            return this.f10765u.getInt(str, 0);
        } catch (Throwable th) {
            bu.a().c(th.getMessage());
            return 0;
        }
    }

    private void i() {
        try {
            if (System.currentTimeMillis() <= b(f10746b).longValue()) {
                this.f10760p = a(f10753i);
                this.f10761q = a(f10754j);
                this.f10762r = a(f10755k);
                this.f10763s = a("tags");
                return;
            }
            this.f10760p = Build.MODEL;
            this.f10761q = Build.BRAND;
            this.f10762r = ((TelephonyManager) this.f10764t.getSystemService("phone")).getNetworkOperator();
            this.f10763s = Build.TAGS;
            a(f10753i, this.f10760p);
            a(f10754j, this.f10761q);
            a(f10755k, this.f10762r);
            a("tags", this.f10763s);
            a(f10746b, Long.valueOf(System.currentTimeMillis() + f10748d));
        } catch (Throwable th) {
            bu.a().c(th.getMessage());
        }
    }

    private void j() {
        try {
            if (System.currentTimeMillis() <= b(f10747c).longValue()) {
                this.f10757m = c(f10750f);
                this.f10758n = a("sdk");
                this.f10759o = a("release");
                return;
            }
            int i6 = Build.VERSION.SDK_INT;
            this.f10757m = i6;
            this.f10758n = Build.VERSION.SDK;
            this.f10759o = Build.VERSION.RELEASE;
            a(f10750f, i6);
            a("sdk", this.f10758n);
            a("release", this.f10759o);
            a(f10747c, Long.valueOf(System.currentTimeMillis() + f10749e));
        } catch (Throwable th) {
            bu.a().c(th.getMessage());
        }
    }

    private SharedPreferences.Editor k() {
        return this.f10765u.edit();
    }

    public String d() {
        return this.f10760p;
    }

    public String e() {
        return this.f10761q;
    }

    public String f() {
        return this.f10762r;
    }

    public String g() {
        return this.f10763s;
    }

    private void h() {
        i();
        j();
    }

    public int a() {
        if (this.f10757m == 0) {
            this.f10757m = Build.VERSION.SDK_INT;
        }
        return this.f10757m;
    }

    private String a(String str) {
        try {
            return this.f10765u.getString(str, "");
        } catch (Throwable th) {
            bu.a().c(th.getMessage());
            return "";
        }
    }

    @TargetApi(9)
    private void a(String str, String str2) {
        try {
            SharedPreferences.Editor k6 = k();
            k6.putString(str, str2);
            k6.apply();
        } catch (Throwable th) {
            bu.a().c(th.getMessage());
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f10758n)) {
            this.f10758n = Build.VERSION.SDK;
        }
        return this.f10758n;
    }

    @TargetApi(9)
    private void a(String str, Long l6) {
        try {
            SharedPreferences.Editor k6 = k();
            k6.putLong(str, l6.longValue());
            k6.apply();
        } catch (Throwable th) {
            bu.a().c(th.getMessage());
        }
    }

    private Long b(String str) {
        try {
            return Long.valueOf(this.f10765u.getLong(str, 0L));
        } catch (Throwable th) {
            bu.a().c(th.getMessage());
            return 0L;
        }
    }

    @TargetApi(9)
    private void a(String str, int i6) {
        try {
            SharedPreferences.Editor k6 = k();
            k6.putInt(str, i6);
            k6.apply();
        } catch (Throwable th) {
            bu.a().c(th.getMessage());
        }
    }
}
