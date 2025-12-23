package com.kwad.components.ad.draw.presenter.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.l.b;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.ad.draw.b.a {

    @Nullable
    private com.kwad.components.ad.l.b dF;
    private com.kwad.sdk.core.webview.d.a.a eT = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.draw.presenter.c.b.1
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.dz.dh != null) {
                b.this.dz.dh.onAdClicked();
            }
        }
    };
    private FrameLayout fc;

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.components.ad.l.b bVar = this.dz.dF;
        this.dF = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.eT);
        com.kwad.components.ad.l.b bVar2 = this.dF;
        FrameLayout frameLayout = this.fc;
        com.kwad.components.ad.draw.b.b bVar3 = this.dz;
        bVar2.a(frameLayout, bVar3.mRootContainer, bVar3.mAdTemplate, bVar3.mApkDownloadHelper);
        this.dF.a((b.InterfaceC0573b) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fc = (FrameLayout) findViewById(R.id.ksad_play_end_web_card_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.l.b bVar = this.dF;
        if (bVar != null) {
            bVar.ny();
        }
    }
}
