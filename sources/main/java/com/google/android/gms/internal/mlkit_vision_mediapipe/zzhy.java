package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhy {
    private static native int zzf(long j6);

    private static native int zzg(long j6);

    private static native boolean zzh(long j6, ByteBuffer byteBuffer);

    private static native byte[] zzi(long j6);

    private static native byte[][] zzj(long j6);

    public static int zza(zzhv zzhvVar) {
        return zzf(zzhvVar.zza());
    }

    public static int zzb(zzhv zzhvVar) {
        return zzg(zzhvVar.zza());
    }

    public static List zzc(zzhv zzhvVar, zzme zzmeVar) {
        byte[][] zzj = zzj(zzhvVar.zza());
        if (zzj != null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (byte[] bArr : zzj) {
                    arrayList.add(zzmeVar.zzb(bArr));
                }
                return arrayList;
            } catch (zzlb e6) {
                throw new IllegalArgumentException(e6);
            }
        }
        throw new NullPointerException("Vector of protocol buffer objects should not be null!");
    }

    public static boolean zzd(zzhv zzhvVar, ByteBuffer byteBuffer) {
        return zzh(zzhvVar.zza(), byteBuffer);
    }

    public static byte[] zze(zzhv zzhvVar) {
        return zzi(zzhvVar.zza());
    }
}
