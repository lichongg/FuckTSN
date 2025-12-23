package com.google.android.gms.internal.common;

import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzaf extends zzag {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzag zzc;

    @Override // com.google.android.gms.internal.common.zzac
    final boolean zzf() {
        return true;
    }

    zzaf(zzag zzagVar, int i6, int i7) {
        this.zzc = zzagVar;
        this.zza = i6;
        this.zzb = i7;
    }

    @Override // java.util.List
    public final Object get(int i6) {
        zzs.zza(i6, this.zzb, "index");
        return this.zzc.get(i6 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.common.zzac
    @CheckForNull
    final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* renamed from: zzh */
    public final zzag subList(int i6, int i7) {
        zzs.zzc(i6, i7, this.zzb);
        int i8 = this.zza;
        return this.zzc.subList(i6 + i8, i7 + i8);
    }

    @Override // com.google.android.gms.internal.common.zzag, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i6, int i7) {
        return subList(i6, i7);
    }
}
