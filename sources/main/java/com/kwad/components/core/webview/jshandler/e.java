package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class e implements com.kwad.sdk.core.webview.c.a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean acn;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isInstalled", this.acn);
            return jSONObject;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class b extends com.kwad.sdk.core.response.a.a {
        public String packageName;
    }

    protected String aS(String str) {
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(str));
            return bVar.packageName;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public String getKey() {
        return "isAppInstalled";
    }

    private static boolean aT(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.kwad.sdk.utils.as.ap(ServiceProvider.getContext(), str);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        String aS = aS(str);
        if (TextUtils.isEmpty(aS)) {
            return;
        }
        a aVar = new a();
        aVar.acn = aT(aS);
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
