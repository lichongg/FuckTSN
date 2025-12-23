package xyz.adscope.ad;

import android.content.Context;
import android.view.MotionEvent;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class a6 extends n6 implements j3 {

    /* renamed from: e, reason: collision with root package name */
    protected i3 f54799e;

    @Override // xyz.adscope.ad.j3
    public void a(i3 i3Var) {
        this.f54799e = i3Var;
        RenderModel renderModel = this.f55727b;
        if (renderModel == null || renderModel.b() == null) {
            return;
        }
        this.f54799e.a((i3) this.f55727b.b());
    }

    @Override // xyz.adscope.ad.j3
    public String getActionType() {
        RenderModel renderModel = this.f55727b;
        if (renderModel == null || renderModel.b() == null) {
            return null;
        }
        return this.f55727b.b().e();
    }

    @Override // xyz.adscope.ad.j3
    public String getInteractionType() {
        RenderModel renderModel = this.f55727b;
        if (renderModel == null || renderModel.b() == null) {
            return null;
        }
        return this.f55727b.b().a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i3 i3Var = this.f54799e;
        if (i3Var != null && (i3Var instanceof p1) && ((p1) i3Var).a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public a6(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i3 i3Var = this.f54799e;
        if (i3Var != null) {
            i3Var.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i3 i3Var = this.f54799e;
        if (i3Var != null) {
            i3Var.b();
        }
    }
}
