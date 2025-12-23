package com.bytedance.sdk.openadsdk.core.tj;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.common.SocializeConstants;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ws {
    private int ae;
    private String av;
    private String az;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private String f30472g;

    /* renamed from: i, reason: collision with root package name */
    private String f30473i;

    /* renamed from: j, reason: collision with root package name */
    private long f30474j;
    private long jy;

    /* renamed from: m, reason: collision with root package name */
    private int f30475m;
    private long oq;
    private long qv;

    /* renamed from: r, reason: collision with root package name */
    private long f30476r;
    private long tl;
    private boolean up;
    private int vl;

    /* renamed from: w, reason: collision with root package name */
    private String f30477w;
    private String ws;
    private String xt;

    public static ws j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ws wsVar = new ws();
        wsVar.f30474j = jSONObject.optLong(SocializeConstants.TENCENT_UID);
        wsVar.xt = jSONObject.optString("coupon_meta_id");
        wsVar.cw = jSONObject.optString("unique_id");
        wsVar.f30476r = jSONObject.optLong("device_id");
        wsVar.up = jSONObject.optBoolean("has_coupon");
        wsVar.f30475m = jSONObject.optInt("coupon_scene");
        wsVar.ae = jSONObject.optInt("type");
        wsVar.tl = jSONObject.optLong("threshold");
        wsVar.f30472g = jSONObject.optString("scene_key");
        wsVar.oq = jSONObject.optLong(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID);
        wsVar.qv = jSONObject.optLong("amount");
        wsVar.vl = jSONObject.optInt(com.umeng.ccg.a.f41544t);
        wsVar.jy = jSONObject.optLong(ResIdentify.RES_TYPE_STYLE);
        wsVar.ws = jSONObject.optString(d.f41197p);
        wsVar.az = jSONObject.optString("expire_time");
        wsVar.av = jSONObject.optString("button_text");
        wsVar.f30473i = jSONObject.optString(JThirdPlatFormInterface.KEY_EXTRA);
        wsVar.f30477w = jSONObject.optString("toast");
        return wsVar;
    }

    public int cw() {
        return this.f30475m;
    }

    public int getType() {
        return this.ae;
    }

    public String r() {
        return this.f30477w;
    }

    public JSONObject xt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocializeConstants.TENCENT_UID, this.f30474j);
            jSONObject.put("coupon_meta_id", this.xt);
            jSONObject.put("unique_id", this.cw);
            jSONObject.put("device_id", this.f30476r);
            jSONObject.put("type", this.ae);
            jSONObject.put("scene_key", this.f30472g);
            jSONObject.put(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, this.oq);
            jSONObject.put("value", this.qv);
            jSONObject.put("threshold", this.tl);
            jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, this.f30473i);
            return jSONObject;
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return jSONObject;
        }
    }

    public JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocializeConstants.TENCENT_UID, this.f30474j);
            jSONObject.put("coupon_meta_id", this.xt);
            jSONObject.put("unique_id", this.cw);
            jSONObject.put("device_id", this.f30476r);
            jSONObject.put("has_coupon", this.up);
            jSONObject.put("coupon_scene", this.f30475m);
            jSONObject.put("type", this.ae);
            jSONObject.put("threshold", this.tl);
            jSONObject.put("scene_key", this.f30472g);
            jSONObject.put(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, this.oq);
            jSONObject.put("amount", this.qv);
            jSONObject.put(com.umeng.ccg.a.f41544t, this.vl);
            jSONObject.put(ResIdentify.RES_TYPE_STYLE, this.jy);
            jSONObject.put(d.f41197p, this.ws);
            jSONObject.put("expire_time", this.az);
            jSONObject.put("button_text", this.av);
            jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, this.f30473i);
            jSONObject.put("toast", this.f30477w);
            return jSONObject;
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return jSONObject;
        }
    }

    public boolean j(boolean z5) {
        int i6;
        boolean z6 = this.up && this.qv > 0;
        return z5 ? z6 && ((i6 = this.f30475m) == 0 || i6 == 5) : z6 && this.f30475m == 5;
    }
}
