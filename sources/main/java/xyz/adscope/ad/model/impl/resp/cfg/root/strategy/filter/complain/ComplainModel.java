package xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.complain;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ComplainModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "duration")
    private long f55647a;

    public long a() {
        return this.f55647a;
    }

    public ComplainModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
