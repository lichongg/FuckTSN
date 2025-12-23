package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Set;
import java.util.logging.Level;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzcv implements zzcm {
    private final String zza;
    private final Level zzb;
    private final Set zzc;
    private final zzbq zzd;
    private final int zze;

    private zzcv(String str, boolean z5, int i6, Level level, boolean z6, Set set, zzbq zzbqVar) {
        this.zza = "";
        this.zze = 2;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zzbqVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private zzcv() {
        /*
            r8 = this;
            java.util.logging.Level r4 = java.util.logging.Level.ALL
            java.util.Set r6 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzcy.zzg()
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzbq r7 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzcy.zze()
            r3 = 2
            r5 = 0
            java.lang.String r1 = ""
            r2 = 1
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_mediapipe.zzcv.<init>():void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzcm
    public final zzbd zza(String str) {
        return new zzcy(this.zza, str, true, 2, this.zzb, this.zzc, this.zzd, null);
    }

    public final zzcv zzb(boolean z5) {
        Set set = this.zzc;
        zzbq zzbqVar = this.zzd;
        return new zzcv(this.zza, true, 2, Level.OFF, false, set, zzbqVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    /* synthetic */ zzcv(com.google.android.gms.internal.mlkit_vision_mediapipe.zzcu r9) {
        /*
            r8 = this;
            java.util.logging.Level r4 = java.util.logging.Level.ALL
            java.util.Set r6 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzcy.zzg()
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzbq r7 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzcy.zze()
            r3 = 2
            r5 = 0
            java.lang.String r1 = ""
            r2 = 1
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_mediapipe.zzcv.<init>(com.google.android.gms.internal.mlkit_vision_mediapipe.zzcu):void");
    }
}
