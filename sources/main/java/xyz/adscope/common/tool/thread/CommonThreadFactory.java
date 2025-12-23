package xyz.adscope.common.tool.thread;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class CommonThreadFactory implements ThreadFactory {

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicInteger f56750e = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    private final ThreadGroup f56751a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f56752b = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    private final String f56753c;

    /* renamed from: d, reason: collision with root package name */
    private final int f56754d;

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f56751a, runnable, this.f56753c + this.f56752b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.f56754d == 1) {
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

    CommonThreadFactory(int i6, String str) {
        ThreadGroup threadGroup;
        this.f56754d = i6;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f56751a = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.f56753c = "common-adsdk-background-" + f56750e.getAndIncrement() + "-thread-";
            return;
        }
        this.f56753c = str + f56750e.getAndIncrement() + "-thread-";
    }
}
