package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h<T> extends rx.e<T> {

    /* renamed from: b, reason: collision with root package name */
    private final a<T> f52860b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.internal.util.f implements rx.f<T> {

        /* renamed from: k, reason: collision with root package name */
        static final c<?>[] f52861k = new c[0];

        /* renamed from: f, reason: collision with root package name */
        final rx.e<? extends T> f52862f;

        /* renamed from: g, reason: collision with root package name */
        final rx.subscriptions.e f52863g;

        /* renamed from: h, reason: collision with root package name */
        volatile c<?>[] f52864h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f52865i;

        /* renamed from: j, reason: collision with root package name */
        boolean f52866j;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.h$a$a, reason: collision with other inner class name */
        class C1034a extends rx.l<T> {
            C1034a() {
            }

            @Override // rx.f
            public void onCompleted() {
                a.this.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.onError(th);
            }

            @Override // rx.f
            public void onNext(T t5) {
                a.this.onNext(t5);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void B(c<T> cVar) {
            synchronized (this.f52863g) {
                c<?>[] cVarArr = this.f52864h;
                int length = cVarArr.length;
                c<?>[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                this.f52864h = cVarArr2;
            }
        }

        public void G() {
            C1034a c1034a = new C1034a();
            this.f52863g.b(c1034a);
            this.f52862f.J6(c1034a);
            this.f52865i = true;
        }

        void H() {
            for (c<?> cVar : this.f52864h) {
                cVar.b();
            }
        }

        public void N(c<T> cVar) {
            synchronized (this.f52863g) {
                try {
                    c<?>[] cVarArr = this.f52864h;
                    int length = cVarArr.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            i6 = -1;
                            break;
                        } else if (!cVarArr[i6].equals(cVar)) {
                            i6++;
                        }
                    }
                    if (i6 < 0) {
                        return;
                    }
                    if (length == 1) {
                        this.f52864h = f52861k;
                        return;
                    }
                    c<?>[] cVarArr2 = new c[length - 1];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, i6);
                    System.arraycopy(cVarArr, i6 + 1, cVarArr2, i6, (length - i6) - 1);
                    this.f52864h = cVarArr2;
                } finally {
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f52866j) {
                return;
            }
            this.f52866j = true;
            d(v.b());
            this.f52863g.unsubscribe();
            H();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f52866j) {
                return;
            }
            this.f52866j = true;
            d(v.c(th));
            this.f52863g.unsubscribe();
            H();
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f52866j) {
                return;
            }
            d(v.j(t5));
            H();
        }

        public a(rx.e<? extends T> eVar, int i6) {
            super(i6);
            this.f52862f = eVar;
            this.f52864h = f52861k;
            this.f52863g = new rx.subscriptions.e();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends AtomicBoolean implements e.a<T> {
        private static final long serialVersionUID = -2817751667698696782L;

        /* renamed from: a, reason: collision with root package name */
        final a<T> f52868a;

        @Override // rx.functions.b
        public void call(rx.l<? super T> lVar) {
            c<T> cVar = new c<>(lVar, this.f52868a);
            this.f52868a.B(cVar);
            lVar.add(cVar);
            lVar.setProducer(cVar);
            if (get() || !compareAndSet(false, true)) {
                return;
            }
            this.f52868a.G();
        }

        public b(a<T> aVar) {
            this.f52868a = aVar;
        }
    }

    public static <T> h<T> x7(rx.e<? extends T> eVar, int i6) {
        if (i6 < 1) {
            throw new IllegalArgumentException("capacityHint > 0 required");
        }
        a aVar = new a(eVar, i6);
        return new h<>(new b(aVar), aVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> extends AtomicLong implements rx.g, rx.m {
        private static final long serialVersionUID = -2557562030197141021L;

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f52869a;

        /* renamed from: b, reason: collision with root package name */
        final a<T> f52870b;

        /* renamed from: c, reason: collision with root package name */
        Object[] f52871c;

        /* renamed from: d, reason: collision with root package name */
        int f52872d;

        /* renamed from: e, reason: collision with root package name */
        int f52873e;

        /* renamed from: f, reason: collision with root package name */
        boolean f52874f;

        /* renamed from: g, reason: collision with root package name */
        boolean f52875g;

        public long a(long j6) {
            return addAndGet(-j6);
        }

        /* JADX WARN: Removed duplicated region for block: B:69:0x00e1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void b() {
            /*
                Method dump skipped, instructions count: 236
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.h.c.b():void");
        }

        public c(rx.l<? super T> lVar, a<T> aVar) {
            this.f52869a = lVar;
            this.f52870b = aVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            if (get() < 0) {
                return true;
            }
            return false;
        }

        @Override // rx.g
        public void request(long j6) {
            long j7;
            long j8;
            do {
                j7 = get();
                if (j7 < 0) {
                    return;
                }
                j8 = j7 + j6;
                if (j8 < 0) {
                    j8 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j7, j8));
            b();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (get() >= 0 && getAndSet(-1L) >= 0) {
                this.f52870b.N(this);
            }
        }
    }

    public static <T> h<T> w7(rx.e<? extends T> eVar) {
        return x7(eVar, 16);
    }

    boolean y7() {
        return this.f52860b.f52864h.length != 0;
    }

    boolean z7() {
        return this.f52860b.f52865i;
    }

    private h(e.a<T> aVar, a<T> aVar2) {
        super(aVar);
        this.f52860b = aVar2;
    }
}
