package com.bykv.vk.component.ttvideo;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import com.baidu.mobads.sdk.internal.ca;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.component.ttvideo.log.LiveLoggerService;
import com.bykv.vk.component.ttvideo.log.LogBundle;
import com.bykv.vk.component.ttvideo.log.MyLog;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener;
import com.bykv.vk.component.ttvideo.medialoader.MediaLoaderWrapper;
import com.bykv.vk.component.ttvideo.model.LiveInfoSource;
import com.bykv.vk.component.ttvideo.model.LiveStreamInfo;
import com.bykv.vk.component.ttvideo.model.LiveURL;
import com.bykv.vk.component.ttvideo.network.DnsHelper;
import com.bykv.vk.component.ttvideo.network.LiveDataFetcher;
import com.bykv.vk.component.ttvideo.player.Keep;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.player.TTPlayerConfiger;
import com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper;
import com.bykv.vk.component.ttvideo.playerwrapper.PlayerSetting;
import com.bykv.vk.component.ttvideo.retry.RetryProcessor;
import com.bykv.vk.component.ttvideo.utils.LiveThreadPool;
import com.bykv.vk.component.ttvideo.utils.LiveUtils;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.component.oq.r.cw;
import com.bytedance.sdk.component.oq.r.r;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.api.plugin.xt;
import com.bytedance.sdk.openadsdk.l.m;
import com.google.android.material.timepicker.TimeModel;
import com.huawei.hms.framework.common.ContainerUtils;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.stub.StubApp;
import com.tencent.bugly.BuglyStrategy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.apache.commons.net.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.misc.IjkMediaFormat;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public final class VideoLiveManager implements ILivePlayer {
    private static final int AUDIOSTREAM = 1;
    private static final int AV_NO_SYNC_THRESHOLD = 10000;
    private static final int BITRATE_ABNORNAL = 1;
    private static final int BITRATE_NORMAL = 0;
    private static final int BOTHSTREAM = 2;
    private static final int CHECK_SEI_INTERVAL = 3000;
    private static final int DEFAULT_RTC_FALLBACK_THRESHOLD = 5000;
    private static final int DEFAULT_RTC_MIN_JITTER_BUFFER = 300;
    private static final String HTTP_FLV_ABR_PREFIX = "mem://llash/";
    private static final int INIT_MTU = 1200;
    public static final int KeyIsGetSeiDelay = 100;
    public static final int KeyIsGetStreamMaxBitrate = 0;
    private static final int LIVE_ABR_CHECK_DEFAULT_INTERVAL = 1000;
    private static final int MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE = 501;
    private static final int MSG_SEI_CHECK = 110;
    private static final int NOTIFY_ALL_SEI_THRESHOLD = 1000;
    private static final String RTC_LOG_PREFIX = "rtc_log_level";
    private static final int RTC_VENDER_TYPE_ALIBABA = 1;
    private static final int RTC_VENDER_TYPE_BYTE = 0;
    private static final int RTC_VENDER_TYPE_OTHERS = 3;
    private static final int RTC_VENDER_TYPE_TECENT = 2;
    private static final String SEI_PREFIX = "JSON";
    private static final int STALL_RECOVER_FROM_BUFFERINGEND = 1;
    private static final int STALL_RECOVER_FROM_RETRY = 2;
    private static final int STALl_NO_RECOVER = 0;
    private static final String TAG = "VideoLiveManager";
    public static final int TEX_LIVE = 1;
    public static final int TEX_VOD = 0;
    private static final int VIDEOSTREAM = 0;
    private static int mAudioRenderStallThreshold = 200;
    private static int mDecoderStallThreshold = 600;
    private static int mDemuxerStallThreshold = 900;
    private static int mFastOpenDuration = -1;
    private static boolean mIsSettingsUpdate = false;
    private static JSONObject mSettingsInfo = null;
    private static int mVideoRenderStallThreshold = 500;
    private int mABRBufferThreshold;
    private int mABRDisableAlgorithm;
    private int mABRMethod;
    private long mALogWriteAddr;
    private int mAVNoSyncThreshold;
    private int mAVPHAudioMaxDuration;
    private int mAVPHAudioProbesize;
    private int mAVPHAutoExit;
    private int mAVPHDnsParseEnable;
    private int mAVPHDnsTimeout;
    private int mAVPHEnableAutoReopen;
    private int mAVPHMaxAVDiff;
    private int mAVPHOpenVideoFirst;
    private int mAVPHReadErrorExit;
    private int mAVPHReadRetryCount;
    private int mAVPHVideoDiffThreshold;
    private int mAVPHVideoMaxDuration;
    private int mAVPHVideoProbesize;
    private String mAbrStrategy;
    private long mAudioLastRenderTime;
    private String mAudioOnly;
    private int mAudioTimescaleEnable;
    private float mAudioVolumeBalancePredelay;
    private float mAudioVolumeBalancePregain;
    private float mAudioVolumeBalanceRatio;
    private float mAudioVolumeBalanceThreshold;
    private int mBufferDataSeconds;
    private int mBufferTimeout;
    private int mByteVC1DecoderType;
    private int mCacheFileEnable;
    private String mCacheFileKey;
    private String mCacheFilePath;
    private boolean mCancelSDKDNSFailRetry;
    private float mCatchSpeed;
    private String mCdnAbrResolution;
    private String mCdnSessionPath;
    private int mCheckBufferingEndAdvanceEnable;
    private int mCheckBufferingEndIgnoreVideo;
    public boolean mCheckSupportSR;
    private boolean mCmafEnable;
    private final Context mContext;
    private String mCurrentIP;
    private String mCurrentPlayURL;
    private int mCurrentRetryCount;
    private int mDefaultCodecId;
    private int mDefaultResBitrate;
    private final DnsHelper mDnsParser;
    private int mEnableAbrStallDegradeImmediately;
    private int mEnableAudioVolumeBalance;
    private String mEnableAvLines;
    private int mEnableByteVC1HardwareDecode;
    private int mEnableCacheSei;
    private int mEnableCheckDropAudio;
    private int mEnableCheckFrame;
    private int mEnableCheckPacketCorrupt;
    private int mEnableCheckSEI;
    private int mEnableClosePlayRetry;
    private int mEnableCmafFastMode;
    private int mEnableCmafOptimizeRetry;
    private int mEnableDTSCheck;
    private int mEnableDecodeMultiSei;
    private int mEnableDecodeSeiOnce;
    private int mEnableDecoderStall;
    private int mEnableDemuxerStall;
    private boolean mEnableDns;
    private boolean mEnableDnsOptimizer;
    private int mEnableDroppingDTSRollFrame;
    private int mEnableFastOpenStream;
    private int mEnableFlvABR;
    private int mEnableFreeFlow;
    private int mEnableH264HardwareDecode;
    private int mEnableHttpPrepare;
    private int mEnableHttpkDegrade;
    private int mEnableHurryFlag;
    private int mEnableLLASHFastOpen;
    private int mEnableLiveAbrCheckEnhance;
    private int mEnableLiveIOP2P;
    private int mEnableLiveIOPlay;
    private int mEnableLowLatencyFLV;
    private int mEnableMediaCodecASYNCInit;
    private int mEnableNTP;
    private int mEnableNTPTask;
    private int mEnableNotifySeiImmediatelyBeforeFirstFrame;
    private int mEnableOpenLiveIO;
    private int mEnableOpenMDL;
    private int mEnableOptimizeBackup;
    private boolean mEnableOriginResolution;
    private int mEnableP2pUp;
    private int mEnablePreventDTSBack;
    private boolean mEnableQuicCertVerify;
    private int mEnableQuicDegrade;
    private int mEnableQuicMTUDiscovery;
    public int mEnableRadioLiveDisableRender;
    private int mEnableRenderStall;
    private int mEnableReportSessionStop;
    private boolean mEnableResolutionAutoDegrade;
    private int mEnableRtcPlay;
    private boolean mEnableSaveSCFG;
    private boolean mEnableSeiCheck;
    private int mEnableSharp;
    public int mEnableSharpen;
    private int mEnableSkipFindUnnecessaryStream;
    private int mEnableSkipFlvNullTag;
    private int mEnableSplitStream;
    private int mEnableStallCounter;
    private int mEnableStallRetryInstantly;
    private boolean mEnableSwitchMainAndBackupUrl;
    private int mEnableTcpFastOpen;
    private int mEnableTextureRender;
    private int mEnableTextureSR;
    private int mEnableUploadSei;
    private boolean mEnableUploadSessionSeries;
    private int mEnableUseLiveThreadPool;
    private int mEnableVideoMpdRefresh;
    private int mEnhancementType;
    private boolean mEnterStallRetryInstantly;
    private ExecutorService mExecutor;
    private LiveDataFetcher mFetcher;
    private int mForceDecodeMsGaps;
    private int mForceDecodeSwitch;
    private boolean mForceHttpDns;
    private int mForceRenderMsGaps;
    private long mFrameDroppingDTSMaxDiff;
    private Object mFrameMetaDataListener;
    private long mFrameTerminatedDTS;
    private int mFramesDrop;
    private long mGetSeiCurrentTime;
    private int mGopDuration;
    private int mHardwareDecodeEnable;
    private int mHardwareRTCDecodeEnable;
    private boolean mHasAbrInfo;
    private boolean mHasRetry;
    private boolean mHasSeiInfo;
    private int mHlsLiveStartIndex;
    private String mHttpDNSServerHost;
    private int mHurryTime;
    private int mHurryType;
    private MyInvocationHandler mInvocationHandler;
    private int mIsAlwaysDoAVSync;
    private boolean mIsCacheHasComplete;
    private int mIsInMainLooper;
    private boolean mIsLiveIOProtoRegister;
    private boolean mIsLocalURL;
    private boolean mIsMdlProtoRegister;
    private boolean mIsPlayWithLiveIO;
    private boolean mIsPlayWithMdl;
    private boolean mIsRequestCanceled;
    private boolean mIsRetrying;
    private boolean mIsStalling;
    private long mLatestAudioPacketDTS;
    private int mLayoutType;
    private String mLevel;
    private final ILiveListener mListener;
    private int mLiveABRCheckInterval;
    private int mLiveIOABGroupID;
    private LivePlayerState mLivePlayerState;
    private String mLocalURL;
    private LiveLoggerService mLogService;
    private boolean mLooping;
    private JSONObject mLowLatencyFLVStrategy;
    private int mMaxCacheSeconds;
    private int mMaxFileCacheSize;
    private int mMaxTextureHeight;
    private int mMaxTextureWidth;
    public boolean mMediaSupportSR;
    private boolean mMediaSupportSharpen;
    private String mMoudleIDToB;
    private final Handler mMyHandler;
    private final INetworkClient mNetworkClient;
    private int mNetworkTimeout;
    private int mNoSyncReportMinDuration;
    private int mNoSyncReportReportThres;
    private List<String> mNodeOptimizeResults;
    private int mOpenCheckSideData;
    private MediaPlayer mPlayer;
    private int mPlayerCache;
    private int mPlayerDegradeMode;
    private final PlayerSetting mPlayerSetting;
    private final int mPlayerType;
    private PlayerState mPrepareState;
    private int mQuicConfigOptimize;
    private boolean mQuicEnable;
    private int mQuicFixProcessTimer;
    private int mQuicFixStreamFinAndRst;
    private int mQuicFixWillingAndAbleToWrite;
    private int mQuicInitMTU;
    private int mQuicInitRtt;
    private int mQuicMaxAckDelay;
    private int mQuicMaxCryptoRetransmissionTimeMs;
    private int mQuicMaxCryptoRetransmissions;
    private int mQuicMaxRetransmissionTimeMs;
    private int mQuicMaxRetransmissions;
    private int mQuicMinReceivedBeforeAckDecimation;
    private int mQuicPadHello;
    private boolean mQuicPull;
    private int mQuicReadBlockMode;
    private int mQuicReadBlockTimeout;
    private int mQuicTimerVersion;
    private int mQuicVersion;
    private boolean mRedoDns;
    private String mReliable;
    public boolean mRenderStartEntered;
    public long mRenderStartNotifyTimeStamp;
    private int mRenderType;
    private String mResolution;
    private boolean mResolutionDisableSR;
    private int mResolutionIndex;
    private final RetryProcessor mRetryProcessor;
    private long mRetryStartTime;
    private int mRtcEarlyInitRender;
    private int mRtcEnableDtls;
    private int mRtcEnableRtcUninitLockFree;
    private int mRtcEnableSDKDns;
    private int mRtcFallbackThreshold;
    private int mRtcMaxJitterBuffer;
    private int mRtcMaxRetryCount;
    private int mRtcMinJitterBuffer;
    private int mRtcPlayFallBack;
    private int mRtcPlayLogInterval;
    private int mRtcSupportMiniSdp;
    private int mScaleType;
    private long mSeiDiffThres;
    private String mSessionId;
    private int mSessionNum;
    private int mSessionReceiveWindow;
    private long mSessionRenderStartTime;
    private long mSessionStartTime;
    private final ILiveSettingBundle mSettingsBundle;
    private float mSharpenAmount;
    private float mSharpenEdgeWeightGamma;
    private int mSharpenMaxHeight;
    private int mSharpenMaxWidth;
    private int mSharpenMode;
    private float mSharpenOverRatio;
    private int mSharpenPowerLevel;
    private int mSharpenSceneMode;
    private JSONObject mSharpenSdkParams;
    private boolean mShowedFirstFrame;
    private float mSlowPlaySpeed;
    private int mSlowPlayTime;
    private int mStallCount;
    private int mStallCountThresOfResolutionDegrade;
    private Handler mStallCounterHandler;
    private int mStallCounterInterval;
    private volatile boolean mStallCounterIsRunning;
    private final Object mStallCounterLock;
    private HandlerThread mStallCounterThread;
    public long mStallRetryTimeIntervalManager;
    private long mStallStartTime;
    private long mStallTotalTime;
    private int mStartDirectAfterPrepared;
    private long mStartPlayBufferThres;
    private String mStreamFormat;
    private int mStreamReceiveWindow;
    private String mSuggestProtocol;
    private boolean mSupportBackupIp;
    public int mSupportSRScene;
    private int mSupportSharpenScene;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private int mSwitchToB;
    private long mTargetOriginBitRate;
    private int mTestAction;
    private String mTextureRenderErrorMsg;
    private boolean mTextureRenderFirstFrame;
    private String mTextureSRBinPath;
    private String mTextureSRDspModuleName;
    public int mTextureSRMode;
    private String mTextureSROclModuleName;
    private String mTransportProtocol;
    private int mTslMinTimeShit;
    private int mTslTimeShift;
    private int mURLAbility;
    private String mURLHost;
    private String mURLProtocol;
    private final LiveInfoSource mURLSource;
    private int mUrlSettingMethod;
    private int mUseExternalDir;
    private boolean mUsePlayerRenderStart;
    private boolean mUserSwitchResoultion;
    private String mUuid;
    private long mVideoLastRenderTime;
    private String mVideoOnly;
    private final VideoStallCountTask mVideoStallCountTask;

    @Keep
    public static final class Builder {
        final Context mContext;
        boolean mEnableResolutionAutoDegrade;
        boolean mEnableSwitchMainAndBackupUrl;
        boolean mForceHttpDns;
        boolean mForceTTNetHttpDns;
        ILiveListener mListener;
        public ExecutorService mLiveThreadPool;
        INetworkClient mNetworkClient;
        int mPlayerType;
        String mProjectKey;
        public long mRTCUploadLogInterval;
        String mResolution;
        int mRetryTimeout;
        public long mSeiCheckTimeOut;
        ILiveSettingBundle mSettingsBundle;
        public long mStallRetryTimeInterval;
        public long mUploadLogInterval;
        String mVideoFormat;

        private Builder(Context context) {
            this.mForceHttpDns = false;
            this.mForceTTNetHttpDns = false;
            this.mRetryTimeout = 60000;
            this.mPlayerType = 1;
            this.mResolution = "origin";
            this.mVideoFormat = LiveConfigKey.FLV;
            this.mEnableResolutionAutoDegrade = false;
            this.mEnableSwitchMainAndBackupUrl = true;
            this.mStallRetryTimeInterval = 10000L;
            this.mUploadLogInterval = 60000L;
            this.mRTCUploadLogInterval = 5000L;
            this.mSeiCheckTimeOut = 8000L;
            this.mLiveThreadPool = null;
            this.mContext = context;
        }

        public VideoLiveManager build() {
            if (this.mContext == null) {
                throw new IllegalArgumentException("mContext should not be null");
            }
            if (this.mListener == null) {
                throw new IllegalArgumentException("mListener should not be null");
            }
            if (this.mNetworkClient != null) {
                return new VideoLiveManager(this);
            }
            throw new IllegalArgumentException("mNetworkClient should not be null");
        }

        public Builder setCustomThreadPool(ExecutorService executorService) {
            MyLog.i(VideoLiveManager.TAG, "setCustomThreadPool: ".concat(String.valueOf(executorService)));
            this.mLiveThreadPool = executorService;
            return this;
        }

        public Builder setEnableResolutionAutoDegrade(boolean z5) {
            this.mEnableResolutionAutoDegrade = z5;
            return this;
        }

        public Builder setEnableSwitchMainAndBackUpURL(boolean z5) {
            this.mEnableSwitchMainAndBackupUrl = z5;
            return this;
        }

        public Builder setForceHttpDns(boolean z5) {
            this.mForceHttpDns = z5;
            return this;
        }

        public Builder setForceTTNetHttpDns(boolean z5) {
            this.mForceTTNetHttpDns = z5;
            return this;
        }

        public Builder setListener(ILiveListener iLiveListener) {
            this.mListener = iLiveListener;
            return this;
        }

        public Builder setNetworkClient(INetworkClient iNetworkClient) {
            this.mNetworkClient = iNetworkClient;
            return this;
        }

        public Builder setPlayerType(int i6) {
            this.mPlayerType = i6;
            return this;
        }

        public Builder setProjectKey(String str) {
            this.mProjectKey = str;
            return this;
        }

        public Builder setResolution(String str) {
            this.mResolution = str;
            return this;
        }

        public Builder setRetryTimeout(int i6) {
            this.mRetryTimeout = i6;
            return this;
        }

        public Builder setSeiCheckTimeOut(long j6) {
            this.mSeiCheckTimeOut = j6;
            return this;
        }

        public Builder setSettingsBundle(ILiveSettingBundle iLiveSettingBundle) {
            this.mSettingsBundle = iLiveSettingBundle;
            return this;
        }

        public Builder setStallRetryInterval(long j6) {
            this.mStallRetryTimeInterval = j6;
            return this;
        }

        public Builder setVideoFormat(String str) {
            this.mVideoFormat = str;
            return this;
        }
    }

    private enum LivePlayerState {
        IDLE,
        PLAYED,
        PAUSED,
        STOPPED
    }

    private static final class MyCompletionListener implements MediaPlayer.OnCompletionListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            MyLog.i(VideoLiveManager.TAG, "onCompletion");
            videoLiveManager.mListener.onCompletion();
            videoLiveManager.mLogService.onPrepare(LiveError.STREAM_DRYUP);
            videoLiveManager.mSupportBackupIp = false;
            if (videoLiveManager.mIsLocalURL) {
                return;
            }
            if (videoLiveManager.mEnableSwitchMainAndBackupUrl && videoLiveManager.mURLSource.getSourceType() == 2 && videoLiveManager.switchMainAndBackupUrl(LiveError.STREAM_DRYUP)) {
                return;
            }
            if (videoLiveManager.mURLSource.getSourceType() == 1 && videoLiveManager.bytevc1DegradeH264(LiveError.STREAM_DRYUP)) {
                return;
            }
            if (videoLiveManager.mCacheFileEnable != 1) {
                videoLiveManager.mRetryProcessor.onError(new LiveError(LiveError.STREAM_DRYUP, "live stream dry up, push stream may occur error", new HashMap()), videoLiveManager.mShowedFirstFrame);
                return;
            }
            videoLiveManager.mListener.onCacheFileCompletion();
            videoLiveManager.mIsCacheHasComplete = true;
            if (!videoLiveManager.mLooping || TextUtils.isEmpty(videoLiveManager.mCacheFilePath)) {
                return;
            }
            videoLiveManager.setLocalURL(videoLiveManager.mCacheFilePath);
            videoLiveManager.setLooping(true);
            videoLiveManager.parsePlayDNS(videoLiveManager.mCacheFilePath);
        }

        public MyCompletionListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }
    }

    private static final class MyErrorListener implements MediaPlayer.OnErrorListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i6, int i7) {
            MyLog.e(VideoLiveManager.TAG, "onError ".concat(String.valueOf(i6)));
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager != null && videoLiveManager.mPlayer != null) {
                if (i6 != 0) {
                    videoLiveManager.mLogService.onPrepare(i6);
                }
                videoLiveManager.mListener.onError(new LiveError(i6, "player on error", null));
                if (videoLiveManager.mIsLocalURL) {
                    return true;
                }
                if (videoLiveManager.mEnableQuicDegrade == 1 && videoLiveManager.QuicDegrade(i6)) {
                    return true;
                }
                if (videoLiveManager.mEnableHttpkDegrade == 1 && videoLiveManager.HttpKDegradeHttp(i6)) {
                    return true;
                }
                if (!(videoLiveManager.mEnableRtcPlay == 1 && videoLiveManager.mRtcPlayFallBack == 0) && videoLiveManager.mEnableSwitchMainAndBackupUrl && videoLiveManager.mURLSource.getSourceType() == 2 && videoLiveManager.switchMainAndBackupUrl(i6)) {
                    return true;
                }
                if (videoLiveManager.mURLSource.getSourceType() == 1 && videoLiveManager.bytevc1DegradeH264(i6)) {
                    return true;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("internalCode", Integer.valueOf(i6));
                hashMap.put("internalExtra", Integer.valueOf(i7));
                hashMap.put("playerType", Integer.valueOf(mediaPlayer.getPlayerType()));
                videoLiveManager.mRetryProcessor.onError(new LiveError(-100003, "player on error", hashMap), videoLiveManager.mShowedFirstFrame);
            }
            return false;
        }

        public MyErrorListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }
    }

    private static final class MyFetcherCompletionListener implements LiveDataFetcher.OnCompletionListener {
        private final String mLiveInfoAPI;
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        @Override // com.bykv.vk.component.ttvideo.network.LiveDataFetcher.OnCompletionListener
        public void onCompletion(final LiveStreamInfo liveStreamInfo) {
            final VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return;
            }
            videoLiveManager.runOnCurrentThread(new Runnable() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.MyFetcherCompletionListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (videoLiveManager.mPlayer == null || videoLiveManager.mRetryProcessor == null) {
                        return;
                    }
                    if (liveStreamInfo == null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("liveAPI", MyFetcherCompletionListener.this.mLiveInfoAPI);
                        videoLiveManager.mRetryProcessor.onError(new LiveError(LiveError.LIVE_DATA_EMPTY, "live data is null", hashMap), videoLiveManager.mShowedFirstFrame);
                        return;
                    }
                    videoLiveManager.mURLSource.setStreamInfo(liveStreamInfo);
                    String playURLForResolution = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
                    if (playURLForResolution != null) {
                        videoLiveManager.parsePlayDNS(playURLForResolution);
                        return;
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("liveAPI", MyFetcherCompletionListener.this.mLiveInfoAPI);
                    videoLiveManager.mRetryProcessor.onError(new LiveError(LiveError.LIVE_DATA_EMPTY, "play url is null", hashMap2), videoLiveManager.mShowedFirstFrame);
                }
            });
        }

        @Override // com.bykv.vk.component.ttvideo.network.LiveDataFetcher.OnCompletionListener
        public void onError(final LiveError liveError) {
            final VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return;
            }
            videoLiveManager.runOnCurrentThread(new Runnable() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.MyFetcherCompletionListener.2
                @Override // java.lang.Runnable
                public void run() {
                    if (videoLiveManager.mPlayer == null || videoLiveManager.mRetryProcessor == null) {
                        return;
                    }
                    videoLiveManager.mRetryProcessor.onError(liveError, videoLiveManager.mShowedFirstFrame);
                }
            });
        }

        public MyFetcherCompletionListener(VideoLiveManager videoLiveManager, String str) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
            this.mLiveInfoAPI = str;
        }
    }

    private static final class MyMediaLoaderListener implements MediaLoaderListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public long getInt64Value(int i6, long j6) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            return (videoLiveManager == null || videoLiveManager.mPlayer == null || i6 != 0) ? j6 : videoLiveManager.mLogService.getInt64Value(i6, j6);
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onDataLoaderError(int i6, String str) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mLogService.onLoaderError(i6, str);
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onSwitchLoaderType(int i6, String str) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mLogService.onLoaderSwitch(i6, str);
        }

        public MyMediaLoaderListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onLogInfo(int i6, String str, JSONObject jSONObject) {
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onNotify(int i6, long j6, long j7, String str) {
        }
    }

    private static class MyOnVideoSizeChangedListener implements MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i6, int i7) {
            MyLog.i(VideoLiveManager.TAG, "onVideoSizeChanged, width: " + i6 + ", height: " + i7);
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null || videoLiveManager.mListener == null) {
                return;
            }
            videoLiveManager.mListener.onVideoSizeChanged(i6, i7);
            videoLiveManager.mLogService.onVideoSizeChanged(i6, i7);
        }

        public MyOnVideoSizeChangedListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }
    }

    private static final class MyPreparedListener implements MediaPlayer.OnPreparedListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPrepareState != PlayerState.PREPARING || videoLiveManager.mPlayer == null) {
                return;
            }
            PlayerState unused = videoLiveManager.mPrepareState;
            videoLiveManager.mLogService.onPrepareEnd();
            videoLiveManager.mPrepareState = PlayerState.PREPARED;
            if (videoLiveManager.mStartDirectAfterPrepared == 0) {
                videoLiveManager.mPlayer.start();
            }
            videoLiveManager.mListener.onPrepared();
        }

        public MyPreparedListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }
    }

    private static class MyReleaseRunnable implements Runnable {
        private MediaPlayer mPlayer;

        @Override // java.lang.Runnable
        public void run() {
            if (this.mPlayer != null) {
                try {
                    MyLog.i(VideoLiveManager.TAG, "MyReleaseRunnable release");
                    this.mPlayer.release();
                    this.mPlayer = null;
                } catch (Exception e6) {
                    MyLog.i(VideoLiveManager.TAG, e6.toString());
                }
            }
        }

        public MyReleaseRunnable(MediaPlayer mediaPlayer) {
            this.mPlayer = mediaPlayer;
        }
    }

    private static final class MyRetryListener implements RetryProcessor.RetryListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onRTCFallBack() {
            String str;
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mIsRetrying = true;
            MyLog.i(VideoLiveManager.TAG, "onRTCFallBack");
            videoLiveManager._stopPlayer();
            if (videoLiveManager.mCurrentRetryCount < videoLiveManager.mRtcMaxRetryCount) {
                videoLiveManager.mCurrentRetryCount++;
            } else {
                videoLiveManager.mRtcPlayFallBack = 1;
                videoLiveManager.mLogService.mRtcPlayFallBack = 1;
                videoLiveManager.mURLSource.setRtcFallback(1);
                if (videoLiveManager.mShowedFirstFrame) {
                    videoLiveManager.mLogService.mFallbackType = 2;
                } else {
                    if (videoLiveManager.mRtcSupportMiniSdp == 1) {
                        videoLiveManager.mRtcSupportMiniSdp = 0;
                        videoLiveManager.mLogService.mEnableMiniSdp = 0;
                    }
                    videoLiveManager.mLogService.mFallbackType = 1;
                }
            }
            if (videoLiveManager.mURLSource.getSourceType() == 1) {
                str = videoLiveManager.mURLSource.getNextURL();
            } else if (videoLiveManager.mURLSource.getSourceType() == 2) {
                str = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
            } else {
                str = null;
            }
            MyLog.i(VideoLiveManager.TAG, "onRTCFallBack url: " + str + ",mCurrentRetryCount:" + videoLiveManager.mCurrentRetryCount);
            videoLiveManager.mLogService.onSwitchURL(str);
            if (videoLiveManager.mPrepareState == PlayerState.PREPARED) {
                videoLiveManager.parsePlayDNS(str);
            } else {
                videoLiveManager._resetPlayer();
                videoLiveManager.parsePlayDNS(str);
            }
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onReportOutToApplication(LiveError liveError) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            MyLog.i(VideoLiveManager.TAG, "onReportOutToApplication");
            videoLiveManager.mListener.onError(liveError);
            videoLiveManager.mFetcher.cancel();
            videoLiveManager.mRetryProcessor.reset();
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onRetryNextPlayURL() {
            String str;
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            MyLog.i(VideoLiveManager.TAG, "onRetryNextPlayURL");
            videoLiveManager.updateDownloadSizeStat();
            videoLiveManager.mLogService.onSessionStop();
            videoLiveManager.mIsRetrying = true;
            if (videoLiveManager.mURLSource.getSourceType() == 1) {
                str = videoLiveManager.mURLSource.getNextURL();
            } else if (videoLiveManager.mURLSource.getSourceType() == 2) {
                str = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
            } else {
                str = null;
            }
            videoLiveManager.mLogService.onSwitchURL(str);
            if (!videoLiveManager.mHasRetry) {
                videoLiveManager.mHasRetry = true;
                videoLiveManager.mLogService.setWaitTime(videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 0L));
            }
            videoLiveManager._stopPlayer();
            videoLiveManager.mLogService.mSessionStartTime = System.currentTimeMillis();
            if (videoLiveManager.mPrepareState == PlayerState.PREPARED) {
                videoLiveManager.parsePlayDNS(str);
            } else {
                videoLiveManager._resetPlayer();
                videoLiveManager.parsePlayDNS(str);
            }
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onRetryResetPlayer(boolean z5) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.updateDownloadSizeStat();
            videoLiveManager.mLogService.onSessionStop();
            videoLiveManager.getLastRenderTime();
            videoLiveManager.mIsRetrying = true;
            MyLog.i(VideoLiveManager.TAG, "onRetryResetPlayer ".concat(String.valueOf(z5)));
            if (!videoLiveManager.mHasRetry) {
                videoLiveManager.mHasRetry = true;
                videoLiveManager.mLogService.setWaitTime(videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 0L));
            }
            videoLiveManager._stopPlayer();
            String str = null;
            if (videoLiveManager.mURLSource.getSourceType() == 1) {
                if (videoLiveManager.mURLSource.getPlayLiveURL() != null) {
                    str = videoLiveManager.mURLSource.getPlayLiveURL().mainURL;
                }
            } else if (videoLiveManager.mURLSource.getSourceType() == 2) {
                str = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
            }
            MyLog.i(VideoLiveManager.TAG, "retry url: ".concat(String.valueOf(str)));
            videoLiveManager.mLogService.onSwitchURL(str);
            boolean z6 = videoLiveManager.mURLSource.getSourceType() == 2 && videoLiveManager.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && videoLiveManager.mResolution.equals("auto");
            videoLiveManager.mRetryStartTime = System.currentTimeMillis();
            videoLiveManager.mLogService.mSessionStartTime = System.currentTimeMillis();
            if (videoLiveManager.mPrepareState == PlayerState.PREPARED) {
                if (videoLiveManager.mEnableAbrStallDegradeImmediately == 1 || !z6 || (z6 && !videoLiveManager.abrDegradeResolution())) {
                    videoLiveManager.parsePlayDNS(str);
                    return;
                }
                return;
            }
            videoLiveManager._resetPlayer();
            if (videoLiveManager.mEnableAbrStallDegradeImmediately == 1 || !z6 || (z6 && !videoLiveManager.abrDegradeResolution())) {
                videoLiveManager.parsePlayDNS(str);
            }
        }

        public MyRetryListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }
    }

    private static class NamedThreadFactory implements ThreadFactory {
        private NamedThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            cw cwVar = new cw(runnable, VideoLiveManager.TAG);
            cwVar.setPriority(10);
            return cwVar;
        }
    }

    private class PlayCacheSyncRunner implements Runnable {
        static final long CacheThreadshold = 5000;
        static final long LongDelay = 500;
        static final long ShortDelay = 300;
        boolean mIsLiveIO;
        String mMdlTaskSessionId;
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public PlayCacheSyncRunner(VideoLiveManager videoLiveManager, String str, boolean z5) {
            this.mIsLiveIO = false;
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
            this.mMdlTaskSessionId = str;
            this.mIsLiveIO = z5;
        }

        private long getPlayCache() {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return -1L;
            }
            long longOption = videoLiveManager.mPlayer.getLongOption(73, -1L);
            long longOption2 = videoLiveManager.mPlayer.getLongOption(72, -1L);
            if (longOption >= 0 && longOption2 >= 0) {
                return Math.min(longOption, longOption2);
            }
            if (longOption >= 0) {
                return longOption;
            }
            if (longOption2 >= 0) {
                return longOption2;
            }
            return -1L;
        }

        private void nextround(long j6) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return;
            }
            videoLiveManager.runOnCurrentThreadDelay(VideoLiveManager.this.new PlayCacheSyncRunner(videoLiveManager, this.mMdlTaskSessionId, this.mIsLiveIO), j6);
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || (str = this.mMdlTaskSessionId) == null || !str.equals(videoLiveManager.mSessionId) || this.mMdlTaskSessionId.isEmpty()) {
                return;
            }
            if (videoLiveManager.mLivePlayerState != LivePlayerState.PLAYED) {
                nextround(LongDelay);
                return;
            }
            long playCache = getPlayCache();
            if (playCache == -1) {
                nextround(LongDelay);
                return;
            }
            if (!this.mIsLiveIO) {
                MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(AVMDLDataLoader.KeyIsPlayInfoCurrentBuffer, videoLiveManager.mSessionId, (int) playCache);
            }
            String unused = videoLiveManager.mSessionId;
            if (playCache > 5000) {
                nextround(LongDelay);
            } else {
                nextround(ShortDelay);
            }
        }
    }

    private enum PlayerState {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED
    }

    private class VideoStallCountTask implements Runnable {
        private VideoStallCountTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (VideoLiveManager.this.mStallCounterLock) {
                try {
                    if (VideoLiveManager.this.mStallCounterIsRunning && VideoLiveManager.this.mPlayer != null) {
                        long uptimeMillis = SystemClock.uptimeMillis() + VideoLiveManager.this.mStallCounterInterval;
                        long longOption = VideoLiveManager.this.mPlayer.getLongOption(381, 0L);
                        long longOption2 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 0L);
                        long longOption3 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 0L);
                        long longOption4 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_500, 0L);
                        long longOption5 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500, 0L);
                        long longOption6 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500, 0L);
                        long longOption7 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500, 0L);
                        if ((longOption != 0 || longOption2 != 0 || longOption3 != 0 || longOption4 != 0 || longOption5 != 0 || longOption6 != 0 || longOption7 != 0) && VideoLiveManager.this.mLogService != null) {
                            VideoLiveManager.this.mLogService.onVideoStallCounter(longOption, longOption2, longOption3, longOption4, longOption5, longOption6, longOption7);
                        }
                        if (VideoLiveManager.this.mStallCounterHandler != null) {
                            VideoLiveManager.this.mStallCounterHandler.postAtTime(this, uptimeMillis);
                        }
                    }
                } finally {
                }
            }
        }
    }

    private void _configLiveSettingBundle() {
        Float valueOf = Float.valueOf(-1.0f);
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle == null) {
            return;
        }
        this.mEnableCheckDropAudio = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_enable_check_drop_audio", 0)).intValue();
        this.mRenderType = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_option_render_type", 3)).intValue();
        this.mEnableCmafFastMode = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_cmaf_fast_mode", 0)).intValue();
        this.mStartPlayBufferThres = ((Long) this.mSettingsBundle.getSettingsValueForKey("live_start_play_buffer_thres", 0L)).longValue();
        this.mCheckBufferingEndIgnoreVideo = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_check_buffering_end_ignore_video", 0)).intValue();
        this.mStartDirectAfterPrepared = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_direct_start_after_prepared", 0)).intValue();
        this.mCheckBufferingEndAdvanceEnable = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_check_buffering_end_advance", 0)).intValue();
        if (!this.mHasAbrInfo) {
            this.mEnableResolutionAutoDegrade = ((Boolean) this.mSettingsBundle.getSettingsValueForKey("live_enable_resolution_degrade", Boolean.FALSE)).booleanValue();
            this.mStallCountThresOfResolutionDegrade = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_stall_count_thres_for_degrade", 4)).intValue();
        }
        MyLog.i(TAG, "mEnableResolutionAutoDegrade:" + this.mEnableResolutionAutoDegrade + " mStallCountThresOfResolutionDegrade:" + this.mStallCountThresOfResolutionDegrade);
        this.mEnableOpenMDL = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_open_mdl_enable", 0)).intValue();
        StringBuilder sb = new StringBuilder("enable mdl:");
        sb.append(this.mEnableOpenMDL);
        MyLog.i(TAG, sb.toString());
        this.mEnableTcpFastOpen = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_tcp_fast_open", 0)).intValue();
        MyLog.i(TAG, "enable tfo:" + this.mEnableTcpFastOpen);
        this.mEnableCheckPacketCorrupt = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_check_packet_corrupt", 0)).intValue();
        this.mEnableFlvABR = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_flv_abr", 0)).intValue();
        ILiveSettingBundle iLiveSettingBundle2 = this.mSettingsBundle;
        Boolean bool = Boolean.FALSE;
        this.mForceHttpDns = ((Boolean) iLiveSettingBundle2.getSettingsValueForKey("live_sdk_http_dns_enabled", bool)).booleanValue();
        this.mHttpDNSServerHost = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_http_dns_server_host", "null");
        this.mLogService.mEnableHttpDns = this.mForceHttpDns;
        MyLog.i(TAG, "enable http dns:" + this.mForceHttpDns + " http dns server: " + this.mHttpDNSServerHost);
        this.mLogService.mHostNTPUrl = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_ntp_server_name", "null");
        this.mCancelSDKDNSFailRetry = ((Boolean) this.mSettingsBundle.getSettingsValueForKey("live_sdk_cancel_sdk_dns_fail_retry", bool)).booleanValue();
        this.mEnableClosePlayRetry = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_close_play_retry", 0)).intValue();
        this.mEnableOptimizeBackup = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_optimize_backup_enabled", 0)).intValue();
        MyLog.i(TAG, "enable optimize backup ip:" + this.mEnableOptimizeBackup);
        this.mEnableStallRetryInstantly = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_stall_retry_instantly_enabled", 1)).intValue();
        this.mEnableAudioVolumeBalance = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_enable", 0)).intValue();
        this.mAudioVolumeBalancePregain = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_pregain", valueOf)).floatValue();
        this.mAudioVolumeBalanceThreshold = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_threshold", valueOf)).floatValue();
        this.mAudioVolumeBalanceRatio = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_ratio", valueOf)).floatValue();
        this.mAudioVolumeBalancePredelay = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_predelay", valueOf)).floatValue();
        MyLog.i(TAG, "audio balance:" + this.mEnableAudioVolumeBalance + "," + this.mAudioVolumeBalancePregain + "," + this.mAudioVolumeBalanceThreshold + "," + this.mAudioVolumeBalanceRatio + "," + this.mAudioVolumeBalancePredelay);
        this.mEnableCacheSei = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_sei_pts_synced", 0)).intValue();
        StringBuilder sb2 = new StringBuilder("enable sei pts sync:");
        sb2.append(this.mEnableCacheSei);
        MyLog.i(TAG, sb2.toString());
        this.mStallRetryTimeIntervalManager = ((Long) this.mSettingsBundle.getSettingsValueForKey("stall_retry_time_interval_manager", 10000L)).longValue();
        this.mEnableDecodeMultiSei = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_decode_multi_sei", 0)).intValue();
        this.mEnableRadioLiveDisableRender = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_radiolive_disable_render", 0)).intValue();
        this.mEnableOpenLiveIO = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_liveio", 0)).intValue();
        this.mEnableDecodeSeiOnce = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_decode_sei_once", 0)).intValue();
        ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_notify_sei_immediately_before_first_frame_enabled", 0)).intValue();
        this.mEnableNotifySeiImmediatelyBeforeFirstFrame = 1;
        this.mEnableDroppingDTSRollFrame = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_dropping_dts_rollback_frame_enabled", 0)).intValue();
        String str = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_low_latency_flv_default_strategy_map", "");
        if (str.length() > 0) {
            try {
                this.mLowLatencyFLVStrategy = new JSONObject(str);
            } catch (JSONException e6) {
                this.mLowLatencyFLVStrategy = null;
                vl.j(e6);
                MyLog.e(TAG, "strategy settings invalid");
            }
        }
    }

    private void _configWithSDKParams() {
        String str;
        ILiveSettingBundle iLiveSettingBundle;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String sDKParams = this.mURLSource.getSDKParams(this.mResolution, this.mLevel);
        if (sDKParams != null) {
            try {
                JSONObject jSONObject4 = new JSONObject(sDKParams);
                if (this.mHasAbrInfo || !jSONObject4.has("Auto") || (jSONObject2 = jSONObject4.getJSONObject("Auto")) == null) {
                    str = "AVPHAudioMaxDuration";
                } else {
                    if (jSONObject2.has("Enable")) {
                        str = "AVPHAudioMaxDuration";
                        this.mEnableResolutionAutoDegrade = jSONObject2.optInt("Enable") == 1;
                    } else {
                        str = "AVPHAudioMaxDuration";
                    }
                    if (jSONObject2.has("Demotion") && (jSONObject3 = jSONObject2.getJSONObject("Demotion")) != null && jSONObject3.has("StallCount")) {
                        this.mStallCountThresOfResolutionDegrade = jSONObject3.getInt("StallCount");
                    }
                }
                if (jSONObject4.has("vbitrate")) {
                    this.mDefaultResBitrate = jSONObject4.optInt("vbitrate");
                }
                if (jSONObject4.has("FramesDrop")) {
                    this.mFramesDrop = jSONObject4.optInt("FramesDrop");
                }
                if (jSONObject4.has("AVPHDnsParseEnable")) {
                    this.mAVPHDnsParseEnable = jSONObject4.optInt("AVPHDnsParseEnable");
                }
                if (jSONObject4.has("AVPHDnsTimeout")) {
                    this.mAVPHDnsTimeout = jSONObject4.optInt("AVPHDnsTimeout");
                }
                if (jSONObject4.has("AVPHVideoProbesize")) {
                    this.mAVPHVideoProbesize = jSONObject4.optInt("AVPHVideoProbesize");
                }
                if (jSONObject4.has("AVPHVideoMaxDuration")) {
                    this.mAVPHVideoMaxDuration = jSONObject4.optInt("AVPHVideoMaxDuration");
                }
                if (jSONObject4.has("AVPHAudioProbesize")) {
                    this.mAVPHAudioProbesize = jSONObject4.optInt("AVPHAudioProbesize");
                }
                String str2 = str;
                if (jSONObject4.has(str2)) {
                    this.mAVPHAudioMaxDuration = jSONObject4.optInt(str2);
                }
                if (jSONObject4.has("AVPHOpenVideoFirst")) {
                    this.mAVPHOpenVideoFirst = jSONObject4.optInt("AVPHOpenVideoFirst");
                }
                if (jSONObject4.has("AVPHMaxAVDiff")) {
                    this.mAVPHMaxAVDiff = jSONObject4.optInt("AVPHMaxAVDiff");
                }
                if (jSONObject4.has("AVPHAutoExit")) {
                    this.mAVPHAutoExit = jSONObject4.optInt("AVPHAutoExit");
                }
                if (jSONObject4.has("AVPHAutoReopen")) {
                    this.mAVPHEnableAutoReopen = jSONObject4.optInt("AVPHAutoReopen");
                }
                if (jSONObject4.has("AVPHVideoDiffThreshold")) {
                    this.mAVPHVideoDiffThreshold = jSONObject4.optInt("AVPHVideoDiffThreshold");
                }
                if (jSONObject4.has("AVPHReadRetryCount")) {
                    this.mAVPHReadRetryCount = jSONObject4.optInt("AVPHReadRetryCount");
                }
                if (jSONObject4.has("AVPHReadErrorExit")) {
                    this.mAVPHReadErrorExit = jSONObject4.optInt("AVPHReadErrorExit");
                }
                if (jSONObject4.has("EnableSkipFindUnnecessaryStream")) {
                    this.mEnableSkipFindUnnecessaryStream = jSONObject4.optInt("EnableSkipFindUnnecessaryStream");
                }
                if (jSONObject4.has("EnableRenderStall")) {
                    this.mEnableRenderStall = jSONObject4.optInt("EnableRenderStall");
                }
                if (jSONObject4.has("VideoRenderStallThreshold")) {
                    mVideoRenderStallThreshold = jSONObject4.optInt("VideoRenderStallThreshold");
                }
                if (jSONObject4.has("AudioRenderStallThreshold")) {
                    mAudioRenderStallThreshold = jSONObject4.optInt("AudioRenderStallThreshold");
                }
                if (jSONObject4.has("EnableDemuxerStall")) {
                    this.mEnableDemuxerStall = jSONObject4.optInt("EnableDemuxerStall");
                }
                if (jSONObject4.has("EnableDecoderStall")) {
                    this.mEnableDecoderStall = jSONObject4.optInt("EnableDecoderStall");
                }
                if (jSONObject4.has("DemuxerStallThreshold")) {
                    mDemuxerStallThreshold = jSONObject4.optInt("DemuxerStallThreshold");
                }
                if (jSONObject4.has("DecoderStallThreshold")) {
                    mDecoderStallThreshold = jSONObject4.optInt("DecoderStallThreshold");
                }
                if (jSONObject4.has("StallCounter") && (jSONObject = jSONObject4.getJSONObject("StallCounter")) != null) {
                    if (jSONObject.has("Enable")) {
                        this.mEnableStallCounter = jSONObject.optInt("Enable");
                    }
                    if (jSONObject.has("TimeInterval")) {
                        this.mStallCounterInterval = jSONObject.optInt("TimeInterval");
                    }
                }
                if (jSONObject4.has("DTSCheckEnabled")) {
                    this.mEnableDTSCheck = jSONObject4.optInt("DTSCheckEnabled");
                }
                if (jSONObject4.has("DroppingRepeatingDataEnabled")) {
                    this.mEnablePreventDTSBack = jSONObject4.optInt("DroppingRepeatingDataEnabled");
                }
                if (jSONObject4.has("DroppingRepeatingDataDTSMaxDiff")) {
                    this.mFrameDroppingDTSMaxDiff = jSONObject4.optLong("DroppingRepeatingDataDTSMaxDiff");
                }
                if (jSONObject4.has("EnableSaveSCFG")) {
                    this.mEnableSaveSCFG = jSONObject4.optInt("EnableSaveSCFG") == 1;
                }
                if (jSONObject4.has("EnableVideoMpdRefresh")) {
                    this.mEnableVideoMpdRefresh = jSONObject4.optInt("EnableVideoMpdRefresh");
                }
                if (jSONObject4.has("TransInfoCheck")) {
                    JSONObject optJSONObject3 = jSONObject4.optJSONObject("TransInfoCheck");
                    if (optJSONObject3.has("Enabled")) {
                        this.mEnableCheckFrame = optJSONObject3.optInt("Enabled");
                    }
                }
                if (jSONObject4.has("SEICheck")) {
                    JSONObject optJSONObject4 = jSONObject4.optJSONObject("SEICheck");
                    if (optJSONObject4.has("Enabled")) {
                        this.mEnableCheckSEI = optJSONObject4.optInt("Enabled");
                        if (optJSONObject4.optInt("Enabled") == 1 || this.mLogService != null) {
                            this.mLogService.enableCheckSei();
                        }
                    }
                }
                if (jSONObject4.has("EnableCacheSei")) {
                    this.mEnableCacheSei = jSONObject4.optInt("EnableCacheSei");
                }
                if (jSONObject4.has("gop")) {
                    this.mGopDuration = jSONObject4.optInt("gop");
                }
                if (jSONObject4.has("EnableLLASHFastOpen")) {
                    this.mEnableLLASHFastOpen = jSONObject4.optInt("EnableLLASHFastOpen");
                }
                if (jSONObject4.has("EnableABRCheckEnhance")) {
                    this.mEnableLiveAbrCheckEnhance = jSONObject4.optInt("EnableABRCheckEnhance");
                }
                if (jSONObject4.has("ABRCheckInterval")) {
                    this.mLiveABRCheckInterval = jSONObject4.optInt("ABRCheckInterval");
                }
                if (jSONObject4.has("ABRMethod")) {
                    this.mABRMethod = jSONObject4.optInt("ABRMethod");
                }
                if (jSONObject4.has("ABRBufferThreshold")) {
                    this.mABRBufferThreshold = jSONObject4.optInt("ABRBufferThreshold");
                }
                if (jSONObject4.has("MaxCacheSeconds")) {
                    this.mMaxCacheSeconds = jSONObject4.optInt("MaxCacheSeconds");
                }
                if (jSONObject4.has("MainBackupSwitch")) {
                    JSONObject optJSONObject5 = jSONObject4.optJSONObject("MainBackupSwitch");
                    if (optJSONObject5.has("Enabled")) {
                        if (optJSONObject5.optInt("Enabled") == 0) {
                            this.mEnableSwitchMainAndBackupUrl = false;
                        } else {
                            this.mEnableSwitchMainAndBackupUrl = true;
                        }
                    }
                }
                if (jSONObject4.has("MinTimeShift")) {
                    this.mTslMinTimeShit = jSONObject4.optInt("MinTimeShift");
                }
                if (jSONObject4.has("TargetOriginBitRate")) {
                    this.mTargetOriginBitRate = jSONObject4.optInt("TargetOriginBitRate");
                }
                if (jSONObject4.has("AbrStallDegradeImmediately")) {
                    this.mEnableAbrStallDegradeImmediately = jSONObject4.optInt("AbrStallDegradeImmediately");
                }
                if (jSONObject4.has("HASSessionPath")) {
                    this.mCdnSessionPath = jSONObject4.optString("HASSessionPath");
                }
                if (jSONObject4.has("DecodeSEIEnabled")) {
                    this.mEnableUploadSei = jSONObject4.optInt("DecodeSEIEnabled");
                }
                if (jSONObject4.has("NetworkAdapt")) {
                    JSONObject jSONObject5 = new JSONObject(jSONObject4.optString("NetworkAdapt"));
                    if (jSONObject5.has("Enabled")) {
                        int optInt = jSONObject5.optInt("Enabled");
                        this.mEnableHurryFlag = optInt;
                        if (optInt == 1) {
                            this.mHurryType = 0;
                        }
                        if (jSONObject5.has("HurryTime")) {
                            int optInt2 = jSONObject5.optInt("HurryTime");
                            this.mHurryTime = optInt2;
                            this.mPlayer.setIntOption(15, optInt2);
                        }
                        if (jSONObject5.has("HurryMillisecond")) {
                            int optInt3 = jSONObject5.optInt("HurryMillisecond");
                            this.mHurryTime = optInt3;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, optInt3);
                        }
                        if (jSONObject5.has("HurrySpeed")) {
                            this.mCatchSpeed = Float.parseFloat(jSONObject5.optString("HurrySpeed"));
                        }
                        if (jSONObject5.has("SlowTime")) {
                            int optInt4 = jSONObject5.optInt("SlowTime");
                            this.mSlowPlayTime = optInt4;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, optInt4);
                        }
                        if (jSONObject5.has("SlowMillisecond")) {
                            int optInt5 = jSONObject5.optInt("SlowMillisecond");
                            this.mSlowPlayTime = optInt5;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, optInt5);
                        }
                        if (jSONObject5.has("SlowSpeed")) {
                            this.mSlowPlaySpeed = Float.parseFloat(jSONObject5.optString("SlowSpeed"));
                        }
                    }
                }
                if (jSONObject4.has("StartPlayAudioBufferThreshold")) {
                    this.mStartPlayBufferThres = jSONObject4.optInt("StartPlayAudioBufferThreshold");
                }
                if (jSONObject4.has("EnableCertVerify")) {
                    this.mEnableQuicCertVerify = jSONObject4.optInt("EnableCertVerify") == 1;
                }
                if (jSONObject4.has("EnableClosePlayRetry")) {
                    this.mEnableClosePlayRetry = jSONObject4.optInt("EnableClosePlayRetry");
                }
                if (jSONObject4.has("EnableDnsOptimizer")) {
                    boolean z5 = jSONObject4.optInt("EnableDnsOptimizer") == 1;
                    this.mEnableDnsOptimizer = z5;
                    this.mLogService.openNodeOptimizer(z5);
                }
                if (jSONObject4.has("EnableMTUDiscovery")) {
                    this.mEnableQuicMTUDiscovery = jSONObject4.optInt("EnableMTUDiscovery");
                }
                if (jSONObject4.has("InitMTU")) {
                    this.mQuicInitMTU = jSONObject4.optInt("InitMTU");
                }
                if (jSONObject4.has("InitRtt")) {
                    this.mQuicInitRtt = jSONObject4.optInt("InitRtt");
                }
                if (jSONObject4.has("MaxCryptoRetransmissions")) {
                    this.mQuicMaxCryptoRetransmissions = jSONObject4.optInt("MaxCryptoRetransmissions");
                }
                if (jSONObject4.has("MaxCryptoRetransmissionTimeMs")) {
                    this.mQuicMaxCryptoRetransmissionTimeMs = jSONObject4.optInt("MaxCryptoRetransmissionTimeMs");
                }
                if (jSONObject4.has("MaxRetransmissions")) {
                    this.mQuicMaxRetransmissions = jSONObject4.optInt("MaxRetransmissions");
                }
                if (jSONObject4.has("MaxRetransmissionTimeMs")) {
                    this.mQuicMaxRetransmissionTimeMs = jSONObject4.optInt("MaxRetransmissionTimeMs");
                }
                if (jSONObject4.has("MaxAckDelay")) {
                    this.mQuicMaxAckDelay = jSONObject4.optInt("MaxAckDelay");
                }
                if (jSONObject4.has("MinReceivedBeforeAckDecimation")) {
                    this.mQuicMinReceivedBeforeAckDecimation = jSONObject4.optInt("MinReceivedBeforeAckDecimation");
                }
                if (jSONObject4.has("QuicVersion")) {
                    this.mQuicVersion = jSONObject4.optInt("QuicVersion", 39);
                }
                if (jSONObject4.has("PadHello")) {
                    this.mQuicPadHello = jSONObject4.optInt("PadHello", 1);
                }
                if (jSONObject4.has("FixWillingAndAbleToWrite")) {
                    this.mQuicFixWillingAndAbleToWrite = jSONObject4.optInt("FixWillingAndAbleToWrite", 1);
                }
                if (jSONObject4.has("FixProcessTimer")) {
                    this.mQuicFixProcessTimer = jSONObject4.optInt("FixProcessTimer", 1);
                }
                if (jSONObject4.has("QuicReadBlockTimeout")) {
                    this.mQuicReadBlockTimeout = jSONObject4.optInt("QuicReadBlockTimeout", 100);
                }
                if (jSONObject4.has("QuicReadBlockMode")) {
                    this.mQuicReadBlockMode = jSONObject4.optInt("QuicReadBlockMode", 0);
                }
                if (jSONObject4.has("FixStreamFinAndRst")) {
                    this.mQuicFixStreamFinAndRst = jSONObject4.optInt("FixStreamFinAndRst", 0);
                }
                if (jSONObject4.has("QuicTimerVersion")) {
                    this.mQuicTimerVersion = jSONObject4.optInt("QuicTimerVersion", 1);
                }
                if (jSONObject4.has("QuicConfigOptimize")) {
                    this.mQuicConfigOptimize = jSONObject4.optInt("QuicConfigOptimize", 0);
                }
                if (jSONObject4.has("QuicSessionReceiveWindow")) {
                    this.mSessionReceiveWindow = jSONObject4.optInt("QuicSessionReceiveWindow", 1);
                }
                if (jSONObject4.has("QuicStreamReceiveWindow")) {
                    this.mStreamReceiveWindow = jSONObject4.optInt("QuicStreamReceiveWindow", 1);
                }
                if (jSONObject4.has("EnableCheckDropAudio")) {
                    this.mEnableCheckDropAudio = jSONObject4.optInt("EnableCheckDropAudio");
                }
                if (jSONObject4.has("AVNoSyncThreshold")) {
                    this.mAVNoSyncThreshold = jSONObject4.optInt("AVNoSyncThreshold");
                }
                if (jSONObject4.has("AlwaysDoAVSync")) {
                    this.mIsAlwaysDoAVSync = jSONObject4.optInt("AlwaysDoAVSync");
                }
                if (jSONObject4.has("StallRetryTimeIntervalManager")) {
                    this.mStallRetryTimeIntervalManager = jSONObject4.optLong("StallRetryTimeIntervalManager");
                }
                if (jSONObject4.has("FastOpenDuration")) {
                    mFastOpenDuration = jSONObject4.optInt("FastOpenDuration");
                }
                if (jSONObject4.has("LLSConfig") && (optJSONObject2 = jSONObject4.optJSONObject("LLSConfig")) != null) {
                    if (optJSONObject2.has("FallbackThreshold")) {
                        this.mRtcFallbackThreshold = optJSONObject2.optInt("FallbackThreshold");
                    }
                    if (optJSONObject2.has("EnableDtls")) {
                        this.mRtcEnableDtls = optJSONObject2.optInt("EnableDtls");
                    }
                    if (optJSONObject2.has("MinJitterBuffer")) {
                        this.mRtcMinJitterBuffer = optJSONObject2.optInt("MinJitterBuffer");
                    }
                    if (optJSONObject2.has("MaxJitterBuffer")) {
                        this.mRtcMaxJitterBuffer = optJSONObject2.optInt("MaxJitterBuffer");
                    }
                    if (optJSONObject2.has("EnableSDKDns")) {
                        this.mRtcEnableSDKDns = optJSONObject2.optInt("EnableSDKDns");
                    }
                    if (optJSONObject2.has("EnableEarlyInitRender")) {
                        this.mRtcEarlyInitRender = optJSONObject2.optInt("EnableEarlyInitRender");
                    }
                    if (optJSONObject2.has("MaxRetryCount")) {
                        this.mRtcMaxRetryCount = optJSONObject2.optInt("MaxRetryCount");
                    }
                    if (optJSONObject2.has("EnableRTCHWDecode")) {
                        this.mHardwareRTCDecodeEnable = optJSONObject2.optInt("EnableRTCHWDecode");
                    }
                    if (optJSONObject2.has("EnableMiniSdp")) {
                        this.mRtcSupportMiniSdp = optJSONObject2.optInt("EnableMiniSdp");
                    }
                    if (optJSONObject2.has("PlayingLogInterval")) {
                        int optInt6 = optJSONObject2.optInt("PlayingLogInterval");
                        this.mRtcPlayLogInterval = optInt6;
                        LiveLoggerService liveLoggerService = this.mLogService;
                        if (liveLoggerService != null) {
                            liveLoggerService.setRtcPlayLogInterval(optInt6);
                        }
                    }
                    if (optJSONObject2.has("EnableRTSFixDeadlock")) {
                        this.mRtcEnableRtcUninitLockFree = optJSONObject2.optInt("EnableRTSFixDeadlock");
                    }
                }
                if (jSONObject4.has("NetWorkTimeoutMs")) {
                    this.mNetworkTimeout = jSONObject4.optInt("NetWorkTimeoutMs");
                }
                if (jSONObject4.has("EnableCheckPacketCorrupt")) {
                    this.mEnableCheckPacketCorrupt = jSONObject4.optInt("EnableCheckPacketCorrupt");
                }
                if (jSONObject4.has("AudioTimescaleEnable")) {
                    this.mAudioTimescaleEnable = jSONObject4.optInt("AudioTimescaleEnable");
                }
                if (jSONObject4.has("EnableTcpFastOpen")) {
                    this.mEnableTcpFastOpen = jSONObject4.optInt("EnableTcpFastOpen");
                }
                if (jSONObject4.has("HlsLiveStartIndex")) {
                    this.mHlsLiveStartIndex = jSONObject4.optInt("HlsLiveStartIndex");
                }
                if (jSONObject4.has("CmafOptimizeRetry")) {
                    this.mEnableCmafOptimizeRetry = jSONObject4.optInt("CmafOptimizeRetry");
                }
                if (jSONObject4.has("EnableFastOpen")) {
                    this.mEnableFastOpenStream = jSONObject4.optInt("EnableFastOpen");
                }
                if (jSONObject4.has("EnableLowLatencyFLV")) {
                    this.mEnableLowLatencyFLV = jSONObject4.optInt("EnableLowLatencyFLV");
                }
                if (jSONObject4.has("EnableSkipFlvNullTag")) {
                    this.mEnableSkipFlvNullTag = jSONObject4.optInt("EnableSkipFlvNullTag");
                }
                if (jSONObject4.has("LiveIOConfig") && (optJSONObject = jSONObject4.optJSONObject("LiveIOConfig")) != null) {
                    if (optJSONObject.has("EnableLiveIO")) {
                        this.mEnableLiveIOPlay = optJSONObject.optInt("EnableLiveIO");
                    }
                    if (optJSONObject.has("EnableP2P")) {
                        this.mEnableLiveIOP2P = optJSONObject.optInt("EnableP2P");
                    }
                    if (optJSONObject.has("EnableHttpPrepare")) {
                        this.mEnableHttpPrepare = optJSONObject.optInt("EnableHttpPrepare");
                    }
                    if (optJSONObject.has("EnableP2pUp")) {
                        this.mEnableP2pUp = optJSONObject.optInt("EnableP2pUp");
                    }
                    if (optJSONObject.has("LiveIOABGroupID")) {
                        this.mLiveIOABGroupID = optJSONObject.optInt("LiveIOABGroupID");
                    }
                }
                if (jSONObject4.has("EnableNTPByApp")) {
                    int optInt7 = jSONObject4.optInt("EnableNTPByApp");
                    this.mEnableNTP = optInt7;
                    LiveLoggerService liveLoggerService2 = this.mLogService;
                    liveLoggerService2.mEnableNTP = optInt7;
                    if (optInt7 == 1 && (iLiveSettingBundle = this.mSettingsBundle) != null) {
                        liveLoggerService2.mTimeDiff = ((Long) iLiveSettingBundle.getSettingsValueForKey("time_diff_server_and_client", 0L)).longValue();
                    }
                }
                if (jSONObject4.has("NoSyncReportMinDuration")) {
                    this.mNoSyncReportMinDuration = jSONObject4.optInt("NoSyncReportMinDuration");
                }
                if (jSONObject4.has("NoSyncReportReportThres")) {
                    this.mNoSyncReportReportThres = jSONObject4.optInt("NoSyncReportReportThres");
                }
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
        this.mLogService.mDefaultResBitrate = this.mDefaultResBitrate;
    }

    private void configPlayerGlobalOption() {
        LiveURL playLiveURL;
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        boolean z5;
        int i6;
        this.mPlayer.setIntOption(9, this.mNetworkTimeout * 1000000);
        this.mPlayer.setIntOption(83, this.mTestAction);
        this.mPlayer.setIntOption(37, this.mEnhancementType);
        this.mPlayer.setIntOption(38, this.mScaleType);
        StringBuilder sb = new StringBuilder();
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_PLAY_TYPE, 0);
        this.mPlayer.setIntOption(36, this.mLayoutType);
        this.mPlayer.setIntOption(110, 5000);
        this.mPlayer.setIntOption(64, 0);
        this.mPlayer.setIntOption(94, 1);
        this.mPlayer.setIntOption(56, this.mRenderType);
        _configLiveSettingBundle();
        _configWithSDKParams();
        configToBParams();
        LiveLoggerService liveLoggerService = this.mLogService;
        int i7 = this.mEnableFastOpenStream;
        liveLoggerService.mEnableFastOpenStream = i7;
        this.mPlayer.setIntOption(220, i7);
        MyLog.i(TAG, "set fast open stream");
        this.mPlayer.setIntOption(56, this.mRenderType);
        this.mPlayer.setIntOption(340, this.mEnableCheckDropAudio);
        this.mPlayer.setIntOption(52, this.mEnableUploadSei);
        if (this.mEnableDTSCheck == 1 || this.mEnableCheckFrame == 1 || this.mEnableCheckSEI == 1) {
            this.mPlayer.setIntOption(640, 1);
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK, 1);
        if (this.mEnableClosePlayRetry == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 0);
            this.mPlayer.setIntOption(82, 0);
        }
        LiveLoggerService liveLoggerService2 = this.mLogService;
        liveLoggerService2.mHasAbrInfo = this.mHasAbrInfo;
        liveLoggerService2.mAbrStrategy = this.mAbrStrategy;
        liveLoggerService2.mEnableResolutionAutoDegrade = this.mEnableResolutionAutoDegrade;
        liveLoggerService2.mStallCountThresOfResolutionDegrade = this.mStallCountThresOfResolutionDegrade;
        long j6 = this.mStallRetryTimeIntervalManager;
        liveLoggerService2.mStallRetryTimeInterval = j6;
        this.mRetryProcessor.setStallRetryTimeInterval(j6);
        int i8 = this.mEnableSharp;
        if (i8 == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SHARP, i8);
            LiveLoggerService liveLoggerService3 = this.mLogService;
            if (liveLoggerService3 != null) {
                liveLoggerService3.enableSharp();
            }
        }
        String vCodec = this.mURLSource.getSourceType() == 2 ? this.mURLSource.getVCodec(this.mResolution, this.mLevel) : (this.mURLSource.getSourceType() != 1 || (playLiveURL = this.mURLSource.getPlayLiveURL()) == null) ? null : playLiveURL.getVCodec();
        if (vCodec != null) {
            if (vCodec.equals(IjkMediaFormat.CODEC_NAME_H264)) {
                this.mHardwareDecodeEnable = this.mEnableH264HardwareDecode;
                this.mDefaultCodecId = 0;
            } else if (vCodec.equals("bytevc1")) {
                this.mHardwareDecodeEnable = this.mEnableByteVC1HardwareDecode;
                this.mDefaultCodecId = 1;
            } else {
                this.mHardwareDecodeEnable = 0;
            }
            this.mLogService.mUrlAbility = vCodec;
        } else {
            this.mHardwareDecodeEnable = 0;
        }
        this.mHardwareDecodeEnable = 1;
        this.mEnableMediaCodecASYNCInit = 1;
        this.mPlayer.setIntOption(800, this.mEnableRtcPlay);
        if (this.mEnableRtcPlay == 1) {
            MyLog.i(TAG, "rtc close hardware decode");
            this.mPlayer.setIntOption(59, 0);
            this.mPlayer.setIntOption(181, 0);
            int i9 = (this.mHardwareRTCDecodeEnable == 1 && this.mHardwareDecodeEnable == 1) ? 1 : 0;
            MyLog.i(TAG, "rts decode mHardwareDecodeEnable:" + this.mHardwareDecodeEnable + ", mHardwareRTCDecodeEnable: " + this.mHardwareRTCDecodeEnable);
            StringBuilder sb2 = new StringBuilder("rts decode  hardware decode ");
            sb2.append(i9 == 1 ? "True" : "False");
            MyLog.i(TAG, sb2.toString());
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE, i9);
        } else {
            this.mPlayer.setIntOption(59, this.mHardwareDecodeEnable);
            this.mLogService.enableHardDecode(this.mHardwareDecodeEnable == 1);
            if (this.mHardwareDecodeEnable == 1) {
                MyLog.i(TAG, "enable hardware decode");
                if (this.mDefaultCodecId != -1) {
                    MyLog.i(TAG, "set hardware async init");
                    this.mPlayer.setIntOption(181, this.mEnableMediaCodecASYNCInit);
                    this.mPlayer.setIntOption(182, this.mDefaultCodecId);
                    LiveLoggerService liveLoggerService4 = this.mLogService;
                    liveLoggerService4.mMediaCodecAsyncInit = this.mEnableMediaCodecASYNCInit;
                    liveLoggerService4.mDefaultCodecID = this.mDefaultCodecId;
                }
            }
            this.mPlayer.setIntOption(97, this.mHardwareDecodeEnable);
            this.mPlayer.setIntOption(536, 500000);
        }
        int i10 = this.mByteVC1DecoderType;
        if (i10 != -1 && this.mEnableByteVC1HardwareDecode != 1) {
            this.mPlayer.setIntOption(67, i10);
        }
        int i11 = this.mBufferTimeout;
        if (i11 != -1) {
            this.mPlayer.setIntOption(81, i11);
        }
        float f6 = this.mCatchSpeed;
        if (f6 > 0.0f) {
            this.mPlayer.setFloatOption(80, f6);
            this.mLogService.mCatchSpeed = this.mCatchSpeed;
        }
        if (this.mCacheFileEnable == -1 && this.mCacheFilePath != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(System.currentTimeMillis());
            String sb4 = sb3.toString();
            this.mCacheFileKey = sb4;
            this.mPlayer.setStringOption(17, sb4);
            this.mPlayer.setIntOption(14, 1);
            this.mPlayer.setCacheFile(this.mCacheFilePath, 1);
        }
        int i12 = this.mHurryType;
        if (i12 != -1) {
            this.mPlayer.setIntOption(84, i12);
            this.mLogService.mEnableHurry = true;
        }
        if (this.mHurryType == 0 && (i6 = this.mHurryTime) != 0) {
            this.mPlayer.setIntOption(15, i6);
            this.mLogService.mHurryTime = this.mHurryTime;
        }
        if (this.mIsLocalURL && !TextUtils.isEmpty(this.mLocalURL) && (z5 = this.mLooping)) {
            this.mPlayer.setLooping(z5);
        }
        int i13 = this.mBufferDataSeconds;
        if (i13 != -1) {
            this.mPlayer.setIntOption(86, i13);
        }
        int i14 = this.mSlowPlayTime;
        if (i14 != -1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, i14);
            this.mLogService.mSlowPlayTime = this.mSlowPlayTime;
        }
        float f7 = this.mSlowPlaySpeed;
        if (f7 > 0.0f) {
            this.mPlayer.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, f7);
            this.mLogService.mSlowSpeed = this.mSlowPlaySpeed;
        }
        int i15 = this.mMaxCacheSeconds;
        if (i15 != -1) {
            this.mPlayer.setIntOption(24, i15);
            this.mPlayer.setIntOption(198, this.mMaxCacheSeconds);
            this.mLogService.mMaxCacheSeconds = this.mMaxCacheSeconds;
        }
        int i16 = this.mEnableSplitStream;
        if (i16 != 0) {
            this.mPlayer.setIntOption(87, i16);
            this.mLogService.mEnableSplitStream = this.mEnableSplitStream;
        }
        long j7 = this.mStartPlayBufferThres;
        if (j7 > 0) {
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES, j7);
            this.mLogService.mStartPlayBufferThres = this.mStartPlayBufferThres;
        }
        int i17 = this.mCheckBufferingEndIgnoreVideo;
        if (i17 == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_BUFFERING_END_IGNORE_VIDEO, i17);
            this.mLogService.mCheckBufferingEndIgnoreVideo = this.mCheckBufferingEndIgnoreVideo;
        }
        int i18 = this.mStartDirectAfterPrepared;
        if (i18 == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_START_DIRECTLLY_AFTER_PREPARED, i18);
            this.mLogService.mStartDirectAfterPrepared = this.mStartDirectAfterPrepared;
        }
        int i19 = this.mCheckBufferingEndAdvanceEnable;
        if (i19 == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END, i19);
            this.mLogService.mCheckBufferingEndAdvanceEnable = this.mCheckBufferingEndAdvanceEnable;
        }
        int i20 = this.mOpenCheckSideData;
        if (i20 == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, i20);
        }
        int i21 = this.mAudioTimescaleEnable;
        if (i21 != -1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TIMESCALE_ENABLE, i21);
            this.mLogService.mAudioTimescaleEnable = this.mAudioTimescaleEnable;
        }
        LiveLoggerService liveLoggerService5 = this.mLogService;
        liveLoggerService5.mEnableUploadSessionSeries = this.mEnableUploadSessionSeries;
        if (this.mEnableNTPTask == 1) {
            liveLoggerService5.openNTP();
        }
        if (this.mEnableOpenMDL == 1) {
            this.mLogService.mEnableOpenMDL = (int) MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(AVMDLDataLoader.KeyIsLiveLoaderEnable);
            this.mLogService.mEnableP2P = (int) MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable);
            this.mLogService.mMDLVersion = MediaLoaderWrapper.getDataLoader().getStringValueFromLoader(11);
            this.mLogService.mEnableMdlProto = (int) MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8102);
            MediaLoaderWrapper.getDataLoader().setListener(new MyMediaLoaderListener(this));
            if (!this.mIsMdlProtoRegister && MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8102) == 1) {
                long longValueFromLoader = MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(AVMDLDataLoader.KeyIsGetMdlProtocolHandle);
                if (longValueFromLoader != -1) {
                    this.mIsMdlProtoRegister = this.mPlayer.setLongOption(500, longValueFromLoader) == 0;
                }
                MyLog.i(TAG, "get mdl proto ret:" + longValueFromLoader + ", register ret:" + this.mIsMdlProtoRegister);
            }
        }
        this.mEnableOpenLiveIO = 0;
        this.mEnableLiveIOPlay = 0;
        this.mEnableRtcPlay = 0;
        long j8 = this.mALogWriteAddr;
        if (j8 != -1) {
            this.mPlayer.setLongOption(231, j8);
            this.mPlayer.setIntOption(223, 1);
        }
        String str = this.mStreamFormat;
        if (str != null) {
            this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, str);
        }
        String str2 = this.mStreamFormat;
        if (str2 != null && str2.equals(LiveConfigKey.AVPH)) {
            prepareAvphPlay();
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AV_NO_SYNC_THRESHOLD, this.mAVNoSyncThreshold);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, this.mIsAlwaysDoAVSync);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, this.mEnableRenderStall);
        if (this.mEnableRenderStall == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, mAudioRenderStallThreshold);
            this.mPlayer.setIntOption(322, mVideoRenderStallThreshold);
        }
        this.mPlayer.setIntOption(360, this.mEnableDemuxerStall);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AVNOSYNC_REPORT_THRES, this.mNoSyncReportReportThres);
        if (this.mEnableDemuxerStall == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_STALL_THRESHOLD, mDemuxerStallThreshold);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME, -1L);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME, -1L);
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODER_STALL, this.mEnableDecoderStall);
        if (this.mEnableDecoderStall == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, mDecoderStallThreshold);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME, -1L);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME, -1L);
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, this.mEnableStallCounter);
        int i22 = this.mEnableTcpFastOpen;
        if (i22 == 1 && (mediaPlayer2 = this.mPlayer) != null) {
            this.mLogService.mEnableTcpFastOpen = i22;
            mediaPlayer2.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, i22);
            sb.append("live_enable_tcp_fast_open:1,");
        }
        MediaPlayer mediaPlayer3 = this.mPlayer;
        if (mediaPlayer3 != null) {
            int i23 = this.mEnableCmafFastMode;
            if (i23 == 1) {
                mediaPlayer3.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, i23);
                sb.append("live_enable_cmaf_fast_mode:1 ");
            }
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY, this.mEnableCmafOptimizeRetry);
        }
        MediaPlayer mediaPlayer4 = this.mPlayer;
        if (mediaPlayer4 != null) {
            mediaPlayer4.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, this.mEnableVideoMpdRefresh);
        }
        int i24 = this.mEnableCheckPacketCorrupt;
        if (i24 == 1 && (mediaPlayer = this.mPlayer) != null) {
            mediaPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT, i24);
            sb.append("live_enable_check_packet_corrupt:1,");
        }
        if (this.mEnableResolutionAutoDegrade && this.mURLSource.getSourceType() == 2 && this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && this.mABRDisableAlgorithm == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 1);
        }
        if (this.mEnableFlvABR == 1) {
            sb.append("live_enable_flv_abr:1,");
        }
        if (this.mEnableOptimizeBackup == 1) {
            sb.append("live_enable_optimize_backup:1,");
        }
        if (this.mEnableStallRetryInstantly == 1) {
            sb.append("live_enable_stall_retry_instantly:1 ");
        } else {
            sb.append("live_enable_stall_retry_instantly:0 ");
        }
        if (this.mEnableCacheSei == 1) {
            sb.append("live_enable_sei_pts_sync:1 ");
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION, 1);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD, 1000);
        }
        if (this.mEnableDecodeMultiSei == 1) {
            sb.append("live_enable_decode_multi_sei:1 ");
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI, 1);
        }
        if (this.mEnableDecodeSeiOnce == 1) {
            sb.append("live_enable_decode_sei_once:1 ");
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 1);
        }
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            if (((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_super_resolution_enable", 0)).intValue() == 1) {
                sb.append("live_sdk_super_resolution_enable:1 ");
            } else {
                sb.append("live_sdk_super_resolution_enable:0 ");
            }
        }
        if (this.mEnableTextureRender == 1) {
            sb.append("live_sdk_texture_render_enable:1 ");
        } else {
            sb.append("live_sdk_texture_render_enable:0 ");
        }
        ILiveSettingBundle iLiveSettingBundle2 = this.mSettingsBundle;
        if (iLiveSettingBundle2 != null) {
            if (((Integer) iLiveSettingBundle2.getSettingsValueForKey("live_sdk_sharpen_enable", 0)).intValue() == 1) {
                sb.append("live_sdk_sharpen_enable:1 ");
            } else {
                sb.append("live_sdk_sharpen_enable:0 ");
            }
        }
        if (this.mEnableOpenLiveIO == 1) {
            sb.append("live_sdk_enable_liveio:1 ");
        }
        if (this.mEnableAudioVolumeBalance == 1) {
            sb.append("live_sdk_audio_volume_balance_enable:1 ");
            if (this.mAudioVolumeBalancePregain != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_pregain:" + this.mAudioVolumeBalancePregain + " ");
            }
            if (this.mAudioVolumeBalanceThreshold != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_threshold:" + this.mAudioVolumeBalanceThreshold + " ");
            }
            if (this.mAudioVolumeBalanceRatio != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_ratio:" + this.mAudioVolumeBalanceRatio + " ");
            }
            if (this.mAudioVolumeBalancePredelay != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_predelay:" + this.mAudioVolumeBalancePredelay + " ");
            }
        }
        if (this.mEnableNotifySeiImmediatelyBeforeFirstFrame == 1) {
            sb.append("live_sdk_notifysei_immediately_before_firstframe:1 ");
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, 1);
        }
        if (this.mEnableRadioLiveDisableRender == 1) {
            sb.append("live_sdk_enable_radiolive_disable_render:1 ");
        }
        if (this.mLogService.mHostNTPUrl != null) {
            sb.append("live_sdk_ntp_server_name:" + this.mLogService.mHostNTPUrl + " ");
        }
        if (this.mEnableReportSessionStop == 1) {
            sb.append("live_sdk_should_report_session_stop:1 ");
            this.mLogService.mEnableReportSessionStop = 1;
        }
        if (this.mUsePlayerRenderStart) {
            sb.append("live_sdk_texturerender_use_player_renderstart:1 ");
        }
        if (this.mEnableFreeFlow == 1) {
            sb.append("live_sdk_isfreeflow:1 ");
        }
        if (this.mEnableDroppingDTSRollFrame == 1) {
            sb.append("live_sdk_dropping_dts_rollback_frame_enabled:1 ");
            this.mPlayer.setIntOption(148, this.mEnableDroppingDTSRollFrame);
        }
        if (this.mEnableUseLiveThreadPool == 1) {
            sb.append("live_sdk_enable_use_live_threadpool:1 ");
        }
        LiveLoggerService liveLoggerService6 = this.mLogService;
        liveLoggerService6.mIsInMainLooper = this.mIsInMainLooper;
        liveLoggerService6.mSettingsInfo = sb.length() == 0 ? "none" : sb.deleteCharAt(sb.length() - 1).toString();
        if (!TextUtils.isEmpty(this.mStreamFormat) && (this.mStreamFormat.equals(LiveConfigKey.HLS) || this.mStreamFormat.equals(LiveConfigKey.TSL))) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, this.mHlsLiveStartIndex);
        }
        LiveLoggerService liveLoggerService7 = this.mLogService;
        liveLoggerService7.mEnableLowLatencyFLV = this.mEnableLowLatencyFLV;
        liveLoggerService7.mFastOpenDuration = mFastOpenDuration;
    }

    private JSONArray formatABRStreamInfoToJSONArray(String str) {
        if (str == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            while (true) {
                JSONObject jSONObject = new JSONObject();
                int indexOf = str.indexOf("index:");
                int indexOf2 = str.indexOf(",pts_diff:");
                if (indexOf < 0 || indexOf2 < 0 || indexOf >= indexOf2) {
                    break;
                }
                jSONObject.put("index", Integer.parseInt(str.substring(indexOf + 6, indexOf2)));
                String substring = str.substring(indexOf2);
                int indexOf3 = substring.indexOf(",drop_dur:");
                if (indexOf3 < 0 || 10 >= indexOf3) {
                    break;
                }
                jSONObject.put("pts_diff", Long.parseLong(substring.substring(10, indexOf3)));
                String substring2 = substring.substring(indexOf3);
                int indexOf4 = substring2.indexOf(",key:");
                if (indexOf4 < 0 || 10 >= indexOf4) {
                    break;
                }
                jSONObject.put("drop_dur", Long.parseLong(substring2.substring(10, indexOf4)));
                String substring3 = substring2.substring(indexOf4);
                int indexOf5 = substring3.indexOf(",index:");
                if (indexOf5 != -1) {
                    if (5 >= indexOf5) {
                        break;
                    }
                    jSONObject.put("key_frame", Integer.parseInt(substring3.substring(5, indexOf5)));
                    arrayList.add(jSONObject);
                    str = substring3.substring(indexOf5 + 1);
                } else if (substring3.length() != 0) {
                    String substring4 = substring3.substring(5);
                    jSONObject.put("key_frame", Integer.parseInt(substring4));
                    arrayList.add(jSONObject);
                    vl.j(TAG, "key: " + substring4);
                }
            }
            return new JSONArray((Collection) arrayList);
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void closeDNS() {
        this.mEnableDns = false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void closeSeiCheck() {
        this.mEnableSeiCheck = false;
        this.mLogService.mEnableSeiCheck = false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void enableSeiCheck() {
        this.mEnableSeiCheck = true;
        this.mLogService.mEnableSeiCheck = true;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void enableUploadSessionSeries() {
        this.mEnableUploadSessionSeries = true;
        this.mLogService.mEnableUploadSessionSeries = true;
    }

    public boolean getSRState() {
        return false;
    }

    public boolean getSharpenState() {
        return false;
    }

    public boolean isUsedSR() {
        return false;
    }

    public boolean isUsedSharpen() {
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void openNTP() {
        this.mEnableNTPTask = 1;
        this.mLogService.openNTP();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0207  */
    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void play() {
        /*
            Method dump skipped, instructions count: 579
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager.play():void");
    }

    private static final class MyInfoListener implements MediaPlayer.OnInfoListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
        
            if (r3.mPlayer.getIntOption(62, -1) == 0) goto L121;
         */
        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnInfoListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onInfo(com.bykv.vk.component.ttvideo.player.MediaPlayer r20, int r21, int r22) {
            /*
                Method dump skipped, instructions count: 1648
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager.MyInfoListener.onInfo(com.bykv.vk.component.ttvideo.player.MediaPlayer, int, int):boolean");
        }

        public MyInfoListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }
    }

    private VideoLiveManager(Builder builder) {
        this.mMyHandler = new Handler(Looper.myLooper());
        this.mURLSource = new LiveInfoSource();
        this.mEnableTextureRender = 0;
        this.mEnableTextureSR = 0;
        this.mResolutionDisableSR = true;
        this.mTextureSRBinPath = "none";
        this.mTextureSROclModuleName = "test";
        this.mTextureSRDspModuleName = "test";
        this.mTextureRenderErrorMsg = null;
        this.mEnableOpenMDL = 0;
        this.mIsMdlProtoRegister = false;
        this.mIsPlayWithMdl = false;
        this.mPrepareState = PlayerState.IDLE;
        this.mLivePlayerState = LivePlayerState.IDLE;
        this.mIsRequestCanceled = false;
        this.mShowedFirstFrame = false;
        this.mHasRetry = false;
        this.mLooping = false;
        this.mPlayerCache = 0;
        this.mEnhancementType = 0;
        this.mScaleType = 0;
        this.mLayoutType = 0;
        this.mRenderType = 3;
        this.mHardwareDecodeEnable = 0;
        this.mHardwareRTCDecodeEnable = 0;
        this.mCacheFileEnable = -1;
        this.mTestAction = -1;
        this.mUseExternalDir = -1;
        this.mMaxFileCacheSize = -1;
        this.mByteVC1DecoderType = 1;
        this.mBufferDataSeconds = -1;
        this.mBufferTimeout = -1;
        this.mNetworkTimeout = -1;
        this.mPlayerDegradeMode = 0;
        this.mEnableSharp = 0;
        this.mDefaultCodecId = -1;
        this.mEnableMediaCodecASYNCInit = 0;
        this.mHurryType = -1;
        this.mHurryTime = 0;
        this.mCatchSpeed = -1.0f;
        this.mSlowPlayTime = -1;
        this.mSlowPlaySpeed = -1.0f;
        this.mEnableHurryFlag = -1;
        this.mCacheFilePath = null;
        this.mCacheFileKey = null;
        this.mIsCacheHasComplete = false;
        this.mCurrentPlayURL = null;
        this.mCurrentIP = null;
        this.mStallCount = 0;
        this.mIsStalling = false;
        this.mEnableResolutionAutoDegrade = false;
        this.mAbrStrategy = LiveConfigKey.RAD;
        this.mHasAbrInfo = false;
        this.mDefaultResBitrate = -1;
        this.mStallCountThresOfResolutionDegrade = 4;
        this.mEnableSwitchMainAndBackupUrl = true;
        this.mEnableVideoMpdRefresh = 1;
        this.mEnableCmafFastMode = 0;
        this.mEnableCmafOptimizeRetry = 0;
        this.mEnableDTSCheck = 0;
        this.mEnablePreventDTSBack = 0;
        this.mFrameDroppingDTSMaxDiff = 10000L;
        this.mFrameTerminatedDTS = -1L;
        this.mLatestAudioPacketDTS = -1L;
        this.mSessionId = null;
        this.mEnableCheckFrame = 0;
        this.mEnableCheckSEI = 0;
        this.mGopDuration = 4;
        this.mFrameMetaDataListener = null;
        this.mInvocationHandler = null;
        this.mLocalURL = null;
        this.mIsLocalURL = false;
        this.mALogWriteAddr = -1L;
        this.mResolution = "origin";
        this.mResolutionIndex = -1;
        this.mLevel = "main";
        this.mStreamFormat = LiveConfigKey.FLV;
        this.mSuggestProtocol = "none";
        this.mTransportProtocol = LiveConfigKey.TCP;
        this.mURLProtocol = "none";
        this.mEnableAvLines = "";
        this.mVideoOnly = "";
        this.mAudioOnly = "";
        this.mReliable = "";
        this.mForceDecodeSwitch = 0;
        this.mForceDecodeMsGaps = 0;
        this.mForceRenderMsGaps = 0;
        this.mFramesDrop = 15;
        this.mAVPHDnsParseEnable = 0;
        this.mAVPHDnsTimeout = 2000000;
        this.mAVPHVideoProbesize = 4096;
        this.mAVPHVideoMaxDuration = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        this.mAVPHAudioProbesize = 4096;
        this.mAVPHAudioMaxDuration = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        this.mAVPHOpenVideoFirst = 1;
        this.mAVPHMaxAVDiff = 10000;
        this.mAVPHAutoExit = 1;
        this.mAVPHEnableAutoReopen = 0;
        this.mAVPHVideoDiffThreshold = 15000;
        this.mAVPHReadRetryCount = 100;
        this.mAVPHReadErrorExit = 1;
        this.mEnableSkipFindUnnecessaryStream = 0;
        this.mEnableRenderStall = 1;
        this.mAudioLastRenderTime = -1L;
        this.mVideoLastRenderTime = -1L;
        this.mIsRetrying = false;
        this.mEnableDemuxerStall = 1;
        this.mEnableDecoderStall = 1;
        this.mEnableStallCounter = 0;
        this.mStallCounterInterval = 2000;
        this.mEnableClosePlayRetry = 0;
        this.mEnableCheckDropAudio = 0;
        this.mURLAbility = 1;
        this.mStallStartTime = 0L;
        this.mStallTotalTime = 0L;
        this.mRetryStartTime = 0L;
        this.mEnableNTP = 0;
        this.mEnableNTPTask = 0;
        this.mEnableDns = true;
        this.mEnableDnsOptimizer = false;
        this.mEnableUploadSessionSeries = false;
        this.mEnableH264HardwareDecode = 0;
        this.mEnableByteVC1HardwareDecode = 0;
        this.mMaxCacheSeconds = -1;
        this.mEnableSplitStream = 0;
        this.mOpenCheckSideData = 1;
        this.mEnableHttpkDegrade = 0;
        this.mEnableQuicDegrade = 1;
        this.mEnableFastOpenStream = 1;
        this.mEnableUploadSei = 1;
        this.mSeiDiffThres = 8000L;
        this.mEnableSeiCheck = false;
        this.mHasSeiInfo = false;
        this.mGetSeiCurrentTime = 0L;
        this.mStartPlayBufferThres = 0L;
        this.mCheckBufferingEndIgnoreVideo = 0;
        this.mStartDirectAfterPrepared = 0;
        this.mCheckBufferingEndAdvanceEnable = 0;
        this.mEnableTcpFastOpen = 0;
        this.mEnableCheckPacketCorrupt = 0;
        this.mEnableLowLatencyFLV = 0;
        this.mLowLatencyFLVStrategy = null;
        this.mEnableDroppingDTSRollFrame = 0;
        this.mIsInMainLooper = 1;
        this.mCmafEnable = false;
        this.mQuicEnable = false;
        this.mQuicVersion = 39;
        this.mEnableSaveSCFG = false;
        this.mEnableQuicCertVerify = false;
        this.mQuicInitMTU = 1200;
        this.mEnableQuicMTUDiscovery = 0;
        this.mQuicPadHello = 1;
        this.mQuicFixWillingAndAbleToWrite = 1;
        this.mQuicFixProcessTimer = 1;
        this.mQuicReadBlockTimeout = 100;
        this.mQuicReadBlockMode = 0;
        this.mQuicFixStreamFinAndRst = 0;
        this.mQuicConfigOptimize = 0;
        this.mQuicTimerVersion = 1;
        this.mQuicPull = false;
        this.mQuicInitRtt = 0;
        this.mQuicMaxCryptoRetransmissions = 0;
        this.mQuicMaxCryptoRetransmissionTimeMs = 0;
        this.mQuicMaxRetransmissions = 0;
        this.mQuicMaxRetransmissionTimeMs = 0;
        this.mQuicMaxAckDelay = 0;
        this.mQuicMinReceivedBeforeAckDecimation = 0;
        this.mSessionReceiveWindow = -1;
        this.mStreamReceiveWindow = -1;
        this.mAVNoSyncThreshold = 10000;
        this.mIsAlwaysDoAVSync = 0;
        this.mEnableFlvABR = 0;
        this.mEnableLLASHFastOpen = 0;
        this.mForceHttpDns = false;
        this.mHttpDNSServerHost = null;
        this.mCancelSDKDNSFailRetry = false;
        this.mUrlSettingMethod = -1;
        this.mUserSwitchResoultion = false;
        this.mEnterStallRetryInstantly = false;
        this.mEnableStallRetryInstantly = 1;
        this.mNodeOptimizeResults = null;
        this.mRedoDns = false;
        this.mEnableOptimizeBackup = 0;
        this.mSupportBackupIp = true;
        this.mTextureSRMode = 0;
        this.mRenderStartNotifyTimeStamp = 0L;
        this.mRenderStartEntered = false;
        this.mEnableAudioVolumeBalance = 0;
        this.mAudioVolumeBalancePregain = -1.0f;
        this.mAudioVolumeBalanceThreshold = -1.0f;
        this.mAudioVolumeBalanceRatio = -1.0f;
        this.mAudioVolumeBalancePredelay = -1.0f;
        this.mEnableCacheSei = 0;
        this.mEnableDecodeMultiSei = 0;
        this.mEnableDecodeSeiOnce = 0;
        this.mEnableSkipFlvNullTag = 0;
        this.mEnableNotifySeiImmediatelyBeforeFirstFrame = 1;
        this.mEnableLiveAbrCheckEnhance = 0;
        this.mLiveABRCheckInterval = 1000;
        this.mABRMethod = -1;
        this.mABRBufferThreshold = -1;
        this.mTslTimeShift = -1;
        this.mTslMinTimeShit = 60;
        this.mEnableOriginResolution = false;
        this.mTargetOriginBitRate = -1L;
        this.mEnableAbrStallDegradeImmediately = 1;
        this.mHlsLiveStartIndex = -3;
        this.mCdnSessionPath = null;
        this.mCdnAbrResolution = null;
        this.mAudioTimescaleEnable = -1;
        this.mStallRetryTimeIntervalManager = 10000L;
        this.mMediaSupportSR = false;
        this.mSupportSRScene = 0;
        this.mCheckSupportSR = false;
        this.mStallCounterThread = null;
        this.mStallCounterHandler = null;
        this.mVideoStallCountTask = new VideoStallCountTask();
        this.mStallCounterLock = new Object();
        this.mStallCounterIsRunning = false;
        this.mEnableRtcPlay = 0;
        this.mRtcPlayFallBack = 0;
        this.mRtcFallbackThreshold = 5000;
        this.mRtcEnableDtls = 1;
        this.mRtcMinJitterBuffer = 300;
        this.mRtcMaxJitterBuffer = 2000;
        this.mRtcEnableSDKDns = 0;
        this.mRtcEarlyInitRender = 0;
        this.mRtcMaxRetryCount = 0;
        this.mRtcSupportMiniSdp = 0;
        this.mCurrentRetryCount = 0;
        this.mRtcPlayLogInterval = 5000;
        this.mRtcEnableRtcUninitLockFree = 0;
        this.mEnableRadioLiveDisableRender = 0;
        this.mSwitchToB = 0;
        this.mMoudleIDToB = "";
        this.mURLHost = "";
        this.mABRDisableAlgorithm = 0;
        this.mTextureRenderFirstFrame = false;
        this.mUsePlayerRenderStart = false;
        this.mMaxTextureWidth = 0;
        this.mMaxTextureHeight = 0;
        this.mEnableReportSessionStop = 0;
        this.mSessionNum = 0;
        this.mSessionStartTime = 0L;
        this.mSessionRenderStartTime = 0L;
        this.mIsLiveIOProtoRegister = false;
        this.mEnableOpenLiveIO = 0;
        this.mIsPlayWithLiveIO = false;
        this.mEnableLiveIOPlay = 0;
        this.mEnableLiveIOP2P = 0;
        this.mEnableHttpPrepare = 0;
        this.mEnableFreeFlow = 0;
        this.mEnableP2pUp = 0;
        this.mLiveIOABGroupID = 0;
        this.mNoSyncReportMinDuration = 5000;
        this.mNoSyncReportReportThres = 2000;
        this.mEnableUseLiveThreadPool = 0;
        this.mExecutor = null;
        this.mEnableSharpen = 0;
        this.mSharpenMode = 0;
        this.mMediaSupportSharpen = false;
        this.mSupportSharpenScene = -1;
        this.mSharpenMaxWidth = PredefinedCaptureConfigurations.f35653t;
        this.mSharpenMaxHeight = PredefinedCaptureConfigurations.f35652s;
        this.mSharpenPowerLevel = 0;
        this.mSharpenAmount = -1.0f;
        this.mSharpenOverRatio = -1.0f;
        this.mSharpenEdgeWeightGamma = 6.0f;
        this.mSharpenSceneMode = 1;
        this.mSharpenSdkParams = null;
        Context context = builder.mContext;
        this.mContext = context;
        ILiveListener iLiveListener = builder.mListener;
        this.mListener = iLiveListener;
        ILiveSettingBundle iLiveSettingBundle = builder.mSettingsBundle;
        this.mSettingsBundle = iLiveSettingBundle;
        builder.setStallRetryInterval(this.mStallRetryTimeIntervalManager);
        if (iLiveSettingBundle != null) {
            this.mEnableReportSessionStop = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_should_report_session_stop", 0)).intValue();
            this.mEnableUseLiveThreadPool = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_enable_use_live_threadpool", 0)).intValue();
        }
        if (this.mEnableUseLiveThreadPool != 1 || builder.mLiveThreadPool == null) {
            MyLog.i(TAG, "create new threadpool");
            this.mExecutor = new r(1, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new NamedThreadFactory() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.1
            });
        } else {
            MyLog.i(TAG, "use live threadpool");
            this.mExecutor = builder.mLiveThreadPool;
            this.mLogService.mUseLiveThreadPool = 1;
        }
        LiveLoggerService liveLoggerService = new LiveLoggerService(this, iLiveListener, builder.mUploadLogInterval, builder.mStallRetryTimeInterval, context, this.mEnableReportSessionStop);
        this.mLogService = liveLoggerService;
        liveLoggerService.setProjectKey(builder.mProjectKey);
        MediaLoaderWrapper.getDataLoader().setLogService(this.mLogService);
        this.mRetryProcessor = new RetryProcessor(new MyRetryListener(this), builder.mRetryTimeout, builder.mStallRetryTimeInterval, this.mLogService);
        this.mPlayerSetting = new PlayerSetting(context, null);
        boolean z5 = builder.mForceHttpDns;
        this.mForceHttpDns = z5;
        this.mLogService.mEnableHttpDns = z5;
        INetworkClient iNetworkClient = builder.mNetworkClient;
        this.mNetworkClient = iNetworkClient;
        DnsHelper dnsHelper = new DnsHelper(context, this.mExecutor, iNetworkClient);
        this.mDnsParser = dnsHelper;
        dnsHelper.updateDNSServerIP();
        this.mPlayerType = builder.mPlayerType;
        this.mStreamFormat = builder.mVideoFormat;
        this.mResolution = builder.mResolution;
        this.mStallCount = 0;
        this.mEnableResolutionAutoDegrade = builder.mEnableResolutionAutoDegrade;
        this.mEnableSwitchMainAndBackupUrl = builder.mEnableSwitchMainAndBackupUrl;
        this.mSeiDiffThres = builder.mSeiCheckTimeOut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HttpKDegradeHttp(int i6) {
        String replaceAll;
        String str = this.mCurrentPlayURL;
        if (str == null || !str.startsWith("httpk") || (replaceAll = this.mCurrentPlayURL.replaceAll("httpk", master.flame.danmaku.danmaku.parser.b.f50154a).replaceAll(":(\\d+)/", "/")) == null) {
            return false;
        }
        updateDownloadSizeStat();
        this.mLogService.onSessionStop();
        this.mIsRetrying = true;
        this.mLogService.onSwitchURL(replaceAll);
        this.mLogService.onSwitch(this.mCurrentPlayURL, replaceAll, "httpk_to_http", i6);
        this.mCurrentPlayURL = replaceAll;
        _stopPlayer();
        _resetPlayer();
        this.mSessionStartTime = System.currentTimeMillis();
        parsePlayDNS(this.mCurrentPlayURL);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QuicDegrade(int i6) {
        String replaceAll;
        if (this.mCurrentPlayURL == null) {
            return false;
        }
        if ((!TextUtils.equals(this.mTransportProtocol, LiveConfigKey.QUIC) && !TextUtils.equals(this.mTransportProtocol, LiveConfigKey.QUICU)) || i6 != -499499) {
            return false;
        }
        if (this.mURLProtocol.equals(LiveConfigKey.TLS)) {
            this.mTransportProtocol = LiveConfigKey.TLS;
            replaceAll = this.mCurrentPlayURL.replaceAll("httpq", master.flame.danmaku.danmaku.parser.b.f50155b);
        } else if (this.mURLProtocol.equals(LiveConfigKey.KCP)) {
            this.mTransportProtocol = LiveConfigKey.KCP;
            replaceAll = this.mCurrentPlayURL.replaceAll("httpq", "httpk");
        } else {
            this.mTransportProtocol = LiveConfigKey.TCP;
            replaceAll = this.mCurrentPlayURL.replaceAll("httpq", master.flame.danmaku.danmaku.parser.b.f50154a);
        }
        String replaceAll2 = replaceAll.replaceAll(":(\\d+)/", "/");
        updateDownloadSizeStat();
        this.mLogService.onSessionStop();
        this.mIsRetrying = true;
        if (replaceAll2 != null) {
            this.mLogService.onSwitchURL(replaceAll2);
            this.mLogService.onSwitch(this.mCurrentPlayURL, replaceAll2, "quic_library_load_error", i6);
            this.mCurrentPlayURL = replaceAll2;
            _stopPlayer();
            _resetPlayer();
            this.mSessionStartTime = System.currentTimeMillis();
            parsePlayDNS(this.mCurrentPlayURL);
        }
        return true;
    }

    private void _checkStreamData() {
        LiveInfoSource liveInfoSource = this.mURLSource;
        if (liveInfoSource == null) {
            return;
        }
        liveInfoSource.setEnableOriginResolution(this.mEnableOriginResolution);
        if (this.mEnableResolutionAutoDegrade && this.mURLSource.getSourceType() == 2 && this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE)) {
            String defaultResolution = this.mURLSource.getDefaultResolution();
            if (!TextUtils.isEmpty(defaultResolution)) {
                if (this.mEnableOriginResolution || !defaultResolution.equals("origin")) {
                    _smartResolveDefaultResolution(defaultResolution);
                } else {
                    _smartResolveDefaultResolution(LiveConfigKey.UHD);
                }
            }
            if (this.mURLSource.isABRListMatch() && this.mURLSource.isCodecSame(this.mLevel)) {
                return;
            }
            this.mResolution = this.mURLSource.getDefaultResolution();
            this.mAbrStrategy = LiveConfigKey.RAD;
            this.mEnableResolutionAutoDegrade = false;
            if (!this.mURLSource.isABRListMatch()) {
                this.mLogService.mABRListMatch = 0;
            }
            if (this.mURLSource.isCodecSame(this.mLevel)) {
                return;
            }
            this.mLogService.mCodecNotSame = 1;
        }
    }

    private void _checkValidAbrResolution() {
        if (!this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) || !this.mEnableResolutionAutoDegrade || this.mURLSource.isEnableAdaptive(this.mResolution)) {
            return;
        }
        int i6 = 0;
        while (true) {
            String[] strArr = LiveConfigKey.resolution;
            if (i6 >= strArr.length) {
                return;
            }
            if (this.mURLSource.isEnableAdaptive(strArr[i6])) {
                MyLog.i(TAG, "Abr res check.modify from " + this.mResolution + " to " + strArr[i6]);
                this.mResolution = strArr[i6];
                return;
            }
            i6++;
        }
    }

    private void _configAbrInfo() {
        JSONObject abrInfo = this.mURLSource.getAbrInfo();
        if (abrInfo == null) {
            this.mHasAbrInfo = false;
            this.mEnableResolutionAutoDegrade = false;
            this.mEnableOriginResolution = false;
            this.mAbrStrategy = LiveConfigKey.RAD;
            this.mStallCountThresOfResolutionDegrade = 4;
            return;
        }
        boolean z5 = true;
        this.mHasAbrInfo = true;
        try {
            if (abrInfo.has("enable")) {
                this.mEnableResolutionAutoDegrade = abrInfo.optInt("enable") == 1;
            }
            if (abrInfo.has("strategy")) {
                this.mAbrStrategy = abrInfo.getString("strategy");
            }
            if (abrInfo.has("enable_origin_resolution")) {
                if (abrInfo.optInt("enable_origin_resolution") != 1) {
                    z5 = false;
                }
                this.mEnableOriginResolution = z5;
            }
            if (abrInfo.has("disable_algorithm")) {
                this.mABRDisableAlgorithm = abrInfo.optInt("disable_algorithm");
            }
        } catch (JSONException e6) {
            vl.j(e6);
            this.mHasAbrInfo = false;
            this.mEnableResolutionAutoDegrade = false;
            this.mAbrStrategy = LiveConfigKey.RAD;
            this.mEnableOriginResolution = false;
            this.mStallCountThresOfResolutionDegrade = 4;
        }
    }

    private void _configAvphNeqStrategy() {
        JSONObject jSONObject;
        String str = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_low_latency_flv_default_strategy_map", "");
        if (str.length() > 0) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e6) {
                vl.j(e6);
            }
            if (jSONObject == null && jSONObject.has("net_effective_connection_type_strategy")) {
                try {
                    jSONObject.getJSONObject("net_effective_connection_type_strategy");
                } catch (JSONException e7) {
                    vl.j(e7);
                    return;
                }
            }
            return;
        }
        jSONObject = null;
        if (jSONObject == null) {
            return;
        }
        jSONObject.getJSONObject("net_effective_connection_type_strategy");
    }

    private void _configFlvLowLatencyWithSDKParam() {
        String sDKParams = this.mURLSource.getSDKParams(this.mResolution, this.mLevel);
        if (sDKParams != null) {
            try {
                JSONObject jSONObject = new JSONObject(sDKParams);
                if (jSONObject.has("NetworkAdapt")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("NetworkAdapt"));
                    if (jSONObject2.has("Enabled")) {
                        int optInt = jSONObject2.optInt("Enabled");
                        this.mEnableHurryFlag = optInt;
                        if (optInt == 1) {
                            this.mHurryType = 0;
                        }
                        if (jSONObject2.has("HurryTime")) {
                            int optInt2 = jSONObject2.optInt("HurryTime");
                            this.mHurryTime = optInt2;
                            this.mPlayer.setIntOption(15, optInt2);
                            this.mLogService.mHurryTime = this.mHurryTime;
                        }
                        if (jSONObject2.has("HurryMillisecond")) {
                            int optInt3 = jSONObject2.optInt("HurryMillisecond");
                            this.mHurryTime = optInt3;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, optInt3);
                            this.mLogService.mHurryTime = this.mHurryTime;
                        }
                        if (jSONObject2.has("HurrySpeed")) {
                            float parseFloat = Float.parseFloat(jSONObject2.optString("HurrySpeed"));
                            this.mCatchSpeed = parseFloat;
                            this.mPlayer.setFloatOption(80, parseFloat);
                            this.mLogService.mCatchSpeed = this.mCatchSpeed;
                        }
                        if (jSONObject2.has("SlowTime")) {
                            int optInt4 = jSONObject2.optInt("SlowTime");
                            this.mSlowPlayTime = optInt4;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, optInt4);
                            this.mLogService.mSlowPlayTime = this.mSlowPlayTime;
                        }
                        if (jSONObject2.has("SlowMillisecond")) {
                            int optInt5 = jSONObject2.optInt("SlowMillisecond");
                            this.mSlowPlayTime = optInt5;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, optInt5);
                            this.mLogService.mSlowPlayTime = this.mSlowPlayTime;
                        }
                        if (jSONObject2.has("SlowSpeed")) {
                            float parseFloat2 = Float.parseFloat(jSONObject2.optString("SlowSpeed"));
                            this.mSlowPlaySpeed = parseFloat2;
                            this.mPlayer.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, parseFloat2);
                            this.mLogService.mSlowSpeed = this.mSlowPlaySpeed;
                        }
                    }
                }
                if (jSONObject.has("FastOpenDuration")) {
                    mFastOpenDuration = jSONObject.optInt("FastOpenDuration");
                }
                if (jSONObject.has("EnableLowLatencyFLV")) {
                    this.mEnableLowLatencyFLV = jSONObject.optInt("EnableLowLatencyFLV");
                    this.mLogService.getStallTotalCount();
                    this.mLogService.getRetryTotalCount();
                }
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
    }

    private void _configWithLowLatencyFLVStrategy(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("net_effective_connection_type_strategy")) {
            try {
                jSONObject.getJSONObject("net_effective_connection_type_strategy");
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _doRequestSwitchUrlFromServer() {
        MediaPlayer mediaPlayer;
        String stringOption;
        if (TextUtils.isEmpty(this.mCdnSessionPath) || TextUtils.isEmpty(this.mCdnAbrResolution) || this.mCdnAbrResolution.equals(this.mResolution) || (mediaPlayer = this.mPlayer) == null || (stringOption = mediaPlayer.getStringOption(335)) == null) {
            return;
        }
        MyLog.i(TAG, "responseHeaders: " + stringOption);
        String str = null;
        for (String str2 : stringOption.split(g.f50795q)) {
            if (str2.startsWith("X-Has-Token: ")) {
                str = str2.split(": ", 2)[1];
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.mLogService.mSessionId)) {
                jSONObject.put("live_stream_session_id", this.mLogService.mSessionId);
            }
            String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mCdnAbrResolution, LiveConfigKey.FLV, this.mLevel);
            if (TextUtils.isEmpty(playURLForResolution)) {
                return;
            }
            jSONObject.put("play_url", playURLForResolution);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(JThirdPlatFormInterface.KEY_TOKEN, str);
            }
            String substring = playURLForResolution.substring(playURLForResolution.indexOf("//") + 2);
            String substring2 = substring.substring(substring.indexOf("/"));
            if (!this.mCdnSessionPath.startsWith("/")) {
                this.mCdnSessionPath = "/" + this.mCdnSessionPath;
            }
            String str3 = playURLForResolution.substring(0, playURLForResolution.indexOf(substring2)) + this.mCdnSessionPath;
            MyLog.i(TAG, "sending 'POST' request to URL : " + str3);
            MyLog.i(TAG, "httpBody: " + jSONObject);
            INetworkClient.Result doPost = this.mNetworkClient.doPost(str3, jSONObject.toString());
            if (doPost != null) {
                MyLog.i(TAG, "response: " + doPost.response);
                MyLog.i(TAG, "code: " + doPost.code);
                LiveLoggerService liveLoggerService = this.mLogService;
                int i6 = doPost.code;
                liveLoggerService.mCdnAbrSwitchCode = i6;
                if (i6 == 200 && doPost.response.has("code")) {
                    this.mLogService.mCdnAbrSwitchCode = doPost.response.optInt("code");
                    if (this.mLogService.mCdnAbrSwitchCode == 0) {
                        this.mResolution = this.mCdnAbrResolution;
                    }
                }
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private void _play(String str) {
        PlayerState playerState = this.mPrepareState;
        if (playerState == PlayerState.PREPARED && this.mPlayer != null) {
            MyLog.i(TAG, "_play resume");
            String str2 = this.mCurrentIP;
            if (str2 != null) {
                this.mLogService.setCdnIp(str2, false);
            }
            this.mPlayer.start();
        } else if (playerState == PlayerState.IDLE || this.mPlayer == null) {
            MyLog.i(TAG, "_play start");
            open();
            this.mPrepareState = PlayerState.INITIALIZED;
            if (!this.mIsLocalURL || TextUtils.isEmpty(this.mLocalURL)) {
                parsePlayDNS(str);
            } else {
                this.mLogService.onCallPrepare();
                prepareToPlay(this.mLocalURL, null, null, null);
            }
        } else {
            configPlayerGlobalOption();
            if (!this.mIsLocalURL || TextUtils.isEmpty(this.mLocalURL)) {
                parsePlayDNS(str);
            } else {
                prepareToPlay(this.mLocalURL, null, null, null);
            }
        }
        this.mIsRequestCanceled = false;
    }

    private void _requestSwitchUrlFromServer() {
        this.mLogService.mIsCdnAbrSwitch = true;
        if ((this.mURLSource.getSourceType() != 2 || this.mURLSource.isCodecSame(this.mLevel)) && !this.mExecutor.isShutdown()) {
            this.mExecutor.submit(new Runnable() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.2
                @Override // java.lang.Runnable
                public void run() {
                    VideoLiveManager.this._doRequestSwitchUrlFromServer();
                }
            });
        }
    }

    private void _reset(String str) {
        MyLog.i(TAG, "_reset");
        _stopPlayer();
        _resetPlayer();
        _stopLiveManager(str);
        this.mResolutionIndex = -1;
        this.mLivePlayerState = LivePlayerState.IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _resetPlayer() {
        MyLog.i(TAG, "_resetPlayer");
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
        this.mPrepareState = PlayerState.INITIALIZED;
    }

    private void _setLooseSync() {
        LiveInfoSource liveInfoSource = this.mURLSource;
        if (liveInfoSource == null) {
            return;
        }
        String sDKParams = liveInfoSource.getSDKParams(this.mResolution, this.mLevel);
        if (TextUtils.isEmpty(sDKParams)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(sDKParams);
            if (jSONObject.has("ForceDecodeSwitch")) {
                this.mForceDecodeSwitch = jSONObject.optInt("ForceDecodeSwitch");
            }
            if (jSONObject.has("ForceDecodeMsGaps")) {
                this.mForceDecodeMsGaps = jSONObject.optInt("ForceDecodeMsGaps");
            }
            if (jSONObject.has("ForceRenderMsGaps")) {
                this.mForceRenderMsGaps = jSONObject.optInt("ForceRenderMsGaps");
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    private void _setProtocol() {
        String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, this.mStreamFormat, this.mLevel);
        if (playURLForResolution != null) {
            this.mLogService.setOriginUrl(playURLForResolution);
            if (playURLForResolution.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                this.mTransportProtocol = LiveConfigKey.TCP;
            }
            if (playURLForResolution.startsWith("httpk")) {
                this.mTransportProtocol = LiveConfigKey.KCP;
            }
            if (playURLForResolution.startsWith(master.flame.danmaku.danmaku.parser.b.f50155b)) {
                this.mTransportProtocol = LiveConfigKey.TLS;
            }
            this.mURLProtocol = this.mTransportProtocol;
        }
        String suggestProtocol = this.mURLSource.getSuggestProtocol(this.mResolution, this.mLevel);
        this.mSuggestProtocol = suggestProtocol;
        if (suggestProtocol == null) {
            this.mSuggestProtocol = "none";
            return;
        }
        if ((suggestProtocol.equals(LiveConfigKey.QUIC) || this.mSuggestProtocol.equals(LiveConfigKey.QUICU)) && !this.mQuicEnable) {
            try {
                LibraryLoader.loadLibrary("ttquic");
                this.mQuicEnable = true;
                MyLog.i(TAG, "ttquic lib is load success");
                this.mLogService.setQuicLibLoader(1);
            } catch (Throwable unused) {
                suggestProtocol = this.mTransportProtocol;
                this.mQuicEnable = false;
                MyLog.i(TAG, "ttquic lib is load failed. change default protocol");
                this.mLogService.setQuicLibLoader(0);
            }
        }
        this.mTransportProtocol = suggestProtocol;
    }

    private void _setStreamFormat() {
        String str;
        String suggestFormat = this.mURLSource.getSuggestFormat(this.mResolution, this.mLevel);
        if (suggestFormat != null) {
            if (suggestFormat.equals(LiveConfigKey.CMAF) && !this.mCmafEnable) {
                try {
                    LibraryLoader.loadLibrary("ttmcmaf");
                    this.mCmafEnable = true;
                    MyLog.i(TAG, "cmaf lib is load success");
                } catch (Throwable unused) {
                    this.mURLSource.setStreamInfoFlag(1);
                    str = this.mStreamFormat;
                    this.mCmafEnable = false;
                    MyLog.i(TAG, "cmaf lib is load failed. change default format");
                }
            } else if (suggestFormat.equals("lls")) {
                this.mEnableRtcPlay = 1;
                this.mLogService.mEnableRtcPlay = 1;
                try {
                    MyLog.i(TAG, "lls load bytertc library");
                    m.j("byteaudio");
                    m.j("bytenn");
                    m.j("bytertc");
                    MyLog.i(TAG, "lls load bytertc library done");
                } catch (Throwable unused2) {
                    this.mURLSource.setStreamInfoFlag(2);
                    str = this.mStreamFormat;
                    this.mEnableRtcPlay = 0;
                    this.mLogService.mEnableRtcPlay = 0;
                    MyLog.i(TAG, "bytertc lib is load failed. change default format");
                }
            }
            str = suggestFormat;
            this.mStreamFormat = str;
            this.mLogService.setFormatInfo(suggestFormat, str);
        } else {
            this.mStreamFormat = LiveConfigKey.FLV;
            this.mLogService.setFormatInfo("none", LiveConfigKey.FLV);
        }
        if (!TextUtils.isEmpty(this.mStreamFormat) && this.mStreamFormat.equals(LiveConfigKey.FLV)) {
            _setAvLines();
            if (!this.mEnableAvLines.isEmpty() && !this.mVideoOnly.isEmpty() && !this.mAudioOnly.isEmpty() && this.mEnableAvLines.equals("true") && this.mVideoOnly.equals(LiveConfigKey.ONLYVIDEO) && this.mAudioOnly.equals(LiveConfigKey.ONLYAUDIO)) {
                this.mStreamFormat = LiveConfigKey.AVPH;
                this.mLogService.setFormatInfo(LiveConfigKey.AVPH, LiveConfigKey.AVPH);
            }
        }
        if (TextUtils.isEmpty(this.mStreamFormat) || !this.mStreamFormat.equals(LiveConfigKey.AVPH)) {
            return;
        }
        _configAvphNeqStrategy();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void _smartResolveDefaultResolution(String str) {
        char c6;
        char c7;
        if (this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && this.mEnableResolutionAutoDegrade && !TextUtils.isEmpty(str)) {
            String str2 = str;
            if (str2.equals(LiveConfigKey.LOW)) {
                while (!TextUtils.isEmpty(str2)) {
                    if (!TextUtils.isEmpty(this.mURLSource.getPlayURLForResolution(str2, this.mStreamFormat, this.mLevel))) {
                        this.mURLSource.setDefaultResolution(str2);
                        this.mLogService.mAutoUsingResolution = this.mURLSource.getDefaultResolution();
                        return;
                    }
                    str2.getClass();
                    switch (str2.hashCode()) {
                        case -1008619738:
                            if (str2.equals("origin")) {
                                c7 = 0;
                                break;
                            }
                            c7 = 65535;
                            break;
                        case 3324:
                            if (str2.equals(LiveConfigKey.HIGH)) {
                                c7 = 1;
                                break;
                            }
                            c7 = 65535;
                            break;
                        case 3448:
                            if (str2.equals(LiveConfigKey.LOW)) {
                                c7 = 2;
                                break;
                            }
                            c7 = 65535;
                            break;
                        case 3665:
                            if (str2.equals(LiveConfigKey.STANDARD)) {
                                c7 = 3;
                                break;
                            }
                            c7 = 65535;
                            break;
                        case 115761:
                            if (str2.equals(LiveConfigKey.UHD)) {
                                c7 = 4;
                                break;
                            }
                            c7 = 65535;
                            break;
                        default:
                            c7 = 65535;
                            break;
                    }
                    switch (c7) {
                        case 0:
                        default:
                            str2 = null;
                            break;
                        case 1:
                            str2 = LiveConfigKey.UHD;
                            break;
                        case 2:
                            str2 = LiveConfigKey.STANDARD;
                            break;
                        case 3:
                            str2 = LiveConfigKey.HIGH;
                            break;
                        case 4:
                            str2 = "origin";
                            break;
                    }
                }
                return;
            }
            while (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(this.mURLSource.getPlayURLForResolution(str2, this.mStreamFormat, this.mLevel))) {
                    this.mURLSource.setDefaultResolution(str2);
                    this.mLogService.mAutoUsingResolution = this.mURLSource.getDefaultResolution();
                    return;
                }
                str2.getClass();
                switch (str2.hashCode()) {
                    case -1008619738:
                        if (str2.equals("origin")) {
                            c6 = 0;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 3324:
                        if (str2.equals(LiveConfigKey.HIGH)) {
                            c6 = 1;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 3448:
                        if (str2.equals(LiveConfigKey.LOW)) {
                            c6 = 2;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 3665:
                        if (str2.equals(LiveConfigKey.STANDARD)) {
                            c6 = 3;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 115761:
                        if (str2.equals(LiveConfigKey.UHD)) {
                            c6 = 4;
                            break;
                        }
                        c6 = 65535;
                        break;
                    default:
                        c6 = 65535;
                        break;
                }
                switch (c6) {
                    case 0:
                        str2 = LiveConfigKey.UHD;
                        break;
                    case 1:
                        str2 = LiveConfigKey.STANDARD;
                        break;
                    case 2:
                    default:
                        str2 = null;
                        break;
                    case 3:
                        str2 = LiveConfigKey.LOW;
                        break;
                    case 4:
                        str2 = LiveConfigKey.HIGH;
                        break;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                MyLog.w(TAG, str2 + " not found");
            }
        }
    }

    private void _stop(boolean z5, String str) {
        MyLog.i(TAG, "_stop");
        LivePlayerState livePlayerState = this.mLivePlayerState;
        if (livePlayerState != LivePlayerState.PLAYED && livePlayerState != LivePlayerState.PAUSED) {
            this.mLogService.onIllegalAPICall(str);
            this.mListener.onReportALog(6, "illegal call: " + str + " -- " + hashCode());
            return;
        }
        if (z5) {
            _stopPlayer();
        } else {
            this.mPrepareState = PlayerState.INITIALIZED;
        }
        _stopLiveManager(str);
        this.mLivePlayerState = LivePlayerState.STOPPED;
        this.mSupportSRScene = 0;
        this.mTextureSRMode = 0;
        this.mEnableReportSessionStop = 0;
        LiveLoggerService liveLoggerService = this.mLogService;
        liveLoggerService.mMuteAudio = -1;
        liveLoggerService.mVolumeSetting = -1.0f;
        liveLoggerService.mPlayerVolumeSetting = -1.0f;
    }

    private void _stopLiveManager(String str) {
        MyLog.i(TAG, "_stopLiveManager");
        LiveDataFetcher liveDataFetcher = this.mFetcher;
        if (liveDataFetcher != null) {
            liveDataFetcher.cancel();
        }
        DnsHelper dnsHelper = this.mDnsParser;
        if (dnsHelper != null) {
            dnsHelper.cancel();
        }
        LivePlayerState livePlayerState = this.mLivePlayerState;
        if (livePlayerState == LivePlayerState.PLAYED || livePlayerState == LivePlayerState.PAUSED) {
            onRenderStallForRetryStop();
            if (this.mIsStalling) {
                this.mLogService.onStallEnd(0);
            }
            this.mLogService.close(str);
        }
        setIntOption(75, 0);
        this.mLogService.reset();
        this.mRetryProcessor.reset();
        if (str.equals("reset")) {
            this.mURLSource.reset();
        }
        this.mShowedFirstFrame = false;
        this.mRenderStartEntered = false;
        this.mResolutionDisableSR = true;
        this.mMediaSupportSR = false;
        this.mStallStartTime = 0L;
        this.mStallTotalTime = 0L;
        this.mStallCount = 0;
        this.mIsRequestCanceled = true;
        this.mLivePlayerState = LivePlayerState.STOPPED;
        this.mHasSeiInfo = false;
        this.mGetSeiCurrentTime = 0L;
        this.mIsStalling = false;
        this.mIsRetrying = false;
        this.mHasRetry = false;
        this.mSupportBackupIp = true;
        this.mUrlSettingMethod = -1;
        this.mEnableDTSCheck = 0;
        this.mEnablePreventDTSBack = 0;
        this.mEnableCheckFrame = 0;
        this.mEnterStallRetryInstantly = false;
        this.mEnableAvLines = "";
        this.mEnableSaveSCFG = false;
        this.mStreamFormat = LiveConfigKey.FLV;
        this.mTransportProtocol = LiveConfigKey.TCP;
        this.mSuggestProtocol = "none";
        this.mEnableVideoMpdRefresh = 1;
        this.mEnableQuicCertVerify = false;
        this.mTextureSRMode = 0;
        this.mSupportSRScene = 0;
        this.mEnableTextureSR = 0;
        this.mEnableTextureRender = 0;
        this.mQuicVersion = 39;
        this.mQuicInitMTU = 1200;
        this.mEnableQuicMTUDiscovery = 0;
        this.mQuicInitRtt = 0;
        this.mQuicMaxCryptoRetransmissions = 0;
        this.mQuicMaxCryptoRetransmissionTimeMs = 0;
        this.mQuicMaxRetransmissions = 0;
        this.mQuicMaxRetransmissionTimeMs = 0;
        this.mQuicMaxAckDelay = 0;
        this.mQuicMinReceivedBeforeAckDecimation = 0;
        this.mQuicPadHello = 1;
        this.mQuicFixWillingAndAbleToWrite = 1;
        this.mQuicFixProcessTimer = 1;
        this.mQuicReadBlockTimeout = 100;
        this.mQuicReadBlockMode = 0;
        this.mQuicFixStreamFinAndRst = 0;
        this.mQuicConfigOptimize = 0;
        this.mEnableCheckDropAudio = 0;
        this.mIsPlayWithMdl = false;
        this.mAVNoSyncThreshold = 10000;
        this.mIsAlwaysDoAVSync = 0;
        this.mRedoDns = false;
        this.mEnableLiveAbrCheckEnhance = 0;
        this.mLiveABRCheckInterval = 1000;
        this.mABRMethod = -1;
        this.mRtcEnableDtls = 0;
        this.mRtcFallbackThreshold = 5000;
        this.mRtcMinJitterBuffer = 300;
        this.mRtcPlayFallBack = 0;
        this.mEnableRtcPlay = 0;
        this.mRtcEnableSDKDns = 0;
        this.mRtcEarlyInitRender = 0;
        this.mEnableFreeFlow = 0;
        this.mABRDisableAlgorithm = 0;
        this.mTextureRenderFirstFrame = false;
        this.mUsePlayerRenderStart = false;
        mFastOpenDuration = -1;
        this.mMyHandler.removeCallbacksAndMessages(null);
        if (this.mEnableStallCounter == 1) {
            stopStallCounter();
        }
        this.mNoSyncReportMinDuration = 5000;
        this.mNoSyncReportReportThres = 200;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _stopPlayer() {
        PlayerState playerState;
        MyLog.i(TAG, "_stopPlayer");
        if (this.mPlayer != null && ((playerState = this.mPrepareState) == PlayerState.PREPARED || playerState == PlayerState.PREPARING)) {
            LiveLoggerService liveLoggerService = this.mLogService;
            if (liveLoggerService != null) {
                liveLoggerService.getABRStreamInfo();
                this.mLogService.getAVPHStreamInfo();
                if (this.mEnableCheckFrame == 1 || this.mEnableCheckSEI == 1) {
                    this.mLogService.resetStreamCheckParams();
                }
            }
            if (this.mLivePlayerState != LivePlayerState.PAUSED) {
                this.mPlayer.stop();
            } else {
                this.mPlayer.reset();
            }
        }
        if (this.mIsPlayWithMdl && this.mSessionId != null) {
            MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(8018, this.mSessionId, 0);
        }
        this.mPrepareState = PlayerState.INITIALIZED;
        MyLog.i(TAG, "prepareState: " + this.mPrepareState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abrDegradeResolution() {
        String playURLForResolution;
        int length = LiveConfigKey.resolution.length - 1;
        while (true) {
            if (length < 0) {
                length = -1;
                break;
            }
            if (this.mURLSource.isSupportResolution(LiveConfigKey.resolution[length])) {
                break;
            }
            length--;
        }
        if (length == -1) {
            return false;
        }
        StringBuilder sb = new StringBuilder("abrDegradeResolution, resolution: ");
        String[] strArr = LiveConfigKey.resolution;
        sb.append(strArr[length]);
        sb.append(", auto defalut resolution: ");
        sb.append(this.mURLSource.getDefaultResolution());
        MyLog.i(TAG, sb.toString());
        if (this.mURLSource.getDefaultResolution().equals(strArr[length]) || (playURLForResolution = this.mURLSource.getPlayURLForResolution(strArr[length], this.mStreamFormat, "main")) == null) {
            return false;
        }
        String str = this.mCurrentPlayURL;
        this.mCurrentPlayURL = playURLForResolution;
        this.mResolutionIndex = length;
        this.mURLSource.setDefaultResolution(strArr[length]);
        this.mLogService.mAutoUsingResolution = strArr[length];
        saveCurrentResolution();
        this.mLogService.onSwitch(str, this.mCurrentPlayURL, "auto_" + this.mLogService.mLastResolution + "_to_" + this.mResolution, LiveError.PLAYER_STALL);
        this.mLogService.onSwitchURL(this.mCurrentPlayURL);
        this.mLevel = "main";
        this.mStallCount = 0;
        parsePlayDNS(playURLForResolution);
        return true;
    }

    static /* synthetic */ int access$4408(VideoLiveManager videoLiveManager) {
        int i6 = videoLiveManager.mStallCount;
        videoLiveManager.mStallCount = i6 + 1;
        return i6;
    }

    private void addRtcCodecInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.mLogService.mCodecName) || "none_codec".equals(this.mLogService.mCodecName)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("video_codec_impl_name")) {
                    String optString = jSONObject.optString("video_codec_impl_name");
                    if (!TextUtils.isEmpty(optString)) {
                        if ("MediaCodec".equals(optString)) {
                            LiveLoggerService liveLoggerService = this.mLogService;
                            liveLoggerService.mCodecName = "hardware_codec";
                            liveLoggerService.mHardDecodeEnable = true;
                        } else {
                            LiveLoggerService liveLoggerService2 = this.mLogService;
                            liveLoggerService2.mCodecName = "software_codec";
                            liveLoggerService2.mHardDecodeEnable = false;
                        }
                    }
                }
                if (jSONObject.has("video_codec_name")) {
                    String optString2 = jSONObject.optString("video_codec_name");
                    if (!TextUtils.isEmpty(optString2)) {
                        if ("ByteVC1".equalsIgnoreCase(optString2)) {
                            this.mLogService.mCodecType = "bytevc1";
                        } else {
                            this.mLogService.mCodecType = IjkMediaFormat.CODEC_NAME_H264;
                        }
                    }
                }
                MyLog.i(TAG, "addRtcCodecInfo mCodecName:" + this.mLogService.mCodecName + ", mCodecType:" + this.mLogService.mCodecType + ",mHardDecodeEnable:" + this.mLogService.mHardDecodeEnable);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bytevc1DegradeH264(int i6) {
        String str;
        if (this.mURLAbility != 2 || (str = this.mURLSource.getPlayURLByCodec(IjkMediaFormat.CODEC_NAME_H264).mainURL) == null) {
            return false;
        }
        updateDownloadSizeStat();
        this.mLogService.onSessionStop();
        this.mIsRetrying = true;
        this.mLogService.onSwitchURL(str);
        this.mLogService.onSwitch(this.mCurrentPlayURL, str, "bytevc1_to_h264", i6);
        this.mCurrentPlayURL = str;
        this.mURLAbility = 1;
        this.mLogService.mUrlAbility = IjkMediaFormat.CODEC_NAME_H264;
        if (this.mHardwareDecodeEnable != 1 && this.mEnableH264HardwareDecode == 1) {
            this.mHardwareDecodeEnable = 1;
            this.mDefaultCodecId = 0;
            this.mPlayer.setIntOption(59, 1);
            this.mLogService.enableHardDecode(this.mHardwareDecodeEnable == 1);
        }
        _resetPlayer();
        this.mSessionStartTime = System.currentTimeMillis();
        parsePlayDNS(str);
        return true;
    }

    private void checkMainLooper(String str) {
        LiveLoggerService liveLoggerService;
        if (this.mIsInMainLooper != 1 || Looper.myLooper() == Looper.getMainLooper() || (liveLoggerService = this.mLogService) == null) {
            return;
        }
        liveLoggerService.onCallNotInMainThread(str);
    }

    private void configPlayerEventHandler() {
        this.mPlayer.setOnPreparedListener(new MyPreparedListener(this));
        this.mPlayer.setOnErrorListener(new MyErrorListener(this));
        this.mPlayer.setOnInfoListener(new MyInfoListener(this));
        this.mPlayer.setOnCompletionListener(new MyCompletionListener(this));
        this.mPlayer.setOnVideoSizeChangedListener(new MyOnVideoSizeChangedListener(this));
    }

    private void configPlayerInstanceOption() {
        String str;
        this.mLogService.setProtocolInfo(this.mSuggestProtocol, this.mTransportProtocol);
        this.mLogService.setSdkParams(this.mURLSource.getSDKParams(this.mResolution, this.mLevel));
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null && (str = this.mStreamFormat) != null) {
            mediaPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, str);
        }
        MediaPlayer mediaPlayer2 = this.mPlayer;
        if (mediaPlayer2 == null || this.mEnableAudioVolumeBalance != 1) {
            return;
        }
        mediaPlayer2.setIntOption(302, 1);
        float f6 = this.mAudioVolumeBalancePregain;
        if (f6 != -1.0f) {
            this.mPlayer.setFloatOption(303, f6);
        }
        float f7 = this.mAudioVolumeBalanceThreshold;
        if (f7 != -1.0f) {
            this.mPlayer.setFloatOption(304, f7);
        }
        float f8 = this.mAudioVolumeBalanceRatio;
        if (f8 != -1.0f) {
            this.mPlayer.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, f8);
        }
        float f9 = this.mAudioVolumeBalancePredelay;
        if (f9 != -1.0f) {
            this.mPlayer.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY, f9);
        }
    }

    private void configToBParams() {
        MediaPlayer mediaPlayer;
        if (this.mSwitchToB != 1 || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        mediaPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_NAME, this.mMoudleIDToB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean degradeResolution() {
        String[] strArr;
        String playURLForResolution;
        if (this.mResolution == LiveConfigKey.LOW) {
            return false;
        }
        if (this.mResolutionIndex == -1) {
            int i6 = 0;
            while (true) {
                String[] strArr2 = LiveConfigKey.resolution;
                if (i6 >= strArr2.length) {
                    break;
                }
                if (strArr2[i6].equals(this.mResolution)) {
                    this.mResolutionIndex = i6;
                    break;
                }
                i6++;
            }
        }
        int i7 = this.mResolutionIndex + 1;
        while (true) {
            strArr = LiveConfigKey.resolution;
            if (i7 >= strArr.length || this.mURLSource.isSupportResolution(strArr[i7])) {
                break;
            }
            i7++;
        }
        if (i7 >= strArr.length || (playURLForResolution = this.mURLSource.getPlayURLForResolution(strArr[i7], this.mStreamFormat, this.mLevel)) == null) {
            return false;
        }
        String str = this.mCurrentPlayURL;
        this.mCurrentPlayURL = playURLForResolution;
        this.mResolutionIndex = i7;
        saveCurrentResolution();
        LiveLoggerService liveLoggerService = this.mLogService;
        String str2 = strArr[i7];
        this.mResolution = str2;
        liveLoggerService.mResolution = str2;
        liveLoggerService.onSwitch(str, this.mCurrentPlayURL, "auto_" + this.mLogService.mLastResolution + "_to_" + this.mResolution, LiveError.PLAYER_STALL);
        ILiveListener iLiveListener = this.mListener;
        if (iLiveListener != null) {
            iLiveListener.onResolutionDegrade(this.mResolution);
        }
        this.mLogService.onSwitchURL(this.mCurrentPlayURL);
        this.mStallCount = 0;
        parsePlayDNS(playURLForResolution);
        return true;
    }

    private JSONObject extractAvphStreamInfo(String str) {
        int i6;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "video_open_input_cost";
        String str8 = "av_dts_diff";
        String str9 = "audio_cur_dts";
        String str10 = "video_last_dts";
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String str11 = "video_find_stream_info_cost";
            String[] split = str.split(",");
            int length = split.length;
            int i7 = 0;
            while (i7 < length) {
                int i8 = i7;
                String str12 = split[i8];
                if (str12.startsWith("video_key")) {
                    i6 = length;
                    jSONObject.put("video_key", Integer.parseInt(str12.substring(10)));
                } else {
                    i6 = length;
                    if (str12.startsWith(str10)) {
                        jSONObject.put(str10, Integer.parseInt(str12.substring(15)));
                    } else {
                        str2 = str10;
                        if (str12.startsWith("video_cur_dts")) {
                            jSONObject.put("video_cur_dts", Integer.parseInt(str12.substring(14)));
                        } else if (str12.startsWith("vv_dts_diff")) {
                            jSONObject.put("vv_dts_diff", Integer.parseInt(str12.substring(12)));
                        } else if (str12.startsWith(str9)) {
                            jSONObject.put(str9, Integer.parseInt(str12.substring(14)));
                        } else if (str12.startsWith(str8)) {
                            jSONObject.put(str8, Integer.parseInt(str12.substring(12)));
                        } else {
                            if (str12.startsWith("audio_first_pkt_ts")) {
                                str3 = str8;
                                str4 = str9;
                                jSONObject.put("audio_first_pkt_ts", Long.parseLong(str12.substring(19)));
                            } else {
                                str3 = str8;
                                str4 = str9;
                                if (str12.startsWith("audio_first_pkt_dts")) {
                                    jSONObject.put("audio_first_pkt_dts", Long.parseLong(str12.substring(20)));
                                } else if (str12.startsWith("video_first_pkt_ts")) {
                                    jSONObject.put("video_first_pkt_ts", Long.parseLong(str12.substring(19)));
                                } else if (str12.startsWith("video_first_pkt_dts")) {
                                    jSONObject.put("video_first_pkt_dts", Long.parseLong(str12.substring(20)));
                                } else if (str12.startsWith("audio_open_input_cost")) {
                                    jSONObject.put("audio_open_input_cost", Long.parseLong(str12.substring(22)));
                                } else if (str12.startsWith("audio_find_stream_info_cost")) {
                                    jSONObject.put("audio_find_stream_info_cost", Long.parseLong(str12.substring(28)));
                                } else if (str12.startsWith(str7)) {
                                    jSONObject.put(str7, Long.parseLong(str12.substring(22)));
                                } else {
                                    str5 = str11;
                                    if (str12.startsWith(str5)) {
                                        str6 = str7;
                                        jSONObject.put(str5, Long.parseLong(str12.substring(28)));
                                        i7 = i8 + 1;
                                        str11 = str5;
                                        str7 = str6;
                                        str8 = str3;
                                        length = i6;
                                        str10 = str2;
                                        str9 = str4;
                                    }
                                    str6 = str7;
                                    i7 = i8 + 1;
                                    str11 = str5;
                                    str7 = str6;
                                    str8 = str3;
                                    length = i6;
                                    str10 = str2;
                                    str9 = str4;
                                }
                            }
                            str6 = str7;
                            str5 = str11;
                            i7 = i8 + 1;
                            str11 = str5;
                            str7 = str6;
                            str8 = str3;
                            length = i6;
                            str10 = str2;
                            str9 = str4;
                        }
                        str3 = str8;
                        str4 = str9;
                        str5 = str11;
                        str6 = str7;
                        i7 = i8 + 1;
                        str11 = str5;
                        str7 = str6;
                        str8 = str3;
                        length = i6;
                        str10 = str2;
                        str9 = str4;
                    }
                }
                str4 = str9;
                str2 = str10;
                str6 = str7;
                str3 = str8;
                str5 = str11;
                i7 = i8 + 1;
                str11 = str5;
                str7 = str6;
                str8 = str3;
                length = i6;
                str10 = str2;
                str9 = str4;
            }
            return jSONObject;
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        } catch (Exception e7) {
            vl.j(e7);
            return null;
        }
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    private void open() {
        TTPlayerConfiger.setValue(1, this.mPlayerType != 0);
        TTPlayerConfiger.setValue(2, this.mPlayerType == 2);
        TTPlayerConfiger.setValue(6, false);
        TTPlayerConfiger.setValue(11, true);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isOSPlayer() ^ (this.mPlayerType == 0)) {
                this.mPlayer.releaseAsync();
                this.mPlayer = null;
            }
        }
        if (this.mPlayer == null) {
            this.mPlayer = MediaPlayerWrapper.create(this.mContext, this.mPlayerDegradeMode);
            MediaLoaderWrapper.getDataLoader().setMediaPlayer(this.mPlayer);
            if (this.mPlayer.getPlayerType() != 1 && this.mPlayer.getPlayerType() != 2) {
                this.mHardwareDecodeEnable = 0;
                this.mEnableH264HardwareDecode = 0;
                this.mEnableByteVC1HardwareDecode = 0;
            }
            configPlayerGlobalOption();
            configPlayerEventHandler();
        }
        if (this.mPlayer.isOSPlayer()) {
            this.mLogService.setPlayerSdkVersion("-1");
        } else {
            this.mLogService.setPlayerSdkVersion(TTPlayerConfiger.getValue(14, "0"));
        }
        this.mDnsParser.configure(this.mForceHttpDns, this.mHttpDNSServerHost);
        if (this.mFetcher == null) {
            this.mFetcher = new LiveDataFetcher(this.mExecutor, this.mNetworkClient);
        }
        this.mPlayerSetting.setPlayer(this.mPlayer);
    }

    private String packAvphHeader(String str, String str2, String str3) {
        if (!str.equals("")) {
            str = str + ContainerUtils.FIELD_DELIMITER;
        }
        return ((str + str2) + ContainerUtils.KEY_VALUE_DELIMITER) + str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (r3.equals(com.bykv.vk.component.ttvideo.LiveConfigKey.TLS) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parsePlayDNS(final java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager.parsePlayDNS(java.lang.String):void");
    }

    private void parseResponseHeaders(LogBundle logBundle) {
        String stringOption = this.mPlayer.getStringOption(335);
        if (stringOption == null) {
            return;
        }
        for (String str : stringOption.split(g.f50795q)) {
            if (str.startsWith("X-Server-Ip: ")) {
                logBundle.headerXServerIP = str.split(": ", 2)[1];
            } else if (str.startsWith("Via: ")) {
                logBundle.headerVia = str.split(": ", 2)[1];
            }
        }
    }

    private void prepareAvphPlay() {
        this.mPlayer.setIntOption(159, this.mFramesDrop);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM, this.mEnableSkipFindUnnecessaryStream);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AVPH_DNS_PARSE, this.mAVPHDnsParseEnable);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT, this.mAVPHDnsTimeout);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE, this.mAVPHVideoProbesize);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_MAXDURATION, this.mAVPHVideoMaxDuration);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, this.mAVPHAudioProbesize);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_MAXDURATION, this.mAVPHAudioMaxDuration);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST, this.mAVPHOpenVideoFirst);
        this.mPlayer.setIntOption(331, this.mAVPHMaxAVDiff);
        this.mPlayer.setIntOption(332, this.mAVPHEnableAutoReopen);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_EXIT, this.mAVPHAutoExit);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_VIDEO_DIFF_THRESHOLD, this.mAVPHVideoDiffThreshold);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, this.mAVPHReadRetryCount);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_ERROR_EXIT, this.mAVPHReadErrorExit);
        String str = new String();
        String str2 = new String();
        if (this.mAudioOnly.equals(LiveConfigKey.ONLYAUDIO)) {
            str = packAvphHeader(str, "only_audio", "1");
        }
        if (this.mVideoOnly.equals(LiveConfigKey.ONLYVIDEO)) {
            str2 = packAvphHeader(str2, "only_video", "1");
        }
        this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_QUERY, str);
        this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, str2);
    }

    private String prepareProxyURL(String str, String str2, String str3, Map<String, String> map) {
        MyLog.i(TAG, "prepareProxy play url: " + str + ", host: " + str3);
        if (!this.mTransportProtocol.equals(LiveConfigKey.TCP) || !this.mStreamFormat.equals(LiveConfigKey.FLV) || this.mEnableResolutionAutoDegrade || TextUtils.isEmpty(this.mSessionId)) {
            String str4 = "proxy not support format: " + this.mStreamFormat + ", proto: " + this.mTransportProtocol + ", abr: " + this.mEnableResolutionAutoDegrade + ", sessio id invalid: " + TextUtils.isEmpty(this.mSessionId);
            MyLog.i(TAG, str4);
            this.mLogService.mLiveIOErrorMsg = str4;
            return null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            try {
                URL url = new URL(str);
                String url2 = new URL(url.getProtocol(), str3, url.getPort() == -1 ? url.getDefaultPort() : url.getPort(), url.getFile()).toString();
                MyLog.i(TAG, "prepareProxy proxy url: " + url2);
                MyLog.i(TAG, "enable liveio:" + this.mEnableOpenLiveIO + " enable liveio play:" + this.mEnableLiveIOPlay);
                MyLog.i(TAG, "live mdl enable_from_sdk:" + this.mEnableOpenMDL + " enable_from_app:" + MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(AVMDLDataLoader.KeyIsLiveLoaderEnable) + " is_running:" + MediaLoaderWrapper.getDataLoader().isRunning());
                if (this.mEnableOpenMDL == 1 && MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(AVMDLDataLoader.KeyIsLiveLoaderEnable) == 1 && MediaLoaderWrapper.getDataLoader().isRunning()) {
                    if (this.mALogWriteAddr != -1) {
                        MediaLoaderWrapper.getDataLoader().setLongValue(59, this.mALogWriteAddr);
                    }
                    this.mIsPlayWithMdl = true;
                    runOnCurrentThread(new PlayCacheSyncRunner(this, this.mSessionId, false));
                    MyLog.i(TAG, "setup mdl play cache sync runner of :" + this.mSessionId);
                    String proxyUrl = MediaLoaderWrapper.getDataLoader().getProxyUrl(url2, Boolean.valueOf(this.mIsMdlProtoRegister));
                    MyLog.i(TAG, "proxyUrl: " + proxyUrl);
                    if (proxyUrl != null && !proxyUrl.isEmpty()) {
                        map.put("Stream-Type", ILivePush.ClickType.LIVE);
                        String str5 = this.mSessionId;
                        if (str5 != null) {
                            map.put("X-Tt-Traceid", str5);
                        }
                        if (str2 != null && !str2.equals("none")) {
                            if (str2.startsWith("[")) {
                                str2 = str2.substring(1, str2.length() - 1);
                            }
                            map.put("X-Given-IPs", str2);
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("url", proxyUrl);
                            if (str2 != null) {
                                jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, str2);
                            }
                            String str6 = this.mSessionId;
                            if (str6 != null) {
                                jSONObject.put("traceId", str6);
                            }
                            MediaLoaderWrapper.getDataLoader().setStringValue(8017, jSONObject.toString());
                            return proxyUrl;
                        } catch (Exception unused) {
                            MyLog.w(TAG, "set play info to mdl failed");
                            return proxyUrl;
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareToPlay(String str, String str2, String str3, String str4) {
        char c6;
        String str5;
        String str6;
        boolean z5;
        Map<String, String> map;
        int i6;
        int i7;
        String str7 = str;
        long currentTimeMillis = System.currentTimeMillis();
        this.mLogService.mLastPrepareTime = currentTimeMillis;
        if (this.mUuid != null) {
            this.mSessionId = this.mUuid + "." + currentTimeMillis;
        }
        MyLog.i(TAG, "prepareToPlay:" + str7);
        if (str7 == null || this.mPlayer == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (str4 != null) {
            c6 = 0;
            hashMap.put("Host", String.format(" %s", str4));
        } else {
            c6 = 0;
        }
        Map<String, String> hTTPHeaders = this.mURLSource.getHTTPHeaders();
        if (hTTPHeaders != null) {
            hashMap.putAll(hTTPHeaders);
            MyLog.i(TAG, "headers: " + hashMap.toString());
        }
        if (this.mTransportProtocol.equals(LiveConfigKey.QUIC) || this.mTransportProtocol.equals(LiveConfigKey.QUICU)) {
            hashMap.put("suggest_protocol", LiveConfigKey.QUIC);
            if (this.mEnableSaveSCFG) {
                this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SCFG_ADDRESS, xt.j(this.mContext).getAbsolutePath() + "/pullstream.scfg");
            }
            if (this.mEnableQuicCertVerify) {
                try {
                    Class<?> cls = Class.forName("com.ss.avframework.transport.ContextUtils");
                    Class<?>[] clsArr = new Class[1];
                    clsArr[c6] = Context.class;
                    Method method = cls.getMethod("initApplicationContext", clsArr);
                    method.setAccessible(true);
                    Object[] objArr = new Object[1];
                    objArr[c6] = StubApp.getOrigApplicationContext(this.mContext.getApplicationContext());
                    method.invoke(null, objArr);
                    Class<?> cls2 = Class.forName("com.ss.avframework.transport.JNIUtils");
                    Class<?>[] clsArr2 = new Class[1];
                    clsArr2[c6] = ClassLoader.class;
                    Method method2 = cls2.getMethod("setClassLoader", clsArr2);
                    method2.setAccessible(true);
                    Object[] objArr2 = new Object[1];
                    objArr2[c6] = this.mContext.getClassLoader();
                    method2.invoke(null, objArr2);
                } catch (Throwable th) {
                    this.mEnableQuicCertVerify = false;
                    vl.r(TAG, "disable quic cert verify, " + th.toString());
                }
            }
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, this.mQuicVersion);
            this.mPlayer.setIntOption(354, this.mEnableQuicCertVerify ? 1 : 0);
            this.mPlayer.setIntOption(357, this.mEnableQuicMTUDiscovery);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU, this.mQuicInitMTU);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, this.mQuicInitRtt);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS, this.mQuicMaxCryptoRetransmissions);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS, this.mQuicMaxCryptoRetransmissionTimeMs);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSIONS, this.mQuicMaxRetransmissions);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS, this.mQuicMaxRetransmissionTimeMs);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY, this.mQuicMaxAckDelay);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION, this.mQuicMinReceivedBeforeAckDecimation);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, this.mQuicPadHello);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE, this.mQuicFixWillingAndAbleToWrite);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, this.mQuicFixProcessTimer);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT, this.mQuicReadBlockTimeout);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, this.mQuicReadBlockMode);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST, this.mQuicFixStreamFinAndRst);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION, this.mQuicTimerVersion);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE, this.mQuicConfigOptimize);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, this.mEnableSkipFlvNullTag);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE, this.mTransportProtocol.equals(LiveConfigKey.QUICU) ? 1 : 0);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, this.mSessionReceiveWindow);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW, this.mStreamReceiveWindow);
            LiveLoggerService liveLoggerService = this.mLogService;
            liveLoggerService.mQuicMtu = this.mQuicInitMTU;
            liveLoggerService.mQuicScfgConfig = this.mEnableSaveSCFG ? 1 : 0;
            liveLoggerService.mQuicPadHello = this.mQuicPadHello;
            liveLoggerService.mQuicTimerVersion = this.mQuicTimerVersion;
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI, this.mEnableDecodeMultiSei);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, this.mEnableDecodeSeiOnce);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS, this.mForceDecodeMsGaps);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_SWITCH, this.mForceDecodeSwitch);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, this.mForceRenderMsGaps);
        _configFlvLowLatencyWithSDKParam();
        this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES, this.mStartPlayBufferThres);
        this.mLogService.mStartPlayBufferThres = this.mStartPlayBufferThres;
        configPlayerInstanceOption();
        if (this.mPrepareState == PlayerState.PREPARED) {
            this.mPrepareState = PlayerState.INITIALIZED;
            this.mPlayer.reset();
            if (this.mCacheFileEnable == 1 && !TextUtils.isEmpty(this.mCacheFilePath) && !TextUtils.isEmpty(this.mCacheFileKey) && !this.mIsCacheHasComplete) {
                this.mPlayer.setStringOption(17, this.mCacheFileKey);
                this.mPlayer.setIntOption(14, 1);
                this.mPlayer.setCacheFile(this.mCacheFilePath, 1);
            }
        }
        int checkSilenceInterval = this.mURLSource.getCheckSilenceInterval(this.mResolution, this.mLevel);
        this.mLogService.setCheckSilenceInterval(checkSilenceInterval);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, checkSilenceInterval);
        StringBuilder sb = new StringBuilder("mEnableResolutionAutoDegrade:");
        sb.append(this.mEnableResolutionAutoDegrade);
        sb.append(";mAbrStrategy:");
        sb.append(this.mAbrStrategy);
        sb.append(";mResolution:");
        sb.append(this.mResolution);
        if (this.mResolution.equals("auto")) {
            str5 = JPushConstants.HTTP_PRE;
            str6 = ";auto default resolution:" + this.mURLSource.getDefaultResolution();
        } else {
            str5 = JPushConstants.HTTP_PRE;
            str6 = "";
        }
        sb.append(str6);
        MyLog.i(TAG, sb.toString());
        LiveLoggerService liveLoggerService2 = this.mLogService;
        liveLoggerService2.mFirstAudioPacketDTS = -1L;
        long j6 = this.mLatestAudioPacketDTS;
        if (j6 > 0) {
            liveLoggerService2.mPreviousAudioPacketDTS = j6;
        }
        String str8 = this.mResolution;
        liveLoggerService2.mResolution = str8;
        liveLoggerService2.mResBitrate = this.mURLSource.getBitrate(str8.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, this.mLevel);
        if (this.mEnablePreventDTSBack == 1 && this.mFrameTerminatedDTS != -1 && this.mPlayer != null) {
            MyLog.i(TAG, "prepareToPlay set dts:" + this.mFrameTerminatedDTS);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, this.mFrameTerminatedDTS);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_DTS_MAX_DIFF, this.mFrameDroppingDTSMaxDiff);
        }
        try {
            if (!this.mIsLocalURL) {
                str7 = addSessionIdToURL(str7, currentTimeMillis);
            }
            if (this.mStreamFormat.equals(LiveConfigKey.FLV) && (i7 = mFastOpenDuration) != -1) {
                str7 = _addParamToURL(str7, "abr_pts", String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i7)));
            }
            if (this.mStreamFormat.equals(LiveConfigKey.CMAF)) {
                str7 = _addParamToURL(str7, "play_start", "1");
            }
            if (this.mStreamFormat.equals(LiveConfigKey.TSL)) {
                String substring = this.mCurrentPlayURL.substring(this.mCurrentPlayURL.indexOf("TimeShiftFormat=") + 16);
                if (substring.indexOf(ContainerUtils.FIELD_DELIMITER) > 0) {
                    substring = substring.substring(0, substring.indexOf(ContainerUtils.FIELD_DELIMITER));
                }
                int i8 = this.mTslTimeShift;
                if (i8 > 0) {
                    str7 = _addParamToURL(str7, substring, String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i8)));
                }
            }
            if (this.mTransportProtocol.equals(LiveConfigKey.QUICU)) {
                str7 = _addParamToURL(str7, "unreliable", "1");
            }
            if (this.mResolution.equals("auto") && this.mEnableResolutionAutoDegrade && this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && this.mURLSource.getSourceType() == 2 && this.mStreamFormat.equals(LiveConfigKey.FLV)) {
                this.mLogService.mAutoUsingResolution = this.mURLSource.getDefaultResolution();
                long j7 = this.mTargetOriginBitRate;
                if (j7 > 0 && this.mURLSource.adjustOriginBitRate(this.mStreamFormat, this.mLevel, j7)) {
                    this.mLogService.mBitRateAbnormalType = 1;
                }
                this.mURLSource.setRequestParamsWithDNSIp("_session_id=" + this.mLogService.mSessionId, str3, str4);
                String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution, this.mStreamFormat, this.mLevel);
                MyLog.i(TAG, "mpd url:" + playURLForResolution);
                if (playURLForResolution != null) {
                    str7 = HTTP_FLV_ABR_PREFIX + playURLForResolution;
                }
                if (playURLForResolution != null) {
                    this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, "llash");
                }
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 1);
                if (this.mShowedFirstFrame && (i6 = this.mEnableLLASHFastOpen) == 1) {
                    this.mPlayer.setIntOption(532, i6);
                }
                int i9 = this.mEnableLiveAbrCheckEnhance;
                if (i9 == 1) {
                    this.mLogService.mEnableLiveAbrCheckEnhance = 1;
                    this.mPlayer.setIntOption(533, i9);
                    this.mPlayer.setIntOption(534, this.mLiveABRCheckInterval);
                }
                int i10 = this.mABRMethod;
                if (i10 >= 0) {
                    this.mPlayer.setIntOption(535, i10);
                }
                int i11 = this.mABRBufferThreshold;
                if (i11 > 0) {
                    this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD, i11);
                }
            }
            String prepareProxyURL = prepareProxyURL(str7, str3, str4, hashMap);
            if (prepareProxyURL != null) {
                try {
                    MyLog.i(TAG, "proxyUrl: " + prepareProxyURL + " headers: " + hashMap.toString());
                    str7 = prepareProxyURL;
                } catch (Exception e6) {
                    e = e6;
                    str7 = prepareProxyURL;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("url", str7);
                    LiveError liveError = new LiveError(-100002, e.getMessage(), hashMap2);
                    if (this.mIsLocalURL) {
                        this.mListener.onError(liveError);
                        return;
                    } else {
                        this.mRetryProcessor.onError(liveError, this.mShowedFirstFrame);
                        return;
                    }
                }
            }
            if (isRtcPlayAvailable()) {
                MyLog.i(TAG, "set rtc play config parameters");
                this.mLogService.mEnableRtcPlay = 1;
                this.mPlayer.setIntOption(801, 1);
                this.mPlayer.setIntOption(802, 1);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_RECONNECT_COUNT, 3);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, 1000);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_STATS_REPORT_INTERVAL, 3000);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_FALLBACK_THRESHLOD, this.mRtcFallbackThreshold);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS, this.mRtcEnableDtls);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MIN_JITTER_BUFFER, this.mRtcMinJitterBuffer);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY, this.mRtcMaxJitterBuffer);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER, this.mRtcEarlyInitRender);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, this.mRtcEnableRtcUninitLockFree);
                if (!this.mLogService.mSessionId.equals("none")) {
                    this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, this.mLogService.mSessionId);
                    LiveLoggerService liveLoggerService3 = this.mLogService;
                    liveLoggerService3.mRtcSessionId = liveLoggerService3.mSessionId;
                }
                if (this.mRtcEnableSDKDns == 1) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("s_expect_ip", str3);
                    this.mLogService.mDnsIp = str3;
                    this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP, String.valueOf(jSONObject));
                }
                LiveLoggerService liveLoggerService4 = this.mLogService;
                liveLoggerService4.mCodecName = "";
                liveLoggerService4.mCodecType = "";
                liveLoggerService4.mHardDecodeEnable = false;
                if (this.mRtcSupportMiniSdp == 1) {
                    if (str2 != null) {
                        String str9 = str5;
                        if (str2.startsWith(str9)) {
                            String replace = str2.replace(str9, "webrtc://");
                            this.mPlayer.setDataSource(this.mContext, Uri.parse(replace), (Map<String, String>) null);
                            LiveLoggerService liveLoggerService5 = this.mLogService;
                            liveLoggerService5.mRequestUrl = replace;
                            liveLoggerService5.mEnableMiniSdp = 1;
                        }
                    }
                    map = null;
                } else {
                    map = null;
                    this.mPlayer.setDataSource(this.mContext, Uri.parse(str2), (Map<String, String>) null);
                    LiveLoggerService liveLoggerService6 = this.mLogService;
                    liveLoggerService6.mRequestUrl = str2;
                    liveLoggerService6.mEnableMiniSdp = 0;
                }
                this.mLogService.mRequestHeaders = map;
                z5 = false;
            } else {
                z5 = false;
                this.mPlayer.setIntOption(800, 0);
                this.mPlayer.setDataSource(this.mContext, Uri.parse(str7), hashMap);
                LiveLoggerService liveLoggerService7 = this.mLogService;
                liveLoggerService7.mRequestUrl = str7;
                liveLoggerService7.mRequestHeaders = hashMap;
            }
            if (this.mEnableRtcPlay == 1 && this.mRtcPlayFallBack == 1) {
                MyLog.i(TAG, "rtc fallback set hardware decode: " + this.mHardwareDecodeEnable);
                this.mPlayer.setIntOption(59, this.mHardwareDecodeEnable);
                LiveLoggerService liveLoggerService8 = this.mLogService;
                if (this.mHardwareDecodeEnable == 1) {
                    z5 = true;
                }
                liveLoggerService8.enableHardDecode(z5);
                if (this.mHardwareDecodeEnable == 1) {
                    MyLog.i(TAG, "rtc fallback enable hardware decode, mDefaultCodecId: " + this.mDefaultCodecId + ", mEnableMediaCodecASYNCInit: " + this.mEnableMediaCodecASYNCInit);
                    if (this.mDefaultCodecId != -1) {
                        this.mPlayer.setIntOption(181, this.mEnableMediaCodecASYNCInit);
                        this.mPlayer.setIntOption(182, this.mDefaultCodecId);
                        LiveLoggerService liveLoggerService9 = this.mLogService;
                        liveLoggerService9.mMediaCodecAsyncInit = this.mEnableMediaCodecASYNCInit;
                        liveLoggerService9.mDefaultCodecID = this.mDefaultCodecId;
                    }
                }
            }
            int i12 = this.mNetworkTimeout;
            if (i12 != -1 && i12 >= 1000) {
                this.mPlayer.setIntOption(9, i12 * 1000);
                MyLog.i(TAG, "networktimeout: " + this.mNetworkTimeout + " microsecond");
                this.mLogService.mNetworkTimeoutMs = this.mNetworkTimeout;
            } else if (i12 != -1) {
                MyLog.e(TAG, "networktimeout so small: " + this.mNetworkTimeout + " microsecond");
                this.mLogService.mNetworkTimeoutMs = 5000;
            }
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null) {
                setSurfaceHolder(surfaceHolder);
            } else {
                Surface surface = this.mSurface;
                if (surface != null) {
                    setSurface(surface);
                }
            }
            MediaPlayer mediaPlayer = this.mPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setScreenOnWhilePlaying(true);
            }
            if (this.mPrepareState != PlayerState.INITIALIZED) {
                return;
            }
            try {
                this.mPlayer.prepareAsync();
                this.mPrepareState = PlayerState.PREPARING;
            } catch (Exception e7) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("url", str7);
                LiveError liveError2 = new LiveError(-100001, e7.getMessage(), hashMap3);
                if (this.mIsLocalURL) {
                    this.mListener.onError(liveError2);
                } else {
                    this.mRetryProcessor.onError(liveError2, this.mShowedFirstFrame);
                }
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnCurrentThread(Runnable runnable) {
        this.mMyHandler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnCurrentThreadDelay(Runnable runnable, long j6) {
        this.mMyHandler.postDelayed(runnable, j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnFrontCurrentThread(Runnable runnable) {
        this.mMyHandler.postAtFrontOfQueue(runnable);
    }

    private void saveCurrentResolution() {
        LiveLoggerService liveLoggerService;
        if (this.mLivePlayerState == LivePlayerState.IDLE || (liveLoggerService = this.mLogService) == null) {
            return;
        }
        liveLoggerService.mLastResolution = this.mResolution.equals("auto") ? this.mLogService.mAutoUsingResolution : this.mResolution;
    }

    public static void setAppInfo(Context context, Map map) {
        if (map == null || map.size() == 0) {
            return;
        }
        AppInfo.mContext = context;
        AppInfo.mAppName = (String) map.get("app_name");
        Object obj = map.get("app_id");
        MyLog.i(TAG, "set appid:" + ((Integer) obj));
        if (obj != null) {
            AppInfo.mAppID = ((Integer) obj).intValue();
            MyLog.i(TAG, "set appid:" + AppInfo.mAppID);
        }
        AppInfo.mAppChannel = (String) map.get("app_channel");
        AppInfo.mAppVersion = (String) map.get("app_version");
        AppInfo.mDeviceId = (String) map.get("device_id");
    }

    public static void setSettingsParam(Context context, Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap hashMap = (HashMap) map;
        hashMap.put("live_pull_sdk_version", Integer.valueOf(LiveUtils.versionStringToInt("1.4.6.31-lite")));
        hashMap.put("ttm_version", Integer.valueOf(LiveUtils.versionStringToInt(TTPlayerConfiger.getValue(14, ""))));
    }

    private void startStallCounter() {
        synchronized (this.mStallCounterLock) {
            try {
                if (this.mStallCounterIsRunning) {
                    return;
                }
                if (this.mStallCounterThread == null) {
                    HandlerThread handlerThread = new HandlerThread("stallCounter");
                    this.mStallCounterThread = handlerThread;
                    handlerThread.start();
                }
                if (this.mStallCounterHandler == null) {
                    this.mStallCounterHandler = new Handler(this.mStallCounterThread.getLooper());
                }
                this.mStallCounterHandler.post(this.mVideoStallCountTask);
                this.mStallCounterIsRunning = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void stopStallCounter() {
        synchronized (this.mStallCounterLock) {
            try {
                Handler handler = this.mStallCounterHandler;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                this.mStallCounterIsRunning = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean switchMainAndBackupUrl(int i6) {
        if (this.mLevel.equals("main")) {
            String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, LiveConfigKey.FLV, LiveConfigKey.BACKUP);
            if (playURLForResolution != null) {
                updateDownloadSizeStat();
                this.mLogService.onSessionStop();
                this.mIsRetrying = true;
                this.mLogService.onSwitch(this.mCurrentPlayURL, playURLForResolution, "main_to_backup", i6);
                this.mLogService.onSwitchURL(playURLForResolution);
                this.mCurrentPlayURL = playURLForResolution;
                this.mLevel = LiveConfigKey.BACKUP;
                _setStreamFormat();
                this.mRetryProcessor.reset();
                _resetPlayer();
                this.mSessionStartTime = System.currentTimeMillis();
                this.mRedoDns = true;
                parsePlayDNS(playURLForResolution);
                this.mStallCount = 0;
                return true;
            }
        } else if (this.mLevel.equals(LiveConfigKey.BACKUP)) {
            String playURLForResolution2 = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, LiveConfigKey.FLV, "main");
            if (playURLForResolution2 != null) {
                updateDownloadSizeStat();
                this.mLogService.onSessionStop();
                this.mIsRetrying = true;
                this.mLogService.onSwitch(this.mCurrentPlayURL, playURLForResolution2, "backup_to_main", i6);
                this.mLogService.onSwitchURL(playURLForResolution2);
                this.mCurrentPlayURL = playURLForResolution2;
                this.mLevel = "main";
                _setStreamFormat();
                this.mRetryProcessor.reset();
                _resetPlayer();
                this.mSessionStartTime = System.currentTimeMillis();
                this.mRedoDns = true;
                parsePlayDNS(playURLForResolution2);
                this.mStallCount = 0;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadSizeStat() {
        long longOption = this.mPlayer.getLongOption(45, 0L);
        LiveLoggerService liveLoggerService = this.mLogService;
        liveLoggerService.mLastTotalDownloadSize += longOption;
        long j6 = liveLoggerService.mLastDownloadSizeDelta;
        if (liveLoggerService.mHaveResetPlayer) {
            liveLoggerService.mLastDownloadSizeDelta = longOption + j6;
        } else {
            liveLoggerService.mLastDownloadSizeDelta = longOption - liveLoggerService.getPlayingDownloadSize();
            this.mLogService.mHaveResetPlayer = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSessionFirstFrameInfo() {
        MediaPlayer mediaPlayer;
        LogBundle logBundle = this.mLogService.mSessionLogBundle;
        if (logBundle == null || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        logBundle.downloadSpeedOnFirstFrame = (mediaPlayer.getLongOption(63, 0L) * 8) / 1000;
        this.mLogService.mSessionLogBundle.videoBufferTimeOnFirstFrame = this.mPlayer.getLongOption(72, 0L);
        this.mLogService.mSessionLogBundle.audioBufferTimeOnFirstFrame = this.mPlayer.getLongOption(73, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void _setAvLines() {
        /*
            r6 = this;
            java.lang.String r0 = "AudioOnly"
            java.lang.String r1 = "VideoOnly"
            java.lang.String r2 = "IsEnable"
            com.bykv.vk.component.ttvideo.model.LiveInfoSource r3 = r6.mURLSource
            java.lang.String r4 = r6.mResolution
            java.lang.String r5 = r6.mLevel
            java.lang.String r3 = r3.getAvLinesParams(r4, r5)
            if (r3 != 0) goto L13
            goto L53
        L13:
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L24
            r5.<init>(r3)     // Catch: org.json.JSONException -> L24
            boolean r3 = r5.has(r2)     // Catch: org.json.JSONException -> L24
            if (r3 == 0) goto L28
            java.lang.String r2 = r5.optString(r2)     // Catch: org.json.JSONException -> L24
            goto L29
        L24:
            r0 = move-exception
            r1 = r4
            r2 = r1
            goto L44
        L28:
            r2 = r4
        L29:
            boolean r3 = r5.has(r1)     // Catch: org.json.JSONException -> L34
            if (r3 == 0) goto L37
            java.lang.String r1 = r5.optString(r1)     // Catch: org.json.JSONException -> L34
            goto L38
        L34:
            r0 = move-exception
            r1 = r4
            goto L44
        L37:
            r1 = r4
        L38:
            boolean r3 = r5.has(r0)     // Catch: org.json.JSONException -> L43
            if (r3 == 0) goto L47
            java.lang.String r4 = r5.optString(r0)     // Catch: org.json.JSONException -> L43
            goto L47
        L43:
            r0 = move-exception
        L44:
            com.bytedance.sdk.component.utils.vl.j(r0)
        L47:
            if (r2 == 0) goto L4b
            r6.mEnableAvLines = r2
        L4b:
            if (r1 == 0) goto L4f
            r6.mVideoOnly = r1
        L4f:
            if (r4 == 0) goto L53
            r6.mAudioOnly = r4
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager._setAvLines():void");
    }

    public boolean disableSR(int i6, int i7) {
        ArrayList arrayList = new ArrayList();
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            arrayList = (ArrayList) iLiveSettingBundle.getSettingsValueForKey("live_sdk_sr_resolution_block_list", new ArrayList());
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String[] split = ((String) it.next()).split("x");
                if (split.length < 2) {
                    return false;
                }
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                if (i6 == parseInt && i7 == parseInt2) {
                    return true;
                }
            }
        }
        return false;
    }

    public void frameDTSNotify(int i6, long j6, long j7) {
        if (this.mEnableCheckFrame == 1 && i6 == 0 && this.mResolution.equals("origin")) {
            this.mLogService.feedVideoDTS(j6);
        }
        if (i6 == 1 && this.mEnableDTSCheck == 1) {
            LiveLoggerService liveLoggerService = this.mLogService;
            if (liveLoggerService.mFirstAudioPacketDTS < 0) {
                liveLoggerService.mFirstAudioPacketDTS = j6;
            } else {
                long j8 = this.mLatestAudioPacketDTS;
                if (j6 < j8) {
                    liveLoggerService.onAudioDTSRollback(j8, j6);
                }
            }
            this.mLatestAudioPacketDTS = j6;
        }
    }

    public int getEnableSR() {
        return this.mEnableTextureSR;
    }

    public int getEnableTexturerender() {
        return this.mEnableTextureRender;
    }

    public long getIntOption(int i6, long j6) {
        if (i6 == 0) {
            MediaPlayer mediaPlayer = this.mPlayer;
            if (mediaPlayer != null) {
                return (mediaPlayer.getLongOption(63, 0L) * 8) / 1000;
            }
        } else if (i6 == 68) {
            MediaPlayer mediaPlayer2 = this.mPlayer;
            if (mediaPlayer2 != null) {
                return (mediaPlayer2.getLongOption(63, 0L) * 8) / 1000;
            }
        } else if (i6 == 78) {
            if (this.mPlayer != null) {
                return r9.getIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL, 0);
            }
        } else if (i6 == 79) {
            return this.mTslMinTimeShit;
        }
        return j6;
    }

    public void getLastRenderTime() {
        if (this.mIsRetrying || this.mIsStalling) {
            return;
        }
        this.mVideoLastRenderTime = this.mPlayer.getLongOption(320, -1L);
        this.mAudioLastRenderTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, -1L);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x03f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getLogInfo(com.bykv.vk.component.ttvideo.log.LogBundle r22, int r23) {
        /*
            Method dump skipped, instructions count: 1024
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.VideoLiveManager.getLogInfo(com.bykv.vk.component.ttvideo.log.LogBundle, int):void");
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public float getMaxVolume() {
        return this.mPlayerSetting.getMaxVolume();
    }

    public long getNtpTimeDiff() {
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            return ((Long) iLiveSettingBundle.getSettingsValueForKey("time_diff_server_and_client", 0L)).longValue();
        }
        return 0L;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public String getPlayerErrorInfo() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null ? mediaPlayer.getStringOption(5002) : "none";
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public float getPlayerVolume() {
        return this.mPlayerSetting.getPlayerVolume();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public long getSeiDelay() {
        return this.mLogService.getInt64Value(100, 0L);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public String getServerIP() {
        return this.mCurrentIP;
    }

    public void getSessionlogInfo(LogBundle logBundle) {
        MediaPlayer mediaPlayer;
        if (logBundle == null || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        logBundle.playerDNSTimestamp = mediaPlayer.getLongOption(68, -1L);
        logBundle.tfoFallBackTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, -1L);
        logBundle.dropAudioPts = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, -1L);
        logBundle.dropAudioCostTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, -1L);
        logBundle.tcpConnectTimestamp = this.mPlayer.getLongOption(69, -1L);
        logBundle.tcpFirstPacketTimestamp = this.mPlayer.getLongOption(70, -1L);
        logBundle.videoPacketTimestamp = this.mPlayer.getLongOption(75, -1L);
        logBundle.audioPacketTimestamp = this.mPlayer.getLongOption(76, -1L);
        logBundle.videoDecodeTimestamp = this.mPlayer.getLongOption(77, -1L);
        logBundle.audioDecodeTimestamp = this.mPlayer.getLongOption(78, -1L);
        logBundle.videoDeviceOpenTime = this.mPlayer.getLongOption(155, -1L);
        logBundle.videoDeviceOpenedTime = this.mPlayer.getLongOption(162, -1L);
        logBundle.audioDeviceOpenTime = this.mPlayer.getLongOption(156, -1L);
        logBundle.audioDeviceOpenedTime = this.mPlayer.getLongOption(163, -1L);
        logBundle.downloadSpeed = (this.mPlayer.getLongOption(63, 0L) * 8) / 1000;
        logBundle.audioBufferTime = this.mPlayer.getLongOption(73, 0L);
        logBundle.videoBufferTime = this.mPlayer.getLongOption(72, 0L);
        logBundle.resolution = this.mResolution;
        logBundle.videoParamSendOutletTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME, 0L);
        logBundle.firstVideoFrameSendOutletTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 0L);
        logBundle.renderType = this.mPlayer.getVideoType();
        logBundle.streamInfoFindTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 0L);
        logBundle.streamInfoFoundTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_STREAM_INFO_FIND_END_TIME, 0L);
        logBundle.videoDeviceWaitStartTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 0L);
        logBundle.videoDeviceWaitEndTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME, 0L);
        logBundle.videoFirstPacketPos = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, -1L);
        logBundle.videoFirstPacketPts = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, -1L);
        logBundle.audioFirstPacketPos = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_POS, -1L);
        logBundle.audioFirstPacketPts = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, -1L);
        logBundle.httpReqFinishTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME, 0L);
        logBundle.httpResFinishTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_RES_FINSIH_TIME, 0L);
        logBundle.downloadSize = this.mPlayer.getLongOption(45, 0L);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public JSONObject getStaticLog() {
        LiveLoggerService liveLoggerService = this.mLogService;
        if (liveLoggerService == null) {
            return null;
        }
        return liveLoggerService.getStaticLog();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public String getStringOption(int i6, String str) {
        if (i6 == 57) {
            str = this.mCurrentPlayURL;
        } else if (i6 == 58) {
            str = this.mResolution;
        } else if (i6 == 60) {
            str = this.mStreamFormat;
        } else if (i6 == 65) {
            str = this.mAbrStrategy;
        }
        MyLog.i(TAG, "getStringOption: " + str);
        return str;
    }

    public int getUrlSettingMethod() {
        return this.mUrlSettingMethod;
    }

    public void getVideoCodecType() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null || this.mLogService == null) {
            return;
        }
        int intOption = mediaPlayer.getIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, -1);
        if (intOption == 0) {
            this.mLogService.setCodecType(IjkMediaFormat.CODEC_NAME_H264);
        } else if (intOption == 1) {
            this.mLogService.setCodecType("bytevc1");
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public int getVideoHeight() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public int getVideoWidth() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public float getVolume() {
        return this.mPlayerSetting.getVolume();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean isIPPlayer() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.getPlayerType() == 2;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean isOsPlayer() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.isOSPlayer();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public boolean isRtcPlayAvailable() {
        return this.mEnableRtcPlay == 1 && this.mRtcPlayFallBack == 0;
    }

    public JSONObject liveInfoItems() {
        try {
            JSONObject liveInfoItems = this.mLogService.getLiveInfoItems();
            liveInfoItems.put("get_live_info_iterms", ca.f10845k);
            return liveInfoItems;
        } catch (JSONException e6) {
            vl.j(e6);
            return null;
        }
    }

    public void onRenderStallForRetryStop() {
        if ((this.mIsStalling || this.mIsRetrying) && this.mEnableRenderStall == 1) {
            if (this.mAudioLastRenderTime != -1) {
                this.mLogService.onRenderStall((int) (System.currentTimeMillis() - this.mAudioLastRenderTime), 0, false, false);
            }
            if (this.mVideoLastRenderTime != -1) {
                this.mLogService.onRenderStall((int) (System.currentTimeMillis() - this.mVideoLastRenderTime), 0, true, false);
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void pause() {
        MyLog.i(TAG, "pause");
        checkMainLooper("pause");
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mLivePlayerState = LivePlayerState.PAUSED;
        this.mPlayer.pause();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean playResolution(String str) {
        MyLog.i(TAG, "playResolution:" + str);
        checkMainLooper("playResolution");
        if (this.mURLSource.getSourceType() != 2 || this.mPrepareState != PlayerState.PREPARED) {
            return false;
        }
        if (this.mResolution.equals(str)) {
            MyLog.i(TAG, "playResolution: same res=" + str);
            return true;
        }
        this.mRetryProcessor.reset();
        this.mResolutionIndex = -1;
        this.mStallCount = 0;
        this.mLogService.onSwitch(this.mCurrentPlayURL, "none", "setting_" + this.mResolution + "_to_" + str, 0);
        this.mLogService.mAbrSwitchInfo = "manual_abr_" + this.mResolution + "_to_" + str;
        saveCurrentResolution();
        this.mResolution = str;
        if (this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) || (this.mAbrStrategy.equals(LiveConfigKey.RAD) && !str.equals("auto"))) {
            String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, this.mStreamFormat, this.mLevel);
            if (TextUtils.isEmpty(playURLForResolution)) {
                MyLog.w(TAG, str + " playUrl not exist");
                return false;
            }
            updateDownloadSizeStat();
            this.mLogService.onSessionStop();
            this.mIsRetrying = true;
            _stopPlayer();
            _resetPlayer();
            this.mLogService.onSwitchURL(playURLForResolution);
            this.mUserSwitchResoultion = true;
            this.mLogService.mSessionStartTime = System.currentTimeMillis();
            parsePlayDNS(playURLForResolution);
        }
        return true;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void release() {
        MyLog.i(TAG, "release start");
        this.mListener.onReportALog(4, "release start -- " + hashCode());
        checkMainLooper("release");
        LivePlayerState livePlayerState = this.mLivePlayerState;
        if (livePlayerState == LivePlayerState.PLAYED || livePlayerState == LivePlayerState.PAUSED) {
            _stop(true, "release");
        }
        releaseTextureRenderRef();
        this.mExecutor.shutdown();
        this.mMyHandler.removeCallbacksAndMessages(null);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.release();
        this.mPlayer = null;
        this.mLogService.reset();
        this.mPrepareState = PlayerState.IDLE;
        this.mLivePlayerState = LivePlayerState.IDLE;
        MyLog.i(TAG, "release end");
        this.mListener.onReportALog(4, "release end -- " + hashCode());
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void releaseAsync() {
        this.mListener.onReportALog(4, "releaseAsync start -- " + hashCode());
        MyLog.i(TAG, "releaseAsync");
        checkMainLooper("releaseAsync");
        LivePlayerState livePlayerState = this.mLivePlayerState;
        if (livePlayerState == LivePlayerState.PLAYED || livePlayerState == LivePlayerState.PAUSED) {
            _stop(false, "releaseAsync");
        }
        this.mExecutor.shutdown();
        this.mMyHandler.removeCallbacksAndMessages(null);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (this.mSurfaceHolder != null) {
            mediaPlayer.setDisplay(null);
        }
        releaseTextureRenderRef();
        MediaPlayer mediaPlayer2 = this.mPlayer;
        this.mPlayer = null;
        this.mLogService.reset();
        this.mPrepareState = PlayerState.IDLE;
        this.mLivePlayerState = LivePlayerState.IDLE;
        LiveThreadPool.addExecuteTask(new MyReleaseRunnable(mediaPlayer2));
        MyLog.i(TAG, "releaseAsync end");
        this.mListener.onReportALog(4, "releaseAsync end -- " + hashCode());
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void reset() {
        MyLog.i(TAG, "reset");
        checkMainLooper("reset");
        if (this.mPlayer == null) {
            return;
        }
        _reset("reset");
        this.mLogService.reset();
        this.mCacheFileKey = null;
        this.mCacheFilePath = null;
        this.mEnableResolutionAutoDegrade = false;
        this.mEnableOriginResolution = false;
        this.mEnableSwitchMainAndBackupUrl = true;
        this.mEnableTextureSR = 0;
        this.mEnableTextureRender = 0;
        this.mTextureSRMode = 0;
        this.mResolution = "origin";
        this.mResolutionIndex = -1;
        this.mStreamFormat = LiveConfigKey.FLV;
        this.mTransportProtocol = LiveConfigKey.TCP;
        this.mSuggestProtocol = "none";
        this.mLevel = "main";
        this.mLocalURL = null;
        this.mIsLocalURL = false;
        this.mEnableHurryFlag = 0;
        this.mHurryType = -1;
        this.mEnableAvLines = "";
        this.mEnableSaveSCFG = false;
        this.mShowedFirstFrame = false;
        this.mEnableLLASHFastOpen = 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setCommonFlag(String str) {
        LiveLoggerService liveLoggerService = this.mLogService;
        if (liveLoggerService != null) {
            liveLoggerService.setCommonFlag(str);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setDisableVideoRender(Boolean bool) {
        MediaPlayer mediaPlayer;
        MyLog.i(TAG, "setDisableVideoRender: " + bool);
        this.mLogService.mDisableVideoRender = bool.booleanValue() ? 1 : 0;
        if (this.mEnableRadioLiveDisableRender != 1 || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        mediaPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_RADIO_MODE, bool.booleanValue() ? 1 : 0);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setFloatOption(int i6, float f6) {
        String str = "";
        if (i6 != 19) {
            if (i6 == 20) {
                if (this.mEnableLowLatencyFLV == 1) {
                    str = "invalid settings on low latency flv, slow_speed:" + f6;
                } else {
                    str = "slow_speed:" + f6;
                    this.mSlowPlaySpeed = f6;
                    MediaPlayer mediaPlayer = this.mPlayer;
                    if (mediaPlayer != null) {
                        mediaPlayer.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, f6);
                        this.mLogService.mSlowSpeed = f6;
                    }
                }
            }
        } else if (this.mEnableLowLatencyFLV == 1) {
            str = "invalid settings on low latency flv, catch_speed:" + f6;
        } else {
            str = "catch_speed:" + f6;
            this.mCatchSpeed = f6;
            MediaPlayer mediaPlayer2 = this.mPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setFloatOption(80, f6);
                this.mLogService.mCatchSpeed = f6;
            }
        }
        MyLog.i(TAG, "setFloatOption " + str);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setIntOption(int i6, int i7) {
        String str = "";
        switch (i6) {
            case 1:
                str = "image_enhancement:" + i7;
                this.mEnhancementType = i7;
                MediaPlayer mediaPlayer = this.mPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.setIntOption(37, i7);
                    break;
                }
                break;
            case 2:
                str = "image_scale:" + i7;
                this.mScaleType = i7;
                MediaPlayer mediaPlayer2 = this.mPlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.setIntOption(38, i7);
                    break;
                }
                break;
            case 3:
                str = "forbid_os_player:" + i7;
                TTPlayerConfiger.setValue(11, i7);
                break;
            case 4:
                str = "image_layout:" + i7;
                this.mLayoutType = i7;
                MediaPlayer mediaPlayer3 = this.mPlayer;
                if (mediaPlayer3 != null) {
                    mediaPlayer3.setIntOption(36, i7);
                    break;
                }
                break;
            case 5:
                str = "render_type:" + i7;
                this.mRenderType = i7;
                MediaPlayer mediaPlayer4 = this.mPlayer;
                if (mediaPlayer4 != null) {
                    mediaPlayer4.setIntOption(56, i7);
                    break;
                }
                break;
            case 7:
                str = "hard_decode:" + i7;
                this.mHardwareDecodeEnable = i7;
                MediaPlayer mediaPlayer5 = this.mPlayer;
                if (mediaPlayer5 != null) {
                    mediaPlayer5.setIntOption(59, i7);
                    break;
                }
                break;
            case 8:
                str = "enable_cache_file:" + i7;
                this.mCacheFileEnable = i7;
                MediaPlayer mediaPlayer6 = this.mPlayer;
                if (mediaPlayer6 != null) {
                    mediaPlayer6.setIntOption(14, 1);
                    break;
                }
                break;
            case 9:
                str = "bytevc1_decoder_type:" + i7;
                this.mByteVC1DecoderType = i7;
                MediaPlayer mediaPlayer7 = this.mPlayer;
                if (mediaPlayer7 != null) {
                    mediaPlayer7.setIntOption(67, i7);
                    break;
                }
                break;
            case 10:
                str = "buffering_millSeconds:" + i7;
                this.mBufferDataSeconds = i7;
                MediaPlayer mediaPlayer8 = this.mPlayer;
                if (mediaPlayer8 != null) {
                    mediaPlayer8.setIntOption(86, i7);
                    break;
                }
                break;
            case 11:
                str = "buffering_timeout:" + i7;
                this.mBufferTimeout = i7;
                MediaPlayer mediaPlayer9 = this.mPlayer;
                if (mediaPlayer9 != null) {
                    mediaPlayer9.setIntOption(81, i7);
                    break;
                }
                break;
            case 12:
                str = "network_timeout:" + i7;
                this.mNetworkTimeout = i7;
                MediaPlayer mediaPlayer10 = this.mPlayer;
                if (mediaPlayer10 != null) {
                    mediaPlayer10.setIntOption(9, i7 * 1000000);
                    break;
                }
                break;
            case 15:
                str = "use_external_dir:" + i7;
                this.mUseExternalDir = i7;
                break;
            case 16:
                str = "use_test_action:" + i7;
                this.mTestAction = i7;
                MediaPlayer mediaPlayer11 = this.mPlayer;
                if (mediaPlayer11 != null) {
                    mediaPlayer11.setIntOption(83, i7);
                    break;
                }
                break;
            case 17:
                if (this.mEnableLowLatencyFLV != 1) {
                    str = "hurry_time:" + i7;
                    this.mHurryTime = i7;
                    MediaPlayer mediaPlayer12 = this.mPlayer;
                    if (mediaPlayer12 != null) {
                        mediaPlayer12.setIntOption(15, i7);
                        this.mLogService.mHurryTime = i7;
                        break;
                    }
                } else {
                    str = "invalid settings on low latency flv, hurry_time:" + i7;
                    break;
                }
                break;
            case 18:
                str = "hurry_type:" + i7;
                this.mHurryType = i7;
                MediaPlayer mediaPlayer13 = this.mPlayer;
                if (mediaPlayer13 != null) {
                    mediaPlayer13.setIntOption(84, i7);
                    break;
                }
                break;
            case 21:
                if (this.mEnableLowLatencyFLV != 1) {
                    str = "slow_play_time:" + i7;
                    this.mSlowPlayTime = i7;
                    MediaPlayer mediaPlayer14 = this.mPlayer;
                    if (mediaPlayer14 != null) {
                        mediaPlayer14.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, i7);
                        this.mLogService.mSlowPlayTime = i7;
                        break;
                    }
                } else {
                    str = "invalid settings on low latency flv, slow_play_time:" + i7;
                    break;
                }
                break;
            case 22:
                str = "check side data" + i7;
                this.mOpenCheckSideData = i7;
                MediaPlayer mediaPlayer15 = this.mPlayer;
                if (mediaPlayer15 != null) {
                    mediaPlayer15.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, i7);
                    break;
                }
                break;
            case 25:
                str = "player_degrade_mode:" + i7;
                this.mPlayerDegradeMode = i7;
                break;
            case 31:
                str = "url_ability:" + i7;
                this.mURLAbility = i7;
                if (i7 != 1) {
                    if (i7 == 2) {
                        this.mLogService.mUrlAbility = "bytevc1";
                        break;
                    }
                } else {
                    this.mLogService.mUrlAbility = IjkMediaFormat.CODEC_NAME_H264;
                    break;
                }
                break;
            case 32:
                str = "enable_sharp:" + i7;
                this.mEnableSharp = i7;
                break;
            case 33:
                str = "asyncInit:" + i7;
                this.mEnableMediaCodecASYNCInit = i7;
                MediaPlayer mediaPlayer16 = this.mPlayer;
                if (mediaPlayer16 != null && this.mHardwareDecodeEnable == 1) {
                    mediaPlayer16.setIntOption(181, i7);
                    this.mLogService.mMediaCodecAsyncInit = i7;
                    break;
                }
                break;
            case 34:
                str = "defaultCodecID:" + i7;
                this.mDefaultCodecId = i7;
                MediaPlayer mediaPlayer17 = this.mPlayer;
                if (mediaPlayer17 != null) {
                    mediaPlayer17.setIntOption(182, i7);
                    this.mLogService.mDefaultCodecID = i7;
                    break;
                }
                break;
            case 35:
                str = "enable 264 hardware decode " + i7;
                this.mEnableH264HardwareDecode = i7;
                break;
            case 36:
                str = "enable bytevc1 hardware decode " + i7;
                this.mEnableByteVC1HardwareDecode = i7;
                break;
            case 37:
                str = "set max cache" + i7;
                this.mMaxCacheSeconds = i7;
                MediaPlayer mediaPlayer18 = this.mPlayer;
                if (mediaPlayer18 != null) {
                    mediaPlayer18.setIntOption(198, i7);
                    this.mLogService.mMaxCacheSeconds = i7;
                    break;
                }
                break;
            case 38:
                str = "enable test split " + i7;
                this.mEnableSplitStream = i7;
                MediaPlayer mediaPlayer19 = this.mPlayer;
                if (mediaPlayer19 != null) {
                    mediaPlayer19.setIntOption(87, i7);
                    this.mLogService.mEnableSplitStream = i7;
                    break;
                }
                break;
            case 39:
                str = "enable httpk degrade:" + i7;
                this.mEnableHttpkDegrade = i7;
                break;
            case 40:
                str = "enable fast open:" + i7;
                this.mEnableFastOpenStream = i7;
                break;
            case 41:
                str = "enable upload sei:" + i7;
                this.mEnableUploadSei = i7;
                break;
            case 42:
                str = "enable NTP:" + i7;
                this.mEnableNTPTask = i7;
                break;
            case 44:
                str = "set in main looper:" + i7;
                this.mIsInMainLooper = i7;
                break;
            case 46:
                str = "buffering end ignore video:" + i7;
                this.mCheckBufferingEndIgnoreVideo = i7;
                MediaPlayer mediaPlayer20 = this.mPlayer;
                if (mediaPlayer20 != null) {
                    mediaPlayer20.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_BUFFERING_END_IGNORE_VIDEO, i7);
                    this.mLogService.mCheckBufferingEndIgnoreVideo = i7;
                    break;
                }
                break;
            case 47:
                str = "start direct:" + i7;
                this.mStartDirectAfterPrepared = i7;
                MediaPlayer mediaPlayer21 = this.mPlayer;
                if (mediaPlayer21 != null) {
                    mediaPlayer21.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_START_DIRECTLLY_AFTER_PREPARED, i7);
                    this.mLogService.mStartDirectAfterPrepared = i7;
                    break;
                }
                break;
            case 48:
                str = "enable mediaLoader:" + i7;
                this.mEnableOpenMDL = i7;
                break;
            case 54:
                str = "check buffering end advance:" + i7;
                this.mCheckBufferingEndAdvanceEnable = i7;
                MediaPlayer mediaPlayer22 = this.mPlayer;
                if (mediaPlayer22 != null) {
                    mediaPlayer22.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END, i7);
                    this.mLogService.mCheckBufferingEndAdvanceEnable = i7;
                    break;
                }
                break;
            case 55:
                str = "set stall count thre:" + i7;
                this.mStallCountThresOfResolutionDegrade = i7;
                break;
            case 56:
                str = "enable resolution degrade:" + i7;
                this.mEnableResolutionAutoDegrade = i7 == 1;
                break;
            case 61:
                str = "enable tcp fast open:" + i7;
                this.mEnableTcpFastOpen = i7;
                MediaPlayer mediaPlayer23 = this.mPlayer;
                if (mediaPlayer23 != null) {
                    mediaPlayer23.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, i7);
                    break;
                }
                break;
            case 62:
                str = "enable check packet corrupt:" + i7;
                this.mEnableCheckPacketCorrupt = i7;
                MediaPlayer mediaPlayer24 = this.mPlayer;
                if (mediaPlayer24 != null) {
                    mediaPlayer24.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT, i7);
                    break;
                }
                break;
            case 67:
                str = "enable flv abr:" + i7;
                this.mEnableFlvABR = i7;
                break;
            case 69:
                str = "enable texture render:" + i7;
                this.mEnableTextureRender = i7;
                break;
            case 70:
                str = "enable texture sr:" + i7;
                this.mEnableTextureSR = i7;
                break;
            case 77:
                str = "tsl time shift:" + i7;
                this.mTslTimeShift = i7;
                this.mLogService.mTslTimeShift = i7;
                break;
            case 80:
                str = "toB switch :" + i7;
                this.mSwitchToB = i7;
                break;
            case 82:
                str = "enable mult_sei:" + i7;
                this.mEnableDecodeMultiSei = i7;
                break;
            case 83:
                this.mHurryTime = i7;
                str = "hurry_time:" + i7;
                MediaPlayer mediaPlayer25 = this.mPlayer;
                if (mediaPlayer25 != null) {
                    mediaPlayer25.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, i7);
                    this.mLogService.mHurryTime = i7;
                    break;
                }
                break;
            case 84:
                str = "slow_play_time:" + i7;
                this.mSlowPlayTime = i7;
                MediaPlayer mediaPlayer26 = this.mPlayer;
                if (mediaPlayer26 != null) {
                    mediaPlayer26.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, i7);
                    this.mLogService.mSlowPlayTime = i7;
                    break;
                }
                break;
            case 85:
                str = "enable free flow:" + i7;
                this.mEnableFreeFlow = i7;
                break;
        }
        MyLog.i(TAG, "setIntOption " + str);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setLocalURL(String str) {
        checkMainLooper("setLocalURL");
        if (str != null && !str.equals(this.mLocalURL) && this.mLocalURL != null) {
            reset();
        }
        this.mLocalURL = str;
        this.mIsLocalURL = true;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setLongOption(int i6, long j6) {
        String str = "";
        if (i6 == 45) {
            str = "startPlayBufferThreshold:" + j6;
            this.mStartPlayBufferThres = j6;
            MediaPlayer mediaPlayer = this.mPlayer;
            if (mediaPlayer != null && j6 > 0) {
                mediaPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES, j6);
                this.mLogService.mStartPlayBufferThres = j6;
            }
        } else if (i6 == 59) {
            str = "set alog func:" + j6;
            this.mALogWriteAddr = j6;
        }
        MyLog.i(TAG, "setLongOptin " + str);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setLooping(boolean z5) {
        this.mLooping = z5;
        if (this.mPlayer == null || !this.mIsLocalURL || TextUtils.isEmpty(this.mLocalURL)) {
            return;
        }
        this.mPlayer.setLooping(this.mLooping);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setMute(Boolean bool) {
        this.mPlayerSetting.setMute(bool.booleanValue());
        this.mLogService.mMuteAudio = bool.booleanValue() ? 1 : 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setPlayURLs(LiveURL[] liveURLArr) {
        MyLog.i(TAG, "setPlayUrls, sdkParam:" + liveURLArr[0].sdkParams);
        checkMainLooper("setPlayURLS");
        this.mURLSource.setPlayURLs(liveURLArr);
        this.mUrlSettingMethod = 0;
        if (this.mCurrentPlayURL == null || this.mURLSource.getPlayLiveURL().mainURL == this.mCurrentPlayURL) {
            return;
        }
        _reset("setPlayURLs");
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setPlayerVolume(float f6) {
        this.mPlayerSetting.setPlayerVolume(f6);
        this.mLogService.mPlayerVolumeSetting = f6;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setPreviewFlag(boolean z5) {
        LiveLoggerService liveLoggerService = this.mLogService;
        if (liveLoggerService != null) {
            liveLoggerService.setPreviewFlag(z5);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setProjectKey(String str) {
        this.mLogService.setProjectKey(str);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setStreamInfo(String str) {
        JSONObject jSONObject;
        MyLog.i(TAG, "setStreamInfo:" + str);
        this.mLogService.mStreamData = str;
        checkMainLooper("setStreamInfo");
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e6) {
            vl.j(e6);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        _reset("setStreamInfo");
        this.mURLSource.setStreamInfo(new LiveStreamInfo(jSONObject));
        this.mUrlSettingMethod = 1;
        _setLooseSync();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setStringOption(int i6, String str) {
        LiveInfoSource liveInfoSource;
        String str2 = "";
        if (i6 == 26) {
            str2 = "cacheFilePath:" + str;
            this.mCacheFilePath = str;
            if (this.mPlayer != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                String sb2 = sb.toString();
                this.mCacheFileKey = sb2;
                this.mPlayer.setStringOption(17, sb2);
                this.mPlayer.setIntOption(14, 1);
                this.mPlayer.setCacheFile(str, 1);
            }
        } else if (i6 == 43) {
            str2 = "set resolution:" + str;
            saveCurrentResolution();
            this.mResolution = str;
            if (this.mPlayer != null && (liveInfoSource = this.mURLSource) != null && liveInfoSource.getSourceType() == 2) {
                long bitrate = this.mURLSource.getBitrate(this.mResolution, this.mLevel);
                if (bitrate > 0) {
                    this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, (int) bitrate);
                    this.mLogService.mUseExpectBitrate = 1;
                }
            }
        } else if (i6 == 60) {
            str2 = "set stream format:" + str;
            this.mStreamFormat = str;
            this.mLogService.setFormatInfo(str, str);
            if (this.mPlayer != null && (this.mStreamFormat.equals(LiveConfigKey.AVPH) || this.mStreamFormat.equals(LiveConfigKey.CMAF))) {
                this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, str);
            }
        } else if (i6 == 81) {
            str2 = "toB module id:" + str;
            this.mMoudleIDToB = str;
        } else if (i6 == 86) {
            str2 = "switch resolution of cdn abr:" + str;
            this.mCdnAbrResolution = str;
            _requestSwitchUrlFromServer();
        } else if (i6 != 89) {
            switch (i6) {
                case 63:
                    this.mLogService.mEnterMethod = str;
                    break;
                case 64:
                    this.mLogService.mEnterAction = str;
                    break;
                case 65:
                    str2 = " abr strategy:" + str;
                    this.mAbrStrategy = str;
                    break;
                case 66:
                    str2 = "set transport protocol:" + str;
                    if (str.equals(LiveConfigKey.TCP) || str.equals(LiveConfigKey.QUIC)) {
                        this.mTransportProtocol = str;
                    }
                    this.mQuicPull = true;
                    break;
                default:
                    switch (i6) {
                        case 72:
                            str2 = "set sr kernal bin path:" + str;
                            this.mTextureSRBinPath = str;
                            break;
                        case 73:
                            str2 = "set sr ocl module path:" + str;
                            this.mTextureSROclModuleName = str;
                            break;
                        case 74:
                            str2 = "set sr dsp module path:" + str;
                            this.mTextureSRDspModuleName = str;
                            break;
                    }
            }
        } else {
            str2 = "set_url_host:" + str;
            this.mURLHost = str;
        }
        MyLog.i(TAG, "setStringOption " + str2);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setSurface(Surface surface) {
        checkMainLooper("setSurface");
        MyLog.i(TAG, "setsurface: " + surface);
        this.mSurface = surface;
        if (this.mPlayer != null) {
            this.mLogService.mSetSurfaceTime = System.currentTimeMillis();
            this.mPlayer.setSurface(surface);
            this.mLogService.mSetSurfaceCost = System.currentTimeMillis() - this.mLogService.mSetSurfaceTime;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        checkMainLooper("setSurfaceHolder");
        this.mSurfaceHolder = surfaceHolder;
        if (this.mPlayer != null) {
            this.mLogService.mSetSurfaceTime = System.currentTimeMillis();
            this.mPlayer.setDisplay(surfaceHolder);
            this.mLogService.mSetSurfaceCost = System.currentTimeMillis() - this.mLogService.mSetSurfaceTime;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setVideoFormat(String str) {
        this.mStreamFormat = str;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setVolume(float f6) {
        this.mPlayerSetting.setVolume(f6);
        this.mLogService.mVolumeSetting = f6;
    }

    public String set_url_port_scheme(String str, String str2) {
        int indexOf;
        int indexOf2 = str.indexOf(".com");
        int indexOf3 = str.indexOf(".com:");
        StringBuilder sb = new StringBuilder(str);
        if (str2 != null) {
            if (indexOf3 != -1) {
                int i6 = indexOf3 + 5;
                int i7 = indexOf3 + 6;
                while (i7 < sb.length() && sb.charAt(i7) - '0' >= 0 && sb.charAt(i7) - '0' <= 9) {
                    i7++;
                }
                sb.replace(i6, i7, str2);
            } else if (indexOf2 != -1 && ((indexOf = str.indexOf("vhost")) == -1 || indexOf > indexOf2)) {
                sb.insert(indexOf2 + 4, ":" + str2);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        int indexOf4 = sb2.indexOf("://");
        if (this.mURLSource.getSourceType() == 2) {
            if (this.mTransportProtocol.equals(LiveConfigKey.KCP)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "httpk");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.QUIC) || this.mTransportProtocol.equals(LiveConfigKey.QUICU)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, "httpq");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TLS)) {
                if (indexOf4 != -1) {
                    sb2.replace(0, indexOf4, master.flame.danmaku.danmaku.parser.b.f50155b);
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TCP) && indexOf4 != -1) {
                sb2.replace(0, indexOf4, master.flame.danmaku.danmaku.parser.b.f50154a);
            }
        }
        return sb2.toString();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void stop() {
        MyLog.i(TAG, "stop");
        this.mListener.onReportALog(4, "stop start -- " + hashCode());
        checkMainLooper("stop");
        _stop(true, "stop");
        this.mRetryProcessor.stop();
        this.mListener.onReportALog(4, "stop end-- " + hashCode());
    }

    public void updateFrameTerminatedDTS(int i6, long j6, long j7) {
        this.mFrameTerminatedDTS = j6;
    }

    private String _addParamToURL(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str4 = str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
        int indexOf = str.indexOf("?");
        if (indexOf == -1) {
            str4 = "?" + str4;
        } else if (indexOf != str.length() - 1) {
            str4 = ContainerUtils.FIELD_DELIMITER + str4;
        }
        return str + str4;
    }

    private String addSessionIdToURL(String str, long j6) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.mUuid)) {
            String str2 = this.mUuid + "." + j6;
            this.mLogService.mSessionId = str2;
            if (!str.contains("_session_id")) {
                return _addParamToURL(str, "_session_id", str2);
            }
            return str;
        }
        return null;
    }

    public static void closeDataLoader() {
        MediaLoaderWrapper.getDataLoader().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String convertCodecName(int i6) {
        switch (i6) {
            case 1:
                return "IOSHWCodec";
            case 2:
                return "hardware_codec";
            case 3:
                return "ff_H264_codec";
            case 4:
                return "ff_ByteVC1_codec";
            case 5:
                return "KS_ByteVC1_codec";
            case 6:
                return "JX_ByteVC1_codec";
            default:
                return "none_codec";
        }
    }

    public static boolean dataLoaderIsRunning() {
        return MediaLoaderWrapper.getDataLoader().isRunning();
    }

    public static void enableLoadLibrary() {
        MediaLoaderWrapper.getDataLoader().enableLoadLibrary();
    }

    private JSONArray formatAVPHStreamInfoToJSONArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (str.contains(";")) {
            for (String str2 : str.split(";")) {
                JSONObject extractAvphStreamInfo = extractAvphStreamInfo(str2);
                if (extractAvphStreamInfo != null) {
                    arrayList.add(extractAvphStreamInfo);
                }
            }
        } else {
            JSONObject extractAvphStreamInfo2 = extractAvphStreamInfo(str);
            if (extractAvphStreamInfo2 != null) {
                arrayList.add(extractAvphStreamInfo2);
            }
        }
        return new JSONArray((Collection) arrayList);
    }

    public static void setDataLoaderListener(MediaLoaderListener mediaLoaderListener) {
        MediaLoaderWrapper.getDataLoader().setListener(mediaLoaderListener);
    }

    public static void setIntValue(int i6, int i7) {
        MediaLoaderWrapper.getDataLoader().setIntValue(i6, i7);
    }

    public static void startDataLoader(Context context) throws Exception {
        MediaLoaderWrapper.getDataLoader().start();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setAsyncInit(int i6) {
        String.format("setAsyncInit enable:%b", Integer.valueOf(i6));
        this.mEnableMediaCodecASYNCInit = i6;
    }

    void doResolutionChange(String str) {
    }

    public void releaseTextureRenderRef() {
    }

    public void setTextureRenderLogListener() {
    }

    public void setupTextureRender() {
    }

    private String prepareLiveIOURL(String str, String str2, Map<String, String> map) {
        return str;
    }
}
