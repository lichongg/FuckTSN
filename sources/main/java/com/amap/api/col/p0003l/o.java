package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class o extends y implements IGLSurfaceView {

    /* renamed from: m, reason: collision with root package name */
    private IAMapDelegate f6809m;

    /* renamed from: n, reason: collision with root package name */
    private GLMapRender f6810n;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f6811o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (o.this.f6810n != null) {
                    o.this.f6810n.onSurfaceDestory();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                b3.D(th);
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.y, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f6810n = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    @Override // com.amap.api.col.p0003l.y
    public final void f() {
        d3.e(c3.f5803c, "AMapGLTextureView onPause mMapRender.mSurfacedestoryed " + this.f6810n.mSurfacedestoryed);
        if (!this.f6810n.mSurfacedestoryed) {
            queueEvent(new a());
            int i6 = 0;
            while (!this.f6810n.mSurfacedestoryed) {
                int i7 = i6 + 1;
                if (i6 >= 50) {
                    break;
                }
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException unused) {
                }
                i6 = i7;
            }
        }
        super.f();
    }

    @Override // com.amap.api.col.p0003l.y, android.view.View
    protected final void onDetachedFromWindow() {
        d3.e(c3.f5803c, "AMapGLTextureView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        f();
        try {
            GLMapRender gLMapRender = this.f6810n;
            if (gLMapRender != null) {
                gLMapRender.onDetachedFromWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void onDetachedGLThread() {
        d3.e(c3.f5803c, "AMapGLTextureView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            f();
            try {
                GLMapRender gLMapRender = this.f6810n;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // com.amap.api.col.p0003l.y, android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        d3.e(c3.f5803c, "AMapGLTextureView onSurfaceTextureDestroyed");
        requestRender();
        try {
            if (MapsInitializer.getTextureDestroyRender()) {
                Thread.sleep(100L);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            b3.D(th);
        }
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    public final IAMapDelegate r() {
        return this.f6809m;
    }

    public o(Context context, boolean z5) {
        super(context);
        this.f6809m = null;
        this.f6810n = null;
        this.f6811o = false;
        if (Build.VERSION.SDK_INT >= 34) {
            o2.a(this, 8, 8, 8);
        } else {
            o2.a(this, 5, 6, 5);
        }
        this.f6809m = new q9(this, context, z5);
    }

    @Override // com.amap.api.col.p0003l.y
    public final void h() {
        super.h();
        d3.e(c3.f5803c, "AMapGLTextureView onResume");
    }

    @Override // com.amap.api.col.p0003l.y, android.view.TextureView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d3.e(c3.f5803c, "AMapGLTextureView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f6810n;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        h();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f6809m.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i6) {
        GLMapRender gLMapRender;
        super.onWindowVisibilityChanged(i6);
        d3.e(c3.f5803c, "AMapGLTextureView onWindowVisibilityChanged visibility ".concat(String.valueOf(i6)));
        try {
            if (i6 != 8 && i6 != 4) {
                if (i6 == 0 && (gLMapRender = this.f6810n) != null) {
                    gLMapRender.renderResume();
                    return;
                }
                return;
            }
            GLMapRender gLMapRender2 = this.f6810n;
            if (gLMapRender2 != null) {
                gLMapRender2.renderPause();
                this.f6811o = false;
            }
            requestRender();
        } catch (Throwable th) {
            th.printStackTrace();
            b3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(m2 m2Var) {
        super.c(m2Var);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(n2 n2Var) {
        super.d(n2Var);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setZOrderOnTop(boolean z5) {
    }
}
