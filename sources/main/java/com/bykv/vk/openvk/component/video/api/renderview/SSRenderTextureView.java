package com.bykv.vk.openvk.component.video.api.renderview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.renderview.xt;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class SSRenderTextureView extends TextureView implements TextureView.SurfaceTextureListener, xt {

    /* renamed from: j, reason: collision with root package name */
    private j f22975j;
    private xt.j xt;

    public SSRenderTextureView(Context context) {
        this(context, null);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public void j(j jVar) {
        this.f22975j = jVar;
        setSurfaceTextureListener(this);
    }

    public SSRenderTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TextureView", "onSurfaceTextureAvailable: ");
        j jVar = this.f22975j;
        if (jVar != null) {
            jVar.j(surfaceTexture, i6, i7);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TextureView", "onSurfaceTextureDestroyed: ");
        j jVar = this.f22975j;
        if (jVar != null) {
            return jVar.j(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
        com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TextureView", "onSurfaceTextureSizeChanged: ");
    }

    public void setWindowVisibilityChangedListener(xt.j jVar) {
        this.xt = jVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public void j(int i6, int i7) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i7;
        layoutParams.width = i6;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            vl.j(th);
            if (com.bykv.vk.openvk.component.video.api.m.cw.xt()) {
                com.bykv.vk.openvk.component.video.api.m.cw.j("CSJ_VIDEO_TextureView", "rethrow exception for debug & local_test, (TextureView)", th);
            }
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
