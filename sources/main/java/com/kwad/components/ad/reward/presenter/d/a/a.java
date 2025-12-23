package com.kwad.components.ad.reward.presenter.d.a;

import android.widget.FrameLayout;
import com.kwad.components.ad.l.a;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements a.b {
    private FrameLayout fc;
    private m vQ;
    private volatile long yU = 0;
    private volatile boolean yV = false;
    private m vR = new m() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            a.this.yV = false;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.yV = true;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            super.onMediaPlayProgress(j6, j7);
            a.this.yU = j7;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.yV = false;
        }
    };
    private m jE = new m() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            boolean z5;
            super.onMediaPlayProgress(j6, j7);
            a.this.yU = j7;
            a aVar = a.this;
            if (j6 - j7 < 800) {
                z5 = true;
            } else {
                z5 = false;
            }
            aVar.yV = z5;
        }
    };
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.4
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            if (a.this.tm.sl || a.this.tm.rI == null) {
                return;
            }
            a.this.tm.rI.aW();
        }
    };
    private com.kwad.sdk.core.webview.d.a.a eT = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.5
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            a.this.tm.rD.cW();
        }
    };

    @Override // com.kwad.components.ad.l.a.b
    public final void jG() {
        f.t(this.tm);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        m mVar;
        super.at();
        this.yU = 0L;
        this.yV = false;
        com.kwad.components.ad.reward.g gVar = this.tm;
        AdTemplate adTemplate = gVar.mAdTemplate;
        com.kwad.components.ad.l.a aVar = gVar.rI;
        if (gVar.rE.kW()) {
            mVar = this.vR;
        } else {
            mVar = this.jE;
        }
        this.vQ = mVar;
        if (aVar != null) {
            this.tm.sf = true;
            aVar.a(this);
            aVar.a(this.eT);
            aVar.a(this.fc, this.tm.mRootContainer, adTemplate);
            aVar.a(new a.InterfaceC0571a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.3
                @Override // com.kwad.components.ad.l.a.InterfaceC0571a
                public final void S(boolean z5) {
                    a.this.tm.sf = z5;
                }
            });
            aVar.setActivity(this.tm.getActivity());
            aVar.bd();
            this.tm.b(this.mPlayEndPageListener);
            this.tm.rE.a(this.vQ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fc = (FrameLayout) findViewById(R.id.ksad_landing_page_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.c(this.mPlayEndPageListener);
        this.tm.rE.b(this.vQ);
    }
}
