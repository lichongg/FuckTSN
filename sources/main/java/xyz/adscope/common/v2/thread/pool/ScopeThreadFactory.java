package xyz.adscope.common.v2.thread.pool;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ScopeThreadFactory implements ThreadFactory {
    private static final String DEF_THREAD_NAME_FORMAT = "adScope-%s-%d-thread-";
    private static final AtomicInteger threadNum = new AtomicInteger(1);
    private final AtomicInteger NEW_NUM = new AtomicInteger(1);
    private final int priority;
    private final ThreadGroup threadGroup;
    private final String threadName;

    private ThreadGroup createNewGroup(String str) {
        try {
            return new ThreadGroup(str);
        } catch (SecurityException unused) {
            return Thread.currentThread().getThreadGroup();
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.threadGroup, runnable, this.threadName + this.NEW_NUM.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.priority == 1) {
            thread.setPriority(1);
            return thread;
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(3);
            return thread;
        }
        thread.setPriority(5);
        return thread;
    }

    ScopeThreadFactory(int i6, String str) {
        this.priority = i6;
        this.threadGroup = createNewGroup(str);
        this.threadName = String.format(Locale.ENGLISH, DEF_THREAD_NAME_FORMAT, str, Integer.valueOf(threadNum.getAndIncrement()));
    }
}
