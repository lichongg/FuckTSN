package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;

@JNINamespace("PLAYER")
/* loaded from: D:\Downloads\app\classes3.dex */
public class NativeSubInfo extends SubInfo {
    @CalledByNative
    private static boolean isNativeSubInfo(SubInfo subInfo) {
        return subInfo instanceof NativeSubInfo;
    }

    @Override // com.bykv.vk.component.ttvideo.player.SubInfo
    protected void onSubInfoCallback(int i6, int i7, String str) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.SubInfo
    protected void onSubInfoCallback2(int i6, String str) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.SubInfo
    protected void onSubLoadFinished(int i6) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.SubInfo
    protected void onSubSwitchCompleted(int i6, int i7) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
