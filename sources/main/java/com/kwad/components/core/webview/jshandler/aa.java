package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class aa implements com.kwad.sdk.core.webview.c.a {
    private Handler acR = new Handler(Looper.getMainLooper());

    @Nullable
    private com.kwad.sdk.core.webview.c.c acS;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.mWebCardCloseListener = null;
        this.acS = null;
        this.acR.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(WebCloseStatus webCloseStatus) {
        com.kwad.sdk.core.webview.d.a.b bVar = this.mWebCardCloseListener;
        if (bVar != null) {
            bVar.b(webCloseStatus);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "close";
    }

    public aa(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.acS = cVar;
        final WebCloseStatus webCloseStatus = new WebCloseStatus();
        try {
            webCloseStatus.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.aa.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                aa.this.c(webCloseStatus);
                if (aa.this.acS != null) {
                    aa.this.acS.a(null);
                }
            }
        });
    }
}
