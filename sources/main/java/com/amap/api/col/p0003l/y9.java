package com.amap.api.col.p0003l;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class y9 implements IGLSurfaceView {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f7774a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f7775b;

    public y9(Context context) {
        this(context, (byte) 0);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final int getHeight() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final ViewParent getParent() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final int getRenderMode() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final int getWidth() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final boolean post(Runnable runnable) {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final boolean postDelayed(Runnable runnable, long j6) {
        return false;
    }

    private y9(Context context, byte b6) {
        this.f7774a = null;
        this.f7775b = false;
        this.f7774a = new q9(this, context);
    }

    public final IAMapDelegate a() {
        return this.f7774a;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final boolean isEnabled() {
        return this.f7774a != null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void queueEvent(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void onDetachedGLThread() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void requestRender() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setBackgroundColor(int i6) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(m2 m2Var) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(n2 n2Var) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderMode(int i6) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setVisibility(int i6) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setZOrderOnTop(boolean z5) {
    }
}
