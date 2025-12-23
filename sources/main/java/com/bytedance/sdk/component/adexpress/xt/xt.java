package com.bytedance.sdk.component.adexpress.xt;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.xt.oq;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements oq {
    private ThemeStatusBroadcastReceiver cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f26053j;

    /* renamed from: m, reason: collision with root package name */
    private int f26054m;

    /* renamed from: r, reason: collision with root package name */
    private tl f26055r;
    private jy up;
    private com.bytedance.sdk.component.adexpress.dynamic.j.j xt;

    public xt(Context context, jy jyVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z5, com.bytedance.sdk.component.adexpress.dynamic.r.tl tlVar, tl tlVar2, com.bytedance.sdk.component.adexpress.dynamic.up.j jVar) {
        this(context, jyVar, themeStatusBroadcastReceiver, z5, tlVar, tlVar2, jVar, null);
    }

    public xt(Context context, jy jyVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z5, com.bytedance.sdk.component.adexpress.dynamic.r.tl tlVar, tl tlVar2, com.bytedance.sdk.component.adexpress.dynamic.up.j jVar, com.bytedance.sdk.component.adexpress.dynamic.j.j jVar2) {
        this.f26053j = context;
        this.up = jyVar;
        this.cw = themeStatusBroadcastReceiver;
        this.f26055r = tlVar2;
        if (jVar2 != null) {
            this.xt = jVar2;
        } else {
            this.xt = new com.bytedance.sdk.component.adexpress.dynamic.j.j(context, themeStatusBroadcastReceiver, z5, tlVar, jyVar, jVar);
        }
        this.xt.j(this.f26055r);
        if (tlVar instanceof com.bytedance.sdk.component.adexpress.dynamic.r.ae) {
            this.f26054m = 3;
        } else {
            this.f26054m = 2;
        }
    }

    public void j(boolean z5) {
        this.xt.xt(z5);
    }

    public com.bytedance.sdk.component.adexpress.dynamic.r xt() {
        com.bytedance.sdk.component.adexpress.dynamic.j.j jVar = this.xt;
        if (jVar != null) {
            return jVar.m();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.oq
    public boolean j(final oq.j jVar) {
        this.up.ae().j(this.f26054m);
        this.xt.j(new ae() { // from class: com.bytedance.sdk.component.adexpress.xt.xt.1
            @Override // com.bytedance.sdk.component.adexpress.xt.ae
            public void j(View view, ws wsVar) {
                if (jVar.cw()) {
                    return;
                }
                xt.this.up.ae().up(xt.this.f26054m);
                xt.this.up.ae().m(xt.this.f26054m);
                xt.this.up.ae().jy();
                az xt = jVar.xt();
                if (xt == null) {
                    return;
                }
                xt.j(xt.this.xt, wsVar);
                jVar.j(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.xt.ae
            public void j(int i6, String str) {
                xt.this.up.ae().j(xt.this.f26054m, i6, str, jVar.xt(xt.this));
                if (jVar.xt(xt.this)) {
                    jVar.j(xt.this);
                    return;
                }
                az xt = jVar.xt();
                if (xt == null) {
                    return;
                }
                xt.a_(i6);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.oq
    public void j() {
        com.bytedance.sdk.component.adexpress.dynamic.j.j jVar = this.xt;
        if (jVar != null) {
            jVar.xt();
        }
    }
}
