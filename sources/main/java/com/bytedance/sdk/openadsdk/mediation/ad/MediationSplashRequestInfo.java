package com.bytedance.sdk.openadsdk.mediation.ad;

import androidx.annotation.Nullable;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class MediationSplashRequestInfo implements IMediationSplashRequestInfo {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private String f31647j;

    /* renamed from: r, reason: collision with root package name */
    private String f31648r;
    private String xt;

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnName() {
        return this.f31647j;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnSlotId() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppId() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppkey() {
        return this.f31648r;
    }

    public MediationSplashRequestInfo(String str, String str2, String str3, String str4) {
        this.f31647j = str;
        this.xt = str2;
        this.cw = str3;
        this.f31648r = str4;
    }
}
