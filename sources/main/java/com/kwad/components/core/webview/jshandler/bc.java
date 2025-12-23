package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bc implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private KsAppDownloadListener abU;

    @Nullable
    private com.kwad.sdk.core.webview.c.c ack;

    @Nullable
    private KsAppDownloadListener aen;
    private final com.kwad.sdk.core.webview.b eQ;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements com.kwad.sdk.core.b {
        public float aep;
        public float aeq;
        public long creativeId;
        public long soFarBytes;
        public int status;
        public long totalBytes;

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, this.aep);
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, this.status);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", this.totalBytes);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", this.soFarBytes);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", this.aeq);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }
    }

    public bc(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar) {
        this.eQ = bVar;
        this.mApkDownloadHelper = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.ack = null;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.abU) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
        this.abU = null;
    }

    private KsAppDownloadListener uz() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.bc.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                bc.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                bc.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                bc.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                bc.this.a(6, 1.0f);
                if (bc.this.aen != null) {
                    bc.this.aen.onInstalled();
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i6) {
                bc.this.a(3, (i6 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i6) {
                bc.this.a(2, (i6 * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    public final void setApkDownloadHelper(com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper.pQ();
        com.kwad.sdk.core.download.b.GR().a(this.mApkDownloadHelper);
        if (com.kwad.sdk.core.config.e.FG()) {
            NetworkMonitor.getInstance().a(this.mApkDownloadHelper);
        }
        this.mApkDownloadHelper = cVar;
        KsAppDownloadListener uz = uz();
        this.abU = uz;
        this.mApkDownloadHelper.b(uz);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.eQ.KJ()) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        this.ack = cVar;
        com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            KsAppDownloadListener ksAppDownloadListener = this.abU;
            if (ksAppDownloadListener == null) {
                KsAppDownloadListener uz = uz();
                this.abU = uz;
                this.mApkDownloadHelper.b(uz);
                return;
            }
            cVar2.d(ksAppDownloadListener);
        }
    }

    public bc(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable KsAppDownloadListener ksAppDownloadListener) {
        this.eQ = bVar;
        this.mApkDownloadHelper = cVar;
        this.aen = ksAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6, float f6) {
        if (this.ack != null) {
            a aVar = new a();
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
            this.ack.a(aVar);
        }
    }
}
