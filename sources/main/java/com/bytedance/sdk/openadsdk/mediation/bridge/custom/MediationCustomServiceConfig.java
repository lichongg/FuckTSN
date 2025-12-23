package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class MediationCustomServiceConfig {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private String f31683j;

    /* renamed from: r, reason: collision with root package name */
    private int f31684r;
    private String up;
    private String xt;

    public MediationCustomServiceConfig(String str, String str2, int i6, int i7, String str3) {
        this.f31683j = str;
        this.xt = str2;
        this.cw = i6;
        this.f31684r = i7;
        this.up = str3;
    }

    public String getADNNetworkName() {
        return this.f31683j;
    }

    public String getADNNetworkSlotId() {
        return this.xt;
    }

    public int getAdStyleType() {
        return this.cw;
    }

    public String getCustomAdapterJson() {
        return this.up;
    }

    public int getSubAdtype() {
        return this.f31684r;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.f31683j + "', mADNNetworkSlotId='" + this.xt + "', mAdStyleType=" + this.cw + ", mSubAdtype=" + this.f31684r + ", mCustomAdapterJson='" + this.up + "'}";
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.f31683j = valueSet.stringValue(8003);
            this.xt = valueSet.stringValue(2);
            this.cw = valueSet.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
            this.f31684r = valueSet.intValue(8094);
            this.up = valueSet.stringValue(8547);
        }
    }
}
