package com.kwad.components.ad.nativead.b;

import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.api.KsNativeAd;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e extends com.kwad.components.ad.nativead.a.a {
    private boolean eD = false;
    private KsNativeAd.VideoPlayListener oQ;

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.oQ = this.pq.oQ;
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.e.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                if (e.this.oQ != null) {
                    e.this.oQ.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i6, int i7) {
                if (e.this.oQ != null) {
                    e.this.oQ.onVideoPlayError(i6, i7);
                }
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                if (e.this.oQ != null) {
                    e.this.oQ.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayPaused() {
                super.onMediaPlayPaused();
                if (e.this.oQ != null) {
                    try {
                        e.this.oQ.onVideoPlayPause();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    }
                }
                e.this.eD = true;
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                if (e.this.eD) {
                    e.this.eD = false;
                    if (e.this.oQ != null) {
                        try {
                            e.this.oQ.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPrepared() {
                super.onMediaPrepared();
                if (e.this.oQ != null) {
                    try {
                        e.this.oQ.onVideoPlayReady();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    }
                }
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pq.pr.b((l) mVar);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
