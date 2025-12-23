package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;
import java.nio.ByteBuffer;

@JNINamespace("PLAYER")
/* loaded from: D:\Downloads\app\classes3.dex */
public class NativeAudioProcessor extends AudioProcessor {
    protected long mNativeWrapper = 0;

    @CalledByNative
    private long getNativeWrapper() {
        return this.mNativeWrapper;
    }

    @CalledByNative
    public static boolean isNativeAudioProcessor(AudioProcessor audioProcessor) {
        return audioProcessor instanceof NativeAudioProcessor;
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioClose() {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioOpen(int i6, int i7, int i8, int i9) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioProcess(ByteBuffer[] byteBufferArr, int i6, long j6) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioRelease(int i6) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @CalledByNative
    public void setNativeWrapper(long j6) {
        this.mNativeWrapper = j6;
    }
}
