package com.kwad.components.ad;

import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.c;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b implements com.kwad.components.core.internal.api.a {
    public c bz = new c();

    @NonNull
    protected final AdResultData mAdResultData;

    @NonNull
    protected final AdTemplate mAdTemplate;

    public void setBidEcpm(int i6) {
        setBidEcpm(i6, -1L);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
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

    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(e.el(this.mAdTemplate));
    }

    public int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(e.el(this.mAdTemplate));
    }

    public int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(e.el(this.mAdTemplate));
    }

    public Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.e.Ft()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    public boolean isVideo() {
        return com.kwad.sdk.core.response.b.a.bc(e.el(this.mAdTemplate));
    }

    public void reportAdExposureFailed(int i6, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i6, adExposureFailedReason);
    }

    public void setBidEcpm(long j6, long j7) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j6;
        com.kwad.sdk.core.adlog.c.m(adTemplate, j6);
    }

    public b(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }
}
