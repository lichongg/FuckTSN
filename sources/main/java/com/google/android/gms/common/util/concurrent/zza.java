package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zza implements Runnable {
    private final Runnable zza;

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.zza.run();
    }

    public zza(Runnable runnable, int i6) {
        this.zza = runnable;
    }
}
