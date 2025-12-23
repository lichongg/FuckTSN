package xyz.adscope.amps.model.material;

import xyz.adscope.amps.report.AMPSReportConstants;
import xyz.adscope.common.v2.model.IBaseToJsonModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSUploadMaterial extends IBaseToJsonModel {

    @JsonParseNode(key = "adType")
    private String adType;

    @JsonParseNode(key = "appId")
    private String appId;

    @JsonParseNode(key = "eventId")
    private String eventId;

    @JsonParseNode(key = AMPSReportConstants.EVENT_TIME_KEY)
    private String eventTime;

    @JsonParseNode(key = "materialData")
    private String materialData;

    @JsonParseNode(key = "materialMD5")
    private String materialMD5;

    @JsonParseNode(key = "said")
    private String said;

    @JsonParseNode(key = "seatAppId")
    private String seatAppId;

    @JsonParseNode(key = "seatId")
    private String seatId;

    @JsonParseNode(key = "seatSpaceId")
    private String seatSpaceId;

    @JsonParseNode(key = "sessionId")
    private String sessionId;

    @JsonParseNode(key = "spaceId")
    private String spaceId;

    @JsonParseNode(key = "startId")
    private String startId;

    public String getAdType() {
        return this.adType;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getEventTime() {
        return this.eventTime;
    }

    public String getMaterialData() {
        return this.materialData;
    }

    public String getMaterialMD5() {
        return this.materialMD5;
    }

    public String getSaid() {
        return this.said;
    }

    public String getSeatAppId() {
        return this.seatAppId;
    }

    public String getSeatId() {
        return this.seatId;
    }

    public String getSeatSpaceId() {
        return this.seatSpaceId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public String getStartId() {
        return this.startId;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setEventTime(String str) {
        this.eventTime = str;
    }

    public void setMaterialData(String str) {
        this.materialData = str;
    }

    public void setMaterialMD5(String str) {
        this.materialMD5 = str;
    }

    public void setSaid(String str) {
        this.said = str;
    }

    public void setSeatAppId(String str) {
        this.seatAppId = str;
    }

    public void setSeatId(String str) {
        this.seatId = str;
    }

    public void setSeatSpaceId(String str) {
        this.seatSpaceId = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setStartId(String str) {
        this.startId = str;
    }
}
