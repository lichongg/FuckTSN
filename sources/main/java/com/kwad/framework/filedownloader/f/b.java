package com.kwad.framework.filedownloader.f;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {
    private static volatile ThreadPoolExecutor apA;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements ThreadFactory {
        private static final AtomicInteger apB = new AtomicInteger(1);
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, "ksad-" + this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }

        a(String str) {
            this.namePrefix = f.bG(str);
        }
    }

    private static boolean zx() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            return hVar.zx();
        }
        return false;
    }

    private static ThreadPoolExecutor zy() {
        if (apA == null) {
            synchronized (b.class) {
                try {
                    if (apA == null) {
                        com.kwad.sdk.core.threads.a.b bVar = new com.kwad.sdk.core.threads.a.b(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(""));
                        apA = bVar;
                        com.kwad.sdk.core.threads.c.a(bVar, "ksad-filedownload-default");
                    }
                } finally {
                }
            }
        }
        return apA;
    }

    @Deprecated
    public static ThreadPoolExecutor a(int i6, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        if (zx()) {
            return zy();
        }
        com.kwad.sdk.core.threads.a.b bVar = new com.kwad.sdk.core.threads.a.b(i6, i6, 15L, TimeUnit.SECONDS, linkedBlockingQueue, new a(str));
        com.kwad.sdk.core.threads.c.a(bVar, "ksad-" + str);
        bVar.allowCoreThreadTimeOut(true);
        return bVar;
    }

    @Deprecated
    public static ThreadPoolExecutor bA(String str) {
        if (zx()) {
            return zy();
        }
        com.kwad.sdk.core.threads.a.b bVar = new com.kwad.sdk.core.threads.a.b(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new SynchronousQueue(), new a(str));
        com.kwad.sdk.core.threads.c.a(bVar, "ksad-" + str);
        return bVar;
    }

    @Deprecated
    public static ThreadPoolExecutor r(int i6, String str) {
        if (zx()) {
            return zy();
        }
        return a(i6, new LinkedBlockingQueue(), str);
    }
}
