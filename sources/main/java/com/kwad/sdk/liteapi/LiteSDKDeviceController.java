package com.kwad.sdk.liteapi;

import android.location.Location;
import androidx.annotation.Keep;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class LiteSDKDeviceController {
    public static boolean readInstalledPackagesDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canReadInstalledPackages();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean readLocationDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canReadLocation();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean useMacAddressDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUseMacAddress();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean useNetworkStateDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUseNetworkState();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean useOaidDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUseOaid();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean usePhoneStateDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUsePhoneState();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean useStoragePermissionDisable() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUseStoragePermission();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String getDevAndroidId() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getAndroidId();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDevImei() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getImei();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] getDevImeis() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getImeis();
            }
        } catch (Throwable unused) {
        }
        return new String[]{"", ""};
    }

    public static List<String> getDevInstalledPackages() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }

    public static Location getDevLocation() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getLocation();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getDevMacAddress() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getMacAddress();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDevOaid() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = InputParamHolder.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getOaid();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }
}
