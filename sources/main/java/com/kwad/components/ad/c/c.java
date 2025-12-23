package com.kwad.components.ad.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends com.kwad.sdk.mvp.a {

    @NonNull
    public SceneImpl mAdScene;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
    }
}
