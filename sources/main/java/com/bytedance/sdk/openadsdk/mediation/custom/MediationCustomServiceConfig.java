package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class MediationCustomServiceConfig {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private String f31704j;

    /* renamed from: m, reason: collision with root package name */
    private Map<String, Object> f31705m = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private int f31706r;
    private String up;
    private String xt;

    public MediationCustomServiceConfig(String str, String str2, int i6, int i7, String str3) {
        this.f31704j = str;
        this.xt = str2;
        this.cw = i6;
        this.f31706r = i7;
        this.up = str3;
    }

    public String getADNNetworkName() {
        return this.f31704j;
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

    public Map<String, Object> getExtraData() {
        return this.f31705m;
    }

    public int getSubAdtype() {
        return this.f31706r;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.f31704j + "', mADNNetworkSlotId='" + this.xt + "', mAdStyleType=" + this.cw + ", mSubAdtype=" + this.f31706r + ", mCustomAdapterJson='" + this.up + "'}";
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.f31704j = valueSet.stringValue(8003);
            this.xt = valueSet.stringValue(2);
            this.cw = valueSet.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
            this.f31706r = valueSet.intValue(8094);
            this.up = valueSet.stringValue(8547);
            Map<? extends String, ? extends Object> map = (Map) valueSet.objectValue(8075, Map.class);
            if (map == null || map.size() <= 0) {
                return;
            }
            this.f31705m.putAll(map);
        }
    }
}
