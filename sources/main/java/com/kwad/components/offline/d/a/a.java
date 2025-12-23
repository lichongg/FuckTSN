package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements com.kwad.sdk.core.webview.c.c {
    private final IOfflineCompoCallBackFunction akt;

    @Override // com.kwad.sdk.core.webview.c.c
    public final void a(final com.kwad.sdk.core.b bVar) {
        if (com.kwad.sdk.core.config.e.Fr()) {
            GlobalThreadPools.Jy().submit(new Runnable() { // from class: com.kwad.components.offline.d.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    final String jSONObject = new com.kwad.sdk.core.webview.c.f(bVar).toJson().toString();
                    bw.runOnUiThread(new Runnable() { // from class: com.kwad.components.offline.d.a.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (a.this.akt != null) {
                                a.this.akt.onSuccess(jSONObject);
                            }
                        }
                    });
                }
            });
            return;
        }
        String jSONObject = new com.kwad.sdk.core.webview.c.f(bVar).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.akt;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onSuccess(jSONObject);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void onError(int i6, String str) {
        String jSONObject = new com.kwad.sdk.core.webview.c.e(i6, str).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.akt;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onError(jSONObject);
        }
    }

    public a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.akt = iOfflineCompoCallBackFunction;
    }
}
