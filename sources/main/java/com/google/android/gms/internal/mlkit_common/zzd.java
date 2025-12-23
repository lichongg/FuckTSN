package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import androidx.core.content.PermissionChecker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzd extends zzk {
    @Override // com.google.android.gms.internal.mlkit_common.zzk
    protected final int zza(Context context, zzj zzjVar, boolean z5) {
        return (zzjVar.zza.getAuthority().lastIndexOf(64) < 0 || PermissionChecker.checkSelfPermission(context, "android.permission.INTERACT_ACROSS_USERS") != 0) ? 3 : 2;
    }

    zzd() {
    }
}
