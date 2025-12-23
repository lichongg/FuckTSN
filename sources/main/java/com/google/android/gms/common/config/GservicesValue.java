package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class GservicesValue<T> {
    private static final Object zzc = new Object();

    @NonNull
    protected final String zza;

    @NonNull
    protected final Object zzb;

    @Nullable
    private Object zzd = null;

    @NonNull
    @KeepForSdk
    public static GservicesValue<Float> value(@NonNull String str, @NonNull Float f6) {
        return new zzd(str, f6);
    }

    @KeepForSdk
    @VisibleForTesting
    public void resetOverride() {
        this.zzd = null;
    }

    @NonNull
    protected abstract Object zza(@NonNull String str);

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static boolean isInitialized() {
        synchronized (zzc) {
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Integer> value(@NonNull String str, @NonNull Integer num) {
        return new zzc(str, num);
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public final T get() {
        T t5;
        T t6 = (T) this.zzd;
        if (t6 != null) {
            return t6;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        Object obj = zzc;
        synchronized (obj) {
        }
        synchronized (obj) {
            try {
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        try {
            t5 = (T) zza(this.zza);
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                t5 = (T) zza(this.zza);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return t5;
    }

    @KeepForSdk
    @VisibleForTesting
    public void override(@NonNull T t5) {
        this.zzd = t5;
        Object obj = zzc;
        synchronized (obj) {
            synchronized (obj) {
            }
        }
    }

    protected GservicesValue(@NonNull String str, @NonNull Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Long> value(@NonNull String str, @NonNull Long l6) {
        return new zzb(str, l6);
    }

    @NonNull
    @Deprecated
    @InlineMe(replacement = "this.get()")
    @KeepForSdk
    public final T getBinderSafe() {
        return get();
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<String> value(@NonNull String str, @NonNull String str2) {
        return new zze(str, str2);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Boolean> value(@NonNull String str, boolean z5) {
        return new zza(str, Boolean.valueOf(z5));
    }
}
