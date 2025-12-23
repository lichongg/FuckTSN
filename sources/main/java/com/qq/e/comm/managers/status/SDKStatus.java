package com.qq.e.comm.managers.status;

import com.qq.e.comm.managers.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SDKStatus {
    public static final int SDK_CHANNEL = 101;
    public static final String SDK_EX1 = "";
    public static final String SDK_EX2 = "";
    public static final int STUB_IDENTITY = 1;
    public static final boolean isNoPlugin = false;

    public static final int getBuildInPluginVersion() {
        return 1512;
    }

    public static final String getIntegrationSDKVersion() {
        return "4.642." + getBuildInPluginVersion();
    }

    public static final String getSDKVersion() {
        return "4.642";
    }

    public static final int getPluginVersion() {
        if (!a.b().d()) {
            return 0;
        }
        return a.b().c().getPluginVersion();
    }
}
