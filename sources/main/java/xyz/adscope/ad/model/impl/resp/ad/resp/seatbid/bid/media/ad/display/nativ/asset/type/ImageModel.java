package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.type;

import com.baidu.mobads.sdk.api.IAdInterListener;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ImageModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "url")
    private String f55469a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = IAdInterListener.AdReqParam.WIDTH)
    private String f55470b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "h")
    private String f55471c;

    public String a() {
        return this.f55471c;
    }

    public String b() {
        return this.f55470b;
    }

    public String c() {
        return this.f55469a;
    }

    public ImageModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
