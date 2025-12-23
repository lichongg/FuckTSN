package com.amap.api.col.s;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class v3 {

    /* renamed from: a, reason: collision with root package name */
    v3 f8578a;

    public v3() {
    }

    protected abstract boolean c();

    public v3(v3 v3Var) {
        this.f8578a = v3Var;
    }

    public void a(int i6) {
        v3 v3Var = this.f8578a;
        if (v3Var != null) {
            v3Var.a(i6);
        }
    }

    public void b(boolean z5) {
        v3 v3Var = this.f8578a;
        if (v3Var != null) {
            v3Var.b(z5);
        }
    }

    public int d() {
        v3 v3Var = this.f8578a;
        return Math.min(Integer.MAX_VALUE, v3Var != null ? v3Var.d() : Integer.MAX_VALUE);
    }

    public final boolean e() {
        v3 v3Var = this.f8578a;
        if (v3Var != null ? v3Var.e() : true) {
            return c();
        }
        return false;
    }
}
