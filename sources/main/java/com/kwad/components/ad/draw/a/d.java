package com.kwad.components.ad.draw.a;

import com.ksad.json.annotation.KsJson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public long dy;
    public int materialType;
    public String materialUrl;
    public int status;

    public static d aN() {
        return new d();
    }

    public final d h(long j6) {
        this.dy = j6;
        return this;
    }

    public final d q(String str) {
        this.materialUrl = str;
        return this;
    }

    public final d y(int i6) {
        this.status = i6;
        return this;
    }

    public final d z(int i6) {
        this.materialType = i6;
        return this;
    }
}
