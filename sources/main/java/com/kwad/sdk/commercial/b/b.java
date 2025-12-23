package com.kwad.sdk.commercial.b;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String avN;
    public String avU;
    public String avV;
    public int avW;
    public int avX;
    public int status;
    public String url;

    public static b DU() {
        return new b();
    }

    public final b cA(int i6) {
        this.avX = i6;
        return this;
    }

    public final b cH(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.avN = url.getHost();
            this.avU = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cI(String str) {
        this.avV = str;
        return this;
    }

    public final b cy(int i6) {
        this.status = i6;
        return this;
    }

    public final b cz(int i6) {
        this.avW = i6;
        return this;
    }
}
