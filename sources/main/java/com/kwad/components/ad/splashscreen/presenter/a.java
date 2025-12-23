package com.kwad.components.ad.splashscreen.presenter;

import android.view.View;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends e implements com.kwad.sdk.widget.d {
    private View FU;
    private boolean FV;

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        this.Gf.c(1, view.getContext(), 53, 2);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        com.kwad.sdk.core.d.c.d("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.FV);
        if (this.FV) {
            this.Gf.c(1, view.getContext(), 153, 2);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        int i6;
        super.at();
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null) {
            this.FV = com.kwad.sdk.core.response.b.d.ea(hVar.mAdTemplate);
            boolean n6 = com.kwad.components.ad.splashscreen.h.n(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate));
            View view = this.FU;
            if (n6) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            view.setVisibility(i6);
            if (n6) {
                new com.kwad.sdk.widget.h(this.FU.getContext(), this.FU, this);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.FU = findViewById(R.id.ksad_splash_actionbar_full_screen);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
