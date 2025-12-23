package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private View zj;
    private boolean zk;
    private final Runnable zl = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.d.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                return;
            }
            b.this.jP();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void jP() {
        com.kwad.sdk.core.d.c.d("RewardPlayEndCloseBtn", "showPageCloseBtn mPlayEndH5ShowSuccess: " + this.tm.sw + ", needHideCloseButton: " + this.zk);
        if (this.tm.sw && this.zk) {
            return;
        }
        this.zj.setVisibility(0);
        this.zj.setAlpha(0.0f);
        this.zj.animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void jO() {
        g gVar = this.tm;
        if (gVar.sf) {
            return;
        }
        long j6 = gVar.sq;
        if (j6 == 0) {
            this.zl.run();
        } else {
            bw.runOnUiThreadDelay(this.zl, j6);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.zj) {
            PlayableSource gP = this.tm.gP();
            if (gP == null || !(gP.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || gP.equals(PlayableSource.PENDANT_CLICK_AUTO) || gP.equals(PlayableSource.PENDANT_AUTO) || gP.equals(PlayableSource.ACTIONBAR_CLICK))) {
                f.v(this.tm);
            } else {
                com.kwad.components.ad.reward.a.gg().gh();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.zk = com.kwad.sdk.core.response.b.b.el(e.el(this.tm.mAdTemplate));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View findViewById = findViewById(R.id.ksad_end_close_btn);
        this.zj = findViewById;
        findViewById.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.zj.setVisibility(8);
        bw.c(this.zl);
    }
}
