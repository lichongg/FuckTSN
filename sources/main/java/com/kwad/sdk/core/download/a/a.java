package com.kwad.sdk.core.download.a;

import com.kwad.sdk.api.KsAppDownloadListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a implements KsAppDownloadListener {
    public String downloadId;

    public a() {
    }

    public a(String str) {
        this.downloadId = str;
    }

    public final String pC() {
        return this.downloadId;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    public void onPaused(int i6) {
    }
}
