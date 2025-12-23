package xyz.adscope.common.v2.model;

import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class IBaseFromJsonModel implements IJsonMappingModel {
    private boolean hasParseException = false;
    protected JSONObject mJsonObject;

    protected void parseFormJson(JSONObject jSONObject) {
        try {
            if (jSONObject != null) {
                JsonUtil.parseJson2Entry(this, jSONObject);
            } else {
                this.hasParseException = true;
            }
        } catch (JSONException unused) {
            this.hasParseException = true;
        }
    }

    public JSONObject asJsonObject() {
        return this.mJsonObject;
    }

    public boolean hasParseException() {
        return this.hasParseException;
    }

    @Override // xyz.adscope.common.v2.model.IJsonMappingModel
    public String toJsonString() {
        JSONObject jSONObject = this.mJsonObject;
        return jSONObject != null ? jSONObject.toString() : "";
    }

    public IBaseFromJsonModel(JSONObject jSONObject) {
        this.mJsonObject = jSONObject;
        parseFormJson(jSONObject);
    }
}
