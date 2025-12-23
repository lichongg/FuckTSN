package com.huawei.hms.common;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class Preconditions {
    public static void checkArgument(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    public static String checkNotEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The input parameter is empty.");
        }
        return str;
    }

    public static void checkNotMainThread() {
        checkNotMainThread("The given thread is main thread.");
    }

    public static <T> T checkNotNull(T t5) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException("The input parameter is null.");
    }

    public static int checkNotZero(int i6) {
        if (i6 != 0) {
            return i6;
        }
        throw new IllegalArgumentException("The input parameter is 0.");
    }

    public static void checkState(boolean z5) {
        if (!z5) {
            throw new IllegalStateException();
        }
    }

    public static void checkArgument(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static String checkNotEmpty(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    public static void checkNotMainThread(String str) {
        if (isMainThread()) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T checkNotNull(T t5, Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int checkNotZero(int i6, Object obj) {
        if (i6 != 0) {
            return i6;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void checkState(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public Preconditions() {
        throw new AssertionError("illegal Argument");
    }

    public static void checkArgument(boolean z5, String str, Object... objArr) {
        if (!z5) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
        }
    }

    public static void checkHandlerThread(Handler handler) {
        if (Looper.myLooper() == handler.getLooper()) {
        } else {
            throw new IllegalStateException("The given thread is not the current thread.");
        }
    }

    public static void checkMainThread(String str) {
        if (isMainThread()) {
        } else {
            throw new IllegalStateException(str);
        }
    }

    public static long checkNotZero(long j6) {
        if (j6 != 0) {
            return j6;
        }
        throw new IllegalArgumentException("The input parameter is 0.");
    }

    public static void checkState(boolean z5, String str, Object... objArr) {
        if (!z5) {
            throw new IllegalStateException(String.format(Locale.ROOT, str, objArr));
        }
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public static long checkNotZero(long j6, Object obj) {
        if (j6 != 0) {
            return j6;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }
}
