package xyz.adscope.amps.base;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.util.AMPSScreenUtil;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSBaseAdapter<T extends AMPSBaseAdAdapterListener> {
    private static final int REQUEST_TIME_OUT_MESSAGE = 10001;
    public int autoPlayPolicy;
    public int expressViewHeight;
    public int expressViewHeightDp;
    public int expressViewWidth;
    public int expressViewWidthDp;
    public int isSendBidData;
    public Map<String, Object> localCustomParameter;
    public String mAccountId;
    public int mAdEcpm;
    public String mBiddingType;
    public Context mContext;
    public String mExtra;
    public int mFloorEcpm;
    public AMPSInitAdapterConfig mInitAdapterConfig;
    public String mPublicKey;
    private Timer mRequestTimeoutTimer;
    private TimerTask mRequestTimeoutTimerTask;
    public String mSeatId;
    public String mServerUrl;
    public String mUserId;
    public int videoMaxTime;
    public String mAppId = null;
    public String mSpaceId = null;
    public int mTimeout = 5000;
    public AMPSBaseAdAdapterListener mAMPSBaseAdAdapterListener = null;
    public AMPSAdBiddingListener mAMPSAdBiddingListener = null;
    public boolean isBidding = false;
    public boolean isHasLoadResult = false;
    public boolean isHasBiddingResult = false;
    public boolean isLoadSuccess = false;
    private boolean isShow = false;
    public int adCount = 1;
    public boolean isVolumeOn = false;
    public boolean isLandScape = false;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: xyz.adscope.amps.base.AMPSBaseAdapter.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what == 10001) {
                AMPSBaseAdapter aMPSBaseAdapter = AMPSBaseAdapter.this;
                if (aMPSBaseAdapter.isHasLoadResult) {
                    return;
                }
                AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_TIMEOUT;
                aMPSBaseAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
            }
        }
    };

    public void destroy() {
        this.mContext = null;
        this.mAMPSBaseAdAdapterListener = null;
        this.mAMPSAdBiddingListener = null;
    }

    public String getMediaCustomExtraInfo() {
        return null;
    }

    public Map<String, Object> getMediaExtraInfo() {
        return null;
    }

    public void getRequestParameters(Context context, AMPSAdapterModel aMPSAdapterModel) {
        if (aMPSAdapterModel != null) {
            try {
                if (!TextUtils.isEmpty(aMPSAdapterModel.getAppId())) {
                    this.mAppId = aMPSAdapterModel.getAppId();
                }
                if (!TextUtils.isEmpty(aMPSAdapterModel.getSpaceId())) {
                    this.mSpaceId = aMPSAdapterModel.getSpaceId();
                }
                if (!TextUtils.isEmpty(aMPSAdapterModel.getOrientation())) {
                    this.isLandScape = aMPSAdapterModel.getOrientation().equals(AMPSEnum.OrientationEnum.ORIENTATION_LANDSCAPE.getOrientation());
                }
                this.mTimeout = aMPSAdapterModel.getTimeOut();
                this.mUserId = aMPSAdapterModel.getUserId();
                this.mExtra = aMPSAdapterModel.getExtra();
                this.adCount = aMPSAdapterModel.getAdCount();
                this.expressViewWidth = aMPSAdapterModel.getExpressViewWidth();
                this.expressViewHeight = aMPSAdapterModel.getExpressViewHeight();
                if (this.expressViewWidth <= 0) {
                    this.expressViewWidth = AMPSScreenUtil.getScreenWidth(this.mContext);
                }
                this.expressViewWidthDp = DeviceInfoUtil.px2dip(context, this.expressViewWidth);
                this.expressViewHeightDp = DeviceInfoUtil.px2dip(context, this.expressViewHeight);
                this.isVolumeOn = aMPSAdapterModel.getVideoSound() == AMPSEnum.VideoSoundEnum.SUPPORT_VIDEO_SOUND.getHasSound();
                this.autoPlayPolicy = aMPSAdapterModel.getVideoAutoPlay();
                this.videoMaxTime = (int) aMPSAdapterModel.getVideoMaxTime();
                this.mInitAdapterConfig = aMPSAdapterModel.getAmpsInitAdapterConfig();
                this.localCustomParameter = aMPSAdapterModel.getLocalCustomParameter();
                this.isSendBidData = aMPSAdapterModel.getIsSendBidData();
                this.mBiddingType = aMPSAdapterModel.getBiddingType();
                this.mFloorEcpm = aMPSAdapterModel.getFloorEcpm();
                this.mAccountId = aMPSAdapterModel.getAccountId();
                this.mServerUrl = aMPSAdapterModel.getServerUrl();
                this.mPublicKey = aMPSAdapterModel.getPublicKey();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public abstract boolean isValid();

    public abstract void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, T t5);

    public void onC2SBiddingFail(String str, String str2) {
        AMPSAdBiddingListener aMPSAdBiddingListener;
        this.isHasBiddingResult = true;
        cancelRequestedTimerTask();
        if (!this.isBidding || (aMPSAdBiddingListener = this.mAMPSAdBiddingListener) == null) {
            return;
        }
        aMPSAdBiddingListener.onC2SBiddingFail(this, AMPSBaseBiddingResult.biddingFail(str, str2));
    }

    public void onC2SBiddingSuccess(int i6) {
        AMPSAdBiddingListener aMPSAdBiddingListener;
        this.isHasBiddingResult = true;
        cancelRequestedTimerTask();
        if (!this.isBidding || (aMPSAdBiddingListener = this.mAMPSAdBiddingListener) == null) {
            return;
        }
        aMPSAdBiddingListener.onC2SBiddingSuccess(this, AMPSBaseBiddingResult.biddingSuccess(i6));
    }

    public void onS2SBiddingFail(String str, String str2) {
        AMPSAdBiddingListener aMPSAdBiddingListener;
        this.isHasBiddingResult = true;
        cancelRequestedTimerTask();
        if (!this.isBidding || (aMPSAdBiddingListener = this.mAMPSAdBiddingListener) == null) {
            return;
        }
        aMPSAdBiddingListener.onS2SBiddingFail(this, AMPSBaseBiddingResult.biddingFail(str, str2));
    }

    public void onS2SBiddingSuccess(int i6) {
        AMPSAdBiddingListener aMPSAdBiddingListener;
        this.isHasBiddingResult = true;
        cancelRequestedTimerTask();
        if (!this.isBidding || (aMPSAdBiddingListener = this.mAMPSAdBiddingListener) == null) {
            return;
        }
        aMPSAdBiddingListener.onS2SBiddingSuccess(this, AMPSBaseBiddingResult.biddingSuccess(i6));
    }

    public abstract void showAd(Activity activity);

    public abstract void showAd(ViewGroup viewGroup);

    public void buildRequestedTimerTask() {
        TimerTask timerTask;
        try {
            if (this.mRequestTimeoutTimer == null) {
                this.mRequestTimeoutTimer = new Timer();
            }
            if (this.mRequestTimeoutTimerTask == null) {
                this.mRequestTimeoutTimerTask = new TimerTask() { // from class: xyz.adscope.amps.base.AMPSBaseAdapter.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        if (AMPSBaseAdapter.this.mHandler != null) {
                            AMPSBaseAdapter.this.mHandler.sendEmptyMessage(10001);
                        }
                    }
                };
            }
            Timer timer = this.mRequestTimeoutTimer;
            if (timer != null && (timerTask = this.mRequestTimeoutTimerTask) != null) {
                timer.schedule(timerTask, this.mTimeout);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void cancelRequestedTimerTask() {
        try {
            TimerTask timerTask = this.mRequestTimeoutTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
                this.mRequestTimeoutTimerTask = null;
            }
            Timer timer = this.mRequestTimeoutTimer;
            if (timer != null) {
                timer.cancel();
                this.mRequestTimeoutTimer = null;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public int getFloorEcpm() {
        return this.mFloorEcpm;
    }

    public String getNetworkSpaceId() {
        return this.mSpaceId;
    }

    public String getSeatId() {
        return this.mSeatId;
    }

    public boolean isC2SAdSource() {
        return this.isBidding && AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equals(this.mBiddingType);
    }

    public boolean isS2SAdSource() {
        return this.isBidding && AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equals(this.mBiddingType);
    }

    public void onAdClicked() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdClicked(this);
        }
    }

    public void onAdDismiss() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdDismiss(this);
        }
    }

    public void onAdFailed(String str, String str2) {
        if (this.isLoadSuccess && !AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_TIMEOUT.getErrorCode().equals(str)) {
            onAdShowFailed(str, str2);
            return;
        }
        if (this.isHasLoadResult) {
            return;
        }
        this.isHasLoadResult = true;
        cancelRequestedTimerTask();
        if (this.isBidding && !this.isHasBiddingResult) {
            onC2SBiddingFail(str, str2);
            return;
        }
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdFailed(this, new AMPSError(String.valueOf(str), str2));
        }
    }

    public void onAdLoad() {
        if (this.isHasLoadResult) {
            return;
        }
        this.isLoadSuccess = true;
        this.isHasLoadResult = true;
        cancelRequestedTimerTask();
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdLoaded(this);
        }
    }

    public void onAdShow() {
        if (this.isShow) {
            return;
        }
        this.isShow = true;
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdShow(this);
        }
    }

    public void onAdShowFailed(String str, String str2) {
        if (!this.isLoadSuccess) {
            onAdFailed(str, str2);
            return;
        }
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdShowFailed(this, new AMPSError(String.valueOf(str), str2));
        }
    }

    public void refreshAMPSAdAdapterListener(T t5) {
    }

    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
    }

    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
    }

    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
    }
}
