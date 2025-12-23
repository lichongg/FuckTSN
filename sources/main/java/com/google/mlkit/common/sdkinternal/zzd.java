package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.Cleaner;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzd extends PhantomReference implements Cleaner.Cleanable {
    private final Set zza;
    private final Runnable zzb;

    @Override // com.google.mlkit.common.sdkinternal.Cleaner.Cleanable
    public final void clean() {
        if (this.zza.remove(this)) {
            clear();
            this.zzb.run();
        }
    }

    /* synthetic */ zzd(Object obj, ReferenceQueue referenceQueue, Set set, Runnable runnable, zzc zzcVar) {
        super(obj, referenceQueue);
        this.zza = set;
        this.zzb = runnable;
    }
}
