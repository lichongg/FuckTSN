package com.amap.api.col.s;

import com.amap.api.col.s.x3;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class y3 extends a4 {

    /* renamed from: d, reason: collision with root package name */
    private static y3 f8774d = new y3(new x3.b().a("amap-global-threadPool").b());

    public static y3 e() {
        return f8774d;
    }

    private y3(x3 x3Var) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(x3Var.a(), x3Var.b(), x3Var.d(), TimeUnit.SECONDS, x3Var.c(), x3Var);
            this.f7869a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            g2.o(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }
}
