package com.kwad.sdk.utils;

import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bc {
    public static volatile int bal;

    public static com.kwad.sdk.internal.api.a Ro() {
        KsCustomController ksCustomController;
        com.kwad.sdk.internal.api.a aVar;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig == null || (ksCustomController = sDKConfig.ksCustomController) == null) {
                return null;
            }
            try {
                aVar = com.kwad.sdk.internal.api.a.m(ksCustomController.getKsLocation());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                aVar = null;
            }
            return aVar != null ? aVar : com.kwad.sdk.internal.api.a.a(ksCustomController.getLocation());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean Rn() {
        if (!com.kwad.framework.a.a.oz.booleanValue()) {
            return false;
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return false;
    }

    private static boolean Rp() {
        if (!com.kwad.sdk.core.d.a.oz.booleanValue()) {
            return false;
        }
        try {
            com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String getDevAndroidId() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
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
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
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
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
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
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }

    public static String getDevMacAddress() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
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
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                return ksCustomController.getOaid();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean readInstalledPackagesDisable() {
        KsCustomController ksCustomController;
        if (Rn()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canReadInstalledPackages()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean readLocationDisable() {
        KsCustomController ksCustomController;
        if (Rn()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canReadLocation()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean useMacAddressDisable() {
        KsCustomController ksCustomController;
        if (Rn()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canUseMacAddress()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean useNetworkStateDisable() {
        KsCustomController ksCustomController;
        if (Rn()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canUseNetworkState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean useOaidDisable() {
        KsCustomController ksCustomController;
        if (Rn()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canUseOaid()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean usePhoneStateDisable() {
        KsCustomController ksCustomController;
        if (Rn()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canUsePhoneState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean useSensorManagerDisable() {
        if (Rp()) {
            return true;
        }
        if (bal == -1) {
            return true;
        }
        return false;
    }

    public static boolean useStoragePermissionDisable() {
        KsCustomController ksCustomController;
        if (Rn()) {
            return true;
        }
        try {
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (sDKConfig != null && (ksCustomController = sDKConfig.ksCustomController) != null) {
                if (!ksCustomController.canUseStoragePermission()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
