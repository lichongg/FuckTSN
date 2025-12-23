package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ax implements com.kwad.sdk.core.webview.c.a {
    private final a aed;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void c(com.kwad.components.core.webview.tachikoma.f.d dVar);

        void d(com.kwad.components.core.webview.tachikoma.f.d dVar);

        void e(com.kwad.components.core.webview.tachikoma.f.d dVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerFeedMotionListener";
    }

    public ax(a aVar) {
        this.aed = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
        if (!TextUtils.isEmpty(str)) {
            final com.kwad.components.core.webview.tachikoma.c.i iVar = new com.kwad.components.core.webview.tachikoma.c.i();
            try {
                iVar.parseJson(new JSONObject(str));
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
            com.kwad.components.core.webview.tachikoma.f.d dVar = new com.kwad.components.core.webview.tachikoma.f.d() { // from class: com.kwad.components.core.webview.jshandler.ax.1
                @Override // com.kwad.components.core.webview.tachikoma.f.d
                public final void p(int i6, String str2) {
                    com.kwad.components.core.webview.tachikoma.c.i iVar2 = iVar;
                    iVar2.ahb = str2;
                    iVar2.aha = i6;
                    cVar.a(iVar2);
                }
            };
            int i6 = iVar.agZ;
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 3) {
                        this.aed.e(dVar);
                        return;
                    }
                    return;
                }
                this.aed.c(dVar);
                return;
            }
            this.aed.d(dVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
