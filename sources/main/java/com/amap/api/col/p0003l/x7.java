package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class x7 {

    /* renamed from: a, reason: collision with root package name */
    x7 f7672a;

    public x7() {
    }

    protected abstract boolean d();

    public x7(x7 x7Var) {
        this.f7672a = x7Var;
    }

    public int a() {
        x7 x7Var = this.f7672a;
        return Math.min(Integer.MAX_VALUE, x7Var != null ? x7Var.a() : Integer.MAX_VALUE);
    }

    public void b(int i6) {
        x7 x7Var = this.f7672a;
        if (x7Var != null) {
            x7Var.b(i6);
        }
    }

    public void c(boolean z5) {
        x7 x7Var = this.f7672a;
        if (x7Var != null) {
            x7Var.c(z5);
        }
    }

    public final boolean e() {
        x7 x7Var = this.f7672a;
        if (x7Var != null ? x7Var.e() : true) {
            return d();
        }
        return false;
    }
}
