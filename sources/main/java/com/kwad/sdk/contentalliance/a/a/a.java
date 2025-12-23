package com.kwad.sdk.contentalliance.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.n;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public long adStyle;
    public long clickTime;
    public int contentType;
    public long photoId;

    public a() {
        this.clickTime = -1L;
    }

    @NonNull
    public static a bQ(@NonNull AdTemplate adTemplate) {
        return new a(adTemplate, n.eN(adTemplate));
    }

    public final String Ek() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentType", this.contentType);
            jSONObject.put("adStyle", this.adStyle);
        } catch (JSONException e6) {
            c.printStackTrace(e6);
        }
        return jSONObject.toString();
    }

    public a(@NonNull AdTemplate adTemplate, long j6) {
        this.clickTime = -1L;
        this.photoId = e.er(adTemplate);
        this.clickTime = j6;
        this.adStyle = e.eg(adTemplate);
        this.contentType = e.eh(adTemplate);
    }
}
