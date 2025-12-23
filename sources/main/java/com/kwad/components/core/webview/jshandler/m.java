package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.core.e.d.c Pc;
    private KsAppDownloadListener abU;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private com.kwad.sdk.core.webview.c.c qn;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String acu;
        public String packageName;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int acv;
        public int progress;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    private synchronized void p(String str, String str2) {
        this.Pc = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, str, str2);
        if (this.abU == null) {
            KsAppDownloadListener uz = uz();
            this.abU = uz;
            this.Pc.b(uz);
        }
    }

    private static boolean q(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.qn = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i6, int i7) {
        if (this.qn != null) {
            b bVar = new b();
            bVar.status = i6;
            bVar.progress = i7;
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                bVar.totalBytes = com.kwad.sdk.core.response.b.e.el(adTemplate).totalBytes;
                long j6 = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate).soFarBytes;
                bVar.soFarBytes = j6;
                long j7 = bVar.totalBytes;
                if (j7 > 0) {
                    bVar.acv = (int) ((j6 * 100.0f) / j7);
                } else {
                    bVar.acv = 0;
                }
            }
            this.qn.a(bVar);
        }
    }

    private KsAppDownloadListener uz() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.m.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                m.this.q(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                m.this.q(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                m.this.q(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                m.this.q(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i6) {
                m.this.q(4, i6);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i6) {
                if (i6 == 0) {
                    m.this.q(1, 0);
                } else {
                    m.this.q(2, i6);
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.qn = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            if (q(aVar.acu, aVar.packageName)) {
                cVar.onError(-1, "param is empty");
                return;
            }
            if (this.Pc == null) {
                p(aVar.acu, aVar.packageName);
            }
            a.C0616a at = new a.C0616a(this.mContext).aq(true).ar(false).aB(this.mAdTemplate).at(false);
            if (this.Pc.s(at)) {
                return;
            }
            this.Pc.d(this.abU);
            this.Pc.r(at);
        } catch (Exception unused) {
            cVar.onError(-1, "data parse error");
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "installAppForDownload";
    }

    public m(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }
}
