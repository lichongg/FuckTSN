package com.scwang.smartrefresh.layout.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public long f37475a;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f37476b;

    public b(Runnable runnable) {
        this.f37476b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Runnable runnable = this.f37476b;
            if (runnable != null) {
                runnable.run();
                this.f37476b = null;
            }
        } catch (Throwable unused) {
        }
    }

    public b(Runnable runnable, long j6) {
        this.f37476b = runnable;
        this.f37475a = j6;
    }
}
