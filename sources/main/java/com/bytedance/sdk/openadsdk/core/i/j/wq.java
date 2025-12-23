package com.bytedance.sdk.openadsdk.core.i.j;

import com.bytedance.sdk.openadsdk.core.widget.ae;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class wq extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private ae.j f29165j;

    public static void j(com.bytedance.sdk.component.j.i iVar, ae.j jVar) {
        iVar.j("UgenDownloadDialogInteraction", (com.bytedance.sdk.component.j.up<?, ?>) new wq(jVar));
    }

    public JSONObject cw() {
        return new JSONObject();
    }

    public wq(ae.j jVar) {
        this.f29165j = jVar;
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        j(jSONObject);
        return cw();
    }

    private void j(JSONObject jSONObject) {
        if (jSONObject == null || this.f29165j == null) {
            return;
        }
        int optInt = jSONObject.optInt("InteractionType");
        if (optInt == 1) {
            this.f29165j.cw(null);
            return;
        }
        if (optInt == 2) {
            this.f29165j.j(null);
            return;
        }
        if (optInt == 3) {
            this.f29165j.j();
        } else if (optInt == 4) {
            this.f29165j.xt(null);
        } else {
            if (optInt != 5) {
                return;
            }
            this.f29165j.r(null);
        }
    }
}
