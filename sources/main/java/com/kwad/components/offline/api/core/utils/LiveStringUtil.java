package com.kwad.components.offline.api.core.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class LiveStringUtil {
    @NonNull
    public static String emptyIfNull(String str) {
        return str != null ? str : "";
    }

    public static boolean isEquals(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(str2)) {
            return true;
        }
        return false;
    }

    public static boolean isNullString(String str) {
        if (!TextUtils.isEmpty(str) && !"null".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }
}
