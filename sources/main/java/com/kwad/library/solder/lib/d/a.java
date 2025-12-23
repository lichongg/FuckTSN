package com.kwad.library.solder.lib.d;

import android.os.Build;
import android.os.Process;
import com.kwad.sdk.utils.z;
import java.util.HashMap;
import java.util.Map;
import tv.cjump.jni.DeviceUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static String arH;
    private static String arI;
    private static final Map<String, String> arJ;

    static {
        HashMap hashMap = new HashMap();
        arJ = hashMap;
        hashMap.put(DeviceUtils.f54643b, DeviceUtils.f54643b);
        hashMap.put("mips64", "mips64");
        hashMap.put(DeviceUtils.f54642a, DeviceUtils.f54642a);
        hashMap.put("x86_64", "x86_64");
        hashMap.put("arm64", "arm64-v8a");
    }

    private static boolean is64Bit() {
        Boolean bool;
        boolean is64Bit;
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            return is64Bit;
        }
        try {
            bool = (Boolean) z.callMethod(z.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0]);
        } catch (Exception e6) {
            e6.printStackTrace();
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static String Az() {
        if (is64Bit()) {
            return "arm64-v8a";
        }
        return "armeabi-v7a";
    }
}
