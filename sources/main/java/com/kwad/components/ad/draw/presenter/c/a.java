package com.kwad.components.ad.draw.presenter.c;

import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.draw.b.a {

    @Nullable
    private com.kwad.components.ad.l.b dF;
    private DrawVideoTailFrame fa;
    private l mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.draw.presenter.c.a.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            if (a.this.dF == null || !a.this.dF.aW()) {
                a.this.bn();
            } else {
                a.this.fa.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bn() {
        this.fa.bW();
        this.fa.setVisibility(0);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.components.ad.draw.b.b bVar = this.dz;
        this.dF = bVar.dF;
        this.fa.j(bVar.mAdTemplate);
        this.fa.setAdBaseFrameLayout(this.dz.mRootContainer);
        this.fa.setApkDownloadHelper(this.dz.mApkDownloadHelper);
        this.fa.setVisibility(8);
        this.fa.setAdInteractionListener(this.dz.dh);
        this.dz.dB.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fa = (DrawVideoTailFrame) findViewById(R.id.ksad_video_tail_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.dz.dB.a(this.mVideoPlayStateListener);
        this.fa.release();
    }
}
