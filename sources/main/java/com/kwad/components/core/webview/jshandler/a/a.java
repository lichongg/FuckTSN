package com.kwad.components.core.webview.jshandler.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.core.webview.jshandler.e {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.a.a$a, reason: collision with other inner class name */
    public static class C0638a extends com.kwad.sdk.core.response.a.a {
        public String aeH;
    }

    @Override // com.kwad.components.core.webview.jshandler.e
    public final String aS(String str) {
        try {
            C0638a c0638a = new C0638a();
            c0638a.parseJson(new JSONObject(str));
            return c0638a.aeH;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.e, com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "checkAppInstalled";
    }
}
