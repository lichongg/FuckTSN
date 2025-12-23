package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public final class Preconditions {
    public static void checkArgument(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkArgumentInRange(int i6, int i7, int i8, @NonNull String str) {
        if (i6 < i7) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i7), Integer.valueOf(i8)));
        }
        if (i6 <= i8) {
            return i6;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i7), Integer.valueOf(i8)));
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i6, @Nullable String str) {
        if (i6 >= 0) {
            return i6;
        }
        throw new IllegalArgumentException(str);
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t5) {
        t5.getClass();
        return t5;
    }

    public static void checkState(boolean z5, @Nullable String str) {
        if (!z5) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t5) {
        if (TextUtils.isEmpty(t5)) {
            throw new IllegalArgumentException();
        }
        return t5;
    }

    public static void checkArgument(boolean z5, @NonNull Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i6) {
        if (i6 >= 0) {
            return i6;
        }
        throw new IllegalArgumentException();
    }

    public static int checkFlagsArgument(int i6, int i7) {
        if ((i6 & i7) == i6) {
            return i6;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i6) + ", but only 0x" + Integer.toHexString(i7) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t5, @NonNull Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z5) {
        checkState(z5, null);
    }

    private Preconditions() {
    }

    public static void checkArgument(boolean z5, @NonNull String str, @NonNull Object... objArr) {
        if (!z5) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static float checkArgumentFinite(float f6, @NonNull String str) {
        if (!Float.isNaN(f6)) {
            if (!Float.isInfinite(f6)) {
                return f6;
            }
            throw new IllegalArgumentException(str + " must not be infinite");
        }
        throw new IllegalArgumentException(str + " must not be NaN");
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t5, @NonNull Object obj) {
        if (TextUtils.isEmpty(t5)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t5;
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t5, @NonNull String str, @NonNull Object... objArr) {
        if (TextUtils.isEmpty(t5)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t5;
    }

    public static long checkArgumentInRange(long j6, long j7, long j8, @NonNull String str) {
        if (j6 < j7) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j7), Long.valueOf(j8)));
        }
        if (j6 <= j8) {
            return j6;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j7), Long.valueOf(j8)));
    }

    public static float checkArgumentInRange(float f6, float f7, float f8, @NonNull String str) {
        if (f6 < f7) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f7), Float.valueOf(f8)));
        }
        if (f6 <= f8) {
            return f6;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f7), Float.valueOf(f8)));
    }

    public static double checkArgumentInRange(double d6, double d7, double d8, @NonNull String str) {
        if (d6 < d7) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d7), Double.valueOf(d8)));
        }
        if (d6 <= d8) {
            return d6;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d7), Double.valueOf(d8)));
    }
}
