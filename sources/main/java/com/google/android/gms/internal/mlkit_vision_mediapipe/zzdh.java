package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzdh implements Iterator {
    final /* synthetic */ zzdi zza;
    private int zzb = 0;

    zzdh(zzdi zzdiVar) {
        this.zza = zzdiVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i6 = this.zzb;
        zzdi zzdiVar = this.zza;
        return i6 < zzdiVar.zza() - zzdiVar.zzb();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object[] objArr;
        int i6 = this.zzb;
        zzdi zzdiVar = this.zza;
        if (i6 >= zzdiVar.zza() - zzdiVar.zzb()) {
            throw new NoSuchElementException();
        }
        zzdi zzdiVar2 = this.zza;
        objArr = zzdiVar2.zzb.zzb;
        Object obj = objArr[zzdiVar2.zzb() + i6];
        this.zzb = i6 + 1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
