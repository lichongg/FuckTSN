package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class i {
    static String auf = "autoRevert";

    public static String aX(Context context) {
        return getVersion(context, "curversion");
    }

    public static String aY(Context context) {
        return getVersion(context, "newversion");
    }

    static String aZ(Context context) {
        return getVersion(context, "apiversion");
    }

    private static String getVersion(Context context, String str) {
        return b.b(context, str, "");
    }

    public static void p(Context context, String str) {
        d(context, "curversion", str);
    }

    public static void q(Context context, String str) {
        d(context, "newversion", str);
    }

    static void r(Context context, String str) {
        d(context, "apiversion", str);
    }

    static boolean L(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        for (int i6 = 0; i6 < split.length && i6 < split2.length; i6++) {
            try {
                int parseInt = Integer.parseInt(split[i6]) - Integer.parseInt(split2[i6]);
                if (parseInt > 0) {
                    return true;
                }
                if (parseInt < 0) {
                    return false;
                }
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        if (split.length <= split2.length) {
            return false;
        }
        return true;
    }

    private static void d(Context context, String str, String str2) {
        b.c(context, str, str2);
    }
}
