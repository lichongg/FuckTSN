package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private AdInfo mAdInfo;
    private ImageView yG;
    private TextView yH;
    private boolean yI = false;
    private View yJ = null;
    private long yK = -1;
    private final m jE = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            if (c.this.yK >= 0) {
                if (j7 > Math.min(Math.min(c.this.yK, com.kwad.sdk.core.response.b.a.ag(c.this.mAdInfo)), j6)) {
                    c.this.jy();
                }
            }
        }
    };
    private final com.kwad.components.ad.reward.e.e kl = new com.kwad.components.ad.reward.e.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.2
        @Override // com.kwad.components.ad.reward.e.e
        public final void dq() {
            c.a(c.this, true);
            c.this.jy();
        }
    };

    static /* synthetic */ boolean a(c cVar, boolean z5) {
        cVar.yI = true;
        return true;
    }

    private void dm() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        this.tm.rE.a(this.jE);
        this.tm.rO.add(this.kl);
        long af = com.kwad.sdk.core.response.b.a.af(this.mAdInfo);
        this.yK = af;
        if (af == 0) {
            this.yJ.setVisibility(0);
        } else {
            this.yJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy() {
        if (this.yJ.getVisibility() == 0) {
            return;
        }
        this.yJ.setAlpha(0.0f);
        this.yJ.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.yJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.yJ) {
            f.a(this.tm, this.yI);
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
        this.yG = (ImageView) findViewById(R.id.ksad_detail_close_btn);
        this.yH = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (!TextUtils.isEmpty(com.kwad.components.ad.reward.a.b.hA())) {
            this.yH.setText(com.kwad.components.ad.reward.a.b.hA());
            this.yJ = this.yH;
        } else {
            if (com.kwad.components.ad.reward.a.b.hz() == 0) {
                this.yG.setImageResource(R.drawable.ksad_page_close);
            } else {
                this.yG.setImageResource(R.drawable.ksad_video_skip_icon);
            }
            this.yJ = this.yG;
        }
        this.yJ.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.jE);
        this.tm.rO.remove(this.kl);
        this.yJ.setVisibility(8);
    }
}
