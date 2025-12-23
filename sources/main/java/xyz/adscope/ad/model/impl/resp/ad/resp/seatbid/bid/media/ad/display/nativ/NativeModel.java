package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ;

import java.util.List;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.DownloadInfoModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.link.LinkModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.OptimizeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class NativeModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "link")
    private LinkModel f55459a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "asset")
    private List<AssetModel> f55460b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "schemeId")
    private String f55461c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "scheme")
    private List<RenderModel> f55462d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "dwinfo")
    private DownloadInfoModel f55463e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = "optimize")
    private List<OptimizeModel> f55464f;

    public List<AssetModel> a() {
        return this.f55460b;
    }

    public DownloadInfoModel b() {
        return this.f55463e;
    }

    public LinkModel c() {
        return this.f55459a;
    }

    public List<OptimizeModel> d() {
        return this.f55464f;
    }

    public List<RenderModel> e() {
        return this.f55462d;
    }

    public String f() {
        return this.f55461c;
    }

    public NativeModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
