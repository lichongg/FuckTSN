package xyz.adscope.amps.init;

import java.util.Map;
import xyz.adscope.amps.config.AMPSPrivacyConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSInitAdapterConfig {
    private AMPSInitChannelAdapterConfig ampsInitChannelAdapterConfig;
    private String appId;

    public AMPSInitChannelAdapterConfig getAmpsInitChannelAdapterConfig() {
        return this.ampsInitChannelAdapterConfig;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        return aMPSInitChannelAdapterConfig != null ? aMPSInitChannelAdapterConfig.getAppName() : "";
    }

    public String getCustomOAID() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        return aMPSInitChannelAdapterConfig != null ? aMPSInitChannelAdapterConfig.getCustomOAID() : "";
    }

    public Map<String, Map<String, Object>> getLocalExtraMap() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        if (aMPSInitChannelAdapterConfig != null) {
            return aMPSInitChannelAdapterConfig.getLocalExtraMap();
        }
        return null;
    }

    public String getOptionInfo() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        if (aMPSInitChannelAdapterConfig != null) {
            return aMPSInitChannelAdapterConfig.getOptionInfo();
        }
        return null;
    }

    public AMPSPrivacyConfig getPrivacyConfig() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        if (aMPSInitChannelAdapterConfig != null) {
            return aMPSInitChannelAdapterConfig.getPrivacyConfig();
        }
        return null;
    }

    public String getUserId() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        return aMPSInitChannelAdapterConfig != null ? aMPSInitChannelAdapterConfig.getUserId() : "";
    }

    public boolean isDebug() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        if (aMPSInitChannelAdapterConfig != null) {
            return aMPSInitChannelAdapterConfig.isDebug();
        }
        return false;
    }

    public boolean isPersonalRecommend() {
        AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig = this.ampsInitChannelAdapterConfig;
        if (aMPSInitChannelAdapterConfig != null) {
            return aMPSInitChannelAdapterConfig.isPersonalRecommend();
        }
        return false;
    }

    public void setAmpsInitChannelAdapterConfig(AMPSInitChannelAdapterConfig aMPSInitChannelAdapterConfig) {
        this.ampsInitChannelAdapterConfig = aMPSInitChannelAdapterConfig;
    }

    public void setAppId(String str) {
        this.appId = str;
    }
}
