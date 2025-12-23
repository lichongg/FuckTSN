package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ap implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b eQ;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String adM;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public double adT;
        public double adU;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    private KsAppDownloadListener aX(String str) {
        return new com.kwad.sdk.core.download.a.a(str) { // from class: com.kwad.components.core.webview.jshandler.ap.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (ap.this.eQ.aMO != null) {
                    ap.this.a(1, 0.0f, ap.this.eQ.aMO.ha(pC()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (ap.this.eQ.aMO != null) {
                    ap.this.a(5, 1.0f, ap.this.eQ.aMO.ha(pC()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                if (ap.this.eQ.aMO != null) {
                    ap.this.a(1, 0.0f, ap.this.eQ.aMO.ha(pC()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (ap.this.eQ.aMO != null) {
                    ap.this.a(6, 1.0f, ap.this.eQ.aMO.ha(pC()));
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i6) {
                if (ap.this.eQ.aMO != null) {
                    ap.this.a(3, (i6 * 1.0f) / 100.0f, ap.this.eQ.aMO.ha(pC()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i6) {
                if (ap.this.eQ.aMO != null) {
                    ap.this.a(2, (i6 * 1.0f) / 100.0f, ap.this.eQ.aMO.ha(pC()));
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.utils.an anVar = this.eQ.aMO;
        if (anVar != null) {
            anVar.release();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.adM));
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            adTemplate = null;
        }
        if (adTemplate == null || !com.kwad.sdk.core.response.b.e.ed(adTemplate) || this.eQ.aMO == null) {
            return;
        }
        com.kwad.components.core.e.d.c cVar2 = new com.kwad.components.core.e.d.c(adTemplate);
        String pC = cVar2.pC();
        cVar2.b(aX(pC));
        this.eQ.aMO.a(pC, cVar2);
        this.eQ.aMO.b(pC, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6, float f6, com.kwad.sdk.core.webview.c.c cVar) {
        if (cVar != null) {
            b bVar = new b();
            bVar.adT = f6;
            bVar.status = i6;
            bVar.totalBytes = com.kwad.sdk.core.response.b.e.el(this.eQ.getAdTemplate()).totalBytes;
            long j6 = com.kwad.sdk.core.response.b.e.el(this.eQ.getAdTemplate()).soFarBytes;
            bVar.soFarBytes = j6;
            long j7 = bVar.totalBytes;
            if (j7 > 0) {
                bVar.adU = (j6 * 1.0d) / j7;
            } else {
                bVar.adU = 0.0d;
            }
            cVar.a(bVar);
        }
    }
}
