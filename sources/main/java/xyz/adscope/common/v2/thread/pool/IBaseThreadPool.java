package xyz.adscope.common.v2.thread.pool;

import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IBaseThreadPool {
    void executeAnalyseAsyncTask(Runnable runnable);

    void executeBasicAsyncTask(Runnable runnable);

    void executeInitAsyncTask(Runnable runnable);

    void executeLocalAsyncTask(Runnable runnable);

    void executeRequestAsyncTask(Runnable runnable);

    void executeResourceCacheTask(Runnable runnable);

    void scheduleAsyncTask(Runnable runnable, long j6, TimeUnit timeUnit);
}
