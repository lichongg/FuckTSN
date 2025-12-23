package com.kwad.components.ad.reward.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.g;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.r;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static k tr = new k("rewardSkipType", 0);
    public static k ts = new k("rewardActiveAppTaskMinSecond", 15);
    public static k tt = new k("rewardContentDetainType", 0);
    public static d tu = new d("forceGetAudioFocus", false);

    /* renamed from: tv, reason: collision with root package name */
    public static r f36341tv = new r("rewardSkipTips", "");
    public static r tw = new r("fullscreenSkipTips", "");
    public static k tx = new k("ecRewardAdOrderSwitch", 0);
    public static k ty = new k("ecRewardAdFanSwitch", 0);
    public static k tz = new k("ecRewardAdKwaishopStyle", 0);
    public static k tA = new k("xdtCouponShowDuration", 3000);
    public static k tB = new k("jinniuCloseDialogStyle", 1);
    public static g tC = new g("interactionTimeInRewardedVideo", 0.0f);
    public static d tD = new d("autoJumpInRewardedVideo", false);
    public static k tE = new k("advanceJumpDirectDeliveryMaxCount", 0);
    public static d tF = new d("advanceJumpDirectDeliverySwitch", false);
    public static k tG = new k("shortVideoFollowRewardPlayStyle", 0);
    public static d tH = new d("enableRewardLayoutOptimise", false);
    public static d tI = new d("enableFullscreenLayoutOptimise", false);

    @InvokeBy(invokerClass = e.class, methodId = "initConfigList")
    public static void init() {
    }
}
