package com.amap.api.col.p0003l;

import android.text.TextUtils;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class z7 implements ThreadFactory {

    /* renamed from: k, reason: collision with root package name */
    private static final int f7806k;

    /* renamed from: l, reason: collision with root package name */
    private static final int f7807l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f7808m;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicLong f7809a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadFactory f7810b;

    /* renamed from: c, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f7811c;

    /* renamed from: d, reason: collision with root package name */
    private final String f7812d;

    /* renamed from: e, reason: collision with root package name */
    private final Integer f7813e;

    /* renamed from: f, reason: collision with root package name */
    private final Boolean f7814f;

    /* renamed from: g, reason: collision with root package name */
    private final int f7815g;

    /* renamed from: h, reason: collision with root package name */
    private final int f7816h;

    /* renamed from: i, reason: collision with root package name */
    private final BlockingQueue<Runnable> f7817i;

    /* renamed from: j, reason: collision with root package name */
    private final int f7818j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f7819a;

        a(Runnable runnable) {
            this.f7819a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f7819a.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private ThreadFactory f7821a;

        /* renamed from: b, reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f7822b;

        /* renamed from: c, reason: collision with root package name */
        private String f7823c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f7824d;

        /* renamed from: e, reason: collision with root package name */
        private Boolean f7825e;

        /* renamed from: f, reason: collision with root package name */
        private int f7826f = z7.f7807l;

        /* renamed from: g, reason: collision with root package name */
        private int f7827g = z7.f7808m;

        /* renamed from: h, reason: collision with root package name */
        private int f7828h = 30;

        /* renamed from: i, reason: collision with root package name */
        private BlockingQueue<Runnable> f7829i;

        private void j() {
            this.f7821a = null;
            this.f7822b = null;
            this.f7823c = null;
            this.f7824d = null;
            this.f7825e = null;
        }

        public final b a() {
            this.f7826f = 1;
            return this;
        }

        public final b b(int i6) {
            if (this.f7826f <= 0) {
                throw new NullPointerException("corePoolSize  must > 0!");
            }
            this.f7827g = i6;
            return this;
        }

        public final b c(String str) {
            if (str == null) {
                throw new NullPointerException("Naming pattern must not be null!");
            }
            this.f7823c = str;
            return this;
        }

        public final b d(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            if (uncaughtExceptionHandler == null) {
                throw new NullPointerException("Uncaught exception handler must not be null!");
            }
            this.f7822b = uncaughtExceptionHandler;
            return this;
        }

        public final b e(BlockingQueue<Runnable> blockingQueue) {
            this.f7829i = blockingQueue;
            return this;
        }

        public final z7 h() {
            z7 z7Var = new z7(this, (byte) 0);
            j();
            return z7Var;
        }
    }

    /* synthetic */ z7(b bVar, byte b6) {
        this(bVar);
    }

    private z7(b bVar) {
        if (bVar.f7821a == null) {
            this.f7810b = Executors.defaultThreadFactory();
        } else {
            this.f7810b = bVar.f7821a;
        }
        int i6 = bVar.f7826f;
        this.f7815g = i6;
        int i7 = f7808m;
        this.f7816h = i7;
        if (i7 < i6) {
            throw new NullPointerException("maxPoolSize must > corePoolSize!");
        }
        this.f7818j = bVar.f7828h;
        if (bVar.f7829i == null) {
            this.f7817i = new LinkedBlockingQueue(256);
        } else {
            this.f7817i = bVar.f7829i;
        }
        if (TextUtils.isEmpty(bVar.f7823c)) {
            this.f7812d = "amap-threadpool";
        } else {
            this.f7812d = bVar.f7823c;
        }
        this.f7813e = bVar.f7824d;
        this.f7814f = bVar.f7825e;
        this.f7811c = bVar.f7822b;
        this.f7809a = new AtomicLong();
    }

    private ThreadFactory g() {
        return this.f7810b;
    }

    private String h() {
        return this.f7812d;
    }

    private Boolean i() {
        return this.f7814f;
    }

    private Integer j() {
        return this.f7813e;
    }

    private Thread.UncaughtExceptionHandler k() {
        return this.f7811c;
    }

    public final int a() {
        return this.f7815g;
    }

    public final int b() {
        return this.f7816h;
    }

    public final BlockingQueue<Runnable> c() {
        return this.f7817i;
    }

    public final int d() {
        return this.f7818j;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        new a(runnable);
        Thread newThread = g().newThread(runnable);
        if (h() != null) {
            newThread.setName(String.format(h() + "-%d", Long.valueOf(this.f7809a.incrementAndGet())));
        }
        if (k() != null) {
            newThread.setUncaughtExceptionHandler(k());
        }
        if (j() != null) {
            newThread.setPriority(j().intValue());
        }
        if (i() != null) {
            newThread.setDaemon(i().booleanValue());
        }
        return newThread;
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f7806k = availableProcessors;
        f7807l = Math.max(2, Math.min(availableProcessors - 1, 4));
        f7808m = (availableProcessors * 2) + 1;
    }
}
