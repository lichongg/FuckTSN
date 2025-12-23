package com.kwad.components.ad.reward.n;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class r {

    @Nullable
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public static r a(AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar) {
        r rVar = new r();
        rVar.setAdTemplate(adTemplate);
        rVar.setApkDownloadHelper(cVar);
        return rVar;
    }

    public static r aa(AdTemplate adTemplate) {
        r rVar = new r();
        rVar.setAdTemplate(adTemplate);
        return rVar;
    }

    private void setAdTemplate(@Nullable AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    private void setApkDownloadHelper(@Nullable com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    @Nullable
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Nullable
    public final com.kwad.components.core.e.d.c ij() {
        return this.mApkDownloadHelper;
    }

    private r() {
    }
}
