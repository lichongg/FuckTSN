package xyz.adscope.ad;

import xyz.adscope.ad.z3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class y3 implements j2<z3, Object, o2> {

    /* renamed from: a, reason: collision with root package name */
    private z3 f56191a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f56192b = false;

    public void b() {
        this.f56192b = false;
        this.f56191a = null;
    }

    public void a(Object obj) {
        this.f56192b = false;
    }

    @Override // xyz.adscope.ad.j2
    public void a() {
        this.f56192b = true;
    }

    public void a(l2 l2Var, o2 o2Var) {
        z3 z3Var;
        if (!this.f56192b || (z3Var = this.f56191a) == null) {
            return;
        }
        if (l2Var == z3.a.RENDER_FAILED) {
            z3Var.renderFailed();
        }
        if (l2Var == z3.a.RENDER_SUCCESS) {
            this.f56191a.a();
        }
        if (l2Var == z3.a.SINGLE_VIEW_RENDERED) {
            this.f56191a.a(o2Var);
        }
    }

    @Override // xyz.adscope.ad.j2
    public void a(z3 z3Var) {
        this.f56191a = z3Var;
        z3Var.a((z3) this);
    }
}
