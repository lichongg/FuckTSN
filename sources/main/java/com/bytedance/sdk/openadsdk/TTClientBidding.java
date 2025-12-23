package com.bytedance.sdk.openadsdk;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface TTClientBidding {
    void loss(Double d6, String str, String str2);

    void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener);

    void setPrice(Double d6);

    void win(Double d6);
}
