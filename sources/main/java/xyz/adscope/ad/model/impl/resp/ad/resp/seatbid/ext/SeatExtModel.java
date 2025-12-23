package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.ext;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class SeatExtModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "uid")
    private String f55591a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = CommonNetImpl.NAME)
    private String f55592b;

    public String a() {
        return this.f55591a;
    }

    public String b() {
        return this.f55592b;
    }

    public SeatExtModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
