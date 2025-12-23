package com.bytedance.sdk.component.adexpress.xt;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.xt.oq;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements oq {
    private jy cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f26045j;
    private j xt;

    @Override // com.bytedance.sdk.component.adexpress.xt.oq
    public void j() {
    }

    public m(Context context, jy jyVar, j jVar) {
        this.f26045j = context;
        this.xt = jVar;
        this.cw = jyVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.oq
    public boolean j(final oq.j jVar) {
        this.cw.ae().g();
        this.xt.j(new ae() { // from class: com.bytedance.sdk.component.adexpress.xt.m.1
            @Override // com.bytedance.sdk.component.adexpress.xt.ae
            public void j(View view, ws wsVar) {
                if (jVar.cw()) {
                    return;
                }
                az xt = jVar.xt();
                if (xt != null) {
                    xt.j(m.this.xt, wsVar);
                }
                jVar.j(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.xt.ae
            public void j(int i6, String str) {
                az xt = jVar.xt();
                if (xt != null) {
                    xt.a_(i6);
                }
            }
        });
        return true;
    }

    public void j(cw cwVar) {
        this.xt.j(cwVar);
    }
}
