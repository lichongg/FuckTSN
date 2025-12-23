package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.par.ClickAreaParams;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.par.SlideParams;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class OptimizeModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "touchDownNum")
    private int f55502a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "slideNum")
    private int f55503b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "closeClickNum")
    private int f55504c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "adSlide")
    private SlideParams f55505d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "clickArea")
    private ClickAreaParams f55506e;

    public ClickAreaParams a() {
        return this.f55506e;
    }

    public int b() {
        return this.f55504c;
    }

    public int c() {
        return this.f55503b;
    }

    public SlideParams d() {
        return this.f55505d;
    }

    public int e() {
        return this.f55502a;
    }

    public OptimizeModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
