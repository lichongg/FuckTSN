package com.google.android.gms.internal.mlkit_vision_mediapipe;

import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzcy extends zzck {
    private static final Set zza;
    private static final zzbq zzb;
    private static final zzcv zzc;
    private final String zzd;
    private final Level zze;
    private final Set zzf;
    private final zzbq zzg;
    private final int zzh;

    static {
        Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzt.zza, zzau.zza, zzav.zza)));
        zza = unmodifiableSet;
        zzb = zzbt.zza(unmodifiableSet).zzd();
        zzc = new zzcv(null);
    }

    public static zzcv zzf() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbd
    public final void zzc(zzbb zzbbVar) {
        zzi(zzbbVar, this.zzd, 2, this.zze, this.zzf, this.zzg);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbd
    public final boolean zzd(Level level) {
        String str = this.zzd;
        int zzb2 = zzcp.zzb(level);
        return Log.isLoggable(str, zzb2) || Log.isLoggable("all", zzb2);
    }

    /* synthetic */ zzcy(String str, String str2, boolean z5, int i6, Level level, Set set, zzbq zzbqVar, zzcx zzcxVar) {
        super(str2);
        this.zzd = zzcp.zza("", str2, true);
        this.zzh = 2;
        this.zze = level;
        this.zzf = set;
        this.zzg = zzbqVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzi(zzbb zzbbVar, String str, int i6, Level level, Set set, zzbq zzbqVar) {
        boolean z5;
        Boolean bool = (Boolean) zzbbVar.zzh().zzc(zzav.zza);
        if (bool != null && bool.booleanValue()) {
            return;
        }
        zzce zzh = zzce.zzh(zzch.zzf(), zzbbVar.zzh());
        if (zzbbVar.zzk().intValue() < level.intValue()) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z5) {
            int i7 = zzci.zza;
            if (zzbbVar.zzi() == null && zzh.zza() <= set.size() && set.containsAll(zzh.zzb())) {
                zzbf.zza(zzbbVar.zzj());
                zzcp.zzb(zzbbVar.zzk());
            }
        }
        StringBuilder sb = new StringBuilder();
        if (zzbc.zza(2, zzbbVar.zzf(), sb)) {
            sb.append(" ");
        }
        if (z5 && zzbbVar.zzi() != null) {
            sb.append("(REDACTED) ");
            sb.append(zzbbVar.zzi().zzb());
        } else {
            zzaw.zzb(zzbbVar, sb);
            int i8 = zzci.zza;
            zzba zzbaVar = new zzba("[CONTEXT ", " ]", sb);
            zzh.zzc(zzbqVar, zzbaVar);
            zzbaVar.zzb();
        }
        zzcp.zzb(zzbbVar.zzk());
    }
}
