package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.l.b;
import com.kwad.components.ad.reward.presenter.RewardPreEndCardPresenter;
import com.kwad.components.core.j.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class s extends b implements com.kwad.components.ad.reward.e.g, a.InterfaceC0621a, y.b {
    private List<com.kwad.components.core.j.c> bK;

    @Nullable
    private com.kwad.components.ad.reward.d rJ;
    private ImageView vy;
    private KsLogoView wA;
    private DetailVideoView wB;
    private int wC;
    private View wD;
    private FrameLayout wE;
    private Animator wF;
    private Animator wG;
    private Animator wH;
    private AdTemplate wI;
    private boolean wQ;
    private View wz;

    @RewardPreEndCardPresenter.PreEndPageStatus
    private int wy = 1;
    private long wJ = 500;
    private long wK = 50;
    private float wL = 1.2254902f;
    private float wM = 0.80472106f;
    private float wN = 0.0f;
    private boolean wO = false;
    private long showTime = -1;
    private long wP = -1;
    private com.kwad.components.core.video.m jE = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.s.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            s.this.k(j7);
        }
    };
    private com.kwad.sdk.core.webview.d.a.a eT = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.s.5
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar == null || com.kwad.sdk.core.response.b.e.b(s.this.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                s.this.tm.rD.cW();
                return;
            }
            com.kwad.components.core.j.c a6 = com.kwad.components.ad.reward.g.a((List<com.kwad.components.core.j.c>) s.this.bK, aVar.creativeId);
            if (a6 != null) {
                s.this.tm.a(a6);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    private void ab(int i6) {
        ViewGroup.LayoutParams layoutParams = this.wz.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i6;
            layoutParams2.bottomMargin = -i6;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i6);
            layoutParams3.height = i6;
            layoutParams3.bottomMargin = -i6;
            this.wz.setLayoutParams(layoutParams3);
        }
    }

    private int b(float f6) {
        return (int) (f6 + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_height) + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    private void f(List<AdTemplate> list) {
        com.kwad.components.ad.reward.d dVar = new com.kwad.components.ad.reward.d(list, this.tm.mReportExtData, this);
        this.rJ = dVar;
        this.tm.rJ = dVar;
        dVar.setShowLandingPage(com.kwad.sdk.core.response.b.b.cF(this.mAdTemplate));
        this.rJ.a(this.eT);
        com.kwad.components.ad.reward.d dVar2 = this.rJ;
        FrameLayout frameLayout = this.wE;
        com.kwad.components.ad.reward.g gVar = this.tm;
        dVar2.a(frameLayout, gVar.mRootContainer, this.mAdTemplate, gVar.mApkDownloadHelper, gVar.mScreenOrientation);
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "startPreloadWebView");
        this.rJ.a(new b.InterfaceC0573b() { // from class: com.kwad.components.ad.reward.presenter.s.2
            @Override // com.kwad.components.ad.l.b.InterfaceC0573b
            public final void iU() {
                com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "onPreloadSuccess");
                s.this.tm.sl = true;
            }
        });
    }

    private Animator iR() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.wD, "alpha", 255.0f, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j6) {
        AdTemplate adTemplate = this.wI;
        if (adTemplate == null || this.wQ) {
            return;
        }
        if (this.showTime <= 0) {
            this.showTime = com.kwad.sdk.core.response.b.b.cC(adTemplate);
            this.wP = com.kwad.sdk.core.response.b.b.cB(this.wI) + this.showTime;
        }
        long j7 = this.showTime;
        if (j7 > 0 && !this.wO && j6 > j7) {
            this.wQ = !J(true);
            com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "showError: " + this.wQ);
            if (this.wQ) {
                return;
            } else {
                this.wO = true;
            }
        }
        boolean z5 = this.wy == 3;
        long j8 = this.wP;
        if (j8 <= 0 || z5 || j6 <= j8) {
            return;
        }
        K(true);
    }

    @Override // com.kwad.components.core.webview.jshandler.y.b
    public final void W(AdTemplate adTemplate) {
        com.kwad.components.core.j.c cVar = new com.kwad.components.core.j.c(adTemplate, com.kwad.components.core.j.e.AGGREGATION);
        com.kwad.components.ad.reward.g gVar = this.tm;
        if (gVar != null) {
            gVar.b(cVar);
        }
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void cX() {
        int i6;
        if (this.wI == null || (i6 = this.wy) == 3) {
            return;
        }
        if (i6 == 1) {
            J(false);
            K(false);
        } else if (i6 == 2) {
            K(true);
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0621a
    public final void e(@Nullable List<com.kwad.components.core.j.c> list) {
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "onInnerAdLoad: " + list);
        if (list == null || list.size() == 0) {
            return;
        }
        this.wI = list.get(0).getAdTemplate();
        this.bK = list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mAdTemplate);
        arrayList.addAll(com.kwad.components.core.j.c.n(list));
        f(arrayList);
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0621a
    public final void onError(int i6, String str) {
        com.kwad.sdk.core.d.c.w("RewardPreEndCardPresenter", "onError : msg " + str);
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0621a
    public final void onRequestResult(int i6) {
        com.kwad.sdk.core.d.c.w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i6);
    }

    private boolean J(boolean z5) {
        boolean z6;
        int b6 = b(iS());
        ab(b6);
        com.kwad.components.ad.reward.d dVar = this.rJ;
        if (dVar != null) {
            z6 = dVar.aW();
        } else {
            z6 = false;
        }
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "webLoadSuccess: " + z6);
        if (!z6) {
            return false;
        }
        int a6 = a(iS());
        float f6 = -b6;
        this.wN = f6;
        Animator a7 = a(true, f6, a6, true, z5);
        this.wF = a7;
        a7.start();
        Animator iR = iR();
        this.wH = iR;
        iR.start();
        this.wy = 2;
        return true;
    }

    private void K(boolean z5) {
        Animator a6 = a(false, (iS() - iT()) + this.wN, a(iT()), false, z5);
        this.wG = a6;
        a6.start();
        com.kwad.sdk.core.local.a.Hq();
        com.kwad.sdk.core.local.a.ch(this.wI);
        this.wy = 3;
        com.kwad.components.ad.reward.d dVar = this.rJ;
        if (dVar != null) {
            dVar.gu();
        }
    }

    private Animator a(boolean z5, float f6, int i6, boolean z6, boolean z7) {
        ValueAnimator ofFloat;
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f6 + ", videoTargetHeight: " + i6);
        if (z5) {
            ofFloat = ObjectAnimator.ofFloat(this.wz, "translationY", f6);
        } else {
            int height = this.wz.getHeight();
            final ViewGroup.LayoutParams layoutParams = this.wz.getLayoutParams();
            ofFloat = ValueAnimator.ofFloat(height, Math.abs(f6));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    s.this.wz.setLayoutParams(layoutParams);
                }
            });
        }
        ObjectAnimator ofFloat2 = z6 ? ObjectAnimator.ofFloat(this.wA, "alpha", 0.0f, 255.0f) : null;
        final ViewGroup.LayoutParams layoutParams2 = this.vy.getLayoutParams();
        ValueAnimator a6 = this.wB.a(this.mAdTemplate, i6, new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                if (layoutParams3 != null) {
                    layoutParams3.height = intValue;
                    s.this.vy.setLayoutParams(layoutParams2);
                }
            }
        });
        long j6 = z7 ? this.wJ : this.wK;
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j6);
        animatorSet.setInterpolator(create);
        if (ofFloat2 != null) {
            if (z7) {
                animatorSet.playTogether(ofFloat, ofFloat2, a6);
                return animatorSet;
            }
            animatorSet.playTogether(ofFloat, ofFloat2);
            return animatorSet;
        }
        if (z7) {
            animatorSet.playTogether(ofFloat, a6);
            return animatorSet;
        }
        animatorSet.playTogether(ofFloat);
        return animatorSet;
    }

    private float iS() {
        return com.kwad.sdk.c.a.a.f(getActivity()) / this.wL;
    }

    private float iT() {
        return com.kwad.sdk.c.a.a.f(getActivity()) / this.wM;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.rE.a(this.jE);
        this.tm.b((com.kwad.components.ad.reward.e.g) this);
        this.tm.a(this);
        this.wC = com.kwad.sdk.c.a.a.J(this.wB);
        com.kwad.sdk.c.a.a.n(this.wB, 49);
        this.wA.aP(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wz = findViewById(R.id.ksad_middle_end_card);
        this.wB = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.wA = (KsLogoView) findViewById(R.id.ksad_splash_logo_container);
        this.vy = (ImageView) findViewById(R.id.ksad_blur_video_cover);
        this.wD = findViewById(R.id.ksad_play_web_card_webView);
        this.wE = (FrameLayout) findViewById(R.id.ksad_middle_end_card_webview_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.g gVar = this.tm;
        gVar.sl = false;
        gVar.rE.b(this.jE);
        this.tm.c(this);
        this.tm.b((a.InterfaceC0621a) this);
        com.kwad.components.ad.reward.d dVar = this.rJ;
        if (dVar != null) {
            dVar.ny();
        }
        Animator animator = this.wH;
        if (animator != null) {
            animator.cancel();
        }
        DetailVideoView detailVideoView = this.wB;
        if (detailVideoView != null) {
            com.kwad.sdk.c.a.a.n(detailVideoView, this.wC);
        }
        Animator animator2 = this.wF;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.wH = null;
        this.wF = null;
    }

    private int a(float f6) {
        return (int) (com.kwad.sdk.c.a.a.g(getActivity()) - f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
