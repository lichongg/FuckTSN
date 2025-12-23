package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ak implements com.kwad.sdk.core.webview.c.a {
    private final Handler acR = new Handler(Looper.getMainLooper());

    @Nullable
    private com.kwad.sdk.core.webview.c.c acS;
    private b eV;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int ady = -1;
        public int type;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.eV = null;
        this.acS = null;
        this.acR.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.eV;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "hide";
    }

    public ak(b bVar) {
        this.eV = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            this.acS = cVar;
            final a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ak.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (ak.this.acS != null) {
                        ak.this.acS.a(null);
                    }
                    ak.this.b(aVar);
                }
            });
        } catch (Exception e6) {
            this.acS.onError(-1, e6.getMessage());
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }
}
