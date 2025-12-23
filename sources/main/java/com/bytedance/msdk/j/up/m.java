package com.bytedance.msdk.j.up;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.sdk.component.utils.vl;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {
    private static final int ae;
    private static boolean cw = false;

    /* renamed from: g, reason: collision with root package name */
    private static final ThreadPoolExecutor f25144g;

    /* renamed from: j, reason: collision with root package name */
    static final /* synthetic */ boolean f25145j = true;

    /* renamed from: m, reason: collision with root package name */
    private static Handler f25146m;
    private static final Executor oq;

    /* renamed from: r, reason: collision with root package name */
    private static Handler f25147r;
    private static final int tl;
    private static HandlerThread up;
    private static final Object xt = new Object();

    public static boolean cw() {
        return tl() && up.getLooper() == Looper.myLooper();
    }

    public static void j() {
        try {
            HandlerThread handlerThread = new HandlerThread("gm_t_main", -19);
            up = handlerThread;
            handlerThread.start();
            f25146m = new Handler(up.getLooper());
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public static Handler r() {
        Handler handler;
        synchronized (xt) {
            try {
                if (f25147r == null) {
                    if (cw) {
                        throw new RuntimeException("Did not yet override the UI thread");
                    }
                    f25147r = new Handler(Looper.getMainLooper());
                }
                handler = f25147r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public static Looper xt() {
        if (tl()) {
            return up.getLooper();
        }
        return null;
    }

    static {
        j();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ae = availableProcessors;
        tl = Math.min(availableProcessors, 4);
        f25144g = g();
        oq = oq();
    }

    public static Executor ae() {
        return oq;
    }

    private static ThreadPoolExecutor g() {
        int i6 = tl;
        com.bytedance.sdk.component.oq.r.r rVar = new com.bytedance.sdk.component.oq.r.r(i6, i6, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(1024), j("gm_t_executor:"), new ThreadPoolExecutor.DiscardOldestPolicy() { // from class: com.bytedance.msdk.j.up.m.2
            @Override // java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy, java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                super.rejectedExecution(runnable, threadPoolExecutor);
                com.bytedance.msdk.ae.xt.j.j().cw();
            }
        });
        try {
            rVar.allowCoreThreadTimeOut(true);
            return rVar;
        } catch (Exception e6) {
            vl.cw("ThreadHelper", "stackerror:", e6);
            return rVar;
        } catch (NoSuchMethodError e7) {
            vl.j(e7);
            return rVar;
        }
    }

    public static Executor m() {
        return f25144g;
    }

    private static Executor oq() {
        return new com.bytedance.sdk.component.oq.r.r(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), j("gm_t_log_upload:"), new ThreadPoolExecutor.DiscardPolicy());
    }

    private static boolean tl() {
        HandlerThread handlerThread = up;
        return (handlerThread == null || !handlerThread.isAlive() || f25146m == null) ? false : true;
    }

    public static void cw(Runnable runnable) {
        if (up()) {
            runnable.run();
        } else {
            r().post(runnable);
        }
    }

    public static boolean up() {
        if (r().getLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public static void xt(Runnable runnable) {
        if (up()) {
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        j(futureTask);
        try {
            futureTask.get();
        } catch (Exception e6) {
            throw new RuntimeException("Exception occured while waiting for runnable", e6);
        }
    }

    public static void j(Runnable runnable) {
        if (tl()) {
            if (cw()) {
                runnable.run();
                return;
            } else {
                f25146m.post(runnable);
                return;
            }
        }
        j();
    }

    public static void r(Runnable runnable) {
        j(f25144g, runnable);
    }

    public static void xt(Runnable runnable, long j6) {
        r().postDelayed(runnable, j6);
    }

    public static void j(Runnable runnable, long j6) {
        if (tl()) {
            f25146m.postDelayed(runnable, j6);
        } else {
            j();
        }
    }

    public static ThreadFactory j(final String str) {
        return new ThreadFactory() { // from class: com.bytedance.msdk.j.up.m.1
            private final AtomicInteger xt = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new com.bytedance.sdk.component.oq.r.cw(runnable, str + " # " + this.xt.getAndIncrement());
            }
        };
    }

    public static <T> FutureTask<T> j(FutureTask<T> futureTask) {
        r().post(futureTask);
        return futureTask;
    }

    public static ExecutorService j(String str, int i6, RejectedExecutionHandler rejectedExecutionHandler) {
        return new com.bytedance.sdk.component.oq.r.r(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(i6), j("gm_t_single_".concat(String.valueOf(str))), rejectedExecutionHandler);
    }

    public static <T> Future<T> j(Callable<T> callable) {
        try {
            return f25144g.submit(callable);
        } catch (Exception e6) {
            vl.cw("ThreadHelper", "stackerror:", e6);
            return null;
        }
    }

    private static boolean j(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
            return true;
        } catch (Exception e6) {
            vl.cw("ThreadHelper", "stackerror:", e6);
            return false;
        }
    }
}
