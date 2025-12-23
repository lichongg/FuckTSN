package xyz.adscope.amps.config;

import android.content.pm.PackageInfo;
import java.util.List;
import xyz.adscope.amps.config.model.AMPSLocation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class AMPSPrivacyConfig {
    public String getAndroidId() {
        return null;
    }

    public List<PackageInfo> getAppList() {
        return null;
    }

    public String getDevImei() {
        return null;
    }

    public String[] getDevImeiList() {
        return null;
    }

    public String getDevOaid() {
        return null;
    }

    public String getIP() {
        return null;
    }

    public AMPSLocation getLocation() {
        return null;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseAppList() {
        return true;
    }

    public boolean isCanUseIP() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseMacAddress() {
        return true;
    }

    public boolean isCanUseOaid() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isCanUseRecordAudio() {
        return true;
    }

    public boolean isCanUseShakeAd() {
        return true;
    }

    public boolean isCanUseSimOperator() {
        return true;
    }

    public boolean isCanUseWifiState() {
        return true;
    }

    public boolean isCanUseWriteExternal() {
        return true;
    }

    public boolean isSupportPersonalized() {
        return true;
    }

    public String getDevSimOperatorCode() {
        return "";
    }

    public String getDevSimOperatorName() {
        return "";
    }

    public String getMacAddress() {
        return "";
    }
}
