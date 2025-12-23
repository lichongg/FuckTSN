package com.amap.api.col.p0003l;

import android.content.Context;
import com.stub.StubApp;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class m0 {

    /* renamed from: d, reason: collision with root package name */
    private static m0 f6753d;

    /* renamed from: a, reason: collision with root package name */
    private a8 f6754a;

    /* renamed from: b, reason: collision with root package name */
    private LinkedHashMap<String, b8> f6755b = new LinkedHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private boolean f6756c = true;

    private static void h() {
        f6753d = null;
    }

    private static synchronized m0 f() {
        synchronized (m0.class) {
            try {
                m0 m0Var = f6753d;
                if (m0Var == null) {
                    f6753d = new m0();
                } else if (m0Var.f6754a == null) {
                    m0Var.f6754a = a8.j();
                }
            } finally {
                return f6753d;
            }
        }
        return f6753d;
    }

    private void g() {
        synchronized (this.f6755b) {
            try {
                if (this.f6755b.size() <= 0) {
                    return;
                }
                for (Map.Entry<String, b8> entry : this.f6755b.entrySet()) {
                    entry.getKey();
                    ((i0) entry.getValue()).a();
                }
                this.f6755b.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(l0 l0Var) {
        synchronized (this.f6755b) {
            try {
                i0 i0Var = (i0) this.f6755b.get(l0Var.b());
                if (i0Var == null) {
                    return;
                }
                i0Var.a();
                this.f6755b.remove(l0Var.b());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(l0 l0Var, Context context) throws fk {
        if (!this.f6755b.containsKey(l0Var.b())) {
            i0 i0Var = new i0((c1) l0Var, StubApp.getOrigApplicationContext(context.getApplicationContext()), (byte) 0);
            synchronized (this.f6755b) {
                this.f6755b.put(l0Var.b(), i0Var);
            }
        }
        this.f6754a.b(this.f6755b.get(l0Var.b()));
    }

    public final void e(l0 l0Var) {
        i0 i0Var = (i0) this.f6755b.get(l0Var.b());
        if (i0Var != null) {
            synchronized (this.f6755b) {
                i0Var.b();
                this.f6755b.remove(l0Var.b());
            }
        }
    }

    private m0() {
        try {
            if (this.f6754a == null) {
                this.f6754a = a8.k();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static m0 a() {
        return f();
    }

    public final void d() {
        g();
        this.f6754a.g();
        this.f6754a = null;
        h();
    }
}
