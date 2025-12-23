package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@CheckReturnValue
/* loaded from: D:\Downloads\app\classes5.dex */
class zzx {
    private static final zzx zze = new zzx(true, 3, 1, null, null);
    final boolean zza;

    @Nullable
    final String zzb;

    @Nullable
    final Throwable zzc;
    final int zzd;

    private zzx(boolean z5, int i6, int i7, @Nullable String str, @Nullable Throwable th) {
        this.zza = z5;
        this.zzd = i6;
        this.zzb = str;
        this.zzc = th;
    }

    /* synthetic */ zzx(boolean z5, int i6, int i7, String str, Throwable th, zzw zzwVar) {
        this(false, 1, 5, null, null);
    }

    @Deprecated
    static zzx zzb() {
        return zze;
    }

    static zzx zzc(@NonNull String str) {
        return new zzx(false, 1, 5, str, null);
    }

    static zzx zzd(@NonNull String str, @NonNull Throwable th) {
        return new zzx(false, 1, 5, str, th);
    }

    static zzx zzf(int i6) {
        return new zzx(true, i6, 1, null, null);
    }

    static zzx zzg(int i6, int i7, @NonNull String str, @Nullable Throwable th) {
        return new zzx(false, i6, i7, str, th);
    }

    @Nullable
    String zza() {
        return this.zzb;
    }

    final void zze() {
        if (this.zza || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.zzc != null) {
            zza();
        } else {
            zza();
        }
    }
}
