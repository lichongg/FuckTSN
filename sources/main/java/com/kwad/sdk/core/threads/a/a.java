package com.kwad.sdk.core.threads.a;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends ScheduledThreadPoolExecutor implements c {
    public static volatile boolean aJR;
    private final ConcurrentHashMap<Runnable, Long> aJS;
    private long aJT;
    private int aJU;

    public a(int i6, ThreadFactory threadFactory) {
        super(1, threadFactory);
        this.aJS = new ConcurrentHashMap<>();
        this.aJT = 0L;
        this.aJU = 0;
    }

    @Override // com.kwad.sdk.core.threads.a.c
    public final long JK() {
        return this.aJT;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (aJR) {
            this.aJS.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (aJR && this.aJS.containsKey(runnable) && this.aJS.get(runnable) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.aJS.get(runnable).longValue();
            if (elapsedRealtime >= 0 && elapsedRealtime < 1800000) {
                long j6 = this.aJT;
                int i6 = this.aJU;
                this.aJT = ((j6 * i6) + elapsedRealtime) / (i6 + 1);
                this.aJU = i6 + 1;
            }
            this.aJS.remove(runnable);
        }
    }
}
