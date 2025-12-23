package com.bytedance.sdk.openadsdk.mediation.custom;

import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface MediationRewardItem {
    float getAmount();

    Map<String, Object> getCustomData();

    String getRewardName();

    boolean rewardVerify();
}
