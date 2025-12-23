package xyz.adscope.common.analyse2.base.model.biz;

import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AnalyseAdEventLog extends AnalyseSimpleLog {

    @JsonParseNode(exclude = true, key = AMPSConstants.RESOURCE_HEAD)
    private AnalyseAdCommon amps;

    @JsonParseNode(exclude = true, key = "asnp")
    private AnalyseAdCommon asnp;

    public AnalyseAdCommon c() {
        AnalyseAdCommon analyseAdCommon = this.amps;
        if (analyseAdCommon != null) {
            return analyseAdCommon;
        }
        AnalyseAdCommon analyseAdCommon2 = this.asnp;
        if (analyseAdCommon2 != null) {
            return analyseAdCommon2;
        }
        return null;
    }

    public AnalyseAdEventLog(JSONObject jSONObject) {
        super(jSONObject);
    }
}
