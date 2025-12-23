package xyz.adscope.ad.model.impl.resp.cfg.root.strategy;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.cache.AdCacheModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class StrategyModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "spaceId")
    private String f55638a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "adCache")
    private AdCacheModel f55639b;

    public AdCacheModel a() {
        return this.f55639b;
    }

    public String b() {
        return this.f55638a;
    }

    public StrategyModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
