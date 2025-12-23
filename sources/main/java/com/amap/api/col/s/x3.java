package com.amap.api.col.s;

import android.text.TextUtils;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class x3 implements ThreadFactory {

    /* renamed from: k, reason: collision with root package name */
    private static final int f8680k;

    /* renamed from: l, reason: collision with root package name */
    private static final int f8681l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f8682m;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicLong f8683a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadFactory f8684b;

    /* renamed from: c, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f8685c;

    /* renamed from: d, reason: collision with root package name */
    private final String f8686d;

    /* renamed from: e, reason: collision with root package name */
    private final Integer f8687e;

    /* renamed from: f, reason: collision with root package name */
    private final Boolean f8688f;

    /* renamed from: g, reason: collision with root package name */
    private final int f8689g;

    /* renamed from: h, reason: collision with root package name */
    private final int f8690h;

    /* renamed from: i, reason: collision with root package name */
    private final BlockingQueue<Runnable> f8691i;

    /* renamed from: j, reason: collision with root package name */
    private final int f8692j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f8693a;

        a(Runnable runnable) {
            this.f8693a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f8693a.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private ThreadFactory f8695a;

        /* renamed from: b, reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f8696b;

        /* renamed from: c, reason: collision with root package name */
        private String f8697c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f8698d;

        /* renamed from: e, reason: collision with root package name */
        private Boolean f8699e;

        /* renamed from: f, reason: collision with root package name */
        private int f8700f = x3.f8681l;

        /* renamed from: g, reason: collision with root package name */
        private int f8701g = x3.f8682m;

        /* renamed from: h, reason: collision with root package name */
        private int f8702h = 30;

        /* renamed from: i, reason: collision with root package name */
        private BlockingQueue<Runnable> f8703i;

        private void e() {
            this.f8695a = null;
            this.f8696b = null;
            this.f8697c = null;
            this.f8698d = null;
            this.f8699e = null;
        }

        public final b a(String str) {
            this.f8697c = str;
            return this;
        }

        public final x3 b() {
            x3 x3Var = new x3(this, (byte) 0);
            e();
            return x3Var;
        }
    }

    /* synthetic */ x3(b bVar, byte b6) {
        this(bVar);
    }

    private x3(b bVar) {
        if (bVar.f8695a == null) {
            this.f8684b = Executors.defaultThreadFactory();
        } else {
            this.f8684b = bVar.f8695a;
        }
        int i6 = bVar.f8700f;
        this.f8689g = i6;
        int i7 = f8682m;
        this.f8690h = i7;
        if (i7 < i6) {
            throw new NullPointerException("maxPoolSize must > corePoolSize!");
        }
        this.f8692j = bVar.f8702h;
        if (bVar.f8703i == null) {
            this.f8691i = new LinkedBlockingQueue(256);
        } else {
            this.f8691i = bVar.f8703i;
        }
        if (TextUtils.isEmpty(bVar.f8697c)) {
            this.f8686d = "amap-threadpool";
        } else {
            this.f8686d = bVar.f8697c;
        }
        this.f8687e = bVar.f8698d;
        this.f8688f = bVar.f8699e;
        this.f8685c = bVar.f8696b;
        this.f8683a = new AtomicLong();
    }

    private ThreadFactory g() {
        return this.f8684b;
    }

    private String h() {
        return this.f8686d;
    }

    private Boolean i() {
        return this.f8688f;
    }

    private Integer j() {
        return this.f8687e;
    }

    private Thread.UncaughtExceptionHandler k() {
        return this.f8685c;
    }

    public final int a() {
        return this.f8689g;
    }

    public final int b() {
        return this.f8690h;
    }

    public final BlockingQueue<Runnable> c() {
        return this.f8691i;
    }

    public final int d() {
        return this.f8692j;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        new a(runnable);
        Thread newThread = g().newThread(runnable);
        if (h() != null) {
            newThread.setName(String.format(h() + "-%d", Long.valueOf(this.f8683a.incrementAndGet())));
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
        f8680k = availableProcessors;
        f8681l = Math.max(2, Math.min(availableProcessors - 1, 4));
        f8682m = (availableProcessors * 2) + 1;
    }
}
