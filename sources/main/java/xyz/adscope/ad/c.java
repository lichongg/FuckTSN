package xyz.adscope.ad;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public enum c {
    BANNER("banner", "4"),
    NATIVE(AMPSConstants.AdType.AD_TYPE_NATIVE, "3"),
    UNIFIED("unified", ""),
    INTERSTITIAL(MediationConstant.RIT_TYPE_INTERSTITIAL, "2"),
    VIDEO("video", ""),
    SPLASH("splash", "1"),
    S2S(AMPSConstants.BiddingType.BIDDING_TYPE_S2S, "");


    /* renamed from: a, reason: collision with root package name */
    private final String f54901a;

    /* renamed from: b, reason: collision with root package name */
    private final String f54902b;

    public String b() {
        return this.f54902b;
    }

    public String c() {
        return this.f54901a;
    }

    c(String str, String str2) {
        this.f54901a = str;
        this.f54902b = str2;
    }
}
