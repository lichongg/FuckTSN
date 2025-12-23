package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bb implements com.kwad.sdk.core.webview.c.a {
    private final a ael;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        @MainThread
        void cL();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
        bw.runOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.bb.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (bb.this.ael != null) {
                    bb.this.ael.cL();
                }
                cVar.a(null);
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMotionListener";
    }

    public bb(a aVar) {
        this.ael = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
