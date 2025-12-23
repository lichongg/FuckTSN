package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzas extends AbstractCollection {
    final /* synthetic */ zzat zza;

    zzas(zzat zzatVar) {
        this.zza = zzatVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzat zzatVar = this.zza;
        Map zzl = zzatVar.zzl();
        return zzl != null ? zzl.values().iterator() : new zzam(zzatVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size();
    }
}
