package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class ExecutorSelector {
    private final Provider zza;

    @NonNull
    @KeepForSdk
    public Executor getExecutorToUse(@Nullable Executor executor) {
        return executor != null ? executor : (Executor) this.zza.get();
    }

    public ExecutorSelector(@NonNull Provider provider) {
        this.zza = provider;
    }
}
