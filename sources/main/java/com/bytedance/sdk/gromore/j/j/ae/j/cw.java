package com.bytedance.sdk.gromore.j.j.ae.j;

import android.content.Context;
import android.view.View;
import com.bytedance.msdk.api.r.j.j.r;
import com.bytedance.msdk.cw.r.qv;
import com.bytedance.sdk.gromore.j.j.up;
import java.util.ArrayList;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements up {
    private qv cw;

    /* renamed from: j, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.mediation.xt.xt.j f27366j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f27367r;
    private final com.bytedance.sdk.gromore.j.j.j.j xt;

    @Override // com.bytedance.sdk.gromore.j.j.up
    public void j() {
        final com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.xt oq;
        com.bytedance.msdk.api.j.xt xtVar = new com.bytedance.msdk.api.j.xt(1, this.f27366j.h());
        xtVar.j(this.f27367r);
        com.bytedance.sdk.openadsdk.mediation.xt.xt.xt l6 = this.f27366j.l();
        if (l6 != null && (oq = l6.oq()) != null) {
            this.cw.j(new r() { // from class: com.bytedance.sdk.gromore.j.j.ae.j.cw.1
                @Override // com.bytedance.msdk.api.r.j.j.r
                public View j(com.bytedance.msdk.api.r.j.j.cw cwVar) {
                    if (cwVar != null) {
                        return oq.j(new com.bytedance.sdk.gromore.j.j.j.r(cwVar));
                    }
                    return null;
                }
            });
        }
        this.cw.j(xtVar, new com.bytedance.msdk.api.r.j.j.xt() { // from class: com.bytedance.sdk.gromore.j.j.ae.j.cw.2
            @Override // com.bytedance.msdk.api.r.j.j.xt
            public void j(com.bytedance.msdk.api.j jVar) {
                if (cw.this.xt != null) {
                    cw.this.xt.j(jVar.f24334j, jVar.xt);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.j.xt
            public void j() {
                if (cw.this.xt != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new j(cw.this.cw));
                    cw.this.xt.j(arrayList);
                }
            }
        });
    }

    public cw(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.gromore.j.j.j.j jVar2, boolean z5) {
        this.f27366j = jVar;
        this.xt = jVar2;
        this.f27367r = z5;
        if (jVar != null) {
            this.cw = new qv(context);
        }
    }
}
