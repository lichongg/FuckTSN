package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bt {
    public static void a(long j6, int i6, @Nullable Context context) {
        if (j6 == 0 || context == null || i6 <= 0 || i6 > 100) {
            return;
        }
        long currentTimeMillis = j6 - System.currentTimeMillis();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
            if (sharedPreferences == null) {
                return;
            }
            if (Math.abs(currentTimeMillis) / 3600000 > i6) {
                sharedPreferences.edit().putLong("key_time_diff_s2c", currentTimeMillis).apply();
            } else {
                sharedPreferences.edit().remove("key_time_diff_s2c").apply();
            }
        } catch (Throwable unused) {
        }
    }

    public static long x(@Nullable Context context, boolean z5) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!z5) {
            return currentTimeMillis;
        }
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
            if (sharedPreferences == null) {
                return Math.abs(currentTimeMillis);
            }
            long j6 = sharedPreferences.getLong("key_time_diff_s2c", 0L);
            if (j6 != 0) {
                return currentTimeMillis + j6;
            }
        }
        return Math.abs(currentTimeMillis);
    }
}
