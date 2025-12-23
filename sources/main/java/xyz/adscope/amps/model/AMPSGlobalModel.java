package xyz.adscope.amps.model;

import android.text.TextUtils;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.model.config.response.AMPSConfigResponseModel;
import xyz.adscope.amps.tool.util.AMPSStringUtil;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSGlobalModel extends AMPSBaseModel {
    private AMPSInitConfig ampsInitConfig;
    private AMPSConfigResponseModel configureResponseModel;
    private long initStartTime;
    private AMPSEnum.AMPSSDKInitStatus initStatus;
    private long sdkInitEndTime;
    private String appId = "";
    private String errorCode = "";
    private String errorMsg = "";
    private String acceptEncrypt = "101,1001";
    private String startId = "";
    private String sessionId = "";

    public String getAcceptEncrypt() {
        AMPSConfigResponseModel aMPSConfigResponseModel = this.configureResponseModel;
        return (aMPSConfigResponseModel == null || aMPSConfigResponseModel.getConfig() == null || TextUtils.isEmpty(this.configureResponseModel.getConfig().getAcceptEncrypt())) ? this.acceptEncrypt : this.configureResponseModel.getConfig().getAcceptEncrypt();
    }

    public AMPSInitConfig getAmpsInitConfig() {
        return this.ampsInitConfig;
    }

    public String getAppId() {
        return this.appId;
    }

    public AMPSConfigResponseModel getConfigureResponseModel() {
        return this.configureResponseModel;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public long getInitStartTime() {
        return this.initStartTime;
    }

    public AMPSEnum.AMPSSDKInitStatus getInitStatus() {
        return this.initStatus;
    }

    public String getRequestId() {
        return "";
    }

    public long getSdkInitEndTime() {
        return this.sdkInitEndTime;
    }

    public String getStartId() {
        return this.startId;
    }

    public void setAmpsInitConfig(AMPSInitConfig aMPSInitConfig) {
        this.ampsInitConfig = aMPSInitConfig;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setConfigureResponseModel(AMPSConfigResponseModel aMPSConfigResponseModel) {
        this.configureResponseModel = aMPSConfigResponseModel;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setInitStartTime(long j6) {
        this.initStartTime = j6;
    }

    public void setInitStatus(AMPSEnum.AMPSSDKInitStatus aMPSSDKInitStatus) {
        this.initStatus = aMPSSDKInitStatus;
    }

    public void setSdkInitEndTime(long j6) {
        this.sdkInitEndTime = j6;
    }

    public void setStartId(String str) {
        this.startId = str;
    }

    public String getEventId() {
        return AMPSStringUtil.createRequestId();
    }

    public long getEventTime() {
        return DeviceInfoUtil.getTimeStamp();
    }

    public long getLogTime() {
        return DeviceInfoUtil.getTimeStamp();
    }
}
