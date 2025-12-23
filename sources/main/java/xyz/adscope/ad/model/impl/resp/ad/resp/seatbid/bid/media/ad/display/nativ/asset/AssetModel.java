package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.type.ImageModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.type.TitleModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.type.VideoModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AssetModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "id")
    private String f55465a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = SocializeProtocolConstants.IMAGE)
    private ImageModel f55466b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "video")
    private VideoModel f55467c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "title")
    private TitleModel f55468d;

    public String a() {
        return this.f55465a;
    }

    public ImageModel b() {
        return this.f55466b;
    }

    public TitleModel c() {
        return this.f55468d;
    }

    public VideoModel d() {
        return this.f55467c;
    }

    public AssetModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
