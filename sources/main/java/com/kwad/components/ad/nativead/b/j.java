package com.kwad.components.ad.nativead.b;

import android.view.View;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j extends com.kwad.components.ad.nativead.a.a {
    private View pS;

    /* JADX INFO: Access modifiers changed from: private */
    public void fG() {
        if (this.pS.getVisibility() == 0) {
            return;
        }
        this.pS.setVisibility(0);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.pS.setVisibility(8);
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.j.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i6, int i7) {
                j.this.fG();
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pq.pr.b((l) mVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pS = findViewById(R.id.ksad_video_error_container);
    }
}
