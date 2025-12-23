package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    static c.d bcG;
    static volatile Executor bcH;
    static ExecutorService bcI = Executors.newSingleThreadExecutor();

    public static void a(c.d dVar) {
        bcG = dVar;
    }

    static Executor getExecutor() {
        if (bcH == null) {
            synchronized (d.class) {
                try {
                    if (bcH == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        bcH = threadPoolExecutor;
                    }
                } finally {
                }
            }
        }
        return bcH;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            bcH = executor;
        }
    }

    private d() {
    }
}
