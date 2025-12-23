package com.bytedance.sdk.openadsdk.core.i.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.tj.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private n f29157j;
    private com.bytedance.sdk.openadsdk.core.rn xt;

    public static void j(com.bytedance.sdk.component.j.i iVar, n nVar, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("getEstimatedInteractionAreaInfo", (com.bytedance.sdk.component.j.up<?, ?>) new tl(nVar, rnVar, "getEstimatedInteractionAreaInfo"));
        iVar.j("interactionAreaInfo", (com.bytedance.sdk.component.j.up<?, ?>) new tl(nVar, rnVar, "interactionAreaInfo"));
    }

    public tl(n nVar, com.bytedance.sdk.openadsdk.core.rn rnVar, String str) {
        this.f29157j = nVar;
        this.xt = rnVar;
        this.cw = str;
    }

    @Override // com.bytedance.sdk.component.j.up
    @Nullable
    public JSONObject j(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.j.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.tj.av avVar;
        com.bytedance.sdk.openadsdk.core.tj.av avVar2;
        JSONObject jSONObject2;
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g cw = this.xt.cw();
        String str = this.cw;
        str.getClass();
        if (str.equals("interactionAreaInfo")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("areas");
            if (optJSONArray == null || optJSONArray.length() <= 0 || (jSONObject2 = optJSONArray.getJSONObject(0)) == null) {
                avVar = null;
                avVar2 = null;
            } else {
                avVar = com.bytedance.sdk.openadsdk.core.tj.av.j(jSONObject2);
                if (cw != null) {
                    cw.setEasyPlayInteractionAreaInfo(avVar);
                    avVar2 = com.bytedance.sdk.openadsdk.core.tj.av.j(cw.getEstimatedInteractionAreaInfo());
                } else {
                    avVar2 = null;
                }
            }
            if (avVar2 == null) {
                if (cw != null) {
                    cw.j(com.bytedance.sdk.openadsdk.core.tj.av.xt(null, avVar), 1.0d);
                    this.xt.j("canMakeVisiable", (JSONObject) null);
                }
            } else if (avVar == null) {
                cw.j(null, -1.0d);
                cw.cw();
                this.xt.j("expressWebviewRecycle", (JSONObject) null);
            } else {
                double j6 = com.bytedance.sdk.openadsdk.core.tj.av.j(avVar2, avVar);
                double d6 = avVar.cw * avVar.f30222r;
                double d7 = avVar2.cw * avVar2.f30222r;
                if (d7 == 0.0d) {
                    cw.j(com.bytedance.sdk.openadsdk.core.tj.av.xt(avVar2, avVar), 1.0d);
                    this.xt.j("canMakeVisiable", (JSONObject) null);
                    return null;
                }
                if (d6 == 0.0d) {
                    cw.j(null, -1.0d);
                    cw.cw();
                    this.xt.j("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                double d8 = j6 / d6;
                boolean z5 = d8 >= 0.8d;
                com.bytedance.sdk.component.utils.vl.j("xeasy", "A:" + d7 + " B:" + d6 + " o:" + j6 + " R:" + d8);
                if (!z5) {
                    cw.j(null, -1.0d);
                    cw.cw();
                    this.xt.j("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                cw.j(com.bytedance.sdk.openadsdk.core.tj.av.xt(avVar2, avVar), (j6 - d7) / d7);
                this.xt.j("canMakeVisiable", (JSONObject) null);
                return null;
            }
        } else if (str.equals("getEstimatedInteractionAreaInfo") && cw != null) {
            return cw.getEstimatedInteractionAreaInfo();
        }
        return null;
    }
}
