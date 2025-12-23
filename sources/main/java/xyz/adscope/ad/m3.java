package xyz.adscope.ad;

import android.view.View;
import xyz.adscope.ad.n3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class m3 implements j2<n3, Object, View> {

    /* renamed from: a, reason: collision with root package name */
    private n3 f55405a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f55406b = false;

    public void b() {
        this.f55406b = false;
    }

    public void a(Object obj) {
        this.f55406b = false;
    }

    @Override // xyz.adscope.ad.j2
    public void a() {
        this.f55406b = true;
    }

    public void a(l2 l2Var, View view) {
        n3 n3Var;
        if (this.f55406b && (n3Var = this.f55405a) != null && (l2Var instanceof n3.a)) {
            n3Var.a(view, (n3.a) l2Var);
        }
    }

    @Override // xyz.adscope.ad.j2
    public void a(n3 n3Var) {
        this.f55405a = n3Var;
        n3Var.a(this);
    }
}
