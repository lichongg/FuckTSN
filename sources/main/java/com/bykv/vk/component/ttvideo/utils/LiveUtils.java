package com.bykv.vk.component.ttvideo.utils;

/* loaded from: D:\Downloads\app\classes3.dex */
public class LiveUtils {
    public static int versionStringToInt(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String[] split = str.split("\\.");
        if (split.length <= 0) {
            return 0;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < split.length; i7++) {
            i6 = i7 == 0 ? Integer.parseInt(split[i7]) : (i6 * 100) + Integer.parseInt(split[i7]);
        }
        return i6;
    }
}
