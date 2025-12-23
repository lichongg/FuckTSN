package com.google.android.gms.internal.mlkit_common;

import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzt {
    private static String zzf(int i6, int i7, String str) {
        if (i6 < 0) {
            return zzu.zza("%s (%s) must not be negative", str, Integer.valueOf(i6));
        }
        if (i7 >= 0) {
            return zzu.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i6), Integer.valueOf(i7));
        }
        throw new IllegalArgumentException("negative size: " + i7);
    }

    public static int zza(int i6, int i7, String str) {
        String zza;
        if (i6 >= 0 && i6 < i7) {
            return i6;
        }
        if (i6 < 0) {
            zza = zzu.zza("%s (%s) must not be negative", "index", Integer.valueOf(i6));
        } else {
            if (i7 < 0) {
                throw new IllegalArgumentException("negative size: " + i7);
            }
            zza = zzu.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i6), Integer.valueOf(i7));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzb(int i6, int i7, String str) {
        if (i6 < 0 || i6 > i7) {
            throw new IndexOutOfBoundsException(zzf(i6, i7, "index"));
        }
        return i6;
    }

    public static Object zzc(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static void zzd(int i6, int i7, int i8) {
        if (i6 < 0 || i7 < i6 || i7 > i8) {
            throw new IndexOutOfBoundsException((i6 < 0 || i6 > i8) ? zzf(i6, i8, "start index") : (i7 < 0 || i7 > i8) ? zzf(i7, i8, "end index") : zzu.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i7), Integer.valueOf(i6)));
        }
    }

    public static void zze(boolean z5, @CheckForNull Object obj) {
        if (!z5) {
            throw new IllegalStateException("A SourcePolicy can only set internal() or external() once.");
        }
    }
}
