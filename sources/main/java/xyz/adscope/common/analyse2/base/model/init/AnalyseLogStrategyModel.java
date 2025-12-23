package xyz.adscope.common.analyse2.base.model.init;

import com.amap.api.fence.GeoFence;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.common.analyse.model.impl.HistoryDbModel;
import xyz.adscope.common.analyse2.base.model.AnalyseBasicReceiveLog;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AnalyseLogStrategyModel extends AnalyseBasicReceiveLog {

    @JsonParseNode(key = HistoryDbModel.COLUMN_ACCEPT_ENCRYPT)
    private String acceptEncrypt;

    @JsonParseNode(key = "crash")
    private AnalyseCrashModel crashModel;

    @JsonParseNode(key = "customData")
    private String customData;

    @JsonParseNode(key = GeoFence.BUNDLE_KEY_CUSTOMID)
    private String customID;

    @JsonParseNode(key = "event")
    private List<AnalyseEventModel> eventModels;

    @JsonParseNode(key = "version")
    private String version;

    public String b() {
        return this.acceptEncrypt;
    }

    public AnalyseCrashModel c() {
        return this.crashModel;
    }

    public String d() {
        return this.customData;
    }

    public List<AnalyseEventModel> e() {
        return this.eventModels;
    }

    public String f() {
        return this.version;
    }

    public AnalyseLogStrategyModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
