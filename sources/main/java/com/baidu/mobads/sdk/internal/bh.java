package com.baidu.mobads.sdk.internal;

import java.lang.Thread;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class bh implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bg f10720a;

    bh(bg bgVar) {
        this.f10720a = bgVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        az.h("ThreadPoolFactory").c("线程名字=" + thread.getName() + "线程crash信息", th);
    }
}
