package com.huawei.hmf.tasks.a;

import android.app.Activity;
import com.huawei.hmf.tasks.k;
import com.huawei.hmf.tasks.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class i<TResult> extends k<TResult> {

    /* renamed from: b, reason: collision with root package name */
    private boolean f33063b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f33064c;

    /* renamed from: d, reason: collision with root package name */
    private TResult f33065d;

    /* renamed from: e, reason: collision with root package name */
    private Exception f33066e;

    /* renamed from: a, reason: collision with root package name */
    private final Object f33062a = new Object();

    /* renamed from: f, reason: collision with root package name */
    private List<com.huawei.hmf.tasks.e<TResult>> f33067f = new ArrayList();

    final class a implements com.huawei.hmf.tasks.i<TResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.huawei.hmf.tasks.j f33068a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f33069b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* renamed from: com.huawei.hmf.tasks.a.i$a$a, reason: collision with other inner class name */
        final class C0541a<TContinuationResult> implements com.huawei.hmf.tasks.g<TContinuationResult> {
            C0541a() {
            }

            @Override // com.huawei.hmf.tasks.g
            public final void a(k<TContinuationResult> kVar) {
                if (kVar.v()) {
                    a.this.f33069b.A(kVar.r());
                } else if (kVar.t()) {
                    a.this.f33069b.B();
                } else {
                    a.this.f33069b.z(kVar.q());
                }
            }
        }

        a(com.huawei.hmf.tasks.j jVar, i iVar) {
            this.f33068a = jVar;
            this.f33069b = iVar;
        }

        @Override // com.huawei.hmf.tasks.i
        public final void onSuccess(TResult tresult) {
            try {
                k then = this.f33068a.then(tresult);
                if (then == null) {
                    this.f33069b.z(new NullPointerException("SuccessContinuation returned null"));
                } else {
                    then.e(new C0541a());
                }
            } catch (Exception e6) {
                this.f33069b.z(e6);
            }
        }
    }

    final class b implements com.huawei.hmf.tasks.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f33072a;

        b(i iVar) {
            this.f33072a = iVar;
        }

        @Override // com.huawei.hmf.tasks.h
        public final void onFailure(Exception exc) {
            this.f33072a.z(exc);
        }
    }

    final class c implements com.huawei.hmf.tasks.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f33074a;

        c(i iVar) {
            this.f33074a = iVar;
        }

        @Override // com.huawei.hmf.tasks.f
        public final void onCanceled() {
            this.f33074a.B();
        }
    }

    final class d implements com.huawei.hmf.tasks.g<TResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.huawei.hmf.tasks.d f33076a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f33077b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        final class a<TContinuationResult> implements com.huawei.hmf.tasks.g<TContinuationResult> {
            a() {
            }

            @Override // com.huawei.hmf.tasks.g
            public final void a(k<TContinuationResult> kVar) {
                if (kVar.v()) {
                    d.this.f33077b.A(kVar.r());
                } else if (kVar.t()) {
                    d.this.f33077b.B();
                } else {
                    d.this.f33077b.z(kVar.q());
                }
            }
        }

        d(com.huawei.hmf.tasks.d dVar, i iVar) {
            this.f33076a = dVar;
            this.f33077b = iVar;
        }

        @Override // com.huawei.hmf.tasks.g
        public final void a(k<TResult> kVar) {
            try {
                k kVar2 = (k) this.f33076a.a(kVar);
                if (kVar2 == null) {
                    this.f33077b.z(new NullPointerException("Continuation returned null"));
                } else {
                    kVar2.e(new a());
                }
            } catch (Exception e6) {
                this.f33077b.z(e6);
            }
        }
    }

    final class e implements com.huawei.hmf.tasks.g<TResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f33080a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.huawei.hmf.tasks.d f33081b;

        e(i iVar, com.huawei.hmf.tasks.d dVar) {
            this.f33080a = iVar;
            this.f33081b = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hmf.tasks.g
        public final void a(k<TResult> kVar) {
            if (kVar.t()) {
                this.f33080a.B();
                return;
            }
            try {
                this.f33080a.A(this.f33081b.a(kVar));
            } catch (Exception e6) {
                this.f33080a.z(e6);
            }
        }
    }

    private void C() {
        synchronized (this.f33062a) {
            Iterator<com.huawei.hmf.tasks.e<TResult>> it = this.f33067f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e6) {
                    throw e6;
                } catch (Exception e7) {
                    throw new RuntimeException(e7);
                }
            }
            this.f33067f = null;
        }
    }

    private k<TResult> y(com.huawei.hmf.tasks.e<TResult> eVar) {
        boolean u5;
        synchronized (this.f33062a) {
            try {
                u5 = u();
                if (!u5) {
                    this.f33067f.add(eVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (u5) {
            eVar.a(this);
        }
        return this;
    }

    public final void A(TResult tresult) {
        synchronized (this.f33062a) {
            try {
                if (!this.f33063b) {
                    this.f33063b = true;
                    this.f33065d = tresult;
                    this.f33062a.notifyAll();
                    C();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean B() {
        synchronized (this.f33062a) {
            try {
                if (this.f33063b) {
                    return false;
                }
                this.f33063b = true;
                this.f33064c = true;
                this.f33062a.notifyAll();
                C();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.huawei.hmf.tasks.k
    public final k<TResult> a(Activity activity, com.huawei.hmf.tasks.f fVar) {
        com.huawei.hmf.tasks.a.b bVar = new com.huawei.hmf.tasks.a.b(m.c(), fVar);
        g.c(activity, bVar);
        return y(bVar);
    }

    @Override // com.huawei.hmf.tasks.k
    public final k<TResult> c(Executor executor, com.huawei.hmf.tasks.f fVar) {
        return y(new com.huawei.hmf.tasks.a.b(executor, fVar));
    }

    @Override // com.huawei.hmf.tasks.k
    public final k<TResult> d(Activity activity, com.huawei.hmf.tasks.g<TResult> gVar) {
        com.huawei.hmf.tasks.a.d dVar = new com.huawei.hmf.tasks.a.d(m.c(), gVar);
        g.c(activity, dVar);
        return y(dVar);
    }

    @Override // com.huawei.hmf.tasks.k
    public final k<TResult> f(Executor executor, com.huawei.hmf.tasks.g<TResult> gVar) {
        return y(new com.huawei.hmf.tasks.a.d(executor, gVar));
    }

    @Override // com.huawei.hmf.tasks.k
    public final k<TResult> g(Activity activity, com.huawei.hmf.tasks.h hVar) {
        f fVar = new f(m.c(), hVar);
        g.c(activity, fVar);
        return y(fVar);
    }

    @Override // com.huawei.hmf.tasks.k
    public final k<TResult> i(Executor executor, com.huawei.hmf.tasks.h hVar) {
        return y(new f(executor, hVar));
    }

    @Override // com.huawei.hmf.tasks.k
    public final k<TResult> j(Activity activity, com.huawei.hmf.tasks.i<TResult> iVar) {
        h hVar = new h(m.c(), iVar);
        g.c(activity, hVar);
        return y(hVar);
    }

    @Override // com.huawei.hmf.tasks.k
    public final k<TResult> l(Executor executor, com.huawei.hmf.tasks.i<TResult> iVar) {
        return y(new h(executor, iVar));
    }

    @Override // com.huawei.hmf.tasks.k
    public final <TContinuationResult> k<TContinuationResult> n(Executor executor, com.huawei.hmf.tasks.d<TResult, TContinuationResult> dVar) {
        i iVar = new i();
        f(executor, new e(iVar, dVar));
        return iVar;
    }

    @Override // com.huawei.hmf.tasks.k
    public final <TContinuationResult> k<TContinuationResult> p(Executor executor, com.huawei.hmf.tasks.d<TResult, k<TContinuationResult>> dVar) {
        i iVar = new i();
        f(executor, new d(dVar, iVar));
        return iVar;
    }

    @Override // com.huawei.hmf.tasks.k
    public final Exception q() {
        Exception exc;
        synchronized (this.f33062a) {
            exc = this.f33066e;
        }
        return exc;
    }

    @Override // com.huawei.hmf.tasks.k
    public final TResult r() {
        TResult tresult;
        synchronized (this.f33062a) {
            try {
                if (this.f33066e != null) {
                    throw new RuntimeException(this.f33066e);
                }
                tresult = this.f33065d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tresult;
    }

    @Override // com.huawei.hmf.tasks.k
    public final <E extends Throwable> TResult s(Class<E> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f33062a) {
            if (cls != null) {
                try {
                    if (cls.isInstance(this.f33066e)) {
                        throw cls.cast(this.f33066e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f33066e != null) {
                throw new RuntimeException(this.f33066e);
            }
            tresult = this.f33065d;
        }
        return tresult;
    }

    @Override // com.huawei.hmf.tasks.k
    public final boolean t() {
        return this.f33064c;
    }

    @Override // com.huawei.hmf.tasks.k
    public final boolean u() {
        boolean z5;
        synchronized (this.f33062a) {
            z5 = this.f33063b;
        }
        return z5;
    }

    @Override // com.huawei.hmf.tasks.k
    public final boolean v() {
        boolean z5;
        synchronized (this.f33062a) {
            try {
                z5 = this.f33063b && !t() && this.f33066e == null;
            } finally {
            }
        }
        return z5;
    }

    @Override // com.huawei.hmf.tasks.k
    public final <TContinuationResult> k<TContinuationResult> x(Executor executor, com.huawei.hmf.tasks.j<TResult, TContinuationResult> jVar) {
        i iVar = new i();
        l(executor, new a(jVar, iVar));
        h(new b(iVar));
        b(new c(iVar));
        return iVar;
    }

    public final void z(Exception exc) {
        synchronized (this.f33062a) {
            try {
                if (!this.f33063b) {
                    this.f33063b = true;
                    this.f33066e = exc;
                    this.f33062a.notifyAll();
                    C();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.huawei.hmf.tasks.k
    public final k<TResult> b(com.huawei.hmf.tasks.f fVar) {
        return c(m.c(), fVar);
    }

    @Override // com.huawei.hmf.tasks.k
    public final k<TResult> e(com.huawei.hmf.tasks.g<TResult> gVar) {
        return f(m.c(), gVar);
    }

    @Override // com.huawei.hmf.tasks.k
    public final k<TResult> h(com.huawei.hmf.tasks.h hVar) {
        return i(m.c(), hVar);
    }

    @Override // com.huawei.hmf.tasks.k
    public final k<TResult> k(com.huawei.hmf.tasks.i<TResult> iVar) {
        return l(m.c(), iVar);
    }

    @Override // com.huawei.hmf.tasks.k
    public final <TContinuationResult> k<TContinuationResult> m(com.huawei.hmf.tasks.d<TResult, TContinuationResult> dVar) {
        return n(m.c(), dVar);
    }

    @Override // com.huawei.hmf.tasks.k
    public final <TContinuationResult> k<TContinuationResult> o(com.huawei.hmf.tasks.d<TResult, k<TContinuationResult>> dVar) {
        return p(m.c(), dVar);
    }

    @Override // com.huawei.hmf.tasks.k
    public final <TContinuationResult> k<TContinuationResult> w(com.huawei.hmf.tasks.j<TResult, TContinuationResult> jVar) {
        return x(m.c(), jVar);
    }
}
