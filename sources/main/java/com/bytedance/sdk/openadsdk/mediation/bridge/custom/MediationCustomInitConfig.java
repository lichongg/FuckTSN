package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationCustomInitConfig {
    private String ae;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private String f31675g;

    /* renamed from: j, reason: collision with root package name */
    private String f31676j;

    /* renamed from: m, reason: collision with root package name */
    private String f31677m;
    private String oq;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    private String f31678r;
    private String tl;
    private String up;
    private String xt;

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.cw = str;
        this.f31676j = str2;
        this.xt = str3;
        this.f31678r = str4;
        this.up = str5;
        this.f31677m = str6;
        this.ae = str7;
        this.tl = str8;
        this.f31675g = str9;
        this.oq = str10;
        this.qv = str11;
    }

    public String getADNName() {
        return this.cw;
    }

    public String getAdnInitClassName() {
        return this.f31678r;
    }

    public String getAppId() {
        return this.f31676j;
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
        return this.f31677m;
    }

    public String getRewardClassName() {
        return this.ae;
    }

    public String getSplashClassName() {
        return this.f31675g;
    }

    public String toString() {
        return "MediationCustomInitConfig{mAppId='" + this.f31676j + "', mAppKey='" + this.xt + "', mADNName='" + this.cw + "', mAdnInitClassName='" + this.f31678r + "', mBannerClassName='" + this.up + "', mInterstitialClassName='" + this.f31677m + "', mRewardClassName='" + this.ae + "', mFullVideoClassName='" + this.tl + "', mSplashClassName='" + this.f31675g + "', mFeedClassName='" + this.oq + "', mDrawClassName='" + this.qv + "'}";
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.cw = valueSet.stringValue(8003);
            this.f31676j = valueSet.stringValue(8534);
            this.xt = valueSet.stringValue(8535);
            this.f31678r = valueSet.stringValue(8536);
            this.up = valueSet.stringValue(8537);
            this.f31677m = valueSet.stringValue(8538);
            this.ae = valueSet.stringValue(8539);
            this.tl = valueSet.stringValue(8540);
            this.f31675g = valueSet.stringValue(8541);
            this.oq = valueSet.stringValue(8542);
            this.qv = valueSet.stringValue(8543);
        }
    }
}
