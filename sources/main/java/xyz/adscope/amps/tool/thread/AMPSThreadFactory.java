package xyz.adscope.amps.tool.thread;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSThreadFactory implements ThreadFactory {
    private static final AtomicInteger threadNum = new AtomicInteger(1);
    private final AtomicInteger NEW_NUM = new AtomicInteger(1);
    private final int priority;
    private final ThreadGroup threadGroup;
    private final String threadName;

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

    AMPSThreadFactory(int i6, String str) {
        ThreadGroup threadGroup;
        this.priority = i6;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.threadGroup = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.threadName = "amps-adsdk-background-" + threadNum.getAndIncrement() + "-thread-";
            return;
        }
        this.threadName = str + threadNum.getAndIncrement() + "-thread-";
    }
}
