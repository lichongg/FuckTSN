package androidx.camera.core;

import android.os.Build;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public final class Logger {
    static final int DEFAULT_MIN_LOG_LEVEL = 3;
    private static final int MAX_TAG_LENGTH = 23;
    private static int sMinLogLevel = 3;

    public static void d(@NonNull String str, @NonNull String str2) {
        isLogLevelEnabled(truncateTag(str), 3);
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        isLogLevelEnabled(truncateTag(str), 6);
    }

    public static void i(@NonNull String str, @NonNull String str2) {
        isLogLevelEnabled(truncateTag(str), 4);
    }

    static void resetMinLogLevel() {
        sMinLogLevel = 3;
    }

    public static void w(@NonNull String str, @NonNull String str2) {
        isLogLevelEnabled(truncateTag(str), 5);
    }

    static int getMinLogLevel() {
        return sMinLogLevel;
    }

    private static boolean isLogLevelEnabled(@NonNull String str, int i6) {
        return sMinLogLevel <= i6 || Log.isLoggable(str, i6);
    }

    static void setMinLogLevel(@IntRange(from = 3, to = 6) int i6) {
        sMinLogLevel = i6;
    }

    @NonNull
    private static String truncateTag(@NonNull String str) {
        return (Build.VERSION.SDK_INT > 25 || 23 >= str.length()) ? str : str.substring(0, 23);
    }

    private Logger() {
    }

    public static void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        isLogLevelEnabled(truncateTag(str), 3);
    }

    public static void e(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        isLogLevelEnabled(truncateTag(str), 6);
    }

    public static void i(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        isLogLevelEnabled(truncateTag(str), 4);
    }

    public static boolean isDebugEnabled(@NonNull String str) {
        return isLogLevelEnabled(truncateTag(str), 3);
    }

    public static boolean isErrorEnabled(@NonNull String str) {
        return isLogLevelEnabled(truncateTag(str), 6);
    }

    public static boolean isInfoEnabled(@NonNull String str) {
        return isLogLevelEnabled(truncateTag(str), 4);
    }

    public static boolean isWarnEnabled(@NonNull String str) {
        return isLogLevelEnabled(truncateTag(str), 5);
    }

    public static void w(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        isLogLevelEnabled(truncateTag(str), 5);
    }
}
