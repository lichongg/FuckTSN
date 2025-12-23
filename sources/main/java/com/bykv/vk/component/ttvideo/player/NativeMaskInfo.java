package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;

@JNINamespace("PLAYER")
/* loaded from: D:\Downloads\app\classes3.dex */
public class NativeMaskInfo extends MaskInfo {
    @CalledByNative
    private static boolean isNativeMaskInfo(MaskInfo maskInfo) {
        return maskInfo instanceof NativeMaskInfo;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MaskInfo
    protected void onMaskInfoCallback(int i6, int i7, String str) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
