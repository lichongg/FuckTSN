package tv.danmaku.ijk.media.player.pragma;

import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DebugLog {
    public static final boolean ENABLE_DEBUG = true;
    public static final boolean ENABLE_ERROR = true;
    public static final boolean ENABLE_INFO = true;
    public static final boolean ENABLE_VERBOSE = true;
    public static final boolean ENABLE_WARN = true;

    public static void d(String str, String str2) {
    }

    public static void e(String str, String str2) {
    }

    public static void i(String str, String str2) {
    }

    public static void v(String str, String str2) {
    }

    public static void w(String str, String str2) {
    }

    public static void d(String str, String str2, Throwable th) {
    }

    public static void dfmt(String str, String str2, Object... objArr) {
        String.format(Locale.US, str2, objArr);
    }

    public static void e(String str, String str2, Throwable th) {
    }

    public static void efmt(String str, String str2, Object... objArr) {
        String.format(Locale.US, str2, objArr);
    }

    public static void i(String str, String str2, Throwable th) {
    }

    public static void ifmt(String str, String str2, Object... objArr) {
        String.format(Locale.US, str2, objArr);
    }

    public static void v(String str, String str2, Throwable th) {
    }

    public static void vfmt(String str, String str2, Object... objArr) {
        String.format(Locale.US, str2, objArr);
    }

    public static void w(String str, String str2, Throwable th) {
    }

    public static void wfmt(String str, String str2, Object... objArr) {
        String.format(Locale.US, str2, objArr);
    }

    public static void printCause(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        printStackTrace(th);
    }

    public static void printStackTrace(Throwable th) {
        th.printStackTrace();
    }
}
