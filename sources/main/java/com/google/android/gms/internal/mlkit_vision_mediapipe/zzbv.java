package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbv implements Iterator {
    final /* synthetic */ zzbw zza;
    private int zzb = 0;

    zzbv(zzbw zzbwVar) {
        this.zza = zzbwVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i6;
        zzca zzcaVar = this.zza.zza;
        int i7 = this.zzb;
        i6 = zzcaVar.zzd;
        return i7 < i6;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int[] iArr;
        zzai zzi;
        zzca zzcaVar = this.zza.zza;
        iArr = zzcaVar.zzc;
        int i6 = this.zzb;
        this.zzb = i6 + 1;
        zzi = zzcaVar.zzi(iArr[i6] & 31);
        return zzi;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
