package com.bykv.vk.component.ttvideo.player;

import java.nio.ByteBuffer;

@JNINamespace("PLAYER")
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class MediaTransport extends NativeObject {
    public static final int FILTER_AUDIO = 2;
    public static final int FILTER_VIDEO = 1;

    @Keep
    public static class MediaPacket {
        public static final int CODEC_ID_AAC = 2;
        public static final int CODEC_ID_BYTE_VC1 = 1;
        public static final int CODEC_ID_H264 = 0;
        public static final int FLAG_CONFIG_FRAME = 1;
        public static final int FLAG_IS_DECODED_ONLY = 3;
        public static final int FLAG_KEY_FRAME = 2;
        public ByteBuffer mBuffer;
        public int mCodecId;
        public int mFlags;
        public boolean mIsAccessUnit;
        public boolean mIsVideo;
        public int mOffset;
        public long mPresentationTimeMs;
        public int mSize;

        @CalledByNative("MediaPacket")
        public void set(ByteBuffer byteBuffer, boolean z5, boolean z6, int i6, int i7, long j6, int i8, int i9) {
            this.mBuffer = byteBuffer;
            this.mOffset = i6;
            this.mSize = i7;
            this.mPresentationTimeMs = j6;
            this.mFlags = i8;
            this.mIsVideo = z5;
            this.mCodecId = i9;
            this.mIsAccessUnit = z6;
        }

        @CalledByNative("MediaPacket")
        public MediaPacket() {
        }
    }

    private native void nativeSetFilterType(int i6);

    @CalledByNative
    protected abstract void sendPacket(MediaPacket mediaPacket);

    public void setFilterType(int i6) {
        nativeSetFilterType(i6);
    }
}
