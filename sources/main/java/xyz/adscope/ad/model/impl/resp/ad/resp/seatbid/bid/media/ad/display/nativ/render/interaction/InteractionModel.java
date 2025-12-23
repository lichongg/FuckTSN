package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction;

import android.text.TextUtils;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.EulerAngleModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.ShakeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.SlideModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class InteractionModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "bindEvent")
    private String f55524a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "execution")
    private String f55525b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "countDownTime")
    private int f55526c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "passivationTime")
    private long f55527d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "passivationType")
    private int f55528e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = "protectTime")
    private long f55529f;

    /* renamed from: g, reason: collision with root package name */
    @JsonParseNode(key = "coolTime")
    private long f55530g;

    /* renamed from: h, reason: collision with root package name */
    @JsonParseNode(key = "feedbackAnimation")
    private int f55531h;

    /* renamed from: i, reason: collision with root package name */
    @JsonParseNode(key = "autoClose")
    private int f55532i;

    /* renamed from: j, reason: collision with root package name */
    @JsonParseNode(key = "shake")
    private ShakeModel f55533j;

    /* renamed from: k, reason: collision with root package name */
    @JsonParseNode(key = "eulerAngle")
    private EulerAngleModel f55534k;

    /* renamed from: l, reason: collision with root package name */
    @JsonParseNode(key = "slide")
    private SlideModel f55535l;

    public String a() {
        return (TextUtils.isEmpty(this.f55524a) || "none".equalsIgnoreCase(this.f55524a)) ? "" : this.f55524a;
    }

    public long b() {
        return this.f55530g;
    }

    public int c() {
        return this.f55526c;
    }

    public EulerAngleModel d() {
        return this.f55534k;
    }

    public String e() {
        return this.f55525b;
    }

    public int f() {
        return this.f55531h;
    }

    public long g() {
        return this.f55527d;
    }

    public int h() {
        return this.f55528e;
    }

    public long i() {
        return this.f55529f;
    }

    public ShakeModel j() {
        return this.f55533j;
    }

    public SlideModel k() {
        return this.f55535l;
    }

    public boolean l() {
        return this.f55532i == 1;
    }

    public InteractionModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
