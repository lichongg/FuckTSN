package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    private boolean f29592f;

    /* renamed from: j, reason: collision with root package name */
    protected int f29593j;
    private boolean tj;

    /* renamed from: v, reason: collision with root package name */
    private boolean f29594v;
    public ImageView xt;

    public ExpressVideoView(Context context, n nVar, String str, boolean z5) {
        super(context, nVar, false, false, str, false, false);
        this.tj = false;
        if ("draw_ad".equals(str)) {
            this.tj = true;
        }
        this.f29592f = z5;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected com.bykv.vk.openvk.component.video.api.r.cw j(Context context, ViewGroup viewGroup, n nVar, String str, boolean z5, boolean z6, boolean z7) {
        return this.f29592f ? new com.bytedance.sdk.openadsdk.core.video.nativevideo.cw(context, viewGroup, nVar, str, z5, z6, z7) : super.j(context, viewGroup, nVar, str, z5, z6, z7);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void xt() {
        if (this.tj) {
            super.xt(this.f29593j);
        }
    }

    private void tl() {
        ed.j((View) this.oq, 0);
        ed.j((View) this.qv, 0);
        ed.j((View) this.jy, 8);
    }

    public boolean A_() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        return (cwVar == null || cwVar.i() == null || !this.up.i().jy()) ? false : true;
    }

    public void cw() {
        ImageView imageView = this.jy;
        if (imageView != null) {
            ed.j((View) imageView, 8);
        }
    }

    public com.bykv.vk.openvk.component.video.api.r.cw getVideoController() {
        return this.up;
    }

    public void m() {
        ImageView imageView = this.vl;
        if (imageView != null) {
            ed.j((View) imageView, 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.vl;
        if (imageView != null && imageView.getVisibility() == 0) {
            ed.up(this.oq);
        }
        xt(this.f29593j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z5) {
        ImageView imageView = this.vl;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowFocusChanged(z5);
        } else {
            tj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        ImageView imageView = this.vl;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i6);
        } else {
            tj();
        }
    }

    public void setCanInterruptVideoPlay(boolean z5) {
        this.tj = z5;
    }

    protected void setPauseIcon(boolean z5) {
        if (this.xt == null) {
            this.xt = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.oq.i().rh() != null) {
                this.xt.setImageBitmap(com.bytedance.sdk.openadsdk.core.oq.i().rh());
            } else {
                com.bytedance.sdk.component.utils.kt.j(com.bytedance.sdk.openadsdk.core.v.getContext(), "tt_new_play_video", this.xt);
            }
            this.xt.setScaleType(ImageView.ScaleType.FIT_XY);
            int cw = ed.cw(getContext(), this.av);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cw, cw);
            layoutParams.gravity = 17;
            this.f30990m.addView(this.xt, layoutParams);
        }
        if (z5) {
            this.xt.setVisibility(0);
        } else {
            this.xt.setVisibility(8);
        }
    }

    public void setShouldCheckNetChange(boolean z5) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar != null) {
            cwVar.up(z5);
        }
    }

    public void setShowAdInteractionView(boolean z5) {
        com.bykv.vk.openvk.component.video.api.r.xt w5;
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.up;
        if (cwVar == null || (w5 = cwVar.w()) == null) {
            return;
        }
        w5.j(z5);
    }

    public void setVideoPlayStatus(int i6) {
        this.f29593j = i6;
    }

    public void y_() {
        ImageView imageView = this.jy;
        if (imageView != null) {
            ed.j((View) imageView, 0);
        }
    }

    private void tj() {
        qv();
        RelativeLayout relativeLayout = this.oq;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            }
            com.bytedance.sdk.openadsdk.g.xt.j(ln.xt(this.f30994r)).j(this.qv);
            j(this.qv, ln.xt(this.f30994r));
        }
        tl();
    }

    public void xt(boolean z5) {
        this.f29594v = z5;
    }

    protected void z_() {
        qv();
        ed.j((View) this.oq, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void j(boolean z5) {
        if (this.f29594v) {
            super.j(z5);
        }
    }
}
