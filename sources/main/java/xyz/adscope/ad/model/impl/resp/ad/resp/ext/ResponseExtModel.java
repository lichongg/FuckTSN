package xyz.adscope.ad.model.impl.resp.ad.resp.ext;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ResponseExtModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "updateCfg")
    private boolean f55435a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "updateTime")
    private long f55436b;

    public long a() {
        return this.f55436b;
    }

    public boolean b() {
        return this.f55435a;
    }

    public ResponseExtModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
