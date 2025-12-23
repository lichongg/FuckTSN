package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class bi implements RejectedExecutionHandler {
    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        ThreadPoolExecutor threadPoolExecutor2;
        ThreadPoolExecutor threadPoolExecutor3;
        LinkedBlockingQueue linkedBlockingQueue;
        ThreadFactory threadFactory;
        az.h("ThreadPoolFactory").e("Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            try {
                threadPoolExecutor2 = bf.f10715d;
                if (threadPoolExecutor2 == null) {
                    LinkedBlockingQueue unused = bf.f10716e = new LinkedBlockingQueue();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    linkedBlockingQueue = bf.f10716e;
                    threadFactory = bf.f10717f;
                    ThreadPoolExecutor unused2 = bf.f10715d = new ThreadPoolExecutor(2, 2, 60L, timeUnit, linkedBlockingQueue, threadFactory);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        threadPoolExecutor3 = bf.f10715d;
        threadPoolExecutor3.execute(runnable);
    }

    bi() {
    }
}
