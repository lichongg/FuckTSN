package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class LoadAdParams {

    /* renamed from: a, reason: collision with root package name */
    private LoginType f36733a;

    /* renamed from: b, reason: collision with root package name */
    private String f36734b;

    /* renamed from: c, reason: collision with root package name */
    private String f36735c;

    /* renamed from: d, reason: collision with root package name */
    private String f36736d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f36737e;

    /* renamed from: f, reason: collision with root package name */
    private JSONObject f36738f;

    /* renamed from: g, reason: collision with root package name */
    private final JSONObject f36739g = new JSONObject();

    public Map getDevExtra() {
        return this.f36737e;
    }

    public String getDevExtraJsonString() {
        try {
            Map<String, String> map = this.f36737e;
            return (map == null || map.size() <= 0) ? "" : new JSONObject(this.f36737e).toString();
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.f36738f;
    }

    public String getLoginAppId() {
        return this.f36734b;
    }

    public String getLoginOpenid() {
        return this.f36735c;
    }

    public LoginType getLoginType() {
        return this.f36733a;
    }

    public JSONObject getParams() {
        return this.f36739g;
    }

    public String getUin() {
        return this.f36736d;
    }

    public void setDevExtra(Map<String, String> map) {
        this.f36737e = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f36738f = jSONObject;
    }

    public void setLoginAppId(String str) {
        this.f36734b = str;
    }

    public void setLoginOpenid(String str) {
        this.f36735c = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f36733a = loginType;
    }

    public void setUin(String str) {
        this.f36736d = str;
    }

    public String toString() {
        return "LoadAdParams{, loginType=" + this.f36733a + ", loginAppId=" + this.f36734b + ", loginOpenid=" + this.f36735c + ", uin=" + this.f36736d + ", passThroughInfo=" + this.f36737e + ", extraInfo=" + this.f36738f + '}';
    }
}
