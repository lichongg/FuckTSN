package com.bykv.vk.component.ttvideo.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.bytedance.sdk.component.utils.vl;

@TargetApi(17)
/* loaded from: D:\Downloads\app\classes3.dex */
public final class DummySurface extends Surface {
    private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    private static final String TAG = "DummySurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    public final boolean secure;
    private final DummySurfaceThread thread;
    private boolean threadReleased;

    /* renamed from: com.bykv.vk.component.ttvideo.player.DummySurface$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class DummySurfaceThread extends HandlerThread implements Handler.Callback {
        private static final int MSG_INIT = 1;
        private static final int MSG_RELEASE = 2;
        private EGLSurfaceTexture eglSurfaceTexture;
        private Handler handler;
        private Error initError;
        private RuntimeException initException;
        private DummySurface surface;

        public DummySurfaceThread() {
            super("dummySurface");
        }

        private void initInternal(int i6) {
            this.eglSurfaceTexture.getClass();
            this.eglSurfaceTexture.init(i6);
            this.surface = new DummySurface(this, this.eglSurfaceTexture.getSurfaceTexture(), i6 != 0, null);
        }

        private void releaseInternal() {
            this.eglSurfaceTexture.getClass();
            this.eglSurfaceTexture.release();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i6 = message.what;
            try {
                if (i6 != 1) {
                    if (i6 != 2) {
                        return true;
                    }
                    try {
                        releaseInternal();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    initInternal(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e6) {
                    vl.cw(DummySurface.TAG, "Failed to initialize dummy surface", e6);
                    this.initError = e6;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e7) {
                    vl.cw(DummySurface.TAG, "Failed to initialize dummy surface", e7);
                    this.initException = e7;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }

        public void release() {
            this.handler.getClass();
            this.handler.sendEmptyMessage(2);
        }

        public DummySurface init(int i6) {
            boolean z5;
            start();
            this.handler = new Handler(getLooper(), this);
            this.eglSurfaceTexture = new EGLSurfaceTexture(this.handler);
            synchronized (this) {
                z5 = false;
                this.handler.obtainMessage(1, i6, 0).sendToTarget();
                while (this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z5 = true;
                    }
                }
            }
            if (z5) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.initException;
            if (runtimeException == null) {
                Error error = this.initError;
                if (error == null) {
                    this.surface.getClass();
                    return this.surface;
                }
                throw error;
            }
            throw runtimeException;
        }
    }

    /* synthetic */ DummySurface(DummySurfaceThread dummySurfaceThread, SurfaceTexture surfaceTexture, boolean z5, AnonymousClass1 anonymousClass1) {
        this(dummySurfaceThread, surfaceTexture, z5);
    }

    private DummySurface(DummySurfaceThread dummySurfaceThread, SurfaceTexture surfaceTexture, boolean z5) {
        super(surfaceTexture);
        this.thread = dummySurfaceThread;
        this.secure = z5;
    }

    @TargetApi(24)
    private static int getSecureModeV24(Context context) {
        String eglQueryString;
        if ((Build.VERSION.SDK_INT >= 26 || !("samsung".equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains(EXTENSION_PROTECTED_CONTENT)) {
            return eglQueryString.contains(EXTENSION_SURFACELESS_CONTEXT) ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        int i6;
        synchronized (DummySurface.class) {
            try {
                if (!secureModeInitialized) {
                    secureMode = Build.VERSION.SDK_INT < 24 ? 0 : getSecureModeV24(context);
                    secureModeInitialized = true;
                }
                i6 = secureMode;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i6 != 0;
    }

    public static DummySurface newInstanceV17(boolean z5) {
        int i6;
        assertApiLevel17OrHigher();
        DummySurfaceThread dummySurfaceThread = new DummySurfaceThread();
        if (z5) {
            i6 = secureMode;
        } else {
            i6 = 0;
        }
        return dummySurfaceThread.init(i6);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.thread) {
            try {
                if (!this.threadReleased) {
                    this.thread.release();
                    this.threadReleased = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void assertApiLevel17OrHigher() {
    }
}
