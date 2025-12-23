package com.hw.videoprocessor.util;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(18)
/* loaded from: D:\Downloads\app\classes6.dex */
public class e {

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f35453e = false;

    /* renamed from: f, reason: collision with root package name */
    private static final int f35454f = 12610;

    /* renamed from: g, reason: collision with root package name */
    private static final int f35455g = 4;

    /* renamed from: a, reason: collision with root package name */
    private EGLDisplay f35456a;

    /* renamed from: b, reason: collision with root package name */
    private EGLContext f35457b;

    /* renamed from: c, reason: collision with root package name */
    private EGLSurface f35458c;

    /* renamed from: d, reason: collision with root package name */
    private Surface f35459d;

    private void a(String str) {
        boolean z5 = false;
        while (EGL14.eglGetError() != 12288) {
            z5 = true;
        }
        if (z5) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    private void b() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f35456a = eglGetDisplay;
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            this.f35456a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f35456a, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, f35454f, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.f35457b = EGL14.eglCreateContext(this.f35456a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        a("eglCreateContext");
        if (this.f35457b == null) {
            throw new RuntimeException("null context");
        }
        this.f35458c = EGL14.eglCreateWindowSurface(this.f35456a, eGLConfigArr[0], this.f35459d, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (this.f35458c == null) {
            throw new RuntimeException("surface was null");
        }
    }

    public Surface c() {
        return this.f35459d;
    }

    public void d() {
        EGLDisplay eGLDisplay = this.f35456a;
        EGLSurface eGLSurface = this.f35458c;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f35457b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void f(long j6) {
        EGLExt.eglPresentationTimeANDROID(this.f35456a, this.f35458c, j6);
    }

    public boolean g() {
        return EGL14.eglSwapBuffers(this.f35456a, this.f35458c);
    }

    public e(Surface surface) {
        surface.getClass();
        this.f35459d = surface;
        b();
    }

    public void e() {
        if (EGL14.eglGetCurrentContext().equals(this.f35457b)) {
            EGLDisplay eGLDisplay = this.f35456a;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.f35456a, this.f35458c);
        EGL14.eglDestroyContext(this.f35456a, this.f35457b);
        this.f35459d.release();
        this.f35456a = null;
        this.f35457b = null;
        this.f35458c = null;
        this.f35459d = null;
    }
}
