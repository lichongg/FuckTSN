package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class x extends ch {
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ch, com.bytedance.sdk.openadsdk.core.nativeexpress.v
    public void j(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        this.f29722r = "draw_ad";
        NativeExpressDrawVideoView nativeExpressDrawVideoView = new NativeExpressDrawVideoView(context, nVar, xtVar, "draw_ad");
        ((v) this).f29720j = nativeExpressDrawVideoView;
        j(nativeExpressDrawVideoView, this.cw);
    }

    public x(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        super(context, nVar, xtVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt, com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(boolean z5) {
        NativeExpressView nativeExpressView = ((v) this).f29720j;
        if (nativeExpressView != null) {
            ((NativeExpressVideoView) nativeExpressView).setCanInterruptVideoPlay(z5);
        }
    }
}
