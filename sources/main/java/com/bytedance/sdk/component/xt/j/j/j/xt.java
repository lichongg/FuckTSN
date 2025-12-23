package com.bytedance.sdk.component.xt.j.j.j;

import com.bytedance.sdk.component.cw.xt.x;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements j {
    @Override // com.bytedance.sdk.component.xt.j.j.j.j
    public void j(com.bytedance.sdk.component.cw.xt.up upVar, InetSocketAddress inetSocketAddress, Proxy proxy, x xVar, IOException iOException) {
        try {
            ((com.bytedance.sdk.component.r.cw) AutoService.j(com.bytedance.sdk.component.r.cw.class)).j("okhttp_connectFailed", j(upVar), iOException);
        } catch (Exception unused) {
        }
    }

    private String xt(com.bytedance.sdk.component.cw.xt.up upVar) throws NullPointerException {
        return upVar.j().j().toString();
    }

    @Override // com.bytedance.sdk.component.xt.j.j.j.j
    public void j(com.bytedance.sdk.component.cw.xt.up upVar, IOException iOException) {
        try {
            ((com.bytedance.sdk.component.r.cw) AutoService.j(com.bytedance.sdk.component.r.cw.class)).j("okhttp_callFailed", j(upVar), iOException);
        } catch (Exception unused) {
        }
    }

    private JSONObject j(com.bytedance.sdk.component.cw.xt.up upVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", xt(upVar));
        return jSONObject;
    }
}
