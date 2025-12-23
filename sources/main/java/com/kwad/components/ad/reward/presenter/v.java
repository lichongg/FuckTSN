package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.aq;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class v extends b {
    private DetailVideoView wV;
    private ViewGroup wW;
    private FrameLayout wX;
    private ImageView wY;
    private ViewGroup.LayoutParams wZ = null;
    private com.kwad.components.core.video.m jE = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.v.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            v.this.wV.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.v.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    v.this.wV.setVisibility(0);
                }
            }, 200L);
        }
    };

    private void iV() {
    }

    private void iW() {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        getContext();
        boolean QW = aq.QW();
        boolean bK = com.kwad.sdk.core.response.b.a.bK(el);
        boolean z5 = true;
        boolean z6 = com.kwad.sdk.core.response.b.a.cJ(el) && com.kwad.components.ad.reward.a.b.hM();
        if (!com.kwad.components.ad.reward.g.N(this.tm.mAdTemplate) && !com.kwad.components.ad.reward.g.O(this.tm.mAdTemplate) && !bK && !z6) {
            z5 = false;
        }
        if (QW || !z5) {
            this.wW.setVisibility(8);
            return;
        }
        this.wW.setVisibility(z6 ? 4 : 0);
        if (bK) {
            this.wY.setVisibility(8);
            ac(R.layout.ksad_playable_end_info);
        } else {
            ac(R.layout.ksad_activity_apk_info_landscape);
        }
        if (com.kwad.sdk.core.response.b.a.aY(el)) {
            this.wV.updateTextureViewGravity(21);
        } else {
            this.wV.updateTextureViewGravity(17);
        }
    }

    private void ac(@LayoutRes int i6) {
        this.wX.addView(com.kwad.sdk.o.m.a(getContext(), i6, this.wX, false), -1, -1);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        iV();
        ViewGroup.LayoutParams layoutParams = this.wV.getLayoutParams();
        if (layoutParams != null) {
            this.wZ = new ViewGroup.LayoutParams(layoutParams);
        }
        this.tm.rE.a(this.jE);
        iW();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wV = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.wW = (ViewGroup) findViewById(R.id.ksad_play_right_area);
        this.wY = (ImageView) findViewById(R.id.ksad_play_right_area_bg_img);
        this.wX = (FrameLayout) findViewById(R.id.ksad_play_right_area_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        super.onUnbind();
        this.tm.rE.b(this.jE);
        if (this.wZ != null && (detailVideoView = this.wV) != null) {
            ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.LayoutParams layoutParams2 = this.wZ;
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
                this.wV.setLayoutParams(layoutParams);
            }
            DetailVideoView detailVideoView2 = this.wV;
            if (detailVideoView2 != null) {
                detailVideoView2.setVisibility(4);
            }
            this.wZ = null;
        }
    }
}
