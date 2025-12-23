package com.bytedance.sdk.gromore.j.j.ae.xt;

import android.text.TextUtils;
import com.bytedance.msdk.cw.r.ae;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends com.bytedance.sdk.openadsdk.mediation.xt.xt.xt.j {

    /* renamed from: j, reason: collision with root package name */
    private ae f27450j;

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.xt.j
    public void j(String str, com.bytedance.sdk.openadsdk.tj.j.xt.j.xt xtVar) {
        xt(str, xtVar);
    }

    public r(ae aeVar) {
        this.f27450j = aeVar;
    }

    public void xt(String str, final com.bytedance.sdk.openadsdk.tj.j.xt.j.xt xtVar) {
        ae aeVar;
        if (!TextUtils.isEmpty(str) && (aeVar = this.f27450j) != null && xtVar != null) {
            aeVar.j(str, new com.bytedance.msdk.api.r.j.cw.xt() { // from class: com.bytedance.sdk.gromore.j.j.ae.xt.r.1
                @Override // com.bytedance.msdk.api.r.j.cw.xt
                public void j(List<com.bytedance.msdk.xt.cw> list) {
                    if (list == null) {
                        xtVar.j(null);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (com.bytedance.msdk.xt.cw cwVar : list) {
                        if (cwVar != null) {
                            arrayList.add(new j(r.this.f27450j, cwVar, r.this.f27450j.kt()));
                        }
                    }
                    xtVar.j(arrayList);
                }

                @Override // com.bytedance.msdk.api.r.j.cw.xt
                public void j(com.bytedance.msdk.api.j jVar) {
                    if (jVar != null) {
                        xtVar.j(jVar.f24334j, jVar.xt);
                    }
                }
            });
        } else {
            com.bytedance.msdk.j.up.cw.r("TMe", "adm 参数错误 或者 drawTokenInfo is null");
        }
    }
}
