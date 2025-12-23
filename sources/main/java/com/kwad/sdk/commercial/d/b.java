package com.kwad.sdk.commercial.d;

import com.ksad.json.annotation.KsJson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int adNum;
    public String adSource;
    public boolean awd;
    public boolean awe;
    public String awf;
    public String methodName;

    public static b DV() {
        return new b();
    }

    public final b bn(boolean z5) {
        this.awd = z5;
        return this;
    }

    public final b cB(int i6) {
        this.adNum = i6;
        return this;
    }

    public final b cJ(String str) {
        this.methodName = str;
        return this;
    }

    public final b cK(String str) {
        this.awf = str;
        return this;
    }

    public final b cL(String str) {
        this.adSource = str;
        return this;
    }
}
