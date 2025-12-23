package com.google.android.gms.common.api.internal;

import androidx.annotation.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zab extends ActivityLifecycleObserver {
    private final WeakReference zaa;

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    @CanIgnoreReturnValue
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        zaa zaaVar = (zaa) this.zaa.get();
        if (zaaVar == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        zaaVar.zac(runnable);
        return this;
    }

    @VisibleForTesting(otherwise = 2)
    zab(zaa zaaVar) {
        this.zaa = new WeakReference(zaaVar);
    }
}
