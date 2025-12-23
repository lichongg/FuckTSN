package com.google.android.gms.internal.mlkit_acceleration;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzgi extends AbstractList implements RandomAccess, zzei {
    private final zzei zza;

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i6) {
        return ((zzeh) this.zza).get(i6);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzgh(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i6) {
        return new zzgg(this, i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzei
    public final Object zzf(int i6) {
        return this.zza.zzf(i6);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzei
    public final List zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzei
    public final void zzi(zzcs zzcsVar) {
        throw new UnsupportedOperationException();
    }

    public zzgi(zzei zzeiVar) {
        this.zza = zzeiVar;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzei
    public final zzei zze() {
        return this;
    }
}
