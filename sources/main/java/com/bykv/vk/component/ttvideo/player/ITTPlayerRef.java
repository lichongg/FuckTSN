package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.view.Surface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.utils.HardWareInfo;
import com.bytedance.sdk.component.utils.vl;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class ITTPlayerRef {
    public static synchronized ITTPlayerRef create(Context context, TTPlayerClient tTPlayerClient, HashMap<Integer, Integer> hashMap) {
        TTPlayerRef tTPlayerRef;
        synchronized (ITTPlayerRef.class) {
            try {
                if (HardWareInfo.getCpuFamily() == 1) {
                    tTPlayerRef = TTPlayerRef.create(tTPlayerClient, context);
                    if (tTPlayerRef != null && TTPlayerConfiger.isPrintInfo()) {
                        vl.j(TTPlayerConfiger.TAG, "---------->ttplayer on<------------");
                    }
                } else {
                    tTPlayerRef = null;
                }
                if (tTPlayerRef == null) {
                    vl.j(TTPlayerConfiger.TAG, TTPlayerConfiger.getValue(16, "not find start service info."));
                    if (hashMap == null || hashMap.get(100).intValue() != 1) {
                        if (!TTPlayerConfiger.getValue(7, false) && TTPlayerConfiger.getValue(10, 0) < 3) {
                            TTPlayerConfiger.setValue(7, true);
                        }
                    } else if (hashMap.get(7).intValue() == 0 && hashMap.get(10).intValue() < 3) {
                        hashMap.put(7, 1);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tTPlayerRef;
    }

    protected abstract void close();

    protected abstract Context getContext();

    protected abstract double getDoubleOption(int i6, double d6);

    protected abstract float getFloatOption(int i6, float f6);

    protected abstract int getIntOption(int i6, int i7);

    protected abstract int getLifeId();

    protected abstract long getLongOption(int i6, long j6);

    protected abstract Object getObjectOption(int i6);

    protected abstract String getStringOption(int i6);

    protected abstract int getType();

    protected abstract boolean isValid();

    protected abstract void mouseEvent(int i6, int i7, int i8);

    protected abstract void pause();

    protected abstract void prepare();

    protected abstract void prevClose();

    protected abstract void release();

    protected abstract void reset();

    protected abstract void rotateCamera(float f6, float f7);

    protected abstract void seekTo(int i6);

    protected abstract void setAudioProcessor(AudioProcessor audioProcessor);

    protected abstract void setCacheFile(String str, int i6);

    protected abstract void setDataSource(IMediaDataSource iMediaDataSource);

    protected abstract void setDataSource(String str);

    protected abstract void setDataSourceFd(int i6);

    protected abstract int setDoubleOption(int i6, double d6);

    protected abstract int setFloatOption(int i6, float f6);

    protected abstract void setFrameMetadataListener(FrameMetadataListener frameMetadataListener);

    protected abstract int setIntOption(int i6, int i7);

    protected abstract void setLoadControl(LoadControl loadControl);

    protected abstract int setLongOption(int i6, long j6);

    protected abstract void setLooping(int i6);

    protected abstract void setMaskInfo(MaskInfo maskInfo);

    protected abstract void setMediaTransport(MediaTransport mediaTransport);

    protected abstract void setNotifyState(long j6);

    protected abstract void setOnScreenshotListener(MediaPlayer.OnScreenshotListener onScreenshotListener);

    protected abstract int setStringOption(int i6, String str);

    protected abstract void setSubInfo(SubInfo subInfo);

    protected abstract void setSurface(Surface surface);

    protected abstract void setVolume(float f6, float f7);

    protected abstract void start();

    protected abstract void stop();

    protected abstract void switchStream(int i6, int i7);

    protected abstract void takeScreenshot();

    protected void invalid() {
    }
}
