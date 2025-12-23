package com.bytedance.sdk.gromore.j.j.ae.r;

import android.text.TextUtils;
import com.bytedance.msdk.cw.r.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends com.bytedance.sdk.openadsdk.mediation.xt.xt.xt.xt {

    /* renamed from: j, reason: collision with root package name */
    private g f27387j;

    @Override // com.bytedance.sdk.openadsdk.mediation.xt.xt.xt.xt
    public void j(String str, com.bytedance.sdk.openadsdk.tj.j.xt.j.cw cwVar) {
        xt(str, cwVar);
    }

    public j(g gVar) {
        this.f27387j = gVar;
    }

    public void xt(String str, final com.bytedance.sdk.openadsdk.tj.j.xt.j.cw cwVar) {
        g gVar;
        if (!TextUtils.isEmpty(str) && (gVar = this.f27387j) != null && cwVar != null) {
            gVar.j(str, new com.bytedance.msdk.api.r.j.ae.r() { // from class: com.bytedance.sdk.gromore.j.j.ae.r.j.1
                @Override // com.bytedance.msdk.api.r.j.ae.r
                public void j(List<com.bytedance.msdk.xt.cw> list) {
                    if (list == null) {
                        cwVar.j(null);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (com.bytedance.msdk.xt.cw cwVar2 : list) {
                        if (cwVar2 != null) {
                            arrayList.add(new xt(j.this.f27387j, cwVar2, j.this.f27387j.kt()));
                        }
                    }
                    cwVar.j(arrayList);
                }

                @Override // com.bytedance.msdk.api.r.j.ae.r
                public void j(com.bytedance.msdk.api.j jVar) {
                    if (jVar != null) {
                        cwVar.j(jVar.f24334j, jVar.xt);
                    }
                }
            });
        } else {
            com.bytedance.msdk.j.up.cw.r("TMe", "adm 参数错误 或者 nativeAdManager is null");
        }
    }
}
