package com.kwad.components.ad.fullscreen.c.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.ad.reward.presenter.f.a {
    private FrameLayout dm;
    private j kG = new j() { // from class: com.kwad.components.ad.fullscreen.c.c.b.1
        @Override // com.kwad.components.ad.reward.e.j
        public final void dk() {
            b.this.dm.setVisibility(0);
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void dl() {
            b.this.dm.setVisibility(4);
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, @Nullable n nVar) {
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        this.dm.setVisibility(8);
        this.tm.rT = false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.dm;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_fullscreen";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dI(this.tm.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.rT = true;
        com.kwad.components.ad.reward.a.gg().a(this.kG);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dm = (FrameLayout) findViewById(R.id.ksad_js_full_card);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.a.gg().b(this.kG);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float f6;
        float f7;
        float bj = com.kwad.sdk.c.a.a.bj(getContext());
        FrameLayout frameLayout = this.dm;
        if (frameLayout != null) {
            f6 = frameLayout.getHeight();
            f7 = this.dm.getWidth();
        } else {
            f6 = 0.0f;
            f7 = 0.0f;
        }
        if (f6 != 0.0f && f7 != 0.0f) {
            aVar.width = (int) ((f7 / bj) + 0.5f);
            aVar.height = (int) ((f6 / bj) + 0.5f);
        } else {
            super.a(aVar);
        }
    }
}
