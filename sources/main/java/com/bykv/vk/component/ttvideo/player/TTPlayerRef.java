package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.os.RemoteException;
import android.view.Surface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class TTPlayerRef extends ITTPlayerRef implements IPlayerNotifyer {
    private static final String TAG = "TTPlayerRef";
    private static String mAppPath;
    private static String mLoadErr;
    private TTPlayerClient mClient;
    private Context mContext;
    private long mId = System.currentTimeMillis();
    private TTPlayer mPlayer;

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int getType() {
        return 1;
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setDataSource(String str) {
        this.mPlayer.setDataSource(str);
    }

    public static final synchronized TTPlayerRef create(TTPlayerClient tTPlayerClient, Context context) {
        TTPlayerRef tTPlayerRef;
        RuntimeException runtimeException;
        synchronized (TTPlayerRef.class) {
            if (mAppPath == null) {
                mAppPath = TTPlayerConfiger.getAppFileCachePath(context);
                try {
                    if (TTPlayer.getAppPath() == null) {
                        TTPlayer.setTempFileDir(mAppPath);
                    }
                } catch (UnsatisfiedLinkError e6) {
                    mLoadErr = e6.getMessage();
                }
            }
            if (mLoadErr != null) {
                throw new UnsatisfiedLinkError(mLoadErr);
            }
            tTPlayerRef = new TTPlayerRef(context);
            tTPlayerRef.mClient = tTPlayerClient;
            try {
                TTPlayer tTPlayer = new TTPlayer(context, tTPlayerRef.mId);
                tTPlayerRef.mPlayer = tTPlayer;
                tTPlayer.setNotifyer(tTPlayerRef);
            } finally {
            }
        }
        return tTPlayerRef;
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void close() {
        this.mPlayer.close();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected double getDoubleOption(int i6, double d6) {
        return this.mPlayer.getDoubleOption(i6, d6);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected float getFloatOption(int i6, float f6) {
        return this.mPlayer.getFloatOption(i6, f6);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int getIntOption(int i6, int i7) {
        return this.mPlayer.getIntOption(i6, i7);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected int getLifeId() {
        return this.mPlayer.getIntOption(35, -1);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public long getLongOption(int i6, long j6) {
        return this.mPlayer.getLongOption(i6, j6);
    }

    public long getNativeObject() {
        return this.mPlayer.getNativePlayer();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected Object getObjectOption(int i6) {
        return this.mPlayer.getObjectValue(i6);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public String getStringOption(int i6) {
        return this.mPlayer.getStringOption(i6);
    }

    @Override // com.bykv.vk.component.ttvideo.player.IPlayerNotifyer
    public void handleErrorNotify(long j6, int i6, int i7, String str) {
        this.mClient.onPlayLogInfo(i6, i7, str);
    }

    @Override // com.bykv.vk.component.ttvideo.player.IPlayerNotifyer
    public void handlePlayerNotify(long j6, int i6, int i7, int i8, String str) {
        this.mClient.onPlayerNotify(i6, i7, i8, str);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected boolean isValid() {
        return this.mPlayer != null;
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void mouseEvent(int i6, int i7, int i8) {
        this.mPlayer.mouseEvent(i6, i7, i8);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void pause() {
        this.mPlayer.pause();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void prepare() {
        this.mPlayer.prepare();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void prevClose() {
        this.mPlayer.prevClose();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void release() {
        TTPlayer tTPlayer = this.mPlayer;
        this.mPlayer = null;
        tTPlayer.release();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void reset() {
        this.mPlayer.reset();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void rotateCamera(float f6, float f7) {
        this.mPlayer.rotateCamera(f6, f7);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void seekTo(int i6) {
        this.mPlayer.seekTo(i6);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected void setAudioProcessor(AudioProcessor audioProcessor) {
        this.mPlayer.setAudioProcessor(audioProcessor);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setCacheFile(String str, int i6) {
        this.mPlayer.setCacheFile(str, i6);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected void setDataSource(IMediaDataSource iMediaDataSource) {
        this.mPlayer.setDataSource(iMediaDataSource);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected void setDataSourceFd(int i6) {
        this.mPlayer.setDataSourceFd(i6);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected int setDoubleOption(int i6, double d6) {
        return this.mPlayer.setDoubleOption(i6, d6);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected int setFloatOption(int i6, float f6) {
        return this.mPlayer.setFloatOption(i6, f6);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected void setFrameMetadataListener(FrameMetadataListener frameMetadataListener) {
        this.mPlayer.setFrameMetadataListener(frameMetadataListener);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int setIntOption(int i6, int i7) {
        try {
            return this.mPlayer.setIntOption(i6, i7);
        } catch (RemoteException e6) {
            vl.j(e6);
            return -1;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected void setLoadControl(LoadControl loadControl) {
        this.mPlayer.setLoadControl(loadControl);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int setLongOption(int i6, long j6) {
        return this.mPlayer.setLongOption(i6, j6);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setLooping(int i6) {
        this.mPlayer.setLooping(i6);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected void setMaskInfo(MaskInfo maskInfo) {
        this.mPlayer.setMaskInfo(maskInfo);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected void setMediaTransport(MediaTransport mediaTransport) {
        this.mPlayer.setMediaTransport(mediaTransport);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setNotifyState(long j6) {
        this.mPlayer.setNotifyerState(j6);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected void setOnScreenshotListener(MediaPlayer.OnScreenshotListener onScreenshotListener) {
        this.mPlayer.setOnScreenshotListener(onScreenshotListener);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public int setStringOption(int i6, String str) {
        return this.mPlayer.setStringOption(i6, str);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    protected void setSubInfo(SubInfo subInfo) {
        this.mPlayer.setSubInfo(subInfo);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setSurface(Surface surface) {
        this.mPlayer.setVideoSurface(surface);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void setVolume(float f6, float f7) {
        this.mPlayer.setVolume(f6, f7);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void start() {
        this.mPlayer.start();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void stop() {
        this.mPlayer.stop();
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void switchStream(int i6, int i7) {
        this.mPlayer.switchStream(i6, i7);
    }

    @Override // com.bykv.vk.component.ttvideo.player.ITTPlayerRef
    public void takeScreenshot() {
        this.mPlayer.takeScreenshot();
    }

    public TTPlayerRef(Context context) {
        this.mContext = context;
    }
}
