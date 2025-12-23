package xyz.adscope.common.analyse2.base.model.biz;

import org.json.JSONObject;
import xyz.adscope.common.analyse2.base.model.AnalyseBasicReceiveLog;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AnalyseSimpleLog extends AnalyseBasicReceiveLog {

    @JsonParseNode(key = "error_code")
    private String error_code;

    @JsonParseNode(key = "error_info")
    private String error_info;

    @JsonParseNode(key = "cost_time")
    private String mCostTime;

    @JsonParseNode(key = "event_code")
    private String mEventCode;

    @JsonParseNode(key = "event_id")
    private String mEventID;

    @JsonParseNode(key = "event_time")
    private String mEventTime;

    @JsonParseNode(key = "sample")
    private String mSample;

    public void a(String str) {
        this.mSample = str;
    }

    public String b() {
        return this.mEventCode;
    }

    public AnalyseSimpleLog(JSONObject jSONObject) {
        super(jSONObject);
    }
}
