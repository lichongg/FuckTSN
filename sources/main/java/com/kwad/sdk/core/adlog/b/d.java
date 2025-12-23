package com.kwad.sdk.core.adlog.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String awq;
    public int awx;
    public int axH;
    public int retryCount;
    public int status;

    public final d cT(int i6) {
        this.axH = 1;
        return this;
    }

    public static d EJ() {
        return new d();
    }

    public final d cR(int i6) {
        this.status = i6;
        return this;
    }

    public final d cS(int i6) {
        this.awx = i6;
        return this;
    }

    public final d cU(int i6) {
        this.retryCount = i6;
        return this;
    }

    public final d dp(String str) {
        this.awq = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cV, reason: merged with bridge method [inline-methods] */
    public final d setErrorCode(int i6) {
        super.setErrorCode(i6);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cg, reason: merged with bridge method [inline-methods] */
    public final d setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: dq, reason: merged with bridge method [inline-methods] */
    public final d setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}
