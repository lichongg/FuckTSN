package xyz.adscope.amps.tool.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSThreadPool {
    private static final int CORE_NUM;
    private static final int MAX_NUM;
    private static final int UPDATE_THREAD_COUNT = 3;
    private static ScheduledExecutorService executorService;
    private static final LinkedBlockingQueue<Runnable> initRequestQueue;
    private static ThreadPoolExecutor mInitRequestPool;

    public static ScheduledExecutorService getScheduledExecutorService() {
        return Executors.newScheduledThreadPool(3);
    }

    public static ThreadPoolExecutor getInitRequestPool() {
        if (mInitRequestPool == null) {
            mInitRequestPool = new ThreadPoolExecutor(2, MAX_NUM, 5L, TimeUnit.SECONDS, initRequestQueue, new AMPSThreadFactory(5, "adscope-adsdk-adrequest-thread-"), rejectHandler());
        }
        return mInitRequestPool;
    }

    public static ScheduledExecutorService getSingleExecutorService() {
        if (executorService == null) {
            executorService = Executors.newSingleThreadScheduledExecutor();
        }
        return executorService;
    }

    public static RejectedExecutionHandler rejectHandler() {
        return new RejectedExecutionHandler() { // from class: xyz.adscope.amps.tool.thread.AMPSThreadPool.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CORE_NUM = availableProcessors;
        MAX_NUM = Math.max((availableProcessors / 2) + 1, 4);
        initRequestQueue = new LinkedBlockingQueue<>();
    }
}
