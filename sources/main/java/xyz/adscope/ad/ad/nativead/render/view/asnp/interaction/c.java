package xyz.adscope.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import xyz.adscope.ad.i3;
import xyz.adscope.ad.i6;
import xyz.adscope.ad.j3;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.ad.p1;
import xyz.adscope.ad.p6;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class c extends i6 implements j3 {

    /* renamed from: g, reason: collision with root package name */
    private i3 f54810g;

    @Override // xyz.adscope.ad.j3
    public void a(i3 i3Var) {
        this.f54810g = i3Var;
        RenderModel renderModel = this.f55254d;
        if (renderModel == null || renderModel.b() == null) {
            return;
        }
        this.f54810g.a((i3) this.f55254d.b());
    }

    @Override // xyz.adscope.ad.j3
    public String getActionType() {
        RenderModel renderModel = this.f55254d;
        if (renderModel == null || renderModel.b() == null) {
            return null;
        }
        return this.f55254d.b().e();
    }

    @Override // xyz.adscope.ad.j3
    public String getInteractionType() {
        RenderModel renderModel = this.f55254d;
        if (renderModel == null || renderModel.b() == null) {
            return null;
        }
        return this.f55254d.b().a();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i3 i3Var = this.f54810g;
        if (i3Var != null && (i3Var instanceof p1) && ((p1) i3Var).a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public c(@NonNull Context context) {
        super(context);
    }

    @Override // xyz.adscope.ad.i6, xyz.adscope.ad.b4
    public void b() {
        super.b();
        i3 i3Var = this.f54810g;
        if (i3Var != null && (i3Var instanceof p6)) {
            ((p6) i3Var).j();
        }
    }

    @Override // xyz.adscope.ad.i6, xyz.adscope.ad.b4
    public void c() {
        super.c();
        i3 i3Var = this.f54810g;
        if (i3Var != null && (i3Var instanceof p6)) {
            ((p6) i3Var).i();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i3 i3Var = this.f54810g;
        if (i3Var != null) {
            i3Var.a();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i3 i3Var = this.f54810g;
        if (i3Var != null) {
            i3Var.b();
        }
    }
}
