package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.layout.par;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.dev.info.ResIdentify;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class LayoutParamModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "size")
    private String f55561a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "reference")
    private String f55562b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = ResIdentify.RES_TYPE_LAYOUT)
    private String f55563c;

    public String a() {
        return this.f55563c;
    }

    public String b() {
        return this.f55562b;
    }

    public String c() {
        return this.f55561a;
    }

    public LayoutParamModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
