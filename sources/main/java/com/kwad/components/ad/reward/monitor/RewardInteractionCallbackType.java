package com.kwad.components.ad.reward.monitor;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public enum RewardInteractionCallbackType implements a {
    AD_CLICK("ad_click"),
    PAGE_DISMISS("page_close"),
    VIDEO_PLAY_ERROR("play_error"),
    VIDEO_PLAY_END("play_end"),
    VIDEO_SKIP_TO_END("skip_to_end"),
    VIDEO_PLAY_START("play_start"),
    REWARD_VERIFY(MediationConstant.REWARD_VERIFY),
    REWARD_STEP_VERIFY("reward_step_verify"),
    EXTRA_REWARD_VERIFY("extra_reward_verify");

    private String typeValue;

    @Override // com.kwad.components.ad.reward.monitor.a
    public final String getTypeValue() {
        return this.typeValue;
    }

    RewardInteractionCallbackType(String str) {
        this.typeValue = str;
    }
}
