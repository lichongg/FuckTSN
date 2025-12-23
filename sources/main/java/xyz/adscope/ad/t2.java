package xyz.adscope.ad;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import xyz.adscope.ad.a2;
import xyz.adscope.ad.publish.ad.IAdListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class t2<C extends a2, L extends IAdListener> extends s2<C, L> {

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f55963e;

    @Override // xyz.adscope.ad.s2
    protected final void a(Context context) {
        if (!this.f55933d.f() || !a(this.f55963e)) {
            this.f55933d.b(y0.ERROR_AD_NOT_READY_TO_SHOW);
            return;
        }
        View a6 = this.f55933d.a(false);
        if (a6 != null) {
            this.f55963e.addView(a6);
        }
    }

    public void setAdContainer(ViewGroup viewGroup) {
        this.f55963e = viewGroup;
    }

    public t2(Context context, C c6) {
        super(context, c6);
    }

    private boolean b(ViewGroup viewGroup) {
        if (viewGroup.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private boolean a(ViewGroup viewGroup) {
        return viewGroup != null && b(viewGroup);
    }
}
