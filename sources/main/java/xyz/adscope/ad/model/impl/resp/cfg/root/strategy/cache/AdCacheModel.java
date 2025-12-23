package xyz.adscope.ad.model.impl.resp.cfg.root.strategy.cache;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AdCacheModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "enable")
    private int f55640a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "reqAdTimeLimit")
    private long f55641b;

    public int a() {
        return this.f55640a;
    }

    public long b() {
        return this.f55641b;
    }

    public AdCacheModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
