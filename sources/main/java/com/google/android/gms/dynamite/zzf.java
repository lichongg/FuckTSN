package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzf implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int zzb = iVersions.zzb(context, str, true);
        selectionResult.remoteVersion = zzb;
        if (zzb != 0) {
            selectionResult.selection = 1;
            return selectionResult;
        }
        int zza = iVersions.zza(context, str);
        selectionResult.localVersion = zza;
        if (zza != 0) {
            selectionResult.selection = -1;
        }
        return selectionResult;
    }

    zzf() {
    }
}
