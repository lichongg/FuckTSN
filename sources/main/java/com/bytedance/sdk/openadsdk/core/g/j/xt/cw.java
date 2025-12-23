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
public class cw implements com.bytedance.sdk.component.qv.j.j.cw {

    @com.bytedance.sdk.component.qv.xt.j(j = "deny_event")
    private String ae;

    @com.bytedance.sdk.component.qv.xt.j(j = MediationConstant.EXTRA_ADID)
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = d.X)
    private Context f29023j;

    /* renamed from: m, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "confirm_event")
    private String f29024m;

    /* renamed from: r, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "permission_popup_listener")
    private m.j f29025r;

    @com.bytedance.sdk.component.qv.xt.j(j = "cancel_event")
    private String tl;

    @com.bytedance.sdk.component.qv.xt.j(j = "app_manage_model")
    private String up;

    @com.bytedance.sdk.component.qv.xt.j(j = "material_meta")
    private n xt;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        com.bytedance.sdk.openadsdk.core.rn.m.j(this.cw, j());
        TTDelegateActivity.j(this.f29023j, this.cw, this.up);
        jVar.j(map2);
        return true;
    }

    private m.j j() {
        return new m.j() { // from class: com.bytedance.sdk.openadsdk.core.g.j.xt.cw.1
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
                if (cw.this.f29025r == null) {
                    return;
                }
                cw.this.f29025r.onDialogBtnNo();
                cw cwVar = cw.this;
                cwVar.j(cwVar.ae);
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                if (cw.this.f29025r == null) {
                    return;
                }
                cw.this.f29025r.onDialogBtnYes();
                cw cwVar = cw.this;
                cwVar.j(cwVar.f29024m);
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
                if (cw.this.f29025r == null) {
                    return;
                }
                cw.this.f29025r.onDialogCancel();
                cw cwVar = cw.this;
                cwVar.j(cwVar.tl);
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
        hashMap.put(d.X, this.f29023j);
        new xt.j(str).j(this.xt.tv()).j(hashMap).j().j();
    }
}
