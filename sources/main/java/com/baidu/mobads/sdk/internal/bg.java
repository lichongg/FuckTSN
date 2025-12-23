package com.baidu.mobads.sdk.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class bg implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f10719a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "MobAds-p-" + this.f10719a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new bh(this));
        return thread;
    }

    bg() {
    }
}
