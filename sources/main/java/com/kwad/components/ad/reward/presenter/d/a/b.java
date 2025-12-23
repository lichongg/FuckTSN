package com.kwad.components.ad.reward.presenter.d.a;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.k;
import com.kwad.components.ad.reward.widget.tailframe.TailFrameView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements as.b {

    @Nullable
    private com.kwad.components.ad.l.b dF;
    private AdInfo mAdInfo;
    private DetailVideoView mDetailVideoView;
    private TailFrameView yX;
    private volatile boolean yY;
    private boolean yZ;
    private k za;
    private Drawable zd;
    private boolean wn = false;
    private int zb = Integer.MIN_VALUE;
    private int zc = Integer.MIN_VALUE;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            b.this.jH();
            if (b.this.yX == null || !g.P(b.this.mAdTemplate)) {
                return;
            }
            b.this.yX.la();
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.2
        @Override // com.kwad.components.ad.reward.e.a, com.kwad.components.ad.reward.e.g
        public final int getPriority() {
            return -1;
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            if ((!e.ey(b.this.mAdTemplate) && b.this.wn && !b.this.tm.gQ()) || b.this.tm.sf || b.this.tm.sl) {
                return;
            }
            b.this.yZ = true;
            if (b.this.dF != null && b.this.dF.aW()) {
                b.this.yZ = false;
            }
            b.this.tm.sw = true ^ b.this.yZ;
            if (b.this.yZ) {
                if (b.this.tm.rH != null) {
                    com.kwad.components.ad.reward.monitor.c.a(b.this.tm.mAdTemplate, b.this.tm.rS, "end_card", com.kwad.sdk.core.response.b.b.cK(b.this.mAdTemplate), System.currentTimeMillis() - b.this.tm.rH.getLoadTime(), 1);
                }
                b.this.bn();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z5) {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", (String) null, new com.kwad.sdk.core.adlog.c.b().f(this.tm.mRootContainer.getTouchCoords()).dd(z5 ? 2 : 153), this.tm.mReportExtData);
        this.tm.rD.cW();
    }

    private void ad(int i6) {
        ViewGroup.LayoutParams layoutParams = this.mDetailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i6;
            this.mDetailVideoView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jH() {
        if (this.yY) {
            return;
        }
        jI();
    }

    private void jI() {
        com.kwad.sdk.core.d.c.d("RewardPlayEndNativeCardPresenter", "initTailView");
        this.yX.a(getContext(), this.tm.mScreenOrientation == 0, jK());
        this.yY = true;
    }

    private void jJ() {
        if (this.yZ) {
            jH();
            this.yX.destroy();
            this.yX.setVisibility(8);
            this.za.hide();
        }
    }

    private boolean jK() {
        AdInfo.AdMaterialInfo.MaterialFeature aX = com.kwad.sdk.core.response.b.a.aX(this.mAdInfo);
        return aX.height > aX.width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn() {
        jH();
        this.yX.a(new com.kwad.components.ad.reward.widget.tailframe.b() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.3
            @Override // com.kwad.components.ad.reward.widget.tailframe.b
            public final void O(boolean z5) {
                b.this.L(z5);
            }
        });
        this.yX.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.jshandler.as.b
    public final void a(as.a aVar) {
        this.wn = aVar.isSuccess();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.components.core.playable.a aVar = this.tm.rF;
        if (aVar != null) {
            aVar.a(this);
        }
        this.mAdInfo = e.el(this.mAdTemplate);
        g gVar = this.tm;
        this.dF = gVar.rH;
        gVar.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.gk().a(this.mRewardVerifyListener);
        this.yX.setCallerContext(this.tm);
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playend_native_jinniu);
        if (viewStub != null) {
            this.za = new k(this.tm, viewStub);
        } else {
            this.za = new k(this.tm, (ViewGroup) findViewById(R.id.ksad_reward_jinniu_end_card_root));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.yX = (TailFrameView) findViewById(R.id.ksad_video_tail_frame);
        DetailVideoView detailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView.getLayoutTransition() != null) {
            this.mDetailVideoView.getLayoutTransition().enableTransitionType(4);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.tm.rF;
        if (aVar != null) {
            aVar.b(this);
        }
        com.kwad.components.ad.reward.b.gk().b(this.mRewardVerifyListener);
        jJ();
        this.tm.c(this.mPlayEndPageListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            int i6 = this.zc;
            if (i6 != Integer.MIN_VALUE) {
                detailVideoView.updateTextureViewGravity(i6);
            }
            com.kwad.sdk.core.d.c.d("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.zb);
            int i7 = this.zb;
            if (i7 != Integer.MIN_VALUE) {
                ad(i7);
            }
            Drawable drawable = this.zd;
            if (drawable != null) {
                this.mDetailVideoView.setBackground(drawable);
            }
        }
    }
}
