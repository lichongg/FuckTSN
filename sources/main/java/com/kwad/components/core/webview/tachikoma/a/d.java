package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.sdk.components.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class d implements m {
    public abstract AdTemplate vy();

    private AdTemplate a(n.a aVar) {
        AdTemplate adTemplate = aVar.adTemplate;
        return adTemplate != null ? adTemplate : vy();
    }

    @Override // com.kwad.sdk.components.m
    public final Object call(@Nullable Object... objArr) {
        try {
            n.a aVar = new n.a();
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj instanceof String) {
                    aVar.parseJson(new JSONObject((String) obj));
                }
            }
            com.kwad.sdk.core.download.a.dM(com.kwad.sdk.core.response.b.e.el(a(aVar)).adConversionInfo.appDownloadUrl);
            return Boolean.TRUE;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }
}
