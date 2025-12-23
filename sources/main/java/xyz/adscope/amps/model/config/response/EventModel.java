package xyz.adscope.amps.model.config.response;

import java.util.List;
import xyz.adscope.common.json.util.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class EventModel {
    private List<EventLevelModel> eventLevel;
    private String version = "";
    private String customData = "";
    private String ext = "";

    public String getCustomData() {
        return this.customData;
    }

    public List<EventLevelModel> getEventLevel() {
        return this.eventLevel;
    }

    public String getExt() {
        return this.ext;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setEventLevel(List<EventLevelModel> list) {
        this.eventLevel = list;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "{\"eventLevel\":" + this.eventLevel + ", \"version\":\"" + this.version + "\", \"customData\":\"" + JsonUtil.addEscapeChar(this.customData) + "\", \"ext\":\"" + this.ext + "\"}";
    }
}
