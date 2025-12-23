package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTaskInput;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class MLTask<T, S extends MLTaskInput> extends ModelResource {
    public MLTask() {
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public abstract T run(@NonNull S s5) throws MlKitException;

    @KeepForSdk
    protected MLTask(@NonNull TaskQueue taskQueue) {
        super(taskQueue);
    }
}
