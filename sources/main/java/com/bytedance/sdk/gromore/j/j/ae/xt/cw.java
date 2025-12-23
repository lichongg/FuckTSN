package com.bytedance.sdk.gromore.j.j.ae.xt;

import android.content.Context;
import com.bytedance.msdk.cw.r.ae;
import com.bytedance.sdk.gromore.j.j.up;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements up {
    private com.bytedance.sdk.openadsdk.tj.j.xt.j.xt cw;

    /* renamed from: j, reason: collision with root package name */
    private ae f27436j;
    private com.bytedance.sdk.openadsdk.mediation.xt.xt.j xt;

    @Override // com.bytedance.sdk.gromore.j.j.up
    public void j() {
        this.f27436j.j(new com.bytedance.msdk.api.j.xt(9, this.xt.h()), new com.bytedance.msdk.api.r.j.cw.xt() { // from class: com.bytedance.sdk.gromore.j.j.ae.xt.cw.1
            @Override // com.bytedance.msdk.api.r.j.cw.xt
            public void j(List<com.bytedance.msdk.xt.cw> list) {
                if (list == null) {
                    j(new com.bytedance.msdk.api.j(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is null"));
                    return;
                }
                if (cw.this.cw != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<com.bytedance.msdk.xt.cw> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new j(cw.this.f27436j, it.next(), cw.this.f27436j.kt()));
                    }
                    cw.this.cw.j(arrayList);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.cw.xt
            public void j(com.bytedance.msdk.api.j jVar) {
                if (jVar == null || cw.this.cw == null) {
                    return;
                }
                cw.this.cw.j(jVar.f24334j, jVar.xt);
            }
        });
    }

    public cw(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.xt xtVar) {
        this.xt = jVar;
        if (jVar != null) {
            this.f27436j = new ae(context);
            this.cw = xtVar;
        }
    }
}
