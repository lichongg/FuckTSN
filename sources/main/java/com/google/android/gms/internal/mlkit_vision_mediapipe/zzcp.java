package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.logging.Level;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzcp {
    public static String zza(String str, String str2, boolean z5) {
        if (str2.length() > 23) {
            int i6 = -1;
            for (int length = str2.length() - 1; length >= 0; length--) {
                char charAt = str2.charAt(length);
                if (charAt == '.' || charAt == '$') {
                    i6 = length;
                    break;
                }
            }
            str2 = str2.substring(i6 + 1);
        }
        String concat = "".concat(String.valueOf(str2));
        return concat.substring(0, Math.min(concat.length(), 23));
    }

    public static int zzb(Level level) {
        int intValue = level.intValue();
        if (intValue >= Level.SEVERE.intValue()) {
            return 6;
        }
        if (intValue >= Level.WARNING.intValue()) {
            return 5;
        }
        if (intValue >= Level.INFO.intValue()) {
            return 4;
        }
        if (intValue >= Level.FINE.intValue()) {
            return 3;
        }
        return 2;
    }
}
