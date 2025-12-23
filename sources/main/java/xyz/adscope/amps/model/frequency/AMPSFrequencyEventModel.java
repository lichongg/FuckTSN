package xyz.adscope.amps.model.frequency;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSFrequencyEventModel {
    private String adSourceSpaceId;
    private String eventCode;
    private String eventTime;
    private String mediationSpaceId;

    public AMPSFrequencyEventModel() {
    }

    public AMPSFrequencyEventModel(String str, String str2) {
        this.adSourceSpaceId = str;
        this.eventCode = str2;
    }

    public String getAdSourceSpaceId() {
        return this.adSourceSpaceId;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public String getEventTime() {
        return this.eventTime;
    }

    public String getMediationSpaceId() {
        return this.mediationSpaceId;
    }

    public void setAdSourceSpaceId(String str) {
        this.adSourceSpaceId = str;
    }

    public void setEventCode(String str) {
        this.eventCode = str;
    }

    public void setEventTime(String str) {
        this.eventTime = str;
    }

    public void setMediationSpaceId(String str) {
        this.mediationSpaceId = str;
    }
}
