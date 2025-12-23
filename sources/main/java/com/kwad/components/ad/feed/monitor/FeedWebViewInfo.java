package com.kwad.components.ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class FeedWebViewInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = -4316140680874648788L;
    public int timeType;
    public String event = "";
    public String url = "";
    public String sceneId = "";
    public long durationMs = -1;

    public FeedWebViewInfo setDurationMs(long j6) {
        this.durationMs = j6;
        return this;
    }

    public FeedWebViewInfo setEvent(String str) {
        this.event = str;
        return this;
    }

    public FeedWebViewInfo setSceneId(String str) {
        this.sceneId = str;
        return this;
    }

    public FeedWebViewInfo setTimeType(int i6) {
        this.timeType = i6;
        return this;
    }

    public FeedWebViewInfo setUrl(String str) {
        this.url = str;
        return this;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        if (this.durationMs == -1) {
            jSONObject.remove("duration_ms");
        }
    }
}
