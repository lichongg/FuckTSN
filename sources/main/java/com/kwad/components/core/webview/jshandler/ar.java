package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.smallApp.JumpFrom;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ar implements com.kwad.sdk.core.webview.c.a {
    private AdTemplate mAdTemplate;
    private Context mContext;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate;
        com.kwad.components.core.webview.a.c cVar2 = new com.kwad.components.core.webview.a.c();
        if (this.mContext == null) {
            com.kwad.sdk.core.adlog.c.j(this.mAdTemplate, 2);
            cVar.onError(-1, "context为空");
            return;
        }
        AdTemplate adTemplate2 = null;
        try {
            cVar2.parseJson(new JSONObject(str));
            adTemplate = this.mAdTemplate;
        } catch (Exception e6) {
            e = e6;
        }
        try {
            int i6 = cVar2.acb;
            if (i6 > 0) {
                adTemplate = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.o.a.e.a.a.aI(i6), cVar2.NN);
            }
            if (adTemplate == null) {
                com.kwad.sdk.core.adlog.c.j(this.mAdTemplate, 2);
                cVar.onError(-1, "adTemplate为空：" + cVar2.acb);
                return;
            }
            if (com.kwad.components.core.e.d.e.a(this.mContext, cVar2.aR(com.kwad.sdk.core.response.b.a.dm(com.kwad.sdk.core.response.b.e.el(adTemplate))), JumpFrom.H5, adTemplate) == 1) {
                cVar.a(null);
            } else {
                cVar.onError(-1, "跳转失败");
            }
        } catch (Exception e7) {
            e = e7;
            adTemplate2 = adTemplate;
            com.kwad.sdk.core.adlog.c.j(adTemplate2, 2);
            cVar.onError(-1, "解析失败");
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "openWechatMiniProgram";
    }

    public ar(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
