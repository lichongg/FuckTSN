package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzdv extends RuntimeException {
    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return this;
    }

    public static zzdv zza(String str, String str2, int i6) {
        return new zzdv(zze(str, str2, i6, i6 + 1), str2);
    }

    public static zzdv zzb(String str, String str2) {
        return new zzdv(str, str2);
    }

    public static zzdv zzc(String str, String str2, int i6, int i7) {
        return new zzdv(zze(str, str2, i6, i7), str2);
    }

    public static zzdv zzd(String str, String str2, int i6) {
        return new zzdv(zze(str, str2, i6, -1), str2);
    }

    private static String zze(String str, String str2, int i6, int i7) {
        if (i7 < 0) {
            i7 = str2.length();
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append(": ");
        if (i6 > 8) {
            sb.append("...");
            sb.append((CharSequence) str2, i6 - 5, i6);
        } else {
            sb.append((CharSequence) str2, 0, i6);
        }
        sb.append('[');
        sb.append(str2.substring(i6, i7));
        sb.append(']');
        if (str2.length() - i7 > 8) {
            sb.append((CharSequence) str2, i7, i7 + 5);
            sb.append("...");
        } else {
            sb.append((CharSequence) str2, i7, str2.length());
        }
        return sb.toString();
    }

    private zzdv(String str, String str2) {
        super(str);
    }
}
