package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.c.m;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private final AdTemplate mAdTemplate;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            cVar.onError(-1, "adTemplate is null");
            return;
        }
        String aS = com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.el(adTemplate));
        if (TextUtils.isEmpty(aS)) {
            cVar.onError(-1, "landing page url is null");
            return;
        }
        m mVar = new m();
        mVar.ahf = aS;
        cVar.a(mVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getLandingPageInfo";
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
