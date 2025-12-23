package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.renderview.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTLottieVideoContainer extends FrameLayout implements com.bykv.vk.openvk.component.video.api.renderview.xt {

    /* renamed from: j, reason: collision with root package name */
    private xt.j f31889j;

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public void j(com.bykv.vk.openvk.component.video.api.renderview.j jVar) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public void j(int i6, int i7) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i7;
        layoutParams.width = i6;
        setLayoutParams(layoutParams);
    }

    public void setWindowVisibilityChangedListener(xt.j jVar) {
        this.f31889j = jVar;
    }

    public TTLottieVideoContainer(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public View getView() {
        return this;
    }
}
