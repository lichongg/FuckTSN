package xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.frequency;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class StrategyFrequencyModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "eventCode")
    private String f55648a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "relativeTime")
    private long f55649b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "absoluteTime")
    private long[] f55650c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "count")
    private int f55651d;

    public long[] a() {
        return this.f55650c;
    }

    public String b() {
        return this.f55648a;
    }

    public long c() {
        return this.f55649b;
    }

    public int getCount() {
        return this.f55651d;
    }

    public StrategyFrequencyModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
