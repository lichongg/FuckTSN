package xyz.adscope.ad.model.impl.resp.cfg.root.temp;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class TemplateModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "schemeId")
    private String f55654a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "adType")
    private String f55655b;

    public String a() {
        return this.f55655b;
    }

    public String b() {
        return this.f55654a;
    }

    public TemplateModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
