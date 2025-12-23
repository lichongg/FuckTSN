package com.kwad.components.ad.nativead.b;

import android.widget.ProgressBar;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k extends com.kwad.components.ad.nativead.a.a {
    private ProgressBar pU;

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i6) {
        this.pU.setProgress(i6);
        if (this.pU.getVisibility() == 0) {
            return;
        }
        this.pU.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fH() {
        if (this.pU.getVisibility() != 0) {
            return;
        }
        this.pU.setVisibility(8);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.pU.setProgress(0);
        this.pU.setVisibility(8);
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.k.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                k.this.fH();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i6, int i7) {
                k.this.fH();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j6, long j7) {
                k.this.U(j6 != 0 ? (int) ((j7 * 100.0f) / j6) : 0);
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pq.pr.b((l) mVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pU = (ProgressBar) findViewById(R.id.ksad_video_progress);
    }
}
