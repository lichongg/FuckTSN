package xyz.adscope.ad.model.impl.resp.cfg.root.log2;

import org.json.JSONObject;
import xyz.adscope.ad.f0;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class Analyse2ConfigModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    private final String f55613a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "version")
    private String f55614b;

    public String a() {
        return this.f55614b;
    }

    public Analyse2ConfigModel(JSONObject jSONObject) {
        super(jSONObject);
        this.f55613a = f0.e();
    }
}
