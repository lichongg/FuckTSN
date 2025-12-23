package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.par;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ClickAreaParams extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "randomNum")
    private int f55507a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "reference")
    private int f55508b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "width")
    private String f55509c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "height")
    private String f55510d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "horizontalSpace")
    private String f55511e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = "verticalSpace")
    private String f55512f;

    /* renamed from: g, reason: collision with root package name */
    @JsonParseNode(key = "needTime")
    private int f55513g;

    /* renamed from: h, reason: collision with root package name */
    @JsonParseNode(key = "durationTime")
    private int f55514h;

    public int a() {
        return this.f55514h;
    }

    public String b() {
        return this.f55510d;
    }

    public String c() {
        return this.f55511e;
    }

    public int d() {
        return this.f55513g;
    }

    public int e() {
        return this.f55507a;
    }

    public int f() {
        return this.f55508b;
    }

    public String g() {
        return this.f55512f;
    }

    public String h() {
        return this.f55509c;
    }

    public ClickAreaParams(JSONObject jSONObject) {
        super(jSONObject);
    }
}
