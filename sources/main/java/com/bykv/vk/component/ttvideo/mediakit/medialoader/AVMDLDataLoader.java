package com.bykv.vk.component.ttvideo.mediakit.medialoader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSInfo;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParser;
import com.bykv.vk.component.ttvideo.mediakit.net.IPCache;
import com.bytedance.sdk.component.oq.r.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.l.m;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlinx.coroutines.t0;
import org.apache.commons.net.g;

/* loaded from: D:\Downloads\app\classes3.dex */
public class AVMDLDataLoader implements Handler.Callback {
    public static final int AVMDLErrorIsCreateTask = -1000;
    public static final int AVMDLErrorIsInvalidContentLenth = -2000;
    public static final int AVMDLErrorIsInvalidFileWrite = -5000;
    public static final int AVMDLErrorIsInvalidRequestInfo = -4000;
    public static final int AVMDLErrorIsStatusCodeMoreThan400 = -3000;
    public static final int AVMDLErrorIsStatusCodeMoreThan500 = -3001;
    public static final int AVMDLErrorIsTheSameKeyTask = -1001;
    public static final int AVMDLErrorIsTooManyTask = -1002;
    public static final int AVMDLLoaderTypeNone = 10000;
    public static final int AVMDLTaskStateStart = 1;
    public static final int AVMDLTaskStateStop = 2;
    public static final int AVMDLTaskTypeDownloadTask = 3;
    public static final int AVMDLTaskTypePlayTask = 1;
    public static final int AVMDLTaskTypePreloadTask = 2;
    public static final int AVMDLoaderTypeAliP2P = 5;
    public static final int AVMDLoaderTypeHttp = 0;
    public static final int AVMDLoaderTypeKsyP2P = 3;
    public static final int AVMDLoaderTypeOwnLiveVDP = 7;
    public static final int AVMDLoaderTypeOwnVDP = 2;
    public static final int AVMDLoaderTypeWsuP2P = 6;
    public static final int AVMDLoaderTypeXYVod = 1;
    public static final int AVMDLoaderTypeYFP2P = 4;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
    public static final int IsFail = 2;
    public static final int IsInit = 0;
    public static final int IsStart = 1;
    public static final int IsStop = 4;
    public static final int KeyIsAccessCheckLevel = 3511;
    public static final int KeyIsAllowTryTheLastUrl = 7357;
    public static final int KeyIsAlogEnable = 7225;
    public static final int KeyIsAlogInfo = 14;
    public static final int KeyIsCDNLog = 6;
    public static final int KeyIsCacheDirListsStr = 7399;
    public static final int KeyIsCloseFileCache = 800;
    public static final int KeyIsConnectPoolStragetyValue = 7363;
    public static final int KeyIsControlCDNRangeType = 703;
    public static final int KeyIsDNSLog = 15;
    public static final int KeyIsDownloadDir = 7300;
    public static final int KeyIsDownloadEnd = 21;
    public static final int KeyIsDownloadSuspend = 22;
    public static final int KeyIsDownloaderLog = 19;
    public static final int KeyIsDownloaderLogTTNet = 16;
    public static final int KeyIsEnableCacheReqRange = 7358;
    public static final int KeyIsEnableDynamicSocketTimeout = 7362;
    public static final int KeyIsEnableEarlyData = 8219;
    public static final int KeyIsEnableEventInfo = 9999;
    public static final int KeyIsEnableExternDNS = 700;
    public static final int KeyIsEnableFileCacheV2 = 7222;
    public static final int KeyIsEnableFileRingBuffer = 7228;
    public static final int KeyIsEnableIOManager = 7391;
    public static final int KeyIsEnableIpBucket = 901;
    public static final int KeyIsEnableLazyBufferpool = 7332;
    public static final int KeyIsEnableLoaderPreempt = 2510;
    public static final int KeyIsEnableLoaderSeek = 7369;
    public static final int KeyIsEnableNetScheduler = 7342;
    public static final int KeyIsEnableNewBufferpool = 7334;
    public static final int KeyIsEnableP2PPreDown = 7340;
    public static final int KeyIsEnablePlayInfoCache = 7339;
    public static final int KeyIsEnablePlayLog = 7341;
    public static final int KeyIsEnablePreconnect = 2508;
    public static final int KeyIsEnablePreloadReUse = 105;
    public static final int KeyIsEnableSessionReuse = 5511;
    public static final int KeyIsEnableSocketReuse = 701;
    public static final int KeyIsEnableStorageModule = 10000;
    public static final int KeyIsEnableSyncDnsForPcdn = 7226;
    public static final int KeyIsEnableUseFileExtendLoaderBuffer = 7229;
    public static final int KeyIsErrorStateTrustTime = 902;
    public static final int KeyIsFileCacheProgress = 3;
    public static final int KeyIsFirstRangeLeftThreshold = 7346;
    public static final int KeyIsForbidByPassCookie = 1510;
    public static final int KeyIsGetAllCacheSize = 100;
    public static final int KeyIsGetCacheInfo = 101;
    public static final int KeyIsGetCacheSize = 103;
    public static final int KeyIsGetCostLog = 1011;
    public static final int KeyIsGetCustomHttpHeader = 1509;
    public static final int KeyIsGetEnableHls = 9407;
    public static final int KeyIsGetIOManagerHandle = 7390;
    public static final int KeyIsGetLoaderVersion = 11;
    public static final int KeyIsGetLocalAddr = 4;
    public static final int KeyIsGetMdlProtocolHandle = 7218;
    public static final int KeyIsGetPlayLog = 1010;
    public static final int KeyIsGetResStatus = 7231;
    public static final int KeyIsGetSpeedStatus = 7230;
    public static final int KeyIsGetVersionInfo = 830;
    public static final int KeyIsGlobalSpeedSample = 703;
    public static final int KeyIsHeartBeatLog = 70;
    public static final int KeyIsHiJackError = 701;
    public static final int KeyIsIOSpeedInfo = 5;
    public static final int KeyIsIgnorePlayInfo = 9400;
    public static final int KeyIsInitialSocketTimeout = 7360;
    public static final int KeyIsIsCheckPreloadLevel = 6512;
    public static final int KeyIsIsChecksumLevel = 1504;
    public static final int KeyIsIsDownloadSource = 1506;
    public static final int KeyIsIsEnableDownloaderLog = 7347;
    public static final int KeyIsIsEnableTTNetLoader = 7348;
    public static final int KeyIsIsEncryptVersion = 1505;
    public static final int KeyIsIsGetChecksumInfo = 1503;
    public static final int KeyIsIsMaxTlsVersion = 5512;
    public static final int KeyIsIsPreloadCancel = 7;
    public static final int KeyIsIsTestSpeedVersion = 1502;
    public static final int KeyIsLiveCacheThresholdHttpToP2p = 8006;
    public static final int KeyIsLiveCacheThresholdP2pToHttp = 8007;
    public static final int KeyIsLiveContainerString = 8021;
    public static final int KeyIsLiveEnableMdlProto = 8102;
    public static final int KeyIsLiveGetCurrentBitRate = 8004;
    public static final int KeyIsLiveGetLoaderType = 8103;
    public static final int KeyIsLiveGetP2pState = 8002;
    public static final int KeyIsLiveGetPlayCacheSec = 8003;
    public static final int KeyIsLiveLoaderEnable = 8100;
    public static final int KeyIsLiveLoaderP2pEnable = 8101;
    public static final int KeyIsLiveMaxTrySwitchP2pTimes = 8008;
    public static final int KeyIsLiveMobileDownloadAllow = 8011;
    public static final int KeyIsLiveMobileUploadAllow = 8010;
    public static final int KeyIsLivePlayInfoAudioMixingEnd = 8014;
    public static final int KeyIsLivePlayInfoAudioMixingStart = 8013;
    public static final int KeyIsLivePlayInfoIsPreview = 8016;
    public static final int KeyIsLivePlayInfoIsStreamReceived = 8015;
    public static final int KeyIsLiveRecvDataTimeout = 8012;
    public static final int KeyIsLiveSetLoaderType = 8000;
    public static final int KeyIsLiveSetP2pAllow = 8001;
    public static final int KeyIsLiveSetPrepareTask = 8017;
    public static final int KeyIsLiveSetTaskFinish = 8018;
    public static final int KeyIsLiveWaitP2pReadyThreshold = 8009;
    public static final int KeyIsLiveWatchDurationThreshold = 8005;
    public static final int KeyIsLoadMonitorMinAllowLoadSize = 7397;
    public static final int KeyIsLoadMonitorTimeInternal = 7396;
    public static final int KeyIsLoaderCacheSize = 9216;
    public static final int KeyIsLoaderEventCancel = 72;
    public static final int KeyIsLoaderEventCompleted = 73;
    public static final int KeyIsLoaderEventStart = 71;
    public static final int KeyIsLoaderEventUnKnown = 74;
    public static final int KeyIsLoaderFactoryP2PLevel = 8216;
    public static final int KeyIsLoaderFactoryP2PStragetyLevel = 8218;
    public static final int KeyIsLoaderFactoryXYLibValue = 8217;
    public static final int KeyIsLoaderTypeSwitch = 12;
    public static final int KeyIsMAXIPV4Num = 7331;
    public static final int KeyIsMAXIPV6Num = 7330;
    public static final int KeyIsMarkedFileIOSpeed = 1508;
    public static final int KeyIsMaxFileMemCacheNum = 5515;
    public static final int KeyIsMaxFileMemCacheSize = 5513;
    public static final int KeyIsMaxIpCountEachDomain = 900;
    public static final int KeyIsMaxKeepAliveHostNum = 7364;
    public static final int KeyIsMaxSocketReuseNum = 7361;
    public static final int KeyIsNetCacheDir = 5510;
    public static final int KeyIsNetSchedulerBlockAllNetErr = 7343;
    public static final int KeyIsNetSchedulerBlockDurationMs = 7345;
    public static final int KeyIsNetSchedulerBlockErrCount = 7344;
    public static final int KeyIsNetworkAccessType = 7219;
    public static final int KeyIsNetworkChanged = 7217;
    public static final int KeyIsNewBufferPoolGrowBlockCount = 7337;
    public static final int KeyIsNewBufferpoolBlockSize = 7335;
    public static final int KeyIsNewBufferpoolResidentSize = 7336;
    public static final int KeyIsNewPreloadLog = 1002;
    public static final int KeyIsNewProtocolLog = 1001;
    public static final int KeyIsNewProxyLog = 1000;
    public static final int KeyIsNewTaskLog = 1003;
    public static final int KeyIsNextDownloadThreshold = 2511;
    public static final int KeyIsOnLiveLoaderError = 9;
    public static final int KeyIsOwnLiveLoaderLog = 10;
    public static final int KeyIsOwnLiveLoaderLogSample = 11;
    public static final int KeyIsOwnVdpLog = 1;
    public static final int KeyIsP2PFirstRangeLoaderType = 7372;
    public static final int KeyIsP2PPredownPeerCount = 7359;
    public static final int KeyIsPlayInfoBufferingEnd = 7214;
    public static final int KeyIsPlayInfoBufferingStart = 7213;
    public static final int KeyIsPlayInfoCurrentBuffer = 7215;
    public static final int KeyIsPlayInfoLoadPercent = 7212;
    public static final int KeyIsPlayInfoPlayingPos = 7211;
    public static final int KeyIsPlayInfoRenderStart = 7210;
    public static final int KeyIsPlayTaskState = 50;
    public static final int KeyIsPreconnectNum = 2509;
    public static final int KeyIsPreloadEnd = 4;
    public static final int KeyIsPreloadFail = 8;
    public static final int KeyIsPreloadStragetyWhenPlay = 1030;
    public static final int KeyIsPreloadWaitListType = 1040;
    public static final int KeyIsRingBufferSizeKB = 7221;
    public static final int KeyIsSessionTimeout = 7333;
    public static final int KeyIsSetAlogFuncPtr = 1100;
    public static final int KeyIsSetBackupLoaderType = 7227;
    public static final int KeyIsSetCacheDir = 0;
    public static final int KeyIsSetDMDomain = 9402;
    public static final int KeyIsSetDomains = 9404;
    public static final int KeyIsSetEnableOwnVdpPreloadNotify = 7395;
    public static final int KeyIsSetEnableReportTaskLog = 7371;
    public static final int KeyIsSetFileExtendSize = 7392;
    public static final int KeyIsSetForesightDomain = 9403;
    public static final int KeyIsSetGlobalSpeedSampleInterval = 7370;
    public static final int KeyIsSetKeyDomain = 9405;
    public static final int KeyIsSetKeyToken = 9406;
    public static final int KeyIsSetLiveListener = 107;
    public static final int KeyIsSetLoaderFactoryAppInfo = 10;
    public static final int KeyIsSetLoaderFactoryCacheDir = 9;
    public static final int KeyIsSetLoaderFactoryMaxCacheSize = 7;
    public static final int KeyIsSetLoaderFactoryMaxMemorySize = 8;
    public static final int KeyIsSetLoaderType = 6;
    public static final int KeyIsSetMaxCacheAge = 104;
    public static final int KeyIsSetMaxCacheSize = 1;
    public static final int KeyIsSetMinAllowSpeed = 7393;
    public static final int KeyIsSetNetSchedulerBlockHostErrIpCount = 7394;
    public static final int KeyIsSetOnlyUseCdn = 7216;
    public static final int KeyIsSetOpenTimeOut = 3;
    public static final int KeyIsSetPlayInfoSeekAction = 7338;
    public static final int KeyIsSetPreloadParallelNum = 102;
    public static final int KeyIsSetRWTimeOut = 2;
    public static final int KeyIsSetSettingsDomain = 9401;
    public static final int KeyIsSetSpeedSampleInterval = 7368;
    public static final int KeyIsSetTryCount = 5;
    public static final int KeyIsSocketIdleTimeout = 702;
    public static final int KeyIsSocketSendBufferKB = 7220;
    public static final int KeyIsSocketTrainingCenterConfigStr = 7398;
    public static final int KeyIsSpeedCoefficientValue = 1507;
    public static final int KeyIsSpeedInfo = 2;
    public static final int KeyIsSpeedTestSampledByTime = 700;
    public static final int KeyIsSpeedTestSampledByTimeV2 = 702;
    public static final int KeyIsStoIoWriteLimitKBTh1 = 10004;
    public static final int KeyIsStoIoWriteLimitKBTh2 = 10005;
    public static final int KeyIsStoMaxIdleTimeSec = 10006;
    public static final int KeyIsStoPlayDldWinSizeKBLS = 10002;
    public static final int KeyIsStoPlayDldWinSizeKBNM = 10001;
    public static final int KeyIsStoRingBufferSizeKB = 10003;
    public static final int KeyIsTTNetLoaderCronetBufSizeKB = 7349;
    public static final int KeyIsTaskFail = 20;
    public static final int KeyIsTaskLog = 0;
    public static final int KeyIsVdpABTestId = 7223;
    public static final int KeyIsVdpGroupId = 7224;
    public static final int KeyIsWriteFileNotifyIntervalMS = 110;
    public static final int LogInfoKeyIsPcdnTaskLog = 13;
    public static final long LongValueViaConfigNotReady = -998;
    public static final long LongValueViaUnknownKey = -1;
    public static final int S_FAIL = -1;
    public static final int S_OK = 0;
    private static final String TAG = "AVMDLDataLoader";
    private static boolean isSupportQueryEncode = true;
    private static AVMDLDataLoader mInstance;
    private static volatile boolean mIsLibraryLoaded;
    private static volatile boolean mIsMdlTtnetPluginLoaded;
    private boolean isSupportGetAuth;
    private AVMDLDataLoaderConfigure mConfigure;
    private long mEndTime;
    private LoaderListener mEventListener;
    private long mHandle;
    private AVMDLDataLoaderListener mLiveListener;
    private Thread mMsgThread;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private long mSartTime;
    private AVMDLStartCompleteListener mStartCompleteListener;
    private volatile int mState;
    private AVMDLDataLoaderListener mVodListener;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;
    private Handler mHandler = null;
    private Handler mLogHandler = null;

    private static native void _addDataSource(long j6, int i6, String str);

    private static native void _cancel(long j6, String str);

    private static native void _cancelAll(long j6);

    private static native void _cancelAllPreloadWaitReqs(long j6);

    private static native void _clearAllCaches(long j6);

    private static native void _clearCachesByUsedTime(long j6, long j7);

    private static native void _clearNetinfoCache(long j6);

    private static native void _close(long j6);

    private final native long _create();

    private static native void _downloadResource(long j6, String str);

    private static native String _encodeUrl(String str, int i6);

    private static native void _forceRemoveCacheFile(long j6, String str);

    private static native String _getAuth(long j6, String str);

    private static native String _getCDNLog(long j6, String str);

    private static native long _getLongValue(long j6, int i6);

    private static native long _getLongValueByStr(long j6, String str, int i6);

    private static native long _getLongValueByStrStr(long j6, String str, String str2, int i6);

    private static native String _getStringValue(long j6, int i6);

    private static native String _getStringValueByStr(long j6, String str, int i6);

    private static native String _getStringValueByStrStr(long j6, String str, String str2, int i6);

    private static native void _makeFileAutoDeleteFlag(long j6, String str, int i6);

    private static native String _makeTsFileKey(String str, String str2);

    private static native void _p2pPredown(long j6, String str);

    private static native void _preConnectByHost(long j6, String str, int i6);

    private static native void _preloadGroupResource(long j6, String str, String str2, int i6, int i7);

    private static native void _preloadResource(long j6, String str, int i6);

    private static native void _preloadResourceWithOffset(long j6, String str, int i6, int i7);

    private static native void _removeCacheFile(long j6, String str);

    private static native void _resumeFileWriteIO(long j6);

    private static native void _setInt64Value(long j6, int i6, long j7);

    private static native void _setInt64ValueByStrKey(long j6, int i6, String str, long j7);

    private static native void _setIntValue(long j6, int i6, int i7);

    private static native void _setStringValue(long j6, int i6, String str);

    private static native int _start(long j6);

    private static native void _stop(long j6);

    private static native void _suspendedDownload(long j6, String str);

    private static native void _updateDNSInfo(long j6, String str, String str2, long j7, String str3, int i6);

    public static synchronized int init(boolean z5) {
        synchronized (AVMDLDataLoader.class) {
            try {
                if (mIsLibraryLoaded) {
                    return 0;
                }
                mIsLibraryLoaded = z5;
                if (!z5) {
                    try {
                        m.j("avmdl_lite");
                        mIsLibraryLoaded = true;
                    } catch (UnsatisfiedLinkError e6) {
                        vl.r("ttmn", "Can't load avmdl library: ".concat(String.valueOf(e6)));
                    } catch (Throwable th) {
                        vl.r("ttmn", "other exception when loading avmdl library: ".concat(String.valueOf(th)));
                    }
                    tryLoadTTNetLoaderPlugin();
                }
                return !mIsLibraryLoaded ? -1 : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private boolean isNotifyInfo(int i6) {
        return i6 == 4 || i6 == 20 || i6 == 50 || i6 == 8 || i6 == 3 || i6 == 21 || i6 == 7 || i6 == 22;
    }

    private boolean postMessage(AVMDLDataLoaderListener aVMDLDataLoaderListener, Message message) {
        Object obj;
        AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo;
        if (message.what == 701) {
            hijack();
            return true;
        }
        if (aVMDLDataLoaderListener != null && (obj = message.obj) != null && (aVMDLDataLoaderNotifyInfo = (AVMDLDataLoaderNotifyInfo) obj) != null) {
            aVMDLDataLoaderListener.onNotify(aVMDLDataLoaderNotifyInfo);
        }
        return true;
    }

    public static boolean tryLoadVcnverifylib() {
        return true;
    }

    public long getCacheSize(String str, String str2) {
        long j6 = -1;
        if (this.mState != 1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j7 = this.mHandle;
                if (j7 != 0) {
                    j6 = _getLongValueByStrStr(j7, str, str2, 103);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            return j6;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getStringCacheInfo(String str) {
        String str2 = null;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    str2 = _getStringValueByStr(j6, str, 101);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            return str2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void onLogInfo(int i6, int i7, int i8, String str) {
        if (this.mState == 1 && this.mLogHandler != null && isNotifyInfo(i6)) {
            AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo = new AVMDLDataLoaderNotifyInfo();
            aVMDLDataLoaderNotifyInfo.what = i6;
            aVMDLDataLoaderNotifyInfo.code = i7;
            aVMDLDataLoaderNotifyInfo.parameter = i8;
            aVMDLDataLoaderNotifyInfo.logInfo = str;
            Message obtainMessage = this.mLogHandler.obtainMessage();
            obtainMessage.what = i6;
            obtainMessage.obj = aVMDLDataLoaderNotifyInfo;
            obtainMessage.sendToTarget();
        }
    }

    public void preloadResource(String str, int i6) {
        if (this.mState != 1 || TextUtils.isEmpty(str) || i6 == 0) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    _preloadResource(j6, str, i6);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setListener(AVMDLDataLoaderListener aVMDLDataLoaderListener) {
        this.mWriteLock.lock();
        try {
            this.mVodListener = aVMDLDataLoaderListener;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public static AVMDLDataLoader getInstance() {
        if (mInstance == null) {
            synchronized (AVMDLDataLoader.class) {
                if (mInstance == null) {
                    try {
                        mInstance = new AVMDLDataLoader(null);
                    } catch (Exception e6) {
                        vl.j(e6);
                        vl.r("ttmdl", "create native exception".concat(String.valueOf(e6)));
                        mInstance = null;
                    }
                }
            }
        }
        return mInstance;
    }

    private void initLogThread(final Handler.Callback callback) {
        if (this.mMsgThread == null) {
            cw cwVar = new cw() { // from class: com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super("AVMDLDataLoader$1");
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (Looper.myLooper() == null) {
                        Looper.prepare();
                    }
                    AVMDLDataLoader.this.mLogHandler = new Handler(callback);
                    Looper.loop();
                }
            };
            this.mMsgThread = cwVar;
            cwVar.setName("mdl_log_handler");
            this.mMsgThread.start();
        }
    }

    private void initNativeHandle() {
        if (this.mHandle != 0) {
            return;
        }
        try {
            this.mHandle = _create();
        } catch (Throwable th) {
            this.mHandle = 0L;
            vl.j(th);
        }
        if (this.mHandle == 0 || this.mHandler != null) {
            return;
        }
        if (Looper.myLooper() != null) {
            this.mHandler = new Handler(this);
        } else {
            this.mHandler = new Handler(Looper.getMainLooper(), this);
        }
    }

    public static String makeTsFileKey(String str, String str2) {
        try {
            return _makeTsFileKey(str, str2);
        } catch (Exception e6) {
            AVMDLLog.e(TAG, "makeTsFileKey failed, other reason:  " + e6.getMessage());
            return null;
        } catch (UnsatisfiedLinkError e7) {
            AVMDLLog.e(TAG, "makeTsFileKey failed, native not support: " + e7.getMessage());
            return null;
        }
    }

    public static String queryComponentEncode(String str) {
        if (isSupportQueryEncode && !TextUtils.isEmpty(str)) {
            try {
                return _encodeUrl(str, 4);
            } catch (Exception e6) {
                e6.getMessage();
                e6.getStackTrace();
            } catch (UnsatisfiedLinkError e7) {
                isSupportQueryEncode = false;
                e7.getMessage();
                e7.getStackTrace();
            }
        }
        return null;
    }

    private void setConfigureInternal(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) {
        if (this.mHandle == 0 || aVMDLDataLoaderConfigure == null) {
            return;
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mCacheDir)) {
            String createFilePathBaseDir = createFilePathBaseDir(aVMDLDataLoaderConfigure.mCacheDir, "loaderFactory");
            if (!TextUtils.isEmpty(createFilePathBaseDir)) {
                _setStringValue(this.mHandle, 9, createFilePathBaseDir);
            }
            if (TextUtils.isEmpty(this.mConfigure.mNetCacheDir)) {
                aVMDLDataLoaderConfigure.mNetCacheDir = createFilePathBaseDir(aVMDLDataLoaderConfigure.mCacheDir, "netCache");
            }
            _setStringValue(this.mHandle, 0, aVMDLDataLoaderConfigure.mCacheDir);
        }
        if (!TextUtils.isEmpty(this.mConfigure.mNetCacheDir)) {
            _setStringValue(this.mHandle, KeyIsNetCacheDir, aVMDLDataLoaderConfigure.mNetCacheDir);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mAppInfo)) {
            _setStringValue(this.mHandle, 10, aVMDLDataLoaderConfigure.mAppInfo);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mDownloadDir)) {
            _setStringValue(this.mHandle, KeyIsDownloadDir, aVMDLDataLoaderConfigure.mDownloadDir);
        }
        _setIntValue(this.mHandle, KeyIsLiveSetP2pAllow, aVMDLDataLoaderConfigure.mLiveP2pAllow);
        _setIntValue(this.mHandle, KeyIsLiveSetLoaderType, aVMDLDataLoaderConfigure.mLiveLoaderType);
        _setIntValue(this.mHandle, KeyIsLiveWatchDurationThreshold, aVMDLDataLoaderConfigure.mLiveWatchDurationThreshold);
        _setIntValue(this.mHandle, KeyIsLiveCacheThresholdHttpToP2p, aVMDLDataLoaderConfigure.mLiveCacheThresholdHttpToP2p);
        _setIntValue(this.mHandle, KeyIsLiveCacheThresholdP2pToHttp, aVMDLDataLoaderConfigure.mLiveCacheThresholdP2pToHttp);
        _setIntValue(this.mHandle, KeyIsLiveMaxTrySwitchP2pTimes, aVMDLDataLoaderConfigure.mLiveMaxTrySwitchP2pTimes);
        _setIntValue(this.mHandle, KeyIsLiveWaitP2pReadyThreshold, aVMDLDataLoaderConfigure.mLiveWaitP2pReadyThreshold);
        _setIntValue(this.mHandle, KeyIsLiveMobileUploadAllow, aVMDLDataLoaderConfigure.mLiveMobileUploadAllow);
        _setIntValue(this.mHandle, KeyIsLiveMobileDownloadAllow, aVMDLDataLoaderConfigure.mLiveMobileDownloadAllow);
        _setIntValue(this.mHandle, KeyIsLiveRecvDataTimeout, aVMDLDataLoaderConfigure.mLiveRecvDataTimeout);
        _setStringValue(this.mHandle, KeyIsLiveContainerString, aVMDLDataLoaderConfigure.mLiveContainerString);
        _setIntValue(this.mHandle, 1, aVMDLDataLoaderConfigure.mMaxCacheSize);
        _setIntValue(this.mHandle, 2, aVMDLDataLoaderConfigure.mRWTimeOut);
        _setIntValue(this.mHandle, 3, aVMDLDataLoaderConfigure.mOpenTimeOut);
        _setIntValue(this.mHandle, 5, aVMDLDataLoaderConfigure.mTryCount);
        _setIntValue(this.mHandle, 7, aVMDLDataLoaderConfigure.mMaxCacheSize);
        _setIntValue(this.mHandle, 8, aVMDLDataLoaderConfigure.mLoaderFactoryMaxMemorySize);
        _setIntValue(this.mHandle, 6, aVMDLDataLoaderConfigure.mLoaderType);
        _setIntValue(this.mHandle, 102, aVMDLDataLoaderConfigure.mPreloadParallelNum);
        _setIntValue(this.mHandle, 800, aVMDLDataLoaderConfigure.mIsCloseFileCache);
        int i6 = aVMDLDataLoaderConfigure.mMaxCacheAge;
        if (i6 > 0) {
            _setIntValue(this.mHandle, 104, i6);
        }
        _setIntValue(this.mHandle, 1030, aVMDLDataLoaderConfigure.mPreloadStrategy);
        _setIntValue(this.mHandle, KeyIsPreloadWaitListType, aVMDLDataLoaderConfigure.mPreloadWaitListType);
        _setIntValue(this.mHandle, 105, aVMDLDataLoaderConfigure.mEnablePreloadReUse);
        _setIntValue(this.mHandle, 700, aVMDLDataLoaderConfigure.mEnableExternDNS);
        _setIntValue(this.mHandle, 701, aVMDLDataLoaderConfigure.mEnableSocketReuse);
        _setIntValue(this.mHandle, 703, aVMDLDataLoaderConfigure.mControlCDNRangeType);
        _setIntValue(this.mHandle, 702, aVMDLDataLoaderConfigure.mSocketIdleTimeOut);
        _setIntValue(this.mHandle, 800, aVMDLDataLoaderConfigure.mIsCloseFileCache);
        _setIntValue(this.mHandle, KeyIsLoaderFactoryP2PLevel, aVMDLDataLoaderConfigure.mLoaderFactoryP2PLevel);
        _setIntValue(this.mHandle, KeyIsIsTestSpeedVersion, aVMDLDataLoaderConfigure.mTestSpeedTypeVersion);
        _setIntValue(this.mHandle, KeyIsIsChecksumLevel, aVMDLDataLoaderConfigure.mCheckSumLevel);
        _setIntValue(this.mHandle, KeyIsIsEncryptVersion, aVMDLDataLoaderConfigure.mEncryptVersion);
        _setIntValue(this.mHandle, KeyIsSpeedCoefficientValue, aVMDLDataLoaderConfigure.mSpeedCoefficientValue);
        _setIntValue(this.mHandle, 900, aVMDLDataLoaderConfigure.mMaxIpCountEachDomain);
        _setIntValue(this.mHandle, 901, aVMDLDataLoaderConfigure.mEnableIpBucket);
        _setIntValue(this.mHandle, 902, aVMDLDataLoaderConfigure.mErrorStateTrustTime);
        _setIntValue(this.mHandle, KeyIsEnablePreconnect, aVMDLDataLoaderConfigure.mEnablePreconnect);
        _setIntValue(this.mHandle, KeyIsPreconnectNum, aVMDLDataLoaderConfigure.mPreconnectNum);
        _setIntValue(this.mHandle, KeyIsEnableLoaderPreempt, aVMDLDataLoaderConfigure.mEnableLoaderPreempt);
        _setIntValue(this.mHandle, KeyIsNextDownloadThreshold, aVMDLDataLoaderConfigure.mNextDownloadThreshold);
        _setIntValue(this.mHandle, KeyIsSetOnlyUseCdn, aVMDLDataLoaderConfigure.mOnlyUseCdn);
        _setIntValue(this.mHandle, KeyIsAccessCheckLevel, aVMDLDataLoaderConfigure.mAccessCheckLevel);
        _setIntValue(this.mHandle, KeyIsEnableSessionReuse, aVMDLDataLoaderConfigure.mEnableSessionReuse);
        _setIntValue(this.mHandle, KeyIsIsMaxTlsVersion, aVMDLDataLoaderConfigure.mMaxTlsVersion);
        _setIntValue(this.mHandle, KeyIsIsCheckPreloadLevel, aVMDLDataLoaderConfigure.mCheckPreloadLevel);
        _setIntValue(this.mHandle, KeyIsLoaderFactoryXYLibValue, aVMDLDataLoaderConfigure.mXYLibValue);
        _setIntValue(this.mHandle, KeyIsEnableP2PPreDown, aVMDLDataLoaderConfigure.mEnableP2PPreDown);
        _setIntValue(this.mHandle, KeyIsEnablePlayLog, aVMDLDataLoaderConfigure.mEnablePlayLog);
        _setIntValue(this.mHandle, KeyIsEnableNetScheduler, aVMDLDataLoaderConfigure.mEnableNetScheduler);
        _setIntValue(this.mHandle, KeyIsEnableCacheReqRange, aVMDLDataLoaderConfigure.mEnableCacheReqRange);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockAllNetErr, aVMDLDataLoaderConfigure.mNetSchedulerBlockAllNetErr);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockErrCount, aVMDLDataLoaderConfigure.mNetSchedulerBlockErrCount);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockDurationMs, aVMDLDataLoaderConfigure.mNetSChedulerBlockDurationMs);
        _setIntValue(this.mHandle, KeyIsFirstRangeLeftThreshold, aVMDLDataLoaderConfigure.mFirstRangeLeftThreshold);
        _setIntValue(this.mHandle, KeyIsSetNetSchedulerBlockHostErrIpCount, aVMDLDataLoaderConfigure.mNetSchedulerBlockHostIpErrCount);
        _setIntValue(this.mHandle, KeyIsMaxFileMemCacheSize, aVMDLDataLoaderConfigure.mMaxFileMemCacheSize);
        _setIntValue(this.mHandle, KeyIsMaxFileMemCacheNum, aVMDLDataLoaderConfigure.mMaxFileMemCacheNum);
        _setIntValue(this.mHandle, 110, aVMDLDataLoaderConfigure.mWriteFileNotifyIntervalMS);
        _setIntValue(this.mHandle, KeyIsP2PPredownPeerCount, aVMDLDataLoaderConfigure.mP2PPreDownPeerCount);
        _setIntValue(this.mHandle, KeyIsP2PFirstRangeLoaderType, aVMDLDataLoaderConfigure.mP2PFirstRangeLoaderType);
        int i7 = aVMDLDataLoaderConfigure.mSocketSendBufferKB;
        if (i7 > 0) {
            _setIntValue(this.mHandle, KeyIsSocketSendBufferKB, i7);
        }
        int i8 = aVMDLDataLoaderConfigure.mRingBufferSizeKB;
        if (i8 > 0) {
            _setIntValue(this.mHandle, KeyIsRingBufferSizeKB, i8);
        }
        _setIntValue(this.mHandle, KeyIsEnableFileCacheV2, aVMDLDataLoaderConfigure.mEnableFileCacheV2);
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mVdpABTestId)) {
            _setStringValue(this.mHandle, KeyIsVdpABTestId, aVMDLDataLoaderConfigure.mVdpABTestId);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mVdpGroupId)) {
            _setStringValue(this.mHandle, KeyIsVdpGroupId, aVMDLDataLoaderConfigure.mVdpGroupId);
        }
        _setIntValue(this.mHandle, KeyIsAlogEnable, aVMDLDataLoaderConfigure.mAlogEnable);
        _setIntValue(this.mHandle, KeyIsEnableSyncDnsForPcdn, aVMDLDataLoaderConfigure.mEnableSyncDnsForPcdn);
        _setIntValue(this.mHandle, KeyIsEnableFileRingBuffer, aVMDLDataLoaderConfigure.mEnableFileRingBuffer);
        _setIntValue(this.mHandle, KeyIsEnableLazyBufferpool, aVMDLDataLoaderConfigure.mEnableLazyBufferpool);
        _setIntValue(this.mHandle, KeyIsEnableNewBufferpool, aVMDLDataLoaderConfigure.mEnableNewBufferpool);
        _setIntValue(this.mHandle, KeyIsNewBufferpoolBlockSize, aVMDLDataLoaderConfigure.mNewBufferPoolBlockSize);
        _setIntValue(this.mHandle, KeyIsNewBufferpoolResidentSize, aVMDLDataLoaderConfigure.mNewBufferPoolResidentSize);
        _setIntValue(this.mHandle, KeyIsNewBufferPoolGrowBlockCount, aVMDLDataLoaderConfigure.mNewBufferPoolGrowBlockCount);
        _setIntValue(this.mHandle, KeyIsEnableUseFileExtendLoaderBuffer, aVMDLDataLoaderConfigure.mEnableUseFileExtendLoaderBuffer);
        _setIntValue(this.mHandle, KeyIsMAXIPV6Num, aVMDLDataLoaderConfigure.mMaxIPV6Num);
        _setIntValue(this.mHandle, KeyIsMAXIPV4Num, aVMDLDataLoaderConfigure.mMaxIPV4Num);
        _setIntValue(this.mHandle, KeyIsForbidByPassCookie, aVMDLDataLoaderConfigure.mForbidByPassCookie);
        _setIntValue(this.mHandle, KeyIsSessionTimeout, aVMDLDataLoaderConfigure.mSessionTimeout);
        _setIntValue(this.mHandle, KeyIsEnablePlayInfoCache, aVMDLDataLoaderConfigure.mEnablePlayInfoCache);
        _setIntValue(this.mHandle, KeyIsIsEnableDownloaderLog, aVMDLDataLoaderConfigure.mEnableDownloaderLog);
        _setIntValue(this.mHandle, KeyIsIsEnableTTNetLoader, aVMDLDataLoaderConfigure.mEnableTTNetLoader);
        _setIntValue(this.mHandle, KeyIsTTNetLoaderCronetBufSizeKB, aVMDLDataLoaderConfigure.mTTNetLoaderCronetBufSizeKB);
        _setIntValue(this.mHandle, KeyIsAllowTryTheLastUrl, aVMDLDataLoaderConfigure.mIsAllowTryTheLastUrl);
        _setIntValue(this.mHandle, KeyIsSetSpeedSampleInterval, aVMDLDataLoaderConfigure.mSpeedSampleInterval);
        _setIntValue(this.mHandle, KeyIsEnableIOManager, aVMDLDataLoaderConfigure.mEnableIOManager);
        _setIntValue(this.mHandle, KeyIsEnableLoaderSeek, aVMDLDataLoaderConfigure.mEnableLoaderSeek);
        _setIntValue(this.mHandle, KeyIsSetGlobalSpeedSampleInterval, aVMDLDataLoaderConfigure.mGlobalSpeedSampleInterval);
        _setIntValue(this.mHandle, KeyIsEnableDynamicSocketTimeout, aVMDLDataLoaderConfigure.mEnableDynamicTimeout);
        _setIntValue(this.mHandle, KeyIsInitialSocketTimeout, aVMDLDataLoaderConfigure.mSocketInitialTimeout);
        _setIntValue(this.mHandle, KeyIsMaxSocketReuseNum, aVMDLDataLoaderConfigure.mMaxSocketReuseCount);
        _setIntValue(this.mHandle, KeyIsSetEnableReportTaskLog, aVMDLDataLoaderConfigure.mEnableReportTaskLog);
        _setInt64Value(this.mHandle, KeyIsLoaderFactoryP2PStragetyLevel, aVMDLDataLoaderConfigure.mP2PStragetyLevel);
        _setInt64Value(this.mHandle, KeyIsConnectPoolStragetyValue, aVMDLDataLoaderConfigure.mConnectPoolStragetyValue);
        _setIntValue(this.mHandle, KeyIsMaxKeepAliveHostNum, aVMDLDataLoaderConfigure.mMaxAliveHostNum);
        _setIntValue(this.mHandle, KeyIsSetFileExtendSize, aVMDLDataLoaderConfigure.mFileExtendSizeKB);
        _setIntValue(this.mHandle, KeyIsSetMinAllowSpeed, aVMDLDataLoaderConfigure.mMinAllowSpeed);
        _setIntValue(this.mHandle, KeyIsSetEnableOwnVdpPreloadNotify, aVMDLDataLoaderConfigure.mEnableOwnVDPPreloadNotify);
        _setIntValue(this.mHandle, KeyIsEnableEarlyData, aVMDLDataLoaderConfigure.mEnableEarlyData);
        _setInt64Value(this.mHandle, KeyIsLoadMonitorMinAllowLoadSize, aVMDLDataLoaderConfigure.mMonitorMinAllowLoadSize);
        _setInt64Value(this.mHandle, KeyIsLoadMonitorTimeInternal, aVMDLDataLoaderConfigure.mMonitorTimeInternal);
        _setStringValue(this.mHandle, KeyIsSocketTrainingCenterConfigStr, aVMDLDataLoaderConfigure.mSocketTraingCenterConfigStr);
        _setStringValue(this.mHandle, KeyIsCacheDirListsStr, aVMDLDataLoaderConfigure.mCacheDirListsStr);
        int i9 = aVMDLDataLoaderConfigure.mEnableEventInfo;
        if (i9 > 0) {
            _setIntValue(this.mHandle, KeyIsEnableEventInfo, i9);
        }
        int i10 = aVMDLDataLoaderConfigure.mEnableStorageModule;
        if (i10 > 0) {
            _setIntValue(this.mHandle, 10000, i10);
            int i11 = aVMDLDataLoaderConfigure.mStoPlayDldWinSizeKBNM;
            if (i11 > 0) {
                _setIntValue(this.mHandle, 10001, i11);
            }
            int i12 = aVMDLDataLoaderConfigure.mStoPlayDldWinSizeKBLS;
            if (i12 > 0) {
                _setIntValue(this.mHandle, 10002, i12);
            }
            int i13 = aVMDLDataLoaderConfigure.mStoRingBufferSizeKB;
            if (i13 > 0) {
                _setIntValue(this.mHandle, 10003, i13);
            }
            int i14 = aVMDLDataLoaderConfigure.mStoIoWriteLimitKBTh1;
            if (i14 > 0) {
                _setIntValue(this.mHandle, 10004, i14);
            }
            int i15 = aVMDLDataLoaderConfigure.mStoIoWriteLimitKBTh2;
            if (i15 > 0) {
                _setIntValue(this.mHandle, 10005, i15);
            }
            int i16 = aVMDLDataLoaderConfigure.mStoMaxIdleTimeSec;
            if (i16 > 0) {
                _setIntValue(this.mHandle, 10006, i16);
            }
        }
        _setIntValue(this.mHandle, KeyIsIgnorePlayInfo, aVMDLDataLoaderConfigure.mIgnorePlayInfo);
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mSettingsDomain)) {
            _setStringValue(this.mHandle, KeyIsSetSettingsDomain, aVMDLDataLoaderConfigure.mSettingsDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mDmDomain)) {
            _setStringValue(this.mHandle, KeyIsSetDMDomain, aVMDLDataLoaderConfigure.mDmDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mForesightDomain)) {
            _setStringValue(this.mHandle, KeyIsSetForesightDomain, aVMDLDataLoaderConfigure.mForesightDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mDomains)) {
            _setStringValue(this.mHandle, KeyIsSetDomains, aVMDLDataLoaderConfigure.mDomains);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mKeyDomain)) {
            _setStringValue(this.mHandle, KeyIsSetKeyDomain, aVMDLDataLoaderConfigure.mKeyDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mKeyToken)) {
            _setStringValue(this.mHandle, KeyIsSetKeyToken, aVMDLDataLoaderConfigure.mKeyToken);
        }
        AVMDLDNSParser.setIntValue(0, this.mConfigure.mDNSMainType);
        AVMDLDNSParser.setIntValue(1, this.mConfigure.mDNSBackType);
        AVMDLDNSParser.setIntValue(2, this.mConfigure.mDefaultExpiredTime);
        AVMDLDNSParser.setIntValue(3, this.mConfigure.mMainToBackUpDelayedTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternal() {
        this.mWriteLock.lock();
        try {
            if (this.mState != 1) {
                initLogThread(this);
                if (this.mHandle != 0) {
                    setConfigureInternal(this.mConfigure);
                    if (_start(this.mHandle) >= 0) {
                        this.mState = 1;
                    }
                }
            }
            this.mWriteLock.unlock();
            if (this.mConfigure.mEnableBenchMarkIOSpeed > 0) {
                int testFileIOSpeed = testFileIOSpeed();
                String.format("test io average speed:%d", Integer.valueOf(testFileIOSpeed));
                if (testFileIOSpeed > 0) {
                    setIntValue(KeyIsMarkedFileIOSpeed, testFileIOSpeed);
                }
            }
            AVMDLStartCompleteListener aVMDLStartCompleteListener = this.mStartCompleteListener;
            if (aVMDLStartCompleteListener != null) {
                aVMDLStartCompleteListener.onStartComplete();
            }
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
    }

    private int testFileIOSpeed() {
        double d6;
        if (TextUtils.isEmpty(this.mConfigure.mCacheDir)) {
            return -1;
        }
        String str = this.mConfigure.mCacheDir;
        String format = str.charAt(str.length() - 1) == '/' ? String.format("%siospeed", this.mConfigure.mCacheDir) : String.format("%s/iospeed", this.mConfigure.mCacheDir);
        File file = new File(format);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(format, "iospeed.cach");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            double d7 = 0.0d;
            double d8 = 0.0d;
            for (int i6 = 0; i6 < 30; i6++) {
                try {
                    d6 = testFileIO(format, i6, randomAccessFile);
                    try {
                        try {
                            String.format("num:%d result:%f", Integer.valueOf(i6), Double.valueOf(d6));
                        } catch (Exception e6) {
                            e = e6;
                            vl.j(e);
                            if (d6 > 0.0d) {
                                try {
                                    d8 += d6;
                                    d7 += 1.0d;
                                } catch (Exception unused) {
                                }
                            }
                        }
                    } catch (Exception e7) {
                        e = e7;
                    }
                } catch (Exception e8) {
                    e = e8;
                    d6 = 0.0d;
                }
                if (d6 > 0.0d && i6 >= 20) {
                    d8 += d6;
                    d7 += 1.0d;
                }
            }
            randomAccessFile.close();
            file2.delete();
            if (d7 > 0.0d) {
                return (int) (d8 / d7);
            }
            return 0;
        } catch (Exception unused2) {
            return -1;
        }
    }

    public static synchronized boolean tryLoadTTNetLoaderPlugin() {
        boolean z5;
        synchronized (AVMDLDataLoader.class) {
            z5 = mIsMdlTtnetPluginLoaded;
        }
        return z5;
    }

    public void cancel(String str) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    _cancel(j6, str);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void cancelAll() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    _cancelAll(j6);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void cancelAllPreloadWaitReqs() {
        if (this.mState != 1) {
            return;
        }
        this.mReadLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    _cancelAllPreloadWaitReqs(j6);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void clearAllCaches() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    _clearAllCaches(j6);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void clearNetinfoCache() {
        if (this.mState != 1) {
            return;
        }
        IPCache.getInstance().clear();
        this.mWriteLock.lock();
        try {
            try {
                _clearNetinfoCache(this.mHandle);
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void close() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    _close(j6);
                    this.mHandle = 0L;
                    this.mState = 5;
                    Handler handler = this.mHandler;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        this.mHandler = null;
                    }
                    Handler handler2 = this.mLogHandler;
                    if (handler2 != null) {
                        handler2.removeCallbacksAndMessages(null);
                        this.mLogHandler.getLooper().quit();
                        this.mLogHandler = null;
                        this.mMsgThread = null;
                    }
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            this.mWriteLock.unlock();
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
    }

    public void downloadResource(String str) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j6 = this.mHandle;
                    if (j6 != 0) {
                        _downloadResource(j6, str);
                    }
                } catch (UnsatisfiedLinkError e6) {
                    vl.j(e6);
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void forceRemoveFileCache(String str) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j6 = this.mHandle;
                    if (j6 != 0) {
                        _forceRemoveCacheFile(j6, str);
                    }
                } catch (UnsatisfiedLinkError e6) {
                    vl.j(e6);
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public long getAllCacheSize() {
        long j6 = -1;
        if (this.mState != 1) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j7 = this.mHandle;
                if (j7 != 0) {
                    j6 = _getLongValue(j7, 100);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            return j6;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getAuth(String str) {
        if (this.mState != 1 || !this.isSupportGetAuth) {
            return null;
        }
        this.mReadLock.lock();
        try {
            return _getAuth(this.mHandle, str);
        } catch (UnsatisfiedLinkError e6) {
            vl.j(e6);
            this.isSupportGetAuth = false;
            return null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getCDNLog(String str) {
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            return _getCDNLog(this.mHandle, str);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public AVMDLFileInfo getCacheInfo(String str) {
        AVMDLFileInfo aVMDLFileInfo = null;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    String[] split = _getStringValueByStr(j6, str, 101).split(",");
                    if (split.length >= 3) {
                        AVMDLFileInfo aVMDLFileInfo2 = new AVMDLFileInfo();
                        try {
                            aVMDLFileInfo2.mFilePath = split[2];
                            if (!TextUtils.isEmpty(split[0])) {
                                aVMDLFileInfo2.mCacheSize = Long.valueOf(split[0]).longValue();
                            }
                            if (!TextUtils.isEmpty(split[1])) {
                                aVMDLFileInfo2.mContentLenght = Long.valueOf(split[1]).longValue();
                            }
                            aVMDLFileInfo = aVMDLFileInfo2;
                        } catch (UnsatisfiedLinkError e6) {
                            e = e6;
                            aVMDLFileInfo = aVMDLFileInfo2;
                            vl.j(e);
                            this.mReadLock.unlock();
                            return aVMDLFileInfo;
                        }
                    }
                }
            } catch (Throwable th) {
                this.mReadLock.unlock();
                throw th;
            }
        } catch (UnsatisfiedLinkError e7) {
            e = e7;
        }
        this.mReadLock.unlock();
        return aVMDLFileInfo;
    }

    public AVMDLDataLoaderConfigure getConfig() {
        if (this.mState != 1) {
            return null;
        }
        return this.mConfigure;
    }

    public long getInt64Value(int i6, long j6) {
        if (i6 != 8003 && i6 != 8004) {
            return j6;
        }
        AVMDLDataLoaderListener aVMDLDataLoaderListener = this.mLiveListener;
        if (aVMDLDataLoaderListener != null) {
            return aVMDLDataLoaderListener.getInt64Value(i6, j6);
        }
        AVMDLLog.e("ttmn", "getInt64Value mLiveListener is nullptr, code: ".concat(String.valueOf(i6)));
        return j6;
    }

    public String getLocalAddr() {
        String str = null;
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    str = _getStringValue(j6, 4);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            return str;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public long getLongValue(int i6) {
        int i7;
        long j6 = -1;
        if (i6 == 7218 || i6 == 7390 || i6 == 9407) {
            long j7 = this.mHandle;
            if (j7 != 0) {
                return _getLongValue(j7, i6);
            }
            return -1L;
        }
        if (this.mState != 1) {
            return -1L;
        }
        if (this.mConfigure == null) {
            return -998L;
        }
        this.mReadLock.lock();
        try {
            try {
                switch (i6) {
                    case KeyIsLiveLoaderEnable /* 8100 */:
                        i7 = this.mConfigure.mLiveLoaderEnable;
                        j6 = i7;
                        break;
                    case KeyIsLiveLoaderP2pEnable /* 8101 */:
                        i7 = this.mConfigure.mLiveP2pAllow;
                        j6 = i7;
                        break;
                    case 8102:
                        i7 = this.mConfigure.mLiveEnableMdlProto;
                        j6 = i7;
                        break;
                    case KeyIsLiveGetLoaderType /* 8103 */:
                        i7 = this.mConfigure.mLiveLoaderType;
                        j6 = i7;
                        break;
                    default:
                        long j8 = this.mHandle;
                        if (j8 != 0) {
                            j6 = _getLongValue(j8, i6);
                            break;
                        }
                        break;
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            this.mReadLock.unlock();
            return j6;
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    public long getLongValueByStr(String str, int i6) {
        long j6 = -1;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return -1L;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j7 = this.mHandle;
                if (j7 != 0) {
                    j6 = _getLongValueByStr(j7, str, i6);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            return j6;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public String getStringValue(int i6) {
        String str = null;
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    str = _getStringValue(j6, i6);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            return str;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getStringValueByStr(String str, int i6) {
        String str2 = null;
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    str2 = _getStringValueByStr(j6, str, i6);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            return str2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getStringValueByStrkey(int i6, long j6, String str) {
        if (this.mState != 1) {
            return null;
        }
        if (i6 != 1503) {
            if ((i6 == 1506 || i6 == 1509) && this.mVodListener != null && !TextUtils.isEmpty(str)) {
                return this.mVodListener.getStringValue(i6, j6, str);
            }
        } else if (this.mVodListener != null && !TextUtils.isEmpty(str)) {
            return this.mVodListener.getCheckSumInfo(str);
        }
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i6 = message.what;
        return (i6 == 12 || i6 == 9) ? postMessage(this.mLiveListener, message) : (i6 == 71 || i6 == 72 || i6 == 73 || i6 == 74) ? postMessage(this.mEventListener, message) : postMessage(this.mVodListener, message);
    }

    public boolean isRunning() {
        return this.mState == 1;
    }

    public void makeFileAutoDeleteFlag(String str, int i6) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j6 = this.mHandle;
                    if (j6 != 0) {
                        _makeFileAutoDeleteFlag(j6, str, i6);
                    }
                } catch (UnsatisfiedLinkError e6) {
                    vl.j(e6);
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void onEventInfo(Object obj) {
        if (this.mState != 1 || this.mLogHandler == null) {
            return;
        }
        LoaderEventInfo loaderEventInfo = new LoaderEventInfo();
        loaderEventInfo.what = 74;
        try {
            HashMap hashMap = (HashMap) obj;
            if (hashMap.containsKey("what")) {
                loaderEventInfo.what = ((Integer) hashMap.get("what")).intValue();
            }
            if (hashMap.containsKey("taskType")) {
                loaderEventInfo.taskType = ((Integer) hashMap.get("taskType")).intValue();
            }
            if (hashMap.containsKey(t0.f49654e)) {
                loaderEventInfo.off = ((Long) hashMap.get(t0.f49654e)).longValue();
            }
            if (hashMap.containsKey("endOff")) {
                loaderEventInfo.endOff = ((Long) hashMap.get("endOff")).longValue();
            }
            if (hashMap.containsKey("fileHash")) {
                loaderEventInfo.fileHash = String.valueOf(hashMap.get("fileHash"));
            }
            if (hashMap.containsKey("bytesLoaded")) {
                loaderEventInfo.bytesLoaded = ((Long) hashMap.get("bytesLoaded")).longValue();
            }
            String valueOf = hashMap.containsKey("headers") ? String.valueOf(hashMap.get("headers")) : "";
            if (valueOf != "") {
                for (String str : valueOf.split(g.f50795q)) {
                    String[] split = str.split(":");
                    loaderEventInfo.mHeaders.put(split[0], split[1]);
                }
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
        Message obtainMessage = this.mLogHandler.obtainMessage();
        obtainMessage.what = loaderEventInfo.what;
        obtainMessage.obj = loaderEventInfo;
        obtainMessage.sendToTarget();
    }

    public void onNotify(int i6, long j6, int i7) {
        if (this.mState != 1 || this.mHandler == null) {
            return;
        }
        AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo = new AVMDLDataLoaderNotifyInfo();
        aVMDLDataLoaderNotifyInfo.what = i6;
        aVMDLDataLoaderNotifyInfo.parameter = j6;
        aVMDLDataLoaderNotifyInfo.code = i7;
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.obj = aVMDLDataLoaderNotifyInfo;
        obtainMessage.what = i6;
        obtainMessage.sendToTarget();
    }

    public void p2pPredown(String str) {
        if (this.mState == 1 && this.mConfigure.mLoaderType > 0) {
            String encodeUrl = encodeUrl(str);
            if (TextUtils.isEmpty(encodeUrl)) {
                return;
            }
            this.mReadLock.lock();
            try {
                _p2pPredown(this.mHandle, encodeUrl);
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                this.mReadLock.unlock();
                throw th;
            }
            this.mReadLock.unlock();
        }
    }

    public void preConnectByHost(String str, int i6) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                _preConnectByHost(this.mHandle, str, i6);
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void preloadGroupResource(String str, String str2, int i6, int i7) {
        if (this.mState != 1 || TextUtils.isEmpty(str2) || i7 == 0) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    _preloadGroupResource(j6, str, str2, i6, i7);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            this.mWriteLock.unlock();
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
    }

    public void removeFileCache(String str) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j6 = this.mHandle;
                    if (j6 != 0) {
                        _removeCacheFile(j6, str);
                    }
                } catch (UnsatisfiedLinkError e6) {
                    vl.j(e6);
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void resumeFileWriteIO() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            if (this.mConfigure.mMaxFileMemCacheSize > 0) {
                _resumeFileWriteIO(this.mHandle);
                this.mConfigure.mMaxFileMemCacheSize = 0;
            }
        } catch (Exception | UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
    }

    public void setConfigure(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) {
        this.mWriteLock.lock();
        try {
            if (this.mState != 1) {
                this.mConfigure = aVMDLDataLoaderConfigure;
                aVMDLDataLoaderConfigure.ParseJsonConfig();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setEventListener(LoaderListener loaderListener) {
        this.mWriteLock.lock();
        try {
            this.mEventListener = loaderListener;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setInt64ValueByStrKey(int i6, String str, long j6) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j7 = this.mHandle;
                if (j7 != 0) {
                    _setInt64ValueByStrKey(j7, i6, str, j6);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            this.mWriteLock.unlock();
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
    }

    public void setIntValue(int i6, int i7) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    _setIntValue(j6, i6, i7);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setLongValue(int i6, long j6) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j7 = this.mHandle;
                if (j7 != 0) {
                    _setInt64Value(j7, i6, j6);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setStartCompleteListener(AVMDLStartCompleteListener aVMDLStartCompleteListener) {
        this.mStartCompleteListener = aVMDLStartCompleteListener;
    }

    public int start() {
        if (this.mState == 1) {
            return 0;
        }
        initNativeHandle();
        new cw(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.2
            @Override // java.lang.Runnable
            public void run() {
                AVMDLDataLoader.this.startInternal();
            }
        }, TAG).start();
        return 0;
    }

    public void stop() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    _stop(j6);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void suspendDownload(String str) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    _suspendedDownload(j6, str);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void tryToClearCachesByUsedTime(long j6) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            long j7 = this.mHandle;
            if (j7 != 0) {
                _clearCachesByUsedTime(j7, j6);
            }
        } catch (UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
    }

    public void updateDNSInfo(String str, String str2, long j6, String str3, int i6) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                _updateDNSInfo(this.mHandle, str, str2, j6, str3, i6);
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            this.mWriteLock.unlock();
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
    }

    private AVMDLDataLoader(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) throws Exception {
        this.mState = -1;
        this.mConfigure = null;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWritedLock = reentrantReadWriteLock;
        this.mMsgThread = null;
        this.isSupportGetAuth = true;
        this.mStartCompleteListener = null;
        initNativeHandle();
        this.mReadLock = reentrantReadWriteLock.readLock();
        this.mWriteLock = reentrantReadWriteLock.writeLock();
        if (this.mHandle != 0) {
            initLogThread(this);
            this.mConfigure = aVMDLDataLoaderConfigure;
            this.mState = 0;
            this.isSupportGetAuth = true;
            return;
        }
        throw new Exception("create native mdl fail");
    }

    private String createFilePathBaseDir(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.charAt(str.length() - 1) == '/') {
                str3 = str + str2;
            } else {
                str3 = str + "/" + str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                File file = new File(str3);
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            return str3;
        }
        return null;
    }

    private String encodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private void hijack() {
        AVMDLDNSParser.processHijack();
        clearNetinfoCache();
    }

    private double testFileIO(String str, int i6, RandomAccessFile randomAccessFile) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return -1.0d;
        }
        long currentTimeMillis = System.currentTimeMillis();
        randomAccessFile.seek(i6);
        byte[] bArr = new byte[4096];
        for (int i7 = 0; i7 < 200; i7++) {
            Thread.sleep(5L);
            randomAccessFile.write(bArr, 0, 1024);
        }
        long currentTimeMillis2 = (System.currentTimeMillis() - currentTimeMillis) - 1000;
        if (currentTimeMillis2 <= 0) {
            return -1.0d;
        }
        String.format("size:%d costtime:%d", 819200, Long.valueOf(currentTimeMillis2));
        return 819200 / currentTimeMillis2;
    }

    public void addDataSource(int i6, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mWriteLock.lock();
        try {
            _addDataSource(this.mHandle, i6, str);
        } catch (Exception | UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
    }

    public void doParseHosts(String[] strArr) {
        AVMDLDNSParser.getInstance().doParseHosts(strArr);
    }

    public void setBackUpIp(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            IPCache.getInstance().putBackUpIp(str, new AVMDLDNSInfo(11, str, str2, 0L, (String) null));
        }
    }

    public void setStringValue(int i6, String str) {
        if (TextUtils.isEmpty(str) || this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    _setStringValue(j6, i6, str);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setListener(int i6, AVMDLDataLoaderListener aVMDLDataLoaderListener) {
        this.mWriteLock.lock();
        if (i6 == 107) {
            try {
                this.mLiveListener = aVMDLDataLoaderListener;
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    private boolean postMessage(LoaderListener loaderListener, Message message) {
        Object obj;
        LoaderEventInfo loaderEventInfo;
        if (loaderListener != null && (obj = message.obj) != null && (loaderEventInfo = (LoaderEventInfo) obj) != null) {
            int i6 = message.what;
            if (i6 == 71) {
                loaderListener.onLoaderTaskStart(loaderEventInfo);
            } else if (i6 == 72) {
                loaderListener.onLoaderTaskCancel(loaderEventInfo);
            } else if (i6 == 73) {
                loaderListener.onLoaderTaskCompleted(loaderEventInfo);
            }
        }
        return true;
    }

    public String getStringCacheInfo(String str, String str2) {
        String str3 = null;
        if (this.mState != 1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    str3 = _getStringValueByStrStr(j6, str, str2, 101);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            return str3;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void preloadResource(String str, int i6, int i7) {
        if (this.mState != 1 || TextUtils.isEmpty(str) || i7 == 0) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j6 = this.mHandle;
                if (j6 != 0) {
                    _preloadResourceWithOffset(j6, str, i6, i7);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public long getCacheSize(String str) {
        long j6 = -1;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j7 = this.mHandle;
                if (j7 != 0) {
                    j6 = _getLongValueByStr(j7, str, 103);
                }
            } catch (UnsatisfiedLinkError e6) {
                vl.j(e6);
            }
            return j6;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public static synchronized int init(boolean z5, boolean z6) {
        synchronized (AVMDLDataLoader.class) {
            try {
                if (mIsLibraryLoaded) {
                    return 0;
                }
                mIsLibraryLoaded = z5;
                if (!z5) {
                    try {
                        m.j("avmdl_lite");
                        mIsLibraryLoaded = true;
                    } catch (UnsatisfiedLinkError e6) {
                        vl.r("ttmn", "Can't load avmdl library: ".concat(String.valueOf(e6)));
                    } catch (Throwable th) {
                        vl.r("ttmn", "other exception when loading avmdl library: ".concat(String.valueOf(th)));
                    }
                    if (z6) {
                        vl.r("ttmn", "try to load pcdn lib");
                        try {
                            m.j("avmdlp2p");
                        } catch (UnsatisfiedLinkError e7) {
                            vl.r("ttmn", "Can't load avmdlp2p library: ".concat(String.valueOf(e7)));
                        } catch (Throwable th2) {
                            vl.r("ttmn", "other exception when loading avmdl library: ".concat(String.valueOf(th2)));
                        }
                    }
                    tryLoadTTNetLoaderPlugin();
                }
                return !mIsLibraryLoaded ? -1 : 0;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLogInfo(int r6, int r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.onLogInfo(int, int, java.lang.String):void");
    }

    public static synchronized int init(boolean z5, boolean z6, boolean z7) {
        synchronized (AVMDLDataLoader.class) {
            if (mIsLibraryLoaded) {
                return 0;
            }
            mIsLibraryLoaded = z5;
            if (!z5) {
                if (z7) {
                    try {
                        m.j("avmdlv2");
                        mIsLibraryLoaded = true;
                    } catch (UnsatisfiedLinkError e6) {
                        vl.r("ttmn", "load avmdlv2 failed: ".concat(String.valueOf(e6)));
                    }
                }
                if (!mIsLibraryLoaded) {
                    try {
                        m.j("avmdl_lite");
                        mIsLibraryLoaded = true;
                    } catch (UnsatisfiedLinkError e7) {
                        vl.r("ttmn", "Can't load avmdl library: ".concat(String.valueOf(e7)));
                    } catch (Throwable th) {
                        vl.r("ttmn", "other exception when loading avmdl library: ".concat(String.valueOf(th)));
                    }
                    if (z6) {
                        vl.r("ttmn", "try to load pcdn lib");
                        try {
                            try {
                                m.j("avmdlp2p");
                            } catch (UnsatisfiedLinkError e8) {
                                vl.r("ttmn", "Can't load avmdlp2p library: ".concat(String.valueOf(e8)));
                            }
                        } catch (Throwable th2) {
                            vl.r("ttmn", "other exception when loading avmdl library: ".concat(String.valueOf(th2)));
                        }
                    }
                    tryLoadTTNetLoaderPlugin();
                }
            }
            return !mIsLibraryLoaded ? -1 : 0;
        }
    }
}
