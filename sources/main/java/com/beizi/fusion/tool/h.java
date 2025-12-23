package com.beizi.fusion.tool;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f13706a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private final ThreadGroup f13707b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicInteger f13708c = new AtomicInteger(1);

    /* renamed from: d, reason: collision with root package name */
    private final String f13709d;

    /* renamed from: e, reason: collision with root package name */
    private final int f13710e;

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f13707b, runnable, this.f13709d + this.f13708c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.f13710e == 1) {
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

    h(int i6, String str) {
        ThreadGroup threadGroup;
        this.f13710e = i6;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f13707b = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.f13709d = "afBg-" + f13706a.getAndIncrement() + "Td-";
            return;
        }
        this.f13709d = str + f13706a.getAndIncrement() + "Td-";
    }
}
