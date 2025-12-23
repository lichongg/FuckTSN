package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzbh extends zzay implements Set {

    @CheckForNull
    private transient zzbd zza;

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

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzay, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzcc iterator();

    public final zzbd zzf() {
        zzbd zzbdVar = this.zza;
        if (zzbdVar != null) {
            return zzbdVar;
        }
        zzbd zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    zzbh() {
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzca.zza(this);
    }

    zzbd zzg() {
        Object[] array = toArray();
        int i6 = zzbd.zzd;
        return zzbd.zzg(array, array.length);
    }
}
