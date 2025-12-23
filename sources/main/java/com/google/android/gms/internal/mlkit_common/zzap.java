package com.google.android.gms.internal.mlkit_common;

import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzap extends zzaf {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    @Override // java.util.List
    public final Object get(int i6) {
        zzt.zza(i6, this.zzc, "index");
        Object obj = this.zza[i6 + i6 + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    zzap(Object[] objArr, int i6, int i7) {
        this.zza = objArr;
        this.zzb = i6;
        this.zzc = i7;
    }
}
