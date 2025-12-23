package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzmu {
    @WorkerThread
    public static void zza(zzmj zzmjVar, int i6, int i7, long j6, int i8, int i9, int i10, int i11) {
        zzmjVar.zzc(zzc(i6, i7, j6, i8, i9, i10, i11), zziv.INPUT_IMAGE_CONSTRUCTION);
    }

    @WorkerThread
    public static void zzb(zzmj zzmjVar, int i6, int i7, long j6, int i8, int i9, int i10, int i11) {
        zzmjVar.zzc(zzc(i6, i7, j6, i8, i9, i10, i11), zziv.ODML_IMAGE);
    }

    private static zzmt zzc(int i6, int i7, long j6, int i8, int i9, int i10, int i11) {
        return new zzmt(i6, i7, i10, i8, i9, SystemClock.elapsedRealtime() - j6, i11);
    }
}
