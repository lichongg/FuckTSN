package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.List;
import java.util.ListIterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzac extends zzaa implements ListIterator {
    final /* synthetic */ zzad zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzac(zzad zzadVar) {
        super(zzadVar);
        this.zzd = zzadVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzac(zzad zzadVar, int i6) {
        super(zzadVar, ((List) zzadVar.zzb).listIterator(i6));
        this.zzd = zzadVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i6;
        boolean isEmpty = this.zzd.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzae zzaeVar = this.zzd.zzf;
        i6 = zzaeVar.zzb;
        zzaeVar.zzb = i6 + 1;
        if (isEmpty) {
            this.zzd.zza();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }
}
