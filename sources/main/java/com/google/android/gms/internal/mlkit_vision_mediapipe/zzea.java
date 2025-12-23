package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.io.Closeable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzea implements Closeable {
    private static final ThreadLocal zza = new zzdz();
    private int zzb = 0;

    public static int zza() {
        return ((zzea) zza.get()).zzb;
    }

    public static zzea zzc() {
        zzea zzeaVar = (zzea) zza.get();
        int i6 = zzeaVar.zzb + 1;
        zzeaVar.zzb = i6;
        if (i6 != 0) {
            return zzeaVar;
        }
        throw new AssertionError("Overflow of RecursionDepth (possible error in core library)");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i6 = this.zzb;
        if (i6 <= 0) {
            throw new AssertionError("Mismatched calls to RecursionDepth (possible error in core library)");
        }
        this.zzb = i6 - 1;
    }

    public final int zzb() {
        return this.zzb;
    }
}
