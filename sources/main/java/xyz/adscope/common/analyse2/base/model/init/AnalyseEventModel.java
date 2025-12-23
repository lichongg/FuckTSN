package xyz.adscope.common.analyse2.base.model.init;

import java.util.List;
import org.json.JSONObject;
import xyz.adscope.common.analyse2.base.model.AnalyseBasicReceiveLog;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AnalyseEventModel extends AnalyseBasicReceiveLog {

    @JsonParseNode(key = "count")
    private int count;

    @JsonParseNode(key = "level")
    private List<String> exclude;

    @JsonParseNode(key = "codes")
    private List<String> handleCodes;

    @JsonParseNode(key = "sample")
    private int sample;

    @JsonParseNode(key = "time")
    private String time;

    @JsonParseNode(key = "uploadUrl")
    private String uploadUrl;

    public int b() {
        return this.count;
    }

    public List<String> c() {
        return this.exclude;
    }

    public List<String> d() {
        return this.handleCodes;
    }

    public int e() {
        return this.sample;
    }

    public String f() {
        return this.time;
    }

    public String g() {
        return this.uploadUrl;
    }

    public AnalyseEventModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
