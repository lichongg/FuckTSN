package com.bytedance.sdk.openadsdk.core.tj;

import com.umeng.analytics.pro.bi;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    private String ae;
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private String f30461j;

    /* renamed from: m, reason: collision with root package name */
    private int f30462m;

    /* renamed from: r, reason: collision with root package name */
    private int f30463r;
    private int up;
    private String xt;

    public String cw() {
        return this.xt;
    }

    public String j() {
        return this.ae;
    }

    public String r() {
        return this.cw;
    }

    public String xt() {
        return this.f30461j;
    }

    public int ae() {
        return this.f30462m;
    }

    public void cw(String str) {
        this.xt = str;
    }

    public void j(String str) {
        this.ae = str;
    }

    public int m() {
        return this.up;
    }

    public void r(String str) {
        this.cw = str;
    }

    public JSONObject tl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", cw());
            jSONObject.put("app_size", ae());
            jSONObject.put("comment_num", m());
            jSONObject.put("download_url", xt());
            jSONObject.put(bi.f40972o, r());
            jSONObject.put("score", up());
            return jSONObject;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.cw(e6.toString());
            return jSONObject;
        }
    }

    public int up() {
        return this.f30463r;
    }

    public void xt(String str) {
        this.f30461j = str;
    }

    public void cw(int i6) {
        this.f30462m = i6;
    }

    public void j(int i6) {
        this.f30463r = i6;
    }

    public void xt(int i6) {
        this.up = i6;
    }
}
