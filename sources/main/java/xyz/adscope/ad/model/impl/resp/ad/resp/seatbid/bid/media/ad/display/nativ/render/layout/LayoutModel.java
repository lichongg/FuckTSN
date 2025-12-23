package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.layout;

import android.text.TextUtils;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.layout.par.LayoutParamModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class LayoutModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "width")
    private LayoutParamModel f55551a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "height")
    private LayoutParamModel f55552b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "marginTop")
    private LayoutParamModel f55553c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "marginRight")
    private LayoutParamModel f55554d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "marginBottom")
    private LayoutParamModel f55555e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = "marginLeft")
    private LayoutParamModel f55556f;

    /* renamed from: g, reason: collision with root package name */
    @JsonParseNode(key = "centerX")
    private LayoutParamModel f55557g;

    /* renamed from: h, reason: collision with root package name */
    @JsonParseNode(key = "centerY")
    private LayoutParamModel f55558h;

    /* renamed from: i, reason: collision with root package name */
    @JsonParseNode(key = "maxHeight")
    private String f55559i;

    /* renamed from: j, reason: collision with root package name */
    @JsonParseNode(key = "minHeight")
    private String f55560j;

    public LayoutParamModel a() {
        return this.f55557g;
    }

    public LayoutParamModel b() {
        return this.f55558h;
    }

    public LayoutParamModel c() {
        return this.f55552b;
    }

    public LayoutParamModel d() {
        return this.f55555e;
    }

    public LayoutParamModel e() {
        return this.f55556f;
    }

    public LayoutParamModel f() {
        return this.f55554d;
    }

    public LayoutParamModel g() {
        return this.f55553c;
    }

    public String h() {
        return this.f55559i;
    }

    public String i() {
        return this.f55560j;
    }

    public LayoutParamModel j() {
        return this.f55551a;
    }

    public boolean k() {
        LayoutParamModel layoutParamModel = this.f55552b;
        if (layoutParamModel != null && !TextUtils.isEmpty(layoutParamModel.c())) {
            String trim = this.f55552b.c().trim();
            if (!"0".equalsIgnoreCase(trim) && !"0%".equalsIgnoreCase(trim)) {
                return false;
            }
        }
        return true;
    }

    public LayoutModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
