package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.MissingBackpressureException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f4<R> implements e.b<R, rx.e<?>[]> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.y<? extends R> f52783a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<R> extends AtomicLong {

        /* renamed from: g, reason: collision with root package name */
        static final int f52784g = (int) (rx.internal.util.j.f54163d * 0.7d);
        private static final long serialVersionUID = 5995274816189928317L;

        /* renamed from: a, reason: collision with root package name */
        final rx.f<? super R> f52785a;

        /* renamed from: b, reason: collision with root package name */
        private final rx.functions.y<? extends R> f52786b;

        /* renamed from: c, reason: collision with root package name */
        private final rx.subscriptions.b f52787c;

        /* renamed from: d, reason: collision with root package name */
        int f52788d;

        /* renamed from: e, reason: collision with root package name */
        private volatile Object[] f52789e;

        /* renamed from: f, reason: collision with root package name */
        private AtomicLong f52790f;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.f4$a$a, reason: collision with other inner class name */
        final class C1033a extends rx.l {

            /* renamed from: a, reason: collision with root package name */
            final rx.internal.util.j f52791a = rx.internal.util.j.g();

            C1033a() {
            }

            @Override // rx.f
            public void onCompleted() {
                this.f52791a.H();
                a.this.b();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.f52785a.onError(th);
            }

            @Override // rx.f
            public void onNext(Object obj) {
                try {
                    this.f52791a.P(obj);
                } catch (MissingBackpressureException e6) {
                    onError(e6);
                }
                a.this.b();
            }

            @Override // rx.l
            public void onStart() {
                request(rx.internal.util.j.f54163d);
            }

            public void g(long j6) {
                request(j6);
            }
        }

        public void a(rx.e[] eVarArr, AtomicLong atomicLong) {
            Object[] objArr = new Object[eVarArr.length];
            for (int i6 = 0; i6 < eVarArr.length; i6++) {
                C1033a c1033a = new C1033a();
                objArr[i6] = c1033a;
                this.f52787c.a(c1033a);
            }
            this.f52790f = atomicLong;
            this.f52789e = objArr;
            for (int i7 = 0; i7 < eVarArr.length; i7++) {
                eVarArr[i7].J6((C1033a) objArr[i7]);
            }
        }

        void b() {
            Object[] objArr = this.f52789e;
            if (objArr == null || getAndIncrement() != 0) {
                return;
            }
            int length = objArr.length;
            rx.f<? super R> fVar = this.f52785a;
            AtomicLong atomicLong = this.f52790f;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z5 = true;
                for (int i6 = 0; i6 < length; i6++) {
                    rx.internal.util.j jVar = ((C1033a) objArr[i6]).f52791a;
                    Object Q = jVar.Q();
                    if (Q == null) {
                        z5 = false;
                    } else {
                        if (jVar.A(Q)) {
                            fVar.onCompleted();
                            this.f52787c.unsubscribe();
                            return;
                        }
                        objArr2[i6] = jVar.s(Q);
                    }
                }
                if (z5 && atomicLong.get() > 0) {
                    try {
                        fVar.onNext(this.f52786b.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.f52788d++;
                        for (Object obj : objArr) {
                            rx.internal.util.j jVar2 = ((C1033a) obj).f52791a;
                            jVar2.R();
                            if (jVar2.A(jVar2.Q())) {
                                fVar.onCompleted();
                                this.f52787c.unsubscribe();
                                return;
                            }
                        }
                        if (this.f52788d > f52784g) {
                            for (Object obj2 : objArr) {
                                ((C1033a) obj2).g(this.f52788d);
                            }
                            this.f52788d = 0;
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.g(th, fVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }

        public a(rx.l<? super R> lVar, rx.functions.y<? extends R> yVar) {
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            this.f52787c = bVar;
            this.f52785a = lVar;
            this.f52786b = yVar;
            lVar.add(bVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c extends rx.l<rx.e[]> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super R> f52794a;

        /* renamed from: b, reason: collision with root package name */
        final a<R> f52795b;

        /* renamed from: c, reason: collision with root package name */
        final b<R> f52796c;

        /* renamed from: d, reason: collision with root package name */
        boolean f52797d;

        public c(rx.l<? super R> lVar, a<R> aVar, b<R> bVar) {
            this.f52794a = lVar;
            this.f52795b = aVar;
            this.f52796c = bVar;
        }

        @Override // rx.f
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onNext(rx.e[] eVarArr) {
            if (eVarArr == null || eVarArr.length == 0) {
                this.f52794a.onCompleted();
            } else {
                this.f52797d = true;
                this.f52795b.a(eVarArr, this.f52796c);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f52797d) {
                return;
            }
            this.f52794a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52794a.onError(th);
        }
    }

    public f4(rx.functions.y<? extends R> yVar) {
        this.f52783a = yVar;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<R> extends AtomicLong implements rx.g {
        private static final long serialVersionUID = -1216676403723546796L;

        /* renamed from: a, reason: collision with root package name */
        final a<R> f52793a;

        public b(a<R> aVar) {
            this.f52793a = aVar;
        }

        @Override // rx.g
        public void request(long j6) {
            rx.internal.operators.a.b(this, j6);
            this.f52793a.b();
        }
    }

    @Override // rx.functions.p
    public rx.l<? super rx.e[]> call(rx.l<? super R> lVar) {
        a aVar = new a(lVar, this.f52783a);
        b bVar = new b(aVar);
        c cVar = new c(lVar, aVar, bVar);
        lVar.add(cVar);
        lVar.setProducer(bVar);
        return cVar;
    }

    public f4(rx.functions.q qVar) {
        this.f52783a = rx.functions.a0.g(qVar);
    }

    public f4(rx.functions.r rVar) {
        this.f52783a = rx.functions.a0.h(rVar);
    }

    public f4(rx.functions.s sVar) {
        this.f52783a = rx.functions.a0.i(sVar);
    }

    public f4(rx.functions.t tVar) {
        this.f52783a = rx.functions.a0.j(tVar);
    }

    public f4(rx.functions.u uVar) {
        this.f52783a = rx.functions.a0.k(uVar);
    }

    public f4(rx.functions.v vVar) {
        this.f52783a = rx.functions.a0.l(vVar);
    }

    public f4(rx.functions.w wVar) {
        this.f52783a = rx.functions.a0.m(wVar);
    }

    public f4(rx.functions.x xVar) {
        this.f52783a = rx.functions.a0.n(xVar);
    }
}
