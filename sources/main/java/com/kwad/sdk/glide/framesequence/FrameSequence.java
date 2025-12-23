package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FrameSequence implements Serializable {
    private static final AtomicBoolean ISLOADED;
    private int mDefaultLoopCount;
    private int mFrameCount;
    private int mHeight;
    private long mNativeFrameSequence;
    private boolean mOpaque;
    private int mWidth;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class State implements Serializable {
        private long mNativeState;

        public void destroy() {
            long j6 = this.mNativeState;
            if (j6 != 0) {
                FrameSequence.nativeDestroyState(j6);
                this.mNativeState = 0L;
            }
        }

        public long getFrame(int i6, Bitmap bitmap, int i7) {
            if (bitmap == null || bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                throw new IllegalArgumentException("Bitmap passed must be non-null and ARGB_8888");
            }
            long j6 = this.mNativeState;
            if (j6 != 0) {
                return FrameSequence.nativeGetFrame(j6, i6, bitmap, i7);
            }
            throw new IllegalStateException("attempted to draw destroyed FrameSequenceState");
        }

        public State(long j6) {
            this.mNativeState = j6;
        }
    }

    public FrameSequence() {
    }

    @Nullable
    public static FrameSequence decodeByteArray(byte[] bArr) {
        if (ISLOADED.get()) {
            return decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    private static native long nativeCreateState(long j6);

    private static native FrameSequence nativeDecodeByteArray(byte[] bArr, int i6, int i7);

    private static native FrameSequence nativeDecodeByteBuffer(ByteBuffer byteBuffer, int i6, int i7);

    private static native FrameSequence nativeDecodeStream(InputStream inputStream, byte[] bArr);

    private static native void nativeDestroyFrameSequence(long j6);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDestroyState(long j6);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeGetFrame(long j6, int i6, Bitmap bitmap, int i7);

    static {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ISLOADED = atomicBoolean;
        try {
            System.loadLibrary("framesequencev2");
            atomicBoolean.set(true);
        } catch (Throwable unused) {
            ISLOADED.set(false);
        }
    }

    private FrameSequence(long j6, int i6, int i7, boolean z5, int i8, int i9) {
        this.mNativeFrameSequence = j6;
        this.mWidth = i6;
        this.mHeight = i7;
        this.mOpaque = z5;
        this.mFrameCount = i8;
        this.mDefaultLoopCount = i9;
    }

    @Nullable
    public static FrameSequence decodeByteBuffer(ByteBuffer byteBuffer) {
        if (!ISLOADED.get()) {
            return null;
        }
        if (byteBuffer == null) {
            throw new IllegalArgumentException();
        }
        if (byteBuffer.isDirect()) {
            return nativeDecodeByteBuffer(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
        }
        if (byteBuffer.hasArray()) {
            return decodeByteArray(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
        }
        throw new IllegalArgumentException("Cannot have non-direct ByteBuffer with no byte array");
    }

    @Nullable
    public static FrameSequence decodeStream(InputStream inputStream) {
        if (!ISLOADED.get()) {
            return null;
        }
        if (inputStream != null) {
            return nativeDecodeStream(inputStream, new byte[16384]);
        }
        throw new IllegalArgumentException();
    }

    public static boolean isEnable() {
        return ISLOADED.get();
    }

    State createState() {
        long j6 = this.mNativeFrameSequence;
        if (j6 == 0) {
            throw new IllegalStateException("attempted to use incorrectly built FrameSequence");
        }
        long nativeCreateState = nativeCreateState(j6);
        if (nativeCreateState == 0) {
            return null;
        }
        return new State(nativeCreateState);
    }

    public void destroy() {
        long j6 = this.mNativeFrameSequence;
        if (j6 != 0) {
            nativeDestroyFrameSequence(j6);
        }
    }

    public int getDefaultLoopCount() {
        return this.mDefaultLoopCount;
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isOpaque() {
        return this.mOpaque;
    }

    @Nullable
    public static FrameSequence decodeByteArray(byte[] bArr, int i6, int i7) {
        if (!ISLOADED.get()) {
            return null;
        }
        if (bArr != null) {
            if (i6 >= 0 && i7 >= 0 && i6 + i7 <= bArr.length) {
                return nativeDecodeByteArray(bArr, i6, i7);
            }
            throw new IllegalArgumentException("invalid offset/length parameters");
        }
        throw new IllegalArgumentException();
    }
}
