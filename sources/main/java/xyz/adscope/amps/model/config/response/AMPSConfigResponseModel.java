package xyz.adscope.amps.model.config.response;

import xyz.adscope.amps.model.AMPSBaseModel;
import xyz.adscope.common.json.util.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSConfigResponseModel extends AMPSBaseModel {
    private BlackRuleModel blackRule;
    private ConfigModel config;
    private String customData = "";
    private EventModel event;
    private long lastUpdateTime;
    private LogStrategyModel logStrategy;
    private MaterialManagerModel materialManager;
    private MediationModel mediation;
    private TestPlanModel testPlan;
    private String version;

    public BlackRuleModel getBlackRule() {
        return this.blackRule;
    }

    public ConfigModel getConfig() {
        return this.config;
    }

    public String getCustomData() {
        return this.customData;
    }

    public EventModel getEvent() {
        return this.event;
    }

    public long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public LogStrategyModel getLogStrategy() {
        return this.logStrategy;
    }

    public MaterialManagerModel getMaterialManager() {
        return this.materialManager;
    }

    public MediationModel getMediation() {
        return this.mediation;
    }

    public TestPlanModel getTestPlan() {
        return this.testPlan;
    }

    public String getVersion() {
        return this.version;
    }

    public void setBlackRule(BlackRuleModel blackRuleModel) {
        this.blackRule = blackRuleModel;
    }

    public void setConfig(ConfigModel configModel) {
        this.config = configModel;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setEvent(EventModel eventModel) {
        this.event = eventModel;
    }

    public void setLastUpdateTime(long j6) {
        this.lastUpdateTime = j6;
    }

    public void setLogStrategy(LogStrategyModel logStrategyModel) {
        this.logStrategy = logStrategyModel;
    }

    public void setMaterialManager(MaterialManagerModel materialManagerModel) {
        this.materialManager = materialManagerModel;
    }

    public void setMediation(MediationModel mediationModel) {
        this.mediation = mediationModel;
    }

    public void setTestPlan(TestPlanModel testPlanModel) {
        this.testPlan = testPlanModel;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "{\"mediation\":" + this.mediation + ", \"event\":" + this.event + ", \"customData\":\"" + JsonUtil.addEscapeChar(this.customData) + "\", \"config\":" + this.config + ", \"logStrategy\":" + this.logStrategy + ", \"testPlan\":" + this.testPlan + ", \"lastUpdateTime\":" + this.lastUpdateTime + ", \"blackRule\":" + this.blackRule + ", \"materialManager\":" + this.materialManager + ", \"version\":\"" + this.version + "\"} ";
    }
}
