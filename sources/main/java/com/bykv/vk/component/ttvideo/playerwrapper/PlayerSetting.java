package com.bykv.vk.component.ttvideo.playerwrapper;

import android.content.Context;
import android.media.AudioManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class PlayerSetting {
    private final Context mContext;
    private float mCurrentPlayerVolume = 1.0f;
    private float mLastVolume;
    private MediaPlayer mPlayer;

    public float getMaxVolume() {
        Context context = this.mContext;
        if (context == null) {
            return 0.0f;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        return (audioManager != null ? audioManager.getStreamMaxVolume(3) : 0) >= 0 ? r0 : 0;
    }

    public float getPlayerVolume() {
        return this.mCurrentPlayerVolume;
    }

    public float getVolume() {
        Context context = this.mContext;
        if (context == null) {
            return 0.0f;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        return (audioManager != null ? audioManager.getStreamVolume(3) : 0) >= 0 ? r0 : 0;
    }

    public boolean isMute() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return false;
        }
        return mediaPlayer.isOSPlayer() ? getVolume() < 0.001f : this.mPlayer.isMute();
    }

    public void setMute(boolean z5) {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (!mediaPlayer.isOSPlayer()) {
            this.mPlayer.setIsMute(z5);
            return;
        }
        float maxVolume = getMaxVolume();
        if (maxVolume > 0.0f) {
            this.mLastVolume = getVolume() / maxVolume;
        }
        if (z5) {
            this.mPlayer.setVolume(0.0f, 0.0f);
            return;
        }
        MediaPlayer mediaPlayer2 = this.mPlayer;
        float f6 = this.mLastVolume;
        mediaPlayer2.setVolume(f6, f6);
    }

    public void setPlayer(MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
    }

    public void setPlayerVolume(float f6) {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (f6 < 0.0f) {
            f6 = 0.0f;
        } else if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        this.mCurrentPlayerVolume = f6;
        mediaPlayer.setVolume(f6, f6);
    }

    public void setVolume(float f6) {
        AudioManager audioManager;
        if (this.mPlayer == null || (audioManager = (AudioManager) this.mContext.getSystemService("audio")) == null) {
            return;
        }
        audioManager.setStreamVolume(3, (int) f6, 0);
    }

    public PlayerSetting(Context context, MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
        this.mContext = context;
    }
}
