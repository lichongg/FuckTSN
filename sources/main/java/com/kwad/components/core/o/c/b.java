package com.kwad.components.core.o.c;

import com.ksad.json.annotation.KsJson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String ST;
    public long SU;
    public long SV;
    public long SW;
    public String SX;

    public final b aL(int i6) {
        this.SW = i6;
        return this;
    }

    public final b F(long j6) {
        this.SU = j6;
        return this;
    }

    public final b G(long j6) {
        this.SV = j6;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: aM, reason: merged with bridge method [inline-methods] */
    public final b setErrorCode(int i6) {
        this.errorCode = i6;
        return this;
    }

    public final b at(String str) {
        this.ST = str;
        return this;
    }

    public final b au(String str) {
        this.errorMsg = str;
        return this;
    }

    public final b av(String str) {
        this.SX = str;
        return this;
    }
}
