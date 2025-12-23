package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.FormatMethod;
import com.google.errorprone.annotations.FormatString;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Preconditions {
    @KeepForSdk
    public static void checkArgument(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    @KeepForSdk
    public static double checkArgumentInRange(double d6, double d7, double d8, @NonNull String str) {
        if (d6 < d7) {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d7), Double.valueOf(d8)));
        }
        if (d6 <= d8) {
            return d6;
        }
        throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d7), Double.valueOf(d8)));
    }

    @KeepForSdk
    public static void checkHandlerThread(@NonNull Handler handler) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            String name = myLooper != null ? myLooper.getThread().getName() : "null current looper";
            throw new IllegalStateException("Must be called on " + handler.getLooper().getThread().getName() + " thread, but got " + name + ".");
        }
    }

    @KeepForSdk
    public static void checkMainThread() {
        checkMainThread("Must be called on the main application thread");
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    @CanIgnoreReturnValue
    @KeepForSdk
    public static String checkNotEmpty(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    @KeepForSdk
    public static void checkNotGoogleApiHandlerThread() {
        checkNotGoogleApiHandlerThread("Must not be called on GoogleApiHandler thread.");
    }

    @KeepForSdk
    public static void checkNotMainThread() {
        checkNotMainThread("Must not be called on the main application thread");
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    @CanIgnoreReturnValue
    @KeepForSdk
    public static <T> T checkNotNull(@Nullable T t5) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException("null reference");
    }

    @CanIgnoreReturnValue
    @KeepForSdk
    public static int checkNotZero(int i6) {
        if (i6 != 0) {
            return i6;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    @KeepForSdk
    public static void checkState(boolean z5) {
        if (!z5) {
            throw new IllegalStateException();
        }
    }

    @KeepForSdk
    public static void checkArgument(boolean z5, @NonNull Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @KeepForSdk
    public static void checkMainThread(@NonNull String str) {
        if (!com.google.android.gms.common.util.zzb.zza()) {
            throw new IllegalStateException(str);
        }
    }

    @KeepForSdk
    public static void checkNotGoogleApiHandlerThread(@NonNull String str) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            String name = myLooper.getThread().getName();
            if (name == "GoogleApiHandler" || (name != null && name.equals("GoogleApiHandler"))) {
                throw new IllegalStateException(str);
            }
        }
    }

    @KeepForSdk
    public static void checkNotMainThread(@NonNull String str) {
        if (com.google.android.gms.common.util.zzb.zza()) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    @CanIgnoreReturnValue
    @KeepForSdk
    public static <T> T checkNotNull(@NonNull T t5, @NonNull Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    @KeepForSdk
    public static int checkNotZero(int i6, @NonNull Object obj) {
        if (i6 != 0) {
            return i6;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    public static void checkState(boolean z5, @NonNull Object obj) {
        if (!z5) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    private Preconditions() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static void checkArgument(boolean z5, @NonNull String str, @NonNull Object... objArr) {
        if (!z5) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    @CanIgnoreReturnValue
    @KeepForSdk
    public static String checkNotEmpty(@Nullable String str, @NonNull Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    @CanIgnoreReturnValue
    @KeepForSdk
    public static long checkNotZero(long j6) {
        if (j6 != 0) {
            return j6;
        }
        throw new IllegalArgumentException("Given Long is zero");
    }

    @KeepForSdk
    @FormatMethod
    public static void checkState(boolean z5, @NonNull @FormatString String str, @NonNull Object... objArr) {
        if (!z5) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    static String zza(String str, Object... objArr) {
        int indexOf;
        StringBuilder sb = new StringBuilder(str.length() + 48);
        int i6 = 0;
        int i7 = 0;
        while (i6 < 3 && (indexOf = str.indexOf("%s", i7)) != -1) {
            sb.append(str.substring(i7, indexOf));
            sb.append(objArr[i6]);
            i7 = indexOf + 2;
            i6++;
        }
        sb.append(str.substring(i7));
        if (i6 < 3) {
            sb.append(" [");
            sb.append(objArr[i6]);
            for (int i8 = i6 + 1; i8 < 3; i8++) {
                sb.append(", ");
                sb.append(objArr[i8]);
            }
            sb.append("]");
        }
        return sb.toString();
    }

    @KeepForSdk
    public static float checkArgumentInRange(float f6, float f7, float f8, @NonNull String str) {
        if (f6 < f7) {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f7), Float.valueOf(f8)));
        }
        if (f6 <= f8) {
            return f6;
        }
        throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f7), Float.valueOf(f8)));
    }

    @CanIgnoreReturnValue
    @KeepForSdk
    public static long checkNotZero(long j6, @NonNull Object obj) {
        if (j6 != 0) {
            return j6;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    @KeepForSdk
    public static int checkArgumentInRange(int i6, int i7, int i8, @NonNull String str) {
        if (i6 < i7) {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i7), Integer.valueOf(i8)));
        }
        if (i6 <= i8) {
            return i6;
        }
        throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i7), Integer.valueOf(i8)));
    }

    @KeepForSdk
    public static void checkHandlerThread(@NonNull Handler handler, @NonNull String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    @KeepForSdk
    public static long checkArgumentInRange(long j6, long j7, long j8, @NonNull String str) {
        if (j6 < j7) {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j7), Long.valueOf(j8)));
        }
        if (j6 <= j8) {
            return j6;
        }
        throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j7), Long.valueOf(j8)));
    }
}
