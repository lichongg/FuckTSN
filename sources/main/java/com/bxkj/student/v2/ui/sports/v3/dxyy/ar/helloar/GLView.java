package com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.opengl.GLSurfaceView;
import android.view.WindowManager;
import cn.easyar.Engine;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class GLView extends GLSurfaceView {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Object f21728a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f21729b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f21730c;

    /* renamed from: d, reason: collision with root package name */
    private int f21731d;

    /* renamed from: e, reason: collision with root package name */
    private int f21732e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar.c f21733f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements GLSurfaceView.Renderer {
        a() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl) {
            g0.p(gl, "gl");
            if (GLView.this.f21730c) {
                com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar.c cVar = GLView.this.f21733f;
                g0.m(cVar);
                cVar.g(GLView.this.f21731d, GLView.this.f21732e, GLView.this.a());
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl, int i6, int i7) {
            g0.p(gl, "gl");
            GLView.this.f21731d = i6;
            GLView.this.f21732e = i7;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            g0.p(gl, "gl");
            g0.p(config, "config");
            if (GLView.this.f21730c) {
                com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar.c cVar = GLView.this.f21733f;
                g0.m(cVar);
                cVar.f();
            } else {
                GLView.this.f21730c = true;
                GLView.this.f21733f = new com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar.c();
                com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar.c cVar2 = GLView.this.f21733f;
                g0.m(cVar2);
                cVar2.c();
            }
            com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar.c cVar3 = GLView.this.f21733f;
            g0.m(cVar3);
            cVar3.h();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements GLSurfaceView.EGLConfigChooser {
        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        @NotNull
        public EGLConfig chooseConfig(@NotNull EGL10 egl, @NotNull EGLDisplay display) {
            g0.p(egl, "egl");
            g0.p(display, "display");
            int[] iArr = {12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344};
            int[] iArr2 = new int[1];
            egl.eglChooseConfig(display, iArr, null, 0, iArr2);
            int i6 = iArr2[0];
            if (i6 <= 0) {
                throw new IllegalArgumentException("fail to choose EGL configs");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i6];
            egl.eglChooseConfig(display, iArr, eGLConfigArr, i6, iArr2);
            for (int i7 = 0; i7 < i6; i7++) {
                EGLConfig eGLConfig = eGLConfigArr[i7];
                int[] iArr3 = new int[1];
                if ((egl.eglGetConfigAttrib(display, eGLConfig, 12325, iArr3) ? iArr3[0] : 0) >= 16) {
                    int i8 = egl.eglGetConfigAttrib(display, eGLConfig, 12324, iArr3) ? iArr3[0] : 0;
                    int i9 = egl.eglGetConfigAttrib(display, eGLConfig, 12323, iArr3) ? iArr3[0] : 0;
                    int i10 = egl.eglGetConfigAttrib(display, eGLConfig, 12322, iArr3) ? iArr3[0] : 0;
                    int i11 = egl.eglGetConfigAttrib(display, eGLConfig, 12321, iArr3) ? iArr3[0] : 0;
                    if (i8 == 8 && i9 == 8 && i10 == 8 && i11 == 0) {
                        g0.m(eGLConfig);
                        return eGLConfig;
                    }
                }
            }
            EGLConfig eGLConfig2 = eGLConfigArr[0];
            g0.m(eGLConfig2);
            return eGLConfig2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c implements GLSurfaceView.EGLContextFactory {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f21735a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final int f21736b = 12440;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a {
            public /* synthetic */ a(v vVar) {
                this();
            }

            private a() {
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        @NotNull
        public EGLContext createContext(@NotNull EGL10 egl, @NotNull EGLDisplay display, @NotNull EGLConfig eglConfig) {
            g0.p(egl, "egl");
            g0.p(display, "display");
            g0.p(eglConfig, "eglConfig");
            EGLContext eglCreateContext = egl.eglCreateContext(display, eglConfig, EGL10.EGL_NO_CONTEXT, new int[]{f21736b, 3, 12344});
            g0.o(eglCreateContext, "eglCreateContext(...)");
            return eglCreateContext;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(@NotNull EGL10 egl, @NotNull EGLDisplay display, @NotNull EGLContext context) {
            g0.p(egl, "egl");
            g0.p(display, "display");
            g0.p(context, "context");
            egl.eglDestroyContext(display, context);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class d implements GLSurfaceView.EGLWindowSurfaceFactory {
        public d() {
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        @Nullable
        public EGLSurface createWindowSurface(@NotNull EGL10 egl, @NotNull EGLDisplay display, @NotNull EGLConfig config, @NotNull Object nativeWindow) {
            g0.p(egl, "egl");
            g0.p(display, "display");
            g0.p(config, "config");
            g0.p(nativeWindow, "nativeWindow");
            try {
                return egl.eglCreateWindowSurface(display, config, nativeWindow, null);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public void destroySurface(@NotNull EGL10 egl, @NotNull EGLDisplay display, @NotNull EGLSurface surface) {
            g0.p(egl, "egl");
            g0.p(display, "display");
            g0.p(surface, "surface");
            GLView.this.l();
            egl.eglDestroySurface(display, surface);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GLView(@NotNull Context context) {
        super(context);
        g0.p(context, "context");
        this.f21728a = new Object();
        this.f21731d = 1;
        this.f21732e = 1;
        setEGLContextFactory(new c());
        setEGLWindowSurfaceFactory(new d());
        setEGLConfigChooser(new b());
        setRenderer(new a());
        setZOrderMediaOverlay(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        boolean z5;
        synchronized (this.f21728a) {
            z5 = this.f21729b;
            n1 n1Var = n1.f44123a;
        }
        if (this.f21730c && z5) {
            this.f21730c = false;
            com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar.c cVar = this.f21733f;
            g0.m(cVar);
            cVar.i();
            com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar.c cVar2 = this.f21733f;
            g0.m(cVar2);
            cVar2.b();
            this.f21733f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int a() {
        Object systemService = getContext().getSystemService("window");
        g0.n(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        int rotation = ((WindowManager) systemService).getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return 0;
        }
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    return 0;
                }
                return 270;
            }
            return 180;
        }
        return 90;
    }

    private final Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        Activity activity = getActivity();
        if (activity != null) {
            boolean isFinishing = activity.isFinishing();
            synchronized (this.f21728a) {
                this.f21729b = isFinishing;
                n1 n1Var = n1.f44123a;
            }
        }
        Engine.onPause();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        Engine.onResume();
    }
}
