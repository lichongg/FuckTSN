package cn.jiguang.by;

import cn.jiguang.bb.f;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements RejectedExecutionHandler {

    /* renamed from: a, reason: collision with root package name */
    private int f2648a;

    /* renamed from: b, reason: collision with root package name */
    private String f2649b;

    /* renamed from: c, reason: collision with root package name */
    private ThreadPoolExecutor f2650c;

    /* renamed from: d, reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f2651d;

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        f.c("JRejectedExecutionHandler", "poolName: " + this.f2649b + ", Exceeded ThreadPoolExecutor pool size");
        if (this.f2650c == null) {
            synchronized (this) {
                try {
                    if (this.f2650c == null) {
                        this.f2651d = new LinkedBlockingQueue<>();
                        int i6 = this.f2648a;
                        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(i6, i6, 3L, TimeUnit.SECONDS, this.f2651d, new c(this.f2649b + "_rjt"));
                        this.f2650c = threadPoolExecutor2;
                        threadPoolExecutor2.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        this.f2650c.execute(runnable);
    }

    a(String str, int i6) {
        this.f2649b = str;
        if (i6 <= 0) {
            this.f2648a = 3;
        }
        this.f2648a = i6;
    }
}
