package com.kwad.sdk.commercial.smallApp;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String avN;
    public String avU;
    public String aws;
    public String awt;
    public String awu;
    public int status;
    public String url;

    public static b a(JumpFrom jumpFrom) {
        return new b(jumpFrom);
    }

    public final b cF(int i6) {
        this.status = i6;
        return this;
    }

    public final b cX(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.avN = url.getHost();
            this.avU = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cY(String str) {
        this.aws = str;
        return this;
    }

    public final b cZ(String str) {
        this.awt = str;
        return this;
    }

    private b(JumpFrom jumpFrom) {
        if (jumpFrom != null) {
            this.awu = jumpFrom.getValue();
        }
    }
}
