package com.kwad.components.ad.draw.presenter.a;

import android.view.View;
import com.kwad.components.core.video.m;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.widget.l;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.draw.b.a {
    private List<Integer> ck;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private boolean eD = false;
    private volatile boolean eE = false;
    private l eF = new l() { // from class: com.kwad.components.ad.draw.presenter.a.a.1
        @Override // com.kwad.sdk.widget.l
        public final void aT() {
            n.eM(a.this.mAdTemplate);
        }
    };
    private com.kwad.components.core.video.l mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.draw.presenter.a.a.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            c.bY(a.this.mAdTemplate);
            if (a.this.dz.dh != null) {
                try {
                    a.this.dz.dh.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            a.this.c(j7);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            a.this.eE = false;
            if (!a.this.mAdTemplate.mPvReported && a.this.dz.dh != null) {
                a.this.dz.dh.onAdShow();
                com.kwad.components.ad.draw.a.c.a(a.this.mAdTemplate, 1, b.de(a.this.mAdTemplate) ? 2 : 1);
            }
            if (a.this.dz.dh != null) {
                try {
                    a.this.dz.dh.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
                a.this.eD = false;
            }
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            bVar.b(new a.C0675a());
            com.kwad.components.core.t.b.sY().a(a.this.mAdTemplate, null, bVar);
            c.bX(a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i6, int i7) {
            super.onMediaPlayError(i6, i7);
            if (a.this.dz.dh != null) {
                try {
                    a.this.dz.dh.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            if (a.this.dz.dh != null) {
                try {
                    a.this.dz.dh.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
            a.this.eD = true;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (a.this.eD) {
                a.this.eD = false;
                if (a.this.dz.dh != null) {
                    try {
                        a.this.dz.dh.onVideoPlayResume();
                        return;
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        return;
                    }
                }
                return;
            }
            if (!a.this.eE) {
                a.this.eE = true;
                com.kwad.components.core.p.a.se().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j6) {
        int ceil = (int) Math.ceil(j6 / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.ck) {
            if (ceil >= num.intValue()) {
                c.a(this.mAdTemplate, ceil, (JSONObject) null);
                this.ck.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        AdTemplate adTemplate = this.dz.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo el = e.el(adTemplate);
        this.mAdInfo = el;
        this.ck = com.kwad.sdk.core.response.b.a.bp(el);
        this.dz.dB.b(this.mVideoPlayStateListener);
        a(this.eF);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.dz.dB.a(this.mVideoPlayStateListener);
        a((l) null);
    }

    private void a(l lVar) {
        View rootView = getRootView();
        if (rootView instanceof AdBasePvFrameLayout) {
            ((AdBasePvFrameLayout) rootView).setVisibleListener(lVar);
        }
    }
}
