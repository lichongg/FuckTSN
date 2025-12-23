package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ao implements com.kwad.sdk.core.webview.c.a {
    private List<c> mHolders = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends com.kwad.sdk.core.download.a.a {
        private c adP;

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            ao.a(this.adP, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            ao.a(this.adP, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            ao.a(this.adP, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            ao.a(this.adP, 6, 1.0f);
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i6) {
            ao.a(this.adP, 3, (i6 * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i6) {
            ao.a(this.adP, 2, (i6 * 1.0f) / 100.0f);
        }

        public a(c cVar) {
            this.adP = cVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class b extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c {
        private com.kwad.components.core.e.d.c adQ;
        private a adR;
        private AdTemplate mAdTemplate;
        private com.kwad.sdk.core.webview.c.c qn;

        public final void destroy() {
            a aVar;
            com.kwad.components.core.e.d.c cVar = this.adQ;
            if (cVar == null || (aVar = this.adR) == null) {
                return;
            }
            cVar.c(aVar);
        }

        public final long getCreativeId() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return -1L;
            }
            return com.kwad.sdk.core.response.b.e.ev(adTemplate);
        }

        public c(com.kwad.components.core.e.d.c cVar, AdTemplate adTemplate) {
            this.adQ = cVar;
            this.mAdTemplate = adTemplate;
        }

        public final void a(a aVar) {
            this.adQ.b(aVar);
            this.adR = aVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.parseJson(jSONObject);
                c R = R(bVar.creativeId);
                if (R != null) {
                    R.qn = cVar;
                    R.a(new a(R));
                }
            } catch (Exception unused) {
            }
        }
    }

    private c R(long j6) {
        if (j6 == -1) {
            return null;
        }
        for (c cVar : this.mHolders) {
            if (cVar.getCreativeId() == j6) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMultiProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        Iterator<c> it = this.mHolders.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    public ao(List<AdTemplate> list, List<com.kwad.components.core.e.d.c> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.mHolders.add(new c(list2.get(i6), list.get(i6)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(c cVar, int i6, float f6) {
        if (cVar == null || cVar.qn == null) {
            return;
        }
        com.kwad.sdk.core.d.c.d("MultiProgressListener", "notifyDownloadProgress: " + cVar.qn + f6);
        com.kwad.sdk.core.webview.c.c cVar2 = cVar.qn;
        bc.a aVar = new bc.a();
        aVar.aep = f6;
        aVar.status = i6;
        aVar.creativeId = cVar.getCreativeId();
        aVar.totalBytes = com.kwad.sdk.core.response.b.e.el(cVar.mAdTemplate).totalBytes;
        long j6 = com.kwad.sdk.core.response.b.e.el(cVar.mAdTemplate).soFarBytes;
        aVar.soFarBytes = j6;
        long j7 = aVar.totalBytes;
        if (j7 > 0) {
            aVar.aeq = (j6 * 1.0f) / j7;
        } else {
            aVar.aeq = 0.0f;
        }
        cVar2.a(aVar);
    }
}
