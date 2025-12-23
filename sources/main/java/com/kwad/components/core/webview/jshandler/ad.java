package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ad implements com.kwad.sdk.core.webview.c.a {
    private a acZ;
    private final com.kwad.sdk.core.webview.b acw;
    private Handler iK = new Handler(Looper.getMainLooper());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void cK();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.iK.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ad.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ad.this.acZ.cK();
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.iK.removeCallbacksAndMessages(null);
    }

    public ad(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.acw = bVar;
        this.acZ = aVar;
    }
}
