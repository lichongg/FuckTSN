package xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter;

import java.util.List;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.complain.ComplainModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.frequency.StrategyFrequencyModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.unite.UniteControlModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class StrategyFilterModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "spaceID")
    private String f55642a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "minTime")
    private int f55643b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "frequency")
    private List<StrategyFrequencyModel> f55644c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "uniteControl")
    private UniteControlModel f55645d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "complain")
    private ComplainModel f55646e;

    public ComplainModel a() {
        return this.f55646e;
    }

    public List<StrategyFrequencyModel> b() {
        return this.f55644c;
    }

    public int c() {
        return this.f55643b;
    }

    public String d() {
        return this.f55642a;
    }

    public UniteControlModel e() {
        return this.f55645d;
    }

    public StrategyFilterModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
