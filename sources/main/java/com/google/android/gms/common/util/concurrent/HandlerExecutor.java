package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzi;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class HandlerExecutor implements Executor {
    private final Handler zza;

    @Override // java.util.concurrent.Executor
    public final void execute(@NonNull Runnable runnable) {
        this.zza.post(runnable);
    }

    @KeepForSdk
    public HandlerExecutor(@NonNull Looper looper) {
        this.zza = new zzi(looper);
    }
}
