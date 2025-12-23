package com.kwad.components.ad.splashscreen.presenter;

import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j extends e {
    /* JADX INFO: Access modifiers changed from: private */
    public void dc() {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate);
        a(new b(), true);
        a(new c(), true);
        if (com.kwad.sdk.core.response.b.a.bc(el)) {
            a(new d(), true);
            a(new t(), true);
        } else {
            a(new h(), true);
        }
        if (this.Gf.Fy) {
            a(new s(), true);
        } else {
            boolean dM = com.kwad.sdk.core.response.b.b.dM(el);
            boolean dQ = com.kwad.sdk.core.response.b.b.dQ(el);
            boolean dY = com.kwad.sdk.core.response.b.b.dY(el);
            if (com.kwad.sdk.core.response.b.b.dS(el)) {
                a(new q(), true);
            } else if (dM) {
                a(new o(), true);
            } else if (dQ) {
                a(new m(), true);
            } else if (dY) {
                a(new s(), true);
            } else {
                a(new s(), true);
            }
        }
        if (com.kwad.sdk.core.response.b.a.aP(el)) {
            a(new f(), true);
        }
        if (!this.Gf.bO) {
            a(new com.kwad.components.ad.splashscreen.presenter.playcard.b(), true);
        }
        a(new a(), true);
        a(new g(), true);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.j.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                j.this.dc();
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        findViewById(R.id.splash_play_card_view).setVisibility(0);
    }
}
