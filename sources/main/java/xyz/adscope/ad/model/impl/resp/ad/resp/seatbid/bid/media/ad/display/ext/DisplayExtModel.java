package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.ext;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DisplayExtModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "cmd5")
    private String f55458a;

    public String a() {
        return this.f55458a;
    }

    public DisplayExtModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
