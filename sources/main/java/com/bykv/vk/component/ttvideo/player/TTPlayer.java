package com.bykv.vk.component.ttvideo.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.RemoteException;
import android.view.Surface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.l.m;
import java.util.List;
import java.util.Map;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class TTPlayer {
    private static final String TAG = "TTPlayer";
    private static String mAppPath;
    private static String mCachePath;
    private static String mCrashPath;
    private static ILibraryLoader mDebugLibLoader = new DefaultLibraryLoader(true);
    private static boolean mIsIPCPlayer;
    private static boolean mSetLibraryLoader;
    private static int mSupportSampleRateNB;
    private static int[] mSupportSampleRates;
    private Context mContext;
    private FrameMetadataListener mFrameMetadataListener;
    private long mHandle;
    private long mId;

    @Keep
    private long mMediaDataSource;
    private IPlayerNotifyer mNotifyer;
    private MediaPlayer.OnScreenshotListener mScreenshotListener;
    private long mNotifyerState = Long.MAX_VALUE;
    private int mTracker = 0;

    private static final native void _close(long j6);

    private final native long _create(Context context, int i6, String str);

    private static final native String _getAppPath();

    private static final native int _getCurrentPosition(long j6);

    private static final native double _getDoubleValue(long j6, int i6, double d6);

    private static final native int _getDuration(long j6);

    private static final native float _getFloatValue(long j6, int i6, float f6);

    private static final native int _getIntValue(long j6, int i6, int i7);

    private static final native Object _getJObjectValue(long j6, int i6);

    private static final native long _getLongValue(long j6, int i6, long j7);

    private static final native String _getStringValue(long j6, int i6);

    private static final native int _getVideoHeight(long j6);

    private static final native int _getVideoWidth(long j6);

    private static final native int _isLooping(long j6);

    private static final native int _isPlaying(long j6);

    private static final native void _mouseEvent(long j6, int i6, int i7, int i8);

    private static final native int _pause(long j6);

    private static final native int _prepare(long j6);

    private static final native void _prevClose(long j6);

    private static final native void _registerPlayerInfo();

    private static final native void _release(long j6);

    private static final native int _reset(long j6);

    private static final native void _rotateCamera(long j6, float f6, float f7);

    private static final native int _seek(long j6, int i6);

    private static final native void _setAudioProcessor(long j6, AudioProcessor audioProcessor);

    private static final native void _setCacheFile(long j6, String str, int i6);

    private static final native void _setDataSource(long j6, IMediaDataSource iMediaDataSource);

    private static final native void _setDataSource(long j6, String str);

    private static final native void _setDataSourceFd(long j6, int i6);

    private static final native int _setDoubleValue(long j6, int i6, double d6);

    private static final native int _setFloatValue(long j6, int i6, float f6);

    private static final native int _setIntValue(long j6, int i6, int i7);

    private static final native void _setLoadControl(long j6, LoadControl loadControl);

    private static final native int _setLongValue(long j6, int i6, long j7);

    private static final native void _setLooping(long j6, int i6);

    private static final native void _setMaskInfo(long j6, MaskInfo maskInfo);

    private static final native void _setMediaTransport(long j6, MediaTransport mediaTransport);

    private static final native int _setStringValue(long j6, int i6, String str);

    private static final native void _setSubInfo(long j6, SubInfo subInfo);

    private static final native void _setSupportFormatNB(int i6);

    private static final native void _setSupprotSampleRates(int[] iArr, int i6);

    private static final native int _setSurfaceValue(long j6, long j7);

    private static final native int _setVideoSurface(long j6, Surface surface);

    private static final native void _setVolume(long j6, float f6, float f7);

    private static final native int _start(long j6);

    private static final native void _stop(long j6);

    private static final native void _switchStream(long j6, int i6, int i7);

    private static final native void _takeScreenshot(long j6);

    private void create(long j6) throws Exception {
        this.mNotifyer = null;
        Context context = this.mContext;
        boolean z5 = mIsIPCPlayer;
        long _create = _create(context, z5 ? 1 : 0, mAppPath);
        this.mHandle = _create;
        this.mId = j6;
        if (_create == 0) {
            throw new Exception("create native player is fail.");
        }
    }

    public void setDataSource(String str) {
        long j6 = this.mHandle;
        if (j6 != 0) {
            _setDataSource(j6, str);
        }
    }

    private static class DefaultLibraryLoader implements ILibraryLoader {
        boolean mLoadLibraryPath;

        public DefaultLibraryLoader(boolean z5) {
            this.mLoadLibraryPath = z5;
        }

        @Override // com.bykv.vk.component.ttvideo.player.ILibraryLoader
        @SuppressLint({"UnsafeDynamicallyLoadedCode"})
        public boolean onLoadNativeLibs(List<String> list) {
            for (String str : list) {
                try {
                    if (this.mLoadLibraryPath) {
                        System.load(str);
                    } else {
                        m.j(str);
                    }
                } catch (Throwable th) {
                    vl.r(TTPlayer.TAG, "load lib failed = " + th.getMessage());
                    return false;
                }
            }
            return true;
        }
    }

    static {
        synchronized (TTPlayer.class) {
            try {
                TTPlayerLibLoader.loadLibrary();
                try {
                    detectAudioFormat();
                } catch (UnsatisfiedLinkError e6) {
                    String errorInfo = TTPlayerLibLoader.getErrorInfo();
                    if (errorInfo == null) {
                        throw e6;
                    }
                    throw new UnsatisfiedLinkError(errorInfo);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void detectAudioFormat() {
        if (mSupportSampleRateNB == 0) {
            int[] iArr = new int[AudioFormats.getDefaultSampleRatesNB()];
            mSupportSampleRates = iArr;
            int maxSupportedSampleRates = AudioFormats.getMaxSupportedSampleRates(iArr);
            mSupportSampleRateNB = maxSupportedSampleRates;
            _setSupprotSampleRates(mSupportSampleRates, maxSupportedSampleRates);
        }
    }

    public static final String getAppPath() {
        return mAppPath;
    }

    public static final String getCachePath() {
        return mCachePath;
    }

    @CalledByNative
    public static final String getCrashPath() {
        return mCrashPath;
    }

    @CalledByNative
    public static int getThreadPoolStackSize() {
        return TTPlayerConfiger.getValue(25, 32);
    }

    @CalledByNative
    public static boolean isIPPlayer() {
        return mIsIPCPlayer;
    }

    @CalledByNative
    public static int isUsedThreadPool() {
        return TTPlayerConfiger.getValue(24, false) ? 1 : 0;
    }

    public static final void setCachePath(String str) {
        mCachePath = str;
    }

    public static final void setCrashPath(String str) {
        mCrashPath = str;
    }

    public static void setIsIPPlayer(boolean z5) {
        mIsIPCPlayer = z5;
    }

    public static final void setTempFileDir(String str) {
        mAppPath = str;
    }

    public int close() {
        long j6 = this.mHandle;
        if (j6 == 0) {
            return -1;
        }
        _close(j6);
        return 0;
    }

    @CalledByNative
    public void frameDTSNotify(int i6, long j6, long j7) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.frameDTSNotify(i6, j7, j6);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public double getDoubleOption(int i6, double d6) {
        return _getDoubleValue(this.mHandle, i6, d6);
    }

    public float getFloatOption(int i6, float f6) {
        return _getFloatValue(this.mHandle, i6, f6);
    }

    public final long getHandle() {
        return this.mHandle;
    }

    public int getIntOption(int i6, int i7) {
        if (i6 == 11) {
            return _getIntValue(this.mHandle, i6, i7);
        }
        if (i6 == 51) {
            return this.mTracker;
        }
        switch (i6) {
            case 1:
                return _getDuration(this.mHandle);
            case 2:
                return _getCurrentPosition(this.mHandle);
            case 3:
                return _getVideoWidth(this.mHandle);
            case 4:
                return _getVideoHeight(this.mHandle);
            case 5:
                return _isLooping(this.mHandle);
            case 6:
                return _isPlaying(this.mHandle);
            default:
                return _getIntValue(this.mHandle, i6, i7);
        }
    }

    public long getLongOption(int i6, long j6) {
        return i6 == 50 ? this.mHandle : _getLongValue(this.mHandle, i6, j6);
    }

    public long getNativePlayer() {
        return this.mHandle;
    }

    public Object getObjectValue(int i6) {
        return _getJObjectValue(this.mHandle, i6);
    }

    public String getStringOption(int i6) {
        return _getStringValue(this.mHandle, i6);
    }

    public void mouseEvent(int i6, int i7, int i8) {
        _mouseEvent(this.mHandle, i6, i7, i8);
    }

    @CalledByNative
    public void onFrameAboutToBeRendered(int i6, long j6, long j7, Map<Integer, String> map) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.onFrameAboutToBeRendered(i6, j6, j7, map);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    @CalledByNative
    public final void onLogInfo(int i6, int i7, String str) {
        IPlayerNotifyer iPlayerNotifyer = this.mNotifyer;
        if (iPlayerNotifyer != null) {
            try {
                iPlayerNotifyer.handleErrorNotify(this.mId, i6, i7, str);
            } catch (Throwable unused) {
            }
        }
    }

    @CalledByNative
    public void onNotify(int i6, int i7, int i8, String str) {
        if (((this.mNotifyerState >> i7) & 1) != 1) {
            return;
        }
        try {
            IPlayerNotifyer iPlayerNotifyer = this.mNotifyer;
            if (iPlayerNotifyer != null) {
                iPlayerNotifyer.handlePlayerNotify(this.mId, i6, i7, i8, str);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    protected int pause() {
        long j6 = this.mHandle;
        if (j6 == 0) {
            return -1;
        }
        return _pause(j6);
    }

    protected int prepare() {
        long j6 = this.mHandle;
        if (j6 == 0) {
            return -1;
        }
        return _prepare(j6);
    }

    public int prevClose() {
        long j6 = this.mHandle;
        if (j6 == 0) {
            return -1;
        }
        _setVideoSurface(j6, null);
        return 0;
    }

    protected void release() {
        this.mNotifyerState = 0L;
        long j6 = this.mHandle;
        if (j6 != 0) {
            _release(j6);
            this.mHandle = 0L;
        }
        this.mNotifyer = null;
        this.mScreenshotListener = null;
    }

    protected int reset() {
        long j6 = this.mHandle;
        if (j6 == 0) {
            return -1;
        }
        return _reset(j6);
    }

    public void rotateCamera(float f6, float f7) {
        _rotateCamera(this.mHandle, f6, f7);
    }

    public void seekTo(int i6) {
        _seek(this.mHandle, i6);
    }

    public void setAudioProcessor(AudioProcessor audioProcessor) {
        long j6 = this.mHandle;
        if (j6 != 0) {
            _setAudioProcessor(j6, audioProcessor);
        }
    }

    public void setCacheFile(String str, int i6) {
        _setCacheFile(this.mHandle, str, i6);
    }

    public void setDataSourceFd(int i6) {
        long j6 = this.mHandle;
        if (j6 != 0) {
            _setDataSourceFd(j6, i6);
        }
    }

    public int setDoubleOption(int i6, double d6) {
        return _setDoubleValue(this.mHandle, i6, d6);
    }

    public int setFloatOption(int i6, float f6) {
        return _setFloatValue(this.mHandle, i6, f6);
    }

    public void setFrameMetadataListener(FrameMetadataListener frameMetadataListener) {
        this.mFrameMetadataListener = frameMetadataListener;
    }

    public int setIntOption(int i6, int i7) throws RemoteException {
        if (i6 == 22) {
            if (i7 == 0) {
                vl.j(TTPlayerConfiger.TAG, "will occur anr crash");
            } else if (i7 == 2) {
                vl.j(TTPlayerConfiger.TAG, "will occur native crash");
            } else if (i7 == 1) {
                Process.killProcess(Process.myPid());
                System.exit(0);
                vl.j(TTPlayerConfiger.TAG, "will occur java crash");
                throw null;
            }
        }
        if (i6 != 111) {
            return _setIntValue(this.mHandle, i6, i7);
        }
        int[] iArr = TTPlayerKeys.SupportSampleRates;
        int length = iArr.length;
        int[] iArr2 = new int[iArr.length];
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            if (((1 << i9) & i7) == 0) {
                iArr2[i8] = TTPlayerKeys.SupportSampleRates[i9];
                i8++;
            }
        }
        _setSupprotSampleRates(iArr2, i8);
        return 0;
    }

    public void setLoadControl(LoadControl loadControl) {
        long j6 = this.mHandle;
        if (j6 != 0) {
            _setLoadControl(j6, loadControl);
        }
    }

    public int setLongOption(int i6, long j6) {
        return _setLongValue(this.mHandle, i6, j6);
    }

    public void setLooping(int i6) {
        _setLooping(this.mHandle, i6);
    }

    public void setMaskInfo(MaskInfo maskInfo) {
        long j6 = this.mHandle;
        if (j6 != 0) {
            _setMaskInfo(j6, maskInfo);
        }
    }

    public void setMediaTransport(MediaTransport mediaTransport) {
        long j6 = this.mHandle;
        if (j6 != 0) {
            _setMediaTransport(j6, mediaTransport);
        }
    }

    public void setNotifyer(IPlayerNotifyer iPlayerNotifyer) {
        this.mNotifyer = iPlayerNotifyer;
    }

    public void setNotifyerState(long j6) {
        this.mNotifyerState = j6;
        _setIntValue(this.mHandle, 16, (int) j6);
        _setLongValue(this.mHandle, 16, j6);
    }

    public void setOnScreenshotListener(MediaPlayer.OnScreenshotListener onScreenshotListener) {
        this.mScreenshotListener = onScreenshotListener;
    }

    public int setStringOption(int i6, String str) {
        return _setStringValue(this.mHandle, i6, str);
    }

    public void setSubInfo(SubInfo subInfo) {
        long j6 = this.mHandle;
        if (j6 != 0) {
            _setSubInfo(j6, subInfo);
        }
    }

    public int setSurfaceValue(long j6) {
        return _setSurfaceValue(this.mHandle, j6);
    }

    protected int setVideoSurface(Surface surface) {
        long j6 = this.mHandle;
        if (j6 != 0) {
            return _setVideoSurface(j6, surface);
        }
        return -1;
    }

    public void setVolume(float f6, float f7) {
        _setVolume(this.mHandle, f6, f7);
    }

    protected int start() {
        long j6 = this.mHandle;
        if (j6 == 0) {
            return -1;
        }
        return _start(j6);
    }

    protected int stop() {
        long j6 = this.mHandle;
        if (j6 == 0) {
            return -1;
        }
        _stop(j6);
        return 0;
    }

    public void switchStream(int i6, int i7) {
        _switchStream(this.mHandle, i6, i7);
    }

    public void takeScreenshot() {
        _takeScreenshot(this.mHandle);
    }

    @CalledByNative
    public final void takeScreenshotComplete(Bitmap bitmap) {
        MediaPlayer.OnScreenshotListener onScreenshotListener = this.mScreenshotListener;
        if (onScreenshotListener != null) {
            onScreenshotListener.onTakeScreenShotCompletion(bitmap);
        }
    }

    @CalledByNative
    public void updateFrameTerminatedDTS(int i6, long j6, long j7) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.updateFrameTerminatedDTS(i6, j7, j6);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public TTPlayer(Context context, long j6) throws Exception {
        this.mContext = context;
        create(j6);
    }

    public static void registerPlayerInfo() {
        _registerPlayerInfo();
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException {
        long j6 = this.mHandle;
        if (j6 != 0) {
            _setDataSource(j6, iMediaDataSource);
        }
    }

    private static final void checkPlayerModel() {
    }
}
