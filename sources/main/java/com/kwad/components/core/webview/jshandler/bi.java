package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bi implements com.kwad.sdk.core.webview.c.a {
    private static Handler aeD;
    private com.kwad.components.core.e.d.c Pc;
    private com.kwad.sdk.core.webview.b aeC;
    private b aeE;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int mI;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        @MainThread
        void ae(int i6);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            final int i6 = aVar.mI;
            aeD.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.bi.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (bi.this.aeE != null) {
                        bi.this.aeE.ae(i6);
                    }
                }
            });
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "playableConvert";
    }

    public bi(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, b bVar2) {
        this.aeC = bVar;
        this.Pc = cVar;
        this.aeE = bVar2;
        if (aeD == null) {
            aeD = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
