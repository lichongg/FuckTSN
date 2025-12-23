package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ca;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, ca.a {
    private static final String[] yB = {"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};
    private ca bQ;
    private TextView jV;
    private boolean jX;
    private long jY;
    private AdInfo mAdInfo;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private TextView yx;
    private ImageView yy;
    private View yz;
    private boolean yA = false;
    private boolean yC = false;
    private boolean yD = false;
    private final m jE = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            long a6 = g.a(j6, a.this.mAdInfo);
            a.this.jY = j7;
            a.this.a(a6, j7);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (!a.this.jX) {
                a.this.bQ.sendEmptyMessageDelayed(1, 500L);
            }
        }
    };
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.2
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            a.a(a.this, true);
            a.this.yx.setText(a.yB[2]);
        }
    };

    private void G(int i6) {
        this.tm.so = i6;
        if (!g.P(this.mAdTemplate)) {
            this.jV.setText(String.valueOf(i6));
        } else {
            if (this.yC) {
                return;
            }
            this.yx.setText(String.format(yB[0], Integer.valueOf(i6)));
        }
    }

    private void dm() {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        this.mAdInfo = el;
        this.mApkDownloadHelper = this.tm.mApkDownloadHelper;
        long a6 = g.a(com.kwad.sdk.core.response.b.a.M(el), this.mAdInfo) / 1000;
        if (g.P(this.mAdTemplate)) {
            this.yz.setVisibility(0);
            this.yz.setOnClickListener(this);
            this.yx.setText(String.format(yB[0], Long.valueOf(a6)));
            this.jV.setVisibility(8);
        } else {
            this.yz.setVisibility(8);
            this.jV.setText(String.valueOf(a6));
            this.jV.setVisibility(0);
            this.jV.setAlpha(1.0f);
        }
        com.kwad.components.ad.reward.b.gk().a(this.mRewardVerifyListener);
        this.tm.rE.a(this.jE);
    }

    private void jv() {
        if (this.yA) {
            return;
        }
        this.yA = true;
        this.yy.setAlpha(0.0f);
        this.yy.setVisibility(0);
        this.yy.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a.this.jV.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.jV.setAlpha(1.0f - floatValue);
                a.this.yy.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    private void jw() {
        com.kwad.components.ad.reward.e.d dVar = this.tm.mAdRewardStepListener;
        if (dVar != null) {
            dVar.gp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", "playTopBar-style1", new com.kwad.sdk.core.adlog.c.b().f(this.tm.mRootContainer.getTouchCoords()).dd(41), this.tm.mReportExtData);
        this.tm.rD.cW();
    }

    private void notifyRewardVerify() {
        this.tm.rD.onRewardVerify();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.yy || view == this.yz) {
            com.kwad.components.core.e.d.a.a(new a.C0616a(view.getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aB(2).A(this.tm.rE.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    static /* synthetic */ boolean a(a aVar, boolean z5) {
        aVar.yC = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.bQ = new ca(this);
        dm();
        if (this.tm.rE.kW()) {
            G((int) (com.kwad.sdk.core.response.b.a.ag(this.mAdInfo) / 1000.0f));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jV = (TextView) findViewById(R.id.ksad_video_count_down);
        this.yy = (ImageView) findViewById(R.id.ksad_detail_reward_icon);
        this.yx = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down);
        this.yz = findViewById(R.id.ksad_detail_reward_deep_task_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.gk().b(this.mRewardVerifyListener);
        this.tm.rE.b(this.jE);
        this.yy.setVisibility(8);
        this.yz.setVisibility(8);
        this.yA = false;
        this.yC = false;
        this.jX = false;
    }

    public final void a(long j6, long j7) {
        int aK;
        if (com.kwad.sdk.core.response.b.a.aO(this.mAdInfo) && com.kwad.components.core.r.a.sF().sG() == 0) {
            aK = com.kwad.sdk.core.response.b.a.aM(this.mAdInfo);
        } else {
            aK = com.kwad.sdk.core.response.b.a.aK(this.mAdInfo);
        }
        g gVar = this.tm;
        long j8 = aK * (gVar.rV ? 1000 : 0);
        com.kwad.components.ad.reward.m.b(gVar, j7, j6, j8);
        if (!this.yD) {
            this.yD = k.a(this.tm, j7, j6, j8);
        }
        a(j7, j6, j8);
    }

    private void a(long j6, long j7, long j8) {
        com.kwad.components.ad.reward.l.a.a aVar;
        com.kwad.components.ad.reward.l.b.a aVar2;
        if (j6 < (j7 - 800) - j8) {
            int floor = (int) Math.floor((j7 - j6) / 1000.0f);
            int i6 = floor > 0 ? floor : 1;
            G(i6);
            p pVar = this.tm.se;
            if (pVar != null) {
                pVar.ah(i6);
                return;
            }
            return;
        }
        this.tm.rY = true;
        if (g.P(this.mAdTemplate)) {
            if (g.N(this.mAdTemplate) && (aVar2 = this.tm.sm) != null) {
                if (!aVar2.kL()) {
                    this.tm.sm.kK();
                }
            } else if (g.O(this.mAdTemplate) && (aVar = this.tm.sn) != null && !aVar.kL()) {
                this.tm.sn.kK();
            }
            if (this.yC) {
                return;
            }
            this.yx.setText(yB[1]);
            jw();
            return;
        }
        notifyRewardVerify();
        jv();
        p pVar2 = this.tm.se;
        if (pVar2 != null) {
            pVar2.ah(0);
        }
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (!this.tm.gV() && !this.tm.gU()) {
                this.jY += 500;
                a(com.kwad.sdk.core.response.b.a.ag(this.mAdInfo), this.jY);
                this.bQ.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.bQ.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
