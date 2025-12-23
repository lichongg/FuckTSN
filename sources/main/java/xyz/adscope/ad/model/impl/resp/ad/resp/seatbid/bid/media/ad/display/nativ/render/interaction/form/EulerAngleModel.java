package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.axis.AxisModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class EulerAngleModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "xAxis")
    private AxisModel f55536a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "yAxis")
    private AxisModel f55537b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "zAxis")
    private AxisModel f55538c;

    public AxisModel a() {
        return this.f55536a;
    }

    public AxisModel b() {
        return this.f55537b;
    }

    public AxisModel c() {
        return this.f55538c;
    }

    public EulerAngleModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
