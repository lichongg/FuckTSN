package com.google.android.gms.internal.mlkit_common;

import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzae extends zzaf {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzaf zzc;

    zzae(zzaf zzafVar, int i6, int i7) {
        this.zzc = zzafVar;
        this.zza = i6;
        this.zzb = i7;
    }

    @Override // java.util.List
    public final Object get(int i6) {
        zzt.zza(i6, this.zzb, "index");
        return this.zzc.get(i6 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    @CheckForNull
    final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaf
    /* renamed from: zzf */
    public final zzaf subList(int i6, int i7) {
        zzt.zzd(i6, i7, this.zzb);
        int i8 = this.zza;
        return this.zzc.subList(i6 + i8, i7 + i8);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaf, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i6, int i7) {
        return subList(i6, i7);
    }
}
