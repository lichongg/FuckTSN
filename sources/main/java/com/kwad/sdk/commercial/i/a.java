package com.kwad.sdk.commercial.i;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends com.kwad.sdk.commercial.c.a {
    public String awh;
    public String awp;
    public String awq;
    public String awr;

    public static a Ec() {
        return new a();
    }

    public final a cT(String str) {
        this.awr = str;
        return this;
    }

    public final a cU(String str) {
        this.awh = str;
        return this;
    }

    public final a cV(String str) {
        this.awp = str;
        return this;
    }

    public final a cW(String str) {
        this.awq = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bO, reason: merged with bridge method [inline-methods] */
    public final a setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }
}
