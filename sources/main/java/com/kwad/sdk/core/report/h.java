package com.kwad.sdk.core.report;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class h extends com.kwad.sdk.core.response.a.a {
    public int aGB;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    public static h cj(AdTemplate adTemplate) {
        h hVar = new h();
        hVar.creativeId = com.kwad.sdk.core.response.b.e.ev(adTemplate);
        hVar.llsid = com.kwad.sdk.core.response.b.e.ei(adTemplate);
        int ez = com.kwad.sdk.core.response.b.e.ez(adTemplate);
        hVar.score = ez;
        hVar.aGB = ez > 0 ? 1 : 0;
        return hVar;
    }

    public final String Iu() {
        return toJson().toString();
    }
}
