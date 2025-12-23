package com.bytedance.sdk.openadsdk.core.component.splash.cw.j;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends j {
    private String ae;

    /* renamed from: g, reason: collision with root package name */
    private int f28664g;

    /* renamed from: m, reason: collision with root package name */
    private Context f28665m;
    private com.bytedance.sdk.openadsdk.i.cw.cw.xt oq;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    public tl f28666r;
    private int tl = 1;
    private m up;

    public com.bytedance.sdk.openadsdk.i.cw.cw.xt ae() {
        return this.oq;
    }

    public boolean g() {
        return this.qv;
    }

    public Context getContext() {
        return this.f28665m;
    }

    public String m() {
        return this.ae;
    }

    public m r() {
        return this.up;
    }

    public int tl() {
        return this.f28664g;
    }

    public tl up() {
        return this.f28666r;
    }

    public cw(Context context, String str, m mVar, tl tlVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        this.f28665m = context;
        this.ae = str;
        this.up = mVar;
        this.qv = mVar.up();
        this.xt = mVar.xt();
        this.f28666r = tlVar;
        this.oq = xtVar;
    }
}
