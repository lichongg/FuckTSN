package xyz.adscope.common.analyse2.base.model.init;

import com.umeng.socialize.common.SocializeConstants;
import org.json.JSONObject;
import xyz.adscope.common.analyse2.base.model.AnalyseBasicReceiveLog;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AnalyseUserModel extends AnalyseBasicReceiveLog {

    @JsonParseNode(exclude = true, key = "oaid")
    private String oaid;

    @JsonParseNode(exclude = true, key = "said")
    private String said;

    @JsonParseNode(key = "user_custom_data")
    private String userCustomData;

    @JsonParseNode(key = SocializeConstants.TENCENT_UID)
    private String userId;

    @JsonParseNode(key = "lmt")
    private String userLmt;

    public String b() {
        return this.oaid;
    }

    public String c() {
        return this.said;
    }

    public String d() {
        return this.userCustomData;
    }

    public String e() {
        return this.userId;
    }

    public String f() {
        return this.userLmt;
    }

    public AnalyseUserModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
