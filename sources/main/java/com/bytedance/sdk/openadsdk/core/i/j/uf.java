package com.bytedance.sdk.openadsdk.core.i.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.widget.SSWebView;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class uf extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.rn cw;

    /* renamed from: j, reason: collision with root package name */
    private SSWebView f29158j;
    private String xt;

    public uf(SSWebView sSWebView, String str, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.f29158j = sSWebView;
        this.xt = str;
        this.cw = rnVar;
    }

    public static void j(com.bytedance.sdk.component.j.i iVar, SSWebView sSWebView, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("closeWebview", (com.bytedance.sdk.component.j.up<?, ?>) new uf(sSWebView, "closeWebview", rnVar));
        iVar.j("makeVisible", (com.bytedance.sdk.component.j.up<?, ?>) new uf(sSWebView, "makeVisible", rnVar));
        iVar.j("getCurrentVisibleState", (com.bytedance.sdk.component.j.up<?, ?>) new uf(sSWebView, "getCurrentVisibleState", rnVar));
        iVar.j("changeSize", (com.bytedance.sdk.component.j.up<?, ?>) new uf(sSWebView, "changeSize", rnVar));
        iVar.j("changeFrame", (com.bytedance.sdk.component.j.up<?, ?>) new uf(sSWebView, "changeFrame", rnVar));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.j.up
    @Nullable
    public JSONObject j(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.j.m mVar) throws Exception {
        JSONObject jSONObject2;
        int i6;
        int i7;
        int i8;
        jSONObject2 = new JSONObject();
        String str = this.xt;
        str.getClass();
        switch (str) {
            case "changeSize":
                JSONArray optJSONArray = jSONObject.optJSONArray("size");
                if (optJSONArray != null && optJSONArray.length() == 2) {
                    int optInt = optJSONArray.optInt(0);
                    int optInt2 = optJSONArray.optInt(1);
                    com.bytedance.sdk.openadsdk.core.rn rnVar = this.cw;
                    if (rnVar != null) {
                        rnVar.j(optInt, optInt2);
                    }
                }
                return jSONObject2;
            case "changeFrame":
                JSONArray optJSONArray2 = jSONObject.optJSONArray("point");
                JSONArray optJSONArray3 = jSONObject.optJSONArray("size");
                int i9 = Integer.MAX_VALUE;
                if (optJSONArray2 == null || optJSONArray2.length() != 2) {
                    i6 = Integer.MAX_VALUE;
                    i7 = Integer.MAX_VALUE;
                } else {
                    i7 = optJSONArray2.optInt(0);
                    i6 = optJSONArray2.optInt(1);
                }
                if (optJSONArray3 == null || optJSONArray3.length() != 2) {
                    i8 = Integer.MAX_VALUE;
                } else {
                    i9 = optJSONArray3.optInt(0);
                    i8 = optJSONArray3.optInt(1);
                }
                com.bytedance.sdk.openadsdk.core.rn rnVar2 = this.cw;
                if (rnVar2 != null) {
                    rnVar2.j(i7, i6, i9, i8);
                    return jSONObject2;
                }
                return jSONObject2;
            case "getCurrentVisibleState":
                jSONObject2.put("visibleState", !com.bytedance.sdk.openadsdk.core.uf.xt(this.f29158j, 50, 5) ? 1 : 0);
                return jSONObject2;
            case "closeWebview":
                com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.j.uf.1
                    @Override // java.lang.Runnable
                    public void run() {
                        uf.this.f29158j.setVisibility(8);
                    }
                });
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g cw = this.cw.cw();
                if (cw != null) {
                    cw.xt();
                    jSONObject2.put("success", true);
                    return jSONObject2;
                }
                jSONObject2.put("success", false);
                return jSONObject2;
            case "makeVisible":
                if (this.f29158j != null) {
                    jSONObject2.put("success", true);
                    com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.j.uf.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (uf.this.f29158j != null) {
                                uf.this.f29158j.setVisibility(0);
                            }
                            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.g cw2 = uf.this.cw.cw();
                            if (cw2 != null) {
                                cw2.F_();
                            }
                        }
                    });
                    return jSONObject2;
                }
                jSONObject2.put("success", false);
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
