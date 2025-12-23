package com.amap.api.col.s;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class o1 {

    /* renamed from: b, reason: collision with root package name */
    private static o1 f8289b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f8290c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f8291d;

    /* renamed from: a, reason: collision with root package name */
    private Context f8292a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends z3 {
        a() {
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            o1.this.d();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b extends z3 {
        b() {
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            o1.this.f();
        }
    }

    public static o1 a(Context context) {
        if (f8289b == null) {
            synchronized (o1.class) {
                try {
                    if (f8289b == null) {
                        f8289b = new o1(context);
                    }
                } finally {
                }
            }
        }
        return f8289b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            if (f8290c) {
                f8290c = false;
                return;
            }
            f8290c = true;
            m1 m1Var = new m1(this.f8292a);
            new u2();
            b3 d6 = u2.d(m1Var);
            if (d6 != null) {
                JSONObject jSONObject = new JSONObject(j1.g(n1.d(d6.f7876a, j1.t("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    k1.m(this.f8292a, m1Var.f8242n);
                    k1.o(this.f8292a, m1Var.f8243o);
                    k1.q(this.f8292a, m1Var.f8244p);
                    k1.s(this.f8292a, m1Var.f8245q);
                    k1.u(this.f8292a, m1Var.f8246r);
                    k1.w(this.f8292a, m1Var.f8247s);
                    k1.y(this.f8292a, m1Var.f8248t);
                    k1.e(this.f8292a, m1Var.f8250v);
                    k1.A(this.f8292a, m1Var.f8249u);
                    k1.b(this.f8292a, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        k1.g(this.f8292a, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        k1.k(this.f8292a, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        k1.i(this.f8292a, optString3);
                    }
                }
            }
            f8290c = false;
        } catch (Throwable unused) {
            f8290c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (f8291d) {
                f8291d = false;
                return;
            }
            f8291d = true;
            p1 p1Var = new p1(this.f8292a);
            new u2();
            b3 d6 = u2.d(p1Var);
            if (d6 != null) {
                JSONObject jSONObject = new JSONObject(j1.g(n1.d(d6.f7876a, j1.t("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    k1.m(this.f8292a, p1Var.f8316n);
                    k1.o(this.f8292a, p1Var.f8317o);
                    k1.q(this.f8292a, p1Var.f8318p);
                    k1.s(this.f8292a, p1Var.f8319q);
                    k1.u(this.f8292a, p1Var.f8320r);
                    k1.w(this.f8292a, p1Var.f8321s);
                    k1.y(this.f8292a, p1Var.f8322t);
                    k1.e(this.f8292a, p1Var.f8324v);
                    k1.A(this.f8292a, p1Var.f8323u);
                    k1.b(this.f8292a, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        k1.g(this.f8292a, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        k1.k(this.f8292a, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        k1.i(this.f8292a, optString3);
                    }
                }
            }
            f8291d = false;
        } catch (Throwable unused) {
            f8291d = false;
        }
    }

    public final String b() {
        String str = "";
        try {
            if (l1.f8228d) {
                str = k1.f(this.f8292a);
                long h6 = k1.h(this.f8292a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (TextUtils.isEmpty(str)) {
                    y3.e().c(new a());
                    return str;
                }
                if (elapsedRealtime - h6 > l1.f8226b) {
                    y3.e().c(new b());
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    private o1(Context context) {
        this.f8292a = context;
    }
}
