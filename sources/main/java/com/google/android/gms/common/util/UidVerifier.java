package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public final class UidVerifier {
    @KeepForSdk
    public static boolean isGooglePlayServicesUid(@NonNull Context context, int i6) {
        if (!uidHasPackageName(context, i6, "com.google.android.gms")) {
            return false;
        }
        try {
            return GoogleSignatureVerifier.getInstance(context).isGooglePublicSignedPackage(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            Log.isLoggable("UidVerifier", 3);
            return false;
        }
    }

    private UidVerifier() {
    }

    @KeepForSdk
    @TargetApi(19)
    public static boolean uidHasPackageName(@NonNull Context context, int i6, @NonNull String str) {
        return Wrappers.packageManager(context).zza(i6, str);
    }
}
