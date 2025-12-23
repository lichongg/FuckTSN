package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class g extends com.kwad.sdk.core.response.a.a {
    public String aIL;
    public String aIM;
    public int thirdAge;
    public int thirdGender;
    public String thirdInterest;

    public static g IP() {
        return new g();
    }

    public final g ex(String str) {
        this.aIL = str;
        return this;
    }
}
