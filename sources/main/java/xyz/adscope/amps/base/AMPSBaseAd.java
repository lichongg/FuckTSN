package xyz.adscope.amps.base;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import xyz.adscope.amps.AMPSRequestInfo;
import xyz.adscope.amps.ad.banner.AMPSBannerLoadEventListener;
import xyz.adscope.amps.ad.interstitial.AMPSInterstitialAd;
import xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener;
import xyz.adscope.amps.ad.interstitial.AMPSInterstitialOpenApiManager;
import xyz.adscope.amps.ad.nativead.AMPSNativeLoadEventListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.reward.AMPSRewardVideoAd;
import xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener;
import xyz.adscope.amps.ad.reward.AMPSRewardVideoOpenApiManager;
import xyz.adscope.amps.ad.splash.AMPSSplashAd;
import xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener;
import xyz.adscope.amps.ad.splash.AMPSSplashOpenApiManager;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.control.preload.AMPSPreLoad;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;
import xyz.adscope.amps.manager.inter.AMPSLoadEventListener;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.preload.AMPSPreloadManagerInfo;
import xyz.adscope.amps.report.AMPSReportConstants;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSBaseAd<T extends AMPSLoadEventListener> {
    protected AMPSLoadEventListener loadEventListener;
    protected WeakReference<Activity> mActivityWeakRef;
    protected AMPSBaseOpenApiManager mAdLoadManager;
    protected int mAdLoadType;
    protected AMPSBaseOpenApiManager mAdPreLoadManager;
    protected AMPSRequestInfo mAsmsRequestInfo;
    protected Context mContext;
    protected String mSpaceId;
    protected AMPSRequestParameters parameters;
    protected int mAdLoadStatus = 0;
    private boolean isCallBack = false;

    public void destroy() {
        this.mActivityWeakRef = null;
        this.mAsmsRequestInfo = null;
        this.parameters = null;
        this.mContext = null;
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = this.mAdLoadManager;
        if (aMPSBaseOpenApiManager != null) {
            aMPSBaseOpenApiManager.destroy();
            this.mAdLoadManager = null;
        }
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager2 = this.mAdPreLoadManager;
        if (aMPSBaseOpenApiManager2 != null) {
            aMPSBaseOpenApiManager2.destroy();
            this.mAdPreLoadManager = null;
        }
        this.loadEventListener = null;
    }

    public abstract AMPSBaseOpenApiManager getAMPSOpenApiManager();

    public AMPSBaseOpenApiManager getPreloadAMPSOpenApiManager() {
        return null;
    }

    public void onAdFailed() {
        if (this.loadEventListener == null) {
            return;
        }
        this.mAdLoadStatus = 3;
        AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_PARAM_ERROR;
        AMPSError aMPSError = new AMPSError(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg());
        AMPSLoadEventListener aMPSLoadEventListener = this.loadEventListener;
        if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
            ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
        } else if (aMPSLoadEventListener instanceof AMPSNativeLoadEventListener) {
            ((AMPSNativeLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
        } else if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
            ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
        } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
            ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
        } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
            ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
        }
        destroy();
    }

    private void refreshListener() {
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = this.mAdLoadManager;
        if (aMPSBaseOpenApiManager == null) {
            return;
        }
        if (this instanceof AMPSSplashAd) {
            ((AMPSSplashOpenApiManager) aMPSBaseOpenApiManager).refreshLoadEventListener((AMPSSplashAd) this);
        } else if (this instanceof AMPSInterstitialAd) {
            ((AMPSInterstitialOpenApiManager) aMPSBaseOpenApiManager).refreshLoadEventListener((AMPSInterstitialAd) this);
        } else if (this instanceof AMPSRewardVideoAd) {
            ((AMPSRewardVideoOpenApiManager) aMPSBaseOpenApiManager).refreshLoadEventListener((AMPSRewardVideoAd) this);
        }
    }

    public void autoRefreshAd() {
        if (this.mAdPreLoadManager == null || this.mAdLoadManager.getAdAutoRefreshSwitch() == 0) {
            return;
        }
        this.isCallBack = false;
        this.mAdLoadStatus = 0;
        this.mAdLoadType = 2;
        this.parameters.setLoadType(AMPSReportConstants.LOAD_TYPE.LOAD_TYPE_AUTO.getValue());
        this.mAdLoadManager = null;
        loadAd();
    }

    public int getEcpm() {
        AdSourceModel winAdSourceModel;
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = this.mAdLoadManager;
        if (aMPSBaseOpenApiManager == null || (winAdSourceModel = aMPSBaseOpenApiManager.getWinAdSourceModel()) == null) {
            return 0;
        }
        return winAdSourceModel.getEcpm();
    }

    public Map<String, Object> getMediaExtraInfo() {
        AMPSBaseAdapter winAdSourceAdapter;
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = this.mAdLoadManager;
        if (aMPSBaseOpenApiManager == null || (winAdSourceAdapter = aMPSBaseOpenApiManager.getWinAdSourceAdapter()) == null) {
            return null;
        }
        return winAdSourceAdapter.getMediaExtraInfo();
    }

    public boolean isReady() {
        AMPSBaseOpenApiManager baseOpenApiManager;
        if (TextUtils.isEmpty(this.mSpaceId)) {
            return false;
        }
        if (this.mAdLoadStatus == 2) {
            return true;
        }
        AMPSPreloadManagerInfo aMPSPreloadManagerInfo = AMPSPreLoad.getInstance().getAMPSPreloadManagerInfo(this.mSpaceId);
        if (aMPSPreloadManagerInfo == null || (baseOpenApiManager = aMPSPreloadManagerInfo.getBaseOpenApiManager()) == null) {
            return false;
        }
        this.mAdLoadManager = baseOpenApiManager;
        refreshListener();
        return true;
    }

    public void loadAd() {
        AMPSBaseOpenApiManager baseOpenApiManager;
        AMPSRequestParameters aMPSRequestParameters = this.parameters;
        if (aMPSRequestParameters == null) {
            onAdFailed();
            return;
        }
        aMPSRequestParameters.setLoadType(AMPSReportConstants.LOAD_TYPE.LOAD_TYPE_NORMAL.getValue());
        if (this.mAdLoadStatus != 0) {
            this.isCallBack = true;
            return;
        }
        AMPSPreloadManagerInfo aMPSPreloadManagerInfo = AMPSPreLoad.getInstance().getAMPSPreloadManagerInfo(this.mSpaceId);
        if (aMPSPreloadManagerInfo != null && (baseOpenApiManager = aMPSPreloadManagerInfo.getBaseOpenApiManager()) != null) {
            this.mAdLoadManager = baseOpenApiManager;
            refreshListener();
            onAdLoaded();
            return;
        }
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "AMPS startLoad start spaceId:" + this.mSpaceId);
        this.mAdLoadStatus = 1;
        AMPSBaseOpenApiManager aMPSOpenApiManager = getAMPSOpenApiManager();
        this.mAdLoadManager = aMPSOpenApiManager;
        aMPSOpenApiManager.startLoad();
    }

    public void onAdClicked() {
        AMPSLoadEventListener aMPSLoadEventListener = this.loadEventListener;
        if (aMPSLoadEventListener == null) {
            return;
        }
        if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
            ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdClicked();
            return;
        }
        if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
            ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdClicked();
        } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
            ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdClicked();
        } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
            ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdVideoClick();
        }
    }

    public void onAdDismiss() {
        AMPSLoadEventListener aMPSLoadEventListener = this.loadEventListener;
        if (aMPSLoadEventListener == null) {
            return;
        }
        if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
            ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdDismiss();
            return;
        }
        if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
            ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdDismiss();
        } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
            ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdDismiss();
        } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
            ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdDismiss();
        }
    }

    public void onAdLoaded() {
        if (this.loadEventListener == null) {
            return;
        }
        LogUtil.e(AMPSConstants.AMPS_LOG_TAG, " AMPSBaseAd onAdLoaded");
        this.mAdLoadStatus = 2;
        if (this.mAdLoadType == 2 && !this.isCallBack) {
            this.isCallBack = true;
            return;
        }
        this.isCallBack = true;
        AMPSLoadEventListener aMPSLoadEventListener = this.loadEventListener;
        if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
            ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdLoaded();
            return;
        }
        if (aMPSLoadEventListener instanceof AMPSNativeLoadEventListener) {
            AMPSBaseAdapter winAdSourceAdapter = this.mAdLoadManager.getWinAdSourceAdapter();
            ((AMPSNativeLoadEventListener) this.loadEventListener).onAmpsAdLoad((winAdSourceAdapter == null || !(winAdSourceAdapter instanceof AMPSNativeAdapter)) ? null : ((AMPSNativeAdapter) winAdSourceAdapter).getNativeListInfo());
        } else if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
            ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdLoaded();
        } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
            ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdLoaded();
        } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
            ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdLoad();
        }
    }

    public void onAdShow() {
        AMPSLoadEventListener aMPSLoadEventListener = this.loadEventListener;
        if (aMPSLoadEventListener == null) {
            return;
        }
        if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
            ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdShow();
            return;
        }
        if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
            ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdShow();
        } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
            ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdShow();
        } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
            ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdShow();
        }
    }

    public AMPSBaseAd(Context context, AMPSRequestParameters aMPSRequestParameters, T t5) {
        this.mAdLoadType = 0;
        if (context != null && aMPSRequestParameters != null && t5 != null) {
            this.mContext = context;
            this.parameters = aMPSRequestParameters;
            this.mSpaceId = aMPSRequestParameters.getSpaceId();
            if (context instanceof Activity) {
                this.mActivityWeakRef = new WeakReference<>((Activity) context);
            }
            this.mAdLoadType = 0;
        }
    }

    public void onAdFailed(AMPSError aMPSError) {
        AMPSLoadEventListener aMPSLoadEventListener = this.loadEventListener;
        if (aMPSLoadEventListener == null) {
            return;
        }
        this.mAdLoadStatus = 3;
        if (this.mAdLoadType != 2 || this.isCallBack) {
            if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
                ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
                return;
            }
            if (aMPSLoadEventListener instanceof AMPSNativeLoadEventListener) {
                ((AMPSNativeLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
                return;
            }
            if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
                ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
            } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
                ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
            } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
                ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
            }
        }
    }
}
