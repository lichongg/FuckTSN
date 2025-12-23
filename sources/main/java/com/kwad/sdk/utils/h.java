package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class h {
    private static volatile ExecutorService aYF;
    private static volatile ScheduledExecutorService aYG;

    public static void execute(Runnable runnable) {
        if (aYF == null) {
            synchronized (h.class) {
                try {
                    if (aYF == null) {
                        aYF = GlobalThreadPools.Jy();
                    }
                } finally {
                }
            }
        }
        if (aYF == null || aYF.isShutdown() || aYF.isTerminated()) {
            return;
        }
        aYF.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        if (aYG == null) {
            synchronized (h.class) {
                try {
                    if (aYG == null) {
                        aYG = GlobalThreadPools.Jz();
                    }
                } finally {
                }
            }
        }
        aYG.schedule(runnable, j6, timeUnit);
    }
}
