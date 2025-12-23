package com.kwad.components.ad.draw.a;

import com.ksad.json.annotation.KsJson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends com.kwad.sdk.commercial.c.a {
    public int adNum;
    public int adStyle;
    public long dw;
    public int dx;
    public long loadTime;
    public int materialType;
    public String materialUrl;
    public String methodName;
    public long renderTime;
    public int renderType;
    public int status;

    public static a aM() {
        return new a();
    }

    public final a e(long j6) {
        this.loadTime = j6;
        return this;
    }

    public final a f(long j6) {
        this.renderTime = j6;
        return this;
    }

    public final a g(long j6) {
        this.dw = j6;
        return this;
    }

    public final a o(String str) {
        this.methodName = str;
        return this;
    }

    public final a p(String str) {
        this.materialUrl = str;
        return this;
    }

    public final a s(int i6) {
        this.status = i6;
        return this;
    }

    public final a t(int i6) {
        this.adNum = i6;
        return this;
    }

    public final a u(int i6) {
        this.materialType = i6;
        return this;
    }

    public final a v(int i6) {
        this.renderType = i6;
        return this;
    }

    public final a w(int i6) {
        this.dx = i6;
        return this;
    }

    public final a x(int i6) {
        this.adStyle = i6;
        return this;
    }
}
