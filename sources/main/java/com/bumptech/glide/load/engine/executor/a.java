package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a implements ExecutorService {

    /* renamed from: b, reason: collision with root package name */
    private static final String f15136b = "source";

    /* renamed from: c, reason: collision with root package name */
    private static final String f15137c = "disk-cache";

    /* renamed from: d, reason: collision with root package name */
    private static final int f15138d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static final String f15139e = "GlideExecutor";

    /* renamed from: f, reason: collision with root package name */
    private static final String f15140f = "source-unlimited";

    /* renamed from: g, reason: collision with root package name */
    private static final String f15141g = "animation";

    /* renamed from: h, reason: collision with root package name */
    private static final long f15142h = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: i, reason: collision with root package name */
    private static final int f15143i = 4;

    /* renamed from: j, reason: collision with root package name */
    private static volatile int f15144j;

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f15145a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.load.engine.executor.a$a, reason: collision with other inner class name */
    public static final class C0154a {

        /* renamed from: g, reason: collision with root package name */
        public static final long f15146g = 0;

        /* renamed from: a, reason: collision with root package name */
        private final boolean f15147a;

        /* renamed from: b, reason: collision with root package name */
        private int f15148b;

        /* renamed from: c, reason: collision with root package name */
        private int f15149c;

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        private c f15150d = c.f15162d;

        /* renamed from: e, reason: collision with root package name */
        private String f15151e;

        /* renamed from: f, reason: collision with root package name */
        private long f15152f;

        public a a() {
            if (TextUtils.isEmpty(this.f15151e)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f15151e);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f15148b, this.f15149c, this.f15152f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.f15151e, this.f15150d, this.f15147a));
            if (this.f15152f != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new a(threadPoolExecutor);
        }

        public C0154a b(String str) {
            this.f15151e = str;
            return this;
        }

        public C0154a c(@IntRange(from = 1) int i6) {
            this.f15148b = i6;
            this.f15149c = i6;
            return this;
        }

        public C0154a d(long j6) {
            this.f15152f = j6;
            return this;
        }

        public C0154a e(@NonNull c cVar) {
            this.f15150d = cVar;
            return this;
        }

        C0154a(boolean z5) {
            this.f15147a = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f15159a = new C0156a();

        /* renamed from: b, reason: collision with root package name */
        public static final c f15160b;

        /* renamed from: c, reason: collision with root package name */
        public static final c f15161c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f15162d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements c {
            @Override // com.bumptech.glide.load.engine.executor.a.c
            public void a(Throwable th) {
                if (th != null) {
                    Log.isLoggable(a.f15139e, 6);
                }
            }

            b() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bumptech.glide.load.engine.executor.a$c$c, reason: collision with other inner class name */
        class C0157c implements c {
            @Override // com.bumptech.glide.load.engine.executor.a.c
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }

            C0157c() {
            }
        }

        void a(Throwable th);

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bumptech.glide.load.engine.executor.a$c$a, reason: collision with other inner class name */
        class C0156a implements c {
            C0156a() {
            }

            @Override // com.bumptech.glide.load.engine.executor.a.c
            public void a(Throwable th) {
            }
        }

        static {
            b bVar = new b();
            f15160b = bVar;
            f15161c = new C0157c();
            f15162d = bVar;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f15145a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f15145a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f15145a.submit(runnable);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b implements ThreadFactory {

        /* renamed from: e, reason: collision with root package name */
        private static final int f15153e = 9;

        /* renamed from: a, reason: collision with root package name */
        private final String f15154a;

        /* renamed from: b, reason: collision with root package name */
        final c f15155b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f15156c;

        /* renamed from: d, reason: collision with root package name */
        private int f15157d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bumptech.glide.load.engine.executor.a$b$a, reason: collision with other inner class name */
        class C0155a extends Thread {
            C0155a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (b.this.f15156c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    b.this.f15155b.a(th);
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C0155a c0155a;
            c0155a = new C0155a(runnable, "glide-" + this.f15154a + "-thread-" + this.f15157d);
            this.f15157d = this.f15157d + 1;
            return c0155a;
        }

        b(String str, c cVar, boolean z5) {
            this.f15154a = str;
            this.f15155b = cVar;
            this.f15156c = z5;
        }
    }

    public static int a() {
        if (f15144j == 0) {
            f15144j = Math.min(4, com.bumptech.glide.load.engine.executor.b.a());
        }
        return f15144j;
    }

    public static C0154a e() {
        return new C0154a(true).c(1).b(f15137c);
    }

    public static C0154a i() {
        return new C0154a(false).c(a()).b("source");
    }

    public static a m() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f15142h, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b(f15140f, c.f15162d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j6, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f15145a.awaitTermination(j6, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f15145a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j6, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f15145a.invokeAll(collection, j6, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j6, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f15145a.invokeAny(collection, j6, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f15145a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f15145a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f15145a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f15145a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t5) {
        return this.f15145a.submit(runnable, t5);
    }

    public String toString() {
        return this.f15145a.toString();
    }

    @VisibleForTesting
    a(ExecutorService executorService) {
        this.f15145a = executorService;
    }

    public static C0154a b() {
        int i6;
        if (a() >= 4) {
            i6 = 2;
        } else {
            i6 = 1;
        }
        return new C0154a(true).c(i6).b(f15141g);
    }

    public static a c() {
        return b().a();
    }

    @Deprecated
    public static a d(int i6, c cVar) {
        return b().c(i6).e(cVar).a();
    }

    public static a f() {
        return e().a();
    }

    @Deprecated
    public static a g(int i6, String str, c cVar) {
        return e().c(i6).b(str).e(cVar).a();
    }

    @Deprecated
    public static a h(c cVar) {
        return e().e(cVar).a();
    }

    public static a j() {
        return i().a();
    }

    @Deprecated
    public static a k(int i6, String str, c cVar) {
        return i().c(i6).b(str).e(cVar).a();
    }

    @Deprecated
    public static a l(c cVar) {
        return i().e(cVar).a();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f15145a.submit(callable);
    }
}
