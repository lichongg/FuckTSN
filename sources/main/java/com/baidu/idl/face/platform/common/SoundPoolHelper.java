package com.baidu.idl.face.platform.common;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.utils.SoundPlayer;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SoundPoolHelper {
    private static final String TAG = "SoundPoolHelper";
    private Context mContext;
    private FaceStatusNewEnum mPlaySoundStatusNewEnum;
    private volatile long mPlayDuration = 0;
    private volatile long mPlayTime = 0;
    private volatile boolean mIsPlaying = false;
    private volatile boolean mIsEnableSound = true;
    private HashMap<Integer, Long> mPlayDurationMap = new HashMap<>();

    private long getSoundDuration(int i6) {
        if (this.mPlayDurationMap.containsKey(Integer.valueOf(i6))) {
            return this.mPlayDurationMap.get(Integer.valueOf(i6)).longValue();
        }
        System.currentTimeMillis();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        long j6 = 600;
        try {
            mediaMetadataRetriever.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i6));
            j6 = Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue();
            this.mPlayDurationMap.put(Integer.valueOf(i6), Long.valueOf(j6));
            return j6;
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
            return j6;
        } catch (IllegalStateException e7) {
            e7.printStackTrace();
            return j6;
        } catch (Exception e8) {
            e8.printStackTrace();
            return j6;
        }
    }

    public boolean getEnableSound() {
        return this.mIsEnableSound;
    }

    public long getPlayDuration() {
        return this.mPlayDuration;
    }

    public boolean playSound(FaceStatusNewEnum faceStatusNewEnum) {
        if (!this.mIsEnableSound) {
            SoundPlayer.release();
        }
        if (this.mContext == null) {
            SoundPlayer.release();
        }
        this.mIsPlaying = System.currentTimeMillis() - SoundPlayer.playTime < this.mPlayDuration;
        if (this.mIsPlaying || (this.mPlaySoundStatusNewEnum == faceStatusNewEnum && System.currentTimeMillis() - this.mPlayTime < FaceEnvironment.TIME_TIPS_REPEAT)) {
            return false;
        }
        this.mIsPlaying = true;
        this.mPlaySoundStatusNewEnum = faceStatusNewEnum;
        this.mPlayDuration = 0L;
        this.mPlayTime = System.currentTimeMillis();
        int soundId = FaceEnvironment.getSoundId(faceStatusNewEnum);
        if (soundId > 0) {
            this.mPlayDuration = getSoundDuration(soundId);
            SoundPlayer.playTime = System.currentTimeMillis();
            if (this.mIsEnableSound) {
                SoundPlayer.play(this.mContext, soundId);
            }
        }
        return this.mIsPlaying;
    }

    public void setEnableSound(boolean z5) {
        this.mIsEnableSound = z5;
    }

    public SoundPoolHelper(Context context) {
        this.mContext = context;
    }

    public void release() {
        SoundPlayer.release();
        this.mPlayDuration = 0L;
        this.mPlayTime = 0L;
        this.mContext = null;
    }
}
