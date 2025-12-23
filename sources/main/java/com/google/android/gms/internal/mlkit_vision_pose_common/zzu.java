package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzu extends zzbm {
    final /* synthetic */ zzw zza;

    zzu(zzw zzwVar) {
        this.zza = zzwVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzbm, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        Set entrySet = this.zza.zza.entrySet();
        entrySet.getClass();
        try {
            return entrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzv(this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzbm
    final Map zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzbm, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Objects.requireNonNull(entry);
        zzw zzwVar = this.zza;
        zzae.zzk(zzwVar.zzb, entry.getKey());
        return true;
    }
}
