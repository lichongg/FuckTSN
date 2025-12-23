package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.api.IAdInterListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public enum CPUAdType {
    FEED("feed"),
    INTERSTITIAL(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL),
    REWARDVIDEO(IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO),
    OTHER("custom");

    private final String value;

    public String getValue() {
        return this.value;
    }

    CPUAdType(String str) {
        this.value = str;
    }

    public static CPUAdType parse(String str) {
        for (CPUAdType cPUAdType : values()) {
            if (cPUAdType.value.equalsIgnoreCase(str)) {
                return cPUAdType;
            }
        }
        return null;
    }
}
