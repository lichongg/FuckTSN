package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {

    /* renamed from: j, reason: collision with root package name */
    private boolean f30976j;
    private int xt;

    public NativeDrawVideoTsView(Context context, n nVar) {
        super(context, nVar);
        this.f30976j = false;
        setOnClickListener(this);
        this.xt = getResources().getConfiguration().orientation;
    }

    private void tl() {
        ed.j((View) this.oq, 0);
        ed.j((View) this.qv, 0);
        ed.j((View) this.jy, 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void ae() {
        this.az = "draw_ad";
        super.ae();
    }

    public void j(Bitmap bitmap, int i6) {
        oq.i().j(bitmap);
        this.av = i6;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.vl;
        if (imageView != null && imageView.getVisibility() == 0) {
            ed.up(this.oq);
        }
        xt();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        int i6 = this.xt;
        int i7 = configuration.orientation;
        if (i6 == i7) {
            return;
        }
        this.xt = i7;
        ed.j(this, new ed.j() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.1
            @Override // com.bytedance.sdk.openadsdk.core.rn.ed.j
            public void j(View view) {
                NativeDrawVideoTsView nativeDrawVideoTsView = NativeDrawVideoTsView.this;
                if (nativeDrawVideoTsView.up == null) {
                    return;
                }
                NativeDrawVideoTsView.this.j(nativeDrawVideoTsView.getWidth(), NativeDrawVideoTsView.this.getHeight());
            }
        });
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
        this.f30976j = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void xt() {
        if (this.f30976j) {
            super.xt();
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

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void r() {
        int i6 = getResources().getConfiguration().orientation;
        if (this.xt != i6) {
            this.xt = i6;
            ed.j(this, new ed.j() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.2
                @Override // com.bytedance.sdk.openadsdk.core.rn.ed.j
                public void j(View view) {
                    NativeDrawVideoTsView nativeDrawVideoTsView = NativeDrawVideoTsView.this;
                    if (nativeDrawVideoTsView.up == null) {
                        return;
                    }
                    NativeDrawVideoTsView.this.j(nativeDrawVideoTsView.getWidth(), NativeDrawVideoTsView.this.getHeight());
                    NativeDrawVideoTsView.super.r();
                }
            });
        } else {
            super.r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected com.bykv.vk.openvk.component.video.api.r.cw j(Context context, ViewGroup viewGroup, n nVar, String str, boolean z5, boolean z6, boolean z7) {
        return new cw(context, viewGroup, nVar, str, z5, z6, z7);
    }

    public NativeDrawVideoTsView(Context context, n nVar, String str, boolean z5, boolean z6) {
        super(context, nVar, str, z5, z6);
        this.f30976j = false;
        setOnClickListener(this);
        this.xt = getResources().getConfiguration().orientation;
    }
}
