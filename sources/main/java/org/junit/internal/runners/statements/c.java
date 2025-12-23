package org.junit.internal.runners.statements;

import java.lang.Thread;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.TestTimedOutException;
import org.junit.runners.model.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends h {

    /* renamed from: a, reason: collision with root package name */
    private final h f51433a;

    /* renamed from: b, reason: collision with root package name */
    private final TimeUnit f51434b;

    /* renamed from: c, reason: collision with root package name */
    private final long f51435c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f51436d;

    /* renamed from: e, reason: collision with root package name */
    private volatile ThreadGroup f51437e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f51438a;

        /* renamed from: b, reason: collision with root package name */
        private long f51439b;

        /* renamed from: c, reason: collision with root package name */
        private TimeUnit f51440c;

        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
            this.f51438a = false;
            this.f51439b = 0L;
            this.f51440c = TimeUnit.SECONDS;
        }

        public c d(h hVar) {
            if (hVar != null) {
                return new c(this, hVar, null);
            }
            throw new NullPointerException("statement cannot be null");
        }

        public b e(boolean z5) {
            this.f51438a = z5;
            return this;
        }

        public b f(long j6, TimeUnit timeUnit) {
            if (j6 < 0) {
                throw new IllegalArgumentException("timeout must be non-negative");
            }
            if (timeUnit == null) {
                throw new NullPointerException("TimeUnit cannot be null");
            }
            this.f51439b = j6;
            this.f51440c = timeUnit;
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.junit.internal.runners.statements.c$c, reason: collision with other inner class name */
    private class CallableC0991c implements Callable<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        private final CountDownLatch f51441a;

        private CallableC0991c() {
            this.f51441a = new CountDownLatch(1);
        }

        public void a() throws InterruptedException {
            this.f51441a.await();
        }

        @Override // java.util.concurrent.Callable
        public Throwable call() throws Exception {
            try {
                this.f51441a.countDown();
                c.this.f51433a.a();
                return null;
            } catch (Exception e6) {
                throw e6;
            } catch (Throwable th) {
                return th;
            }
        }

        /* synthetic */ CallableC0991c(c cVar, a aVar) {
            this();
        }
    }

    /* synthetic */ c(b bVar, h hVar, a aVar) {
        this(bVar, hVar);
    }

    private Thread[] d(Thread[] threadArr, int i6) {
        int min = Math.min(i6, threadArr.length);
        Thread[] threadArr2 = new Thread[min];
        for (int i7 = 0; i7 < min; i7++) {
            threadArr2[i7] = threadArr[i7];
        }
        return threadArr2;
    }

    @Deprecated
    public c(h hVar, long j6) {
        this(c().f(j6, TimeUnit.MILLISECONDS), hVar);
    }

    public static b c() {
        return new b(null);
    }

    private Throwable g(FutureTask<Throwable> futureTask, Thread thread) {
        try {
            long j6 = this.f51435c;
            return j6 > 0 ? futureTask.get(j6, this.f51434b) : futureTask.get();
        } catch (InterruptedException e6) {
            return e6;
        } catch (ExecutionException e7) {
            return e7.getCause();
        } catch (TimeoutException unused) {
            return f(thread);
        }
    }

    private Thread i(Thread thread) {
        Thread[] j6;
        if (this.f51437e == null || (j6 = j(this.f51437e)) == null) {
            return null;
        }
        long j7 = 0;
        Thread thread2 = null;
        for (Thread thread3 : j6) {
            if (thread3.getState() == Thread.State.RUNNABLE) {
                long e6 = e(thread3);
                if (thread2 == null || e6 > j7) {
                    thread2 = thread3;
                    j7 = e6;
                }
            }
        }
        if (thread2 == thread) {
            return null;
        }
        return thread2;
    }

    @Override // org.junit.runners.model.h
    public void a() throws Throwable {
        CallableC0991c callableC0991c = new CallableC0991c(this, null);
        FutureTask<Throwable> futureTask = new FutureTask<>(callableC0991c);
        this.f51437e = new ThreadGroup("FailOnTimeoutGroup");
        Thread thread = new Thread(this.f51437e, futureTask, "Time-limited test");
        thread.setDaemon(true);
        thread.start();
        callableC0991c.a();
        Throwable g6 = g(futureTask, thread);
        if (g6 != null) {
            throw g6;
        }
    }

    private c(b bVar, h hVar) {
        this.f51437e = null;
        this.f51433a = hVar;
        this.f51435c = bVar.f51439b;
        this.f51434b = bVar.f51440c;
        this.f51436d = bVar.f51438a;
    }

    private long e(Thread thread) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        if (threadMXBean.isThreadCpuTimeSupported()) {
            try {
                return threadMXBean.getThreadCpuTime(thread.getId());
            } catch (UnsupportedOperationException unused) {
                return 0L;
            }
        }
        return 0L;
    }

    private Exception f(Thread thread) {
        Thread thread2;
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (this.f51436d) {
            thread2 = i(thread);
        } else {
            thread2 = null;
        }
        TestTimedOutException testTimedOutException = new TestTimedOutException(this.f51435c, this.f51434b);
        if (stackTrace != null) {
            testTimedOutException.setStackTrace(stackTrace);
            thread.interrupt();
        }
        if (thread2 != null) {
            Exception exc = new Exception("Appears to be stuck in thread " + thread2.getName());
            exc.setStackTrace(h(thread2));
            return new MultipleFailureException(Arrays.asList(testTimedOutException, exc));
        }
        return testTimedOutException;
    }

    private StackTraceElement[] h(Thread thread) {
        try {
            return thread.getStackTrace();
        } catch (SecurityException unused) {
            return new StackTraceElement[0];
        }
    }

    private Thread[] j(ThreadGroup threadGroup) {
        int max = Math.max(threadGroup.activeCount() * 2, 100);
        int i6 = 0;
        do {
            Thread[] threadArr = new Thread[max];
            int enumerate = threadGroup.enumerate(threadArr);
            if (enumerate < max) {
                return d(threadArr, enumerate);
            }
            max += 100;
            i6++;
        } while (i6 < 5);
        return null;
    }
}
