package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class ac {
    static boolean is64Bit() {
        boolean is64Bit;
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            return is64Bit;
        }
        try {
            return ((Boolean) ApiReflect.cn("dalvik.system.VMRuntime").cq("getRuntime").cq("is64Bit").get()).booleanValue();
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static String Az() {
        if (is64Bit()) {
            return "arm64-v8a";
        }
        return "armeabi-v7a";
    }
}
