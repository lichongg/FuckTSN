package com.google.android.gms.internal.mlkit_vision_pose_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzwn implements zzwa {
    private final zzpq zza;
    private zztp zzb = new zztp();
    private final int zzc;

    public static zzwa zzf(zzpq zzpqVar) {
        return new zzwn(zzpqVar, 0);
    }

    public static zzwa zzg(zzpq zzpqVar, int i6) {
        return new zzwn(zzpqVar, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzwa
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzwa
    public final zzwa zzb(zzpp zzppVar) {
        this.zza.zzg(zzppVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzwa
    public final zzwa zzc(zztp zztpVar) {
        this.zzb = zztpVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzwa
    public final String zzd() {
        String zzk;
        zztr zzg = this.zza.zzl().zzg();
        return (zzg == null || (zzk = zzg.zzk()) == null || zzk.isEmpty()) ? "NA" : (String) Preconditions.checkNotNull(zzg.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzwa
    public final byte[] zze(int i6, boolean z5) {
        this.zzb.zzf(Boolean.valueOf(1 == (i6 ^ 1)));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzk(this.zzb.zzm());
        try {
            zzxq.zza();
            if (i6 == 0) {
                return new JsonDataEncoderBuilder().configureWith(zznk.zza).ignoreNullValues(true).build().encode(this.zza.zzl()).getBytes("utf-8");
            }
            zzps zzl = this.zza.zzl();
            zzcq zzcqVar = new zzcq();
            zznk.zza.configure(zzcqVar);
            return zzcqVar.zza().zza(zzl);
        } catch (UnsupportedEncodingException e6) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e6);
        }
    }

    private zzwn(zzpq zzpqVar, int i6) {
        this.zza = zzpqVar;
        zzxq.zza();
        this.zzc = i6;
    }
}
