package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.content.Context;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzvs {
    private final zzwk zza;

    protected zzvs(zzwk zzwkVar) {
        this.zza = zzwkVar;
    }

    public zzvs(Context context) {
        this.zza = new zzwk(context, new SharedPrefManager(context), new zzwe(context, zzwd.zzd("shared-installation-id").zzd()), "shared-installation-id");
    }

    protected final void zza(zzpp zzppVar, zzvr zzvrVar) {
        zzpq zzpqVar = new zzpq();
        zzpqVar.zzj(zzvrVar.zza().zzi());
        this.zza.zze(zzwn.zzf(zzpqVar), zzppVar, "o:a:mlkit:1.0.0");
    }
}
