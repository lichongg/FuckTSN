package com.kwad.components.ad.fullscreen.c.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView ki;
    private TextView kj;
    private View kk = null;
    private com.kwad.components.ad.reward.e.e kl = new com.kwad.components.ad.reward.e.e() { // from class: com.kwad.components.ad.fullscreen.c.a.d.1
        @Override // com.kwad.components.ad.reward.e.e
        public final void dq() {
            d.this.dp();
        }
    };
    private m jE = new m() { // from class: com.kwad.components.ad.fullscreen.c.a.d.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            d.this.k(j7);
        }
    };

    private void dm() {
        this.tm.rE.a(this.jE);
        this.tm.rO.add(this.kl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp() {
        if (this.kk.getVisibility() == 0) {
            return;
        }
        this.kk.setAlpha(0.0f);
        this.kk.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.kk.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.kk.setOnClickListener(this);
    }

    public final void k(long j6) {
        if (j6 >= com.kwad.sdk.core.response.b.a.al(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate))) {
            dp();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.kk) {
            com.kwad.components.ad.reward.presenter.f.a(this.tm, false);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        dm();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ki = (ImageView) findViewById(R.id.ksad_skip_icon);
        this.kj = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (!TextUtils.isEmpty(com.kwad.components.ad.fullscreen.a.b.cZ())) {
            this.kj.setText(com.kwad.components.ad.fullscreen.a.b.cZ());
            this.ki.setVisibility(8);
            this.kk = this.kj;
        } else {
            if (com.kwad.components.ad.fullscreen.a.b.cY() == 0) {
                this.ki.setImageResource(R.drawable.ksad_page_close);
            } else {
                this.ki.setImageResource(R.drawable.ksad_video_skip_icon);
            }
            this.kj.setVisibility(8);
            this.kk = this.ki;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rO.remove(this.kl);
        this.tm.rE.b(this.jE);
    }
}
