package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.type;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class VideoModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "adm")
    private String f55473a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "curl")
    private String f55474b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "url")
    private String f55475c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = IAdInterListener.AdReqParam.WIDTH)
    private String f55476d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "h")
    private String f55477e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION)
    private int f55478f;

    public String a() {
        return this.f55473a;
    }

    public String b() {
        return this.f55474b;
    }

    public int c() {
        return this.f55478f;
    }

    public String d() {
        return this.f55475c;
    }

    public String e() {
        return this.f55477e;
    }

    public String f() {
        return this.f55476d;
    }

    public VideoModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
