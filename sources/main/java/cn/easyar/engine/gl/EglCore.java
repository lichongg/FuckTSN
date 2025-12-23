package cn.easyar.engine.gl;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(18)
/* loaded from: D:\Downloads\app\classes2.dex */
public final class EglCore {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;
    private static final String TAG = "easyar.GlUtil";
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private int mGlVersion;

    public EglCore() {
        this(null, 0);
    }

    private EGLConfig getConfig(int flags, int version) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, version >= 3 ? 68 : 4, 12344, 0, 12344};
        if ((flags & 1) != 0) {
            iArr[10] = EGL_RECORDABLE_ANDROID;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.mEGLDisplay, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        return null;
    }

    public void makeCurrent(EGLSurface eglSurface) {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eglSurface, eglSurface, this.mEGLContext)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public int querySurface(EGLSurface eglSurface, int what) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEGLDisplay, eglSurface, what, iArr, 0);
        return iArr[0];
    }

    public EglCore(EGLContext sharedContext, int flags) {
        EGLConfig config;
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLDisplay = eGLDisplay;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        this.mGlVersion = -1;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        sharedContext = sharedContext == null ? EGL14.EGL_NO_CONTEXT : sharedContext;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.mEGLDisplay = eglGetDisplay;
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            this.mEGLDisplay = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        if ((flags & 2) != 0 && (config = getConfig(flags, 3)) != null) {
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEGLDisplay, config, sharedContext, new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() == 12288) {
                this.mEGLConfig = config;
                this.mEGLContext = eglCreateContext;
                this.mGlVersion = 3;
            }
        }
        if (this.mEGLContext == EGL14.EGL_NO_CONTEXT) {
            EGLConfig config2 = getConfig(flags, 2);
            if (config2 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.mEGLDisplay, config2, sharedContext, new int[]{12440, 2, 12344}, 0);
            checkEglError("eglCreateContext");
            this.mEGLConfig = config2;
            this.mEGLContext = eglCreateContext2;
            this.mGlVersion = 2;
        }
        EGL14.eglQueryContext(this.mEGLDisplay, this.mEGLContext, 12440, new int[1], 0);
    }

    public EGLSurface createOffscreenSurface(int width, int height) {
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, width, 12374, height, 12344}, 0);
        checkEglError("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public EGLSurface createWindowSurface(Object surface) {
        if (!(surface instanceof Surface) && !(surface instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + surface);
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, surface, new int[]{12344}, 0);
        checkEglError("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
                release();
            }
        } finally {
            super.finalize();
        }
    }

    public int getGlVersion() {
        return this.mGlVersion;
    }

    public boolean isCurrent(EGLSurface eglSurface) {
        return this.mEGLContext.equals(EGL14.eglGetCurrentContext()) && eglSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    public void makeNothingCurrent() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public String queryString(int what) {
        return EGL14.eglQueryString(this.mEGLDisplay, what);
    }

    public void release() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
    }

    public void releaseSurface(EGLSurface eglSurface) {
        EGL14.eglDestroySurface(this.mEGLDisplay, eglSurface);
    }

    public void setPresentationTime(EGLSurface eglSurface, long nsecs) {
        EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, eglSurface, nsecs);
    }

    public boolean swapBuffers(EGLSurface eglSurface) {
        return EGL14.eglSwapBuffers(this.mEGLDisplay, eglSurface);
    }

    private void checkEglError(String msg) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(msg + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    public static EGLSurface getCurrentSurface(int read_write) {
        return EGL14.eglGetCurrentSurface(read_write);
    }

    public static void logCurrent(String msg) {
        EGLDisplay eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay();
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        EGLSurface eglGetCurrentSurface = EGL14.eglGetCurrentSurface(12377);
        Objects.toString(eglGetCurrentDisplay);
        Objects.toString(eglGetCurrentContext);
        Objects.toString(eglGetCurrentSurface);
    }

    public void makeCurrent(EGLSurface drawSurface, EGLSurface readSurface) {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
        if (!EGL14.eglMakeCurrent(eGLDisplay, drawSurface, readSurface, this.mEGLContext)) {
            throw new RuntimeException("eglMakeCurrent(draw,read) failed");
        }
    }

    public EglCore(EGLDisplay display, EGLSurface surface, int flags) {
        EGLConfig config;
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        this.mGlVersion = -1;
        this.mEGLDisplay = display;
        if ((flags & 2) != 0 && (config = getConfig(flags, 3)) != null) {
            EGLContext eglCreateContext = EGL14.eglCreateContext(display, config, EGL14.EGL_NO_CONTEXT, new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() == 12288) {
                this.mEGLConfig = config;
                this.mEGLContext = eglCreateContext;
                this.mGlVersion = 3;
            }
        }
        if (this.mEGLContext == EGL14.EGL_NO_CONTEXT) {
            EGLConfig config2 = getConfig(flags, 2);
            if (config2 != null) {
                this.mEGLContext = EGL14.eglGetCurrentContext();
                checkEglError("eglCreateContext");
                this.mEGLConfig = config2;
                this.mGlVersion = 2;
                return;
            }
            throw new RuntimeException("Unable to find a suitable EGLConfig");
        }
    }
}
