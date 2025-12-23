package xyz.adscope.ad.model.impl.resp.cfg.root.statistics;

import java.util.List;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.statistics.event.ConfigEventModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.statistics.task.TaskModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class StatisticsModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "task")
    private List<TaskModel> f55617a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "event")
    private List<ConfigEventModel> f55618b;

    public List<ConfigEventModel> a() {
        return this.f55618b;
    }

    public List<TaskModel> b() {
        return this.f55617a;
    }

    public StatisticsModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
