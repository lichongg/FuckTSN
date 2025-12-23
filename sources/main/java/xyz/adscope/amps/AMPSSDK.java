package xyz.adscope.amps;

import android.content.Context;
import android.content.Intent;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.config.AMPSPrivacyConfig;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.init.inter.IAMPSInitCallback;
import xyz.adscope.amps.manager.AMPSSDKManager;
import xyz.adscope.amps.tool.util.AMPSIntentInterrupter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSSDK {
    public static Context getContext() {
        return AMPSSDKManager.getInstance().getContext();
    }

    public static AMPSInitConfig getInitConfig() {
        return AMPSSDKManager.getInstance().getAMPSAdConfig();
    }

    public static String getSdkVersion() {
        return AMPSSDKManager.getInstance().getSdkVersion();
    }

    public static void init(Context context, AMPSInitConfig aMPSInitConfig, IAMPSInitCallback iAMPSInitCallback) {
        AMPSSDKManager.getInstance().initialize(context, aMPSInitConfig, iAMPSInitCallback);
    }

    public static boolean isInterrupterIntent(Context context, Intent intent) {
        return AMPSIntentInterrupter.getInstance().interruptRpkDeeplink(context, intent);
    }

    public static AMPSEnum.AMPSSDKInitStatus sdkInitStatus() {
        return AMPSSDKManager.getInstance().sdkInitStatus();
    }

    public static void setPersonalRecommend(boolean z5) {
        AMPSInitConfig aMPSAdConfig = AMPSSDKManager.getInstance().getAMPSAdConfig();
        if (aMPSAdConfig != null) {
            aMPSAdConfig.setPersonalRecommend(z5);
        }
    }

    public static void updatePrivacyConfig(AMPSPrivacyConfig aMPSPrivacyConfig) {
        AMPSSDKManager.getInstance().setAMPSPrivacyConfig(aMPSPrivacyConfig);
    }
}
