package com.google.android.gms.common;

import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@CheckReturnValue
/* loaded from: D:\Downloads\app\classes5.dex */
public class PackageVerificationResult {
    private final String zza;
    private final boolean zzb;

    @Nullable
    private final String zzc;

    @Nullable
    private final Throwable zzd;

    @NonNull
    public static PackageVerificationResult zza(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        return new PackageVerificationResult(str, 1, false, str2, th);
    }

    @NonNull
    public static PackageVerificationResult zzd(@NonNull String str, int i6) {
        return new PackageVerificationResult(str, i6, true, null, null);
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        String str = this.zzc;
        Throwable th = this.zzd;
        String concat = "PackageVerificationRslt: ".concat(String.valueOf(str));
        if (th == null) {
            throw new SecurityException(concat);
        }
        throw new SecurityException(concat, th);
    }

    public final boolean zzc() {
        return this.zzb;
    }

    private PackageVerificationResult(String str, int i6, boolean z5, @Nullable String str2, @Nullable Throwable th) {
        this.zza = str;
        this.zzb = z5;
        this.zzc = str2;
        this.zzd = th;
    }
}
