package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.logging.Level;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzv implements zzaf, zzbb {
    private static final String zza = new String();
    private final Level zzb;
    private final long zzc;
    private zzu zzd;
    private zzz zze;
    private zzao zzf;
    private zzcj zzg;
    private Object[] zzh;

    protected abstract zzdu zza();

    protected abstract zzd zzc();

    protected abstract zzaf zzd();

    private final void zzr(String str, Object... objArr) {
        this.zzh = objArr;
        for (int i6 = 0; i6 < objArr.length; i6++) {
            Object obj = objArr[i6];
            if (obj instanceof zzq) {
                objArr[i6] = ((zzq) obj).zza();
            }
        }
        if (str != zza) {
            this.zzg = new zzcj(zza(), str);
        }
        zzdl zzk = zzch.zzk();
        if (!zzk.zze()) {
            zzbh zzh = zzh();
            zzai zzaiVar = zzt.zzh;
            zzdl zzdlVar = (zzdl) zzh.zzc(zzaiVar);
            if (zzdlVar != null) {
                zzk = zzk.zzb(zzdlVar);
            }
            zzl(zzaiVar, zzk);
        }
        zzc().zze(this);
    }

    private final boolean zzs() {
        if (this.zze == null) {
            this.zze = zzch.zzg().zza(zzv.class, 1);
        }
        zzaa zzaaVar = this.zze;
        if (zzaaVar != zzz.zza) {
            zzu zzuVar = this.zzd;
            if (zzuVar != null && zzuVar.zza() > 0) {
                zzdy.zza(zzaaVar, "logSiteKey");
                int zza2 = zzuVar.zza();
                for (int i6 = 0; i6 < zza2; i6++) {
                    if (zzt.zzf.equals(zzuVar.zzb(i6))) {
                        Object zzd = zzuVar.zzd(i6);
                        zzaaVar = zzd instanceof zzag ? ((zzag) zzd).zzb() : zzas.zza(zzaaVar, zzd);
                    }
                }
            }
        } else {
            zzaaVar = null;
        }
        boolean zzb = zzb(zzaaVar);
        zzao zzaoVar = this.zzf;
        if (zzaoVar == null) {
            return zzb;
        }
        int zza3 = zzan.zza(zzaoVar, zzaaVar, this.zzd);
        if (zzb && zza3 > 0) {
            this.zzd.zze(zzt.zze, Integer.valueOf(zza3));
        }
        return zzb & (zza3 >= 0);
    }

    protected boolean zzb(@NullableDecl zzaa zzaaVar) {
        zzu zzuVar = this.zzd;
        if (zzuVar != null) {
            if (zzaaVar != null) {
                zzao zzc = zzao.zzc(zzao.zzc(zzi.zza(zzuVar, zzaaVar, this.zzc), zzf.zza(this.zzd, zzaaVar)), zzar.zza(this.zzd, zzaaVar));
                this.zzf = zzc;
                if (zzc == zzao.zzc) {
                    return false;
                }
            }
            zzu zzuVar2 = this.zzd;
            zzai zzaiVar = zzt.zzi;
            zzat zzatVar = (zzat) zzuVar2.zzc(zzaiVar);
            if (zzatVar != null) {
                zzu zzuVar3 = this.zzd;
                if (zzuVar3 != null) {
                    zzuVar3.zzf(zzaiVar);
                }
                zzbh zzh = zzh();
                zzai zzaiVar2 = zzt.zza;
                zzl(zzaiVar2, new zzad((Throwable) zzh.zzc(zzaiVar2), zzatVar, zzdx.zzb(zzv.class, zzatVar.zza(), 1)));
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbb
    public final long zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbb
    public final zzz zzf() {
        zzz zzzVar = this.zze;
        if (zzzVar != null) {
            return zzzVar;
        }
        throw new IllegalStateException("cannot request log site information prior to postProcess()");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzaf
    public final zzaf zzg(String str, String str2, int i6, @NullableDecl String str3) {
        zzy zzyVar = new zzy("com/google/mediapipe/framework/Graph", str2, i6, "Graph.java", null);
        if (this.zze == null) {
            this.zze = zzyVar;
        }
        return zzd();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbb
    public final zzbh zzh() {
        zzu zzuVar = this.zzd;
        return zzuVar != null ? zzuVar : zzbh.zzg();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbb
    @NullableDecl
    public final zzcj zzi() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbb
    public final Object zzj() {
        if (this.zzg == null) {
            return this.zzh[0];
        }
        throw new IllegalStateException("cannot get literal argument if a template context exists");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbb
    public final Level zzk() {
        return this.zzb;
    }

    protected final void zzl(zzai zzaiVar, Object obj) {
        if (this.zzd == null) {
            this.zzd = new zzu();
        }
        this.zzd.zze(zzaiVar, obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbb
    public final boolean zzp() {
        zzu zzuVar = this.zzd;
        return zzuVar != null && Boolean.TRUE.equals(zzuVar.zzc(zzt.zzg));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbb
    public final Object[] zzq() {
        if (this.zzg != null) {
            return this.zzh;
        }
        throw new IllegalStateException("cannot get arguments unless a template context exists");
    }

    protected zzv(Level level, boolean z5) {
        long zzb = zzch.zzb();
        this.zzd = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
        this.zzh = null;
        zzdy.zza(level, "level");
        this.zzb = level;
        this.zzc = zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzaf
    public final void zzm(String str) {
        if (zzs()) {
            zzr(zza, "MediaPipe graph won't start until all stream headers are available.");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzaf
    public final void zzn(String str, @NullableDecl Object obj) {
        if (zzs()) {
            zzr("Stream: %s might be missing.", obj);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzaf
    public final void zzo(String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (zzs()) {
            zzr("AddPacket for stream: %s failed: %s.", obj, obj2);
        }
    }
}
