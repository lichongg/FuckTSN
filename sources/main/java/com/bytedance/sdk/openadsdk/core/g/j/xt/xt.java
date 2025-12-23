package com.bytedance.sdk.openadsdk.core.g.j.xt;

import android.content.Context;
import com.bytedance.sdk.component.qv.j.xt;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.rn.m;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;

@com.bytedance.sdk.component.qv.xt.xt
/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements com.bytedance.sdk.component.qv.j.j.cw {

    @com.bytedance.sdk.component.qv.xt.j(j = "deny_event")
    private String ae;

    @com.bytedance.sdk.component.qv.xt.j(j = MediationConstant.EXTRA_ADID)
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = d.X)
    private Context f29087j;

    /* renamed from: m, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "confirm_event")
    private String f29088m;

    /* renamed from: r, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "function_desc_popup_listener")
    private m.j f29089r;

    @com.bytedance.sdk.component.qv.xt.j(j = "cancel_event")
    private String tl;

    @com.bytedance.sdk.component.qv.xt.j(j = "app_manage_model")
    private String up;

    @com.bytedance.sdk.component.qv.xt.j(j = "material_meta")
    private n xt;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        com.bytedance.sdk.openadsdk.core.rn.m.j(this.cw, j());
        TTDelegateActivity.cw(this.f29087j, this.cw, this.up);
        jVar.j(map2);
        return true;
    }

    private m.j j() {
        return new m.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.xt.1
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
                if (xt.this.f29089r == null) {
                    return;
                }
                xt.this.f29089r.onDialogBtnNo();
                xt xtVar = xt.this;
                xtVar.j(xtVar.ae);
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                if (xt.this.f29089r == null) {
                    return;
                }
                xt.this.f29089r.onDialogBtnYes();
                xt xtVar = xt.this;
                xtVar.j(xtVar.f29088m);
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
                if (xt.this.f29089r == null) {
                    return;
                }
                xt.this.f29089r.onDialogCancel();
                xt xtVar = xt.this;
                xtVar.j(xtVar.tl);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("material_meta", this.xt);
        hashMap.put(d.X, this.f29087j);
        new xt.j(str).j(this.xt.tv()).j(hashMap).j().j();
    }
}
