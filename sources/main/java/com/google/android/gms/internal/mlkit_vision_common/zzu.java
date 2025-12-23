package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzu extends zzp {
    static final zzp zza = new zzu(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    final int zzc() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i6) {
        zzf.zza(i6, this.zzc, "index");
        Object obj = this.zzb[i6];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzp, com.google.android.gms.internal.mlkit_vision_common.zzl
    final int zza(Object[] objArr, int i6) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    final Object[] zze() {
        return this.zzb;
    }

    zzu(Object[] objArr, int i6) {
        this.zzb = objArr;
        this.zzc = i6;
    }
}
