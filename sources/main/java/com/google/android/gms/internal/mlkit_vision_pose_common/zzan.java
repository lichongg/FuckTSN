package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzan extends AbstractSet {
    final /* synthetic */ zzat zza;

    zzan(zzat zzatVar) {
        this.zza = zzatVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        int zzw;
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            zzw = this.zza.zzw(entry.getKey());
            if (zzw != -1 && zzp.zza(zzat.zzj(this.zza, zzw), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzat zzatVar = this.zza;
        Map zzl = zzatVar.zzl();
        return zzl != null ? zzl.entrySet().iterator() : new zzal(zzatVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        int zzv;
        int[] zzA;
        Object[] zzB;
        Object[] zzC;
        int i6;
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzat zzatVar = this.zza;
        if (zzatVar.zzr()) {
            return false;
        }
        zzv = zzatVar.zzv();
        Object key = entry.getKey();
        Object value = entry.getValue();
        zzat zzatVar2 = this.zza;
        Object zzi = zzat.zzi(zzatVar2);
        zzA = zzatVar2.zzA();
        zzB = zzatVar2.zzB();
        zzC = zzatVar2.zzC();
        int zzb = zzau.zzb(key, value, zzv, zzi, zzA, zzB, zzC);
        if (zzb == -1) {
            return false;
        }
        this.zza.zzq(zzb, zzv);
        zzat zzatVar3 = this.zza;
        i6 = zzatVar3.zzg;
        zzatVar3.zzg = i6 - 1;
        this.zza.zzo();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
