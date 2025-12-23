package xyz.adscope.ad.model.impl.resp.ad.resp;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.ext.ResponseExtModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.SeatBidModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class AdResponseModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "seatbid")
    private List<SeatBidModel> f55433a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)
    private ResponseExtModel f55434b;

    public ResponseExtModel a() {
        return this.f55434b;
    }

    public List<SeatBidModel> b() {
        return this.f55433a;
    }

    public AdResponseModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
