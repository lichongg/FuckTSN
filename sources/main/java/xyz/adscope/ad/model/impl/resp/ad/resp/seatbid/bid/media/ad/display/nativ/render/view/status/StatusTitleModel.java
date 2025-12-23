package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.status;

import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.par.StatusParamModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class StatusTitleModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = PrerollVideoResponse.NORMAL)
    private StatusParamModel f55582a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "download")
    private StatusParamModel f55583b;

    public StatusParamModel a() {
        return this.f55583b;
    }

    public StatusParamModel b() {
        return this.f55582a;
    }

    public StatusTitleModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
