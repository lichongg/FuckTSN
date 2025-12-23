package com.google.android.gms.internal.mlkit_acceleration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzdi {
    static final zzdi zza = new zzdi(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc;
    private final Map zzd;

    zzdi() {
        this.zzd = new HashMap();
    }

    public static zzdi zza() {
        return zza;
    }

    public final zzdt zzb(zzfa zzfaVar, int i6) {
        return (zzdt) this.zzd.get(new zzdh(zzfaVar, i6));
    }

    zzdi(boolean z5) {
        this.zzd = Collections.EMPTY_MAP;
    }
}
