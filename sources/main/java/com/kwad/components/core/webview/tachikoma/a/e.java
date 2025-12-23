package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.components.o;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private KsAppDownloadListener abU;

    @Nullable
    private KsAppDownloadListener aen;

    @NonNull
    private o afJ;
    private com.kwad.sdk.core.webview.b eQ;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    private KsAppDownloadListener uz() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.tachikoma.a.e.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                e.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                e.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                e.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                e.this.a(6, 1.0f);
                if (e.this.aen != null) {
                    e.this.aen.onInstalled();
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i6) {
                e.this.a(3, (i6 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i6) {
                e.this.a(2, (i6 * 1.0f) / 100.0f);
            }
        };
    }

    public e(com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.b bVar, @NonNull o oVar) {
        this.eQ = bVar;
        this.mApkDownloadHelper = cVar;
        this.afJ = oVar;
        if (cVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.abU;
            if (ksAppDownloadListener == null) {
                KsAppDownloadListener uz = uz();
                this.abU = uz;
                this.mApkDownloadHelper.b(uz);
                return;
            }
            cVar.d(ksAppDownloadListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6, float f6) {
        bc.a aVar = new bc.a();
        aVar.aep = f6;
        aVar.status = i6;
        aVar.totalBytes = com.kwad.sdk.core.response.b.e.el(this.eQ.getAdTemplate()).totalBytes;
        long j6 = com.kwad.sdk.core.response.b.e.el(this.eQ.getAdTemplate()).soFarBytes;
        aVar.soFarBytes = j6;
        long j7 = aVar.totalBytes;
        if (j7 > 0) {
            aVar.aeq = (j6 * 1.0f) / j7;
        } else {
            aVar.aeq = 0.0f;
        }
        this.afJ.setDownloadProgress(aVar.toJson().toString());
    }
}
