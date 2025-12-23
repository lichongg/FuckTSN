package xyz.adscope.ad.model.impl.resp.cfg.root.requrl;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class RequestUrlModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "configUrl")
    private String f55615a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "adUrl")
    private String f55616b;

    public String a() {
        return this.f55616b;
    }

    public String b() {
        return this.f55615a;
    }

    public RequestUrlModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
