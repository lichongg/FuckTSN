package com.bytedance.sdk.openadsdk.mi;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.openadsdk.api.m;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f31798j;
    private final Handler cw;
    private volatile ThreadPoolExecutor xt = null;

    public static j j() {
        if (f31798j == null) {
            synchronized (j.class) {
                f31798j = new j();
            }
        }
        return f31798j;
    }

    public ExecutorService cw() {
        if (this.xt == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 1000L, TimeUnit.MILLISECONDS, new SynchronousQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            this.xt = threadPoolExecutor;
        }
        return this.xt;
    }

    public Handler xt() {
        return this.cw;
    }

    private j() {
        HandlerThread handlerThread = new HandlerThread("csj_api_main");
        handlerThread.start();
        this.cw = new Handler(handlerThread.getLooper());
    }

    public void j(Runnable runnable) {
        if (runnable != null) {
            try {
                this.cw.post(runnable);
            } catch (Throwable th) {
                m.j(th);
            }
        }
    }

    public void j(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            if (this.xt != null) {
                m.xt("ApiThread", "setPluginExecutor: 释放掉api层的线程池");
                j(threadPoolExecutor, this.xt);
            }
            this.xt = threadPoolExecutor;
        }
    }

    private void j(ExecutorService executorService, final ThreadPoolExecutor threadPoolExecutor) {
        executorService.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.mi.j.1
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                if (threadPoolExecutor2 == null) {
                    return;
                }
                try {
                    threadPoolExecutor2.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    while (true) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                        }
                        if (threadPoolExecutor.getQueue().size() <= 0 && threadPoolExecutor.getActiveCount() == 0) {
                            threadPoolExecutor.shutdown();
                            return;
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}
