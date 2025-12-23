package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import com.kwad.sdk.utils.ac;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class r extends e {
    private com.kwad.sdk.core.download.a.a HF;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.sdk.core.download.a.a aVar = this.HF;
        if (aVar != null) {
            this.Gf.mApkDownloadHelper.c(aVar);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.sdk.core.download.a.a aVar = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.r.1
            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                String str;
                super.onDownloadStarted();
                Context context = r.this.getContext();
                if (context != null) {
                    String cF = com.kwad.sdk.utils.m.cF(context);
                    if (cF != null) {
                        str = cF + ":已开始下载";
                    } else {
                        str = "已开始下载";
                    }
                    ac.Q(context, str);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i6) {
            }
        };
        this.HF = aVar;
        this.Gf.mApkDownloadHelper.b(aVar);
    }
}
