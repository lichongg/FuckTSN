package xyz.adscope.common.v2.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class ScopeThreadPool implements IBaseThreadPool {
    private static final String GROUP_ANALYSE = "T_analyse";
    private static final String GROUP_BASIC = "T_basic";
    private static final String GROUP_INIT = "T_init";
    private static final String GROUP_LOCAL = "T_local";
    private static final String GROUP_REQUEST = "T_request";
    private final int CORE_NUM;
    private final int MAX_NUM;
    private final ExecutorService mAnalyseExecutor;
    private final ExecutorService mBasicExecutor;
    private final ExecutorService mCacheExecutor;
    private final ExecutorService mInitExecutor;
    private final ExecutorService mLocalExecutor;
    private final ExecutorService mRequestExecutor;
    private final ScheduledExecutorService mScheduledExecutor;

    @Override // xyz.adscope.common.v2.thread.pool.IBaseThreadPool
    public void executeAnalyseAsyncTask(Runnable runnable) {
        this.mAnalyseExecutor.execute(runnable);
    }

    @Override // xyz.adscope.common.v2.thread.pool.IBaseThreadPool
    public void executeBasicAsyncTask(Runnable runnable) {
        this.mBasicExecutor.execute(runnable);
    }

    @Override // xyz.adscope.common.v2.thread.pool.IBaseThreadPool
    public void executeInitAsyncTask(Runnable runnable) {
        this.mInitExecutor.execute(runnable);
    }

    @Override // xyz.adscope.common.v2.thread.pool.IBaseThreadPool
    public void executeLocalAsyncTask(Runnable runnable) {
        this.mLocalExecutor.execute(runnable);
    }

    @Override // xyz.adscope.common.v2.thread.pool.IBaseThreadPool
    public void executeRequestAsyncTask(Runnable runnable) {
        this.mRequestExecutor.execute(runnable);
    }

    @Override // xyz.adscope.common.v2.thread.pool.IBaseThreadPool
    public void executeResourceCacheTask(Runnable runnable) {
        this.mCacheExecutor.execute(runnable);
    }

    void removeScheduleAtFixedRate(Runnable runnable) {
        ScheduledExecutorService scheduledExecutorService = this.mScheduledExecutor;
        if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) scheduledExecutorService).remove(runnable);
        }
    }

    @Override // xyz.adscope.common.v2.thread.pool.IBaseThreadPool
    public void scheduleAsyncTask(Runnable runnable, long j6, TimeUnit timeUnit) {
        this.mScheduledExecutor.schedule(runnable, j6, timeUnit);
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        return this.mScheduledExecutor.scheduleWithFixedDelay(runnable, j6, j7, timeUnit);
    }

    ScopeThreadPool() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.CORE_NUM = availableProcessors;
        this.MAX_NUM = Math.max((availableProcessors / 2) + 1, 4);
        this.mRequestExecutor = Executors.newFixedThreadPool(8, new ScopeThreadFactory(5, GROUP_REQUEST));
        this.mBasicExecutor = Executors.newFixedThreadPool(8, new ScopeThreadFactory(5, GROUP_BASIC));
        this.mCacheExecutor = Executors.newFixedThreadPool(8, new ScopeThreadFactory(5, GROUP_BASIC));
        this.mInitExecutor = Executors.newFixedThreadPool(2, new ScopeThreadFactory(5, GROUP_INIT));
        this.mLocalExecutor = Executors.newFixedThreadPool(8, new ScopeThreadFactory(5, GROUP_LOCAL));
        this.mAnalyseExecutor = Executors.newFixedThreadPool(4, new ScopeThreadFactory(5, GROUP_ANALYSE));
        this.mScheduledExecutor = Executors.newScheduledThreadPool(8, new ScopeThreadFactory(5, GROUP_BASIC));
    }
}
