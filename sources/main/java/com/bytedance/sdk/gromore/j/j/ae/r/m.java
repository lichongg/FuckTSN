package com.bytedance.sdk.gromore.j.j.ae.r;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.msdk.cw.r.g;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements com.bytedance.sdk.gromore.j.j.up {
    private com.bytedance.sdk.openadsdk.tj.j.xt.j.cw cw;

    /* renamed from: j, reason: collision with root package name */
    private g f27389j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f27390r;
    private com.bytedance.sdk.openadsdk.mediation.xt.xt.j xt;

    @Override // com.bytedance.sdk.gromore.j.j.up
    public void j() {
        com.bytedance.msdk.api.j.xt xtVar = new com.bytedance.msdk.api.j.xt(5, this.xt.h());
        xtVar.j(this.f27390r);
        this.f27389j.j(xtVar, new com.bytedance.msdk.api.r.j.ae.r() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.m.1
            @Override // com.bytedance.msdk.api.r.j.ae.r
            public void j(@NonNull List<com.bytedance.msdk.xt.cw> list) {
                if (list == null) {
                    j(new com.bytedance.msdk.api.j(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is null"));
                    return;
                }
                if (m.this.cw != null) {
                    LinkedList linkedList = new LinkedList();
                    Iterator<com.bytedance.msdk.xt.cw> it = list.iterator();
                    while (it.hasNext()) {
                        linkedList.add(new xt(m.this.f27389j, it.next(), m.this.f27389j.kt()));
                    }
                    m.this.cw.j(linkedList);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.ae.r
            public void j(@NonNull com.bytedance.msdk.api.j jVar) {
                if (jVar == null || m.this.cw == null) {
                    return;
                }
                m.this.cw.j(jVar.f24334j, jVar.xt);
            }
        });
    }

    public m(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.cw cwVar, boolean z5) {
        this.xt = jVar;
        this.f27390r = z5;
        if (jVar != null) {
            this.f27389j = new g(context);
            this.cw = cwVar;
        }
    }
}
