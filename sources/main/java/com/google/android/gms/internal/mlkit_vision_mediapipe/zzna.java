package com.google.android.gms.internal.mlkit_vision_mediapipe;

import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzna extends zznc {
    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznc
    public final double zza(Object obj, long j6) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznc
    public final float zzb(Object obj, long j6) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznc
    public final void zzc(Object obj, long j6, boolean z5) {
        if (zznd.zzb) {
            zznd.zzD(obj, j6, r3 ? (byte) 1 : (byte) 0);
        } else {
            zznd.zzE(obj, j6, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznc
    public final void zzd(Object obj, long j6, byte b6) {
        if (zznd.zzb) {
            zznd.zzD(obj, j6, b6);
        } else {
            zznd.zzE(obj, j6, b6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznc
    public final boolean zzg(Object obj, long j6) {
        return zznd.zzb ? zznd.zzt(obj, j6) : zznd.zzu(obj, j6);
    }

    zzna(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznc
    public final void zze(Object obj, long j6, double d6) {
        this.zza.putLong(obj, j6, Double.doubleToLongBits(d6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznc
    public final void zzf(Object obj, long j6, float f6) {
        this.zza.putInt(obj, j6, Float.floatToIntBits(f6));
    }
}
