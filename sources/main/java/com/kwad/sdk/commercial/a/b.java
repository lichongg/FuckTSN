package com.kwad.sdk.commercial.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String avN;
    public String avO;
    public String avP;
    public long avQ;
    public long avR;
    public int avS;
    public int avT;
    public String downloadId;
    public long downloadTime;
    public int status;
    public String url;

    public static b DT() {
        return new b();
    }

    public final b ar(long j6) {
        this.downloadTime = j6;
        return this;
    }

    public final b cv(int i6) {
        this.status = i6;
        return this;
    }

    public final b cw(int i6) {
        this.avS = i6;
        return this;
    }

    public final b cx(int i6) {
        this.avT = i6;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bn, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        AdInfo el = e.el(adTemplate);
        this.url = e.eo(adTemplate);
        try {
            this.avN = new URL(this.url).getHost();
        } catch (Throwable unused) {
        }
        this.downloadId = el.downloadId;
        AdInfo.AdBaseInfo adBaseInfo = el.adBaseInfo;
        this.avO = adBaseInfo.appPackageName;
        this.avP = adBaseInfo.appName;
        this.avQ = el.totalBytes;
        this.avR = el.soFarBytes;
        return this;
    }
}
