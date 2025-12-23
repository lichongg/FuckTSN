package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import io.netty.handler.codec.http.HttpHeaders;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String data;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.c.k kVar = new com.kwad.components.core.webview.tachikoma.c.k();
        try {
            kVar.parseJson(new JSONObject(str));
        } catch (Exception unused) {
        }
        a aVar = new a();
        if (TextUtils.isEmpty(kVar.data)) {
            aVar.data = "";
        } else {
            aVar.data = new String(com.kwad.sdk.core.a.c.Hf().encode(kVar.data.getBytes()), com.kwad.sdk.crash.utils.a.UTF_8);
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return HttpHeaders.Values.BASE64;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
