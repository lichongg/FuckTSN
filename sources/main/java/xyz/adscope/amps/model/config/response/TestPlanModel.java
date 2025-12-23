package xyz.adscope.amps.model.config.response;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class TestPlanModel {
    private String duration;
    private String endTime;
    private String planId;
    private String random;
    private String startTime;
    private String version;

    public String getDuration() {
        return this.duration;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getPlanId() {
        return this.planId;
    }

    public String getRandom() {
        return this.random;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getVersion() {
        return this.version;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setPlanId(String str) {
        this.planId = str;
    }

    public void setRandom(String str) {
        this.random = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "{\"planId\":\"" + this.planId + "\", \"duration\":\"" + this.duration + "\", \"random\":\"" + this.random + "\", \"startTime\":\"" + this.startTime + "\", \"endTime\":\"" + this.endTime + "\", \"version\":\"" + this.version + "\"}";
    }
}
