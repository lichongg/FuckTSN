package com.google.android.gms.internal.mlkit_common;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzaj extends zzab implements Set {

    @CheckForNull
    private transient zzaf zza;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    return containsAll(set);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzas iterator();

    public final zzaf zzf() {
        zzaf zzafVar = this.zza;
        if (zzafVar != null) {
            return zzafVar;
        }
        zzaf zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    zzaj() {
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzar.zza(this);
    }

    zzaf zzg() {
        Object[] array = toArray();
        int i6 = zzaf.zzd;
        return zzaf.zzg(array, array.length);
    }
}
