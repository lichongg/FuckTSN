package com.beizi.fusion;

import com.beizi.ad.model.BeiZiLocation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class BeiZiCustomController {
    public boolean forbidSensor() {
        return false;
    }

    public String getAndroidId() {
        return null;
    }

    public String getDevOaid() {
        return null;
    }

    public BeiZiLocation getLocation() {
        return null;
    }

    public String getOaidVersion() {
        return null;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseAppList() {
        return true;
    }

    public boolean isCanUseGaid() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseOaid() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isCanUseWifiState() {
        return true;
    }
}
