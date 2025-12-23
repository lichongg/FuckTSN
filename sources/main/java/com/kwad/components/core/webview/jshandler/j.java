package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.playable.PlayableSource;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ack;
    private p aco;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String acp;

        public final String getTarget() {
            return this.acp;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int Re;
        public int acq;
        public int acr;
        public String acs;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            String target = aVar.getTarget();
            p pVar = this.aco;
            if (pVar != null) {
                pVar.a(this, target);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
    }

    public final void P(long j6) {
        b bVar = new b();
        bVar.acs = Long.toString(j6);
        a(bVar);
    }

    public final void aW(boolean z5) {
        b bVar = new b();
        bVar.acr = z5 ? 1 : 0;
        a(bVar);
    }

    public final void be(int i6) {
        b bVar = new b();
        bVar.Re = i6;
        a(bVar);
    }

    public final void f(PlayableSource playableSource) {
        if (playableSource == null) {
            return;
        }
        b bVar = new b();
        bVar.acq = playableSource.getCode();
        a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getNativeData";
    }

    public j(p pVar) {
        this.aco = pVar;
    }

    public final void a(com.kwad.sdk.core.response.a.a aVar) {
        com.kwad.sdk.core.webview.c.c cVar = this.ack;
        if (cVar == null || aVar == null) {
            return;
        }
        cVar.a(aVar);
    }
}
