package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends xt {
    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.xt
    protected void j(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        ((xt) this).f27985j = new BannerExpressVideoView(context, nVar, xtVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar) {
        j jVar = ((xt) this).f27985j;
        if (jVar != null) {
            jVar.setVideoAdListener(cwVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt
    public com.bytedance.sdk.openadsdk.core.multipro.xt.j qv() {
        WeakReference<BannerExpressBackupView> weakReference = this.ae;
        if (weakReference != null && weakReference.get() != null) {
            return this.ae.get().getVideoModel();
        }
        j jVar = ((xt) this).f27985j;
        if (jVar != null) {
            return ((BannerExpressVideoView) jVar).getVideoModel();
        }
        return null;
    }

    public cw(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        super(context, nVar, xtVar);
    }
}
