package com.google.android.gms.internal.mlkit_vision_mediapipe;

import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzb {
    private static String zzd(int i6, int i7, String str) {
        return i6 < 0 ? zzc.zza("%s (%s) must not be negative", str, Integer.valueOf(i6)) : zzc.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i6), Integer.valueOf(i7));
    }

    public static void zza(int i6, int i7, int i8) {
        if (i6 < 0 || i7 < i6 || i7 > i8) {
            throw new IndexOutOfBoundsException((i6 < 0 || i6 > i8) ? zzd(i6, i8, "start index") : (i7 < 0 || i7 > i8) ? zzd(i7, i8, "end index") : zzc.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i7), Integer.valueOf(i6)));
        }
    }

    public static void zzb(boolean z5) {
        if (!z5) {
            throw new IllegalStateException();
        }
    }

    public static void zzc(boolean z5, @CheckForNull Object obj) {
        if (!z5) {
            throw new IllegalStateException((String) obj);
        }
    }
}
