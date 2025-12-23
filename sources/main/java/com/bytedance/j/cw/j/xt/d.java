package com.bytedance.j.cw.j.xt;

import com.bytedance.j.cw.j.xt.xt;
import com.bytedance.sdk.component.oq.cw;
import com.bytedance.sdk.component.oq.r.r;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int f24128a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f24129b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f24130c;

    /* renamed from: d, reason: collision with root package name */
    private static final PriorityBlockingQueue<Runnable> f24131d;

    /* renamed from: e, reason: collision with root package name */
    private static final PriorityBlockingQueue<Runnable> f24132e;

    public static ScheduledExecutorService a() {
        return cw.cw(new c(xt.j.LOW, "tt-delay-thread-"));
    }

    public static ThreadPoolExecutor b() {
        int i6 = f24129b;
        return new r(i6, i6, 1L, TimeUnit.SECONDS, f24131d, new c(xt.j.NORMAL, "tt-api-thread-"));
    }

    public static ThreadPoolExecutor c() {
        int i6 = f24130c;
        return new r(i6, i6, 1L, TimeUnit.SECONDS, f24132e, new c(xt.j.NORMAL, "tt-default-thread-"));
    }

    static {
        int i6;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f24128a = availableProcessors;
        int i7 = 4;
        if ((availableProcessors / 2) + 1 < 4) {
            i6 = 4;
        } else {
            i6 = (availableProcessors / 2) + 1;
        }
        f24129b = i6;
        if ((availableProcessors / 2) + 1 >= 4) {
            i7 = (availableProcessors / 2) + 1;
        }
        f24130c = i7;
        f24131d = new PriorityBlockingQueue<>();
        f24132e = new PriorityBlockingQueue<>();
    }
}
