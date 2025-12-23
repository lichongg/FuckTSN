package com.bytedance.sdk.openadsdk.core.dislike;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.v;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private boolean f28877j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.cw.cw f28878r;
    private String xt;

    public static r j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return j(new JSONObject(str));
        } catch (JSONException e6) {
            vl.xt("OncallUploadConfig", "parse failed:".concat(String.valueOf(e6)));
            return null;
        }
    }

    public String cw() {
        return this.xt;
    }

    public String r() {
        return this.cw;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("enable", Boolean.valueOf(this.f28877j));
            jSONObject.putOpt("upload_api", this.xt);
            jSONObject.putOpt("alert_text", this.cw);
            com.bytedance.sdk.openadsdk.core.dislike.cw.cw cwVar = this.f28878r;
            if (cwVar != null) {
                jSONObject.putOpt("filter_word", cwVar.ae());
            }
        } catch (JSONException e6) {
            vl.xt("OncallUploadConfig", e6);
        }
        return jSONObject.toString();
    }

    public com.bytedance.sdk.openadsdk.core.dislike.cw.cw up() {
        return this.f28878r;
    }

    public boolean xt() {
        return this.f28877j;
    }

    public static r j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        r rVar = new r();
        rVar.f28877j = jSONObject.optBoolean("enable");
        rVar.xt = jSONObject.optString("upload_api");
        rVar.cw = jSONObject.optString("alert_text");
        JSONObject optJSONObject = jSONObject.optJSONObject("filter_word");
        if (optJSONObject != null) {
            com.bytedance.sdk.openadsdk.core.dislike.cw.cw j6 = com.bytedance.sdk.openadsdk.core.dislike.cw.cw.j(optJSONObject);
            if (j6 != null) {
                if (TextUtils.isEmpty(j6.j())) {
                    j6.j("99:1");
                }
                if (TextUtils.isEmpty(j6.xt())) {
                    j6.xt("素材反馈");
                }
            }
            rVar.f28878r = j6;
        }
        return rVar;
    }

    public static com.bytedance.sdk.openadsdk.core.dislike.cw.cw j() {
        r y5 = v.xt().y();
        if (y5 != null) {
            return y5.up();
        }
        return null;
    }
}
