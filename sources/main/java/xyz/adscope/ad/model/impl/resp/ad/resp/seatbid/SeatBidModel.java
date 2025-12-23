package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.BidModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.ext.SeatExtModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SeatBidModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "bid")
    private List<BidModel> f55437a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)
    private SeatExtModel f55438b;

    public List<BidModel> a() {
        return this.f55437a;
    }

    public SeatExtModel b() {
        return this.f55438b;
    }

    public SeatBidModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
