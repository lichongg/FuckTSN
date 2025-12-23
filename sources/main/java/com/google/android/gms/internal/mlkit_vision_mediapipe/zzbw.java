package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.AbstractSet;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbw extends AbstractSet {
    final /* synthetic */ zzca zza;

    zzbw(zzca zzcaVar) {
        this.zza = zzcaVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzbv(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        int i6;
        i6 = this.zza.zzd;
        return i6;
    }
}
