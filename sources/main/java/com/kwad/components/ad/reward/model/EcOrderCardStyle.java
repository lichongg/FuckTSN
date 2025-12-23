package com.kwad.components.ad.reward.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public enum EcOrderCardStyle {
    SPIKE_AND_COUPON(1),
    SPIKE(2),
    COUPON(3),
    NO_SPIKE_AND_NO_COUPON(4),
    DEFAULT(5);

    private int value;

    public final int getValue() {
        return this.value;
    }

    EcOrderCardStyle(int i6) {
        this.value = i6;
    }

    @Nullable
    public static EcOrderCardStyle createFromAdInfo(AdInfo adInfo) {
        if (!com.kwad.components.ad.reward.a.b.k(adInfo) && !com.kwad.components.ad.reward.a.b.j(adInfo)) {
            return null;
        }
        AdProductInfo cV = com.kwad.sdk.core.response.b.a.cV(adInfo);
        boolean hasSpike = cV.hasSpike();
        boolean hasCoupon = cV.hasCoupon();
        boolean hasOriginalPrice = cV.hasOriginalPrice();
        if (hasSpike && hasCoupon) {
            return SPIKE_AND_COUPON;
        }
        if (hasSpike) {
            return SPIKE;
        }
        if (hasCoupon) {
            return COUPON;
        }
        if (hasOriginalPrice) {
            return NO_SPIKE_AND_NO_COUPON;
        }
        return DEFAULT;
    }
}
