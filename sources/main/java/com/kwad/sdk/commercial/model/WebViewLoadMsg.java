package com.kwad.sdk.commercial.model;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class WebViewLoadMsg extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int FAIL = 2;
    public static final int SUCCESS = 1;
    private static final long serialVersionUID = -8132509704708242619L;
    public String costTime;
    public String failReason;
    public String interval;
    public int state;
    public String url;

    public WebViewLoadMsg setCostTime(String str) {
        this.costTime = str;
        return this;
    }

    public WebViewLoadMsg setFailReason(String str) {
        this.failReason = str;
        return this;
    }

    public WebViewLoadMsg setInterval(String str) {
        this.interval = str;
        return this;
    }

    public WebViewLoadMsg setState(int i6) {
        this.state = i6;
        return this;
    }

    public WebViewLoadMsg setUrl(String str) {
        this.url = str;
        return this;
    }
}
