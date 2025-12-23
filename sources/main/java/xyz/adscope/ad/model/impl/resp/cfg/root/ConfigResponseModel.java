package xyz.adscope.ad.model.impl.resp.cfg.root;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.beta.BetaTestPlanModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.log2.Analyse2ConfigModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.requrl.RequestUrlModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.statistics.StatisticsModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.statistics.event.ConfigEventModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.StrategyModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.temp.TemplateModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.update.UpdateModel;
import xyz.adscope.common.v2.encrypt.impl.MD5Util;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.model.IDeepCopyModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;
import xyz.adscope.common.v2.tool.json.JsonUtil;
import xyz.adscope.common.v2.tool.reflect.ReflectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ConfigResponseModel extends ASNPJsonResponseModel implements IDeepCopyModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "update")
    private UpdateModel f55595a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "updateMD5")
    private String f55596b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "requestUrl")
    private RequestUrlModel f55597c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "requestUrlMD5")
    private String f55598d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "statistics")
    private StatisticsModel f55599e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = "statisticsMD5")
    private String f55600f;

    /* renamed from: g, reason: collision with root package name */
    @JsonParseNode(key = "spaceStrategy")
    private List<StrategyModel> f55601g;

    /* renamed from: h, reason: collision with root package name */
    @JsonParseNode(key = "spaceStrategyMD5")
    private String f55602h;

    /* renamed from: i, reason: collision with root package name */
    @JsonParseNode(key = "templateMD5")
    private String f55603i;

    /* renamed from: j, reason: collision with root package name */
    @JsonParseNode(key = "defTemplate")
    private List<TemplateModel> f55604j;

    /* renamed from: k, reason: collision with root package name */
    @JsonParseNode(key = "requestRule")
    private List<StrategyFilterModel> f55605k;

    /* renamed from: l, reason: collision with root package name */
    @JsonParseNode(key = "testPlan")
    private BetaTestPlanModel f55606l;

    /* renamed from: m, reason: collision with root package name */
    @JsonParseNode(key = "logStrategy")
    private Analyse2ConfigModel f55607m;

    @Override // xyz.adscope.common.v2.model.IDeepCopyModel
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConfigResponseModel deepCopy() {
        return new ConfigResponseModel(this.mJsonObject);
    }

    public ConfigResponseModel a(ConfigResponseModel configResponseModel) {
        JsonParseNode jsonParseNode;
        JSONObject emptyJSONObject = JsonUtil.emptyJSONObject();
        List<Field> allFields = ReflectUtil.getAllFields(getClass());
        if (!allFields.isEmpty()) {
            try {
                for (Field field : allFields) {
                    if (ReflectUtil.isAnnotationType(field, JsonParseNode.class) && (jsonParseNode = (JsonParseNode) field.getAnnotation(JsonParseNode.class)) != null) {
                        String key = jsonParseNode.key();
                        JsonUtil.putObject(emptyJSONObject, key, JsonUtil.getObject(this.mJsonObject, key));
                        Object fieldValue = ReflectUtil.getFieldValue(configResponseModel, field);
                        if (fieldValue != null) {
                            ReflectUtil.setFieldValue(this, field, fieldValue);
                            JsonUtil.putObject(emptyJSONObject, key, JsonUtil.getObject(configResponseModel.mJsonObject, key));
                        }
                    }
                }
                this.mJsonObject = emptyJSONObject;
                return this;
            } catch (Throwable th) {
                SDKLog.stack(th);
            }
        }
        return this;
    }

    public Analyse2ConfigModel b() {
        return this.f55607m;
    }

    public BetaTestPlanModel c() {
        return this.f55606l;
    }

    public String d() {
        String md5 = MD5Util.md5("DEFAULT");
        StatisticsModel statisticsModel = this.f55599e;
        if (statisticsModel == null) {
            return md5;
        }
        List<ConfigEventModel> a6 = statisticsModel.a();
        if (a6.isEmpty()) {
            return md5;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<ConfigEventModel> it = a6.iterator();
        while (it.hasNext()) {
            sb.append(MD5Util.md5(it.next().toJsonString()));
        }
        return MD5Util.md5(sb.toString());
    }

    public List<StrategyFilterModel> e() {
        return this.f55605k;
    }

    public RequestUrlModel f() {
        return this.f55597c;
    }

    public String g() {
        return this.f55598d;
    }

    public StatisticsModel h() {
        return this.f55599e;
    }

    public String i() {
        return this.f55600f;
    }

    public List<StrategyModel> j() {
        return this.f55601g;
    }

    public String k() {
        return this.f55602h;
    }

    public String l() {
        return this.f55603i;
    }

    public List<TemplateModel> m() {
        return this.f55604j;
    }

    public UpdateModel n() {
        return this.f55595a;
    }

    public String o() {
        return this.f55596b;
    }

    public ConfigResponseModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
