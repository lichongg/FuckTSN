package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class l {

    /* renamed from: c, reason: collision with root package name */
    private static Handler f40671c;

    /* renamed from: d, reason: collision with root package name */
    private static HandlerThread f40672d;

    /* renamed from: b, reason: collision with root package name */
    private static Object f40670b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f40669a = c();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.tencent.open.utils.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static void a(Runnable runnable) {
        try {
            f40669a.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    public static void b(Runnable runnable) {
        a().post(runnable);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        final Queue<Runnable> f40673a;

        /* renamed from: b, reason: collision with root package name */
        Runnable f40674b;

        private a() {
            this.f40673a = new LinkedList();
        }

        protected synchronized void a() {
            Runnable poll = this.f40673a.poll();
            this.f40674b = poll;
            if (poll != null) {
                l.f40669a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f40673a.offer(new Runnable() { // from class: com.tencent.open.utils.l.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.f40674b == null) {
                a();
            }
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static Handler a() {
        if (f40671c == null) {
            synchronized (l.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f40672d = handlerThread;
                handlerThread.start();
                f40671c = new Handler(f40672d.getLooper());
            }
        }
        return f40671c;
    }

    public static Executor b() {
        return new a(null);
    }

    private static Executor c() {
        return new ThreadPoolExecutor(0, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }
}
