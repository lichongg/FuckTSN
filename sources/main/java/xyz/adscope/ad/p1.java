package xyz.adscope.ad;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.InteractionModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.SlideModel;
import xyz.adscope.ad.n3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class p1 extends g1 {

    /* renamed from: i, reason: collision with root package name */
    private b f55787i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface b {
        boolean a(MotionEvent motionEvent);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final String f55788a;

        /* renamed from: b, reason: collision with root package name */
        private float f55789b;

        /* renamed from: c, reason: collision with root package name */
        private float f55790c;

        /* renamed from: d, reason: collision with root package name */
        private final float f55791d;

        /* synthetic */ c(p1 p1Var, SlideModel slideModel, String str, a aVar) {
            this(slideModel, str);
        }

        private c(SlideModel slideModel, String str) {
            this.f55788a = slideModel.a(str);
            this.f55791d = slideModel.b(str);
        }

        @Override // xyz.adscope.ad.p1.b
        public boolean a(MotionEvent motionEvent) {
            String str;
            if (motionEvent.getAction() == 0) {
                this.f55789b = motionEvent.getX();
                this.f55790c = motionEvent.getY();
            }
            if (motionEvent.getAction() == 1) {
                int scaledTouchSlop = ViewConfiguration.get(p1.this.f55165e.getContext()).getScaledTouchSlop();
                float x5 = motionEvent.getX();
                float y5 = motionEvent.getY();
                float f6 = scaledTouchSlop;
                if ((Math.abs(this.f55789b - x5) > f6 || Math.abs(this.f55790c - y5) > f6) && (Math.abs(this.f55789b - x5) > this.f55791d || Math.abs(this.f55790c - y5) > this.f55791d)) {
                    if (Math.abs(this.f55789b - x5) > Math.abs(this.f55790c - y5)) {
                        if (this.f55789b > x5) {
                            str = "LEFT";
                        } else {
                            str = "RIGHT";
                        }
                    } else if (this.f55790c > y5) {
                        str = "UP";
                    } else {
                        str = "DOWN";
                    }
                    if (str.equalsIgnoreCase(this.f55788a)) {
                        p1.this.e();
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f55787i = null;
        a(n3.a.GESTURE_INTERACTIVE_TRIGGER);
    }

    public boolean a(MotionEvent motionEvent) {
        b bVar = this.f55787i;
        if (bVar != null) {
            return bVar.a(motionEvent);
        }
        return false;
    }

    @Override // xyz.adscope.ad.g1
    protected void d() {
        InteractionModel interactionModel = this.f55167g;
        if (interactionModel == null || interactionModel.k() == null) {
            return;
        }
        x6 orCreateImplement = e7.a().getOrCreateImplement(this.f55163c);
        a aVar = null;
        if (orCreateImplement.a(this.f55167g.i()) || orCreateImplement.a(this.f55168h, this.f55167g.b())) {
            this.f55787i = new c(this, this.f55167g.k(), "Cooling", aVar);
        } else {
            this.f55787i = new c(this, this.f55167g.k(), "Normal", aVar);
        }
    }

    public p1(Context context, String str) {
        super(context, str);
    }
}
