package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.FormatMethod;
import com.google.errorprone.annotations.FormatString;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public final class GmsLogger {
    private final String zza;

    @Nullable
    private final String zzb;

    @KeepForSdk
    public GmsLogger(@NonNull String str) {
        this(str, null);
    }

    @KeepForSdk
    public boolean canLogPii() {
        return false;
    }

    @KeepForSdk
    public void d(@NonNull String str, @NonNull String str2) {
        if (canLog(3)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void e(@NonNull String str, @NonNull String str2) {
        if (canLog(6)) {
            zza(str2);
        }
    }

    @KeepForSdk
    @FormatMethod
    public void efmt(@NonNull String str, @NonNull @FormatString String str2, @NonNull Object... objArr) {
        if (canLog(6)) {
            zzb(str2, objArr);
        }
    }

    @KeepForSdk
    public void i(@NonNull String str, @NonNull String str2) {
        if (canLog(4)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void pii(@NonNull String str, @NonNull String str2) {
    }

    @KeepForSdk
    public void v(@NonNull String str, @NonNull String str2) {
        if (canLog(2)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void w(@NonNull String str, @NonNull String str2) {
        if (canLog(5)) {
            zza(str2);
        }
    }

    @KeepForSdk
    @FormatMethod
    public void wfmt(@NonNull String str, @NonNull @FormatString String str2, @NonNull Object... objArr) {
        if (canLog(5)) {
            zzb(str2, objArr);
        }
    }

    @KeepForSdk
    public void wtf(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(7)) {
            zza(str2);
            Log.wtf(str, zza(str2), th);
        }
    }

    @KeepForSdk
    public GmsLogger(@NonNull String str, @Nullable String str2) {
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zza = str;
        this.zzb = (str2 == null || str2.length() <= 0) ? null : str2;
    }

    private final String zza(String str) {
        String str2 = this.zzb;
        return str2 == null ? str : str2.concat(str);
    }

    @FormatMethod
    private final String zzb(String str, Object... objArr) {
        String str2 = this.zzb;
        String format = String.format(str, objArr);
        return str2 == null ? format : str2.concat(format);
    }

    @KeepForSdk
    public boolean canLog(int i6) {
        return Log.isLoggable(this.zza, i6);
    }

    @KeepForSdk
    public void pii(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
    }

    @KeepForSdk
    public void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(3)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void e(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(6)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void i(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(4)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void v(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(2)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void w(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(5)) {
            zza(str2);
        }
    }
}
