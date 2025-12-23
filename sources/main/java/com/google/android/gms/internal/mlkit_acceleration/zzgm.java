package com.google.android.gms.internal.mlkit_acceleration;

import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzgm {
    final Unsafe zza;

    public abstract double zza(Object obj, long j6);

    public abstract float zzb(Object obj, long j6);

    public abstract void zzc(Object obj, long j6, boolean z5);

    public abstract void zzd(Object obj, long j6, byte b6);

    public abstract void zze(Object obj, long j6, double d6);

    public abstract void zzf(Object obj, long j6, float f6);

    public abstract boolean zzg(Object obj, long j6);

    zzgm(Unsafe unsafe) {
        this.zza = unsafe;
    }
}
