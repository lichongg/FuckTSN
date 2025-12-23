package com.bytedance.j.cw.j.xt;

import android.text.TextUtils;
import com.bytedance.j.cw.j.xt.xt;
import com.bytedance.sdk.component.oq.r.cw;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes3.dex */
public class c implements ThreadFactory {

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicInteger f24123e = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    private final ThreadGroup f24124a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f24125b = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    private final String f24126c;

    /* renamed from: d, reason: collision with root package name */
    private final xt.j f24127d;

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        cw cwVar = new cw(this.f24124a, runnable, this.f24126c + this.f24125b.getAndIncrement(), 0L);
        if (cwVar.isDaemon()) {
            cwVar.setDaemon(false);
        }
        xt.j jVar = this.f24127d;
        if (jVar != null && jVar.j() == xt.j.LOW.j()) {
            cwVar.setPriority(1);
            return cwVar;
        }
        if (cwVar.getPriority() != 5) {
            cwVar.setPriority(3);
            return cwVar;
        }
        cwVar.setPriority(5);
        return cwVar;
    }

    c(xt.j jVar, String str) {
        ThreadGroup threadGroup;
        this.f24127d = jVar;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f24124a = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.f24126c = "ttdefault-" + f24123e.getAndIncrement() + "-thread-";
            return;
        }
        this.f24126c = str + f24123e.getAndIncrement() + "-thread-";
    }
}
