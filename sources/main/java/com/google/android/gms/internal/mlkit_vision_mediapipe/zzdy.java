package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzdy {
    public static Object zza(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str.concat(" must not be null"));
    }

    public static void zzc(boolean z5, String str) {
        if (!z5) {
            throw new IllegalArgumentException(str);
        }
    }

    private static boolean zzd(char c6) {
        if (c6 < 'a' || c6 > 'z') {
            return c6 >= 'A' && c6 <= 'Z';
        }
        return true;
    }

    public static String zzb(String str) {
        if (!str.isEmpty()) {
            if (zzd(str.charAt(0))) {
                for (int i6 = 1; i6 < str.length(); i6++) {
                    char charAt = str.charAt(i6);
                    if (!zzd(charAt) && ((charAt < '0' || charAt > '9') && charAt != '_')) {
                        throw new IllegalArgumentException("identifier must contain only ASCII letters, digits or underscore: ".concat(str));
                    }
                }
                return str;
            }
            throw new IllegalArgumentException("identifier must start with an ASCII letter: ".concat(str));
        }
        throw new IllegalArgumentException("identifier must not be empty");
    }
}
