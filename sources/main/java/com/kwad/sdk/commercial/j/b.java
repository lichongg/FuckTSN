package com.kwad.sdk.commercial.j;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String awp;
    public String awq;
    public int awx;
    public int requestType;
    public int status;

    public static b Eg() {
        return new b();
    }

    public final b cG(int i6) {
        this.status = i6;
        return this;
    }

    public final b cH(int i6) {
        this.awx = i6;
        return this;
    }

    public final b cI(int i6) {
        this.requestType = i6;
        return this;
    }

    public final b db(String str) {
        this.awp = str;
        return this;
    }

    public final b dc(String str) {
        this.awq = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bP, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cJ, reason: merged with bridge method [inline-methods] */
    public final b setErrorCode(int i6) {
        super.setErrorCode(i6);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: dd, reason: merged with bridge method [inline-methods] */
    public final b setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}
