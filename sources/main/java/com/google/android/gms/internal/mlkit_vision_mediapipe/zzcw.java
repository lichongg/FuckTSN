package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Set;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzcw extends zzck {
    private final String zza;
    private final Level zzb;
    private final Set zzc;
    private final zzbq zzd;
    private final int zze;

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbd
    public final boolean zzd(Level level) {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcw(String str, @NullableDecl String str2, boolean z5, int i6, boolean z6, boolean z7) {
        super(str2);
        Set set;
        zzbq zzbqVar;
        Level level = Level.ALL;
        set = zzcy.zza;
        zzbqVar = zzcy.zzb;
        this.zza = "";
        this.zze = 2;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zzbqVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbd
    public final void zzc(zzbb zzbbVar) {
        String str = (String) zzbbVar.zzh().zzc(zzau.zza);
        if (str == null) {
            str = zza();
        }
        if (str == null) {
            str = zzbbVar.zzf().zzb();
            int indexOf = str.indexOf(36, str.lastIndexOf(46));
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
        }
        String str2 = this.zza;
        zzcy.zzi(zzbbVar, zzcp.zza(str2, str, true), 2, this.zzb, this.zzc, this.zzd);
    }
}
