package io.netty.util;

import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ThreadDeathWatcher {
    static final ThreadFactory threadFactory;
    private static volatile Thread watcherThread;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ThreadDeathWatcher.class);
    private static final Queue<Entry> pendingEntries = new ConcurrentLinkedQueue();
    private static final Watcher watcher = new Watcher();
    private static final AtomicBoolean started = new AtomicBoolean();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Entry {
        final boolean isWatch;
        final Runnable task;
        final Thread thread;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.thread == entry.thread && this.task == entry.task;
        }

        public int hashCode() {
            return this.thread.hashCode() ^ this.task.hashCode();
        }

        Entry(Thread thread, Runnable runnable, boolean z5) {
            this.thread = thread;
            this.task = runnable;
            this.isWatch = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Watcher implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<Entry> watchees;

        private Watcher() {
            this.watchees = new ArrayList();
        }

        private void notifyWatchees() {
            List<Entry> list = this.watchees;
            int i6 = 0;
            while (i6 < list.size()) {
                Entry entry = list.get(i6);
                if (entry.thread.isAlive()) {
                    i6++;
                } else {
                    list.remove(i6);
                    try {
                        entry.task.run();
                    } catch (Throwable th) {
                        ThreadDeathWatcher.logger.warn("Thread death watcher task raised an exception:", th);
                    }
                }
            }
        }

        private void fetchWatchees() {
            while (true) {
                Entry entry = (Entry) ThreadDeathWatcher.pendingEntries.poll();
                if (entry == null) {
                    return;
                }
                if (entry.isWatch) {
                    this.watchees.add(entry);
                } else {
                    this.watchees.remove(entry);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                fetchWatchees();
                notifyWatchees();
                fetchWatchees();
                notifyWatchees();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                if (this.watchees.isEmpty() && ThreadDeathWatcher.pendingEntries.isEmpty()) {
                    ThreadDeathWatcher.started.compareAndSet(true, false);
                    if (ThreadDeathWatcher.pendingEntries.isEmpty() || !ThreadDeathWatcher.started.compareAndSet(false, true)) {
                        return;
                    }
                }
            }
        }
    }

    static {
        String str = SystemPropertyUtil.get("io.netty.serviceThreadPrefix");
        String str2 = "threadDeathWatcher";
        if (!StringUtil.isNullOrEmpty(str)) {
            str2 = str + "threadDeathWatcher";
        }
        threadFactory = new DefaultThreadFactory(str2, true, 1, null);
    }

    public static boolean awaitInactivity(long j6, TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        Thread thread = watcherThread;
        if (thread == null) {
            return true;
        }
        thread.join(timeUnit.toMillis(j6));
        return !thread.isAlive();
    }

    private static void schedule(Thread thread, Runnable runnable, boolean z5) {
        pendingEntries.add(new Entry(thread, runnable, z5));
        if (started.compareAndSet(false, true)) {
            final Thread newThread = threadFactory.newThread(watcher);
            AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: io.netty.util.ThreadDeathWatcher.1
                @Override // java.security.PrivilegedAction
                public Void run() {
                    newThread.setContextClassLoader(null);
                    return null;
                }
            });
            newThread.start();
            watcherThread = newThread;
        }
    }

    public static void unwatch(Thread thread, Runnable runnable) {
        if (thread == null) {
            throw new NullPointerException("thread");
        }
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        schedule(thread, runnable, false);
    }

    public static void watch(Thread thread, Runnable runnable) {
        if (thread == null) {
            throw new NullPointerException("thread");
        }
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        if (!thread.isAlive()) {
            throw new IllegalArgumentException("thread must be alive.");
        }
        schedule(thread, runnable, true);
    }

    private ThreadDeathWatcher() {
    }
}
