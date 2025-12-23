package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzby implements Iterator {
    final /* synthetic */ zzca zza;
    private final zzai zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzby(zzca zzcaVar, zzai zzaiVar, int i6, zzbx zzbxVar) {
        this.zza = zzcaVar;
        this.zzb = zzaiVar;
        int i7 = i6 & 31;
        this.zzc = i7;
        this.zzd = i6 >>> (i7 + 5);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object zzj;
        zzj = this.zza.zzj(this.zzc);
        Object zze = this.zzb.zze(zzj);
        int i6 = this.zzd;
        if (i6 == 0) {
            this.zzc = -1;
            return zze;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i6) + 1;
        this.zzd >>>= numberOfTrailingZeros;
        this.zzc += numberOfTrailingZeros;
        return zze;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
