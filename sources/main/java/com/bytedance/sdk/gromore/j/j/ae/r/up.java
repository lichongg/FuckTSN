package com.bytedance.sdk.gromore.j.j.ae.r;

import android.content.Context;
import com.bytedance.msdk.cw.r.g;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements com.bytedance.sdk.gromore.j.j.up {
    private g cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.xt.xt.j f27407j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f27408r;
    private com.bytedance.sdk.openadsdk.tj.j.xt.j.m xt;

    @Override // com.bytedance.sdk.gromore.j.j.up
    public void j() {
        com.bytedance.msdk.api.j.xt xtVar = new com.bytedance.msdk.api.j.xt(5, this.f27407j.h());
        xtVar.j(this.f27408r);
        this.cw.j(xtVar, new com.bytedance.msdk.api.r.j.ae.r() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.up.1
            @Override // com.bytedance.msdk.api.r.j.ae.r
            public void j(List<com.bytedance.msdk.xt.cw> list) {
                com.bytedance.sdk.openadsdk.mediation.xt.xt.xt l6;
                if (list == null) {
                    j(new com.bytedance.msdk.api.j(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is null"));
                    return;
                }
                if (up.this.xt != null) {
                    com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.xt oq = (up.this.f27407j == null || (l6 = up.this.f27407j.l()) == null) ? null : l6.oq();
                    LinkedList linkedList = new LinkedList();
                    Iterator<com.bytedance.msdk.xt.cw> it = list.iterator();
                    while (it.hasNext()) {
                        linkedList.add(new r(up.this.cw, it.next(), up.this.cw.kt(), oq));
                    }
                    up.this.xt.j(linkedList);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.ae.r
            public void j(com.bytedance.msdk.api.j jVar) {
                if (jVar == null || up.this.xt == null) {
                    return;
                }
                up.this.xt.j(jVar.f24334j, jVar.xt);
            }
        });
    }

    public up(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.m mVar, boolean z5) {
        this.f27407j = jVar;
        this.f27408r = z5;
        if (jVar != null) {
            this.cw = new g(context);
            this.xt = mVar;
        }
    }
}
