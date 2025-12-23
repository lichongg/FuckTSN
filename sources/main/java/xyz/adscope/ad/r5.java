package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;
import xyz.adscope.common.v2.encrypt.ILinkedEncrypt;
import xyz.adscope.common.v2.encrypt.LinkedEncryptManager;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class r5 {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f55928a;

    /* renamed from: b, reason: collision with root package name */
    private final String f55929b;

    public void a(Context context) {
        if (TextUtils.isEmpty(this.f55929b)) {
            return;
        }
        this.f55928a = JsonUtil.parseJSONObject(LinkedEncryptManager.getInstance().getOrCreateImplement(context).decrypt(this.f55929b, "101,1001", ILinkedEncrypt.B64Model.STEP_BY_STEP, true));
    }

    public JSONObject b() {
        return this.f55928a;
    }

    public String c() {
        JSONObject jSONObject = this.f55928a;
        return jSONObject != null ? JsonUtil.getStringFromJson(jSONObject, "id") : "";
    }

    public r5(String str) {
        this.f55929b = str;
    }

    public String a() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.f55928a;
        if (jSONObject2 != null && (jSONObject = JsonUtil.getJSONObject(jSONObject2, SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)) != null) {
            return JsonUtil.getStringFromJson(jSONObject, "spaceId");
        }
        return "";
    }
}
