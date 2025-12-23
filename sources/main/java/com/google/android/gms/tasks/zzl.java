package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzl implements zzq {
    private final Executor zza;
    private final Object zzb = new Object();

    @Nullable
    private OnFailureListener zzc;

    @Override // com.google.android.gms.tasks.zzq
    public final void zzc() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }

    public zzl(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zza = executor;
        this.zzc = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(@NonNull Task task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            synchronized (this.zzb) {
                try {
                    if (this.zzc == null) {
                        return;
                    }
                    this.zza.execute(new zzk(this, task));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
