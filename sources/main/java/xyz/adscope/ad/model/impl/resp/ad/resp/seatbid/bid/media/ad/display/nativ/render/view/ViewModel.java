package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.status.StatusTitleModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ViewModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "controlType")
    private String f55564a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "borderSize")
    private String f55565b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "borderColor")
    private String f55566c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "borderRadius")
    private String f55567d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "bgColor")
    private String f55568e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = "assetId")
    private String f55569f;

    /* renamed from: g, reason: collision with root package name */
    @JsonParseNode(key = "fontSize")
    private int f55570g;

    /* renamed from: h, reason: collision with root package name */
    @JsonParseNode(key = "textColor")
    private String f55571h;

    /* renamed from: i, reason: collision with root package name */
    @JsonParseNode(key = "textAlign")
    private String f55572i;

    /* renamed from: j, reason: collision with root package name */
    @JsonParseNode(key = "lineCount")
    private int f55573j;

    /* renamed from: k, reason: collision with root package name */
    @JsonParseNode(key = "title")
    private String f55574k;

    /* renamed from: l, reason: collision with root package name */
    @JsonParseNode(key = "imageUrl")
    private String f55575l;

    /* renamed from: m, reason: collision with root package name */
    @JsonParseNode(key = "voiceOn")
    private int f55576m;

    /* renamed from: n, reason: collision with root package name */
    @JsonParseNode(key = "animationType")
    private String f55577n;

    /* renamed from: o, reason: collision with root package name */
    @JsonParseNode(key = "isBlur")
    private int f55578o;

    /* renamed from: p, reason: collision with root package name */
    @JsonParseNode(key = "interactiveTitle")
    private StatusTitleModel f55579p;

    /* renamed from: q, reason: collision with root package name */
    @JsonParseNode(key = "interactiveSubTitle")
    private StatusTitleModel f55580q;

    /* renamed from: r, reason: collision with root package name */
    private String f55581r;

    public void a(String str) {
        this.f55581r = str;
    }

    public String a() {
        return this.f55577n;
    }

    public String b() {
        return this.f55569f;
    }

    public String c() {
        return this.f55568e;
    }

    public String d() {
        return this.f55566c;
    }

    public String e() {
        return this.f55567d;
    }

    public String f() {
        return this.f55565b;
    }

    public String g() {
        return this.f55581r;
    }

    public String h() {
        return this.f55564a;
    }

    public int i() {
        return this.f55570g;
    }

    public String j() {
        return this.f55575l;
    }

    public StatusTitleModel k() {
        return this.f55580q;
    }

    public StatusTitleModel l() {
        return this.f55579p;
    }

    public int m() {
        int i6 = this.f55573j;
        if (i6 > 0) {
            return i6;
        }
        return 1;
    }

    public String n() {
        return this.f55572i;
    }

    public String o() {
        return this.f55571h;
    }

    public String p() {
        return this.f55574k;
    }

    public boolean q() {
        return this.f55576m <= 0;
    }

    public boolean r() {
        return this.f55578o == 1;
    }

    public ViewModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
