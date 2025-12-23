package xyz.adscope.amps.report.model.request;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSReportRequestModel {
    private AdModel ad;
    private AppModel app;
    private DeviceModel device;
    private EventModel eventModel;
    private SdkModel sdk;
    private UserModel user;

    public AMPSReportRequestModel() {
    }

    public AMPSReportRequestModel(AMPSReportRequestModel aMPSReportRequestModel) {
        this.eventModel = aMPSReportRequestModel.getEventModel();
        this.app = aMPSReportRequestModel.getApp();
        this.device = aMPSReportRequestModel.getDevice();
        this.user = aMPSReportRequestModel.getUser();
        this.sdk = aMPSReportRequestModel.getSdk();
        this.ad = aMPSReportRequestModel.getAd();
    }

    public AdModel getAd() {
        return this.ad;
    }

    public AppModel getApp() {
        return this.app;
    }

    public DeviceModel getDevice() {
        return this.device;
    }

    public EventModel getEventModel() {
        return this.eventModel;
    }

    public SdkModel getSdk() {
        return this.sdk;
    }

    public UserModel getUser() {
        return this.user;
    }

    public void setAd(AdModel adModel) {
        this.ad = adModel;
    }

    public void setApp(AppModel appModel) {
        this.app = appModel;
    }

    public void setDevice(DeviceModel deviceModel) {
        this.device = deviceModel;
    }

    public void setEventModel(EventModel eventModel) {
        this.eventModel = eventModel;
    }

    public void setSdk(SdkModel sdkModel) {
        this.sdk = sdkModel;
    }

    public void setUser(UserModel userModel) {
        this.user = userModel;
    }

    public String toString() {
        return "{\"eventModel\":" + this.eventModel + ", \"app\":" + this.app + ", \"device\":" + this.device + ", \"user\":" + this.user + ", \"ad\":" + this.ad + ", \"sdk\":" + this.sdk + '}';
    }
}
