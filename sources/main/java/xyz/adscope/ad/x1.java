package xyz.adscope.ad;

import android.view.View;
import xyz.adscope.ad.y1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class x1 implements j2<y1, Object, View> {

    /* renamed from: a, reason: collision with root package name */
    private y1 f56118a;

    @Override // xyz.adscope.ad.j2
    public void a() {
    }

    public void a(l2 l2Var, View view) {
        y1 y1Var = this.f56118a;
        if (y1Var == null || !(l2Var instanceof y1.a)) {
            return;
        }
        if (y1.a.AD_CLOSE == l2Var) {
            y1Var.a(l2Var);
        }
        if (y1.a.COMPLAIN_CONFIRM == l2Var) {
            this.f56118a.b(l2Var);
        }
        if (y1.a.AD_CLICK == l2Var) {
            this.f56118a.c(l2Var);
        }
        this.f56118a.a((y1.a) l2Var);
    }

    @Override // xyz.adscope.ad.j2
    public void a(y1 y1Var) {
        this.f56118a = y1Var;
        y1Var.a((y1) this);
    }
}
