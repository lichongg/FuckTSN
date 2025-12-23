package com.bytedance.sdk.openadsdk.core.g.j.xt;

import android.content.Context;
import android.text.TextUtils;
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
public class r implements com.bytedance.sdk.component.qv.j.j.cw {

    @com.bytedance.sdk.component.qv.xt.j(j = "deny_event")
    private String ae;

    @com.bytedance.sdk.component.qv.xt.j(j = MediationConstant.EXTRA_ADID)
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = d.X)
    private Context f29070j;

    /* renamed from: m, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "confirm_event")
    private String f29071m;

    /* renamed from: r, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "privacy_popup_listener")
    private m.j f29072r;

    @com.bytedance.sdk.component.qv.xt.j(j = "cancel_event")
    private String tl;

    @com.bytedance.sdk.component.qv.xt.j(j = "app_manage_model")
    private String up;

    @com.bytedance.sdk.component.qv.xt.j(j = "material_meta")
    private n xt;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        com.bytedance.sdk.openadsdk.core.rn.m.j(this.cw, j());
        TTDelegateActivity.xt(this.f29070j, this.cw, this.up);
        jVar.j(map2);
        return true;
    }

    private m.j j() {
        return new m.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.r.1
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
                if (r.this.f29072r == null) {
                    return;
                }
                r.this.f29072r.onDialogBtnNo();
                r rVar = r.this;
                rVar.j(rVar.ae);
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                if (r.this.f29072r == null) {
                    return;
                }
                r.this.f29072r.onDialogBtnYes();
                r rVar = r.this;
                rVar.j(rVar.f29071m);
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
                if (r.this.f29072r == null) {
                    return;
                }
                r.this.f29072r.onDialogCancel();
                r rVar = r.this;
                rVar.j(rVar.tl);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        if (this.xt == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("material_meta", this.xt);
        hashMap.put(d.X, this.f29070j);
        new xt.j(str).j(this.xt.tv()).j(hashMap).j().j();
    }
}
