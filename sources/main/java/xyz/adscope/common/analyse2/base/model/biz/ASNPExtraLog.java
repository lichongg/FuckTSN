package xyz.adscope.common.analyse2.base.model.biz;

import org.json.JSONObject;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPExtraLog extends AnalyseAdEventLog {

    @JsonParseNode(key = "click_type")
    private String clickType;

    @JsonParseNode(key = "creative_id")
    private String creativeId;

    @JsonParseNode(key = "dsp_id")
    private String dspId;

    @JsonParseNode(key = "ecpm")
    private String ecpm;

    @JsonParseNode(key = "floor_price")
    private String floorPrice;

    @JsonParseNode(key = "material_id")
    private String materialId;

    @JsonParseNode(key = "order_id")
    private String orderId;

    @JsonParseNode(key = "scheme_id")
    private String schemeId;

    public ASNPExtraLog(JSONObject jSONObject) {
        super(jSONObject);
    }
}
