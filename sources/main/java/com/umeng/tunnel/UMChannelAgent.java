package com.umeng.tunnel;

import android.content.Context;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMChannelAgent {
    private static final String TAG = "UMChannelAgent";
    private static final String UMENG_VCHANNEL = "com.umeng.commonsdk.vchannel.Sender";
    private static boolean vChannelReady;

    static {
        try {
            Class.forName(UMENG_VCHANNEL);
            vChannelReady = true;
        } catch (Throwable unused) {
        }
    }

    public static boolean init() {
        return vChannelReady;
    }

    private static void reflectOnEvent(Context context, String str, Map<String, Object> map) {
        try {
            Class.forName(UMENG_VCHANNEL).getMethod("onEvent", Context.class, String.class, Map.class).invoke(null, context, str, map);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | Exception unused) {
        }
    }

    private static void reflectSetCustomHeader(Map<String, String> map) {
        try {
            Class.forName(UMENG_VCHANNEL).getMethod("setCustomHeader", Map.class).invoke(null, map);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | Exception unused) {
        }
    }

    public static void onDebugEvent(Context context, String str, Map<String, Object> map) {
        reflectOnEvent(context, str, map);
    }

    public static void setCustomHeader(Map<String, String> map) {
        reflectSetCustomHeader(map);
    }
}
