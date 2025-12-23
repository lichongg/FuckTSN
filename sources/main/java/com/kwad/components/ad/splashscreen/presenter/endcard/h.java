package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bv;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h extends com.kwad.components.ad.splashscreen.presenter.a.c implements com.kwad.sdk.core.j.c {
    private FrameLayout cV;
    private az cX;

    private void an(int i6) {
        a.C0675a c0675a = new a.C0675a();
        bv bvVar = this.Gf.mTimerHelper;
        if (bvVar != null) {
            c0675a.duration = bvVar.getTime();
        }
        com.kwad.sdk.core.adlog.c.b b6 = new com.kwad.sdk.core.adlog.c.b().dm(6).b(c0675a);
        if (i6 == 2) {
            b6.de(14);
        } else {
            b6.de(1);
        }
        com.kwad.sdk.core.adlog.c.b(this.Gf.mAdTemplate, b6, (JSONObject) null);
    }

    private void mX() {
        try {
            this.Gf.mRootContainer.findViewById(R.id.splash_play_card_view).setVisibility(8);
        } catch (NullPointerException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
        mX();
        this.cV.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uF();
            this.cX.uG();
        }
        mX();
        this.cV.setVisibility(0);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uJ();
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uK();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.cV;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash_end_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dL(this.Gf.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
        super.onUnbind();
        this.Gf.Fs.b(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.Gf.Fs.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cV = (FrameLayout) findViewById(R.id.splash_end_card_view);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        an(webCloseStatus.closeType);
        if (webCloseStatus.closeType == 2) {
            this.Gf.lW();
        } else {
            com.kwad.components.ad.splashscreen.monitor.a.lX().ah(this.Gf.mAdTemplate);
            this.Gf.lS();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.Gf.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.Gf.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.cX = azVar;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(a(bVar));
    }

    @NonNull
    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, this.Gf.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.h.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    h.this.Gf.mRootContainer.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.h.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            h.this.Gf.X();
                        }
                    });
                }
            }
        });
    }
}
