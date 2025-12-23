package xyz.adscope.common.network.util;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class WorkExecutor implements Executor {

    /* renamed from: b, reason: collision with root package name */
    private static final int f56738b = Runtime.getRuntime().availableProcessors();

    /* renamed from: c, reason: collision with root package name */
    private static final ThreadFactory f56739c = new ThreadFactory() { // from class: xyz.adscope.common.network.util.WorkExecutor.1

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f56741a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Request #" + this.f56741a.getAndIncrement());
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f56740a;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f56740a.execute(runnable);
    }

    public RejectedExecutionHandler rejectHandler() {
        return new RejectedExecutionHandler() { // from class: xyz.adscope.common.network.util.WorkExecutor.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public WorkExecutor() {
        int i6 = f56738b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Math.max(2, Math.min(i6 - 1, 4)), (i6 * 2) + 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(200), f56739c, rejectHandler());
        this.f56740a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }
}
