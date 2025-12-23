package xyz.adscope.ad.model.impl.resp.cfg.root.beta;

import com.umeng.analytics.AnalyticsConfig;
import org.json.JSONObject;
import xyz.adscope.ad.f0;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.beta.IBetaTestConfig;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class BetaTestPlanModel extends ASNPJsonResponseModel implements IBetaTestConfig {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "random")
    private String f55608a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = AnalyticsConfig.RTD_START_TIME)
    private String f55609b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "endTime")
    private String f55610c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "duration")
    private String f55611d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "planId")
    private String f55612e;

    @Override // xyz.adscope.common.v2.beta.IBetaTestConfig
    public String getBetaTestPlanID() {
        return this.f55612e;
    }

    @Override // xyz.adscope.common.v2.beta.IBetaTestConfig
    public long getDurationMillisecond() {
        return StringUtil.parseLong(this.f55611d);
    }

    @Override // xyz.adscope.common.v2.beta.IBetaTestConfig
    public long getEndTimestamp() {
        return StringUtil.parseLong(this.f55610c);
    }

    @Override // xyz.adscope.common.v2.beta.IBetaTestConfig
    public int getRandomProbability() {
        return StringUtil.parseInt(this.f55608a);
    }

    @Override // xyz.adscope.common.v2.beta.IBetaTestConfig
    public long getStartTimestamp() {
        return StringUtil.parseLong(this.f55609b);
    }

    public BetaTestPlanModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // xyz.adscope.common.v2.beta.IBetaTestConfig
    public String getSDKBizID() {
        return f0.e();
    }
}
