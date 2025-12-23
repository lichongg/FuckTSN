package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzkb {
    static final zzkb zza = new zzkb(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc;
    private final Map zzd;

    zzkb() {
        this.zzd = new HashMap();
    }

    zzkb(boolean z5) {
        this.zzd = Collections.EMPTY_MAP;
    }

    public static zzkb zza() {
        int i6 = zzmf.zza;
        return zza;
    }

    public final zzkp zzb(zzlw zzlwVar, int i6) {
        return (zzkp) this.zzd.get(new zzka(zzlwVar, i6));
    }
}
