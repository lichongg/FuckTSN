package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class w4 {

    /* renamed from: b, reason: collision with root package name */
    private static w4 f7508b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f7509c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f7510d;

    /* renamed from: a, reason: collision with root package name */
    private Context f7511a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends b8 {
        a() {
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            w4.this.d();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b extends b8 {
        b() {
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            w4.this.f();
        }
    }

    public static w4 a(Context context) {
        if (f7508b == null) {
            synchronized (w4.class) {
                try {
                    if (f7508b == null) {
                        f7508b = new w4(context);
                    }
                } finally {
                }
            }
        }
        return f7508b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            if (f7509c) {
                f7509c = false;
                return;
            }
            f7509c = true;
            u4 u4Var = new u4(this.f7511a);
            new r6();
            z6 d6 = r6.d(u4Var);
            if (d6 != null) {
                JSONObject jSONObject = new JSONObject(q4.g(v4.d(d6.f7800a, q4.u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    r4.m(this.f7511a, u4Var.f7358s);
                    r4.o(this.f7511a, u4Var.f7359t);
                    r4.q(this.f7511a, u4Var.f7360u);
                    r4.s(this.f7511a, u4Var.f7361v);
                    r4.u(this.f7511a, u4Var.f7362w);
                    r4.w(this.f7511a, u4Var.f7363x);
                    r4.y(this.f7511a, u4Var.f7364y);
                    r4.e(this.f7511a, u4Var.A);
                    r4.A(this.f7511a, u4Var.f7365z);
                    r4.b(this.f7511a, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        r4.g(this.f7511a, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        r4.k(this.f7511a, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        r4.i(this.f7511a, optString3);
                    }
                }
            }
            f7509c = false;
        } catch (Throwable unused) {
            f7509c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (f7510d) {
                f7510d = false;
                return;
            }
            f7510d = true;
            x4 x4Var = new x4(this.f7511a);
            new r6();
            z6 d6 = r6.d(x4Var);
            if (d6 != null) {
                JSONObject jSONObject = new JSONObject(q4.g(v4.d(d6.f7800a, q4.u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes())));
                if (jSONObject.optBoolean("suc")) {
                    r4.m(this.f7511a, x4Var.f7659s);
                    r4.o(this.f7511a, x4Var.f7660t);
                    r4.q(this.f7511a, x4Var.f7661u);
                    r4.s(this.f7511a, x4Var.f7662v);
                    r4.u(this.f7511a, x4Var.f7663w);
                    r4.w(this.f7511a, x4Var.f7664x);
                    r4.y(this.f7511a, x4Var.f7665y);
                    r4.e(this.f7511a, x4Var.A);
                    r4.A(this.f7511a, x4Var.f7666z);
                    r4.b(this.f7511a, SystemClock.elapsedRealtime());
                    String optString = jSONObject.optString("aaid", "");
                    String optString2 = jSONObject.optString("resetToken", "");
                    String optString3 = jSONObject.optString("uabc", "");
                    if (!TextUtils.isEmpty(optString)) {
                        r4.g(this.f7511a, optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        r4.k(this.f7511a, optString2);
                    }
                    if (!TextUtils.isEmpty(optString3)) {
                        r4.i(this.f7511a, optString3);
                    }
                }
            }
            f7510d = false;
        } catch (Throwable unused) {
            f7510d = false;
        }
    }

    public final String b() {
        String str = "";
        try {
            if (s4.f7230d) {
                str = r4.f(this.f7511a);
                long h6 = r4.h(this.f7511a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (TextUtils.isEmpty(str)) {
                    a8.h().b(new a());
                    return str;
                }
                if (elapsedRealtime - h6 > s4.f7228b) {
                    a8.h().b(new b());
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    private w4(Context context) {
        this.f7511a = context;
    }
}
