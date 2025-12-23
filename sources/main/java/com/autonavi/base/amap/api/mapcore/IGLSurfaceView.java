package com.autonavi.base.amap.api.mapcore;

import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.amap.api.col.p0003l.m2;
import com.amap.api.col.p0003l.n2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface IGLSurfaceView {
    int getHeight();

    SurfaceHolder getHolder();

    ViewParent getParent();

    int getRenderMode();

    int getWidth();

    boolean isEnabled();

    void onDetachedGLThread();

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j6);

    void queueEvent(Runnable runnable);

    void requestRender();

    void setBackgroundColor(int i6);

    void setEGLConfigChooser(m2 m2Var);

    void setEGLContextFactory(n2 n2Var);

    void setRenderMode(int i6);

    void setRenderer(GLSurfaceView.Renderer renderer);

    void setVisibility(int i6);

    void setZOrderOnTop(boolean z5);
}
