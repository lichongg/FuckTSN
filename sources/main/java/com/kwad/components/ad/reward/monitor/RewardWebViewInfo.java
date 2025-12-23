package com.kwad.components.ad.reward.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class RewardWebViewInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = -4316140680874648788L;
    public int status;
    public int timeType;
    public String event = "";
    public String url = "";
    public String source = "";
    public String sceneId = "";
    public String pageType = "";
    public long durationMs = -1;

    public RewardWebViewInfo setDurationMs(long j6) {
        this.durationMs = j6;
        return this;
    }

    public RewardWebViewInfo setEvent(String str) {
        this.event = str;
        return this;
    }

    public RewardWebViewInfo setPageType(String str) {
        this.pageType = str;
        return this;
    }

    public RewardWebViewInfo setSceneId(String str) {
        this.sceneId = str;
        return this;
    }

    public RewardWebViewInfo setSource(String str) {
        this.source = str;
        return this;
    }

    public RewardWebViewInfo setStatus(int i6) {
        this.status = i6;
        return this;
    }

    public RewardWebViewInfo setTimeType(int i6) {
        this.timeType = i6;
        return this;
    }

    public RewardWebViewInfo setUrl(String str) {
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
