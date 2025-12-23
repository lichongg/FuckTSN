package xyz.adscope.common.analyse2.base.model.init;

import org.json.JSONObject;
import xyz.adscope.common.analyse2.base.model.AnalyseBasicReceiveLog;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AnalyseChannelModel extends AnalyseBasicReceiveLog {

    @JsonParseNode(key = "version")
    private String code;

    @JsonParseNode(key = "channel")
    private String name;

    public AnalyseChannelModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
