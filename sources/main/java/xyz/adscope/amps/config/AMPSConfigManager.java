package xyz.adscope.amps.config;

import android.content.Context;
import android.text.TextUtils;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.config.inter.IConfigInfoCallback;
import xyz.adscope.amps.config.inter.IConfigInterface;
import xyz.adscope.amps.config.inter.IConfigUpdateCallBack;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.model.config.request.AMPSConfigRequestModel;
import xyz.adscope.amps.model.config.request.AMPSExtModel;
import xyz.adscope.amps.model.config.response.AMPSConfigResponseModel;
import xyz.adscope.amps.report.AMPSReportMediation;
import xyz.adscope.amps.tool.AMPSSecurityUtil;
import xyz.adscope.amps.tool.crash.AMPSCrashRouter;
import xyz.adscope.amps.tool.crash.inter.ICrashRouter;
import xyz.adscope.amps.tool.persistent.sp.AMPSSpUtil;
import xyz.adscope.amps.tool.request.AMPSHttpRequest;
import xyz.adscope.amps.tool.request.inter.IHttpRequest;
import xyz.adscope.amps.tool.request.inter.IHttpResponseCallback;
import xyz.adscope.amps.tool.task.AMPSTimerOutTask;
import xyz.adscope.amps.tool.task.scheduler.AMPSConfigSchedulerTask;
import xyz.adscope.common.info.DeviceInfo;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.json.JSONParse;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.Base64Util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSConfigManager implements IConfigInterface {
    private AMPSConfigSchedulerTask adConfigSchedulerTask;
    private AMPSGlobalModel ampsGlobalModel;
    private Context context;
    private AMPSConfigResponseInfo responseInfo;
    private ICrashRouter iCrashRouter = new AMPSCrashRouter();
    private IHttpRequest iHttpRequest = new AMPSHttpRequest();
    private int configUpdateStatus = 0;
    private int mIntervalTime = PredefinedCaptureConfigurations.f35634a;
    private CopyOnWriteArrayList<String> mCfgMD5List = new CopyOnWriteArrayList<>();
    private AMPSTimerOutTask ampsTimerOutTask = new AMPSTimerOutTask();

    private synchronized boolean isConfigCanUpdate() {
        int i6;
        try {
            AMPSConfigResponseInfo aMPSConfigResponseInfo = this.responseInfo;
            if (aMPSConfigResponseInfo == null) {
                return false;
            }
            long lastUpdateTime = aMPSConfigResponseInfo.getLastUpdateTime();
            if (System.currentTimeMillis() - lastUpdateTime < this.mIntervalTime) {
                return false;
            }
            CopyOnWriteArrayList<String> copyOnWriteArrayList = this.mCfgMD5List;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 1) {
                i6 = 0;
            } else {
                String str = this.mCfgMD5List.get(0);
                i6 = 0;
                for (int i7 = 1; i7 < this.mCfgMD5List.size() && str.equals(this.mCfgMD5List.get(i7)); i7++) {
                    i6++;
                }
            }
            return System.currentTimeMillis() - lastUpdateTime >= ((long) (this.mIntervalTime * (i6 < 7 ? 1 << i6 : 96)));
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putCfgMD5ToList() {
        try {
            String configVersion = this.responseInfo.getConfigVersion();
            if (!TextUtils.isEmpty(configVersion)) {
                this.mCfgMD5List.add(0, configVersion);
            }
            CopyOnWriteArrayList<String> copyOnWriteArrayList = this.mCfgMD5List;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 8) {
                this.mCfgMD5List.remove(this.mCfgMD5List.size() - 1);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        this.configUpdateStatus = 0;
    }

    @Override // xyz.adscope.amps.config.inter.IConfigInterface
    public void requestConfigureFile(final AMPSGlobalModel aMPSGlobalModel, final IConfigInfoCallback iConfigInfoCallback) {
        String decode;
        this.configUpdateStatus = 1;
        AMPSConfigResponseInfo aMPSConfigResponseInfo = this.responseInfo;
        if (aMPSConfigResponseInfo == null || aMPSConfigResponseInfo.getConfigureResponseModel() == null || this.responseInfo.getConfigureResponseModel().getConfig() == null || TextUtils.isEmpty(this.responseInfo.getConfigureResponseModel().getConfig().getConfigURL())) {
            decode = Base64Util.decode(isUseHttps() ? AMPSConstants.AMPS_CONFIG_URL_TRANSFER_PROTOCOL : AMPSConstants.AMPS_CONFIG_URL);
            if (TextUtils.isEmpty(decode)) {
                this.configUpdateStatus = 0;
                return;
            }
        } else {
            decode = this.responseInfo.getConfigureResponseModel().getConfig().getConfigURL();
        }
        AMPSConfigRequestInfo aMPSConfigRequestInfo = AMPSConfigRequestInfo.getInstance(this.context);
        if (!aMPSConfigRequestInfo.isInit) {
            aMPSConfigRequestInfo.init(aMPSGlobalModel.getAmpsInitConfig());
        }
        this.iHttpRequest.doRequestWithJson(decode, new JSONParse().toJson(aMPSConfigRequestInfo.getConfigureRequestModel()), new IHttpResponseCallback<String>() { // from class: xyz.adscope.amps.config.AMPSConfigManager.2
            @Override // xyz.adscope.amps.tool.request.inter.IHttpResponseCallback
            public void failCallback(String str, int i6) {
                AMPSConfigManager.this.configUpdateStatus = 0;
                AMPSConfigManager.this.failResultCallback(iConfigInfoCallback, str);
                AMPSGlobalModel aMPSGlobalModel2 = aMPSGlobalModel;
                AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_CONFIG_REQUEST_ERROR;
                aMPSGlobalModel2.setErrorCode(aSMPLogicErrorEnum.getErrorCode());
                aMPSGlobalModel.setErrorMsg(aSMPLogicErrorEnum.getErrorMsg());
            }

            @Override // xyz.adscope.amps.tool.request.inter.IHttpResponseCallback
            public void successCallback(String str) {
                AMPSConfigManager.this.configUpdateStatus = 0;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("code") == 200) {
                        String optString = jSONObject.optString("data");
                        AMPSGlobalModel aMPSGlobalModel2 = aMPSGlobalModel;
                        String processUnCompressAndDecrypt = AMPSSecurityUtil.processUnCompressAndDecrypt(optString, aMPSGlobalModel2 != null ? aMPSGlobalModel2.getAcceptEncrypt() : "101,1001");
                        if (TextUtils.isEmpty(processUnCompressAndDecrypt) || processUnCompressAndDecrypt.equals("null") || processUnCompressAndDecrypt.equals("{}")) {
                            AMPSConfigManager.this.failResultCallback(iConfigInfoCallback, "error");
                            AMPSGlobalModel aMPSGlobalModel3 = aMPSGlobalModel;
                            AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_CONFIG_RESPONSE_ERROR;
                            aMPSGlobalModel3.setErrorCode(aSMPLogicErrorEnum.getErrorCode());
                            aMPSGlobalModel.setErrorMsg(aSMPLogicErrorEnum.getErrorMsg());
                            return;
                        }
                        LogUtil.i(AMPSConstants.AMPS_LOG_TAG, "AdConfig successCallback ");
                        AMPSConfigManager.this.updateConfigureFile(aMPSGlobalModel, processUnCompressAndDecrypt);
                        IConfigInfoCallback iConfigInfoCallback2 = iConfigInfoCallback;
                        if (iConfigInfoCallback2 != null) {
                            iConfigInfoCallback2.successCallBack();
                            AMPSConfigManager.this.ampsTimerOutTask.setIsExecuteConfig(true);
                            AMPSConfigManager.this.ampsTimerOutTask.cancelTimerTask();
                        }
                    }
                } catch (Exception e6) {
                    AMPSConfigManager.this.failResultCallback(iConfigInfoCallback, e6.toString());
                    AMPSGlobalModel aMPSGlobalModel4 = aMPSGlobalModel;
                    AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum2 = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_CONFIG_PARSE_ERROR;
                    aMPSGlobalModel4.setErrorCode(aSMPLogicErrorEnum2.getErrorCode());
                    aMPSGlobalModel.setErrorMsg(aSMPLogicErrorEnum2.getErrorMsg());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failResultCallback(IConfigInfoCallback iConfigInfoCallback, String str) {
        if (iConfigInfoCallback != null) {
            AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_INIT_FAIL;
            iConfigInfoCallback.failCallBack(new AMPSError(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg()));
            this.ampsTimerOutTask.setIsExecuteConfig(true);
            this.ampsTimerOutTask.cancelTimerTask();
        }
        LogUtil.i(AMPSConstants.AMPS_LOG_TAG, "e : " + str);
    }

    private boolean isUseHttps() {
        AMPSInitConfig ampsInitConfig;
        AMPSGlobalModel aMPSGlobalModel = this.ampsGlobalModel;
        if (aMPSGlobalModel == null || (ampsInitConfig = aMPSGlobalModel.getAmpsInitConfig()) == null) {
            return false;
        }
        return ampsInitConfig.isUseHttps();
    }

    @Override // xyz.adscope.amps.config.inter.IConfigInterface
    public boolean checkConfig() {
        long j6;
        long j7;
        AMPSConfigResponseModel configureResponseModel = this.responseInfo.getConfigureResponseModel();
        if (configureResponseModel == null) {
            LogUtil.i(AMPSConstants.AMPS_LOG_TAG, "first launch and heartConfig is null return true!");
            return false;
        }
        long timeStamp = DeviceInfoUtil.getTimeStamp();
        long lastUpdateTime = configureResponseModel.getLastUpdateTime();
        if (configureResponseModel.getConfig() != null) {
            j6 = configureResponseModel.getConfig().getMaxExpireTime();
            j7 = configureResponseModel.getConfig().getExpireTime();
        } else {
            j6 = 0;
            j7 = 0;
        }
        if (timeStamp <= lastUpdateTime || timeStamp - lastUpdateTime <= j6) {
            return timeStamp > lastUpdateTime && timeStamp - lastUpdateTime > j7;
        }
        return true;
    }

    @Override // xyz.adscope.amps.config.inter.IConfigInterface
    public void initConfigureFile(AMPSGlobalModel aMPSGlobalModel, IConfigInfoCallback iConfigInfoCallback) {
        this.ampsGlobalModel = aMPSGlobalModel;
        LogUtil.i(AMPSConstants.AMPS_LOG_TAG, "initConfigureFile() execute");
        if (this.responseInfo == null) {
            this.responseInfo = AMPSConfigResponseInfo.getInstance();
        }
        if (!this.responseInfo.isInit()) {
            this.responseInfo.init(isUseHttps());
        }
        if (aMPSGlobalModel != null) {
            AMPSInitConfig ampsInitConfig = aMPSGlobalModel.getAmpsInitConfig();
            if (ampsInitConfig == null) {
                DeviceInfoUtil.initOaid(this.context);
            } else if (ampsInitConfig.isPersonalRecommend()) {
                DeviceInfoUtil.initOaid(this.context);
            }
        }
        if (this.iCrashRouter.lastLaunchCrashedBecauseOfSDK()) {
            requestConfigureFile(aMPSGlobalModel, iConfigInfoCallback);
        } else {
            syncLocalOrCacheConfig(aMPSGlobalModel, iConfigInfoCallback);
            schedulerUpdateConfigureFile();
        }
        AMPSReportMediation.getInstance().registerAnalyseUpdate(new IConfigUpdateCallBack() { // from class: xyz.adscope.amps.config.AMPSConfigManager.1
            @Override // xyz.adscope.amps.config.inter.IConfigUpdateCallBack
            public void onUpdate() {
                AMPSConfigManager.this.requestConfigureFile();
            }
        });
    }

    @Override // xyz.adscope.amps.config.inter.IConfigInterface
    public void schedulerUpdateConfigureFile() {
        if (this.adConfigSchedulerTask == null) {
            AMPSConfigSchedulerTask aMPSConfigSchedulerTask = new AMPSConfigSchedulerTask(this);
            this.adConfigSchedulerTask = aMPSConfigSchedulerTask;
            aMPSConfigSchedulerTask.setAdScopeGlobalModel(this.ampsGlobalModel);
        }
        this.adConfigSchedulerTask.startSchedulerTask();
    }

    @Override // xyz.adscope.amps.config.inter.IConfigInterface
    public void setContext(Context context) {
        this.context = context;
    }

    @Override // xyz.adscope.amps.config.inter.IConfigInterface
    public void updateConfigureFile(AMPSGlobalModel aMPSGlobalModel, String str) {
        this.responseInfo.parseResponse(str);
        AMPSSpUtil.put(AMPSConstants.AMPS_CRASH_REASON_KEY, Boolean.FALSE);
        aMPSGlobalModel.setConfigureResponseModel(this.responseInfo.getConfigureResponseModel());
        AMPSReportMediation.getInstance().initLogStrategy();
        schedulerUpdateConfigureFile();
    }

    private void syncLocalOrCacheConfig(AMPSGlobalModel aMPSGlobalModel, IConfigInfoCallback iConfigInfoCallback) {
        if (checkConfig()) {
            requestConfigureFile(aMPSGlobalModel, iConfigInfoCallback);
            return;
        }
        AMPSConfigResponseModel configureResponseModel = this.responseInfo.getConfigureResponseModel();
        aMPSGlobalModel.setConfigureResponseModel(configureResponseModel);
        aMPSGlobalModel.setSdkInitEndTime(DeviceInfo.getInstance(this.context).getTimeStamp());
        if (configureResponseModel != null) {
            if (iConfigInfoCallback != null) {
                iConfigInfoCallback.successCallBack();
                this.ampsTimerOutTask.cancelTimerTask();
                return;
            }
            return;
        }
        if (iConfigInfoCallback != null) {
            AMPSErrorCode.ASMPLogicErrorEnum aSMPLogicErrorEnum = AMPSErrorCode.ASMPLogicErrorEnum.PLATFORM_ERROR_INIT_FAIL;
            iConfigInfoCallback.failCallBack(new AMPSError(aSMPLogicErrorEnum.getErrorCode(), aSMPLogicErrorEnum.getErrorMsg()));
            this.ampsTimerOutTask.cancelTimerTask();
        }
    }

    public void requestConfigureFile() {
        String decode;
        try {
            if (this.configUpdateStatus != 0) {
                return;
            }
            this.configUpdateStatus = 1;
            if (!isConfigCanUpdate()) {
                this.configUpdateStatus = 0;
                return;
            }
            AMPSConfigResponseInfo aMPSConfigResponseInfo = this.responseInfo;
            if (aMPSConfigResponseInfo != null && aMPSConfigResponseInfo.getConfigureResponseModel() != null && this.responseInfo.getConfigureResponseModel().getConfig() != null && !TextUtils.isEmpty(this.responseInfo.getConfigureResponseModel().getConfig().getConfigURL())) {
                decode = this.responseInfo.getConfigureResponseModel().getConfig().getConfigURL();
            } else {
                decode = Base64Util.decode(isUseHttps() ? AMPSConstants.AMPS_CONFIG_URL_TRANSFER_PROTOCOL : AMPSConstants.AMPS_CONFIG_URL);
                if (TextUtils.isEmpty(decode)) {
                    return;
                }
            }
            AMPSConfigRequestInfo aMPSConfigRequestInfo = AMPSConfigRequestInfo.getInstance(this.context);
            if (!aMPSConfigRequestInfo.isInit) {
                aMPSConfigRequestInfo.init(this.ampsGlobalModel.getAmpsInitConfig());
            }
            AMPSConfigRequestModel configureRequestModel = aMPSConfigRequestInfo.getConfigureRequestModel();
            AMPSExtModel aMPSExtModel = new AMPSExtModel();
            aMPSExtModel.setIsLogReq(1);
            configureRequestModel.setExt(aMPSExtModel);
            this.iHttpRequest.doRequestWithJson(decode, new JSONParse().toJson(configureRequestModel), new IHttpResponseCallback<String>() { // from class: xyz.adscope.amps.config.AMPSConfigManager.3
                @Override // xyz.adscope.amps.tool.request.inter.IHttpResponseCallback
                public void failCallback(String str, int i6) {
                    AMPSConfigManager.this.putCfgMD5ToList();
                }

                @Override // xyz.adscope.amps.tool.request.inter.IHttpResponseCallback
                public void successCallback(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.optInt("code") == 200) {
                            String processUnCompressAndDecrypt = AMPSSecurityUtil.processUnCompressAndDecrypt(jSONObject.optString("data"), AMPSConfigManager.this.ampsGlobalModel != null ? AMPSConfigManager.this.ampsGlobalModel.getAcceptEncrypt() : "101,1001");
                            if (!TextUtils.isEmpty(processUnCompressAndDecrypt) && !processUnCompressAndDecrypt.equals("null") && !processUnCompressAndDecrypt.equals("{}")) {
                                AMPSConfigManager aMPSConfigManager = AMPSConfigManager.this;
                                aMPSConfigManager.updateConfigureFile(aMPSConfigManager.ampsGlobalModel, processUnCompressAndDecrypt);
                            }
                            AMPSConfigManager.this.putCfgMD5ToList();
                        }
                    } catch (Exception unused) {
                        AMPSConfigManager.this.putCfgMD5ToList();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            this.configUpdateStatus = 0;
        }
    }
}
