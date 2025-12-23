package com.kwad.sdk.i;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class j {
    private static final AtomicInteger aTb = new AtomicInteger(1);
    private static final ExecutorService aTc = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.i.j.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(Thread.currentThread().getThreadGroup(), runnable, "ksad-lm-thread-" + j.aTb.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    });
    private static final Handler aRF = new Handler(Looper.getMainLooper());

    static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    static boolean L(@Nullable List<?> list) {
        return list == null || list.isEmpty();
    }

    static void a(n nVar) {
        aTc.execute(nVar);
    }

    static void closeQuietly(URLConnection uRLConnection) {
        try {
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
        } catch (Throwable unused) {
        }
    }

    private static String dY(String str) {
        return str + " " + zJ();
    }

    private static String gm(String str) {
        return "KSAd_LM_" + str;
    }

    static double o(double d6) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d6)), 0, RoundingMode.HALF_UP).doubleValue();
    }

    private static String zJ() {
        return "";
    }

    public static void ak(String str, String str2) {
        gm(str);
        dY(str2);
    }

    static void Nn() {
    }

    public static void No() {
    }
}
