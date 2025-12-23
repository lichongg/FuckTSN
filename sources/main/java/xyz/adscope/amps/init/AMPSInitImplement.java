package xyz.adscope.amps.init;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import xyz.adscope.amps.AMPSSDK;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.config.AMPSConfigManager;
import xyz.adscope.amps.config.AMPSPrivacyConfig;
import xyz.adscope.amps.config.inter.IConfigInfoCallback;
import xyz.adscope.amps.config.inter.IConfigInterface;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;
import xyz.adscope.amps.init.inter.IAMPSInitCallback;
import xyz.adscope.amps.init.inter.IAMPSInitInterface;
import xyz.adscope.amps.manager.AMPSAdSourceDataProvider;
import xyz.adscope.amps.manager.AMPSSDKManager;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.model.config.response.AMPSConfigResponseModel;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.model.config.response.BlackRuleModel;
import xyz.adscope.amps.plan.BetaPlanMediation;
import xyz.adscope.amps.report.AMPSEventReportCode;
import xyz.adscope.amps.report.AMPSReportLoader;
import xyz.adscope.amps.report.AMPSReportMediation;
import xyz.adscope.amps.tool.AMPSAdapterFactory;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.amps.tool.crash.AMPSCrashHandler;
import xyz.adscope.amps.tool.thread.AMPSThreadPool;
import xyz.adscope.amps.tool.util.AMPSIntentInterrupter;
import xyz.adscope.amps.tool.util.AMPSStringUtil;
import xyz.adscope.common.network.JsonConverter;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.KalleConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSInitImplement implements IAMPSInitInterface {
    private AMPSGlobalModel ampsGlobalModel;
    private Context context;
    private boolean isCallBackInitResult;
    private AMPSInitConfig mAMPSAdConfig;
    private AMPSPrivacyConfig mAMPSPrivacyConfig;
    private IConfigInterface iAdConfig = new AMPSConfigManager();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private AMPSInitUserAgent initUserAgent = new AMPSInitUserAgent();

    @Override // xyz.adscope.amps.init.inter.IAMPSInitInterface
    public boolean isInitSuccess() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initInterrupterBlackList() {
        AMPSConfigResponseModel configureResponseModel;
        BlackRuleModel blackRule;
        List<String> blackList;
        try {
            if (this.ampsGlobalModel != null && BetaPlanMediation.getInstance().isExecuteHapBetaPlan() && (configureResponseModel = this.ampsGlobalModel.getConfigureResponseModel()) != null && (blackRule = configureResponseModel.getBlackRule()) != null && (blackList = blackRule.getBlackList()) != null && !blackList.isEmpty()) {
                AMPSIntentInterrupter.getInstance().initInterrupter(blackList);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preInitAdSource(AMPSInitConfig aMPSInitConfig) {
        if (aMPSInitConfig == null || aMPSInitConfig.getAdapterNameList() == null || aMPSInitConfig.getAdapterNameList().size() < 1) {
            return;
        }
        List<String> adapterNameList = aMPSInitConfig.getAdapterNameList();
        for (int i6 = 0; i6 < adapterNameList.size(); i6++) {
            String str = adapterNameList.get(i6);
            AdSourceModel adSourceByAdapterName = AMPSAdSourceDataProvider.getInstance().getAdSourceByAdapterName(str);
            AMPSChannelInitMediation createAdapterInit = AMPSAdapterFactory.createAdapterInit(str);
            if (adSourceByAdapterName != null && createAdapterInit != null) {
                String appId = adSourceByAdapterName.getAppId();
                if (!TextUtils.isEmpty(appId)) {
                    AMPSInitAdapterConfig aMPSInitAdapterConfig = new AMPSInitAdapterConfig();
                    aMPSInitAdapterConfig.setAppId(appId);
                    createAdapterInit.initSDK(aMPSInitAdapterConfig, null);
                }
            }
        }
    }

    private void startInitCountTimer(final IAMPSInitCallback iAMPSInitCallback) {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: xyz.adscope.amps.init.AMPSInitImplement.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (iAMPSInitCallback == null || AMPSInitImplement.this.isCallBackInitResult) {
                        return;
                    }
                    AMPSInitImplement.this.isCallBackInitResult = true;
                    IAMPSInitCallback iAMPSInitCallback2 = iAMPSInitCallback;
                    AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_INIT_TIME_OUT;
                    iAMPSInitCallback2.failCallback(new AMPSError(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg()));
                    AMPSSDKManager.getInstance().setInitStatus(AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusFail);
                    AMPSSDKManager.getInstance().handleInitResultCallBack(0);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }, 10000L);
    }

    public AMPSPrivacyConfig getAMPSPrivacyConfig() {
        return this.mAMPSPrivacyConfig;
    }

    @Override // xyz.adscope.amps.init.inter.IAMPSInitInterface
    public AMPSGlobalModel getGlobalModel() {
        return this.ampsGlobalModel;
    }

    @Override // xyz.adscope.amps.init.inter.IAMPSInitInterface
    public void init(final Context context, AMPSInitConfig aMPSInitConfig, AMPSGlobalModel aMPSGlobalModel, final IAMPSInitCallback iAMPSInitCallback) {
        this.context = context;
        this.ampsGlobalModel = aMPSGlobalModel;
        if (aMPSInitConfig != null && !TextUtils.isEmpty(aMPSInitConfig.getAppId())) {
            this.ampsGlobalModel.setAppId(aMPSInitConfig.getAppId());
        }
        this.ampsGlobalModel.setStartId(AMPSStringUtil.createRequestId());
        this.ampsGlobalModel.setAmpsInitConfig(aMPSInitConfig);
        AMPSLogUtil.i(AMPSConstants.AMPS_LOG_TAG, " init execute appId:" + aMPSInitConfig.getAppId() + ", sdkVersion:" + AMPSSDK.getSdkVersion());
        startInitCountTimer(iAMPSInitCallback);
        syncStartService();
        AMPSThreadPool.getInitRequestPool().execute(new Runnable() { // from class: xyz.adscope.amps.init.AMPSInitImplement.1
            @Override // java.lang.Runnable
            public void run() {
                AMPSInitImplement.this.asyncUpdateInfo(context, iAMPSInitCallback);
            }
        });
    }

    public void setAMPSAdConfig(AMPSInitConfig aMPSInitConfig) {
        this.mAMPSAdConfig = aMPSInitConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asyncUpdateInfo(Context context, final IAMPSInitCallback iAMPSInitCallback) {
        asyncGetDb();
        this.iAdConfig.setContext(context);
        this.iAdConfig.initConfigureFile(this.ampsGlobalModel, new IConfigInfoCallback() { // from class: xyz.adscope.amps.init.AMPSInitImplement.2
            @Override // xyz.adscope.amps.config.inter.IConfigInfoCallback
            public void failCallBack(final AMPSError aMPSError) {
                long currentTimeMillis = System.currentTimeMillis() - AMPSSDKManager.initStartTime;
                AMPSReportLoader.getInstance().reportInitLog(AMPSEventReportCode.EVENT_INIT_FAIL_CODE.getCodeStr(), currentTimeMillis + "");
                AMPSSDKManager.initStartTime = 0L;
                AMPSReportLoader.getInstance().loadLogModelFromConfig();
                AMPSReportLoader.getInstance().loadLogsFromDatabase();
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "initialize failCallback");
                AMPSReportMediation.getInstance().initLogStrategy();
                AMPSReportLoader.getInstance().reportInitLog(AMPSEventReportCode.EVENT_CRASH_CODE.getCodeStr(), "");
                AMPSReportLoader.getInstance().reportInitLog(AMPSEventReportCode.EVENT_INIT_START_CODE.getCodeStr(), "0");
                if (iAMPSInitCallback != null) {
                    if (AMPSInitImplement.this.mHandler != null) {
                        AMPSInitImplement.this.isCallBackInitResult = true;
                        AMPSInitImplement.this.mHandler.post(new Runnable() { // from class: xyz.adscope.amps.init.AMPSInitImplement.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                IAMPSInitCallback iAMPSInitCallback2 = iAMPSInitCallback;
                                if (iAMPSInitCallback2 != null) {
                                    iAMPSInitCallback2.failCallback(aMPSError);
                                }
                                AMPSSDKManager.getInstance().handleInitResultCallBack(0);
                            }
                        });
                    }
                    if (AMPSInitImplement.this.ampsGlobalModel != null) {
                        AMPSInitImplement.this.ampsGlobalModel.setErrorCode(aMPSError.getCode());
                        AMPSInitImplement.this.ampsGlobalModel.setErrorMsg(aMPSError.getMessage());
                    }
                }
                AMPSSDKManager.getInstance().setInitStatus(AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusFail);
            }

            @Override // xyz.adscope.amps.config.inter.IConfigInfoCallback
            public void successCallBack() {
                long currentTimeMillis = System.currentTimeMillis() - AMPSSDKManager.initStartTime;
                AMPSSDKManager.getInstance().setInitStatus(AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusSuccess);
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "initialize success " + (System.currentTimeMillis() - AMPSSDKManager.initStartTime));
                AMPSSDKManager.initStartTime = 0L;
                AMPSReportLoader.getInstance().reportInitLog(AMPSEventReportCode.EVENT_INIT_SUCCESS_CODE.getCodeStr(), currentTimeMillis + "");
                AMPSReportLoader.getInstance().loadLogModelFromConfig();
                AMPSReportLoader.getInstance().loadLogsFromDatabase();
                if (AMPSInitImplement.this.mHandler != null) {
                    AMPSInitImplement.this.isCallBackInitResult = true;
                    AMPSInitImplement.this.mHandler.post(new Runnable() { // from class: xyz.adscope.amps.init.AMPSInitImplement.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IAMPSInitCallback iAMPSInitCallback2 = iAMPSInitCallback;
                            if (iAMPSInitCallback2 != null) {
                                iAMPSInitCallback2.successCallback();
                            }
                            AMPSSDKManager.getInstance().handleInitResultCallBack(1);
                        }
                    });
                }
                AMPSReportMediation.getInstance().initLogStrategy();
                AMPSReportLoader.getInstance().reportInitLog(AMPSEventReportCode.EVENT_INIT_START_CODE.getCodeStr(), "0");
                AMPSReportLoader.getInstance().reportInitLog(AMPSEventReportCode.EVENT_CRASH_CODE.getCodeStr(), "0");
                AMPSInitImplement aMPSInitImplement = AMPSInitImplement.this;
                aMPSInitImplement.preInitAdSource(aMPSInitImplement.ampsGlobalModel.getAmpsInitConfig());
                AMPSInitImplement.this.updateNetWorkConfig();
                AMPSInitImplement.this.initInterrupterBlackList();
            }
        });
    }

    private void initNetWork() {
        Kalle.setConfig(KalleConfig.newBuilder().converter(new JsonConverter(this.context)).build());
        if (Kalle.getConfig() != null) {
            Kalle.getConfig().getHeaders().add("Accept-Encrypt", "101,1001");
        }
    }

    private void syncStartService() {
        initNetWork();
        AMPSCrashHandler.getInstance().init(AMPSSDKManager.getInstance().getContext());
        this.initUserAgent.getUserAgent(AMPSSDKManager.getInstance().getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNetWorkConfig() {
        AMPSGlobalModel aMPSGlobalModel;
        if (Kalle.getConfig() != null && (aMPSGlobalModel = this.ampsGlobalModel) != null && aMPSGlobalModel.getConfigureResponseModel() != null && this.ampsGlobalModel.getConfigureResponseModel().getConfig() != null) {
            Kalle.getConfig().getHeaders().remove("Accept-Encrypt");
            Kalle.getConfig().getHeaders().add("Accept-Encrypt", this.ampsGlobalModel.getAcceptEncrypt());
        }
    }

    private void asyncGetDb() {
    }
}
