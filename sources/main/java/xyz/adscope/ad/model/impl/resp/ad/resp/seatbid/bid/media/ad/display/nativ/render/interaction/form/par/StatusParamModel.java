package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.par;

import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class StatusParamModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = PrerollVideoResponse.NORMAL)
    private String f55548a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "passivation")
    private String f55549b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "cool")
    private String f55550c;

    public String a() {
        return this.f55550c;
    }

    public String b() {
        return this.f55548a;
    }

    public String c() {
        return this.f55549b;
    }

    public StatusParamModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
