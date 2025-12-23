package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class FullRewardExpressBackupView extends BackupView {
    private FrameLayout az;
    private View jy;
    private NativeExpressView ws;

    public void j(n nVar, NativeExpressView nativeExpressView) {
        setBackgroundColor(-1);
        this.xt = nVar;
        this.ws = nativeExpressView;
        if (uf.tl(nVar) == 7) {
            this.up = "rewarded_video";
        } else {
            this.up = "fullscreen_interstitial_ad";
        }
        j();
        this.ws.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void xt() {
        FrameLayout frameLayout = new FrameLayout(this.f29586j);
        this.jy = frameLayout;
        frameLayout.setId(2114387740);
        addView(this.jy);
        FrameLayout frameLayout2 = (FrameLayout) this.jy.findViewById(2114387740);
        this.az = frameLayout2;
        frameLayout2.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.az;
    }

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.f29586j = context;
    }

    private void j() {
        this.f29587m = ed.cw(this.f29586j, this.ws.getExpectExpressWidth());
        this.ae = ed.cw(this.f29586j, this.ws.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f29587m, this.ae);
        }
        layoutParams.width = this.f29587m;
        layoutParams.height = this.ae;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        xt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void j(View view, int i6, com.bytedance.sdk.openadsdk.core.tj.x xVar) {
        NativeExpressView nativeExpressView = this.ws;
        if (nativeExpressView != null) {
            nativeExpressView.j(view, i6, xVar);
        }
    }
}
