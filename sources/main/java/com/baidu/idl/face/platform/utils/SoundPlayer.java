package com.baidu.idl.face.platform.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.SoundPool;
import android.util.SparseIntArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class SoundPlayer {
    private static final boolean DEBUG = false;
    private static final long LOAD_SOUND_MILLIS = 100;
    public static final int MAX_STREAMS = 5;
    private static final String TAG = "SoundPlayer";
    public static long playTime;
    private static SoundPlayer sSoundPlayer;
    private SoundPool mSoundPool = new SoundPool(5, 3, 0);
    private SparseIntArray mSoundPoolCache = new SparseIntArray();

    @SuppressLint({"NewApi"})
    public static void play(Context context, int i6) {
        if (sSoundPlayer == null) {
            sSoundPlayer = new SoundPlayer();
        }
        int i7 = sSoundPlayer.mSoundPoolCache.get(i6);
        if (i7 != 0) {
            try {
                sSoundPlayer.mSoundPool.play(i7, 1.0f, 1.0f, 5, 0, 1.0f);
                return;
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
        if (context == null) {
            return;
        }
        final int load = sSoundPlayer.mSoundPool.load(context, i6, 1);
        sSoundPlayer.mSoundPoolCache.put(i6, load);
        if (APIUtils.hasFroyo()) {
            sSoundPlayer.mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.baidu.idl.face.platform.utils.SoundPlayer.1
                @Override // android.media.SoundPool.OnLoadCompleteListener
                public void onLoadComplete(SoundPool soundPool, int i8, int i9) {
                    if (i9 == 0 && load == i8) {
                        try {
                            SoundPlayer.playTime = System.currentTimeMillis();
                            SoundPlayer.sSoundPlayer.mSoundPool.play(load, 1.0f, 1.0f, 5, 0, 1.0f);
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                }
            });
            return;
        }
        try {
            Thread.currentThread().join(100L);
        } catch (InterruptedException e7) {
            e7.printStackTrace();
        }
        playTime = System.currentTimeMillis();
        sSoundPlayer.mSoundPool.play(load, 1.0f, 1.0f, 5, 0, 1.0f);
    }

    public static void release() {
        SoundPlayer soundPlayer = sSoundPlayer;
        if (soundPlayer != null) {
            int size = soundPlayer.mSoundPoolCache.size();
            for (int i6 = 0; i6 < size; i6++) {
                SoundPlayer soundPlayer2 = sSoundPlayer;
                soundPlayer2.mSoundPool.unload(soundPlayer2.mSoundPoolCache.valueAt(i6));
            }
            sSoundPlayer.mSoundPool.release();
            SoundPlayer soundPlayer3 = sSoundPlayer;
            soundPlayer3.mSoundPool = null;
            soundPlayer3.mSoundPoolCache.clear();
            sSoundPlayer.mSoundPoolCache = null;
            sSoundPlayer = null;
        }
        playTime = 0L;
    }

    private SoundPlayer() {
        playTime = 0L;
    }
}
