package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class i {

    /* renamed from: j, reason: collision with root package name */
    private static volatile String f30302j;
    private String ae;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f30303g;

    /* renamed from: m, reason: collision with root package name */
    private int f30304m;

    /* renamed from: r, reason: collision with root package name */
    private int f30305r;
    private String tl;
    private JSONObject up;
    private String xt;

    public i() {
        this.ae = "";
        this.tl = "";
    }

    public static void j(String str) {
        f30302j = str;
    }

    private String r(String str) {
        if (this.up != null && !TextUtils.isEmpty(str) && this.xt != null) {
            String optString = this.up.optString(str);
            if (!TextUtils.isEmpty(optString)) {
                return this.xt + (this.xt.contains("?") ? ContainerUtils.FIELD_DELIMITER : "?") + optString;
            }
        }
        return this.xt;
    }

    public int cw() {
        return this.f30304m;
    }

    public String xt() {
        return r(f30302j);
    }

    public String ae() {
        return this.tl;
    }

    public void cw(String str) {
        this.cw = str;
    }

    public void j(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("deeplink_url", xt());
            jSONObject2.put("fallback_url", r());
            jSONObject2.put("fallback_type", up());
            jSONObject2.put("addon_params", this.up);
            jSONObject2.put("fallback_landing", this.f30304m);
            jSONObject2.put("fallback_landing_ugen_url", this.ae);
            jSONObject2.put("fallback_landing_ugen_md5", this.tl);
            jSONObject.put("deep_link", jSONObject2);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public String m() {
        return this.ae;
    }

    public int up() {
        return this.f30305r;
    }

    public void xt(String str) {
        this.xt = str;
    }

    public i(JSONObject jSONObject) {
        this.ae = "";
        this.tl = "";
        if (jSONObject == null) {
            return;
        }
        xt(jSONObject.optString("deeplink_url"));
        cw(jSONObject.optString("fallback_url"));
        j(jSONObject.optInt("fallback_type"));
        this.up = jSONObject.optJSONObject("addon_params");
        this.f30304m = jSONObject.optInt("fallback_landing");
        this.ae = jSONObject.optString("fallback_landing_ugen_url");
        this.tl = jSONObject.optString("fallback_landing_ugen_md5");
    }

    public String r() {
        return this.cw;
    }

    public boolean j() {
        return this.f30303g;
    }

    public void j(boolean z5) {
        this.f30303g = z5;
    }

    public void j(int i6) {
        this.f30305r = i6;
    }

    public void j(i iVar) {
        if (iVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(iVar.xt())) {
            xt(iVar.xt());
        }
        if (!TextUtils.isEmpty(iVar.r())) {
            cw(iVar.r());
        }
        if (iVar.up() != 0) {
            j(iVar.up());
        }
    }
}
