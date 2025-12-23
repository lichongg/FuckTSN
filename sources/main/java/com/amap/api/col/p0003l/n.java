package com.amap.api.col.p0003l;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class n extends GLSurfaceView implements IGLSurfaceView {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f6786a;

    /* renamed from: b, reason: collision with root package name */
    private GLMapRender f6787b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f6788c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (n.this.f6787b != null) {
                try {
                    n.this.f6787b.onSurfaceDestory();
                } catch (Throwable th) {
                    th.printStackTrace();
                    b3.D(th);
                }
            }
        }
    }

    public n(Context context, boolean z5) {
        this(context, z5, (byte) 0);
    }

    @Override // android.opengl.GLSurfaceView, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f6787b = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    private n(Context context, boolean z5, byte b6) {
        super(context, null);
        this.f6786a = null;
        this.f6787b = null;
        this.f6788c = false;
        o2.a(this, 5, 6, 5);
        this.f6786a = new q9(this, context, z5);
    }

    public final IAMapDelegate b() {
        return this.f6786a;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected final void onDetachedFromWindow() {
        d3.e(c3.f5803c, "AMapGLSurfaceView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        onPause();
        try {
            GLMapRender gLMapRender = this.f6787b;
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
        d3.e(c3.f5803c, "AMapGLSurfaceView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            onPause();
            try {
                GLMapRender gLMapRender = this.f6787b;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                b3.D(th);
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        d3.e(c3.f5803c, "AMapGLSurfaceView onPause mMapRender.mSurfacedestoryed " + this.f6787b.mSurfacedestoryed);
        if (!this.f6787b.mSurfacedestoryed) {
            queueEvent(new a());
            int i6 = 0;
            while (!this.f6787b.mSurfacedestoryed) {
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
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d3.e(c3.f5803c, "AMapGLSurfaceView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f6787b;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            b3.D(th);
        }
        onResume();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        d3.e(c3.f5803c, "AMapGLSurfaceView onPause");
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f6786a.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected final void onWindowVisibilityChanged(int i6) {
        GLMapRender gLMapRender;
        super.onWindowVisibilityChanged(i6);
        d3.e(c3.f5803c, "AMapGLSurfaceView onWindowVisibilityChanged visibility ".concat(String.valueOf(i6)));
        try {
            if (i6 != 8 && i6 != 4) {
                if (i6 == 0 && (gLMapRender = this.f6787b) != null) {
                    gLMapRender.renderResume();
                    return;
                }
                return;
            }
            GLMapRender gLMapRender2 = this.f6787b;
            if (gLMapRender2 != null) {
                gLMapRender2.renderPause();
                this.f6788c = false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            b3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(m2 m2Var) {
        super.setEGLConfigChooser((GLSurfaceView.EGLConfigChooser) m2Var);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(n2 n2Var) {
        super.setEGLContextFactory((GLSurfaceView.EGLContextFactory) n2Var);
    }
}
