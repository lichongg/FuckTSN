package com.bykv.vk.component.ttvideo.player;

@JNINamespace("PLAYER")
/* loaded from: D:\Downloads\app\classes3.dex */
public class NativeObject {
    protected long mNativeObj = 0;

    private native void nativeRelease(long j6);

    public synchronized void release() {
        long j6 = this.mNativeObj;
        if (j6 != 0) {
            nativeRelease(j6);
            this.mNativeObj = 0L;
        }
    }

    @CalledByNative
    private long getNativeObj() {
        return this.mNativeObj;
    }

    protected void setNativeObj(long j6) {
        this.mNativeObj = j6;
    }

    protected void finalize() throws Throwable {
    }
}
