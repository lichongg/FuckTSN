package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.report;

import java.util.List;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.report.rule.RuleModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ReportModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "exposureArea")
    private int f55584a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "rule")
    private List<RuleModel> f55585b;

    public int a() {
        return this.f55584a;
    }

    public List<RuleModel> b() {
        return this.f55585b;
    }

    public ReportModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
