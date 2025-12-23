package xyz.adscope.common.analyse2.base.model;

import org.json.JSONObject;
import xyz.adscope.common.v2.model.IBaseFromJsonModel;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AnalyseBasicReceiveLog extends IBaseFromJsonModel {
    public JSONObject a() {
        return JsonUtil.entry2JsonObject(this, true);
    }

    public AnalyseBasicReceiveLog(JSONObject jSONObject) {
        super(jSONObject);
    }
}
