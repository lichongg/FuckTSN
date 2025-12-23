package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.j;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\Downloads\app\classes5.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static com.huawei.hmf.tasks.a.j f33096a = new com.huawei.hmf.tasks.a.j();

    public static <TResult> TResult c(k<TResult> kVar) throws ExecutionException, InterruptedException {
        com.huawei.hmf.tasks.a.j.e("await must not be called on the UI thread");
        if (kVar.u()) {
            return (TResult) com.huawei.hmf.tasks.a.j.d(kVar);
        }
        j.d dVar = new j.d();
        kVar.k(dVar).h(dVar);
        dVar.f33088a.await();
        return (TResult) com.huawei.hmf.tasks.a.j.d(kVar);
    }

    public static <TResult> k<TResult> call(Callable<TResult> callable) {
        return f33096a.c(m.b(), callable);
    }

    public static <TResult> TResult d(k<TResult> kVar, long j6, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        com.huawei.hmf.tasks.a.j.e("await must not be called on the UI thread");
        if (!kVar.u()) {
            j.d dVar = new j.d();
            kVar.k(dVar).h(dVar);
            if (!dVar.f33088a.await(j6, timeUnit)) {
                throw new TimeoutException("Timed out waiting for Task");
            }
        }
        return (TResult) com.huawei.hmf.tasks.a.j.d(kVar);
    }

    public static <TResult> k<TResult> e(Callable<TResult> callable) {
        return f33096a.c(m.a(), callable);
    }

    public static <TResult> k<TResult> f(Executor executor, Callable<TResult> callable) {
        return f33096a.c(executor, callable);
    }

    public static <TResult> k<TResult> g() {
        com.huawei.hmf.tasks.a.i iVar = new com.huawei.hmf.tasks.a.i();
        iVar.B();
        return iVar;
    }

    public static <TResult> k<TResult> h(Exception exc) {
        l lVar = new l();
        lVar.c(exc);
        return lVar.b();
    }

    public static k<List<k<?>>> a(Collection<? extends k<?>> collection) {
        return com.huawei.hmf.tasks.a.j.b(collection);
    }

    public static k<List<k<?>>> b(k<?>... kVarArr) {
        return com.huawei.hmf.tasks.a.j.b(Arrays.asList(kVarArr));
    }

    public static <TResult> k<TResult> i(TResult tresult) {
        return com.huawei.hmf.tasks.a.j.a(tresult);
    }

    public static k<Void> j(Collection<? extends k<?>> collection) {
        return com.huawei.hmf.tasks.a.j.g(collection);
    }

    public static k<Void> k(k<?>... kVarArr) {
        return com.huawei.hmf.tasks.a.j.g(Arrays.asList(kVarArr));
    }

    public static <TResult> k<List<TResult>> l(Collection<? extends k<TResult>> collection) {
        return com.huawei.hmf.tasks.a.j.f(collection);
    }

    public static <TResult> k<List<TResult>> m(k<?>... kVarArr) {
        return com.huawei.hmf.tasks.a.j.f(Arrays.asList(kVarArr));
    }
}
