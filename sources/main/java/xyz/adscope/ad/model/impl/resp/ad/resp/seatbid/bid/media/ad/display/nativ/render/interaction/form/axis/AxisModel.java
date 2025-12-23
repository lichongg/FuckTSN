package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.axis;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.par.StatusParamModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AxisModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "angle")
    private StatusParamModel f55546a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "direction")
    private StatusParamModel f55547b;

    public StatusParamModel a() {
        return this.f55546a;
    }

    public StatusParamModel b() {
        return this.f55547b;
    }

    public AxisModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
