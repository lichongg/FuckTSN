package xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.unite;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class UniteControlModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "random")
    private int f55652a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "duration")
    private long f55653b;

    public long a() {
        return this.f55653b;
    }

    public int b() {
        return this.f55652a;
    }

    public UniteControlModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
