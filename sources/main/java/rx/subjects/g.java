package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.functions.m;
import rx.internal.operators.v;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
final class g<T> extends AtomicReference<b<T>> implements e.a<T> {
    private static final long serialVersionUID = 6035251036011671568L;

    /* renamed from: a, reason: collision with root package name */
    volatile Object f54546a;

    /* renamed from: b, reason: collision with root package name */
    boolean f54547b;

    /* renamed from: c, reason: collision with root package name */
    rx.functions.b<c<T>> f54548c;

    /* renamed from: d, reason: collision with root package name */
    rx.functions.b<c<T>> f54549d;

    /* renamed from: e, reason: collision with root package name */
    rx.functions.b<c<T>> f54550e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f54551a;

        a(c cVar) {
            this.f54551a = cVar;
        }

        @Override // rx.functions.a
        public void call() {
            g.this.f(this.f54551a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static final class b<T> {

        /* renamed from: c, reason: collision with root package name */
        static final c[] f54553c;

        /* renamed from: d, reason: collision with root package name */
        static final b f54554d;

        /* renamed from: e, reason: collision with root package name */
        static final b f54555e;

        /* renamed from: a, reason: collision with root package name */
        final boolean f54556a;

        /* renamed from: b, reason: collision with root package name */
        final c[] f54557b;

        static {
            c[] cVarArr = new c[0];
            f54553c = cVarArr;
            f54554d = new b(true, cVarArr);
            f54555e = new b(false, cVarArr);
        }

        public b a(c cVar) {
            c[] cVarArr = this.f54557b;
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
            return new b(this.f54556a, cVarArr2);
        }

        public b b(c cVar) {
            c[] cVarArr = this.f54557b;
            int length = cVarArr.length;
            if (length == 1 && cVarArr[0] == cVar) {
                return f54555e;
            }
            if (length != 0) {
                int i6 = length - 1;
                c[] cVarArr2 = new c[i6];
                int i7 = 0;
                for (c cVar2 : cVarArr) {
                    if (cVar2 != cVar) {
                        if (i7 != i6) {
                            cVarArr2[i7] = cVar2;
                            i7++;
                        }
                    }
                }
                if (i7 == 0) {
                    return f54555e;
                }
                if (i7 < i6) {
                    c[] cVarArr3 = new c[i7];
                    System.arraycopy(cVarArr2, 0, cVarArr3, 0, i7);
                    cVarArr2 = cVarArr3;
                }
                return new b(this.f54556a, cVarArr2);
            }
            return this;
        }

        public b(boolean z5, c[] cVarArr) {
            this.f54556a = z5;
            this.f54557b = cVarArr;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static final class c<T> implements rx.f<T> {

        /* renamed from: a, reason: collision with root package name */
        final l<? super T> f54558a;

        /* renamed from: b, reason: collision with root package name */
        boolean f54559b = true;

        /* renamed from: c, reason: collision with root package name */
        boolean f54560c;

        /* renamed from: d, reason: collision with root package name */
        List<Object> f54561d;

        /* renamed from: e, reason: collision with root package name */
        boolean f54562e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f54563f;

        /* renamed from: g, reason: collision with root package name */
        private volatile Object f54564g;

        void e(Object obj) {
            synchronized (this) {
                if (this.f54559b && !this.f54560c) {
                    this.f54559b = false;
                    this.f54560c = obj != null;
                    if (obj != null) {
                        f(null, obj);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0038  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void f(java.util.List<java.lang.Object> r5, java.lang.Object r6) {
            /*
                r4 = this;
                r0 = 1
                r1 = 1
            L2:
                r2 = 0
                if (r5 == 0) goto L1a
                java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L17
            L9:
                boolean r3 = r5.hasNext()     // Catch: java.lang.Throwable -> L17
                if (r3 == 0) goto L1a
                java.lang.Object r3 = r5.next()     // Catch: java.lang.Throwable -> L17
                r4.d(r3)     // Catch: java.lang.Throwable -> L17
                goto L9
            L17:
                r5 = move-exception
                r0 = 0
                goto L36
            L1a:
                if (r1 == 0) goto L20
                r4.d(r6)     // Catch: java.lang.Throwable -> L17
                r1 = 0
            L20:
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L17
                java.util.List<java.lang.Object> r5 = r4.f54561d     // Catch: java.lang.Throwable -> L2e
                r3 = 0
                r4.f54561d = r3     // Catch: java.lang.Throwable -> L2e
                if (r5 != 0) goto L31
                r4.f54560c = r2     // Catch: java.lang.Throwable -> L2e
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L2c
                return
            L2c:
                r5 = move-exception
                goto L33
            L2e:
                r5 = move-exception
                r0 = 0
                goto L33
            L31:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L2e
                goto L2
            L33:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L2c
                throw r5     // Catch: java.lang.Throwable -> L35
            L35:
                r5 = move-exception
            L36:
                if (r0 != 0) goto L40
                monitor-enter(r4)
                r4.f54560c = r2     // Catch: java.lang.Throwable -> L3d
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3d
                goto L40
            L3d:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3d
                throw r5
            L40:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.g.c.f(java.util.List, java.lang.Object):void");
        }

        public void A(Object obj) {
            this.f54564g = obj;
        }

        void d(Object obj) {
            if (obj != null) {
                v.a(this.f54558a, obj);
            }
        }

        void g(Object obj) {
            if (!this.f54562e) {
                synchronized (this) {
                    try {
                        this.f54559b = false;
                        if (this.f54560c) {
                            if (this.f54561d == null) {
                                this.f54561d = new ArrayList();
                            }
                            this.f54561d.add(obj);
                            return;
                        }
                        this.f54562e = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            v.a(this.f54558a, obj);
        }

        rx.f<? super T> j() {
            return this.f54558a;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f54558a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f54558a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f54558a.onNext(t5);
        }

        public <I> I s() {
            return (I) this.f54564g;
        }

        public c(l<? super T> lVar) {
            this.f54558a = lVar;
        }
    }

    public g() {
        super(b.f54555e);
        this.f54547b = true;
        this.f54548c = m.a();
        this.f54549d = m.a();
        this.f54550e = m.a();
    }

    void b(l<? super T> lVar, c<T> cVar) {
        lVar.add(rx.subscriptions.f.a(new a(cVar)));
    }

    Object c() {
        return this.f54546a;
    }

    @Override // rx.functions.b
    public void call(l<? super T> lVar) {
        c<T> cVar = new c<>(lVar);
        b(lVar, cVar);
        this.f54548c.call(cVar);
        if (!lVar.isUnsubscribed() && a(cVar) && lVar.isUnsubscribed()) {
            f(cVar);
        }
    }

    void g(Object obj) {
        this.f54546a = obj;
    }

    boolean a(c<T> cVar) {
        b<T> bVar;
        do {
            bVar = get();
            if (bVar.f54556a) {
                this.f54550e.call(cVar);
                return false;
            }
        } while (!compareAndSet(bVar, bVar.a(cVar)));
        this.f54549d.call(cVar);
        return true;
    }

    c<T>[] d(Object obj) {
        g(obj);
        return get().f54557b;
    }

    c<T>[] e() {
        return get().f54557b;
    }

    void f(c<T> cVar) {
        b<T> bVar;
        b<T> b6;
        do {
            bVar = get();
            if (bVar.f54556a || (b6 = bVar.b(cVar)) == bVar) {
                return;
            }
        } while (!compareAndSet(bVar, b6));
    }

    c<T>[] h(Object obj) {
        g(obj);
        this.f54547b = false;
        if (get().f54556a) {
            return b.f54553c;
        }
        return getAndSet(b.f54554d).f54557b;
    }
}
