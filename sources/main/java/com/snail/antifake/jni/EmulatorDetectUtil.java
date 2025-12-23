package com.snail.antifake.jni;

import android.content.Context;
import com.snail.antifake.deviceid.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class EmulatorDetectUtil {
    public static native boolean detect();

    static {
        System.loadLibrary("emulator_check");
    }

    public static boolean a() {
        return detect();
    }

    public static boolean b(Context context) {
        if (!a.q(context) && !detect()) {
            return false;
        }
        return true;
    }

    public void c() {
    }
}
