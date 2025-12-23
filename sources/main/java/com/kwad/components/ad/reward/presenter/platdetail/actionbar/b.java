package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.n.h;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarH5;
import com.kwad.components.core.t.o;
import com.kwad.components.core.video.m;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {

    @Nullable
    private ValueAnimator eX;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private RewardActionBarControl rG;
    private KsLogoView vN;
    private ActionBarAppLandscape xO;
    private ActionBarAppPortrait xP;
    private ActionBarH5 xQ;
    private boolean xS;

    @Nullable
    private ViewGroup xT;

    @Nullable
    private ViewGroup xU;

    @Nullable
    private ViewGroup xV;
    private h xW;
    private boolean xX;
    private boolean xR = false;
    private final m vR = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.xX = true;
            if (com.kwad.sdk.core.response.b.a.cR(b.this.mAdInfo) && b.this.xV != null) {
                b.this.xV.setVisibility(8);
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.xX = false;
            if (com.kwad.sdk.core.response.b.a.cR(b.this.mAdInfo) && b.this.xV != null) {
                b.this.xV.setVisibility(0);
            }
        }
    };
    private RewardActionBarControl.b xY = new RewardActionBarControl.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.4
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public final void a(boolean z5, a aVar) {
            b.this.xS = true;
            b.this.a(z5, aVar);
        }
    };
    private g xZ = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.5
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            b.this.xS = false;
            b.this.M(false);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void M(boolean z5) {
        if (this.xR) {
            this.xR = false;
            this.vN.setVisibility(8);
            ViewGroup viewGroup = this.xT;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.xV;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            if (!com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
                if (z5) {
                    h(this.xQ, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
                    return;
                } else {
                    this.xQ.setVisibility(8);
                    return;
                }
            }
            if (this.tm.mScreenOrientation == 1) {
                if (z5) {
                    jh();
                    return;
                } else {
                    ji();
                    return;
                }
            }
            if (z5) {
                ActionBarAppPortrait actionBarAppPortrait = this.xP;
                if (actionBarAppPortrait != null) {
                    h(actionBarAppPortrait, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
                    return;
                }
                return;
            }
            ActionBarAppPortrait actionBarAppPortrait2 = this.xP;
            if (actionBarAppPortrait2 != null) {
                actionBarAppPortrait2.setVisibility(8);
            }
        }
    }

    private void bl() {
        ValueAnimator valueAnimator = this.eX;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.eX.cancel();
        }
    }

    private void d(boolean z5, a aVar) {
        this.xQ.a(this.mAdTemplate, new ActionBarH5.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.10
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
            public final void O(boolean z6) {
                b.this.N(z6);
            }
        });
        if (z5) {
            g(this.xQ, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.xQ.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.xQ, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void dm() {
        if (com.kwad.sdk.core.response.b.a.cL(this.mAdInfo)) {
            this.xT = (ViewGroup) findViewById(R.id.ksad_reward_jinniu_root);
        }
        this.vN.aP(this.mAdTemplate);
        com.kwad.components.ad.reward.g gVar = this.tm;
        this.mApkDownloadHelper = gVar.mApkDownloadHelper;
        RewardActionBarControl rewardActionBarControl = gVar.rG;
        this.rG = rewardActionBarControl;
        rewardActionBarControl.a(this.xY);
        this.tm.b(this.xZ);
    }

    private void f(final View view, int i6) {
        bl();
        view.setVisibility(0);
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ValueAnimator c6 = o.c(view, i6, 0);
        this.eX = c6;
        c6.setInterpolator(create);
        this.eX.setDuration(500L);
        this.eX.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.eX.start();
    }

    @Deprecated
    private void g(final View view, int i6) {
        bl();
        view.setVisibility(0);
        ValueAnimator b6 = o.b(view, 0, i6);
        this.eX = b6;
        b6.setInterpolator(new DecelerateInterpolator(2.0f));
        this.eX.setDuration(500L);
        this.eX.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.eX.start();
    }

    private void h(final View view, int i6) {
        bl();
        view.setVisibility(0);
        ValueAnimator b6 = o.b(view, i6, 0);
        this.eX = b6;
        b6.setInterpolator(new DecelerateInterpolator(2.0f));
        this.eX.setDuration(300L);
        this.eX.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        this.eX.start();
    }

    private void jf() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar_landscape);
        if (viewStub != null) {
            this.xO = (ActionBarAppLandscape) viewStub.inflate();
        } else {
            this.xO = (ActionBarAppLandscape) findViewById(R.id.ksad_video_play_bar_app_landscape);
        }
    }

    private void jg() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar);
        if (viewStub != null) {
            this.xP = (ActionBarAppPortrait) viewStub.inflate();
        } else {
            this.xP = (ActionBarAppPortrait) findViewById(R.id.ksad_video_play_bar_app_portrait);
        }
    }

    private void ji() {
        ActionBarAppPortrait actionBarAppPortrait = this.xP;
        if (actionBarAppPortrait != null) {
            actionBarAppPortrait.setVisibility(8);
        }
    }

    protected final void N(boolean z5) {
        com.kwad.sdk.core.adlog.c.b dd = new com.kwad.sdk.core.adlog.c.b().f(this.tm.mRootContainer.getTouchCoords()).dd(z5 ? 1 : 153);
        com.kwad.components.ad.reward.g gVar = this.tm;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, "native_id", (String) null, dd, gVar.mReportExtData);
        this.tm.rD.cW();
    }

    private void b(boolean z5, a aVar) {
        jf();
        this.xO.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppLandscape.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.8
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
            public final void O(boolean z6) {
                b.this.N(z6);
            }
        });
        if (z5) {
            g(this.xO, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.xO.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.xO, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void c(boolean z5, a aVar) {
        jg();
        this.xP.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortrait.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.9
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
            public final void O(boolean z6) {
                b.this.N(z6);
            }
        });
        if (z5) {
            g(this.xP, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.xP.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.xP, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void jh() {
        jg();
        g(this.xP, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        AdTemplate adTemplate = this.tm.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.tm.rE.a(this.vR);
        dm();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vN = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
        this.xQ = (ActionBarH5) findViewById(R.id.ksad_video_play_bar_h5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.rG;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.b) null);
        }
        this.tm.rE.b(this.vR);
        this.tm.c(this.xZ);
        bl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z5, a aVar) {
        ViewGroup viewGroup;
        if (this.xR) {
            return;
        }
        this.xR = true;
        this.vN.setVisibility(com.kwad.sdk.core.response.b.a.cR(this.mAdInfo) ? 8 : 0);
        getContext();
        final boolean z6 = !aq.QW();
        if (com.kwad.sdk.core.response.b.a.bd(this.mAdInfo)) {
            if (this.xW == null) {
                h hVar = new h() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.6
                    @Override // com.kwad.components.ad.reward.n.h
                    public final int jj() {
                        return z6 ? R.id.ksad_common_app_card_land_stub : super.jj();
                    }
                };
                this.xW = hVar;
                hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.7
                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jk() {
                        b.this.tm.a(1, b.this.getContext(), 29, 1);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jl() {
                        b.this.tm.a(1, b.this.getContext(), 30, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jm() {
                        b.this.tm.a(1, b.this.getContext(), 31, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jn() {
                        b.this.tm.a(1, b.this.getContext(), 32, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jo() {
                        b.this.tm.a(1, b.this.getContext(), 84, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jp() {
                        b.this.tm.a(1, b.this.getContext(), 53, 2);
                    }
                });
                this.xW.f((ViewGroup) getRootView());
                this.xW.b(r.a(this.mAdTemplate, this.mApkDownloadHelper));
            }
            this.xW.show();
            RewardActionBarControl.a(aVar, this.xW.hP(), RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.ch(this.mAdInfo) == 1 && (viewGroup = this.xT) != null) {
            viewGroup.setVisibility(0);
            RewardActionBarControl.a(aVar, this.xT, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_JINNIU);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cR(this.mAdInfo)) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.ksad_reward_origin_live_root);
            this.xV = viewGroup2;
            if (viewGroup2 != null) {
                if (!this.xX) {
                    viewGroup2.setVisibility(0);
                }
                RewardActionBarControl.a(aVar, this.xV, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORIGIN_LIVE);
                return;
            }
        }
        if (com.kwad.sdk.core.response.b.a.co(this.mAdTemplate)) {
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.ksad_reward_live_subscribe_root);
            this.xU = viewGroup3;
            if (viewGroup3 != null) {
                Resources resources = viewGroup3.getResources();
                f(this.xU, (int) (resources.getDimension(R.dimen.ksad_live_subscribe_card_full_height) + resources.getDimension(R.dimen.ksad_live_subscribe_card_margin)));
                RewardActionBarControl.a(aVar, this.xU, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_LIVE_SUBSCRIBE);
                return;
            }
        }
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            if (this.tm.mScreenOrientation == 1) {
                b(z5, aVar);
                return;
            } else {
                c(z5, aVar);
                return;
            }
        }
        d(z5, aVar);
    }
}
