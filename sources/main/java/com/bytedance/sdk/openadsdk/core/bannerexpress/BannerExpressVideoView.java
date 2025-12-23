package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class BannerExpressVideoView extends j {
    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.j
    protected void j() {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.f27976j, this.f27978r, this.up, this.oq);
        this.xt = nativeExpressVideoView;
        addView(nativeExpressVideoView, new ViewGroup.LayoutParams(-1, -1));
    }

    public com.bytedance.sdk.openadsdk.core.multipro.xt.j getVideoModel() {
        NativeExpressView nativeExpressView = this.xt;
        if (nativeExpressView != null) {
            return ((NativeExpressVideoView) nativeExpressView).getVideoModel();
        }
        return null;
    }

    public BannerExpressVideoView(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        super(context, nVar, xtVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.j
    public /* bridge */ /* synthetic */ void cw() {
        super.cw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.j
    public /* bridge */ /* synthetic */ NativeExpressView getCurView() {
        return super.getCurView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.j
    public /* bridge */ /* synthetic */ NativeExpressView getNextView() {
        return super.getNextView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.j
    public void j(n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.f27976j, nVar, xtVar, this.oq);
        this.cw = nativeExpressVideoView;
        nativeExpressVideoView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.j() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressVideoView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
            public void j(View view, int i6) {
                BannerExpressVideoView bannerExpressVideoView = BannerExpressVideoView.this;
                com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar = bannerExpressVideoView.f27977m;
                if (jVar != null) {
                    jVar.j(bannerExpressVideoView, i6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
            public void j(View view, float f6, float f7) {
                BannerExpressVideoView.this.j(f6, f7);
                BannerExpressVideoView.this.m();
            }
        });
        ed.j((View) this.cw, 8);
        addView(this.cw, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.j
    public /* bridge */ /* synthetic */ void r() {
        super.r();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.j
    public /* bridge */ /* synthetic */ void setDuration(int i6) {
        super.setDuration(i6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.j
    public /* bridge */ /* synthetic */ void setExpressInteractionListener(com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar) {
        super.setExpressInteractionListener(jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.j
    public /* bridge */ /* synthetic */ void setVideoAdListener(com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar) {
        super.setVideoAdListener(cwVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.j
    public /* bridge */ /* synthetic */ void up() {
        super.up();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.j
    public /* bridge */ /* synthetic */ boolean xt() {
        return super.xt();
    }
}
