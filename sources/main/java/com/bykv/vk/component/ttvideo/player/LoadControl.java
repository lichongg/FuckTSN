package com.bykv.vk.component.ttvideo.player;

@JNINamespace("PLAYER")
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class LoadControl extends NativeObject {
    @CalledByNative
    protected abstract int onCodecStackSelected(int i6);

    @CalledByNative
    protected abstract int onFilterStackSelected(int i6);

    @CalledByNative
    protected abstract int onTrackSelected(int i6);

    @CalledByNative
    protected abstract boolean shouldStartPlayback(long j6, float f6, boolean z5);
}
