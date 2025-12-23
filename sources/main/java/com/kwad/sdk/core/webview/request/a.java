package com.kwad.sdk.core.webview.request;

import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.aa;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends d {
    private String aNU;
    private String mUrl;

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public String getUrl() {
        return h.AK() + this.mUrl;
    }

    public a(String str, String str2, String str3) {
        JSONObject jSONObject;
        this.mUrl = str;
        this.aNU = str2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e6) {
            c.printStackTrace(e6);
            jSONObject = null;
        }
        c.d("WebCardGetDataRequest", "mBodyParams1 size=" + this.mBodyParams.length());
        if (jSONObject != null) {
            c.d("WebCardGetDataRequest", "paramsJsonObj=" + jSONObject.toString());
        }
        aa.a(this.mBodyParams, jSONObject, true);
        c.d("WebCardGetDataRequest", "mBodyParams2 size=" + this.mBodyParams.length());
        addHeader("user-agent", p.getUserAgent());
        c.d("WebCardGetDataRequest", "user-agent" + p.getUserAgent());
    }
}
