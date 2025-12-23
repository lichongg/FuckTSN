package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.par.StatusParamModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ShakeModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "startAmplitude")
    private StatusParamModel f55539a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "endAmplitude")
    private StatusParamModel f55540b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "count")
    private StatusParamModel f55541c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "axial")
    private StatusParamModel f55542d;

    public StatusParamModel a() {
        return this.f55542d;
    }

    public StatusParamModel b() {
        return this.f55541c;
    }

    public StatusParamModel c() {
        return this.f55540b;
    }

    public StatusParamModel d() {
        return this.f55539a;
    }

    public ShakeModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
