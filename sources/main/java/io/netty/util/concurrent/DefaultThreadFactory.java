package io.netty.util.concurrent;

import io.netty.util.internal.StringUtil;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolId = new AtomicInteger();
    private final boolean daemon;
    private final AtomicInteger nextId;
    private final String prefix;
    private final int priority;
    protected final ThreadGroup threadGroup;

    public DefaultThreadFactory(Class<?> cls) {
        this(cls, false, 5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = newThread(FastThreadLocalRunnable.wrap(runnable), this.prefix + this.nextId.incrementAndGet());
        try {
            boolean isDaemon = newThread.isDaemon();
            boolean z5 = this.daemon;
            if (isDaemon != z5) {
                newThread.setDaemon(z5);
            }
            int priority = newThread.getPriority();
            int i6 = this.priority;
            if (priority != i6) {
                newThread.setPriority(i6);
            }
        } catch (Exception unused) {
        }
        return newThread;
    }

    public DefaultThreadFactory(String str) {
        this(str, false, 5);
    }

    public static String toPoolName(Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException("poolType");
        }
        String simpleClassName = StringUtil.simpleClassName(cls);
        int length = simpleClassName.length();
        if (length == 0) {
            return "unknown";
        }
        if (length == 1) {
            return simpleClassName.toLowerCase(Locale.US);
        }
        if (!Character.isUpperCase(simpleClassName.charAt(0)) || !Character.isLowerCase(simpleClassName.charAt(1))) {
            return simpleClassName;
        }
        return Character.toLowerCase(simpleClassName.charAt(0)) + simpleClassName.substring(1);
    }

    public DefaultThreadFactory(Class<?> cls, boolean z5) {
        this(cls, z5, 5);
    }

    public DefaultThreadFactory(String str, boolean z5) {
        this(str, z5, 5);
    }

    public DefaultThreadFactory(Class<?> cls, int i6) {
        this(cls, false, i6);
    }

    public DefaultThreadFactory(String str, int i6) {
        this(str, false, i6);
    }

    protected Thread newThread(Runnable runnable, String str) {
        return new FastThreadLocalThread(this.threadGroup, runnable, str);
    }

    public DefaultThreadFactory(Class<?> cls, boolean z5, int i6) {
        this(toPoolName(cls), z5, i6);
    }

    public DefaultThreadFactory(String str, boolean z5, int i6, ThreadGroup threadGroup) {
        this.nextId = new AtomicInteger();
        if (str == null) {
            throw new NullPointerException("poolName");
        }
        if (i6 >= 1 && i6 <= 10) {
            this.prefix = str + '-' + poolId.incrementAndGet() + '-';
            this.daemon = z5;
            this.priority = i6;
            this.threadGroup = threadGroup;
            return;
        }
        throw new IllegalArgumentException("priority: " + i6 + " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
    }

    public DefaultThreadFactory(String str, boolean z5, int i6) {
        this(str, z5, i6, System.getSecurityManager() == null ? Thread.currentThread().getThreadGroup() : System.getSecurityManager().getThreadGroup());
    }
}
