package xyz.adscope.amps.init;

import java.util.Map;
import xyz.adscope.amps.config.AMPSPrivacyConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSInitChannelAdapterConfig {
    private String appName;
    private String customOAID;
    private boolean debug;
    private Map<String, Map<String, Object>> localExtraMap;
    private String optionInfo;
    private boolean personalRecommend;
    private AMPSPrivacyConfig privacyConfig;
    private String userId;

    public void clear() {
        this.privacyConfig = null;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getCustomOAID() {
        return this.customOAID;
    }

    public Map<String, Map<String, Object>> getLocalExtraMap() {
        return this.localExtraMap;
    }

    public String getOptionInfo() {
        return this.optionInfo;
    }

    public AMPSPrivacyConfig getPrivacyConfig() {
        return this.privacyConfig;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isPersonalRecommend() {
        return this.personalRecommend;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setCustomOAID(String str) {
        this.customOAID = str;
    }

    public void setDebug(boolean z5) {
        this.debug = z5;
    }

    public void setLocalExtraMap(Map<String, Map<String, Object>> map) {
        this.localExtraMap = map;
    }

    public void setOptionInfo(String str) {
        this.optionInfo = str;
    }

    public void setPersonalRecommend(boolean z5) {
        this.personalRecommend = z5;
    }

    public void setPrivacyConfig(AMPSPrivacyConfig aMPSPrivacyConfig) {
        this.privacyConfig = aMPSPrivacyConfig;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
