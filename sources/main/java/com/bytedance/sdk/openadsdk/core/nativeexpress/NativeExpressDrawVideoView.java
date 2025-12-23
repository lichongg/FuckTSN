package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class NativeExpressDrawVideoView extends NativeExpressVideoView {
    private int tj;

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView
    protected ExpressVideoView j(Context context, n nVar, String str) {
        return new ExpressVideoView(context, nVar, str, true);
    }

    public NativeExpressDrawVideoView(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str) {
        super(context, nVar, xtVar, str);
        this.tj = getResources().getConfiguration().orientation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view, int i6, int i7) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = i6;
        layoutParams.height = i7;
        view.setLayoutParams(layoutParams);
    }

    private void v() {
        int i6 = getResources().getConfiguration().orientation;
        if (this.tj != i6) {
            this.tj = i6;
            ed.j(this, new ed.j() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressDrawVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.rn.ed.j
                public void j(View view) {
                    int width = NativeExpressDrawVideoView.this.getWidth();
                    int height = NativeExpressDrawVideoView.this.getHeight();
                    NativeExpressDrawVideoView nativeExpressDrawVideoView = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView.j(nativeExpressDrawVideoView.jy, width, height);
                    View findViewById = NativeExpressDrawVideoView.this.jy.findViewById(2114387720);
                    NativeExpressDrawVideoView.this.j(findViewById, width, height);
                    if (findViewById != null) {
                        findViewById.requestLayout();
                    }
                    NativeExpressDrawVideoView nativeExpressDrawVideoView2 = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView2.j(nativeExpressDrawVideoView2.getWebView(), width, height);
                    ExpressVideoView expressVideoView = NativeExpressDrawVideoView.this.oq;
                    if (expressVideoView != null) {
                        expressVideoView.j(width, height);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView, com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        v();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        v();
    }
}
