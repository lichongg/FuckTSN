package com.kwad.sdk.api.proxy.app;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ApiConfigUtils {
    private static final String PREFERENCE_NAME = "ksadsdk_config";

    public static int readInt(Context context, String str, int i6) {
        try {
            return context.getSharedPreferences(PREFERENCE_NAME, 0).getInt(str, i6);
        } catch (Throwable unused) {
            return i6;
        }
    }

    public static String readString(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(PREFERENCE_NAME, 0).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
