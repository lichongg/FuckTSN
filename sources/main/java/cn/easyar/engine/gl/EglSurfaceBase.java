package cn.easyar.engine.gl;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(18)
/* loaded from: D:\Downloads\app\classes2.dex */
public class EglSurfaceBase {
    protected static final String TAG = "easyar.GlUtil";
    protected EglCore mEglCore;
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    private int mWidth = -1;
    private int mHeight = -1;

    public void makeCurrentReadFrom(EglSurfaceBase readSurface) {
        this.mEglCore.makeCurrent(this.mEGLSurface, readSurface.mEGLSurface);
    }

    public void createOffscreenSurface(int width, int height) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.mEGLSurface = this.mEglCore.createOffscreenSurface(width, height);
        this.mWidth = width;
        this.mHeight = height;
    }

    public void createWindowSurface(Object surface) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.mEGLSurface = this.mEglCore.createWindowSurface(surface);
    }

    public int getHeight() {
        int i6 = this.mHeight;
        return i6 < 0 ? this.mEglCore.querySurface(this.mEGLSurface, 12374) : i6;
    }

    public int getWidth() {
        int i6 = this.mWidth;
        return i6 < 0 ? this.mEglCore.querySurface(this.mEGLSurface, 12375) : i6;
    }

    public void makeCurrent() {
        this.mEglCore.makeCurrent(this.mEGLSurface);
    }

    public void makeCurrentReadFrom(EGLSurface readSurface) {
        this.mEglCore.makeCurrent(this.mEGLSurface, readSurface);
    }

    public void releaseEglSurface() {
        this.mEglCore.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    public void saveFrame(File file) throws IOException {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        if (!this.mEglCore.isCurrent(this.mEGLSurface)) {
            throw new RuntimeException("Expected EGL context/surface is not current");
        }
        String file2 = file.toString();
        int width = getWidth();
        int height = getHeight();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(width * height * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, width, height, 6408, 5121, allocateDirect);
        GlUtil.checkGlError("glReadPixels");
        allocateDirect.rewind();
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(allocateDirect);
            createBitmap.compress(Bitmap.CompressFormat.PNG, 90, bufferedOutputStream);
            createBitmap.recycle();
            bufferedOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 == null) {
                throw th;
            }
            bufferedOutputStream2.close();
            throw th;
        }
    }

    public void setPresentationTime(long nsecs) {
        this.mEglCore.setPresentationTime(this.mEGLSurface, nsecs);
    }

    public boolean swapBuffers() {
        return this.mEglCore.swapBuffers(this.mEGLSurface);
    }

    protected EglSurfaceBase(EglCore eglCore) {
        this.mEglCore = eglCore;
    }
}
