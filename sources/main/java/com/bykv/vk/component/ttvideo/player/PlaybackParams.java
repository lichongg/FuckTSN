package com.bykv.vk.component.ttvideo.player;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class PlaybackParams {
    protected static final int DEFAULT_VALUE = -1;
    private int mDescribeContents = -1;
    private int mAudioFallbackMode = -1;
    private float mPitch = -1.0f;
    private float mSpeed = -1.0f;

    public int describeContents() {
        return this.mDescribeContents;
    }

    public int getAudioFallbackMode() {
        return this.mAudioFallbackMode;
    }

    public float getPitch() {
        return this.mPitch;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public PlaybackParams setAudioFallbackMode(int i6) {
        this.mAudioFallbackMode = i6;
        return this;
    }

    public PlaybackParams setPitch(float f6) {
        this.mPitch = f6;
        return this;
    }

    public PlaybackParams setSpeed(float f6) {
        this.mSpeed = f6;
        return this;
    }

    public PlaybackParams allowDefaults() {
        return this;
    }
}
