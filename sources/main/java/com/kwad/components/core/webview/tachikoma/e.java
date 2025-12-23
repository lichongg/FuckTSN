package com.kwad.components.core.webview.tachikoma;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class e implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c qn;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.qn = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.qn = cVar;
    }

    public final void b(final com.kwad.sdk.core.response.a.a aVar) {
        if (this.qn != null) {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.e.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    e.this.qn.a(aVar);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerConvertStatusListener";
    }
}
