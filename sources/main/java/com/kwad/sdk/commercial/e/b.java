package com.kwad.sdk.commercial.e;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String awh;
    public String awi;

    public static b DW() {
        return new b();
    }

    public final b cM(String str) {
        this.awh = str;
        return this;
    }

    public final b cN(String str) {
        this.awi = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bN, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }
}
