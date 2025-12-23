package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv {
    private String ae;
    private com.bytedance.sdk.openadsdk.core.qv.xt.cw cw;

    /* renamed from: j, reason: collision with root package name */
    private final Context f29872j;

    /* renamed from: m, reason: collision with root package name */
    private View f29873m;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.nativeexpress.m f29874r;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.up up;
    private final com.bytedance.sdk.openadsdk.core.tj.n xt;

    public void j(int i6, com.bytedance.sdk.openadsdk.core.tj.x xVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.up upVar;
        if (i6 == -1 || xVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.tj.qv qvVar = new com.bytedance.sdk.openadsdk.core.tj.qv();
        qvVar.j(xVar.f30480j);
        qvVar.xt(xVar.xt);
        qvVar.cw(xVar.cw);
        qvVar.r(xVar.f30482r);
        qvVar.j(xVar.az);
        qvVar.j(xVar.av);
        if (i6 != 1) {
            if (i6 == 2 && (upVar = this.up) != null) {
                upVar.j(xVar);
                this.up.j(qvVar);
                this.up.j(this.f29873m, qvVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.m mVar = this.f29874r;
        if (mVar != null) {
            mVar.j(xVar);
            this.f29874r.j(qvVar);
            this.f29874r.j(this.f29873m, qvVar);
        }
    }

    public qv(Context context, com.bytedance.sdk.openadsdk.core.tj.n nVar, View view, String str) {
        this.ae = "rewarded_video";
        this.xt = nVar;
        this.f29872j = context;
        this.f29873m = view;
        if (TextUtils.isEmpty(str)) {
            this.ae = com.bytedance.sdk.openadsdk.core.rn.uf.xt(com.bytedance.sdk.openadsdk.core.rn.uf.tl(nVar));
        } else {
            this.ae = str;
        }
        if (nVar.jl() == 4) {
            this.cw = com.bytedance.sdk.openadsdk.core.qv.tl.j(context, nVar, this.ae, false);
        }
        String str2 = this.ae;
        com.bytedance.sdk.openadsdk.core.nativeexpress.m mVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.m(context, nVar, str2, com.bytedance.sdk.openadsdk.core.rn.uf.xt(str2));
        this.f29874r = mVar;
        mVar.j(this.f29873m);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.f29874r.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.cw);
        String str3 = this.ae;
        com.bytedance.sdk.openadsdk.core.nativeexpress.up upVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.up(context, nVar, str3, com.bytedance.sdk.openadsdk.core.rn.uf.xt(str3));
        this.up = upVar;
        upVar.j(this.f29873m);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.up.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.cw);
    }
}
