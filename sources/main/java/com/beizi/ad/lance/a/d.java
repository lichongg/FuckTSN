package com.beizi.ad.lance.a;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f12740a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private final ThreadGroup f12741b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicInteger f12742c = new AtomicInteger(1);

    /* renamed from: d, reason: collision with root package name */
    private final String f12743d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12744e;

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f12741b, runnable, this.f12743d + this.f12742c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.f12744e == 1) {
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

    d(int i6, String str) {
        ThreadGroup threadGroup;
        this.f12744e = i6;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f12741b = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.f12743d = "BeiZi-adsdk-background-" + f12740a.getAndIncrement() + "-thread-";
            return;
        }
        this.f12743d = str + f12740a.getAndIncrement() + "-thread-";
    }
}
