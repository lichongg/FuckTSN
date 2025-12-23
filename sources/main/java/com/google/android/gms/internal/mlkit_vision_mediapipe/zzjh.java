package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzjh extends zzji {
    final /* synthetic */ zzjo zza;
    private int zzb = 0;
    private final int zzc;

    zzjh(zzjo zzjoVar) {
        this.zza = zzjoVar;
        this.zzc = zzjoVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzjk
    public final byte zza() {
        int i6 = this.zzb;
        if (i6 >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i6 + 1;
        return this.zza.zzb(i6);
    }
}
