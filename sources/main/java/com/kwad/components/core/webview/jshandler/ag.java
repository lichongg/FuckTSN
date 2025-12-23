package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ag implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b acw;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String playableExtraData;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.acw.KJ()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        a aVar = new a();
        try {
            aVar.playableExtraData = this.acw.getAdTemplate().adInfoList.get(0).adStyleInfo.playableExtraData;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsPlayableAdData";
    }

    public ag(com.kwad.sdk.core.webview.b bVar) {
        this.acw = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
