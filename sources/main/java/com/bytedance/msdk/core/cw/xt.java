package com.bytedance.msdk.core.cw;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    private int ae;
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    public List<Integer> f24461j;

    /* renamed from: m, reason: collision with root package name */
    private String f24462m;

    /* renamed from: r, reason: collision with root package name */
    private String f24463r;
    private String up;
    private JSONObject xt;

    public int j() {
        return this.cw;
    }

    public int xt() {
        return this.ae;
    }

    public boolean ae() {
        return "1".equals(this.f24463r) || "2".equals(this.f24463r) || "3".equals(this.f24463r) || "4".equals(this.f24463r) || "5".equals(this.f24463r);
    }

    public String cw() {
        return this.up;
    }

    public boolean j(int i6) {
        List<Integer> list = this.f24461j;
        if (list != null) {
            return list.contains(Integer.valueOf(i6));
        }
        return false;
    }

    public String m() {
        return this.f24463r;
    }

    public String r() {
        return this.f24462m;
    }

    public JSONObject up() {
        return this.xt;
    }

    public double xt(String str, String str2) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.xt) == null || (optJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (optJSONObject2 = optJSONObject.optJSONObject(str2)) == null || (optJSONObject3 = optJSONObject2.optJSONObject("srr")) == null) {
            return 0.0d;
        }
        return optJSONObject3.optDouble(str, 0.0d);
    }

    public xt(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("behavior_state");
        if (optJSONArray != null) {
            this.f24461j = new LinkedList();
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                try {
                    this.f24461j.add(Integer.valueOf(optJSONArray.getInt(i6)));
                } catch (JSONException e6) {
                    throw new RuntimeException(e6);
                }
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("rule_excs");
        if (optJSONObject != null) {
            this.ae = optJSONObject.optInt("condition");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("perform");
            this.xt = optJSONObject2;
            if (optJSONObject2 != null) {
                this.cw = optJSONObject2.optInt("condition");
                this.f24463r = this.xt.optString("opt");
                this.up = this.xt.optString("rule_id");
                this.f24462m = this.xt.optString("rule_timestamp");
            }
        }
    }

    public boolean j(String str) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = this.xt.optJSONObject("prime_rits");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject(str)) == null) {
            return false;
        }
        return (optJSONObject.optJSONObject("ssr") == null && optJSONObject.optJSONObject("srr") == null) ? false : true;
    }

    public double j(String str, String str2) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.xt) == null || (optJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (optJSONObject2 = optJSONObject.optJSONObject(str2)) == null || (optJSONObject3 = optJSONObject2.optJSONObject("ssr")) == null) {
            return 0.0d;
        }
        return optJSONObject3.optDouble(str, 0.0d);
    }
}
