package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.par.StatusParamModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SlideModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    private final String f55543a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "distance")
    private StatusParamModel f55544b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "direction")
    private StatusParamModel f55545c;

    public String a(String str) {
        return this.f55545c != null ? "Cooling".equalsIgnoreCase(str) ? this.f55545c.a() : this.f55545c.b() : "UP";
    }

    public int b(String str) {
        if (this.f55544b != null) {
            return "Cooling".equalsIgnoreCase(str) ? StringUtil.parseInt(this.f55544b.a()) : StringUtil.parseInt(this.f55544b.b());
        }
        return 0;
    }

    public SlideModel(JSONObject jSONObject) {
        super(jSONObject);
        this.f55543a = "Cooling";
    }
}
