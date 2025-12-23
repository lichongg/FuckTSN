package xyz.adscope.ad.model.impl.resp.cfg.root.update;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class UpdateModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "expireTime")
    private long f55656a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "maxExpireTime")
    private long f55657b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "checkInterval")
    private int f55658c;

    public int a() {
        return this.f55658c;
    }

    public long b() {
        return this.f55656a;
    }

    public long c() {
        return this.f55657b;
    }

    public UpdateModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
