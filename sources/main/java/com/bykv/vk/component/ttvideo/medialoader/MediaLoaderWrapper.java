package com.bykv.vk.component.ttvideo.medialoader;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.AppInfo;
import com.bykv.vk.component.ttvideo.log.LiveLoggerService;
import com.bykv.vk.component.ttvideo.log.MyLog;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderNotifyInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.vl;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class MediaLoaderWrapper implements AVMDLDataLoaderListener {
    public static final int DATALOADER_KEY_NOTIFY_OWNVDPLOG = 1;
    public static final int DATALOADER_KEY_NOTIFY_SPEEDINFO = 2;
    public static final int DATALOADER_KEY_NOTIFY_TASKLOG = 0;
    static final String HTTP_PROTO_PREFIX = "http://";
    static final String MDL_PROTO_PREFIX = "mdl://";
    static final String TAG = "MediaLoaderWrapper";
    private volatile boolean isProxyLibraryLoaded;
    public AVMDLDataLoaderConfigure mConfigure;
    private boolean mEnableLoadLibrary;
    private boolean mIsRunning;
    private MediaLoaderListener mListener;
    private LiveLoggerService mLogService;
    private MediaPlayer mPlayer;
    private volatile LibraryLoadProxy mProxy;

    /* renamed from: com.bykv.vk.component.ttvideo.medialoader.MediaLoaderWrapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Holder {
        private static MediaLoaderWrapper instance = new MediaLoaderWrapper((AnonymousClass1) null);

        private Holder() {
        }
    }

    /* synthetic */ MediaLoaderWrapper(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void enableLoadLibrary() {
        this.mEnableLoadLibrary = true;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getCheckSumInfo(String str) {
        return null;
    }

    public String getProxyUrl(String str, Boolean bool) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        if (!supportProxy(str)) {
            return str;
        }
        String localAddr = AVMDLDataLoader.getInstance().getLocalAddr();
        if (TextUtils.isEmpty(localAddr)) {
            return null;
        }
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (Throwable th) {
            vl.j(th);
        }
        String str3 = localAddr + "?rk=v02004b50000bh9ajqhdli3lfv2rgsgg&k=426161df8c5ce110209a6fc6641e049ddfrfgaf&u0=" + str2;
        return bool.booleanValue() ? "mdl://".concat(String.valueOf(str3)) : "http://".concat(String.valueOf(str3));
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getStringValue(int i6, long j6, String str) {
        return null;
    }

    private MediaLoaderWrapper() {
        this.isProxyLibraryLoaded = false;
        this.mProxy = null;
        this.mIsRunning = false;
        this.mEnableLoadLibrary = false;
        this.mConfigure = AVMDLDataLoaderConfigure.getDefaultonfigure();
    }

    private boolean initInternal() {
        if (this.mEnableLoadLibrary) {
            if (!loadLibrary()) {
                MyLog.i(TAG, String.format("library load fail", new Object[0]));
                return false;
            }
            if (AVMDLDataLoader.init(this.mProxy != null) != 0) {
                String.format("library has not been loaded", new Object[0]);
                return false;
            }
        }
        try {
            AVMDLDataLoader.getInstance().setListener(107, this);
            return true;
        } catch (Exception e6) {
            vl.j(e6);
            MyLog.i(TAG, String.format("create loader failed: exception is" + e6.toString(), new Object[0]));
            return false;
        }
    }

    private boolean loadLibrary() {
        if (this.mProxy == null) {
            return true;
        }
        if (this.mProxy != null && !this.isProxyLibraryLoaded) {
            this.isProxyLibraryLoaded = this.mProxy.loadLibrary("avmdl");
        }
        return this.isProxyLibraryLoaded;
    }

    public void close() {
        if (!this.mIsRunning) {
            MyLog.e(TAG, "MediaLoader not started, not need close");
            return;
        }
        this.mListener = null;
        AVMDLDataLoader.getInstance().close();
        AVMDLDataLoader.getInstance().cancelAll();
        this.mIsRunning = false;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public long getInt64Value(int i6, long j6) {
        MediaLoaderListener mediaLoaderListener;
        MyLog.i(TAG, "getInt64Value:".concat(String.valueOf(i6)));
        if (i6 == 8003) {
            MediaPlayer mediaPlayer = this.mPlayer;
            if (mediaPlayer != null) {
                return mediaPlayer.getLongOption(73, 0L);
            }
        } else if (i6 == 8004 && (mediaLoaderListener = this.mListener) != null) {
            return mediaLoaderListener.getInt64Value(0, j6);
        }
        return j6;
    }

    public long getLongValueFromLoader(int i6) {
        MyLog.i(TAG, "get long value from loader");
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (i6 == 7218) {
            if (aVMDLDataLoader == null) {
                return -1L;
            }
            return aVMDLDataLoader.getLongValue(AVMDLDataLoader.KeyIsGetMdlProtocolHandle);
        }
        switch (i6) {
            case AVMDLDataLoader.KeyIsLiveLoaderEnable /* 8100 */:
                if (aVMDLDataLoader == null) {
                    return -1L;
                }
                return aVMDLDataLoader.getLongValue(AVMDLDataLoader.KeyIsLiveLoaderEnable);
            case AVMDLDataLoader.KeyIsLiveLoaderP2pEnable /* 8101 */:
                if (aVMDLDataLoader == null) {
                    return -1L;
                }
                return aVMDLDataLoader.getLongValue(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable);
            case 8102:
                return (aVMDLDataLoader != null ? aVMDLDataLoader.getLongValue(8102) : -1L) == 1 ? 1L : 0L;
            default:
                return -1L;
        }
    }

    public String getStringValueFromLoader(int i6) {
        MyLog.i(TAG, "get string value from loader");
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (i6 == 11 && aVMDLDataLoader != null) {
            return aVMDLDataLoader.getStringValue(11);
        }
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public void onNotify(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        if (aVMDLDataLoaderNotifyInfo == null || this.mListener == null) {
            return;
        }
        MyLog.i(TAG, "what:" + aVMDLDataLoaderNotifyInfo.what);
        int i6 = aVMDLDataLoaderNotifyInfo.what;
        if (i6 == 9) {
            MediaLoaderListener mediaLoaderListener = this.mListener;
            if (mediaLoaderListener != null) {
                mediaLoaderListener.onDataLoaderError((int) aVMDLDataLoaderNotifyInfo.parameter, aVMDLDataLoaderNotifyInfo.logInfo);
            }
            MyLog.i(TAG, "live loader errorCode:" + aVMDLDataLoaderNotifyInfo.parameter + " errorInfo:" + aVMDLDataLoaderNotifyInfo.logInfo);
            return;
        }
        if (i6 != 12) {
            return;
        }
        MediaLoaderListener mediaLoaderListener2 = this.mListener;
        if (mediaLoaderListener2 != null) {
            mediaLoaderListener2.onSwitchLoaderType((int) aVMDLDataLoaderNotifyInfo.parameter, aVMDLDataLoaderNotifyInfo.logInfo);
        }
        MyLog.i(TAG, "switch reason:" + aVMDLDataLoaderNotifyInfo.parameter + " switchInfo:" + aVMDLDataLoaderNotifyInfo.logInfo);
    }

    public void setIntValue(int i6, int i7) {
        if (i6 == 51) {
            this.mConfigure.mRWTimeOut = i7;
            return;
        }
        if (i6 == 52) {
            this.mConfigure.mOpenTimeOut = i7;
            return;
        }
        if (i6 == 53) {
            this.mConfigure.mTryCount = i7;
            return;
        }
        if (i6 == 49) {
            MyLog.i(TAG, "allow p2p:".concat(String.valueOf(i7)));
            this.mConfigure.mLiveP2pAllow = i7;
        } else if (i6 == 50) {
            MyLog.i(TAG, "loader type:".concat(String.valueOf(i7)));
            this.mConfigure.mLiveLoaderType = i7;
        }
    }

    public void setListener(MediaLoaderListener mediaLoaderListener) {
        this.mListener = mediaLoaderListener;
        try {
            AVMDLDataLoader.getInstance().setListener(107, this);
        } catch (Exception e6) {
            vl.j(e6);
            MyLog.i(TAG, String.format("create loader failed: exception is" + e6.toString(), new Object[0]));
        }
    }

    public void setLoadProxy(LibraryLoadProxy libraryLoadProxy) {
        this.mProxy = libraryLoadProxy;
    }

    public void setLogService(LiveLoggerService liveLoggerService) {
        this.mLogService = liveLoggerService;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
    }

    public void start() throws Exception {
        if (this.mIsRunning) {
            return;
        }
        if (!initInternal()) {
            throw new Exception("init mediaLoader fail");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String str = AppInfo.mAppChannel;
            if (str != null) {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_channel", AppInfo.mAppChannel);
                }
                if (!TextUtils.isEmpty(AppInfo.mAppName)) {
                    jSONObject.put("app_name", AppInfo.mAppName);
                }
                if (!TextUtils.isEmpty(AppInfo.mDeviceId)) {
                    jSONObject.put("device_id", AppInfo.mDeviceId);
                }
                if (!TextUtils.isEmpty(AppInfo.mAppVersion)) {
                    jSONObject.put("app_version", AppInfo.mAppVersion);
                }
                jSONObject.put("app_id", AppInfo.mAppID);
            }
        } catch (JSONException e6) {
            vl.j(e6);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        this.mConfigure.mAppInfo = jSONObject.toString();
        if (AppInfo.mAppID != -1) {
            MyLog.i(TAG, "set config");
            AVMDLDataLoader.getInstance().setConfigure(this.mConfigure);
        }
        if (AVMDLDataLoader.getInstance().start() < 0) {
            throw new Exception("start mediaLoader fail");
        }
        this.mIsRunning = true;
    }

    public static MediaLoaderWrapper getDataLoader() {
        return Holder.instance;
    }

    private boolean supportProxy(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("http://127.0.0.1") || lowerCase.startsWith("http://localhost") || lowerCase.startsWith("file://") || lowerCase.startsWith("/") || lowerCase.endsWith(".mpd") || lowerCase.contains(".mpd?") || lowerCase.contains(".m3u8?") || lowerCase.endsWith(".m3u8")) {
            return false;
        }
        return true;
    }

    public boolean isRunning() {
        if (AVMDLDataLoader.getInstance() == null) {
            return false;
        }
        return AVMDLDataLoader.getInstance().isRunning();
    }

    public void setInt64ValueByStrKey(int i6, String str, int i7) {
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (aVMDLDataLoader == null) {
            return;
        }
        if (i6 != 7213 && i6 != 7215) {
            aVMDLDataLoader.setInt64ValueByStrKey(i6, str, System.currentTimeMillis());
        } else {
            aVMDLDataLoader.setInt64ValueByStrKey(i6, str, i7);
        }
    }

    public void setLongValue(int i6, long j6) {
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (aVMDLDataLoader == null || i6 != 59) {
            return;
        }
        aVMDLDataLoader.setLongValue(1100, j6);
    }

    public void setStringValue(int i6, String str) {
        AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
        if (aVMDLDataLoader == null) {
            return;
        }
        aVMDLDataLoader.setStringValue(i6, str);
    }

    public MediaLoaderWrapper(MediaLoaderListener mediaLoaderListener) {
        this.isProxyLibraryLoaded = false;
        this.mProxy = null;
        this.mIsRunning = false;
        this.mEnableLoadLibrary = false;
        this.mConfigure = AVMDLDataLoaderConfigure.getDefaultonfigure();
        this.mListener = mediaLoaderListener;
    }
}
