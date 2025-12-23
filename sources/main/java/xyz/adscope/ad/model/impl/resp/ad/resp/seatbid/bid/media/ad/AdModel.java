package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.DisplayModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AdModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "id")
    private String f55447a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "adType")
    private String f55448b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "display")
    private DisplayModel f55449c;

    public String a() {
        return this.f55448b;
    }

    public DisplayModel b() {
        return this.f55449c;
    }

    public String c() {
        return this.f55447a;
    }

    public AdModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
