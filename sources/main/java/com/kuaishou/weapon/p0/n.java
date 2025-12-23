package com.kuaishou.weapon.p0;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes6.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static volatile n f36073a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f36074b = 3;

    /* renamed from: c, reason: collision with root package name */
    private static int f36075c = 6;

    /* renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f36076d;

    public static n a() {
        if (f36073a == null) {
            synchronized (n.class) {
                try {
                    if (f36073a == null) {
                        f36073a = new n();
                    }
                    if (f36076d == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f36074b, f36075c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.1
                            @Override // java.util.concurrent.RejectedExecutionHandler
                            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                            }
                        });
                        f36076d = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        return f36073a;
    }

    private n() {
    }

    public static n a(int i6, int i7) {
        if (f36073a == null) {
            synchronized (n.class) {
                try {
                    if (f36073a == null) {
                        f36074b = i6;
                        f36075c = i7;
                        f36073a = new n();
                        if (f36076d == null) {
                            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f36074b, f36075c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.2
                                @Override // java.util.concurrent.RejectedExecutionHandler
                                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                                }
                            });
                            f36076d = threadPoolExecutor;
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        }
                    }
                } finally {
                }
            }
        }
        return f36073a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f36076d.execute(runnable);
            } catch (Exception unused) {
            }
        }
    }
}
