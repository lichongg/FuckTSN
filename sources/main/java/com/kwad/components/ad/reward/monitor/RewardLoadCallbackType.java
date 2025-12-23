package com.kwad.components.ad.reward.monitor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public enum RewardLoadCallbackType implements a {
    LOAD_SUCCESS_BEFORE("load_success_before"),
    LOAD_SUCCESS("load_success"),
    LOAD_ERROR("load_error"),
    LOAD_CACHE_SUCCESS_BEFORE("load_cache_success_before"),
    LOAD_CACHE_SUCCESS("load_cache_success");

    private String typeValue;

    @Override // com.kwad.components.ad.reward.monitor.a
    public final String getTypeValue() {
        return this.typeValue;
    }

    RewardLoadCallbackType(String str) {
        this.typeValue = str;
    }
}
