package com.bytedance.sdk.openadsdk.mediation;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface IMediationNativeAdTokenCallback {
    void onAdTokenLoaded(String str, IMediationNativeTokenInfo iMediationNativeTokenInfo);

    void onAdTokenLoadedFail(int i6, String str);
}
