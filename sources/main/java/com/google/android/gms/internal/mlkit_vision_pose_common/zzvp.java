package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzvp {

    @Nullable
    private static zzvp zza;
    private final zzvn zzb;
    private final zzvu zzc;
    private final zzvs zzd;

    @Nullable
    private zzvv zze;

    public static synchronized zzvp zzb(Context context) {
        zzvp zzvpVar;
        synchronized (zzvp.class) {
            try {
                if (zza == null) {
                    zza = new zzvp(context, zzvw.zza);
                }
                zzvpVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzvpVar;
    }

    public final zzvk zza() {
        Preconditions.checkState(this.zze != null);
        return this.zze.zzb();
    }

    public final String zzc() throws InterruptedException {
        Preconditions.checkState(this.zze != null);
        Preconditions.checkState(this.zze != null);
        if (this.zze.zze()) {
            zzvr zzvrVar = new zzvr();
            zzvrVar.zzg();
            try {
                if (this.zzb.zzc(zzvrVar)) {
                    this.zze = this.zzb.zza();
                }
            } finally {
                zzvrVar.zze();
                this.zzd.zza(zzpp.INSTALLATION_ID_REFRESH_TEMPORARY_TOKEN, zzvrVar);
            }
        }
        Preconditions.checkState(this.zze != null);
        return this.zze.zzd();
    }

    public final void zzd() throws IOException, InterruptedException {
        zzvs zzvsVar;
        zzvr zzvrVar = new zzvr();
        zzvrVar.zzg();
        try {
            zzvv zza2 = this.zzc.zza(zzvrVar);
            if (zza2 != null) {
                this.zze = zza2;
            } else {
                final zzvr zzvrVar2 = new zzvr();
                zzvrVar2.zzg();
                try {
                    int i6 = zzvq.zzb;
                    byte[] bArr = new byte[17];
                    zzvq.zza.nextBytes(bArr);
                    bArr[0] = (byte) ((bArr[0] & 15) | 112);
                    String substring = Base64.encodeToString(bArr, 11).substring(0, 22);
                    "Generated installation id: ".concat(String.valueOf(substring));
                    final zzvk zzvkVar = new zzvk(substring);
                    final zzvn zzvnVar = this.zzb;
                    if (zzxo.zza(new zzxn() { // from class: com.google.android.gms.internal.mlkit_vision_pose_common.zzvm
                        @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzxn
                        public final boolean zza() {
                            System.out.getClass();
                            return false;
                        }
                    })) {
                        zzvv zza3 = this.zzb.zza();
                        this.zze = zza3;
                        if (zza3 != null) {
                            this.zzc.zzc(zza3, zzvrVar2);
                        }
                        zzvrVar2.zze();
                        zzvsVar = this.zzd;
                    } else {
                        zzvrVar2.zzd(zztd.RPC_EXPONENTIAL_BACKOFF_FAILED);
                        zzvrVar2.zzd(zztd.RPC_ERROR);
                        zzvrVar2.zze();
                        zzvsVar = this.zzd;
                    }
                    zzvsVar.zza(zzpp.INSTALLATION_ID_REGISTER_NEW_ID, zzvrVar2);
                } catch (Throwable th) {
                    zzvrVar2.zze();
                    this.zzd.zza(zzpp.INSTALLATION_ID_REGISTER_NEW_ID, zzvrVar2);
                    throw th;
                }
            }
            zzvrVar.zze();
            this.zzd.zza(zzpp.INSTALLATION_ID_INIT, zzvrVar);
        } catch (Throwable th2) {
            zzvrVar.zze();
            this.zzd.zza(zzpp.INSTALLATION_ID_INIT, zzvrVar);
            throw th2;
        }
    }

    @VisibleForTesting
    public zzvp(Context context, zzvo zzvoVar) {
        zzvs zzvsVar = new zzvs(context);
        this.zzd = zzvsVar;
        this.zzc = new zzvu(context);
        this.zzb = new zzvn(zzvoVar, zzvsVar);
    }
}
