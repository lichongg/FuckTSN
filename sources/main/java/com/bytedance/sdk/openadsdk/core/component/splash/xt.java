package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.component.splash.ae;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
abstract class xt {
    protected n cw;

    /* renamed from: j, reason: collision with root package name */
    protected Context f28793j;

    /* renamed from: r, reason: collision with root package name */
    protected ae.j f28794r;
    protected ViewGroup xt;

    public abstract String j();

    public abstract void j(com.bytedance.sdk.openadsdk.core.xt.j jVar);

    public void j(boolean z5) {
    }

    public void j(Context context, ViewGroup viewGroup, n nVar) {
        this.f28793j = context;
        this.xt = viewGroup;
        this.cw = nVar;
    }

    public void xt() {
        ae.j jVar = this.f28794r;
        if (jVar != null) {
            jVar.xt();
        }
    }

    xt() {
    }

    public void j(com.bytedance.sdk.openadsdk.core.video.nativevideo.r rVar, ae.j jVar) {
        com.bytedance.sdk.openadsdk.core.jy.cw.cw(this.cw, "splash_ad", j());
        this.xt.setVisibility(0);
        this.f28794r = jVar;
    }
}
