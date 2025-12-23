package xyz.adscope.ad;

import android.content.Context;
import com.baidu.mobads.sdk.api.SplashAd;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.v2.dev.info.AdScopeUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class f0 {
    public static String a(Context context) {
        return AdScopeUtil.getScopeSdkID(context);
    }

    public static String a() {
        return AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_ASNP;
    }

    public static String b() {
        return "xyz.adscope.ad";
    }

    public static String c() {
        return "5.2.1.3";
    }

    public static String d() {
        return "sdk";
    }

    public static String e() {
        return SplashAd.KEY_BIDFAIL_ADN;
    }

    public static String f() {
        return "5.2.1.3";
    }
}
