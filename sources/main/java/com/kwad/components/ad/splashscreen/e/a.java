package com.kwad.components.ad.splashscreen.e;

import android.text.TextUtils;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a extends com.kwad.sdk.core.download.a.a {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    private void j(int i6, int i7) {
        String a6 = com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, i6, i7);
        if (TextUtils.isEmpty(a6)) {
            return;
        }
        j(i6, a6);
    }

    protected abstract void j(int i6, String str);

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        j(7, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        j(0, 0);
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i6) {
        j(4, i6);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i6) {
        j(2, i6);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        j(8, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        j(12, 0);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.el(adTemplate);
    }
}
