package com.baidu.liantian.b;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class r {

    /* renamed from: b, reason: collision with root package name */
    private static final int f10379b = Runtime.getRuntime().availableProcessors();

    /* renamed from: c, reason: collision with root package name */
    private static volatile r f10380c;

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f10381a;

    public final void a(Runnable runnable) {
        try {
            this.f10381a.execute(runnable);
        } catch (Throwable unused) {
            e.a();
        }
    }

    private r() {
        int i6;
        this.f10381a = null;
        int i7 = f10379b;
        if (i7 <= 0) {
            i6 = 1;
        } else {
            i6 = i7;
        }
        com.baidu.liantian.b.a();
        this.f10381a = new ThreadPoolExecutor(i6, i6, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static r a() {
        if (f10380c == null) {
            try {
                synchronized (r.class) {
                    try {
                        if (f10380c == null) {
                            f10380c = new r();
                        }
                    } finally {
                    }
                }
            } catch (Throwable unused) {
                e.a();
            }
        }
        return f10380c;
    }
}
