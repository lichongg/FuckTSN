package com.bytedance.sdk.component.adexpress.dynamic.r;

import com.bytedance.sdk.component.adexpress.xt.jy;
import com.bytedance.sdk.component.utils.vl;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae implements tl {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.up.xt f25788j;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.r.tl
    public void j(com.bytedance.sdk.component.adexpress.dynamic.up.xt xtVar) {
        this.f25788j = xtVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(jy jyVar) {
        try {
            JSONObject up = jyVar.up();
            JSONObject jSONObject = new JSONObject(up.optString("template_Plugin"));
            JSONObject optJSONObject = up.optJSONObject("creative");
            com.bytedance.sdk.component.adexpress.dynamic.cw.tl j6 = new m(jSONObject, optJSONObject, up.optJSONObject("AdSize"), new JSONObject(up.optString("diff_template_Plugin"))).j(jyVar.r(), jyVar.jy(), optJSONObject.optDouble("score_exact_i18n"), optJSONObject.optString("comment_num_i18n"), jyVar);
            try {
                JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("dynamic_creative"));
                j6.j(jSONObject2.optString("color"));
                j6.j(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.f25788j.j(j6);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.r.tl
    public void j(final jy jyVar) {
        if (jyVar.az() == 1) {
            xt(jyVar);
        } else {
            com.bytedance.sdk.component.adexpress.r.up.j(new com.bytedance.sdk.component.oq.g("dynamicparse") { // from class: com.bytedance.sdk.component.adexpress.dynamic.r.ae.1
                @Override // java.lang.Runnable
                public void run() {
                    ae.this.xt(jyVar);
                }
            }, 5);
        }
    }
}
