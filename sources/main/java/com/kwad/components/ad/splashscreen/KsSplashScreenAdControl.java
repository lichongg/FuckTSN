package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.AbstrackKsSplashScreenAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsSplashScreenAdControl extends AbstrackKsSplashScreenAd implements com.kwad.components.core.internal.api.a {
    private KsScene Fc;
    private com.kwad.components.core.internal.api.c bz = new com.kwad.components.core.internal.api.c();
    private com.kwad.sdk.core.j.b dn = new com.kwad.sdk.core.j.b() { // from class: com.kwad.components.ad.splashscreen.KsSplashScreenAdControl.1
        @Override // com.kwad.sdk.core.j.b
        public final void aK() {
            KsSplashScreenAdControl.this.bz.h(KsSplashScreenAdControl.this);
        }

        @Override // com.kwad.sdk.core.j.b
        public final void aL() {
            KsSplashScreenAdControl.this.bz.i(KsSplashScreenAdControl.this);
        }
    };

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private final AdTemplate mAdTemplate;

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(int i6) {
        setBidEcpm(i6, -1L);
    }

    @Keep
    public boolean showSplashMiniWindowIfNeeded(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener, Rect rect) {
        return false;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return false;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
    }

    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    protected KsFragment getFragment2(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        com.kwad.sdk.commercial.d.c.bK(this.mAdTemplate);
        com.kwad.components.ad.splashscreen.a.a aVar = (com.kwad.components.ad.splashscreen.a.a) com.kwad.sdk.components.d.f(com.kwad.components.ad.splashscreen.a.a.class);
        if (aVar != null) {
            return aVar.a(this.mAdResultData, this.dn, splashScreenAdInteractionListener);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public KSAdInfoData getKSAdInfoData() {
        if (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBw)) {
            return com.kwad.sdk.core.response.b.a.dj(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.e.Ft()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @Nullable
    public View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        if (context == null || !l.Cf().Bn()) {
            return null;
        }
        com.kwad.sdk.commercial.d.c.bK(this.mAdTemplate);
        return c.a(context, this.mAdResultData, true, this.dn, splashScreenAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isVideo() {
        return com.kwad.sdk.core.response.b.a.bc(com.kwad.sdk.core.response.b.e.el(this.mAdResultData.getAdTemplateList().get(0)));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void reportAdExposureFailed(int i6, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i6, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(long j6, long j7) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j6;
        com.kwad.sdk.core.adlog.c.m(adTemplate, j7);
    }

    public KsSplashScreenAdControl(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.Fc = ksScene;
        this.mAdTemplate = adResultData.getAdTemplateList().get(0);
        com.kwad.components.ad.i.b.fR().a(this);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isAdEnable() {
        if (!SplashPreloadManager.lD().h(this.mAdResultData)) {
            SplashPreloadManager.lD();
            if (!SplashPreloadManager.i(this.mAdResultData)) {
                return false;
            }
            return true;
        }
        return true;
    }
}
