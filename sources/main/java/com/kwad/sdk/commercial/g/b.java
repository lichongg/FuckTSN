package com.kwad.sdk.commercial.g;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int To;
    public String avN;
    public String avU;
    public int status;
    public String url;

    public static b DZ() {
        return new b();
    }

    public final b cD(int i6) {
        this.status = i6;
        return this;
    }

    public final b cE(int i6) {
        this.To = i6;
        return this;
    }

    public final b cR(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.avN = url.getHost();
            this.avU = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }
}
