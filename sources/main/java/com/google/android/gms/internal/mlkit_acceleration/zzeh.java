package com.google.android.gms.internal.mlkit_acceleration;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzeh extends zzcd implements RandomAccess, zzei {

    @Deprecated
    public static final zzei zza;
    private static final zzeh zzb;
    private final List zzc;

    public zzeh() {
        this(10);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final boolean addAll(int i6, Collection collection) {
        zza();
        if (collection instanceof zzei) {
            collection = ((zzei) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i6, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    static {
        zzeh zzehVar = new zzeh(false);
        zzb = zzehVar;
        zza = zzehVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeh(int i6) {
        super(true);
        ArrayList arrayList = new ArrayList(i6);
        this.zzc = arrayList;
    }

    private static String zzj(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzcs ? ((zzcs) obj).zzm(zzeb.zzb) : zzeb.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i6, Object obj) {
        zza();
        this.zzc.add(i6, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i6, Object obj) {
        zza();
        return zzj(this.zzc.set(i6, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzei
    public final Object zzf(int i6) {
        return this.zzc.get(i6);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i6) {
        Object obj = this.zzc.get(i6);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzcs) {
            zzcs zzcsVar = (zzcs) obj;
            String zzm = zzcsVar.zzm(zzeb.zzb);
            if (zzcsVar.zzi()) {
                this.zzc.set(i6, zzm);
            }
            return zzm;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzeb.zzd(bArr);
        if (zzgs.zze(bArr)) {
            this.zzc.set(i6, zzd);
        }
        return zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzei
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i6) {
        zza();
        Object remove = this.zzc.remove(i6);
        ((AbstractList) this).modCount++;
        return zzj(remove);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzea
    public final /* bridge */ /* synthetic */ zzea zzd(int i6) {
        if (i6 >= size()) {
            ArrayList arrayList = new ArrayList(i6);
            arrayList.addAll(this.zzc);
            return new zzeh(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzei
    public final zzei zze() {
        if (zzc()) {
            return new zzgi(this);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzei
    public final void zzi(zzcs zzcsVar) {
        zza();
        this.zzc.add(zzcsVar);
        ((AbstractList) this).modCount++;
    }

    private zzeh(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzeh(boolean z5) {
        super(false);
        this.zzc = Collections.EMPTY_LIST;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
