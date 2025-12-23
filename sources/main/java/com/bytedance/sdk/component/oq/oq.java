package com.bytedance.sdk.component.oq;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq implements ThreadFactory {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    public final String f26631j;

    /* renamed from: r, reason: collision with root package name */
    private final AtomicInteger f26632r;
    private final ThreadGroup xt;

    public oq(String str) {
        this(5, str);
    }

    public oq(int i6, String str) {
        this.f26632r = new AtomicInteger(1);
        this.cw = i6;
        this.xt = new ThreadGroup("csj_g_" + str);
        StringBuilder sb = new StringBuilder("csj_");
        sb.append(qv.xt.m() ? "p" : "");
        sb.append(str);
        this.f26631j = sb.toString();
    }

    protected Thread j(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new com.bytedance.sdk.component.oq.r.cw(threadGroup, runnable, str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread j6 = j(this.xt, runnable, this.f26631j + "_" + this.f26632r.getAndIncrement());
        if (j6.isDaemon()) {
            j6.setDaemon(false);
        }
        int i6 = this.cw;
        if (i6 > 10) {
            this.cw = 10;
        } else if (i6 <= 0) {
            this.cw = 1;
        }
        j6.setPriority(this.cw);
        return j6;
    }
}
