package xyz.adscope.common.v2.dev.oaid.sm.oaid;

import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class OAIDLog {
    private static final String TAG = "OAID";
    private static boolean enable;

    public static void enable() {
        enable = true;
    }

    public static void print(Object obj) {
        if (enable) {
            if (obj == null) {
                obj = "<null>";
            }
            SDKLog.d(TAG, obj.toString());
        }
    }

    private OAIDLog() {
    }
}
