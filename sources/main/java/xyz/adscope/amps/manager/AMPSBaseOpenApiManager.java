package xyz.adscope.amps.manager;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.banner.AMPSBannerLoadEventListener;
import xyz.adscope.amps.ad.draw.AMPSDrawLoadEventListener;
import xyz.adscope.amps.ad.draw.adapter.AMPSDrawAdAdapter;
import xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener;
import xyz.adscope.amps.ad.nativead.AMPSNativeLoadEventListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener;
import xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener;
import xyz.adscope.amps.ad.unified.AMPSUnifiedNativeLoadEventListener;
import xyz.adscope.amps.ad.unified.adapter.AMPSUnifiedNativeAdapter;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.base.AMPSBaseBiddingResult;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.control.bid.AMPSPriceComparator;
import xyz.adscope.amps.control.bid.inter.IPriceComparatorInterface;
import xyz.adscope.amps.control.cache.AMPSCacheController;
import xyz.adscope.amps.control.dispatch.AMPSDispatcher;
import xyz.adscope.amps.control.dispatch.inter.IDispatcherInterface;
import xyz.adscope.amps.control.filter.AMPSFilter;
import xyz.adscope.amps.control.filter.inter.IFilterInterface;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.init.AMPSInitChannelAdapterConfig;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.init.inter.IAMPSInitCallback;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.manager.inter.AMPSLoadEventListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.model.AMPSCycleModel;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.model.cache.AMPSAdSourceCacheInfo;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.config.response.AdSourceNoticeRuleModel;
import xyz.adscope.amps.model.config.response.AuctionStrategyModel;
import xyz.adscope.amps.model.config.response.MaterialManagerModel;
import xyz.adscope.amps.model.config.response.SpaceModel;
import xyz.adscope.amps.model.frequency.AMPSFrequencyEventModel;
import xyz.adscope.amps.model.material.AMPSUploadMaterial;
import xyz.adscope.amps.report.AMPSEventReportCode;
import xyz.adscope.amps.report.AMPSReportConstants;
import xyz.adscope.amps.report.AMPSReportLoader;
import xyz.adscope.amps.tool.AMPSAdapterFactory;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.amps.tool.material.MaterialManager;
import xyz.adscope.amps.tool.task.AMPSManagerTask;
import xyz.adscope.amps.tool.task.inter.IBiddingTimeoutTimerCallBack;
import xyz.adscope.amps.tool.task.inter.IDispatchFloorAdSourceTimerCallBack;
import xyz.adscope.amps.tool.task.inter.IRequestTimeoutTimerCallBack;
import xyz.adscope.amps.tool.util.AMPSRandomUtil;
import xyz.adscope.amps.tool.util.AMPSRegularUtil;
import xyz.adscope.amps.tool.util.AMPSStringUtil;
import xyz.adscope.common.info.DeviceInfo;
import xyz.adscope.common.json.util.JsonUtil;
import xyz.adscope.common.tool.security.AesUtil;
import xyz.adscope.common.tool.security.GzipUtil;
import xyz.adscope.common.tool.security.KeyGenerator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSBaseOpenApiManager<T extends AMPSLoadEventListener> implements AMPSAdBiddingListener, AMPSBaseAdAdapterListener {
    private AMPSInitChannelAdapterConfig ampsInitChannelAdapterConfig;
    private AMPSLoadEventListener ampsLoadEventListener;
    protected View currentViewGroup;
    private IDispatcherInterface iDispatcherInterface;
    private IFilterInterface iFilterInterface;
    private IPriceComparatorInterface iPriceComparatorInterface;
    private boolean isAdClosed;
    private AMPSBaseAdapter mAMPSBaseAdapter;
    private AMPSRequestParameters mAMPSRequestParameters;
    private Context mContext;
    private String mSessionId;
    private long mSpaceCachedOffersTimeout;
    private String mSpaceId;
    private SpaceModel mSpaceModel;
    private AdSourceModel mWinAdSourceModel;
    private long mediationStartTime;
    private final String TAG = getClass().getSimpleName();
    private long mAdRequestTimeout = 5000;
    private int mAdSourceRequestTimeout = 5000;
    private int mAdRequestType = 0;
    private long mBidAdTimeout = 5000;
    private long mFloorDelayTime = 5000;
    private List<AdSourceModel> mS2SAdSourceList = null;
    private List<AdSourceModel> mC2SAdSourceList = null;
    private List<AdSourceModel> mFloorAdSourceList = null;
    private int mAdAutoRefreshSwitch = 0;
    private AMPSManagerTask mAmpsManagerTask = null;
    private Map<String, AdSourceModel> loadAdResourceDatas = new HashMap();
    private Map<String, AMPSBaseAdapter> loadAdResourceAdapters = new HashMap();
    private boolean isHasLoadingSuccess = false;
    private boolean isDispatchFloorAdSource = false;
    private boolean isRequestTimeout = false;
    private int mSpaceAdStatus = 0;
    private boolean isFirstLoadAd = true;

    private int calcLossECPM(AdSourceModel adSourceModel) {
        if (adSourceModel == null) {
            return 0;
        }
        int ecpm = adSourceModel.getEcpm();
        AdSourceModel adSourceModel2 = this.mWinAdSourceModel;
        int ecpm2 = adSourceModel2 != null ? adSourceModel2.getEcpm() : 0;
        if (ecpm > 0) {
            if (ecpm2 > 0) {
                int calcLossNoticePrice = calcLossNoticePrice(getAdSourceNoticeRule(1, adSourceModel, (ecpm * 100.0d) / ecpm2), this.mWinAdSourceModel, adSourceModel);
                if (calcLossNoticePrice > ecpm) {
                    return calcLossNoticePrice;
                }
                if (ecpm2 > 0) {
                }
            }
            return ecpm;
        }
        return ecpm2;
    }

    private int calcLossNoticePrice(AdSourceNoticeRuleModel adSourceNoticeRuleModel, AdSourceModel adSourceModel, AdSourceModel adSourceModel2) {
        if (adSourceModel2 == null) {
            return 0;
        }
        try {
            int ecpm = adSourceModel2.getEcpm();
            int ecpm2 = adSourceModel != null ? adSourceModel.getEcpm() : 0;
            if (adSourceNoticeRuleModel != null) {
                int parseInt = (int) (ecpm2 + (((((AMPSRegularUtil.isInteger(adSourceNoticeRuleModel.getAdd()) ? Integer.parseInt(r1) : 0) - (AMPSRegularUtil.isInteger(adSourceNoticeRuleModel.getSubtract()) ? Integer.parseInt(r2) : 0)) + ((AMPSRandomUtil.getNegativeToPositiveRandomNum(100) * (AMPSRegularUtil.isInteger(adSourceNoticeRuleModel.getRandom()) ? Integer.parseInt(r10) : 0)) / 100.0d)) / 100.0d) * ecpm));
                if (parseInt >= ecpm) {
                    return parseInt;
                }
                if (ecpm2 <= 0) {
                    return ecpm;
                }
            } else if (ecpm2 <= 0) {
                return 0;
            }
            return ecpm2;
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    private int calcWinNoticePrice(AdSourceNoticeRuleModel adSourceNoticeRuleModel, AdSourceModel adSourceModel, AdSourceModel adSourceModel2) {
        if (adSourceModel == null) {
            return 0;
        }
        try {
            int ecpm = adSourceModel.getEcpm();
            int ecpm2 = adSourceModel2 != null ? adSourceModel2.getEcpm() : 0;
            if (adSourceNoticeRuleModel != null) {
                int parseInt = (int) (ecpm2 + (((((AMPSRegularUtil.isInteger(adSourceNoticeRuleModel.getAdd()) ? Integer.parseInt(r1) : 0) - (AMPSRegularUtil.isInteger(adSourceNoticeRuleModel.getSubtract()) ? Integer.parseInt(r2) : 0)) + ((AMPSRandomUtil.getNegativeToPositiveRandomNum(100) * (AMPSRegularUtil.isInteger(adSourceNoticeRuleModel.getRandom()) ? Integer.parseInt(r10) : 0)) / 100.0d)) / 100.0d) * ecpm));
                if (parseInt <= ecpm && parseInt >= 0) {
                    return parseInt;
                }
                if (ecpm2 <= 0) {
                    return ecpm - 1;
                }
            } else if (ecpm2 <= 0) {
                return ecpm - 1;
            }
            return ecpm2;
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackAdLoadFail(String str, String str2) {
        Exception exc;
        try {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " callbackAdLoadFail code:" + str + "; message:" + str2);
            if (!this.isDispatchFloorAdSource) {
                try {
                    if (!this.isRequestTimeout) {
                        this.isDispatchFloorAdSource = true;
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " callbackAdLoadFail 分发兜底广告源");
                        dispatchAdSource(this.mFloorAdSourceList);
                        return;
                    }
                } catch (Exception e6) {
                    exc = e6;
                    exc.printStackTrace();
                }
            }
            if (this.mSpaceAdStatus == 3) {
                return;
            }
            this.mSpaceAdStatus = 3;
            try {
                uploadLog(null, AMPSEventReportCode.EVENT_MEDIATION_LOAD_FAIL_CODE, str, str2, System.currentTimeMillis() - this.mediationStartTime);
                if (this.ampsLoadEventListener != null) {
                    AMPSError aMPSError = new AMPSError(str, str2);
                    AMPSLoadEventListener aMPSLoadEventListener = this.ampsLoadEventListener;
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
                    } else if (aMPSLoadEventListener instanceof AMPSUnifiedNativeLoadEventListener) {
                        ((AMPSUnifiedNativeLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
                    } else if (aMPSLoadEventListener instanceof AMPSDrawLoadEventListener) {
                        ((AMPSDrawLoadEventListener) aMPSLoadEventListener).onAmpsAdFailed(aMPSError);
                    }
                }
                sendLosNoticeByFail();
                destroy();
            } catch (Exception e7) {
                e = e7;
                exc = e;
                exc.printStackTrace();
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    private AdSourceNoticeRuleModel getAdSourceNoticeRule(int i6, AdSourceModel adSourceModel, double d6) {
        List<String> priceGapScope;
        if (adSourceModel == null) {
            return null;
        }
        try {
            List<AdSourceNoticeRuleModel> winNoticeRule = i6 == 0 ? adSourceModel.getWinNoticeRule() : i6 == 1 ? adSourceModel.getLossNoticeRule() : null;
            if (winNoticeRule != null && !winNoticeRule.isEmpty()) {
                for (AdSourceNoticeRuleModel adSourceNoticeRuleModel : winNoticeRule) {
                    if (adSourceNoticeRuleModel != null && (priceGapScope = adSourceNoticeRuleModel.getPriceGapScope()) != null && priceGapScope.size() >= 2) {
                        String str = priceGapScope.get(0);
                        String str2 = priceGapScope.get(1);
                        int parseInt = AMPSRegularUtil.isInteger(str) ? Integer.parseInt(str) : "max".equals(str) ? -2 : -1;
                        int parseInt2 = AMPSRegularUtil.isInteger(str2) ? Integer.parseInt(str2) : -1;
                        if (parseInt != -1 && parseInt2 != -1 && ((parseInt == -2 && d6 >= parseInt2) || (d6 >= parseInt2 && d6 <= parseInt))) {
                            return adSourceNoticeRuleModel;
                        }
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00f5 A[Catch: Exception -> 0x00ec, TryCatch #1 {Exception -> 0x00ec, blocks: (B:25:0x00f5, B:28:0x00f9, B:35:0x005e, B:48:0x00e8), top: B:34:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f9 A[Catch: Exception -> 0x00ec, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ec, blocks: (B:25:0x00f5, B:28:0x00f9, B:35:0x005e, B:48:0x00e8), top: B:34:0x005e }] */
    @Override // xyz.adscope.amps.inner.AMPSAdBiddingListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onC2SBiddingSuccess(xyz.adscope.amps.base.AMPSBaseAdapter r14, xyz.adscope.amps.base.AMPSBaseBiddingResult r15) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.manager.AMPSBaseOpenApiManager.onC2SBiddingSuccess(xyz.adscope.amps.base.AMPSBaseAdapter, xyz.adscope.amps.base.AMPSBaseBiddingResult):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00f5 A[Catch: Exception -> 0x00ec, TryCatch #1 {Exception -> 0x00ec, blocks: (B:25:0x00f5, B:28:0x00f9, B:35:0x005e, B:48:0x00e8), top: B:34:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f9 A[Catch: Exception -> 0x00ec, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ec, blocks: (B:25:0x00f5, B:28:0x00f9, B:35:0x005e, B:48:0x00e8), top: B:34:0x005e }] */
    @Override // xyz.adscope.amps.inner.AMPSAdBiddingListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onS2SBiddingSuccess(xyz.adscope.amps.base.AMPSBaseAdapter r14, xyz.adscope.amps.base.AMPSBaseBiddingResult r15) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.manager.AMPSBaseOpenApiManager.onS2SBiddingSuccess(xyz.adscope.amps.base.AMPSBaseAdapter, xyz.adscope.amps.base.AMPSBaseBiddingResult):void");
    }

    protected void saveWinAdSourceMaterial() {
        try {
            saveWinAdSourceMaterial(null);
        } catch (Exception unused) {
        }
    }

    public void show(ViewGroup viewGroup) {
        this.currentViewGroup = viewGroup;
        if (viewGroup != null) {
            try {
                AMPSBaseAdapter aMPSBaseAdapter = this.mAMPSBaseAdapter;
                if (aMPSBaseAdapter != null) {
                    aMPSBaseAdapter.refreshAMPSAdAdapterListener(this);
                    this.mAMPSBaseAdapter.showAd(viewGroup);
                    return;
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
        AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_SHOW_ERROR;
        callBackAdLoadFail(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg());
    }

    public synchronized void uploadLog(AdSourceModel adSourceModel, AMPSEventReportCode aMPSEventReportCode, String str, String str2, long j6) {
        try {
            try {
                AMPSCycleModel aMPSCycleModel = new AMPSCycleModel();
                aMPSCycleModel.setMediationAppId(AMPSSDKManager.getInstance().getAppId());
                aMPSCycleModel.setMediationSpaceId(this.mSpaceId);
                aMPSCycleModel.setErrorCode(str);
                aMPSCycleModel.setErrorMsg(str2);
                aMPSCycleModel.setRoundTripTime(j6);
                if (adSourceModel != null) {
                    aMPSCycleModel.setAdSourceAppId(adSourceModel.getAppId());
                    aMPSCycleModel.setAdSourceId(adSourceModel.getSeatId());
                    aMPSCycleModel.setAdSourceSpaceId(adSourceModel.getSpaceId());
                    aMPSCycleModel.setEcpm(adSourceModel.getReportEcpm() + "");
                    aMPSCycleModel.setAdSourceCustomData(adSourceModel.getCustomData());
                    aMPSCycleModel.setBidType(adSourceModel.getBiddingType());
                    aMPSCycleModel.setFloorPrice(adSourceModel.getFloorEcpm() + "");
                    AuctionStrategyModel auctionStrategy = adSourceModel.getAuctionStrategy();
                    if (auctionStrategy != null) {
                        aMPSCycleModel.setIsHitAuction(auctionStrategy.isHit() ? "1" : "0");
                        aMPSCycleModel.setIsLastLook(auctionStrategy.isUseLastLook() ? "1" : "0");
                        aMPSCycleModel.setBidStrategyCustomData(auctionStrategy.getCustomData());
                    }
                    aMPSCycleModel.setNoticePrice(adSourceModel.getNoticePrice());
                    aMPSCycleModel.setLossReason(adSourceModel.getLossReason());
                    aMPSCycleModel.setRealPrice(adSourceModel.getRealPrice());
                    aMPSCycleModel.setBidSeatId(adSourceModel.getBidSeatId());
                    aMPSCycleModel.setBidSpaceId(adSourceModel.getBidSpaceId());
                }
                AMPSRequestParameters aMPSRequestParameters = this.mAMPSRequestParameters;
                if (aMPSRequestParameters != null) {
                    aMPSCycleModel.setLoadType(aMPSRequestParameters.getLoadType());
                    aMPSCycleModel.setAdCount(this.mAMPSRequestParameters.getAdCount() + "");
                }
                SpaceModel spaceModel = this.mSpaceModel;
                if (spaceModel != null) {
                    aMPSCycleModel.setAdType(spaceModel.getAdType());
                    aMPSCycleModel.setSessionId(this.mSessionId);
                    aMPSCycleModel.setSpaceCustomData(this.mSpaceModel.getCustomData());
                    aMPSCycleModel.setMaxWaitTime(this.mSpaceModel.getAdsTimeout() + "");
                    aMPSCycleModel.setAdTimeOut(this.mSpaceModel.getAdTimeout() + "");
                }
                AMPSReportLoader.getInstance().reportAdLog(aMPSCycleModel, aMPSEventReportCode.getCodeStr());
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private int calcWinECPM(AdSourceModel adSourceModel) {
        AdSourceModel adSourceModel2 = this.mWinAdSourceModel;
        if (adSourceModel2 == null) {
            return 0;
        }
        int ecpm = adSourceModel2.getEcpm();
        int ecpm2 = adSourceModel != null ? adSourceModel.getEcpm() : 0;
        if (ecpm <= 0) {
            return 0;
        }
        int calcWinNoticePrice = calcWinNoticePrice(getAdSourceNoticeRule(0, this.mWinAdSourceModel, (ecpm2 * 100.0d) / ecpm), this.mWinAdSourceModel, adSourceModel);
        return calcWinNoticePrice <= 0 ? ecpm2 > 0 ? ecpm2 : ecpm - 1 : calcWinNoticePrice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackAdLoadSuccess(AdSourceModel adSourceModel) {
        Map<String, AMPSBaseAdapter> map;
        if (adSourceModel != null) {
            try {
                if (this.mAMPSBaseAdapter == null && this.mSpaceAdStatus < 1) {
                    String spaceId = adSourceModel.getSpaceId();
                    if (TextUtils.isEmpty(spaceId)) {
                        return;
                    }
                    this.mWinAdSourceModel = adSourceModel;
                    if (this.loadAdResourceAdapters.containsKey(spaceId)) {
                        this.mAMPSBaseAdapter = this.loadAdResourceAdapters.get(spaceId);
                    }
                    if (this.mAMPSBaseAdapter != null && this.ampsLoadEventListener != null) {
                        this.mSpaceAdStatus = 1;
                        adSourceModel.setAdComparePriceStatus(3);
                        updateAdSourceECPM(adSourceModel);
                        adSourceModel.setReportEcpm(adSourceModel.getEcpm());
                        if (!AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType())) {
                            AdSourceModel secondAdSourceModel = getSecondAdSourceModel();
                            AMPSBidResult aMPSBidResult = new AMPSBidResult();
                            int calcWinECPM = calcWinECPM(secondAdSourceModel);
                            aMPSBidResult.setEcpm(calcWinECPM);
                            aMPSBidResult.setChannelName(adSourceModel.getSeatId());
                            aMPSBidResult.setBidType(adSourceModel.getBiddingType());
                            aMPSBidResult.setWinPrice(this.mWinAdSourceModel.getEcpm());
                            this.mAMPSBaseAdapter.sendWinNotice(aMPSBidResult);
                            adSourceModel.setNoticePrice(String.valueOf(calcWinECPM));
                            if (secondAdSourceModel != null) {
                                adSourceModel.setRealPrice(secondAdSourceModel.getEcpm() + "");
                                adSourceModel.setBidSeatId(secondAdSourceModel.getSeatId());
                                adSourceModel.setBidSpaceId(secondAdSourceModel.getSpaceId());
                            }
                            uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_LOAD_WIN_CODE, "", "", 0L);
                        }
                        uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_COMPARISON_SUCCESS_CODE, "", "", 0L);
                        for (AdSourceModel adSourceModel2 : this.loadAdResourceDatas.values()) {
                            if (adSourceModel2 != null && adSourceModel2.getAdStatus() == 5 && adSourceModel2.getAdComparePriceStatus() == 1) {
                                adSourceModel2.setAdComparePriceStatus(4);
                                AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_COMPARISON_FAIL_CODE;
                                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_COMPARISON_FAIL;
                                uploadLog(adSourceModel2, aMPSEventReportCode, reportLogErrorEnum.getErrorCode(), reportLogErrorEnum.getErrorMsg(), 0L);
                            }
                        }
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " callBackAdLoadSuccess winAdSource:" + spaceId);
                        uploadLog(null, AMPSEventReportCode.EVENT_MEDIATION_LOAD_SUCCESS_CODE, "", "", System.currentTimeMillis() - this.mediationStartTime);
                        AMPSLoadEventListener aMPSLoadEventListener = this.ampsLoadEventListener;
                        if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
                            ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdLoaded();
                        } else if (aMPSLoadEventListener instanceof AMPSNativeLoadEventListener) {
                            AMPSBaseAdapter aMPSBaseAdapter = this.mAMPSBaseAdapter;
                            if (aMPSBaseAdapter instanceof AMPSNativeAdapter) {
                                ((AMPSNativeLoadEventListener) aMPSLoadEventListener).onAmpsAdLoad(((AMPSNativeAdapter) aMPSBaseAdapter).getNativeListInfo());
                            }
                        } else if (aMPSLoadEventListener instanceof AMPSUnifiedNativeLoadEventListener) {
                            AMPSBaseAdapter aMPSBaseAdapter2 = this.mAMPSBaseAdapter;
                            if (aMPSBaseAdapter2 instanceof AMPSUnifiedNativeAdapter) {
                                ((AMPSUnifiedNativeLoadEventListener) aMPSLoadEventListener).onAmpsAdLoad(((AMPSUnifiedNativeAdapter) aMPSBaseAdapter2).getNativeListInfo());
                            } else if (aMPSBaseAdapter2 instanceof AMPSNativeAdapter) {
                                ((AMPSUnifiedNativeLoadEventListener) aMPSLoadEventListener).onAmpsAdLoad(((AMPSNativeAdapter) aMPSBaseAdapter2).getNativeExpressListInfo());
                            }
                        } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
                            ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdLoad();
                        } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
                            ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdLoaded();
                        } else if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
                            ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdLoaded();
                        } else if (aMPSLoadEventListener instanceof AMPSDrawLoadEventListener) {
                            ((AMPSDrawLoadEventListener) aMPSLoadEventListener).onAmpsAdLoad(((AMPSDrawAdAdapter) this.mAMPSBaseAdapter).getDrawListInfo());
                        }
                        startCacheLoadSuccessAdSource();
                        removeCacheAdSource(spaceId);
                        sendLosNotice();
                        AMPSManagerTask aMPSManagerTask = this.mAmpsManagerTask;
                        if (aMPSManagerTask != null) {
                            aMPSManagerTask.cancelBiddingTimerTask();
                            this.mAmpsManagerTask.cancelDispatchFloorAdSourceTimerTask();
                            this.mAmpsManagerTask.cancelRequestedTimerTask();
                            this.mAmpsManagerTask = null;
                        }
                        if (!(this.ampsLoadEventListener instanceof AMPSBannerLoadEventListener) || (map = this.loadAdResourceAdapters) == null || map.size() <= 0) {
                            return;
                        }
                        Iterator<Map.Entry<String, AMPSBaseAdapter>> it = this.loadAdResourceAdapters.entrySet().iterator();
                        while (it.hasNext()) {
                            AMPSBaseAdapter value = it.next().getValue();
                            if (value != null && !isWinAdSource(value)) {
                                value.destroy();
                            }
                        }
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    private void comparePrice(AMPSBaseAdapter aMPSBaseAdapter, AdSourceModel adSourceModel) {
        try {
            if (this.iPriceComparatorInterface != null && adSourceModel != null && !TextUtils.isEmpty(adSourceModel.getSpaceId())) {
                uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_COMPARISON_CODE, "", "", 0L);
                int comparePriceResult = this.iPriceComparatorInterface.getComparePriceResult(adSourceModel);
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "comparePrice channel:" + adSourceModel.getSeatId() + ",spaceId:" + adSourceModel.getSpaceId() + ",comparePriceResult:" + comparePriceResult);
                adSourceModel.setAdComparePriceStatus(comparePriceResult);
                if (comparePriceResult == 1) {
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_COMPARISON_WAIT_CODE, "", "", 0L);
                } else if (comparePriceResult == 4) {
                    AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_COMPARISON_FAIL_CODE;
                    AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_COMPARISON_FAIL;
                    uploadLog(adSourceModel, aMPSEventReportCode, reportLogErrorEnum.getErrorCode(), reportLogErrorEnum.getErrorMsg(), 0L);
                }
                if (comparePriceResult == 3) {
                    callBackAdLoadSuccess(adSourceModel);
                    return;
                }
                if (this.mAdRequestType != 1 && adSourceModel.getIsFloor() != 1) {
                    if (isC2SOrS2SAdSource(adSourceModel.getBiddingType())) {
                        dispatchAdSourceByChannelResult(adSourceModel);
                    }
                    handleCallbackAdSourceLoadResult();
                    return;
                }
                handleCallbackAdSourceLoadResult();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void createAMPSInitCustomAdapterConfig() {
        try {
            if (this.ampsInitChannelAdapterConfig == null) {
                this.ampsInitChannelAdapterConfig = new AMPSInitChannelAdapterConfig();
            }
            AMPSInitConfig aMPSAdConfig = AMPSSDKManager.getInstance().getAMPSAdConfig();
            if (aMPSAdConfig != null) {
                this.ampsInitChannelAdapterConfig.setAppName(aMPSAdConfig.getAppName());
                this.ampsInitChannelAdapterConfig.setPrivacyConfig(aMPSAdConfig.getPrivacyConfig());
                this.ampsInitChannelAdapterConfig.setPersonalRecommend(aMPSAdConfig.isPersonalRecommend());
                this.ampsInitChannelAdapterConfig.setDebug(aMPSAdConfig.isDebug());
                this.ampsInitChannelAdapterConfig.setUserId(aMPSAdConfig.getUserId());
                this.ampsInitChannelAdapterConfig.setCustomOAID(aMPSAdConfig.getCustomOAID());
                this.ampsInitChannelAdapterConfig.setLocalExtraMap(aMPSAdConfig.getLocalExtraMap());
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAdSource(List<AdSourceModel> list) {
        Exception exc;
        try {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        for (AdSourceModel adSourceModel : list) {
                            try {
                                if (adSourceModel != null && !TextUtils.isEmpty(adSourceModel.getSpaceId())) {
                                    this.loadAdResourceDatas.put(adSourceModel.getSpaceId(), adSourceModel);
                                }
                            } catch (Exception e6) {
                                exc = e6;
                                exc.printStackTrace();
                                return;
                            }
                        }
                        for (AdSourceModel adSourceModel2 : list) {
                            if (adSourceModel2 != null && !TextUtils.isEmpty(adSourceModel2.getSpaceId())) {
                                uploadLog(adSourceModel2, AMPSEventReportCode.EVENT_ADSOURCE_FILTER_CODE, "", "", 0L);
                                IFilterInterface iFilterInterface = this.iFilterInterface;
                                if (iFilterInterface != null ? iFilterInterface.channelFilter(adSourceModel2) : false) {
                                    uploadLog(adSourceModel2, AMPSEventReportCode.EVENT_ADSOURCE_FILTER_SUCCESS_CODE, "", "", 0L);
                                    starLoadAdResource(adSourceModel2);
                                } else {
                                    AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_FILTER_FAIL_CODE;
                                    AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_FILTER_FAIL;
                                    uploadLog(adSourceModel2, aMPSEventReportCode, reportLogErrorEnum.getErrorCode(), reportLogErrorEnum.getErrorMsg(), 0L);
                                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " filter not pass spaceId:" + adSourceModel2.getSpaceId());
                                    adSourceModel2.setAdStatus(6);
                                    dispatchAdSourceByChannelResult(adSourceModel2);
                                }
                            }
                        }
                        return;
                    }
                } catch (Exception e7) {
                    e = e7;
                    exc = e;
                    exc.printStackTrace();
                    return;
                }
            }
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " dispatchAdSource is null:");
            handleCallbackAdSourceLoadResult();
        } catch (Exception e8) {
            e = e8;
        }
    }

    private void dispatchAdSourceByChannelResult(AdSourceModel adSourceModel) {
        try {
            IDispatcherInterface iDispatcherInterface = this.iDispatcherInterface;
            if (iDispatcherInterface == null) {
                return;
            }
            dispatchAdSource(iDispatcherInterface.dispatch(adSourceModel));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void dispatchAdSourceByFloor() {
        AMPSManagerTask aMPSManagerTask;
        try {
            List<AdSourceModel> list = this.mFloorAdSourceList;
            if (list != null && list.size() != 0 && (aMPSManagerTask = this.mAmpsManagerTask) != null) {
                aMPSManagerTask.startDispatchFloorAdSourceTimerTask(this.mFloorDelayTime, new IDispatchFloorAdSourceTimerCallBack() { // from class: xyz.adscope.amps.manager.AMPSBaseOpenApiManager.4
                    @Override // xyz.adscope.amps.tool.task.inter.IDispatchFloorAdSourceTimerCallBack
                    public void callBackDispatchFloorAdSource() {
                        if (AMPSBaseOpenApiManager.this.isHasLoadingSuccess || AMPSBaseOpenApiManager.this.isDispatchFloorAdSource) {
                            return;
                        }
                        AMPSBaseOpenApiManager.this.isDispatchFloorAdSource = true;
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, AMPSBaseOpenApiManager.this.TAG + " dispatchAdSourceByFloor 分发兜底广告源:");
                        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = AMPSBaseOpenApiManager.this;
                        aMPSBaseOpenApiManager.dispatchAdSource(aMPSBaseOpenApiManager.mFloorAdSourceList);
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void dispatchAdSourceByS2S() {
        List<AdSourceModel> list = this.mS2SAdSourceList;
        if (list == null || list.size() == 0) {
            return;
        }
        this.iDispatcherInterface.updateAdSourceAdStatus(this.mS2SAdSourceList, 1);
        this.iDispatcherInterface.updateAdSourceAdStatus(this.mS2SAdSourceList, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAdSourceByTimeOut() {
        try {
            if (this.iDispatcherInterface == null) {
                return;
            }
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " dispatchAdSourceByTimeOut 询价超时:");
            dispatchAdSource(this.iDispatcherInterface.biddingTimeOut());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private int getProfitPrice(int i6, String str) {
        if (i6 > 0) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return str.endsWith("%") ? (i6 * Integer.parseInt(str.substring(0, str.indexOf("%")))) / 100 : Integer.parseInt(str);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                return 1;
            }
        }
        return 1;
    }

    private AdSourceModel getSecondAdSourceModel() {
        AdSourceModel adSourceModel = null;
        for (AdSourceModel adSourceModel2 : this.loadAdResourceDatas.values()) {
            if (adSourceModel2 != null && (adSourceModel2.getAdStatus() == 5 ? adSourceModel2.getAdComparePriceStatus() != 3 && (adSourceModel == null || adSourceModel2.getEcpm() > adSourceModel.getEcpm()) : isC2SOrS2SAdSource(adSourceModel2.getBiddingType()) && adSourceModel2.getEcpm() > 0 && 4 == adSourceModel2.getAdComparePriceStatus() && (adSourceModel == null || adSourceModel2.getEcpm() > adSourceModel.getEcpm()))) {
                adSourceModel = adSourceModel2;
            }
        }
        return adSourceModel;
    }

    private int getWinEcpm() {
        AdSourceModel adSourceModel = this.mWinAdSourceModel;
        if (adSourceModel != null) {
            return adSourceModel.getEcpm();
        }
        return 0;
    }

    private void handleC2SOrS2SAdSourceBidResult(AdSourceModel adSourceModel, AMPSBaseBiddingResult aMPSBaseBiddingResult, int i6) {
        int i7;
        if (adSourceModel == null || aMPSBaseBiddingResult == null) {
            return;
        }
        try {
            if (adSourceModel.getAdStatus() == 3 && i6 == 2 && ((i7 = this.mAdRequestType) == 0 || i7 == 2)) {
                starLoadAdResource(adSourceModel);
            } else {
                dispatchAdSourceByChannelResult(adSourceModel);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void handleCallbackAdSourceLoadResult() {
        IPriceComparatorInterface iPriceComparatorInterface;
        try {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " handleCallbackAdSourceLoadResult ");
            if (this.mAMPSBaseAdapter == null && (iPriceComparatorInterface = this.iPriceComparatorInterface) != null) {
                AdSourceModel winAdSourceModel = iPriceComparatorInterface.getWinAdSourceModel();
                if (winAdSourceModel != null && !TextUtils.isEmpty(winAdSourceModel.getSpaceId())) {
                    callBackAdLoadSuccess(winAdSourceModel);
                    return;
                }
                if (judgeIsHasNoResultAdSource() || this.ampsLoadEventListener == null) {
                    return;
                }
                AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_REQUEST_ERROR;
                callBackAdLoadFail(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg());
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void handlerBiddingTimeout() {
        int i6;
        try {
            if (this.mAmpsManagerTask != null && (i6 = this.mAdRequestType) != 0 && i6 != 2) {
                List<AdSourceModel> list = this.mS2SAdSourceList;
                if (list != null) {
                    if (list.size() <= 0) {
                    }
                    this.mAmpsManagerTask.startBiddingTimerTask(this.mBidAdTimeout, new IBiddingTimeoutTimerCallBack() { // from class: xyz.adscope.amps.manager.AMPSBaseOpenApiManager.2
                        @Override // xyz.adscope.amps.tool.task.inter.IBiddingTimeoutTimerCallBack
                        public void callBackBiddingTimeout() {
                            AMPSBaseOpenApiManager.this.dispatchAdSourceByTimeOut();
                        }
                    });
                }
                List<AdSourceModel> list2 = this.mC2SAdSourceList;
                if (list2 == null || list2.size() <= 0) {
                    return;
                }
                this.mAmpsManagerTask.startBiddingTimerTask(this.mBidAdTimeout, new IBiddingTimeoutTimerCallBack() { // from class: xyz.adscope.amps.manager.AMPSBaseOpenApiManager.2
                    @Override // xyz.adscope.amps.tool.task.inter.IBiddingTimeoutTimerCallBack
                    public void callBackBiddingTimeout() {
                        AMPSBaseOpenApiManager.this.dispatchAdSourceByTimeOut();
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void handlerRequestedTimeout() {
        try {
            AMPSManagerTask aMPSManagerTask = this.mAmpsManagerTask;
            if (aMPSManagerTask == null) {
                return;
            }
            aMPSManagerTask.startRequestedTimerTask(this.mAdRequestTimeout, new IRequestTimeoutTimerCallBack() { // from class: xyz.adscope.amps.manager.AMPSBaseOpenApiManager.3
                @Override // xyz.adscope.amps.tool.task.inter.IRequestTimeoutTimerCallBack
                public void callBackRequestedTimeout() {
                    try {
                        AMPSBaseOpenApiManager.this.isRequestTimeout = true;
                        if (AMPSBaseOpenApiManager.this.mAmpsManagerTask != null && AMPSBaseOpenApiManager.this.mAMPSBaseAdapter == null && AMPSBaseOpenApiManager.this.loadAdResourceDatas != null) {
                            for (AdSourceModel adSourceModel : AMPSBaseOpenApiManager.this.loadAdResourceDatas.values()) {
                                if (adSourceModel != null && adSourceModel.getAdStatus() < 5) {
                                    AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_LOAD_FAIL_CODE;
                                    if (AMPSBaseOpenApiManager.this.isC2SOrS2SAdSource(adSourceModel.getBiddingType()) && adSourceModel.getAdStatus() < 3) {
                                        aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_FAIL_CODE;
                                    }
                                    AMPSEventReportCode aMPSEventReportCode2 = aMPSEventReportCode;
                                    adSourceModel.setAdStatus(6);
                                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_TIMEOUT;
                                    adSourceModel.setErrorCode(channelErrorEnum.getErrorCode());
                                    adSourceModel.setErrorMsg(channelErrorEnum.getErrorMsg() + " , handlerRequestedTimeout");
                                    AMPSBaseOpenApiManager.this.uploadLog(adSourceModel, aMPSEventReportCode2, channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg() + " , handlerRequestedTimeout", 0L);
                                }
                            }
                            if (AMPSBaseOpenApiManager.this.iPriceComparatorInterface == null) {
                                return;
                            }
                            AMPSBaseOpenApiManager.this.iPriceComparatorInterface.comparePriceTimeout();
                            AdSourceModel winAdSourceModel = AMPSBaseOpenApiManager.this.iPriceComparatorInterface.getWinAdSourceModel();
                            if (winAdSourceModel != null) {
                                AMPSBaseOpenApiManager.this.callBackAdLoadSuccess(winAdSourceModel);
                                return;
                            }
                            AMPSBaseOpenApiManager aMPSBaseOpenApiManager = AMPSBaseOpenApiManager.this;
                            AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_REQUEST_TIME_OUT;
                            aMPSBaseOpenApiManager.callBackAdLoadFail(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg());
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isC2SOrS2SAdSource(String str) {
        return AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(str) || AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(str);
    }

    private boolean judgeIsHasNoResultAdSource() {
        try {
            for (AdSourceModel adSourceModel : this.loadAdResourceDatas.values()) {
                if (adSourceModel != null && adSourceModel.getAdStatus() >= 1 && adSourceModel.getAdStatus() <= 4) {
                    return true;
                }
            }
            return false;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private void modifyAdSourceAuctionStrategy(AdSourceModel adSourceModel, String str) {
        AuctionStrategyModel auctionStrategyModel;
        if (adSourceModel != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String decrypt = AesUtil.decrypt(KeyGenerator.generateAesKey(), str);
                if (TextUtils.isEmpty(decrypt)) {
                    return;
                }
                String decompressForGzip = GzipUtil.decompressForGzip(decrypt);
                if (!TextUtils.isEmpty(decompressForGzip) && (auctionStrategyModel = (AuctionStrategyModel) JsonUtil.fromJson(decompressForGzip, AuctionStrategyModel.class)) != null) {
                    AuctionStrategyModel auctionStrategy = adSourceModel.getAuctionStrategy();
                    if (auctionStrategy == null) {
                        auctionStrategy = new AuctionStrategyModel();
                    }
                    int raiseSortPrice = auctionStrategyModel.getRaiseSortPrice();
                    if (raiseSortPrice != -1) {
                        auctionStrategy.setRaiseSortPrice(raiseSortPrice);
                    }
                    int effectRate = auctionStrategyModel.getEffectRate();
                    if (effectRate != -1) {
                        auctionStrategy.setEffectRate(effectRate);
                    }
                    int auctionType = auctionStrategyModel.getAuctionType();
                    if (auctionType != -1) {
                        auctionStrategy.setAuctionType(auctionType);
                    }
                    int isLastLook = auctionStrategyModel.getIsLastLook();
                    if (isLastLook != -1) {
                        auctionStrategy.setIsLastLook(isLastLook);
                    }
                    int secondPrice = auctionStrategyModel.getSecondPrice();
                    if (secondPrice > 0) {
                        auctionStrategy.setSecondPrice(secondPrice);
                    }
                    String winPriceMin = auctionStrategyModel.getWinPriceMin();
                    if (!TextUtils.isEmpty(winPriceMin)) {
                        auctionStrategy.setWinPriceMin(winPriceMin);
                    }
                    String winPriceMax = auctionStrategyModel.getWinPriceMax();
                    if (!TextUtils.isEmpty(winPriceMax)) {
                        auctionStrategy.setWinPriceMax(winPriceMax);
                    }
                    String customData = auctionStrategyModel.getCustomData();
                    if (!TextUtils.isEmpty(customData)) {
                        auctionStrategy.setCustomData(customData);
                    }
                    adSourceModel.setAuctionStrategy(auctionStrategy);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    private void requestAdResource(AdSourceModel adSourceModel) {
        AMPSBaseAdapter baseAdapter;
        if (adSourceModel == null) {
            return;
        }
        try {
            String spaceId = adSourceModel.getSpaceId();
            if (AMPSConstants.BiddingType.BIDDING_TYPE_WF.equals(adSourceModel.getBiddingType())) {
                uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_GET_CACHE_CODE, "", "", 0L);
                AMPSAdSourceCacheInfo adSourceCacheInfo = AMPSCacheController.getInstance().getAdSourceCacheInfo(this.mSpaceId, spaceId);
                if (adSourceCacheInfo == null) {
                    AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_GET_CACHE_FAIL_CODE;
                    AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_GET_CACHE_FAIL;
                    uploadLog(adSourceModel, aMPSEventReportCode, reportLogErrorEnum.getErrorCode(), reportLogErrorEnum.getErrorMsg(), 0L);
                }
                if (adSourceCacheInfo != null && (baseAdapter = adSourceCacheInfo.getBaseAdapter()) != null) {
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_GET_CACHE_SUCCESS_CODE, "", "", 0L);
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "loadAdResource  cacheInfo spaceId:" + adSourceCacheInfo.getSpaceId());
                    adSourceModel.setCache(true);
                    this.loadAdResourceAdapters.put(adSourceModel.getSpaceId(), baseAdapter);
                    addFilterEvent(adSourceModel.getSpaceId(), "request");
                    onAdLoaded(baseAdapter);
                    return;
                }
            }
            AMPSBaseAdapter createAdapterClass = this.loadAdResourceAdapters.containsKey(adSourceModel.getSpaceId()) ? this.loadAdResourceAdapters.get(adSourceModel.getSpaceId()) : AMPSAdapterFactory.createAdapterClass(adSourceModel.getAdapterClass());
            if (createAdapterClass == null) {
                AMPSEventReportCode aMPSEventReportCode2 = AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_FAIL_SELECTOR_CODE;
                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum2 = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_BIDDING_FAIL_SELECTOR_ADAPTER_NULL;
                uploadLog(adSourceModel, aMPSEventReportCode2, reportLogErrorEnum2.getErrorCode(), reportLogErrorEnum2.getErrorMsg(), 0L);
                adSourceModel.setAdStatus(6);
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "loadAdResource  adapter name error spaceId:" + adSourceModel.getSpaceId());
                dispatchAdSourceByChannelResult(adSourceModel);
                return;
            }
            addFilterEvent(adSourceModel.getSpaceId(), "request");
            AMPSAdapterModel aMPSAdapterModel = new AMPSAdapterModel();
            aMPSAdapterModel.setAppId(adSourceModel.getAppId());
            aMPSAdapterModel.setSpaceId(adSourceModel.getSpaceId());
            aMPSAdapterModel.setTimeOut(this.mAdSourceRequestTimeout);
            aMPSAdapterModel.setZoomOut(adSourceModel.getZoomout());
            aMPSAdapterModel.setVideoSound(adSourceModel.getVideoSound());
            aMPSAdapterModel.setVideoMaxTime(adSourceModel.getVideoMaxTime());
            aMPSAdapterModel.setVideoAutoPlay(adSourceModel.getVideoAutoPlay());
            aMPSAdapterModel.setOrientation(adSourceModel.getOrientation());
            if (adSourceModel.getTemplateTypes() != null && adSourceModel.getTemplateTypes().size() > 0) {
                aMPSAdapterModel.setTemplateTypes(adSourceModel.getTemplateTypes());
            }
            AMPSRequestParameters aMPSRequestParameters = this.mAMPSRequestParameters;
            if (aMPSRequestParameters != null) {
                aMPSAdapterModel.setAdCount(aMPSRequestParameters.getAdCount());
                aMPSAdapterModel.setExpressViewWidth(this.mAMPSRequestParameters.getWidth());
                aMPSAdapterModel.setExpressViewHeight(this.mAMPSRequestParameters.getHeight());
                aMPSAdapterModel.setUserId(this.mAMPSRequestParameters.getUserId());
                aMPSAdapterModel.setExtra(this.mAMPSRequestParameters.getExtraData());
                aMPSAdapterModel.setLocalCustomParameter(this.mAMPSRequestParameters.getCustomExtraParameters());
            }
            AMPSInitAdapterConfig aMPSInitAdapterConfig = new AMPSInitAdapterConfig();
            aMPSInitAdapterConfig.setAppId(adSourceModel.getAppId());
            aMPSInitAdapterConfig.setAmpsInitChannelAdapterConfig(this.ampsInitChannelAdapterConfig);
            aMPSAdapterModel.setAmpsInitAdapterConfig(aMPSInitAdapterConfig);
            aMPSAdapterModel.setIsSendBidData(adSourceModel.getIsSendBidData());
            aMPSAdapterModel.setEcpm(adSourceModel.getEcpm());
            aMPSAdapterModel.setSeatId(adSourceModel.getSeatId());
            aMPSAdapterModel.setBiddingType(adSourceModel.getBiddingType());
            aMPSAdapterModel.setFloorEcpm(adSourceModel.getFloorEcpm());
            aMPSAdapterModel.setAccountId(adSourceModel.getAccountId());
            aMPSAdapterModel.setServerUrl(adSourceModel.getServerUrl());
            aMPSAdapterModel.setPublicKey(adSourceModel.getPublicKey());
            this.loadAdResourceAdapters.put(adSourceModel.getSpaceId(), createAdapterClass);
            if (!adSourceModel.isCache()) {
                if (!isC2SOrS2SAdSource(adSourceModel.getBiddingType()) || adSourceModel.getAdStatus() > 1) {
                    adSourceModel.setRequestStartTime(System.currentTimeMillis());
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_LOAD_CODE, "", "", 0L);
                } else {
                    adSourceModel.setBiddingStartTime(System.currentTimeMillis());
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_CODE, "", "", 0L);
                }
            }
            if (!isC2SOrS2SAdSource(adSourceModel.getBiddingType()) || adSourceModel.getAdStatus() > 1) {
                adSourceModel.setAdStatus(4);
                createAdapterClass.loadNetworkAd(this.mContext, aMPSAdapterModel, this);
            } else {
                adSourceModel.setAdStatus(2);
                createAdapterClass.startBid(this.mContext, aMPSAdapterModel, this);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void sendLosNotice() {
        AMPSBaseAdapter aMPSBaseAdapter;
        try {
            for (AdSourceModel adSourceModel : this.loadAdResourceDatas.values()) {
                if (adSourceModel != null && !AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType())) {
                    String spaceId = adSourceModel.getSpaceId();
                    if (!TextUtils.isEmpty(spaceId)) {
                        AdSourceModel adSourceModel2 = this.mWinAdSourceModel;
                        if (!spaceId.equalsIgnoreCase(adSourceModel2 != null ? adSourceModel2.getSpaceId() : "") && this.loadAdResourceAdapters.containsKey(spaceId) && (aMPSBaseAdapter = this.loadAdResourceAdapters.get(spaceId)) != null) {
                            AMPSBidResult aMPSBidResult = new AMPSBidResult();
                            int calcLossECPM = calcLossECPM(adSourceModel);
                            adSourceModel.setNoticePrice(String.valueOf(calcLossECPM));
                            if (this.mWinAdSourceModel != null) {
                                adSourceModel.setRealPrice(this.mWinAdSourceModel.getEcpm() + "");
                                adSourceModel.setBidSeatId(this.mWinAdSourceModel.getSeatId());
                                adSourceModel.setBidSpaceId(this.mWinAdSourceModel.getSpaceId());
                            }
                            aMPSBidResult.setEcpm(calcLossECPM);
                            aMPSBidResult.setChannelName(this.mWinAdSourceModel.getSeatId());
                            aMPSBidResult.setBidType(this.mWinAdSourceModel.getBiddingType());
                            if (adSourceModel.getEcpm() > 0) {
                                aMPSBidResult.setReason(1);
                                adSourceModel.setLossReason(String.valueOf(1));
                            } else if (AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_TIMEOUT.getErrorCode().equals(adSourceModel.getErrorCode())) {
                                aMPSBidResult.setReason(3);
                                adSourceModel.setLossReason(String.valueOf(3));
                            } else {
                                aMPSBidResult.setReason(2);
                                adSourceModel.setLossReason(String.valueOf(2));
                            }
                            aMPSBaseAdapter.sendLossNotice(aMPSBidResult);
                            uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_LOAD_LOSS_CODE, "", "", 0L);
                        }
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void sendLosNoticeByFail() {
        AMPSBaseAdapter aMPSBaseAdapter;
        try {
            for (AdSourceModel adSourceModel : this.loadAdResourceDatas.values()) {
                if (adSourceModel != null && !AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType())) {
                    String spaceId = adSourceModel.getSpaceId();
                    if (!TextUtils.isEmpty(spaceId) && adSourceModel.getAdStatus() == 6 && this.loadAdResourceAdapters.containsKey(spaceId) && (aMPSBaseAdapter = this.loadAdResourceAdapters.get(spaceId)) != null) {
                        AMPSBidResult aMPSBidResult = new AMPSBidResult();
                        aMPSBidResult.setEcpm(0);
                        aMPSBidResult.setChannelName("9999");
                        aMPSBidResult.setBidType("other");
                        if (AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_TIMEOUT.getErrorCode().equals(adSourceModel.getErrorCode())) {
                            aMPSBidResult.setReason(3);
                        } else {
                            aMPSBidResult.setReason(2);
                        }
                        aMPSBaseAdapter.sendLossNotice(aMPSBidResult);
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void starLoadAdResource(AdSourceModel adSourceModel) {
        if (adSourceModel == null) {
            return;
        }
        try {
            requestAdResource(adSourceModel);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void startCacheLoadSuccessAdSource() {
        try {
            for (AdSourceModel adSourceModel : this.loadAdResourceDatas.values()) {
                if (adSourceModel != null) {
                    String spaceId = adSourceModel.getSpaceId();
                    if (!TextUtils.isEmpty(spaceId) && adSourceModel.getAdStatus() == 5 && AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType()) && !adSourceModel.isCache()) {
                        AMPSBaseAdapter aMPSBaseAdapter = this.mAMPSBaseAdapter;
                        if (aMPSBaseAdapter != null) {
                            String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
                            if (!TextUtils.isEmpty(networkSpaceId) && networkSpaceId.equalsIgnoreCase(spaceId)) {
                            }
                        }
                        AMPSBaseAdapter aMPSBaseAdapter2 = this.loadAdResourceAdapters.containsKey(spaceId) ? this.loadAdResourceAdapters.get(spaceId) : null;
                        if (aMPSBaseAdapter2 != null) {
                            AMPSCacheController.getInstance().addAdSourceCacheInfo(this.mSpaceModel, adSourceModel, aMPSBaseAdapter2);
                        }
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0085 A[Catch: Exception -> 0x0028, TryCatch #0 {Exception -> 0x0028, blocks: (B:3:0x0004, B:8:0x000c, B:12:0x0014, B:14:0x0024, B:16:0x002a, B:18:0x0034, B:25:0x0085, B:26:0x0086, B:28:0x0050, B:30:0x0056, B:31:0x0061, B:33:0x0074, B:36:0x007e), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void updateAdSourceECPM(xyz.adscope.amps.model.config.response.AdSourceModel r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L4
            goto L89
        L4:
            xyz.adscope.amps.model.config.response.AuctionStrategyModel r0 = r8.getAuctionStrategy()     // Catch: java.lang.Exception -> L28
            if (r0 != 0) goto Lc
            goto L89
        Lc:
            boolean r1 = r0.isHit()     // Catch: java.lang.Exception -> L28
            if (r1 != 0) goto L14
            goto L89
        L14:
            int r1 = r0.getOriginEcpm()     // Catch: java.lang.Exception -> L28
            java.lang.String r2 = "WF"
            java.lang.String r3 = r8.getBiddingType()     // Catch: java.lang.Exception -> L28
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch: java.lang.Exception -> L28
            if (r2 == 0) goto L2a
            r8.setEcpm(r1)     // Catch: java.lang.Exception -> L28
            return
        L28:
            r8 = move-exception
            goto L8a
        L2a:
            java.lang.String r2 = r8.getBiddingType()     // Catch: java.lang.Exception -> L28
            boolean r2 = r7.isC2SOrS2SAdSource(r2)     // Catch: java.lang.Exception -> L28
            if (r2 == 0) goto L89
            int r2 = r8.getEcpm()     // Catch: java.lang.Exception -> L28
            int r3 = r0.getRaiseSortPrice()     // Catch: java.lang.Exception -> L28
            boolean r4 = r0.isUseLastLook()     // Catch: java.lang.Exception -> L28
            int r5 = r0.getAuctionType()     // Catch: java.lang.Exception -> L28
            boolean r6 = r0.isRaise()     // Catch: java.lang.Exception -> L28
            if (r4 != 0) goto L50
            r4 = 2
            if (r5 != r4) goto L4e
            goto L50
        L4e:
            r1 = r2
            goto L83
        L50:
            xyz.adscope.amps.model.config.response.AdSourceModel r4 = r7.getSecondAdSourceModel()     // Catch: java.lang.Exception -> L28
            if (r4 == 0) goto L60
            int r5 = r4.getEcpm()     // Catch: java.lang.Exception -> L28
            int r4 = r4.getEcpm()     // Catch: java.lang.Exception -> L28
            int r2 = r2 - r4
            goto L61
        L60:
            r5 = 0
        L61:
            java.lang.String r4 = r0.getWinPriceMin()     // Catch: java.lang.Exception -> L28
            java.lang.String r0 = r0.getWinPriceMax()     // Catch: java.lang.Exception -> L28
            int r4 = r7.getProfitPrice(r2, r4)     // Catch: java.lang.Exception -> L28
            int r0 = r7.getProfitPrice(r2, r0)     // Catch: java.lang.Exception -> L28
            r2 = 1
            if (r4 >= r0) goto L79
            int r0 = xyz.adscope.amps.tool.util.AMPSRandomUtil.getRandomNum(r4, r0)     // Catch: java.lang.Exception -> L28
            goto L7a
        L79:
            r0 = 1
        L7a:
            if (r0 > 0) goto L7d
            goto L7e
        L7d:
            r2 = r0
        L7e:
            int r5 = r5 + r2
            if (r5 <= r1) goto L82
            goto L83
        L82:
            r1 = r5
        L83:
            if (r6 == 0) goto L86
            int r1 = r1 - r3
        L86:
            r8.setEcpm(r1)     // Catch: java.lang.Exception -> L28
        L89:
            return
        L8a:
            r8.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.manager.AMPSBaseOpenApiManager.updateAdSourceECPM(xyz.adscope.amps.model.config.response.AdSourceModel):void");
    }

    private void updateC2SOrS2SAdSourceAdStatus(AdSourceModel adSourceModel, AMPSBaseBiddingResult aMPSBaseBiddingResult) {
        if (adSourceModel == null) {
            return;
        }
        try {
            if (aMPSBaseBiddingResult == null) {
                adSourceModel.setAdStatus(6);
                long currentTimeMillis = System.currentTimeMillis() - adSourceModel.getBiddingStartTime();
                AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_FAIL_CODE;
                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_BIDDING_FAIL_RESULT_NULL;
                uploadLog(adSourceModel, aMPSEventReportCode, reportLogErrorEnum.getErrorCode(), reportLogErrorEnum.getErrorMsg(), currentTimeMillis);
                return;
            }
            if (adSourceModel.getAdStatus() == 6) {
                adSourceModel.setAdStatus(6);
                return;
            }
            if (!aMPSBaseBiddingResult.isSuccess()) {
                adSourceModel.setAdStatus(6);
                long currentTimeMillis2 = System.currentTimeMillis() - adSourceModel.getBiddingStartTime();
                AMPSEventReportCode aMPSEventReportCode2 = AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_FAIL_CODE;
                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum2 = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_BIDDING_FAIL_RESULT;
                uploadLog(adSourceModel, aMPSEventReportCode2, reportLogErrorEnum2.getErrorCode(), reportLogErrorEnum2.getErrorMsg(), currentTimeMillis2);
                return;
            }
            adSourceModel.setEcpm(aMPSBaseBiddingResult.getEcpm());
            adSourceModel.setReportEcpm(aMPSBaseBiddingResult.getEcpm());
            if (aMPSBaseBiddingResult.getEcpm() >= adSourceModel.getFloorEcpm()) {
                uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_SUCCESS_CODE, "", "", System.currentTimeMillis() - adSourceModel.getBiddingStartTime());
                adSourceModel.setAdStatus(3);
            } else {
                adSourceModel.setAdStatus(6);
                AMPSEventReportCode aMPSEventReportCode3 = AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_COMPARE_FAIL_CODE;
                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum3 = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_BIDDING_COMPARE_FAIL_LESS_FLOOR;
                uploadLog(adSourceModel, aMPSEventReportCode3, reportLogErrorEnum3.getErrorCode(), reportLogErrorEnum3.getErrorMsg(), 0L);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void destroy() {
        try {
            Map<String, AdSourceModel> map = this.loadAdResourceDatas;
            if (map != null && !map.isEmpty()) {
                for (AdSourceModel adSourceModel : this.loadAdResourceDatas.values()) {
                    if (adSourceModel != null && adSourceModel.getAdStatus() < 5) {
                        AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_LOAD_FAIL_CODE;
                        AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_ADSOURCE_LOAD_REQUEST_FAIL;
                        try {
                            uploadLog(adSourceModel, aMPSEventReportCode, reportLogErrorEnum.getErrorCode(), reportLogErrorEnum.getErrorMsg() + " onDestroy", 0L);
                        } catch (Exception e6) {
                            e = e6;
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            }
            Map<String, AMPSBaseAdapter> map2 = this.loadAdResourceAdapters;
            if (map2 != null && map2.size() > 0) {
                Iterator<Map.Entry<String, AMPSBaseAdapter>> it = this.loadAdResourceAdapters.entrySet().iterator();
                while (it.hasNext()) {
                    AMPSBaseAdapter value = it.next().getValue();
                    if (value != null) {
                        value.destroy();
                    }
                }
            }
            this.mAMPSBaseAdapter = null;
            Map<String, AdSourceModel> map3 = this.loadAdResourceDatas;
            if (map3 != null) {
                map3.clear();
            }
            this.loadAdResourceDatas = null;
            Map<String, AMPSBaseAdapter> map4 = this.loadAdResourceAdapters;
            if (map4 != null) {
                map4.clear();
            }
            this.loadAdResourceAdapters = null;
            this.mSpaceModel = null;
            List<AdSourceModel> list = this.mS2SAdSourceList;
            if (list != null) {
                list.clear();
            }
            this.mS2SAdSourceList = null;
            List<AdSourceModel> list2 = this.mC2SAdSourceList;
            if (list2 != null) {
                list2.clear();
            }
            this.mC2SAdSourceList = null;
            List<AdSourceModel> list3 = this.mFloorAdSourceList;
            if (list3 != null) {
                list3.clear();
            }
            this.mFloorAdSourceList = null;
            this.iDispatcherInterface = null;
            this.iPriceComparatorInterface = null;
            this.mContext = null;
            AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
            if (aMPSInitChannelAdapterConfig != null) {
                aMPSInitChannelAdapterConfig.clear();
                this.ampsInitChannelAdapterConfig = null;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    public int getAdAutoRefreshSwitch() {
        return this.mAdAutoRefreshSwitch;
    }

    public long getSpaceCachedOffersTimeout() {
        return this.mSpaceCachedOffersTimeout;
    }

    public AMPSBaseAdapter getWinAdSourceAdapter() {
        return this.mAMPSBaseAdapter;
    }

    public AdSourceModel getWinAdSourceModel() {
        return this.mWinAdSourceModel;
    }

    public boolean isWinAdSource(AMPSBaseAdapter aMPSBaseAdapter) {
        AMPSBaseAdapter aMPSBaseAdapter2;
        if (aMPSBaseAdapter == null) {
            return false;
        }
        String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
        return (TextUtils.isEmpty(networkSpaceId) || (aMPSBaseAdapter2 = this.mAMPSBaseAdapter) == null || !aMPSBaseAdapter2.getNetworkSpaceId().equals(networkSpaceId)) ? false : true;
    }

    @Override // xyz.adscope.amps.inner.AMPSBaseAdAdapterListener
    public void onAdClicked(AMPSBaseAdapter aMPSBaseAdapter) {
        try {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " onAdClicked ");
            if (this.ampsLoadEventListener != null && isWinAdSource(aMPSBaseAdapter)) {
                AMPSLoadEventListener aMPSLoadEventListener = this.ampsLoadEventListener;
                if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
                    ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdClicked();
                } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
                    ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdClicked();
                } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
                    ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdVideoClick();
                } else if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
                    ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdClicked();
                }
                AMPSBaseAdapter aMPSBaseAdapter2 = this.mAMPSBaseAdapter;
                if (aMPSBaseAdapter2 != null) {
                    String networkSpaceId = aMPSBaseAdapter2.getNetworkSpaceId();
                    addFilterEvent(networkSpaceId, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK);
                    AdSourceModel adSourceModel = this.loadAdResourceDatas.get(networkSpaceId);
                    if (adSourceModel == null) {
                        return;
                    }
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_CLICK_CODE, "", "", 0L);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.inner.AMPSBaseAdAdapterListener
    public void onAdDismiss(AMPSBaseAdapter aMPSBaseAdapter) {
        AdSourceModel adSourceModel;
        AMPSLoadEventListener aMPSLoadEventListener;
        try {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " onAdDismiss ");
            if (this.isAdClosed) {
                if (isWinAdSource(aMPSBaseAdapter) && (aMPSLoadEventListener = this.ampsLoadEventListener) != null && (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener)) {
                    ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdDismiss();
                    return;
                }
                return;
            }
            if (isWinAdSource(aMPSBaseAdapter)) {
                this.isAdClosed = true;
                AMPSLoadEventListener aMPSLoadEventListener2 = this.ampsLoadEventListener;
                if (aMPSLoadEventListener2 == null) {
                    return;
                }
                if (aMPSLoadEventListener2 instanceof AMPSSplashLoadEventListener) {
                    ((AMPSSplashLoadEventListener) aMPSLoadEventListener2).onAmpsAdDismiss();
                } else if (aMPSLoadEventListener2 instanceof AMPSInterstitialLoadEventListener) {
                    ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener2).onAmpsAdDismiss();
                } else if (aMPSLoadEventListener2 instanceof AMPSRewardVideoLoadEventListener) {
                    ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener2).onAmpsAdDismiss();
                } else if (aMPSLoadEventListener2 instanceof AMPSBannerLoadEventListener) {
                    ((AMPSBannerLoadEventListener) aMPSLoadEventListener2).onAmpsAdDismiss();
                }
                AMPSBaseAdapter aMPSBaseAdapter2 = this.mAMPSBaseAdapter;
                if (aMPSBaseAdapter2 != null) {
                    String networkSpaceId = aMPSBaseAdapter2.getNetworkSpaceId();
                    if (!TextUtils.isEmpty(networkSpaceId) && (adSourceModel = this.loadAdResourceDatas.get(networkSpaceId)) != null) {
                        for (AdSourceModel adSourceModel2 : this.loadAdResourceDatas.values()) {
                            if (adSourceModel2 != null && adSourceModel2.getAdStatus() < 5) {
                                adSourceModel2.setAdStatus(6);
                                AMPSEventReportCode aMPSEventReportCode = AMPSEventReportCode.EVENT_ADSOURCE_LOAD_FAIL_CODE;
                                AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_TIMEOUT;
                                uploadLog(adSourceModel2, aMPSEventReportCode, channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg() + " , onAdDismiss", 0L);
                            }
                        }
                        uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_CLOSE_CODE, "", "", 0L);
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void onAdFailed(AMPSBaseAdapter aMPSBaseAdapter, AMPSError aMPSError) {
        AdSourceModel adSourceModel;
        try {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " onAdFailed code: " + aMPSError.getCode() + ";message:" + aMPSError.getMessage() + " spaceID:" + aMPSBaseAdapter.getNetworkSpaceId());
            if (this.ampsLoadEventListener != null) {
                String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
                if (!TextUtils.isEmpty(networkSpaceId) && this.loadAdResourceDatas.containsKey(networkSpaceId) && (adSourceModel = this.loadAdResourceDatas.get(networkSpaceId)) != null) {
                    if (adSourceModel.getAdStatus() != 6) {
                        long currentTimeMillis = System.currentTimeMillis() - adSourceModel.getRequestStartTime();
                        adSourceModel.setAdStatus(6);
                        String code = aMPSError.getCode();
                        String message = aMPSError.getMessage();
                        adSourceModel.setErrorCode(code);
                        adSourceModel.setErrorMsg(message);
                        try {
                            uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_LOAD_FAIL_CODE, code, message, currentTimeMillis);
                        } catch (Exception e6) {
                            e = e6;
                            e.printStackTrace();
                            return;
                        }
                    }
                    dispatchAdSourceByChannelResult(adSourceModel);
                }
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    public void onAdLoaded(AMPSBaseAdapter aMPSBaseAdapter) {
        AdSourceModel adSourceModel;
        AMPSBaseOpenApiManager<T> aMPSBaseOpenApiManager;
        long j6;
        try {
            if (this.ampsLoadEventListener != null && aMPSBaseAdapter != null) {
                String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
                if (!TextUtils.isEmpty(networkSpaceId) && this.loadAdResourceDatas.containsKey(networkSpaceId) && (adSourceModel = this.loadAdResourceDatas.get(networkSpaceId)) != null) {
                    if (adSourceModel.isCache()) {
                        aMPSBaseOpenApiManager = this;
                        j6 = 0;
                    } else {
                        j6 = System.currentTimeMillis() - adSourceModel.getRequestStartTime();
                        aMPSBaseOpenApiManager = this;
                        try {
                            aMPSBaseOpenApiManager.uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_LOAD_SUCCESS_CODE, "", "", j6);
                        } catch (Exception e6) {
                            e = e6;
                            e.printStackTrace();
                            return;
                        }
                    }
                    AMPSLogUtil.e(AMPSConstants.AMPS_LOG_TAG, aMPSBaseOpenApiManager.TAG + " channel:" + adSourceModel.getSeatId() + " spaceId:" + networkSpaceId + ", onAdLoaded success time:" + j6);
                    adSourceModel.setAdStatus(5);
                    aMPSBaseOpenApiManager.isHasLoadingSuccess = true;
                    if (aMPSBaseOpenApiManager.mAMPSBaseAdapter != null && !adSourceModel.isCache() && AMPSConstants.BiddingType.BIDDING_TYPE_WF.equalsIgnoreCase(adSourceModel.getBiddingType())) {
                        AMPSCacheController.getInstance().addAdSourceCacheInfo(aMPSBaseOpenApiManager.mSpaceModel, adSourceModel, aMPSBaseAdapter);
                    }
                    comparePrice(aMPSBaseAdapter, adSourceModel);
                }
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    @Override // xyz.adscope.amps.inner.AMPSBaseAdAdapterListener
    public void onAdShow(AMPSBaseAdapter aMPSBaseAdapter) {
        try {
            if (this.ampsLoadEventListener != null && isWinAdSource(aMPSBaseAdapter)) {
                String adType = this.mWinAdSourceModel.getAdType();
                if (!AMPSReportConstants.REPORT_AD_TYPE.AD_TYPE_NATIVE_EXPRESS.getCode().equals(adType) && !AMPSReportConstants.REPORT_AD_TYPE.AD_TYPE_NATIVE_UNIFIED.getCode().equals(adType)) {
                    saveWinAdSourceMaterial();
                }
                this.mSpaceAdStatus = 2;
                AMPSLoadEventListener aMPSLoadEventListener = this.ampsLoadEventListener;
                if (aMPSLoadEventListener instanceof AMPSSplashLoadEventListener) {
                    ((AMPSSplashLoadEventListener) aMPSLoadEventListener).onAmpsAdShow();
                } else if (aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener) {
                    ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsAdShow();
                } else if (aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener) {
                    ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdShow();
                } else if (aMPSLoadEventListener instanceof AMPSBannerLoadEventListener) {
                    ((AMPSBannerLoadEventListener) aMPSLoadEventListener).onAmpsAdShow();
                }
                AMPSBaseAdapter aMPSBaseAdapter2 = this.mAMPSBaseAdapter;
                if (aMPSBaseAdapter2 != null) {
                    String networkSpaceId = aMPSBaseAdapter2.getNetworkSpaceId();
                    addFilterEvent(networkSpaceId, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW);
                    AdSourceModel adSourceModel = this.loadAdResourceDatas.get(networkSpaceId);
                    if (adSourceModel == null) {
                        return;
                    }
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_SHOW_CODE, "", "", 0L);
                    uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_EXPOSURE_CODE, "", "", 0L);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.inner.AMPSBaseAdAdapterListener
    public void onAdShowFailed(AMPSBaseAdapter aMPSBaseAdapter, AMPSError aMPSError) {
        Exception exc;
        String code;
        String message;
        try {
            if (this.mWinAdSourceModel != null && isWinAdSource(aMPSBaseAdapter) && this.mWinAdSourceModel.getAdStatus() == 5) {
                if (aMPSError != null) {
                    try {
                        code = aMPSError.getCode();
                        message = aMPSError.getMessage();
                    } catch (Exception e6) {
                        exc = e6;
                        exc.printStackTrace();
                    }
                } else {
                    code = "";
                    message = code;
                }
                try {
                    uploadLog(this.mWinAdSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_SHOW_FAIL_CODE, code, message, 0L);
                    this.isDispatchFloorAdSource = true;
                    AMPSCacheController.getInstance().removeAdSourceCacheInfo(this.mSpaceId, this.mWinAdSourceModel.getSpaceId());
                    callBackAdLoadFail(code, message);
                } catch (Exception e7) {
                    e = e7;
                    exc = e;
                    exc.printStackTrace();
                }
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    @Override // xyz.adscope.amps.inner.AMPSAdBiddingListener
    public void onC2SBiddingFail(AMPSBaseAdapter aMPSBaseAdapter, AMPSBaseBiddingResult aMPSBaseBiddingResult) {
        AdSourceModel adSourceModel;
        if (aMPSBaseAdapter != null && aMPSBaseBiddingResult != null) {
            try {
                String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
                if (!TextUtils.isEmpty(networkSpaceId) && this.loadAdResourceDatas.containsKey(networkSpaceId) && (adSourceModel = this.loadAdResourceDatas.get(networkSpaceId)) != null && adSourceModel.getAdStatus() != 5) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " onC2SBiddingFail  channel:" + adSourceModel.getSeatId() + ",spaceId:" + networkSpaceId + ";adStatus:" + adSourceModel.getAdStatus() + ";" + aMPSBaseBiddingResult.toString());
                    adSourceModel.setAdStatus(6);
                    try {
                        uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_FAIL_CODE, aMPSBaseBiddingResult.getErrorCode(), aMPSBaseBiddingResult.getErrorMsg(), System.currentTimeMillis() - adSourceModel.getBiddingStartTime());
                        if (adSourceModel.getIsFloor() == 1) {
                            handleC2SOrS2SFloorAdSourceBidResult(adSourceModel, aMPSBaseBiddingResult, 4);
                        } else {
                            handleC2SOrS2SAdSourceBidResult(adSourceModel, aMPSBaseBiddingResult, 4);
                        }
                    } catch (Exception e6) {
                        e = e6;
                        e.printStackTrace();
                    }
                }
            } catch (Exception e7) {
                e = e7;
            }
        }
    }

    @Override // xyz.adscope.amps.inner.AMPSAdBiddingListener
    public void onS2SBiddingFail(AMPSBaseAdapter aMPSBaseAdapter, AMPSBaseBiddingResult aMPSBaseBiddingResult) {
        AdSourceModel adSourceModel;
        if (aMPSBaseAdapter != null && aMPSBaseBiddingResult != null) {
            try {
                String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
                if (!TextUtils.isEmpty(networkSpaceId) && this.loadAdResourceDatas.containsKey(networkSpaceId) && (adSourceModel = this.loadAdResourceDatas.get(networkSpaceId)) != null && adSourceModel.getAdStatus() != 5) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, this.TAG + " onS2SBiddingFail  channel:" + adSourceModel.getSeatId() + ",spaceId:" + networkSpaceId + ";adStatus:" + adSourceModel.getAdStatus() + ";" + aMPSBaseBiddingResult.toString());
                    adSourceModel.setAdStatus(6);
                    try {
                        uploadLog(adSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_BIDDING_FAIL_CODE, aMPSBaseBiddingResult.getErrorCode(), aMPSBaseBiddingResult.getErrorMsg(), System.currentTimeMillis() - adSourceModel.getBiddingStartTime());
                        if (adSourceModel.getIsFloor() == 1) {
                            handleC2SOrS2SFloorAdSourceBidResult(adSourceModel, aMPSBaseBiddingResult, 4);
                        } else {
                            handleC2SOrS2SAdSourceBidResult(adSourceModel, aMPSBaseBiddingResult, 4);
                        }
                    } catch (Exception e6) {
                        e = e6;
                        e.printStackTrace();
                    }
                }
            } catch (Exception e7) {
                e = e7;
            }
        }
    }

    public void refreshListener(T t5) {
        this.ampsLoadEventListener = t5;
    }

    protected void saveWinAdSourceMaterial(View view) {
        AMPSGlobalModel globalModel = AMPSSDKManager.getInstance().getIAMPSInitInterface().getGlobalModel();
        MaterialManagerModel materialManager = globalModel.getConfigureResponseModel().getMaterialManager();
        if (materialManager == null) {
            return;
        }
        if (AMPSRandomUtil.getRandomNum(100) > materialManager.getRandom()) {
            return;
        }
        AMPSUploadMaterial aMPSUploadMaterial = new AMPSUploadMaterial();
        aMPSUploadMaterial.setAppId(globalModel.getAppId());
        aMPSUploadMaterial.setSpaceId(this.mAMPSRequestParameters.getSpaceId());
        aMPSUploadMaterial.setSeatId(this.mWinAdSourceModel.getSeatId());
        aMPSUploadMaterial.setSeatAppId(this.mWinAdSourceModel.getAppId());
        aMPSUploadMaterial.setSeatSpaceId(this.mWinAdSourceModel.getSpaceId());
        aMPSUploadMaterial.setAdType(this.mWinAdSourceModel.getAdType());
        aMPSUploadMaterial.setStartId(globalModel.getStartId());
        aMPSUploadMaterial.setSessionId(this.mSessionId);
        aMPSUploadMaterial.setSaid(DeviceInfo.getInstance(this.mContext).getSdkid());
        if (view != null) {
            this.currentViewGroup = view;
        }
        new MaterialManager(this.mContext, this.currentViewGroup, aMPSUploadMaterial).saveMaterial();
    }

    public void startLoad() {
        try {
            if (this.isFirstLoadAd && this.mSpaceModel == null) {
                AMPSSDKManager.getInstance().setInitResultCallBack(new IAMPSInitCallback() { // from class: xyz.adscope.amps.manager.AMPSBaseOpenApiManager.1
                    @Override // xyz.adscope.amps.init.inter.IAMPSInitCallback
                    public void failCallback(AMPSError aMPSError) {
                        AMPSBaseOpenApiManager.this.uploadLog(null, AMPSEventReportCode.EVENT_MEDIATION_LOAD_CODE, "", "", 0L);
                        AMPSBaseOpenApiManager.this.isDispatchFloorAdSource = true;
                        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = AMPSBaseOpenApiManager.this;
                        AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_PARAM_ERROR;
                        aMPSBaseOpenApiManager.callBackAdLoadFail(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg());
                    }

                    @Override // xyz.adscope.amps.init.inter.IAMPSInitCallback
                    public void successCallback() {
                        AMPSBaseOpenApiManager.this.mSpaceModel = AMPSAdSourceDataProvider.getInstance().buildDispatcherModel(AMPSBaseOpenApiManager.this.mAMPSRequestParameters);
                        if (AMPSBaseOpenApiManager.this.mSpaceModel != null) {
                            AMPSBaseOpenApiManager.this.initData();
                            AMPSBaseOpenApiManager.this.startLoad();
                            return;
                        }
                        AMPSBaseOpenApiManager.this.uploadLog(null, AMPSEventReportCode.EVENT_MEDIATION_LOAD_CODE, "", "", 0L);
                        AMPSBaseOpenApiManager.this.isDispatchFloorAdSource = true;
                        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = AMPSBaseOpenApiManager.this;
                        AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_PARAM_ERROR;
                        aMPSBaseOpenApiManager.callBackAdLoadFail(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg());
                    }
                });
                this.isFirstLoadAd = false;
                return;
            }
            try {
                uploadLog(null, AMPSEventReportCode.EVENT_MEDIATION_LOAD_CODE, "", "", 0L);
                try {
                    if (this.mSpaceModel != null && this.mAMPSRequestParameters != null && this.iFilterInterface != null && this.iDispatcherInterface != null) {
                        uploadLog(null, AMPSEventReportCode.EVENT_SPACE_FILTER_CODE, "", "", 0L);
                        if (!this.iFilterInterface.platformFilter()) {
                            this.isDispatchFloorAdSource = true;
                            uploadLog(null, AMPSEventReportCode.EVENT_SPACE_FILTER_FAIL_CODE, "", "", 0L);
                            AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_FILTER_NOT_PASS;
                            callBackAdLoadFail(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg());
                            return;
                        }
                        uploadLog(null, AMPSEventReportCode.EVENT_SPACE_FILTER_SUCCESS_CODE, "", "", 0L);
                        createAMPSInitCustomAdapterConfig();
                        addFilterEvent("", "request");
                        handlerBiddingTimeout();
                        handlerRequestedTimeout();
                        uploadLog(null, AMPSEventReportCode.EVENT_FORWARD_BEGIN_CODE, "", "", 0L);
                        List<AdSourceModel> dispatch = this.iDispatcherInterface.dispatch(null);
                        uploadLog(null, AMPSEventReportCode.EVENT_FORWARD_RESULT_CODE, "", "", 0L);
                        dispatchAdSource(dispatch);
                        dispatchAdSourceByFloor();
                        return;
                    }
                    this.isDispatchFloorAdSource = true;
                    AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum2 = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_PARAM_ERROR;
                    callBackAdLoadFail(aSMPLogicErrorEnum2.getErrorCode(), aSMPLogicErrorEnum2.getErrorMsg());
                } catch (Exception e6) {
                    e = e6;
                    e.printStackTrace();
                }
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    public AMPSBaseOpenApiManager(Context context, AMPSRequestParameters aMPSRequestParameters, T t5) {
        this.mContext = context;
        this.mAMPSRequestParameters = aMPSRequestParameters;
        this.ampsLoadEventListener = t5;
        SpaceModel buildDispatcherModel = AMPSAdSourceDataProvider.getInstance().buildDispatcherModel(aMPSRequestParameters);
        this.mSpaceModel = buildDispatcherModel;
        if (buildDispatcherModel == null) {
            return;
        }
        initData();
    }

    private void addFilterEvent(String str, String str2) {
        IFilterInterface iFilterInterface;
        try {
            if (!TextUtils.isEmpty(str2) && (iFilterInterface = this.iFilterInterface) != null) {
                iFilterInterface.addFilterEvent(new AMPSFrequencyEventModel(str, str2));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void handleC2SOrS2SFloorAdSourceBidResult(AdSourceModel adSourceModel, AMPSBaseBiddingResult aMPSBaseBiddingResult, int i6) {
        try {
            if (adSourceModel.getAdStatus() == 3 && i6 == 2) {
                starLoadAdResource(adSourceModel);
            } else {
                handleCallbackAdSourceLoadResult();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        this.mediationStartTime = System.currentTimeMillis();
        this.mSessionId = AMPSStringUtil.createRequestId();
        SpaceModel spaceModel = this.mSpaceModel;
        if (spaceModel != null) {
            this.mSpaceId = spaceModel.getSpaceId();
            this.mSpaceCachedOffersTimeout = this.mSpaceModel.getCachedOffersTimeout();
            this.mAdRequestType = this.mSpaceModel.getBidDistributionMethod();
            this.mBidAdTimeout = this.mSpaceModel.getBidAdTimeout();
            this.mFloorDelayTime = this.mSpaceModel.getFloorDelayTime();
            this.mAdRequestTimeout = this.mSpaceModel.getAdTimeout();
            this.mAdSourceRequestTimeout = (int) this.mSpaceModel.getAdsTimeout();
            this.mS2SAdSourceList = this.mSpaceModel.getS2sAdSourceList();
            this.mC2SAdSourceList = this.mSpaceModel.getC2sAdSourceList();
            this.mFloorAdSourceList = this.mSpaceModel.getFloorAdSourceList();
            this.mAdAutoRefreshSwitch = this.mSpaceModel.getAutoRefreshSwitch();
        }
        this.mAmpsManagerTask = new AMPSManagerTask();
        this.iFilterInterface = new AMPSFilter(this.mSpaceModel);
        this.iDispatcherInterface = new AMPSDispatcher(this.mSpaceModel);
        this.iPriceComparatorInterface = new AMPSPriceComparator(this.mSpaceModel, this.loadAdResourceDatas);
    }

    private void removeCacheAdSource(String str) {
        AdSourceModel adSourceModel;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (this.loadAdResourceDatas.containsKey(str)) {
                    adSourceModel = this.loadAdResourceDatas.get(str);
                } else {
                    adSourceModel = null;
                }
                if (adSourceModel == null || TextUtils.isEmpty(adSourceModel.getAppId())) {
                    return;
                }
                AMPSCacheController.getInstance().removeAdSourceCacheInfo(this.mSpaceId, str);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void show(Activity activity) {
        if (activity != null) {
            try {
                AMPSBaseAdapter aMPSBaseAdapter = this.mAMPSBaseAdapter;
                if (aMPSBaseAdapter != null) {
                    aMPSBaseAdapter.refreshAMPSAdAdapterListener(this);
                    this.mAMPSBaseAdapter.showAd(activity);
                    return;
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
        AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_SHOW_ERROR;
        callBackAdLoadFail(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg());
    }

    public void preLoad() {
    }
}
