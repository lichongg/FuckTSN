package xyz.adscope.common.analyse2.base.model.biz;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.common.analyse2.base.model.AnalyseBasicReceiveLog;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;
import xyz.adscope.common.v2.tool.json.JsonUtil;
import xyz.adscope.common.v2.tool.str.SerialUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AnalyseAdCommon extends AnalyseBasicReceiveLog {

    @JsonParseNode(key = "ad_type")
    private String mAdType;

    @JsonParseNode(key = "currency")
    private String mCurrency;

    @JsonParseNode(key = "custom_data")
    private String mCustomData;

    @JsonParseNode(key = "hex_id")
    private String mHex;

    @JsonParseNode(key = "quantity")
    private String mQuantity;

    @JsonParseNode(key = "session_id")
    private String mSessionID;

    @JsonParseNode(key = "space_id")
    private String mSpaceID;

    @JsonParseNode(key = "time_out")
    private String mTimeout;

    @Override // xyz.adscope.common.analyse2.base.model.AnalyseBasicReceiveLog
    public JSONObject a() {
        JSONArray parseJSONArray;
        if (TextUtils.isEmpty(this.mHex)) {
            this.mHex = SerialUtil.generateCRCHex(this.mSessionID) + "";
        }
        if (!TextUtils.isEmpty(this.mCurrency) && (parseJSONArray = JsonUtil.parseJSONArray(this.mCurrency)) != null && parseJSONArray.length() > 0) {
            this.mCurrency = JsonUtil.getStringFromArray(parseJSONArray, 0);
        }
        return super.a();
    }

    public String b() {
        return this.mSessionID;
    }

    public AnalyseAdCommon(JSONObject jSONObject) {
        super(jSONObject);
    }
}
