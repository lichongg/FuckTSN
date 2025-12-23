package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.net.HttpURLConnection;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzxe implements zzxn {
    final /* synthetic */ zzxf zza;
    private final String zzb;
    private final Date zzc;
    private final zzvr zzd;
    private zzbg zze;
    private zzwy zzf;

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzxn
    public final boolean zza() throws zzxh {
        zzwz zzwzVar;
        zzwz zzwzVar2;
        zzvp zzvpVar;
        String str;
        zzbg zzm;
        try {
            zzwzVar = this.zza.zzh;
            HttpURLConnection zzb = zzwzVar.zzb();
            zzxf zzxfVar = this.zza;
            zzwzVar2 = zzxfVar.zzh;
            zzvpVar = zzxfVar.zzg;
            String zza = zzvpVar.zza().zza();
            String str2 = this.zzb;
            Date date = this.zzc;
            zzxf zzxfVar2 = this.zza;
            zzvr zzvrVar = this.zzd;
            zzbg zzc = zzbg.zzc();
            zzbg zzc2 = zzbg.zzc();
            str = zzxfVar2.zzn;
            zzwy zza2 = zzwzVar2.zza(zzb, zza, str2, zzc, null, zzc2, date, "o:a:mlkit:1.0.0", str, zzvrVar).zza();
            this.zzf = zza2;
            JSONObject zzc3 = zza2.zzc();
            try {
                zzm = zzxf.zzm(zzc3);
                this.zze = zzm;
                return true;
            } catch (JSONException unused) {
                this.zzd.zzb(zztd.RPC_RETURNED_MALFORMED_RESULT);
                "Fetched remote config setting has invalid format: ".concat(String.valueOf(zzc3));
                return false;
            }
        } catch (zzxh unused2) {
            this.zzd.zzb(zztd.NO_CONNECTION);
            return false;
        }
    }

    zzxe(zzxf zzxfVar, String str, Date date, zzvr zzvrVar) {
        this.zza = zzxfVar;
        this.zzb = str;
        this.zzc = date;
        this.zzd = zzvrVar;
    }

    public final zzbg zzb() {
        return this.zze;
    }

    public final zzwy zzc() {
        return this.zzf;
    }
}
