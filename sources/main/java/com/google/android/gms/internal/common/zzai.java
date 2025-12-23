package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@NullMarked
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzai extends zzag {
    static final zzag zza = new zzai(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    @Override // com.google.android.gms.internal.common.zzac
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final boolean zzf() {
        return false;
    }

    @Override // java.util.List
    public final Object get(int i6) {
        zzs.zza(i6, this.zzc, "index");
        Object obj = this.zzb[i6];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.common.zzag, com.google.android.gms.internal.common.zzac
    final int zza(Object[] objArr, int i6) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final Object[] zzg() {
        return this.zzb;
    }

    zzai(Object[] objArr, int i6) {
        this.zzb = objArr;
        this.zzc = i6;
    }
}
