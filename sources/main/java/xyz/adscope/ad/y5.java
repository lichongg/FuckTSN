package xyz.adscope.ad;

import android.content.Context;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class y5 extends x5 implements j3 {

    /* renamed from: k, reason: collision with root package name */
    private i3 f56193k;

    @Override // xyz.adscope.ad.j3
    public void a(i3 i3Var) {
        this.f56193k = i3Var;
        RenderModel renderModel = this.f56128h;
        if (renderModel == null || renderModel.b() == null) {
            return;
        }
        this.f56193k.a((i3) this.f56128h.b());
    }

    @Override // xyz.adscope.ad.j3
    public String getActionType() {
        RenderModel renderModel = this.f56128h;
        if (renderModel == null || renderModel.b() == null) {
            return null;
        }
        return this.f56128h.b().e();
    }

    @Override // xyz.adscope.ad.j3
    public String getInteractionType() {
        RenderModel renderModel = this.f56128h;
        if (renderModel == null || renderModel.b() == null) {
            return null;
        }
        return this.f56128h.b().a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i3 i3Var = this.f56193k;
        if (i3Var != null && (i3Var instanceof p1) && ((p1) i3Var).a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public y5(@NonNull Context context) {
        super(context);
    }

    @Override // xyz.adscope.ad.x5, xyz.adscope.ad.b4
    public void b() {
        super.b();
        i3 i3Var = this.f56193k;
        if (i3Var != null && (i3Var instanceof p6)) {
            ((p6) i3Var).j();
        }
    }

    @Override // xyz.adscope.ad.x5, xyz.adscope.ad.b4
    public void c() {
        super.c();
        i3 i3Var = this.f56193k;
        if (i3Var != null && (i3Var instanceof p6)) {
            ((p6) i3Var).i();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i3 i3Var = this.f56193k;
        if (i3Var != null) {
            i3Var.a();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i3 i3Var = this.f56193k;
        if (i3Var != null) {
            i3Var.b();
        }
    }
}
