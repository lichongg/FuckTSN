package xyz.adscope.amps.manager;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.amps.BuildConfig;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.config.AMPSPrivacyConfig;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.init.AMPSInitImplement;
import xyz.adscope.amps.init.inter.IAMPSInitCallback;
import xyz.adscope.amps.init.inter.IAMPSInitInterface;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.report.AMPSEventReportCode;
import xyz.adscope.amps.report.AMPSReportLoader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSSDKManager {
    public static long initStartTime;
    private static AMPSSDKManager instance;
    private AMPSGlobalModel ampsGlobalModel;
    private AMPSInitConfig mAMPSAdConfig;
    private AMPSPrivacyConfig mAMPSPrivacyConfig;
    private String mAppId;
    private Context mContext;
    private String userAgent;
    private AMPSEnum.AMPSSDKInitStatus initStatus = AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusNormal;
    private List<IAMPSInitCallback> mInitCallBackList = new ArrayList();
    private IAMPSInitInterface iampsInitInterface = new AMPSInitImplement();

    public static synchronized AMPSSDKManager getInstance() {
        AMPSSDKManager aMPSSDKManager;
        synchronized (AMPSSDKManager.class) {
            try {
                if (instance == null) {
                    synchronized (AMPSSDKManager.class) {
                        instance = new AMPSSDKManager();
                    }
                }
                aMPSSDKManager = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aMPSSDKManager;
    }

    public AMPSInitConfig getAMPSAdConfig() {
        return this.mAMPSAdConfig;
    }

    public AMPSPrivacyConfig getAMPSPrivacyConfig() {
        return this.mAMPSPrivacyConfig;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public Context getContext() {
        return this.mContext;
    }

    public IAMPSInitInterface getIAMPSInitInterface() {
        return this.iampsInitInterface;
    }

    public String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void handleInitResultCallBack(int i6) {
        List<IAMPSInitCallback> list;
        if (this.mInitCallBackList.size() < 1) {
            return;
        }
        if (i6 == 1) {
            List<IAMPSInitCallback> list2 = this.mInitCallBackList;
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            Iterator<IAMPSInitCallback> it = this.mInitCallBackList.iterator();
            while (it.hasNext()) {
                IAMPSInitCallback next = it.next();
                if (next != null) {
                    next.successCallback();
                }
                it.remove();
            }
            return;
        }
        if (i6 != 0 || (list = this.mInitCallBackList) == null || list.size() <= 0) {
            return;
        }
        Iterator<IAMPSInitCallback> it2 = this.mInitCallBackList.iterator();
        while (it2.hasNext()) {
            IAMPSInitCallback next2 = it2.next();
            if (next2 != null) {
                next2.failCallback(null);
            }
            it2.remove();
        }
    }

    public AMPSEnum.AMPSSDKInitStatus sdkInitStatus() {
        return this.initStatus;
    }

    public void setAMPSAdConfig(AMPSInitConfig aMPSInitConfig) {
        this.mAMPSAdConfig = aMPSInitConfig;
    }

    public void setAMPSPrivacyConfig(AMPSPrivacyConfig aMPSPrivacyConfig) {
        this.mAMPSPrivacyConfig = aMPSPrivacyConfig;
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setInitResultCallBack(IAMPSInitCallback iAMPSInitCallback) {
        AMPSEnum.AMPSSDKInitStatus aMPSSDKInitStatus = this.initStatus;
        if (aMPSSDKInitStatus == AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusSuccess) {
            iAMPSInitCallback.successCallback();
        } else if (aMPSSDKInitStatus == AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusFail) {
            iAMPSInitCallback.failCallback(null);
        } else {
            this.mInitCallBackList.add(iAMPSInitCallback);
        }
    }

    public void setInitStatus(AMPSEnum.AMPSSDKInitStatus aMPSSDKInitStatus) {
        this.initStatus = aMPSSDKInitStatus;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    private AMPSSDKManager() {
    }

    public void initialize(Context context, AMPSInitConfig aMPSInitConfig, IAMPSInitCallback iAMPSInitCallback) {
        try {
            if (sdkInitStatus() == AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusSuccess) {
                iAMPSInitCallback.successCallback();
                return;
            }
            this.ampsGlobalModel = new AMPSGlobalModel();
            setContext(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            initStartTime = System.currentTimeMillis();
            this.ampsGlobalModel.setInitStartTime(System.currentTimeMillis());
            if (aMPSInitConfig == null) {
                StringBuilder sb = new StringBuilder();
                AMPSEnum.AMPSSDKInitStatus aMPSSDKInitStatus = AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusFail;
                sb.append(aMPSSDKInitStatus.getCode());
                sb.append("");
                iAMPSInitCallback.failCallback(new AMPSError(sb.toString(), aMPSSDKInitStatus.getMsg()));
                AMPSGlobalModel aMPSGlobalModel = this.ampsGlobalModel;
                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_INIT_FAIL_CONFIG_NULL;
                aMPSGlobalModel.setErrorCode(reportLogErrorEnum.getErrorCode());
                this.ampsGlobalModel.setErrorMsg(reportLogErrorEnum.getErrorMsg());
                long currentTimeMillis = System.currentTimeMillis() - initStartTime;
                AMPSReportLoader.getInstance().reportInitLog(AMPSEventReportCode.EVENT_INIT_FAIL_CODE.getCodeStr(), currentTimeMillis + "");
                this.initStatus = aMPSSDKInitStatus;
                initStartTime = 0L;
                return;
            }
            String appId = aMPSInitConfig.getAppId();
            if (TextUtils.isEmpty(appId)) {
                StringBuilder sb2 = new StringBuilder();
                AMPSEnum.AMPSSDKInitStatus aMPSSDKInitStatus2 = AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusFail;
                sb2.append(aMPSSDKInitStatus2.getCode());
                sb2.append("");
                iAMPSInitCallback.failCallback(new AMPSError(sb2.toString(), aMPSSDKInitStatus2.getMsg()));
                AMPSGlobalModel aMPSGlobalModel2 = this.ampsGlobalModel;
                AMPSErrorCode.ReportLogErrorEnum reportLogErrorEnum2 = AMPSErrorCode.ReportLogErrorEnum.REPORT_LOG_INIT_FAIL_APPID_NULL;
                aMPSGlobalModel2.setErrorCode(reportLogErrorEnum2.getErrorCode());
                this.ampsGlobalModel.setErrorMsg(reportLogErrorEnum2.getErrorMsg());
                long currentTimeMillis2 = System.currentTimeMillis() - initStartTime;
                AMPSReportLoader.getInstance().reportInitLog(AMPSEventReportCode.EVENT_INIT_FAIL_CODE.getCodeStr(), currentTimeMillis2 + "");
                this.initStatus = aMPSSDKInitStatus2;
                initStartTime = 0L;
                return;
            }
            this.initStatus = AMPSEnum.AMPSSDKInitStatus.AMPSAdSDKInitStatusLoading;
            this.mAMPSAdConfig = aMPSInitConfig;
            setAppId(appId);
            setAMPSAdConfig(aMPSInitConfig);
            this.iampsInitInterface.init(StubApp.getOrigApplicationContext(context.getApplicationContext()), aMPSInitConfig, this.ampsGlobalModel, iAMPSInitCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
