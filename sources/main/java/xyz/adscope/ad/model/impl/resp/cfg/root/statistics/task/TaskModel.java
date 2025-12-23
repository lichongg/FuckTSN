package xyz.adscope.ad.model.impl.resp.cfg.root.statistics.task;

import java.util.List;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.statistics.task.pkg.PkgModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.statistics.task.taskurl.TaskUrlModel;
import xyz.adscope.common.analyse.model.impl.HistoryDbModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class TaskModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "taskType")
    private int f55625a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "taskReport")
    private int f55626b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "pkgs")
    private List<PkgModel> f55627c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "delay")
    private int f55628d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = HistoryDbModel.COLUMN_REPORT_URL)
    private String f55629e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = "taskUrls")
    private List<TaskUrlModel> f55630f;

    /* renamed from: g, reason: collision with root package name */
    @JsonParseNode(key = HistoryDbModel.COLUMN_MACROS)
    private String f55631g;

    public int a() {
        return this.f55628d;
    }

    public List<PkgModel> b() {
        return this.f55627c;
    }

    public String c() {
        return this.f55629e;
    }

    public int d() {
        return this.f55626b;
    }

    public int e() {
        return this.f55625a;
    }

    public List<TaskUrlModel> f() {
        return this.f55630f;
    }

    public String getMacros() {
        return this.f55631g;
    }

    public TaskModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
