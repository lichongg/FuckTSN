package com.kwad.components.core.o.c;

import com.ksad.json.annotation.KsJson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String ST;
    public long SU;
    public long SV;
    public String SX;
    public long SY;

    public final d H(long j6) {
        this.SU = j6;
        return this;
    }

    public final d I(long j6) {
        this.SV = j6;
        return this;
    }

    public final d J(long j6) {
        this.SY = j6;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: aN, reason: merged with bridge method [inline-methods] */
    public final d setErrorCode(int i6) {
        this.errorCode = i6;
        return this;
    }

    public final d aw(String str) {
        this.ST = str;
        return this;
    }

    public final d ax(String str) {
        this.errorMsg = str;
        return this;
    }

    public final d ay(String str) {
        this.SX = str;
        return this;
    }
}
