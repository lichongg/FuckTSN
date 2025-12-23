package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;

@JNINamespace("PLAYER")
/* loaded from: D:\Downloads\app\classes3.dex */
public class NativeLoadControl extends LoadControl {
    @CalledByNative
    private static boolean isNativeLoadControl(LoadControl loadControl) {
        return loadControl instanceof NativeLoadControl;
    }

    @Override // com.bykv.vk.component.ttvideo.player.LoadControl
    protected int onCodecStackSelected(int i6) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.LoadControl
    protected int onFilterStackSelected(int i6) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.LoadControl
    protected int onTrackSelected(int i6) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.LoadControl
    protected boolean shouldStartPlayback(long j6, float f6, boolean z5) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
