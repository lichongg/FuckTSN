package cn.easyar.engine.recorder;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLException;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bxkj.base.v2.common.utils.g0;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(17)
/* loaded from: D:\Downloads\app\classes2.dex */
public class TextureMovieEncoder implements Runnable {
    private static final int MSG_FRAME_AVAILABLE = 2;
    private static final int MSG_STOP_RECORDING = 1;
    private static final String TAG = "easyar.TextureEncoder";
    private static final boolean VERBOSE = false;
    private RecordNative aNative;
    private AVRecorderConfig config;
    private DeviceType mDeviceType;
    private volatile EncoderHandler mHandler;
    private VideoEncoderCore mVideoEncoder;
    Runnable run;
    Handler vHandler;
    private Object mReadyFence = new Object();
    private volatile boolean mReady = false;
    private int[] texWaterMark = {0};
    private int[] mSurfaceWidth = {0};
    private int[] mSurfaceHeight = {0};
    private int number = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum DeviceType {
        Default,
        Sony_Z1,
        HUAWEI_P7,
        IPH,
        UnKnown
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class EncoderHandler extends Handler {
        private WeakReference<TextureMovieEncoder> mWeakEncoder;

        @Override // android.os.Handler
        public void handleMessage(Message inputMessage) {
            int i6 = inputMessage.what;
            TextureMovieEncoder textureMovieEncoder = this.mWeakEncoder.get();
            if (textureMovieEncoder == null) {
                return;
            }
            if (i6 == 1) {
                textureMovieEncoder.handleStopRecording();
                Looper.myLooper().quit();
            } else {
                if (i6 == 2) {
                    textureMovieEncoder.handleFrameAvailable();
                    return;
                }
                throw new RuntimeException("Unhandled msg what=" + i6);
            }
        }

        public EncoderHandler(TextureMovieEncoder encoder) {
            this.mWeakEncoder = new WeakReference<>(encoder);
        }
    }

    public void updateRecording(int aTexName) {
        long nanoTime = System.nanoTime();
        frameAvailableSoon();
        try {
            GLES20.glFinish();
            this.aNative.updateRecord(aTexName, nanoTime);
        } catch (Exception unused) {
        }
    }

    private Bitmap createBitmapFromGLSurface(int x5, int y5, int w5, int h6) {
        int i6 = w5 * h6;
        int[] iArr = new int[i6];
        int[] iArr2 = new int[i6];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        try {
            GLES20.glReadPixels(x5, y5, w5, h6, 6408, 5121, wrap);
            for (int i7 = 0; i7 < h6; i7++) {
                int i8 = i7 * w5;
                int i9 = ((h6 - i7) - 1) * w5;
                for (int i10 = 0; i10 < w5; i10++) {
                    int i11 = iArr[i8 + i10];
                    iArr2[i9 + i10] = (i11 & (-16711936)) | ((i11 << 16) & 16711680) | ((i11 >> 16) & 255);
                }
            }
            return Bitmap.createBitmap(iArr2, w5, h6, Bitmap.Config.ARGB_8888);
        } catch (GLException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFrameAvailable() {
        this.mVideoEncoder.drainEncoder(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        this.mVideoEncoder.drainEncoder(true);
        synchronized (this.mReadyFence) {
            this.mReady = false;
            this.mReadyFence.notify();
        }
    }

    private void saveBitmap(Bitmap bitmap) {
        File file = new File("/sdcard/easyar3d/video/", "" + this.number + g0.f16898c);
        try {
            file.createNewFile();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArray);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }

    public void frameAvailableSoon() {
        synchronized (this.mReadyFence) {
            try {
                if (this.mReady) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setDeviceType() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.toLowerCase().equals("c6602")) {
            this.mDeviceType = DeviceType.Sony_Z1;
            return;
        }
        if (str2.toLowerCase().equals("HUAWEI P7-L07")) {
            this.mDeviceType = DeviceType.HUAWEI_P7;
        } else if (str2.toLowerCase().equals("iph")) {
            this.mDeviceType = DeviceType.IPH;
        } else {
            this.mDeviceType = DeviceType.Default;
        }
    }

    public void startRecording() {
        synchronized (this.mReadyFence) {
            new Thread(this, "TextureMovieEncoder").start();
            while (!this.mReady) {
                try {
                    this.mReadyFence.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public void stopRecording(Handler viewHandler, Runnable r5) {
        Assert(this.mReady, "stopRecording: mReady");
        this.vHandler = viewHandler;
        this.run = r5;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        synchronized (this.mReadyFence) {
            while (this.mReady) {
                try {
                    this.mReadyFence.wait();
                } catch (InterruptedException e6) {
                    e6.printStackTrace();
                }
            }
        }
        this.aNative.release();
        VideoEncoderCore videoEncoderCore = this.mVideoEncoder;
        if (videoEncoderCore != null) {
            videoEncoderCore.release();
            this.mVideoEncoder = null;
        }
        this.vHandler = null;
    }

    public TextureMovieEncoder(AVRecorderConfig mAVRecorderConfig) throws RuntimeException {
        int width;
        int height;
        this.config = mAVRecorderConfig;
        try {
            if (mAVRecorderConfig.getRotationClip()) {
                height = mAVRecorderConfig.getWidth();
                width = mAVRecorderConfig.getHeight();
            } else {
                width = mAVRecorderConfig.getWidth();
                height = mAVRecorderConfig.getHeight();
            }
            VideoEncoderCore videoEncoderCore = new VideoEncoderCore(width, height, mAVRecorderConfig.getVideoBitRate(), mAVRecorderConfig.getMuxer());
            this.mVideoEncoder = videoEncoderCore;
            try {
                this.aNative = new RecordNative(videoEncoderCore.getInputSurface(), this.config.getTextureWidth(), this.config.getTextureHeight(), this.config.getZoomMode());
            } catch (Exception unused) {
                this.mVideoEncoder.release();
                throw new RuntimeException("ReccordNative init failed");
            }
        } catch (IOException e6) {
            throw new RuntimeException(e6);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Looper.prepare();
        synchronized (this.mReadyFence) {
            this.mHandler = new EncoderHandler(this);
            this.mReady = true;
            this.mReadyFence.notify();
        }
        Looper.loop();
        synchronized (this.mReadyFence) {
            this.mHandler = null;
        }
    }

    public void updateRecording(int aTexName, int texWidth, int texHeight) {
        long nanoTime = System.nanoTime();
        frameAvailableSoon();
        this.aNative.nativeWidth();
        this.aNative.nativeHeight();
        int i6 = this.number + 1;
        this.number = i6;
        if (i6 < 0) {
            Bitmap createBitmapFromGLSurface = createBitmapFromGLSurface(0, 0, PredefinedCaptureConfigurations.f35648o, PredefinedCaptureConfigurations.f35647n);
            saveBitmap(createBitmapFromGLSurface);
            createBitmapFromGLSurface.recycle();
        }
        this.number++;
        try {
            GLES20.glFinish();
            this.aNative.updateRecord(aTexName, texWidth, texHeight, nanoTime);
            if (this.number < 0) {
                Bitmap createBitmapFromGLSurface2 = createBitmapFromGLSurface(0, 0, PredefinedCaptureConfigurations.f35648o, PredefinedCaptureConfigurations.f35647n);
                saveBitmap(createBitmapFromGLSurface2);
                createBitmapFromGLSurface2.recycle();
            }
        } catch (Exception unused) {
        }
    }

    private void Assert(boolean judge, String st) {
    }
}
