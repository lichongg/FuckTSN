package cn.jiguang.bg;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final int f2142a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f2143b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f2144c;

    /* renamed from: e, reason: collision with root package name */
    private final cn.jiguang.bg.a<Object> f2146e;

    /* renamed from: g, reason: collision with root package name */
    private Object f2148g;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f2145d = new AtomicBoolean(true);

    /* renamed from: f, reason: collision with root package name */
    private volatile long f2147f = 0;

    /* renamed from: h, reason: collision with root package name */
    private CountDownLatch f2149h = new CountDownLatch(1);

    static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final ExecutorService f2151a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (this.f2151a.isShutdown()) {
                    cn.jiguang.bb.f.i("Step", "executor is shutdown");
                } else {
                    this.f2151a.submit((Callable) message.obj);
                }
            } catch (Throwable th) {
                cn.jiguang.bb.f.l("Step", "handleMessage e:" + th);
            }
        }

        a(ExecutorService executorService) {
            super(p.d());
            this.f2151a = executorService;
        }
    }

    private synchronized long b(long j6) {
        long j7 = this.f2147f + j6;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (j7 < uptimeMillis) {
            this.f2147f = uptimeMillis;
            return -1L;
        }
        this.f2147f = j7;
        return j7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Looper d() {
        HandlerThread handlerThread = new HandlerThread("jg_step_thread") { // from class: cn.jiguang.bg.p.2
            @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        };
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        return looper == null ? Looper.getMainLooper() : looper;
    }

    public synchronized Object a(long j6) {
        if (a()) {
            return this.f2148g;
        }
        if (this.f2145d.get()) {
            return null;
        }
        try {
            if (j6 != -1) {
                this.f2149h.await(j6, TimeUnit.MILLISECONDS);
            } else {
                this.f2149h.await();
            }
        } catch (InterruptedException unused) {
        }
        if (this.f2149h.getCount() == 0) {
            this.f2149h = new CountDownLatch(1);
        }
        return this.f2148g;
    }

    public p(int i6, int i7, cn.jiguang.bg.a<Object> aVar, String str) {
        this.f2142a = i7;
        this.f2146e = aVar;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i6, i6, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new cn.jiguang.by.c(str)) { // from class: cn.jiguang.bg.p.1
            @Override // java.util.concurrent.ThreadPoolExecutor
            protected void afterExecute(Runnable runnable, Throwable th) {
                if (getActiveCount() > 1 || !getQueue().isEmpty()) {
                    return;
                }
                if (p.this.f2144c.hasMessages(233)) {
                    return;
                }
                try {
                    p.this.f2145d.set(true);
                    p.this.f2149h.countDown();
                } catch (Throwable unused) {
                }
            }
        };
        this.f2143b = threadPoolExecutor;
        this.f2144c = new a(threadPoolExecutor);
    }

    public void a(Object obj) {
        if (a() || obj == null) {
            return;
        }
        this.f2148g = obj;
        this.f2149h.countDown();
        cn.jiguang.bg.a<Object> aVar = this.f2146e;
        if (aVar != null) {
            aVar.a(obj);
        }
        a(true);
        cn.jiguang.bb.f.c("Step", "done!");
    }

    public void b() {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f2143b;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.getQueue().clear();
                this.f2144c.removeMessages(233);
            }
        } catch (Throwable th) {
            th.toString();
        }
    }

    public void a(Callable<?> callable) {
        try {
            long b6 = b(this.f2142a);
            if (b6 < 0) {
                this.f2143b.submit(callable);
            } else {
                Message obtain = Message.obtain();
                obtain.what = 233;
                obtain.obj = callable;
                this.f2144c.sendMessageAtTime(obtain, b6);
            }
            this.f2145d.set(false);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z5) {
        this.f2144c.removeMessages(233);
        if (!this.f2143b.isShutdown()) {
            if (z5) {
                this.f2143b.shutdownNow();
            } else {
                this.f2143b.shutdown();
            }
        }
        try {
            this.f2144c.getLooper().quit();
        } catch (Throwable unused) {
        }
        cn.jiguang.bb.f.c("Step", "StepParallelScheduler stop !");
    }

    public boolean a() {
        return this.f2148g != null;
    }
}
