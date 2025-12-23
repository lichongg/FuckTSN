package com.google.android.gms.internal.mlkit_common;

import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzal extends zzaf {
    static final zzaf zza = new zzal(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    final int zzc() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i6) {
        zzt.zza(i6, this.zzc, "index");
        Object obj = this.zzb[i6];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaf, com.google.android.gms.internal.mlkit_common.zzab
    final int zza(Object[] objArr, int i6) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    final Object[] zze() {
        return this.zzb;
    }

    zzal(Object[] objArr, int i6) {
        this.zzb = objArr;
        this.zzc = i6;
    }
}
