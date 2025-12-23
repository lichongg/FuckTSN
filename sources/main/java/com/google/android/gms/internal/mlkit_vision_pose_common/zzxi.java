package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.content.Context;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzxi extends zzvs {
    public zzxi(Context context) {
        super(new zzwk(context, new SharedPrefManager(context), new zzwe(context, zzwd.zzd("shared-remote-config").zzd()), "shared-remote-config"));
    }

    public final void zzb(zzvr zzvrVar) {
        zza(zzpp.REMOTE_CONFIG_ACTIVATE, zzvrVar);
    }

    public final void zzc(zzvr zzvrVar) {
        zza(zzpp.REMOTE_CONFIG_FETCH, zzvrVar);
    }

    public final void zzd(zzvr zzvrVar) {
        zza(zzpp.REMOTE_CONFIG_FRC_FETCH, zzvrVar);
    }

    public final void zze(zzvr zzvrVar) {
        zza(zzpp.REMOTE_CONFIG_LOAD, zzvrVar);
    }
}
