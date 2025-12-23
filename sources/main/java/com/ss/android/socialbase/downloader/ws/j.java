package com.ss.android.socialbase.downloader.ws;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes6.dex */
public class j implements ThreadFactory {
    private final boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f39012j;
    private final AtomicInteger xt;

    public j(String str) {
        this(str, false);
    }

    public j(String str, boolean z5) {
        this.xt = new AtomicInteger();
        this.f39012j = str;
        this.cw = z5;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.oq.r.cw cwVar = new com.bytedance.sdk.component.oq.r.cw(runnable, this.f39012j + "-" + this.xt.incrementAndGet());
        if (!this.cw) {
            if (cwVar.isDaemon()) {
                cwVar.setDaemon(false);
            }
            if (cwVar.getPriority() != 5) {
                cwVar.setPriority(5);
            }
        }
        return cwVar;
    }
}
