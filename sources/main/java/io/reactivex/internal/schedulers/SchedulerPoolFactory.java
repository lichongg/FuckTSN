package io.reactivex.internal.schedulers;

import androidx.camera.view.p;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SchedulerPoolFactory {
    public static final boolean PURGE_ENABLED;
    static final String PURGE_ENABLED_KEY = "rx2.purge-enabled";
    public static final int PURGE_PERIOD_SECONDS;
    static final String PURGE_PERIOD_SECONDS_KEY = "rx2.purge-period-seconds";
    static final AtomicReference<ScheduledExecutorService> PURGE_THREAD = new AtomicReference<>();
    static final Map<ScheduledThreadPoolExecutor, Object> POOLS = new ConcurrentHashMap();

    public static ScheduledExecutorService create(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor) {
            POOLS.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }

    static {
        int i6;
        Properties properties = System.getProperties();
        boolean z5 = true;
        if (properties.containsKey(PURGE_ENABLED_KEY)) {
            boolean z6 = Boolean.getBoolean(PURGE_ENABLED_KEY);
            if (z6 && properties.containsKey(PURGE_PERIOD_SECONDS_KEY)) {
                i6 = Integer.getInteger(PURGE_PERIOD_SECONDS_KEY, 1).intValue();
                z5 = z6;
                PURGE_ENABLED = z5;
                PURGE_PERIOD_SECONDS = i6;
                start();
            }
            z5 = z6;
        }
        i6 = 1;
        PURGE_ENABLED = z5;
        PURGE_PERIOD_SECONDS = i6;
        start();
    }

    public static void shutdown() {
        PURGE_THREAD.get().shutdownNow();
        POOLS.clear();
    }

    public static void start() {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = PURGE_THREAD;
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (p.a(atomicReference, scheduledExecutorService, newScheduledThreadPool)) {
                Runnable runnable = new Runnable() { // from class: io.reactivex.internal.schedulers.SchedulerPoolFactory.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Iterator it = new ArrayList(SchedulerPoolFactory.POOLS.keySet()).iterator();
                            while (it.hasNext()) {
                                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                                if (scheduledThreadPoolExecutor.isShutdown()) {
                                    SchedulerPoolFactory.POOLS.remove(scheduledThreadPoolExecutor);
                                } else {
                                    scheduledThreadPoolExecutor.purge();
                                }
                            }
                        } catch (Throwable th) {
                            RxJavaPlugins.onError(th);
                        }
                    }
                };
                int i6 = PURGE_PERIOD_SECONDS;
                newScheduledThreadPool.scheduleAtFixedRate(runnable, i6, i6, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }

    private SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }
}
