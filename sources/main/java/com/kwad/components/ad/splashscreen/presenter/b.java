package com.kwad.components.ad.splashscreen.presenter;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bg;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends e {
    private KsLogoView mLogoView;

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ViewGroup viewGroup) {
        if (!com.kwad.components.ad.splashscreen.e.c.z(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate))) {
            if (com.kwad.components.ad.splashscreen.e.c.a(getContext(), this.Gf.mRootContainer.getWidth(), this.Gf.mRootContainer.getHeight())) {
                com.kwad.components.ad.splashscreen.e.c.a(findViewById(R.id.ksad_splash_logo_container), -1, 16, 16, -1);
            }
            if (com.kwad.sdk.core.response.b.a.dn(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate))) {
                com.kwad.components.ad.splashscreen.e.c.a(findViewById(R.id.ksad_splash_logo_container), -1, 34, 16, -1);
                return;
            }
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams.gravity = 51;
        viewGroup.setLayoutParams(layoutParams);
        DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels / displayMetrics.widthPixels > 1.7777777910232544d) {
            ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(viewGroup.getContext(), 12.0f);
                marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(viewGroup.getContext(), 12.0f);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        AdInfo.AdSplashInfo adSplashInfo;
        super.at();
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.ksad_splash_logo_container);
        this.mLogoView = ksLogoView;
        ksLogoView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b bVar = b.this;
                bVar.i(bVar.mLogoView);
            }
        });
        if (!this.Gf.mAdTemplate.adInfoList.isEmpty() && (adSplashInfo = this.Gf.mAdTemplate.adInfoList.get(0).adSplashInfo) != null) {
            if (adSplashInfo.logoPosition != 0) {
                this.mLogoView.setVisibility(0);
                this.mLogoView.aP(this.Gf.mAdTemplate);
            } else {
                this.mLogoView.setVisibility(8);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
