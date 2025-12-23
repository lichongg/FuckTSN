package xyz.adscope.ad.model.impl.resp.cfg.root.statistics.task.taskurl;

import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class TaskUrlModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "implement")
    private String f55634a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "url")
    private String f55635b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "nextTime")
    private long f55636c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "randomTime")
    private long f55637d;

    public String a() {
        return this.f55634a;
    }

    public long b() {
        return this.f55636c;
    }

    public long c() {
        return this.f55637d;
    }

    public String d() {
        return this.f55635b;
    }

    public TaskUrlModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
