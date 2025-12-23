package com.amap.api.col.p0003l;

import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class o2 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends m2 {

        /* renamed from: h, reason: collision with root package name */
        private static int f6818h = 4;

        /* renamed from: a, reason: collision with root package name */
        protected int f6819a;

        /* renamed from: b, reason: collision with root package name */
        protected int f6820b;

        /* renamed from: c, reason: collision with root package name */
        protected int f6821c;

        /* renamed from: g, reason: collision with root package name */
        private int[] f6825g = new int[1];

        /* renamed from: d, reason: collision with root package name */
        protected int f6822d = 0;

        /* renamed from: e, reason: collision with root package name */
        protected int f6823e = 16;

        /* renamed from: f, reason: collision with root package name */
        protected int f6824f = 8;

        private EGLConfig c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a6 = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a7 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a6 >= this.f6823e && a7 >= this.f6824f) {
                    int a8 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a9 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a10 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a11 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a8 == this.f6819a && a9 == this.f6820b && a10 == this.f6821c && a11 == this.f6822d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i6) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i6, this.f6825g)) {
                return this.f6825g[0];
            }
            return 0;
        }

        private c b(EGL10 egl10, EGLDisplay eGLDisplay) {
            c cVar = new c((byte) 0);
            int[] d6 = d(true);
            cVar.f6826a = d6;
            egl10.eglChooseConfig(eGLDisplay, d6, null, 0, cVar.f6827b);
            if (cVar.f6827b[0] > 0) {
                return cVar;
            }
            int[] d7 = d(false);
            cVar.f6826a = d7;
            egl10.eglChooseConfig(eGLDisplay, d7, null, 0, cVar.f6827b);
            if (cVar.f6827b[0] <= 0) {
                return null;
            }
            return cVar;
        }

        private int[] d(boolean z5) {
            return new int[]{12324, this.f6819a, 12323, this.f6820b, 12322, this.f6821c, 12321, this.f6822d, 12325, this.f6823e, 12326, this.f6824f, 12338, z5 ? 1 : 0, 12352, f6818h, 12344};
        }

        public a(int i6, int i7, int i8) {
            this.f6819a = i6;
            this.f6820b = i7;
            this.f6821c = i8;
        }

        @Override // com.amap.api.col.p0003l.m2, android.opengl.GLSurfaceView.EGLConfigChooser, com.amap.api.col.3l.y.e
        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr;
            int[] iArr2;
            c b6 = b(egl10, eGLDisplay);
            if (b6 != null && (iArr = b6.f6826a) != null) {
                int[] iArr3 = b6.f6827b;
                int i6 = iArr3[0];
                EGLConfig[] eGLConfigArr = new EGLConfig[i6];
                egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i6, iArr3);
                EGLConfig c6 = c(egl10, eGLDisplay, eGLConfigArr);
                if (c6 == null) {
                    this.f6819a = 8;
                    this.f6820b = 8;
                    this.f6821c = 8;
                    c b7 = b(egl10, eGLDisplay);
                    if (b7 != null && (iArr2 = b7.f6826a) != null) {
                        int[] iArr4 = b7.f6827b;
                        int i7 = iArr4[0];
                        EGLConfig[] eGLConfigArr2 = new EGLConfig[i7];
                        egl10.eglChooseConfig(eGLDisplay, iArr2, eGLConfigArr2, i7, iArr4);
                        return c(egl10, eGLDisplay, eGLConfigArr2);
                    }
                    return c6;
                }
                return c6;
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b extends n2 {
        @Override // com.amap.api.col.p0003l.n2, android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.col.3l.y.f
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            try {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        @Override // com.amap.api.col.p0003l.n2, android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.col.3l.y.f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    public static void a(IGLSurfaceView iGLSurfaceView, int i6, int i7, int i8) {
        iGLSurfaceView.setEGLContextFactory(new b());
        iGLSurfaceView.setEGLConfigChooser(new a(i6, i7, i8));
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        public int[] f6826a;

        /* renamed from: b, reason: collision with root package name */
        public int[] f6827b;

        private c() {
            this.f6826a = null;
            this.f6827b = new int[1];
        }

        /* synthetic */ c(byte b6) {
            this();
        }
    }
}
