package xyz.adscope.common.tool.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class CommonThreadPool {

    /* renamed from: a, reason: collision with root package name */
    private static final int f56755a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f56756b;

    /* renamed from: c, reason: collision with root package name */
    private static final LinkedBlockingQueue<Runnable> f56757c;

    public static ScheduledExecutorService getScheduledExecutorService() {
        return Executors.newScheduledThreadPool(3);
    }

    public static ThreadPoolExecutor getInitRequestPool() {
        return new ThreadPoolExecutor(2, f56756b, 5L, TimeUnit.SECONDS, f56757c, new CommonThreadFactory(5, "common-adsdk-adrequest-thread-"), rejectHandler());
    }

    public static RejectedExecutionHandler rejectHandler() {
        return new RejectedExecutionHandler() { // from class: xyz.adscope.common.tool.thread.CommonThreadPool.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f56755a = availableProcessors;
        f56756b = Math.max((availableProcessors / 2) + 1, 4);
        f56757c = new LinkedBlockingQueue<>();
    }

    public static ScheduledExecutorService getSingleExecutorService() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
