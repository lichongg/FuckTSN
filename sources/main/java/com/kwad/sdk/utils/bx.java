package com.kwad.sdk.utils;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bx {
    public static boolean aA(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
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
            if (split.length >= split2.length) {
                return true;
            }
        }
        return false;
    }
}
