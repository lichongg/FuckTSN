package com.bytedance.sdk.openadsdk.core.f;

import android.content.Context;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.tj.a;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.oq;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private cw cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ch.j.xt.j.xt f28959j;

    /* renamed from: r, reason: collision with root package name */
    private final Context f28960r = v.getContext();
    private n up;
    private JSONObject xt;

    public void j(com.bytedance.sdk.openadsdk.ch.j.xt.j.xt xtVar) {
        this.f28959j = xtVar;
    }

    public Context getContext() {
        return this.f28960r;
    }

    public void j(cw cwVar) {
        this.cw = cwVar;
    }

    public JSONObject xt() {
        JSONObject jSONObject = new JSONObject();
        if (a.j()) {
            try {
                com.bytedance.sdk.openadsdk.ch.j.xt.j.xt xtVar = this.f28959j;
                if (xtVar != null) {
                    JSONObject j6 = xtVar.j();
                    this.xt = j6;
                    return j6;
                }
            } catch (Exception e6) {
                vl.xt("xeasy", e6.getMessage());
                return jSONObject;
            }
        }
        return jSONObject;
    }

    public xt(n nVar) {
        this.up = nVar;
    }

    public void cw() {
        if (a.j()) {
            vl.j("xeasy", "oc");
            com.bytedance.sdk.openadsdk.ch.j.xt.j.xt xtVar = this.f28959j;
            if (xtVar != null) {
                xtVar.xt();
            }
        }
    }

    public n j() {
        return this.up;
    }

    public void j(n nVar) {
        if (this.f28959j != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style_category", String.valueOf(a.r(nVar)));
            } catch (JSONException e6) {
                vl.j(e6);
            }
            this.f28959j.j(jSONObject);
        }
    }

    public void j(boolean z5, JSONObject jSONObject) {
        if (a.j()) {
            vl.j("xeasy", "er:".concat(String.valueOf(z5)));
            com.bytedance.sdk.openadsdk.ch.j.xt.j.xt xtVar = this.f28959j;
            if (xtVar != null) {
                if (z5) {
                    xtVar.xt(jSONObject);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("success", 0);
                hashMap.put("estimatedArea", this.xt);
                hashMap.put("realArea", this.cw.getMaxRectJson());
                hashMap.put("exceedAreaRate", Double.valueOf(this.cw.getExceedAreaRate()));
                hashMap.put("widgetArea", this.cw.getActualRectJson());
                oq.j(this.up, false, a.cw(this.up), 2, (Map<String, Object>) hashMap);
                this.f28959j.cw(jSONObject);
            }
        }
    }

    public static void j(n nVar, float f6, float f7, int i6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("convert", 0);
            jSONObject.put("down_x", f6);
            jSONObject.put("down_y", f7);
        } catch (Exception e6) {
            vl.j("xeasy", "e:" + e6.getMessage());
        }
        oq.j(nVar, false, a.cw(nVar), i6, jSONObject);
    }
}
