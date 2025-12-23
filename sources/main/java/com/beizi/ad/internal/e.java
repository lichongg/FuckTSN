package com.beizi.ad.internal;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    static HashSet<String> f11773a;

    /* renamed from: c, reason: collision with root package name */
    private String f11775c;

    /* renamed from: j, reason: collision with root package name */
    private String f11782j;

    /* renamed from: n, reason: collision with root package name */
    private WeakReference<Context> f11786n;

    /* renamed from: o, reason: collision with root package name */
    private String f11787o;

    /* renamed from: b, reason: collision with root package name */
    private k f11774b = k.PREFETCH;

    /* renamed from: d, reason: collision with root package name */
    private int f11776d = 3;

    /* renamed from: e, reason: collision with root package name */
    private boolean f11777e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f11778f = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f11779g = -1;

    /* renamed from: h, reason: collision with root package name */
    private int f11780h = -1;

    /* renamed from: i, reason: collision with root package name */
    private int f11781i = -1;

    /* renamed from: k, reason: collision with root package name */
    private boolean f11783k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f11784l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11785m = false;

    public void a(boolean z5) {
        this.f11783k = z5;
    }

    public Context b() {
        if (this.f11786n.get() != null) {
            return this.f11786n.get();
        }
        return null;
    }

    public String c() {
        return this.f11775c;
    }

    public int d() {
        if (this.f11774b == k.BANNER) {
            return this.f11778f;
        }
        return -1;
    }

    public String a() {
        return this.f11787o;
    }

    public void c(int i6) {
        this.f11780h = i6;
    }

    public int e() {
        if (this.f11774b == k.BANNER) {
            return this.f11779g;
        }
        return -1;
    }

    public int f() {
        return this.f11780h;
    }

    public int g() {
        return this.f11781i;
    }

    public boolean h() {
        return this.f11777e;
    }

    public k i() {
        return this.f11774b;
    }

    public String k() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = b().getResources().getConfiguration().orientation == 2 ? "h" : "v";
            this.f11782j = str;
            if (!com.beizi.ad.internal.h.o.a(str)) {
                jSONObject.put("mOrientation", this.f11782j);
            }
            if (this.f11778f > 0 && this.f11779g > 0) {
                jSONObject.put("size", this.f11778f + "x" + this.f11779g);
            }
            int g6 = g();
            int f6 = f();
            if (g6 > 0 && f6 > 0) {
                k kVar = this.f11774b;
                k kVar2 = k.INTERSTITIAL;
                if (!kVar.equals(kVar2) && (this.f11778f < 0 || this.f11779g < 0)) {
                    jSONObject.put("max_size", f6 + "x" + g6);
                } else if (this.f11774b.equals(kVar2)) {
                    jSONObject.put("size", f6 + "x" + g6);
                }
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public boolean l() {
        return this.f11785m;
    }

    public e(Context context, String str) {
        this.f11787o = "";
        this.f11786n = new WeakReference<>(context);
        this.f11787o = str;
    }

    public void a(String str) {
        this.f11787o = str;
    }

    public void b(String str) {
        this.f11775c = str;
    }

    public void c(boolean z5) {
        this.f11785m = z5;
    }

    public void d(int i6) {
        this.f11781i = i6;
    }

    public boolean j() {
        if (!com.beizi.ad.internal.h.o.a(h.a().d()) && !com.beizi.ad.internal.h.o.a(this.f11775c)) {
            return true;
        }
        return false;
    }

    public void a(int i6) {
        this.f11778f = i6;
    }

    public void b(int i6) {
        this.f11779g = i6;
    }

    public void a(k kVar) {
        this.f11774b = kVar;
    }

    public void b(boolean z5) {
        this.f11777e = z5;
    }
}
