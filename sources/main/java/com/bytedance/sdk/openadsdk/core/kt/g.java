package com.bytedance.sdk.openadsdk.core.kt;

import android.content.Context;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g implements com.bytedance.sdk.component.tl.j.r {
    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean j() {
        return false;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean jy() {
        return false;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean m() {
        return true;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public int oq() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public com.bytedance.sdk.component.tl.xt.cw qv() {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public String xt() {
        return "csj_";
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public com.bytedance.sdk.component.tl.j.j.xt ae() {
        return new oq(com.bytedance.sdk.openadsdk.core.v.up.j().xt().cw());
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public com.bytedance.sdk.component.tl.j.xt j(JSONObject jSONObject) {
        try {
            jSONObject.put("is_new", true);
            jSONObject.put("sdk_session_id", xt.f29419j);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        com.bytedance.sdk.component.tl.xt.r.j.j jVar = new com.bytedance.sdk.component.tl.xt.r.j.j(UUID.randomUUID().toString(), com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("new_adlog_monitor").xt(jSONObject.toString()).j());
        jVar.cw((byte) 0);
        jVar.xt((byte) 2);
        jVar.j((byte) 1);
        return jVar;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public com.bytedance.sdk.component.tl.j.tl vl() {
        return j.f29337j;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public String xt(String str) {
        return com.bytedance.sdk.component.utils.j.xt(str);
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    /* renamed from: av, reason: merged with bridge method [inline-methods] */
    public ExecutorService tl() {
        return com.bytedance.sdk.component.oq.ae.xt();
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public Looper az() {
        return com.bytedance.sdk.component.oq.xt.j.j().xt().getLooper();
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean cw() {
        return v.xt().f();
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public Executor g() {
        return com.bytedance.sdk.component.oq.ae.j();
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean r() {
        return com.bytedance.sdk.openadsdk.core.p.g.j();
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public String up() {
        return uf.ae();
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean ws() {
        return v.xt().tj();
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean j(Context context) {
        return com.bytedance.sdk.component.utils.ws.j(context);
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public String j(String str) {
        return com.bytedance.sdk.component.utils.j.cw(str);
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public void j(JSONObject jSONObject, JSONObject jSONObject2) {
        boolean nt = v.xt().nt();
        if (jSONObject2 != null && jSONObject2.optInt("success") == 1 && nt) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.j(jSONObject, jSONObject2);
    }
}
