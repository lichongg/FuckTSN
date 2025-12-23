package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzv extends zzx {
    private final Callable zze;

    /* synthetic */ zzv(Callable callable, zzu zzuVar) {
        super(false, 1, 5, null, null, null);
        this.zze = callable;
    }

    @Override // com.google.android.gms.common.zzx
    final String zza() {
        try {
            return (String) this.zze.call();
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }
}
