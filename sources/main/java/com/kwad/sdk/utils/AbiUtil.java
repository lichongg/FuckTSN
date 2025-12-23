package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class AbiUtil {
    private static Abi aYo;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    private static Abi cq(Context context) {
        boolean is64Bit;
        Abi abi = aYo;
        if (abi != null) {
            return abi;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            aYo = is64Bit ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
        } else {
            try {
                aYo = ((Boolean) z.callMethod(z.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                        aYo = Abi.ARM64_V8A;
                    } else {
                        aYo = Abi.UNKNOWN;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    aYo = Abi.UNKNOWN;
                }
            }
        }
        return aYo;
    }

    public static String cp(Context context) {
        if (isArm64(context)) {
            return "arm64-v8a";
        }
        return "armeabi-v7a";
    }

    public static boolean isArm64(Context context) {
        if (cq(context) == Abi.ARM64_V8A) {
            return true;
        }
        return false;
    }
}
