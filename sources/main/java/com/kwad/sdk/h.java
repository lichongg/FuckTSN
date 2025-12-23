package com.kwad.sdk;

import cn.jpush.android.local.JPushConstants;
import com.kwad.sdk.components.DevelopMangerComponents;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h {
    public static String AK() {
        String str = JPushConstants.HTTPS_PRE + com.kwad.sdk.core.network.idc.a.HF().W("api", "open.e.kuaishou.com");
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return str;
    }

    public static String AL() {
        return AK() + "/rest/e/v3/open/univ";
    }

    public static String AM() {
        return AK() + "/rest/e/v4/open/univ";
    }

    public static String AN() {
        return AK() + "/rest/e/v4/open/univ/bidding";
    }

    public static String AO() {
        return AK() + "/rest/e/v4/open/univ/getMaterial";
    }

    public static String AP() {
        return AK() + "/rest/e/v3/open/logBatch";
    }

    public static String AQ() {
        return AK() + "/rest/e/v3/open/config";
    }

    public static String AR() {
        return AK() + "/rest/e/v3/open/callback";
    }

    public static String AS() {
        return AK() + "/rest/e/v3/open/crashLog";
    }

    public static String AT() {
        return AK() + "/rest/e/v3/open/appCheck";
    }

    public static String AU() {
        return AK() + "/rest/e/v3/open/collect";
    }

    public static String AV() {
        return AK() + "/rest/e/v3/open/checkReward";
    }

    public static String AW() {
        return AK() + "/rest/e/v3/open/rewardFraudVerify";
    }

    public static String AX() {
        return AK() + "/rest/e/v3/open/kwaiGeoLocation";
    }

    public static String AY() {
        return AK() + "/rest/e/v3/open/getMiMarketUrl";
    }

    public static String AZ() {
        return "https://style-browse-openapi.test.gifshow.com//rest/e/internal/adBrowse";
    }

    public static String Ba() {
        return AK() + "/rest/e/v3/open/uaid";
    }

    public static String Bb() {
        return "https://msg.cmpassport.com/h5/uaidAdGetMobile";
    }

    public static String Bc() {
        return AK() + "/rest/e/v3/open/sdk/warmup";
    }

    public static String ce(String str) {
        return str + "/rest/e/system/speed";
    }
}
