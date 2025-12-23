package xyz.adscope.ad;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.OptimizeModel;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class f1 extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    protected final OptimizeModel f55130a;

    /* renamed from: b, reason: collision with root package name */
    private i3 f55131b;

    /* renamed from: c, reason: collision with root package name */
    protected View f55132c;

    public void a(i3 i3Var) {
        this.f55131b = i3Var;
        i3Var.a((i3) this.f55130a);
    }

    public void b() {
        i3 i3Var = this.f55131b;
        if (i3Var != null) {
            i3Var.b();
        }
    }

    public void c() {
        i3 i3Var = this.f55131b;
        if (i3Var != null) {
            i3Var.a();
        }
    }

    public f1(@NonNull Context context, OptimizeModel optimizeModel) {
        super(context);
        this.f55130a = optimizeModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view) {
        xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a expressRoot;
        this.f55132c = view;
        if (view instanceof xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a) {
            setTag(ResIdentify.getIDIdentify(getContext(), "scope_root_container"), view);
        } else {
            if (!(view instanceof b4) || (expressRoot = ((b4) view).getExpressRoot()) == null) {
                return;
            }
            setTag(ResIdentify.getIDIdentify(getContext(), "scope_root_container"), expressRoot);
        }
    }

    public void d() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
        i3 i3Var = this.f55131b;
        if (i3Var instanceof x4) {
            ((x4) i3Var).e();
        }
    }

    public void a() {
        i3 i3Var = this.f55131b;
        if (i3Var != null) {
            i3Var.a();
        }
        View view = this.f55132c;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this, this.f55132c.getLayoutParams());
            }
        }
    }
}
