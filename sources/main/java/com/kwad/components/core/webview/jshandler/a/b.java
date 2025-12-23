package com.kwad.components.core.webview.jshandler.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private c abQ;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.abQ = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        bw.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.abQ != null) {
                    b.this.abQ.rq();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "exitWebView";
    }

    public b(c cVar) {
        this.abQ = cVar;
    }
}
