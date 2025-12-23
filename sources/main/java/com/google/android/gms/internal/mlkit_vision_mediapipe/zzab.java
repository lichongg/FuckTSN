package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzab implements Runnable {
    final /* synthetic */ zzaa zza;
    final /* synthetic */ zzac zzb;

    zzab(zzac zzacVar, zzaa zzaaVar) {
        this.zza = zzaaVar;
        this.zzb = zzacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentHashMap concurrentHashMap;
        concurrentHashMap = this.zzb.zza;
        concurrentHashMap.remove(this.zza);
    }
}
