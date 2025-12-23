package xyz.adscope.ad;

import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.common.v2.model.IJsonMappingModel;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class i2 implements IJsonMappingModel {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f55224a;

    public i2() {
    }

    private String a() {
        return JsonUtil.parseEntry2Json(this).toString();
    }

    public i2(JSONObject jSONObject) {
        this.f55224a = jSONObject;
        a(jSONObject);
    }

    protected void a(JSONObject jSONObject) {
        try {
            JsonUtil.parseJson2Entry(this, jSONObject);
        } catch (JSONException unused) {
        }
    }

    @Override // xyz.adscope.common.v2.model.IJsonMappingModel
    public String toJsonString() {
        JSONObject jSONObject = this.f55224a;
        return jSONObject != null ? jSONObject.toString() : a();
    }
}
