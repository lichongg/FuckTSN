package com.kwad.components.ad.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public FrameLayout bH;
    public a bI;
    public KsAdVideoPlayConfig bJ;
    public List<AdTemplate> bK;
    private KsBannerAd.BannerAdInteractionListener bL;
    private d bM;
    public StyleTemplate bN;
    public boolean bO = false;
    public AdResultData mAdResultData;

    @NonNull
    public SceneImpl mAdScene;
    public Context mContext;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void Z();
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }

    @MainThread
    public final void W() {
        this.mAdTemplate.converted = true;
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bL;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdShow();
        }
    }

    @MainThread
    public final void X() {
        this.mAdTemplate.converted = true;
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bL;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdClicked();
        }
    }

    @MainThread
    public final void Y() {
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bL;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdClose();
        }
    }

    public final void b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.bM.b(adTemplate);
    }

    @MainThread
    public final void c(int i6, String str) {
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.bL;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdShowError(0, str);
        }
    }

    public final void setBannerUpdateAdResultDataListener(d dVar) {
        this.bM = dVar;
    }

    public static boolean a(AdTemplate adTemplate) {
        AdMatrixInfo.AdBannerTKInfo dy;
        return com.kwad.sdk.core.config.e.Fq() && (dy = com.kwad.sdk.core.response.b.b.dy(adTemplate)) != null && !TextUtils.isEmpty(dy.templateId) && dy.renderType == 1;
    }

    public final void a(KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener) {
        this.bL = bannerAdInteractionListener;
    }

    public final void a(a aVar) {
        this.bI = aVar;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
    }
}
