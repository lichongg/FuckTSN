package xyz.adscope.ad;

import android.content.Context;
import java.util.Map;
import xyz.adscope.ad.a2;
import xyz.adscope.ad.publish.ad.IAdListener;
import xyz.adscope.ad.publish.ad.IBidding;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class s2<C extends a2, L extends IAdListener> extends c2<C, L> implements IBidding {

    /* renamed from: d, reason: collision with root package name */
    protected final l1<C, L> f55933d;

    protected void a(Context context) {
        if (context == null || !this.f55933d.f()) {
            return;
        }
        this.f55933d.a(true);
        this.f55933d.b(context);
    }

    public void destroyAd() {
        l1<C, L> l1Var = this.f55933d;
        if (l1Var != null) {
            l1Var.j();
        }
    }

    @Override // xyz.adscope.ad.publish.ad.IBidding
    public int getECPM() {
        l1<C, L> l1Var = this.f55933d;
        if (l1Var != null) {
            return l1Var.k();
        }
        return 0;
    }

    @Override // xyz.adscope.ad.publish.ad.IBidding
    public void notifyBidLose(Map<String, String> map) {
        l1<C, L> l1Var = this.f55933d;
        if (l1Var != null) {
            l1Var.a(map);
        }
    }

    @Override // xyz.adscope.ad.publish.ad.IBidding
    public void notifyBidWin(Map<String, String> map) {
        l1<C, L> l1Var = this.f55933d;
        if (l1Var != null) {
            l1Var.b(map);
        }
    }

    public void onActivityPause() {
        l1<C, L> l1Var = this.f55933d;
        if (l1Var != null) {
            l1Var.l();
        }
    }

    public void onActivityResume() {
        l1<C, L> l1Var = this.f55933d;
        if (l1Var != null) {
            l1Var.m();
        }
    }

    public s2(Context context, C c6) {
        super(context, c6);
        this.f55933d = (l1) super.a();
    }
}
