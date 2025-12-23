package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media;

import com.umeng.analytics.pro.bi;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.AdModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class MediaModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = bi.az)
    private AdModel f55446a;

    public AdModel a() {
        return this.f55446a;
    }

    public MediaModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
