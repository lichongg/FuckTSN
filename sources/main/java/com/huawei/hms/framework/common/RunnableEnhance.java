package com.huawei.hms.framework.common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class RunnableEnhance implements Runnable {
    static final String TRANCELOGO = " -->";

    /* renamed from: a, reason: collision with root package name */
    private Runnable f33343a;

    /* renamed from: b, reason: collision with root package name */
    private String f33344b = Thread.currentThread().getName();

    public String getParentName() {
        return this.f33344b;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f33343a.run();
    }

    RunnableEnhance(Runnable runnable) {
        this.f33343a = runnable;
    }
}
