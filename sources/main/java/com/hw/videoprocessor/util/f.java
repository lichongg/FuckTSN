package com.hw.videoprocessor.util;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(16)
/* loaded from: D:\Downloads\app\classes6.dex */
public class f implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: n, reason: collision with root package name */
    private static final int f35460n = 4;

    /* renamed from: o, reason: collision with root package name */
    private static final int f35461o = 12440;

    /* renamed from: a, reason: collision with root package name */
    private EGL10 f35462a;

    /* renamed from: b, reason: collision with root package name */
    private EGLDisplay f35463b;

    /* renamed from: c, reason: collision with root package name */
    private EGLContext f35464c;

    /* renamed from: d, reason: collision with root package name */
    private EGLSurface f35465d;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceTexture f35466e;

    /* renamed from: f, reason: collision with root package name */
    private Surface f35467f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f35468g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f35469h;

    /* renamed from: i, reason: collision with root package name */
    private h f35470i;

    /* renamed from: j, reason: collision with root package name */
    private int f35471j;

    /* renamed from: k, reason: collision with root package name */
    private int f35472k;

    /* renamed from: l, reason: collision with root package name */
    private int f35473l;

    /* renamed from: m, reason: collision with root package name */
    private ByteBuffer f35474m;

    public f(int i6, int i7, int i8) {
        this.f35463b = null;
        this.f35464c = null;
        this.f35465d = null;
        this.f35468g = new Object();
        this.f35473l = 0;
        if (i6 <= 0 || i7 <= 0) {
            throw new IllegalArgumentException();
        }
        this.f35471j = i6;
        this.f35472k = i7;
        this.f35473l = i8;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i6 * i7 * 4);
        this.f35474m = allocateDirect;
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        e(i6, i7);
        h();
        j();
    }

    private void c(String str) {
        if (this.f35462a.eglGetError() != 12288) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    private void j() {
        h hVar = new h(this.f35473l);
        this.f35470i = hVar;
        hVar.g();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f35470i.e());
        this.f35466e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f35467f = new Surface(this.f35466e);
    }

    public void a() {
        synchronized (this.f35468g) {
            do {
                if (this.f35469h) {
                    this.f35469h = false;
                } else {
                    try {
                        this.f35468g.wait(5000L);
                    } catch (InterruptedException e6) {
                        throw new RuntimeException(e6);
                    }
                }
            } while (this.f35469h);
            throw new RuntimeException("Surface frame wait timed out");
        }
        this.f35470i.b("before updateTexImage");
        this.f35466e.updateTexImage();
    }

    public void b(String str) {
        this.f35470i.a(str);
    }

    public void d(boolean z5) {
        this.f35470i.d(this.f35466e, z5);
    }

    public ByteBuffer f() {
        this.f35474m.rewind();
        GLES20.glReadPixels(0, 0, this.f35471j, this.f35472k, 6408, 5121, this.f35474m);
        return this.f35474m;
    }

    public Surface g() {
        return this.f35467f;
    }

    public void h() {
        if (this.f35462a == null) {
            throw new RuntimeException("not configured for makeCurrent");
        }
        c("before makeCurrent");
        EGL10 egl10 = this.f35462a;
        EGLDisplay eGLDisplay = this.f35463b;
        EGLSurface eGLSurface = this.f35465d;
        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f35464c)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void i() {
        EGL10 egl10 = this.f35462a;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.f35464c)) {
                EGL10 egl102 = this.f35462a;
                EGLDisplay eGLDisplay = this.f35463b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            }
            this.f35462a.eglDestroySurface(this.f35463b, this.f35465d);
            this.f35462a.eglDestroyContext(this.f35463b, this.f35464c);
        }
        this.f35467f.release();
        this.f35463b = null;
        this.f35464c = null;
        this.f35465d = null;
        this.f35462a = null;
        this.f35470i = null;
        this.f35467f = null;
        this.f35466e = null;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f35468g) {
            try {
                if (this.f35469h) {
                    throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
                }
                this.f35469h = true;
                this.f35468g.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void e(int i6, int i7) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f35462a = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f35463b = eglGetDisplay;
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
            if (this.f35462a.eglInitialize(eglGetDisplay, null)) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (this.f35462a.eglChooseConfig(this.f35463b, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12339, 1, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                    this.f35464c = this.f35462a.eglCreateContext(this.f35463b, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{f35461o, 2, 12344});
                    c("eglCreateContext");
                    if (this.f35464c != null) {
                        this.f35465d = this.f35462a.eglCreatePbufferSurface(this.f35463b, eGLConfigArr[0], new int[]{12375, i6, 12374, i7, 12344});
                        c("eglCreatePbufferSurface");
                        if (this.f35465d != null) {
                            return;
                        } else {
                            throw new RuntimeException("surface was null");
                        }
                    }
                    throw new RuntimeException("null context");
                }
                throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
            }
            this.f35463b = null;
            throw new RuntimeException("unable to initialize EGL10");
        }
        throw new RuntimeException("unable to get EGL10 display");
    }

    public f() {
        this.f35463b = null;
        this.f35464c = null;
        this.f35465d = null;
        this.f35468g = new Object();
        this.f35473l = 0;
        j();
    }
}
