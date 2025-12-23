package com.bytedance.msdk.core.up.xt;

import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private int ae;
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private int f24741j;

    /* renamed from: m, reason: collision with root package name */
    private int f24742m;

    /* renamed from: r, reason: collision with root package name */
    private String f24743r;
    private int up;
    private int xt;

    public String j() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediationConstant.KEY_REASON, this.f24741j);
            jSONObject.put("fill_error_code", this.xt);
            jSONObject.put("fill_error_msg", this.cw);
            jSONObject.put("mediation_rit", this.f24743r);
            jSONObject.put("load_sort", this.up);
            jSONObject.put("show_sort", this.f24742m);
            jSONObject.put("has_shown", this.ae);
            return jSONObject.toString();
        } catch (JSONException e6) {
            vl.j(e6);
            return "{\"name\": \"json err\"}";
        }
    }

    public void xt(int i6) {
        this.f24741j = i6;
    }

    public void cw(int i6) {
        this.xt = i6;
    }

    public void r(int i6) {
        this.up = i6;
    }

    public void up(int i6) {
        this.f24742m = i6;
    }

    public void xt(String str) {
        this.f24743r = str;
    }

    public void j(int i6) {
        this.ae = i6;
    }

    public void j(String str) {
        this.cw = str;
    }
}
