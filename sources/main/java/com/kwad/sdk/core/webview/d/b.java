package com.kwad.sdk.core.webview.d;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.core.webview.request.WebCardGetDataResponse;
import com.kwad.sdk.core.webview.request.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private c aNM;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String method;
        public String params;
        public String url;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aNM = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull c cVar) {
        this.aNM = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            a(aVar);
        } catch (JSONException e6) {
            c cVar2 = this.aNM;
            if (cVar2 != null) {
                cVar2.onError(-1, "data parse json error.");
            }
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "requestData";
    }

    private void a(a aVar) {
        new com.kwad.sdk.core.webview.request.b().a(aVar, new b.a() { // from class: com.kwad.sdk.core.webview.d.b.1
            @Override // com.kwad.sdk.core.webview.request.b.a
            public final void a(@NonNull WebCardGetDataResponse webCardGetDataResponse) {
                if (b.this.aNM != null) {
                    b.this.aNM.a(webCardGetDataResponse);
                }
            }

            @Override // com.kwad.sdk.core.webview.request.b.a
            public final void onError(int i6, String str) {
                if (b.this.aNM != null) {
                    b.this.aNM.onError(i6, str);
                }
            }
        });
    }
}
