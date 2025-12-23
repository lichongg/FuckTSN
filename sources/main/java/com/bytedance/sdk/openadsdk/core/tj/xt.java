package com.bytedance.sdk.openadsdk.core.tj;

import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private int ae;
    public int cw = 1;

    /* renamed from: g, reason: collision with root package name */
    private long f30496g;

    /* renamed from: j, reason: collision with root package name */
    public String f30497j;

    /* renamed from: m, reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.i.cw.cw.xt f30498m;
    private long oq;
    private long qv;

    /* renamed from: r, reason: collision with root package name */
    public String f30499r;
    private long tl;
    public ArrayList<Integer> up;
    private JSONObject vl;
    public int xt;

    public int cw() {
        return this.ae;
    }

    public String j() {
        return this.f30497j;
    }

    public String r() {
        return this.f30499r;
    }

    public int xt() {
        return this.xt;
    }

    public com.bytedance.sdk.openadsdk.i.cw.cw.xt ae() {
        return this.f30498m;
    }

    public void cw(int i6) {
        this.cw = i6;
    }

    public long g() {
        return this.tl;
    }

    public void j(String str) {
        this.f30497j = str;
    }

    public int m() {
        return this.cw;
    }

    public long oq() {
        return this.f30496g;
    }

    public long qv() {
        return this.oq;
    }

    public void r(long j6) {
        this.qv = j6;
    }

    public ArrayList<Integer> tl() {
        return this.up;
    }

    public JSONObject up() {
        return this.vl;
    }

    public long vl() {
        return this.qv;
    }

    public void xt(int i6) {
        this.ae = i6;
    }

    public void cw(long j6) {
        this.oq = j6;
    }

    public void j(int i6) {
        this.xt = i6;
    }

    public void xt(String str) {
        this.f30499r = str;
    }

    public void j(JSONObject jSONObject) {
        this.vl = jSONObject;
    }

    public void xt(long j6) {
        this.f30496g = j6;
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        this.f30498m = xtVar;
    }

    public void j(ArrayList<Integer> arrayList) {
        this.up = arrayList;
    }

    public static void j(xt xtVar) {
        int xt;
        if (xtVar == null || xtVar.ae() == null || (xt = xtVar.xt()) >= 0 || xt == -8) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.tj.xt.1
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject up = xt.this.up();
                if (up == null) {
                    up = new JSONObject();
                }
                up.put(Constants.FROM, xt.this.m());
                up.put("err_code", xt.this.xt());
                up.put("err_msg", xt.this.r());
                up.put("server_res_str", xt.this.j());
                if (xt.this.tl() != null && xt.this.tl().size() > 0) {
                    up.put("mate_unavailable_code_list", new JSONArray((Collection) xt.this.tl()).toString());
                }
                com.bytedance.sdk.component.utils.vl.j("AdLogInfoModel", "rd_client_custom_error = ", up);
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("rd_client_custom_error").j(xt.this.ae().kt()).xt(up.toString());
            }
        }, "rd_client_custom_error");
    }

    public void j(long j6) {
        this.tl = j6;
    }
}
