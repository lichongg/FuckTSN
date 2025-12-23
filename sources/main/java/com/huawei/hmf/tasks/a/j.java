package com.huawei.hmf.tasks.a;

import android.os.Looper;
import com.huawei.hmf.tasks.k;
import com.huawei.hmf.tasks.l;
import com.huawei.hmf.tasks.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class j {

    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f33083a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Callable f33084b;

        a(l lVar, Callable callable) {
            this.f33083a = lVar;
            this.f33084b = callable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f33083a.setResult(this.f33084b.call());
            } catch (Exception e6) {
                this.f33083a.c(e6);
            }
        }
    }

    static class b implements com.huawei.hmf.tasks.d<Void, List<k<?>>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Collection f33086a;

        b(Collection collection) {
            this.f33086a = collection;
        }

        @Override // com.huawei.hmf.tasks.d
        public final /* synthetic */ List<k<?>> a(k<Void> kVar) throws Exception {
            ArrayList arrayList = new ArrayList(this.f33086a.size());
            arrayList.addAll(this.f33086a);
            return arrayList;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TResult] */
    static class c<TResult> implements com.huawei.hmf.tasks.d<Void, List<TResult>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Collection f33087a;

        c(Collection collection) {
            this.f33087a = collection;
        }

        @Override // com.huawei.hmf.tasks.d
        public final /* synthetic */ Object a(k<Void> kVar) throws Exception {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f33087a.iterator();
            while (it.hasNext()) {
                arrayList.add(((k) it.next()).r());
            }
            return arrayList;
        }
    }

    public static class d<TResult> implements com.huawei.hmf.tasks.f, com.huawei.hmf.tasks.h, com.huawei.hmf.tasks.i<TResult> {

        /* renamed from: a, reason: collision with root package name */
        public final CountDownLatch f33088a = new CountDownLatch(1);

        @Override // com.huawei.hmf.tasks.f
        public final void onCanceled() {
            this.f33088a.countDown();
        }

        @Override // com.huawei.hmf.tasks.h
        public final void onFailure(Exception exc) {
            this.f33088a.countDown();
        }

        @Override // com.huawei.hmf.tasks.i
        public final void onSuccess(TResult tresult) {
            this.f33088a.countDown();
        }
    }

    public static <TResult> k<TResult> a(TResult tresult) {
        l lVar = new l();
        lVar.setResult(tresult);
        return lVar.b();
    }

    public final <TResult> k<TResult> c(Executor executor, Callable<TResult> callable) {
        l lVar = new l();
        try {
            executor.execute(new a(lVar, callable));
        } catch (Exception e6) {
            lVar.c(e6);
        }
        return lVar.b();
    }

    public static k<List<k<?>>> b(Collection<? extends k<?>> collection) {
        return g(collection).m(new b(collection));
    }

    public static <TResult> TResult d(k<TResult> kVar) throws ExecutionException {
        if (kVar.v()) {
            return kVar.r();
        }
        throw new ExecutionException(kVar.q());
    }

    public static void e(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
        } else {
            throw new IllegalStateException(str);
        }
    }

    public static <TResult> k<List<TResult>> f(Collection<? extends k<?>> collection) {
        return (k<List<TResult>>) g(collection).m(new c(collection));
    }

    public static k<Void> g(Collection<? extends k<?>> collection) {
        if (collection.isEmpty()) {
            return a(null);
        }
        Iterator<? extends k<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("task can not is null");
            }
        }
        i iVar = new i();
        e eVar = new e(collection.size(), iVar);
        for (k<?> kVar : collection) {
            kVar.l(m.b(), eVar);
            kVar.i(m.b(), eVar);
            kVar.c(m.b(), eVar);
        }
        return iVar;
    }
}
