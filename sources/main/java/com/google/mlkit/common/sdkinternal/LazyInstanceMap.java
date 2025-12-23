package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class LazyInstanceMap<K, V> {

    @GuardedBy("instances")
    private final Map zza = new HashMap();

    @NonNull
    @KeepForSdk
    protected abstract V create(@NonNull K k6);

    @NonNull
    @KeepForSdk
    public V get(@NonNull K k6) {
        synchronized (this.zza) {
            try {
                if (this.zza.containsKey(k6)) {
                    return (V) this.zza.get(k6);
                }
                V create = create(k6);
                this.zza.put(k6, create);
                return create;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
