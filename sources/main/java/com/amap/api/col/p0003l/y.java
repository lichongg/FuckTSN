package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.TextureView;
import com.amap.api.maps.MapsInitializer;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes2.dex */
public class y extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: l, reason: collision with root package name */
    private static final j f7676l = new j(0);

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<y> f7677a;

    /* renamed from: b, reason: collision with root package name */
    private i f7678b;

    /* renamed from: c, reason: collision with root package name */
    private GLSurfaceView.Renderer f7679c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7680d;

    /* renamed from: e, reason: collision with root package name */
    private e f7681e;

    /* renamed from: f, reason: collision with root package name */
    private f f7682f;

    /* renamed from: g, reason: collision with root package name */
    private g f7683g;

    /* renamed from: h, reason: collision with root package name */
    private k f7684h;

    /* renamed from: i, reason: collision with root package name */
    private int f7685i;

    /* renamed from: j, reason: collision with root package name */
    private int f7686j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7687k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private abstract class a implements e {

        /* renamed from: a, reason: collision with root package name */
        protected int[] f7688a;

        abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // com.amap.api.col.3l.y.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f7688a, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i6 = iArr[0];
            if (i6 <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i6];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f7688a, eGLConfigArr, i6, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig a6 = a(egl10, eGLDisplay, eGLConfigArr);
            if (a6 != null) {
                return a6;
            }
            throw new IllegalArgumentException("No config chosen");
        }

        public a(int[] iArr) {
            this.f7688a = b(iArr);
        }

        private int[] b(int[] iArr) {
            if (y.this.f7686j != 2 && y.this.f7686j != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i6 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            iArr2[i6] = 12352;
            if (y.this.f7686j == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b extends a {

        /* renamed from: c, reason: collision with root package name */
        private int[] f7690c;

        /* renamed from: d, reason: collision with root package name */
        protected int f7691d;

        /* renamed from: e, reason: collision with root package name */
        protected int f7692e;

        /* renamed from: f, reason: collision with root package name */
        protected int f7693f;

        /* renamed from: g, reason: collision with root package name */
        protected int f7694g;

        /* renamed from: h, reason: collision with root package name */
        protected int f7695h;

        /* renamed from: i, reason: collision with root package name */
        protected int f7696i;

        @Override // com.amap.api.col.3l.y.a
        public final EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int c6 = c(egl10, eGLDisplay, eGLConfig, 12325);
                int c7 = c(egl10, eGLDisplay, eGLConfig, 12326);
                if (c6 >= this.f7695h && c7 >= this.f7696i) {
                    int c8 = c(egl10, eGLDisplay, eGLConfig, 12324);
                    int c9 = c(egl10, eGLDisplay, eGLConfig, 12323);
                    int c10 = c(egl10, eGLDisplay, eGLConfig, 12322);
                    int c11 = c(egl10, eGLDisplay, eGLConfig, 12321);
                    if (c8 == this.f7691d && c9 == this.f7692e && c10 == this.f7693f && c11 == this.f7694g) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        public b() {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 16, 12326, 0, 12344});
            this.f7690c = new int[1];
            this.f7691d = 8;
            this.f7692e = 8;
            this.f7693f = 8;
            this.f7694g = 0;
            this.f7695h = 16;
            this.f7696i = 0;
        }

        private int c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i6) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i6, this.f7690c)) {
                return this.f7690c[0];
            }
            return 0;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements f {
        private c() {
        }

        @Override // com.amap.api.col.3l.y.f
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, y.this.f7686j, 12344};
            if (y.this.f7686j == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, iArr);
        }

        /* synthetic */ c(y yVar, byte b6) {
            this();
        }

        @Override // com.amap.api.col.3l.y.f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Objects.toString(eGLDisplay);
                Objects.toString(eGLContext);
                h.c("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d implements g {
        private d() {
        }

        @Override // com.amap.api.col.3l.y.g
        public final EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* synthetic */ d(byte b6) {
            this();
        }

        @Override // com.amap.api.col.3l.y.g
        public final void b(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void b(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class h {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<y> f7699a;

        /* renamed from: b, reason: collision with root package name */
        EGL10 f7700b;

        /* renamed from: c, reason: collision with root package name */
        EGLDisplay f7701c;

        /* renamed from: d, reason: collision with root package name */
        EGLSurface f7702d;

        /* renamed from: e, reason: collision with root package name */
        EGLConfig f7703e;

        /* renamed from: f, reason: collision with root package name */
        EGLContext f7704f;

        private void b(String str) {
            c(str, this.f7700b.eglGetError());
        }

        private static String e(String str, int i6) {
            return str + " failed: " + i6;
        }

        private void k() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f7702d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.f7700b.eglMakeCurrent(this.f7701c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            y yVar = this.f7699a.get();
            if (yVar != null) {
                yVar.f7683g.b(this.f7700b, this.f7701c, this.f7702d);
            }
            this.f7702d = null;
        }

        public final boolean f() {
            if (this.f7700b == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.f7701c == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.f7703e == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            k();
            y yVar = this.f7699a.get();
            if (yVar != null) {
                this.f7702d = yVar.f7683g.a(this.f7700b, this.f7701c, this.f7703e, yVar.getSurfaceTexture());
            } else {
                this.f7702d = null;
            }
            EGLSurface eGLSurface = this.f7702d;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                this.f7700b.eglGetError();
                return false;
            }
            if (this.f7700b.eglMakeCurrent(this.f7701c, eGLSurface, eGLSurface, this.f7704f)) {
                return true;
            }
            d("EGLHelper", "eglMakeCurrent", this.f7700b.eglGetError());
            return false;
        }

        final GL g() {
            GL gl = this.f7704f.getGL();
            y yVar = this.f7699a.get();
            if (yVar == null) {
                return gl;
            }
            if (yVar.f7684h != null) {
                gl = yVar.f7684h.a();
            }
            if ((yVar.f7685i & 3) != 0) {
                return GLDebugHelper.wrap(gl, (yVar.f7685i & 1) == 0 ? 0 : 1, (yVar.f7685i & 2) != 0 ? new l() : null);
            }
            return gl;
        }

        public final int h() {
            if (this.f7700b.eglSwapBuffers(this.f7701c, this.f7702d)) {
                return 12288;
            }
            return this.f7700b.eglGetError();
        }

        public final void j() {
            if (this.f7704f != null) {
                y yVar = this.f7699a.get();
                if (yVar != null) {
                    yVar.f7682f.destroyContext(this.f7700b, this.f7701c, this.f7704f);
                }
                this.f7704f = null;
            }
            EGLDisplay eGLDisplay = this.f7701c;
            if (eGLDisplay != null) {
                this.f7700b.eglTerminate(eGLDisplay);
                this.f7701c = null;
            }
        }

        public h(WeakReference<y> weakReference) {
            this.f7699a = weakReference;
        }

        public static void c(String str, int i6) {
            throw new RuntimeException(e(str, i6));
        }

        public static void d(String str, String str2, int i6) {
            e(str2, i6);
        }

        public final void a() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f7700b = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f7701c = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.f7700b.eglInitialize(eglGetDisplay, new int[2])) {
                    y yVar = this.f7699a.get();
                    if (yVar == null) {
                        this.f7703e = null;
                        this.f7704f = null;
                    } else {
                        this.f7703e = yVar.f7681e.chooseConfig(this.f7700b, this.f7701c);
                        this.f7704f = yVar.f7682f.createContext(this.f7700b, this.f7701c, this.f7703e);
                    }
                    EGLContext eGLContext = this.f7704f;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.f7704f = null;
                        b("createContext");
                    }
                    this.f7702d = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public final void i() {
            k();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class i extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private boolean f7705a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f7706b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f7707c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7708d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f7709e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f7710f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f7711g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f7712h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f7713i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f7714j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f7715k;

        /* renamed from: p, reason: collision with root package name */
        private boolean f7720p;

        /* renamed from: s, reason: collision with root package name */
        private h f7723s;

        /* renamed from: t, reason: collision with root package name */
        private WeakReference<y> f7724t;

        /* renamed from: q, reason: collision with root package name */
        private ArrayList<Runnable> f7721q = new ArrayList<>();

        /* renamed from: r, reason: collision with root package name */
        private boolean f7722r = true;

        /* renamed from: l, reason: collision with root package name */
        private int f7716l = 0;

        /* renamed from: m, reason: collision with root package name */
        private int f7717m = 0;

        /* renamed from: o, reason: collision with root package name */
        private boolean f7719o = true;

        /* renamed from: n, reason: collision with root package name */
        private int f7718n = 1;

        static /* synthetic */ boolean e(i iVar) {
            iVar.f7706b = true;
            return true;
        }

        public final void l() {
            this.f7715k = true;
            y.f7676l.notifyAll();
        }

        private void o() {
            if (this.f7713i) {
                this.f7713i = false;
                this.f7723s.i();
            }
        }

        private void p() {
            if (this.f7712h) {
                this.f7723s.j();
                this.f7712h = false;
                y.f7676l.g(this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:174:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void q() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 559
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3l.y.i.q():void");
        }

        private boolean r() {
            return this.f7712h && this.f7713i && s();
        }

        private boolean s() {
            if (this.f7708d || !this.f7709e || this.f7710f || this.f7716l <= 0 || this.f7717m <= 0) {
                return false;
            }
            return this.f7719o || this.f7718n == 1;
        }

        public final void b(int i6) {
            if (i6 < 0 || i6 > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (y.f7676l) {
                this.f7718n = i6;
                y.f7676l.notifyAll();
            }
        }

        public final void d(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (y.f7676l) {
                this.f7721q.add(runnable);
                y.f7676l.notifyAll();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            setName("GLThread " + getId());
            try {
                q();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                y.f7676l.a(this);
                throw th;
            }
            y.f7676l.a(this);
        }

        i(WeakReference<y> weakReference) {
            this.f7724t = weakReference;
        }

        public final int a() {
            int i6;
            synchronized (y.f7676l) {
                i6 = this.f7718n;
            }
            return i6;
        }

        public final void c(int i6, int i7) {
            synchronized (y.f7676l) {
                this.f7716l = i6;
                this.f7717m = i7;
                this.f7722r = true;
                this.f7719o = true;
                this.f7720p = false;
                y.f7676l.notifyAll();
                while (!this.f7706b && !this.f7708d && !this.f7720p && r()) {
                    try {
                        y.f7676l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void f() {
            synchronized (y.f7676l) {
                this.f7719o = true;
                y.f7676l.notifyAll();
            }
        }

        public final void g() {
            synchronized (y.f7676l) {
                this.f7709e = true;
                this.f7714j = false;
                y.f7676l.notifyAll();
                while (this.f7711g && !this.f7714j && !this.f7706b) {
                    try {
                        y.f7676l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void h() {
            synchronized (y.f7676l) {
                try {
                    this.f7709e = false;
                    y.f7676l.notifyAll();
                    while (!this.f7711g && !this.f7706b) {
                        try {
                            if (MapsInitializer.getTextureViewDestorySync()) {
                                y.f7676l.wait();
                            } else {
                                y.f7676l.wait(2000L);
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void i() {
            synchronized (y.f7676l) {
                try {
                    this.f7707c = true;
                    y.f7676l.notifyAll();
                    while (!this.f7706b && !this.f7708d) {
                        try {
                            if (MapsInitializer.getTextureViewDestorySync()) {
                                y.f7676l.wait();
                            } else {
                                y.f7676l.wait(2000L);
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void j() {
            synchronized (y.f7676l) {
                this.f7707c = false;
                this.f7719o = true;
                this.f7720p = false;
                y.f7676l.notifyAll();
                while (!this.f7706b && this.f7708d && !this.f7720p) {
                    try {
                        y.f7676l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void k() {
            synchronized (y.f7676l) {
                this.f7705a = true;
                y.f7676l.notifyAll();
                while (!this.f7706b) {
                    try {
                        y.f7676l.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final int m() {
            int i6;
            synchronized (y.f7676l) {
                i6 = this.f7716l;
            }
            return i6;
        }

        public final int n() {
            int i6;
            synchronized (y.f7676l) {
                i6 = this.f7717m;
            }
            return i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class j {

        /* renamed from: g, reason: collision with root package name */
        private static String f7725g = "GLThreadManager";

        /* renamed from: a, reason: collision with root package name */
        private boolean f7726a;

        /* renamed from: b, reason: collision with root package name */
        private int f7727b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f7728c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7729d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f7730e;

        /* renamed from: f, reason: collision with root package name */
        private i f7731f;

        private j() {
        }

        public final synchronized void a(i iVar) {
            try {
                i.e(iVar);
                if (this.f7731f == iVar) {
                    this.f7731f = null;
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized void b(GL10 gl10) {
            try {
                if (!this.f7728c && gl10 != null) {
                    f();
                    String glGetString = gl10.glGetString(7937);
                    if (this.f7727b < 131072) {
                        this.f7729d = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.f7730e = !this.f7729d;
                    this.f7728c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized boolean c() {
            return this.f7730e;
        }

        public final synchronized boolean d() {
            f();
            return !this.f7729d;
        }

        /* synthetic */ j(byte b6) {
            this();
        }

        private void f() {
            if (this.f7726a) {
                return;
            }
            this.f7727b = 131072;
            this.f7729d = true;
            this.f7726a = true;
        }

        public final boolean e(i iVar) {
            i iVar2 = this.f7731f;
            if (iVar2 == iVar || iVar2 == null) {
                this.f7731f = iVar;
                notifyAll();
                return true;
            }
            f();
            if (this.f7729d) {
                return true;
            }
            i iVar3 = this.f7731f;
            if (iVar3 == null) {
                return false;
            }
            iVar3.l();
            return false;
        }

        public final void g(i iVar) {
            if (this.f7731f == iVar) {
                this.f7731f = null;
            }
            notifyAll();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface k {
        GL a();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class l extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private StringBuilder f7732a = new StringBuilder();

        @Override // java.io.Writer
        public final void write(char[] cArr, int i6, int i7) {
            for (int i8 = 0; i8 < i7; i8++) {
                char c6 = cArr[i6 + i8];
                if (c6 == '\n') {
                    a();
                } else {
                    this.f7732a.append(c6);
                }
            }
        }

        private void a() {
            if (this.f7732a.length() > 0) {
                this.f7732a.toString();
                StringBuilder sb = this.f7732a;
                sb.delete(0, sb.length());
            }
        }

        l() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            a();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class m extends b {
        public m() {
            super();
        }
    }

    public y(Context context) {
        super(context, null);
        this.f7677a = new WeakReference<>(this);
        b();
    }

    private void l() {
        if (this.f7678b != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static boolean n() {
        return Build.VERSION.SDK_INT < 23;
    }

    public void f() {
        this.f7678b.i();
    }

    protected void finalize() throws Throwable {
        try {
            i iVar = this.f7678b;
            if (iVar != null) {
                iVar.k();
            }
        } finally {
            super.finalize();
        }
    }

    public int getRenderMode() {
        return this.f7678b.a();
    }

    public void h() {
        this.f7678b.j();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        i iVar = this.f7678b;
        if (iVar != null) {
            iVar.k();
        }
        this.f7680d = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
        this.f7678b.g();
        if (n() || MapsInitializer.getTextureSizeChangedInvoked()) {
            onSurfaceTextureSizeChanged(surfaceTexture, i6, i7);
        } else {
            if (this.f7678b.m() == i6 && this.f7678b.n() == i7) {
                return;
            }
            onSurfaceTextureSizeChanged(surfaceTexture, i6, i7);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f7678b.h();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
        this.f7678b.c(i6, i7);
    }

    public void queueEvent(Runnable runnable) {
        this.f7678b.d(runnable);
    }

    public void requestRender() {
        this.f7678b.f();
    }

    public void setRenderMode(int i6) {
        this.f7678b.b(i6);
    }

    private void b() {
        setSurfaceTextureListener(this);
    }

    public final void c(e eVar) {
        l();
        this.f7681e = eVar;
    }

    public final void d(f fVar) {
        l();
        this.f7682f = fVar;
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        int i6;
        super.onAttachedToWindow();
        if (this.f7680d && this.f7679c != null) {
            i iVar = this.f7678b;
            if (iVar != null) {
                i6 = iVar.a();
            } else {
                i6 = 1;
            }
            i iVar2 = new i(this.f7677a);
            this.f7678b = iVar2;
            if (i6 != 1) {
                iVar2.b(i6);
            }
            this.f7678b.start();
        }
        this.f7680d = false;
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i8 - i6, i9 - i7);
        super.onLayout(z5, i6, i7, i8, i9);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        l();
        if (this.f7681e == null) {
            this.f7681e = new m();
        }
        byte b6 = 0;
        if (this.f7682f == null) {
            this.f7682f = new c(this, b6);
        }
        if (this.f7683g == null) {
            this.f7683g = new d(b6);
        }
        this.f7679c = renderer;
        i iVar = new i(this.f7677a);
        this.f7678b = iVar;
        iVar.start();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
