package xyz.adscope.amps.model.config.request;

import xyz.adscope.amps.model.AMPSBaseModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSConfigRequestModel extends AMPSBaseModel {
    private AppModel app;
    private DeviceModel device;
    private AMPSExtModel ext;
    private SdkModel sdk;
    private long time;
    private UserModel user;

    public AppModel getApp() {
        return this.app;
    }

    public DeviceModel getDevice() {
        return this.device;
    }

    public AMPSExtModel getExt() {
        return this.ext;
    }

    public SdkModel getSdk() {
        return this.sdk;
    }

    public Long getTime() {
        return Long.valueOf(this.time);
    }

    public UserModel getUser() {
        return this.user;
    }

    public void setApp(AppModel appModel) {
        this.app = appModel;
    }

    public void setDevice(DeviceModel deviceModel) {
        this.device = deviceModel;
    }

    public void setExt(AMPSExtModel aMPSExtModel) {
        this.ext = aMPSExtModel;
    }

    public void setSdk(SdkModel sdkModel) {
        this.sdk = sdkModel;
    }

    public void setUser(UserModel userModel) {
        this.user = userModel;
    }

    public String toString() {
        return "{\"device\":" + this.device + ", \"app\":" + this.app + ", \"user\":" + this.user + ", \"ext\":" + this.ext + ", \"time\":" + this.time + ", \"sdk\":" + this.sdk + "} ";
    }

    public void setTime(Long l6) {
        this.time = l6.longValue();
    }
}
