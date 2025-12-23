package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.MissingBackpressureException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v2<T> extends rx.observables.c<T> {

    /* renamed from: b, reason: collision with root package name */
    final rx.e<? extends T> f53610b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<d<T>> f53611c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements e.a<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f53612a;

        a(AtomicReference atomicReference) {
            this.f53612a = atomicReference;
        }

        @Override // rx.functions.b
        public void call(rx.l<? super T> lVar) {
            while (true) {
                d dVar = (d) this.f53612a.get();
                if (dVar == null || dVar.isUnsubscribed()) {
                    d dVar2 = new d(this.f53612a);
                    dVar2.A();
                    if (androidx.camera.view.p.a(this.f53612a, dVar, dVar2)) {
                        dVar = dVar2;
                    } else {
                        continue;
                    }
                }
                c<T> cVar = new c<>(dVar, lVar);
                if (dVar.g(cVar)) {
                    lVar.add(cVar);
                    lVar.setProducer(cVar);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b<R> implements e.a<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f53613a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.p f53614b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.e f53615c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends rx.l<R> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.l f53616a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ OnSubscribePublishMulticast f53617b;

            a(rx.l lVar, OnSubscribePublishMulticast onSubscribePublishMulticast) {
                this.f53616a = lVar;
                this.f53617b = onSubscribePublishMulticast;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f53617b.unsubscribe();
                this.f53616a.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f53617b.unsubscribe();
                this.f53616a.onError(th);
            }

            @Override // rx.f
            public void onNext(R r5) {
                this.f53616a.onNext(r5);
            }

            @Override // rx.l, rx.observers.a
            public void setProducer(rx.g gVar) {
                this.f53616a.setProducer(gVar);
            }
        }

        b(boolean z5, rx.functions.p pVar, rx.e eVar) {
            this.f53613a = z5;
            this.f53614b = pVar;
            this.f53615c = eVar;
        }

        @Override // rx.functions.b
        public void call(rx.l<? super R> lVar) {
            OnSubscribePublishMulticast onSubscribePublishMulticast = new OnSubscribePublishMulticast(rx.internal.util.j.f54163d, this.f53613a);
            a aVar = new a(lVar, onSubscribePublishMulticast);
            lVar.add(onSubscribePublishMulticast);
            lVar.add(aVar);
            ((rx.e) this.f53614b.call(rx.e.I6(onSubscribePublishMulticast))).J6(aVar);
            this.f53615c.J6(onSubscribePublishMulticast.subscriber());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> extends AtomicLong implements rx.g, rx.m {

        /* renamed from: c, reason: collision with root package name */
        static final long f53619c = Long.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        static final long f53620d = -4611686018427387904L;
        private static final long serialVersionUID = -4453897557930727610L;

        /* renamed from: a, reason: collision with root package name */
        final d<T> f53621a;

        /* renamed from: b, reason: collision with root package name */
        final rx.l<? super T> f53622b;

        public long a(long j6) {
            long j7;
            long j8;
            if (j6 <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j7 = get();
                if (j7 == f53620d) {
                    throw new IllegalStateException("Produced without request");
                }
                if (j7 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j8 = j7 - j6;
                if (j8 < 0) {
                    throw new IllegalStateException("More produced (" + j6 + ") than requested (" + j7 + ")");
                }
            } while (!compareAndSet(j7, j8));
            return j8;
        }

        @Override // rx.g
        public void request(long j6) {
            long j7;
            long j8;
            if (j6 < 0) {
                return;
            }
            do {
                j7 = get();
                if (j7 == Long.MIN_VALUE) {
                    return;
                }
                if (j7 >= 0 && j6 == 0) {
                    return;
                }
                if (j7 == f53620d) {
                    j8 = j6;
                } else {
                    j8 = j7 + j6;
                    if (j8 < 0) {
                        j8 = Long.MAX_VALUE;
                    }
                }
            } while (!compareAndSet(j7, j8));
            this.f53621a.s();
        }

        public c(d<T> dVar, rx.l<? super T> lVar) {
            this.f53621a = dVar;
            this.f53622b = lVar;
            lazySet(f53620d);
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        @Override // rx.m
        public void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f53621a.B(this);
                this.f53621a.s();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d<T> extends rx.l<T> implements rx.m {

        /* renamed from: h, reason: collision with root package name */
        static final c[] f53623h = new c[0];

        /* renamed from: i, reason: collision with root package name */
        static final c[] f53624i = new c[0];

        /* renamed from: a, reason: collision with root package name */
        final Queue<Object> f53625a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference<d<T>> f53626b;

        /* renamed from: c, reason: collision with root package name */
        volatile Object f53627c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference<c[]> f53628d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicBoolean f53629e;

        /* renamed from: f, reason: collision with root package name */
        boolean f53630f;

        /* renamed from: g, reason: collision with root package name */
        boolean f53631g;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                d.this.f53628d.getAndSet(d.f53624i);
                d dVar = d.this;
                androidx.camera.view.p.a(dVar.f53626b, dVar, null);
            }
        }

        boolean j(Object obj, boolean z5) {
            int i6 = 0;
            if (obj != null) {
                if (!v.f(obj)) {
                    Throwable d6 = v.d(obj);
                    androidx.camera.view.p.a(this.f53626b, this, null);
                    try {
                        c[] andSet = this.f53628d.getAndSet(f53624i);
                        int length = andSet.length;
                        while (i6 < length) {
                            andSet[i6].f53622b.onError(d6);
                            i6++;
                        }
                        return true;
                    } finally {
                    }
                }
                if (z5) {
                    androidx.camera.view.p.a(this.f53626b, this, null);
                    try {
                        c[] andSet2 = this.f53628d.getAndSet(f53624i);
                        int length2 = andSet2.length;
                        while (i6 < length2) {
                            andSet2[i6].f53622b.onCompleted();
                            i6++;
                        }
                        return true;
                    } finally {
                    }
                }
            }
            return false;
        }

        void A() {
            add(rx.subscriptions.f.a(new a()));
        }

        void B(c<T> cVar) {
            c[] cVarArr;
            c[] cVarArr2;
            do {
                cVarArr = this.f53628d.get();
                if (cVarArr == f53623h || cVarArr == f53624i) {
                    return;
                }
                int length = cVarArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        i6 = -1;
                        break;
                    } else if (cVarArr[i6].equals(cVar)) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i6 < 0) {
                    return;
                }
                if (length == 1) {
                    cVarArr2 = f53623h;
                } else {
                    c[] cVarArr3 = new c[length - 1];
                    System.arraycopy(cVarArr, 0, cVarArr3, 0, i6);
                    System.arraycopy(cVarArr, i6 + 1, cVarArr3, i6, (length - i6) - 1);
                    cVarArr2 = cVarArr3;
                }
            } while (!androidx.camera.view.p.a(this.f53628d, cVarArr, cVarArr2));
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53627c == null) {
                this.f53627c = v.b();
                s();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53627c == null) {
                this.f53627c = v.c(th);
                s();
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53625a.offer(v.j(t5))) {
                s();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        @Override // rx.l
        public void onStart() {
            request(rx.internal.util.j.f54163d);
        }

        /* JADX WARN: Code restructure failed: missing block: B:65:0x00ca, code lost:
        
            if (r4 == false) goto L67;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void s() {
            /*
                Method dump skipped, instructions count: 245
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.v2.d.s():void");
        }

        public d(AtomicReference<d<T>> atomicReference) {
            Queue<Object> dVar;
            if (rx.internal.util.unsafe.n0.f()) {
                dVar = new rx.internal.util.unsafe.z<>(rx.internal.util.j.f54163d);
            } else {
                dVar = new rx.internal.util.atomic.d<>(rx.internal.util.j.f54163d);
            }
            this.f53625a = dVar;
            this.f53628d = new AtomicReference<>(f53623h);
            this.f53626b = atomicReference;
            this.f53629e = new AtomicBoolean();
        }

        boolean g(c<T> cVar) {
            c[] cVarArr;
            c[] cVarArr2;
            cVar.getClass();
            do {
                cVarArr = this.f53628d.get();
                if (cVarArr == f53624i) {
                    return false;
                }
                int length = cVarArr.length;
                cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
            } while (!androidx.camera.view.p.a(this.f53628d, cVarArr, cVarArr2));
            return true;
        }
    }

    public static <T, R> rx.e<R> C7(rx.e<? extends T> eVar, rx.functions.p<? super rx.e<T>, ? extends rx.e<R>> pVar) {
        return D7(eVar, pVar, false);
    }

    public static <T, R> rx.e<R> D7(rx.e<? extends T> eVar, rx.functions.p<? super rx.e<T>, ? extends rx.e<R>> pVar, boolean z5) {
        return rx.e.I6(new b(z5, pVar, eVar));
    }

    public static <T> rx.observables.c<T> E7(rx.e<? extends T> eVar) {
        AtomicReference atomicReference = new AtomicReference();
        return new v2(new a(atomicReference), eVar, atomicReference);
    }

    @Override // rx.observables.c
    public void A7(rx.functions.b<? super rx.m> bVar) {
        d<T> dVar;
        while (true) {
            dVar = this.f53611c.get();
            if (dVar != null && !dVar.isUnsubscribed()) {
                break;
            }
            d<T> dVar2 = new d<>(this.f53611c);
            dVar2.A();
            if (androidx.camera.view.p.a(this.f53611c, dVar, dVar2)) {
                dVar = dVar2;
                break;
            }
        }
        boolean z5 = false;
        if (!dVar.f53629e.get() && dVar.f53629e.compareAndSet(false, true)) {
            z5 = true;
        }
        bVar.call(dVar);
        if (z5) {
            this.f53610b.J6(dVar);
        }
    }

    private v2(e.a<T> aVar, rx.e<? extends T> eVar, AtomicReference<d<T>> atomicReference) {
        super(aVar);
        this.f53610b = eVar;
        this.f53611c = atomicReference;
    }
}
