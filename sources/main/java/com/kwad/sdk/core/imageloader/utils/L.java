package com.kwad.sdk.core.imageloader.utils;

import android.util.Log;
import com.kwad.sdk.core.imageloader.core.ImageLoader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class L {
    private static final String LOG_FORMAT = "%1$s\n%2$s";
    private static volatile boolean writeDebugLogs = false;
    private static volatile boolean writeLogs = true;

    @Deprecated
    public static void disableLogging() {
        writeLogs(false);
    }

    public static void e(Throwable th) {
        log(6, th, null, new Object[0]);
    }

    @Deprecated
    public static void enableLogging() {
        writeLogs(true);
    }

    public static void i(String str, Object... objArr) {
        log(4, null, str, objArr);
    }

    public static void w(String str, Object... objArr) {
        log(5, null, str, objArr);
    }

    public static void d(String str, Object... objArr) {
        if (writeDebugLogs) {
            log(3, null, str, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        log(6, null, str, objArr);
    }

    private static void log(int i6, Throwable th, String str, Object... objArr) {
        if (writeLogs) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format(LOG_FORMAT, str, Log.getStackTraceString(th));
            }
            Log.println(i6, ImageLoader.TAG, str);
        }
    }

    public static void writeDebugLogs(boolean z5) {
        writeDebugLogs = z5;
    }

    public static void writeLogs(boolean z5) {
        writeLogs = z5;
    }

    private L() {
    }

    public static void e(Throwable th, String str, Object... objArr) {
        log(6, th, str, objArr);
    }
}
