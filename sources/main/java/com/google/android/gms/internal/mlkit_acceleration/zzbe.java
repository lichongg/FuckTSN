package com.google.android.gms.internal.mlkit_acceleration;

import com.google.android.gms.internal.mlkit_acceleration.zzaj;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbe extends zzaj.zzi implements Runnable {
    private final Runnable zzc;

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzc.run();
        } catch (Throwable th) {
            zzl(th);
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzaj
    protected final String zze() {
        return "task=[" + this.zzc.toString() + "]";
    }

    public zzbe(Runnable runnable) {
        runnable.getClass();
        this.zzc = runnable;
    }
}
