package xyz.adscope.amps.model.config.response;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class LogStrategyModel {
    private String acceptEncrypt;
    private LogCrashModel crash;
    private String customData;
    private String customId;
    private List<LogEventModel> event;
    private String version;

    public String getAcceptEncrypt() {
        return this.acceptEncrypt;
    }

    public LogCrashModel getCrash() {
        return this.crash;
    }

    public String getCustomData() {
        return this.customData;
    }

    public String getCustomId() {
        return this.customId;
    }

    public List<LogEventModel> getEvent() {
        return this.event;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAcceptEncrypt(String str) {
        this.acceptEncrypt = str;
    }

    public void setCrash(LogCrashModel logCrashModel) {
        this.crash = logCrashModel;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setCustomId(String str) {
        this.customId = str;
    }

    public void setEvent(List<LogEventModel> list) {
        this.event = list;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "{\"acceptEncrypt\":\"" + this.acceptEncrypt + "\", \"customData\":\"" + this.customData + "\", \"version\":\"" + this.version + "\", \"customId\":\"" + this.customId + "\", \"event\":" + this.event + ", \"crash\":" + this.crash + '}';
    }
}
