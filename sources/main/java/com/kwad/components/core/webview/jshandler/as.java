package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class as implements com.kwad.sdk.core.webview.c.a {
    private Handler acR = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c acS;
    private b eW;
    private String mUrl;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String errorMsg;
        public int status;

        public final boolean isSuccess() {
            return this.status == 1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    @Deprecated
    public as(b bVar) {
        this.eW = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.eW = null;
        this.acS = null;
        this.acR.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.eW;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "pageStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.acS = cVar;
        try {
            final a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.as.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    as.this.b(aVar);
                    if (as.this.acS != null) {
                        as.this.acS.a(null);
                    }
                }
            });
        } catch (JSONException e6) {
            com.kwad.sdk.core.d.c.e("WebCardPageStatusHandler", "handleJsCall error: " + e6);
            com.kwad.sdk.core.webview.b.c.b.ag(this.mUrl, e6.getMessage());
            cVar.onError(-1, e6.getMessage());
        }
    }

    public as(b bVar, String str) {
        this.eW = bVar;
        this.mUrl = str;
    }
}
