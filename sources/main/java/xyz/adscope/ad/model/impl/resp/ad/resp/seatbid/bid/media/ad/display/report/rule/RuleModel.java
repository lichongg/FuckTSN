package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.report.rule;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class RuleModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "type")
    private int f55586a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "repDelay")
    private String f55587b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "repRandomDelay")
    private int f55588c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "calExposureTime")
    private int f55589d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "calRandomNum")
    private int f55590e;

    public int a() {
        return this.f55589d;
    }

    public int b() {
        return this.f55590e;
    }

    public String c() {
        return this.f55587b;
    }

    public int d() {
        return this.f55588c;
    }

    public int e() {
        return this.f55586a;
    }

    public RuleModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
