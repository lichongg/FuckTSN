package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jspecify.nullness.NullMarked;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@NullMarked
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzx {
    private final zzo zza;
    private final boolean zzb;
    private final zzu zzc;

    public static zzx zzc(zzo zzoVar) {
        return new zzx(new zzu(zzoVar), false, zzn.zza, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator zzh(CharSequence charSequence) {
        return new zzt(this.zzc, this, charSequence);
    }

    public final zzx zzb() {
        return new zzx(this.zzc, true, this.zza, Integer.MAX_VALUE);
    }

    public final Iterable zzd(CharSequence charSequence) {
        return new zzv(this, charSequence);
    }

    private zzx(zzu zzuVar, boolean z5, zzo zzoVar, int i6) {
        this.zzc = zzuVar;
        this.zzb = z5;
        this.zza = zzoVar;
    }

    public final List zzf(CharSequence charSequence) {
        charSequence.getClass();
        Iterator zzh = zzh(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzh.hasNext()) {
            arrayList.add((String) zzh.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
