package xyz.adscope.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Locale;
import xyz.adscope.ad.b3;
import xyz.adscope.ad.l3;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.common.v2.thread.timer.cd.PauseAbleCountDown;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class b extends c implements b3 {

    /* renamed from: h, reason: collision with root package name */
    private PauseAbleCountDown f54807h;

    /* renamed from: i, reason: collision with root package name */
    private l3 f54808i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends PauseAbleCountDown {
        a(long j6, long j7) {
            super(j6, j7);
        }

        @Override // xyz.adscope.common.v2.thread.timer.cd.PauseAbleCountDown
        public void onCancel() {
            b.this.e();
        }

        @Override // xyz.adscope.common.v2.thread.timer.cd.PauseAbleCountDown
        public void onFinish() {
            b.this.f();
        }

        @Override // xyz.adscope.common.v2.thread.timer.cd.PauseAbleCountDown
        public void onTick(long j6) {
            b.this.a(j6);
        }
    }

    protected void a(long j6) {
        setText(String.format(Locale.ENGLISH, "%d %s", Integer.valueOf((int) (j6 / 1000)), this.f55254d.f().p()));
    }

    protected void f() {
        l3 l3Var = this.f54808i;
        if (l3Var != null) {
            l3Var.a(this);
        }
    }

    protected int getCountDownTime() {
        RenderModel renderModel = this.f55254d;
        return (renderModel == null || renderModel.b() == null || this.f55254d.b().c() < 1000) ? getDefaultCountDownTime() : this.f55254d.b().c();
    }

    protected int getDefaultCountDownTime() {
        return 5000;
    }

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // xyz.adscope.ad.b3
    public void a(l3 l3Var) {
        this.f54808i = l3Var;
    }

    @Override // xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.c, xyz.adscope.ad.i6, xyz.adscope.ad.b4
    public void b() {
        super.b();
    }

    @Override // xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.c, xyz.adscope.ad.i6, xyz.adscope.ad.b4
    public void c() {
        super.c();
    }

    @Override // xyz.adscope.ad.i6
    protected void d() {
        if (getCountDownTime() > 0) {
            this.f54807h = new a(getCountDownTime() + 500, 1000L);
        } else {
            g();
        }
    }

    @Override // xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.c, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        PauseAbleCountDown pauseAbleCountDown = this.f54807h;
        if (pauseAbleCountDown != null) {
            pauseAbleCountDown.start();
        }
    }

    @Override // xyz.adscope.ad.ad.nativead.render.view.asnp.interaction.c, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PauseAbleCountDown pauseAbleCountDown = this.f54807h;
        if (pauseAbleCountDown != null) {
            pauseAbleCountDown.cancel();
        }
    }

    protected void e() {
    }

    protected void g() {
    }
}
