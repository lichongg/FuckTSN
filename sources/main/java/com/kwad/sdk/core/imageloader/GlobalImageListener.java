package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class GlobalImageListener implements OnRenderResultListener<AdTemplate> {
    @Override // com.kwad.sdk.core.imageloader.OnRenderResultListener
    public void onRenderResult(boolean z5, AdTemplate adTemplate, String str, String str2) {
        if (!z5) {
            ((b) ServiceProvider.get(b.class)).I(str, str2);
        }
        if (z5) {
            return;
        }
        ((b) ServiceProvider.get(b.class)).aQ(adTemplate);
    }
}
