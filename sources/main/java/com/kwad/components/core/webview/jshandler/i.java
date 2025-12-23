package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i implements com.kwad.sdk.core.webview.c.a {

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
            aVar.data = com.kwad.sdk.utils.al.md5(kVar.data);
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return TKDownloadReason.KSAD_TK_MD5;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
