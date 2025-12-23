package com.kwad.sdk.core.adlog.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int awx;
    public boolean axD;
    public int axE;
    public int axF;
    public long axG;
    public int axt;
    public String axu;
    public int retryCount;
    public int status;

    public static b EI() {
        return new b();
    }

    public final b at(long j6) {
        this.axG = j6;
        return this;
    }

    public final b bp(boolean z5) {
        this.axD = z5;
        return this;
    }

    public final b cL(int i6) {
        this.status = i6;
        return this;
    }

    public final b cM(int i6) {
        this.awx = i6;
        return this;
    }

    public final b cN(int i6) {
        this.retryCount = i6;
        return this;
    }

    public final b cO(int i6) {
        this.axt = i6;
        return this;
    }

    public final b cP(int i6) {
        this.axE = i6;
        return this;
    }

    public final b cQ(int i6) {
        this.axF = i6;
        return this;
    }

    /* renamed from: do, reason: not valid java name */
    public final b m119do(String str) {
        this.axu = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cf, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }
}
