package com.kwad.components.ad.reward.model;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.kwad.sdk.core.response.model.AdInfo;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    public static String m(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.cR(adInfo)) {
            return ILivePush.ClickType.LIVE;
        }
        if (com.kwad.sdk.core.response.b.a.bd(adInfo)) {
            return SocializeProtocolConstants.IMAGE;
        }
        if (com.kwad.sdk.core.response.b.a.cf(adInfo)) {
            return "reward_preview";
        }
        return "video";
    }
}
