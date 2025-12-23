package com.google.android.gms.internal.mlkit_acceleration;

import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzgh implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzgi zzb;

    zzgh(zzgi zzgiVar) {
        zzei zzeiVar;
        this.zzb = zzgiVar;
        zzeiVar = zzgiVar.zza;
        this.zza = zzeiVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
