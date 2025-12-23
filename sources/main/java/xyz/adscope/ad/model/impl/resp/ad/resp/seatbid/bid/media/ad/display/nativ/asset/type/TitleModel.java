package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.type;

import com.baidu.mobads.sdk.internal.a;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class TitleModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = a.f10501b)
    private String f55472a;

    public String a() {
        return this.f55472a;
    }

    public TitleModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
