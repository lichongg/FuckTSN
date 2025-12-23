package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes.dex */
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void beginAsyncSection(String str, int i6) {
            Trace.beginAsyncSection(str, i6);
        }

        @DoNotInline
        static void endAsyncSection(String str, int i6) {
            Trace.endAsyncSection(str, i6);
        }

        @DoNotInline
        static boolean isEnabled() {
            return Trace.isEnabled();
        }

        @DoNotInline
        static void setCounter(String str, long j6) {
            Trace.setCounter(str, j6);
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                sTraceCounterMethod = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception unused) {
            }
        }
    }

    public static void beginAsyncSection(@NonNull String str, int i6) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.beginAsyncSection(str, i6);
        } else {
            try {
                sAsyncTraceBeginMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i6));
            } catch (Exception unused) {
            }
        }
    }

    public static void endAsyncSection(@NonNull String str, int i6) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.endAsyncSection(str, i6);
        } else {
            try {
                sAsyncTraceEndMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i6));
            } catch (Exception unused) {
            }
        }
    }

    public static boolean isEnabled() {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.isEnabled();
        }
        try {
            return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void setCounter(@NonNull String str, int i6) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setCounter(str, i6);
        } else {
            try {
                sTraceCounterMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i6));
            } catch (Exception unused) {
            }
        }
    }

    private TraceCompat() {
    }

    public static void beginSection(@NonNull String str) {
        Trace.beginSection(str);
    }

    public static void endSection() {
        Trace.endSection();
    }
}
