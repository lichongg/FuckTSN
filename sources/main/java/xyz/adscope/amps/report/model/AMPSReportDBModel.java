package xyz.adscope.amps.report.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSReportDBModel {
    public String eventCode = "";
    public String eventId = "";
    public long eventTime = 0;
    public String eventJsonStr = "";

    public String getEventCode() {
        return this.eventCode;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getEventJsonStr() {
        return this.eventJsonStr;
    }

    public long getEventTime() {
        return this.eventTime;
    }

    public void setEventCode(String str) {
        this.eventCode = str;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setEventJsonStr(String str) {
        this.eventJsonStr = str;
    }

    public void setEventTime(long j6) {
        this.eventTime = j6;
    }

    public String toString() {
        return "{\"eventCode\":\"" + this.eventCode + "\", \"eventId\":\"" + this.eventId + "\", \"eventTime\":" + this.eventTime + ", \"eventJsonStr\":\"" + this.eventJsonStr + "\"}";
    }
}
