package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationCustomInitConfig {
    private String ae;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private String f31700g;

    /* renamed from: j, reason: collision with root package name */
    private String f31701j;

    /* renamed from: m, reason: collision with root package name */
    private String f31702m;
    private String oq;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    private String f31703r;
    private String tl;
    private String up;
    private String xt;

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.cw = str;
        this.f31701j = str2;
        this.xt = str3;
        this.f31703r = str4;
        this.up = str5;
        this.f31702m = str6;
        this.ae = str7;
        this.tl = str8;
        this.f31700g = str9;
        this.oq = str10;
        this.qv = str11;
    }

    public String getADNName() {
        return this.cw;
    }

    public String getAdnInitClassName() {
        return this.f31703r;
    }

    public String getAppId() {
        return this.f31701j;
    }

    public String getAppKey() {
        return this.xt;
    }

    public String getBannerClassName() {
        return this.up;
    }

    public String getDrawClassName() {
        return this.qv;
    }

    public String getFeedClassName() {
        return this.oq;
    }

    public String getFullVideoClassName() {
        return this.tl;
    }

    public String getInterstitialClassName() {
        return this.f31702m;
    }

    public String getRewardClassName() {
        return this.ae;
    }

    public String getSplashClassName() {
        return this.f31700g;
    }

    public String toString() {
        return "MediationCustomInitConfig{mAppId='" + this.f31701j + "', mAppKey='" + this.xt + "', mADNName='" + this.cw + "', mAdnInitClassName='" + this.f31703r + "', mBannerClassName='" + this.up + "', mInterstitialClassName='" + this.f31702m + "', mRewardClassName='" + this.ae + "', mFullVideoClassName='" + this.tl + "', mSplashClassName='" + this.f31700g + "', mFeedClassName='" + this.oq + "', mDrawClassName='" + this.qv + "'}";
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.cw = valueSet.stringValue(8003);
            this.f31701j = valueSet.stringValue(8534);
            this.xt = valueSet.stringValue(8535);
            this.f31703r = valueSet.stringValue(8536);
            this.up = valueSet.stringValue(8537);
            this.f31702m = valueSet.stringValue(8538);
            this.ae = valueSet.stringValue(8539);
            this.tl = valueSet.stringValue(8540);
            this.f31700g = valueSet.stringValue(8541);
            this.oq = valueSet.stringValue(8542);
            this.qv = valueSet.stringValue(8543);
        }
    }
}
