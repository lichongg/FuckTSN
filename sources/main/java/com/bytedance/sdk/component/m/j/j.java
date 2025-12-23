package com.bytedance.sdk.component.m.j;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements ThreadFactory {

    /* renamed from: j, reason: collision with root package name */
    private final ThreadGroup f26596j;
    private final AtomicInteger xt = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.oq.r.cw cwVar = new com.bytedance.sdk.component.oq.r.cw(this.f26596j, runnable, "tt_img_" + this.xt.getAndIncrement());
        if (cwVar.isDaemon()) {
            cwVar.setDaemon(false);
        }
        return cwVar;
    }

    public j(String str) {
        this.f26596j = new ThreadGroup("tt_img_".concat(String.valueOf(str)));
    }
}
