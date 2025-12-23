package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o2<T> implements e.b<T, rx.e<? extends T>> {

    /* renamed from: a, reason: collision with root package name */
    final boolean f53276a;

    /* renamed from: b, reason: collision with root package name */
    final int f53277b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> extends rx.l<T> {

        /* renamed from: f, reason: collision with root package name */
        static final int f53280f = rx.internal.util.j.f54163d / 4;

        /* renamed from: a, reason: collision with root package name */
        final e<T> f53281a;

        /* renamed from: b, reason: collision with root package name */
        final long f53282b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f53283c;

        /* renamed from: d, reason: collision with root package name */
        volatile rx.internal.util.j f53284d;

        /* renamed from: e, reason: collision with root package name */
        int f53285e;

        @Override // rx.f
        public void onCompleted() {
            this.f53283c = true;
            this.f53281a.s();
        }

        public void g(long j6) {
            int i6 = this.f53285e - ((int) j6);
            if (i6 > f53280f) {
                this.f53285e = i6;
                return;
            }
            int i7 = rx.internal.util.j.f54163d;
            this.f53285e = i7;
            int i8 = i7 - i6;
            if (i8 > 0) {
                request(i8);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53281a.P().offer(th);
            this.f53283c = true;
            this.f53281a.s();
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53281a.X(this, t5);
        }

        @Override // rx.l
        public void onStart() {
            int i6 = rx.internal.util.j.f54163d;
            this.f53285e = i6;
            request(i6);
        }

        public c(e<T> eVar, long j6) {
            this.f53281a = eVar;
            this.f53282b = j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d<T> extends AtomicLong implements rx.g {
        private static final long serialVersionUID = -1214379189873595503L;

        /* renamed from: a, reason: collision with root package name */
        final e<T> f53286a;

        public long a(int i6) {
            return addAndGet(-i6);
        }

        @Override // rx.g
        public void request(long j6) {
            if (j6 <= 0) {
                if (j6 < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            } else {
                if (get() == Long.MAX_VALUE) {
                    return;
                }
                rx.internal.operators.a.b(this, j6);
                this.f53286a.s();
            }
        }

        public d(e<T> eVar) {
            this.f53286a = eVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e<T> extends rx.l<rx.e<? extends T>> {

        /* renamed from: r, reason: collision with root package name */
        static final c<?>[] f53287r = new c[0];

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f53288a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f53289b;

        /* renamed from: c, reason: collision with root package name */
        final int f53290c;

        /* renamed from: d, reason: collision with root package name */
        d<T> f53291d;

        /* renamed from: e, reason: collision with root package name */
        volatile Queue<Object> f53292e;

        /* renamed from: f, reason: collision with root package name */
        volatile rx.subscriptions.b f53293f;

        /* renamed from: g, reason: collision with root package name */
        volatile ConcurrentLinkedQueue<Throwable> f53294g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f53295h;

        /* renamed from: i, reason: collision with root package name */
        boolean f53296i;

        /* renamed from: j, reason: collision with root package name */
        boolean f53297j;

        /* renamed from: k, reason: collision with root package name */
        final Object f53298k = new Object();

        /* renamed from: l, reason: collision with root package name */
        volatile c<?>[] f53299l = f53287r;

        /* renamed from: m, reason: collision with root package name */
        long f53300m;

        /* renamed from: n, reason: collision with root package name */
        long f53301n;

        /* renamed from: o, reason: collision with root package name */
        int f53302o;

        /* renamed from: p, reason: collision with root package name */
        final int f53303p;

        /* renamed from: q, reason: collision with root package name */
        int f53304q;

        /* JADX WARN: Removed duplicated region for block: B:37:0x01a6  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x00f9 A[Catch: all -> 0x005c, TryCatch #9 {all -> 0x005c, blocks: (B:3:0x0003, B:4:0x0005, B:6:0x000c, B:15:0x0030, B:18:0x0040, B:23:0x0067, B:25:0x0049, B:30:0x004d, B:27:0x0060, B:52:0x007f, B:59:0x009a, B:62:0x00a5, B:66:0x00ad, B:68:0x00b1, B:71:0x00b8, B:73:0x00bc, B:76:0x00c2, B:78:0x00c9, B:85:0x00dc, B:87:0x00e5, B:91:0x00ea, B:95:0x00ed, B:99:0x00f9, B:101:0x0100, B:105:0x0108, B:107:0x010f, B:109:0x0114, B:111:0x011b, B:130:0x013b, B:131:0x0147, B:137:0x0151, B:140:0x0159, B:142:0x015f, B:144:0x0169, B:148:0x016f, B:152:0x0174, B:156:0x0177, B:158:0x0183, B:161:0x018b), top: B:2:0x0003 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void B() {
            /*
                Method dump skipped, instructions count: 431
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.o2.e.B():void");
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected void G(T r5, long r6) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                rx.l<? super T> r2 = r4.f53288a     // Catch: java.lang.Throwable -> L8
                r2.onNext(r5)     // Catch: java.lang.Throwable -> L8
                goto L23
            L8:
                r5 = move-exception
                boolean r2 = r4.f53289b     // Catch: java.lang.Throwable -> L19
                if (r2 != 0) goto L1c
                rx.exceptions.a.e(r5)     // Catch: java.lang.Throwable -> L19
                r4.unsubscribe()     // Catch: java.lang.Throwable -> L17
                r4.onError(r5)     // Catch: java.lang.Throwable -> L17
                goto L49
            L17:
                r5 = move-exception
                goto L55
            L19:
                r5 = move-exception
                r0 = 0
                goto L55
            L1c:
                java.util.Queue r2 = r4.P()     // Catch: java.lang.Throwable -> L19
                r2.offer(r5)     // Catch: java.lang.Throwable -> L19
            L23:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r5 == 0) goto L31
                rx.internal.operators.o2$d<T> r5 = r4.f53291d     // Catch: java.lang.Throwable -> L19
                r5.a(r0)     // Catch: java.lang.Throwable -> L19
            L31:
                int r5 = r4.f53304q     // Catch: java.lang.Throwable -> L19
                int r5 = r5 + r0
                int r6 = r4.f53303p     // Catch: java.lang.Throwable -> L19
                if (r5 != r6) goto L3f
                r4.f53304q = r1     // Catch: java.lang.Throwable -> L19
                long r5 = (long) r5     // Catch: java.lang.Throwable -> L19
                r4.V(r5)     // Catch: java.lang.Throwable -> L19
                goto L41
            L3f:
                r4.f53304q = r5     // Catch: java.lang.Throwable -> L19
            L41:
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L19
                boolean r5 = r4.f53297j     // Catch: java.lang.Throwable -> L4a
                if (r5 != 0) goto L4c
                r4.f53296i = r1     // Catch: java.lang.Throwable -> L4a
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L4a
            L49:
                return
            L4a:
                r5 = move-exception
                goto L53
            L4c:
                r4.f53297j = r1     // Catch: java.lang.Throwable -> L4a
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L4a
                r4.B()
                return
            L53:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L4a
                throw r5     // Catch: java.lang.Throwable -> L17
            L55:
                if (r0 != 0) goto L5f
                monitor-enter(r4)
                r4.f53296i = r1     // Catch: java.lang.Throwable -> L5c
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L5c
                goto L5f
            L5c:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L5c
                throw r5
            L5f:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.o2.e.G(java.lang.Object, long):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected void H(rx.internal.operators.o2.c<T> r5, T r6, long r7) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                rx.l<? super T> r2 = r4.f53288a     // Catch: java.lang.Throwable -> L8
                r2.onNext(r6)     // Catch: java.lang.Throwable -> L8
                goto L23
            L8:
                r6 = move-exception
                boolean r2 = r4.f53289b     // Catch: java.lang.Throwable -> L19
                if (r2 != 0) goto L1c
                rx.exceptions.a.e(r6)     // Catch: java.lang.Throwable -> L19
                r5.unsubscribe()     // Catch: java.lang.Throwable -> L17
                r5.onError(r6)     // Catch: java.lang.Throwable -> L17
                goto L3e
            L17:
                r5 = move-exception
                goto L4a
            L19:
                r5 = move-exception
                r0 = 0
                goto L4a
            L1c:
                java.util.Queue r2 = r4.P()     // Catch: java.lang.Throwable -> L19
                r2.offer(r6)     // Catch: java.lang.Throwable -> L19
            L23:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r6 == 0) goto L31
                rx.internal.operators.o2$d<T> r6 = r4.f53291d     // Catch: java.lang.Throwable -> L19
                r6.a(r0)     // Catch: java.lang.Throwable -> L19
            L31:
                r6 = 1
                r5.g(r6)     // Catch: java.lang.Throwable -> L19
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L19
                boolean r5 = r4.f53297j     // Catch: java.lang.Throwable -> L3f
                if (r5 != 0) goto L41
                r4.f53296i = r1     // Catch: java.lang.Throwable -> L3f
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
            L3e:
                return
            L3f:
                r5 = move-exception
                goto L48
            L41:
                r4.f53297j = r1     // Catch: java.lang.Throwable -> L3f
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
                r4.B()
                return
            L48:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
                throw r5     // Catch: java.lang.Throwable -> L17
            L4a:
                if (r0 != 0) goto L54
                monitor-enter(r4)
                r4.f53296i = r1     // Catch: java.lang.Throwable -> L51
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L51
                goto L54
            L51:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L51
                throw r5
            L54:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.o2.e.H(rx.internal.operators.o2$c, java.lang.Object, long):void");
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53295h = true;
            s();
        }

        void s() {
            synchronized (this) {
                try {
                    if (this.f53296i) {
                        this.f53297j = true;
                    } else {
                        this.f53296i = true;
                        B();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private void U() {
            ArrayList arrayList = new ArrayList(this.f53294g);
            if (arrayList.size() == 1) {
                this.f53288a.onError((Throwable) arrayList.get(0));
            } else {
                this.f53288a.onError(new CompositeException(arrayList));
            }
        }

        void A() {
            int i6 = this.f53304q + 1;
            if (i6 != this.f53303p) {
                this.f53304q = i6;
            } else {
                this.f53304q = 0;
                V(i6);
            }
        }

        rx.subscriptions.b N() {
            rx.subscriptions.b bVar;
            boolean z5;
            rx.subscriptions.b bVar2 = this.f53293f;
            if (bVar2 != null) {
                return bVar2;
            }
            synchronized (this) {
                try {
                    bVar = this.f53293f;
                    if (bVar == null) {
                        bVar = new rx.subscriptions.b();
                        this.f53293f = bVar;
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z5) {
                add(bVar);
            }
            return bVar;
        }

        Queue<Throwable> P() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue;
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue2 = this.f53294g;
            if (concurrentLinkedQueue2 != null) {
                return concurrentLinkedQueue2;
            }
            synchronized (this) {
                try {
                    concurrentLinkedQueue = this.f53294g;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.f53294g = concurrentLinkedQueue;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return concurrentLinkedQueue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.f
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public void onNext(rx.e<? extends T> eVar) {
            if (eVar == null) {
                return;
            }
            if (eVar == rx.e.S1()) {
                A();
                return;
            }
            if (eVar instanceof rx.internal.util.k) {
                W(((rx.internal.util.k) eVar).y7());
                return;
            }
            long j6 = this.f53300m;
            this.f53300m = 1 + j6;
            c cVar = new c(this, j6);
            g(cVar);
            eVar.J6(cVar);
            s();
        }

        protected void R(T t5) {
            Queue<Object> queue = this.f53292e;
            if (queue == null) {
                int i6 = this.f53290c;
                if (i6 == Integer.MAX_VALUE) {
                    queue = new rx.internal.util.atomic.g<>(rx.internal.util.j.f54163d);
                } else {
                    queue = rx.internal.util.unsafe.p.a(i6) ? rx.internal.util.unsafe.n0.f() ? new rx.internal.util.unsafe.z<>(i6) : new rx.internal.util.atomic.d<>(i6) : new SpscExactAtomicArrayQueue<>(i6);
                }
                this.f53292e = queue;
            }
            if (queue.offer(v.j(t5))) {
                return;
            }
            unsubscribe();
            onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t5));
        }

        protected void S(c<T> cVar, T t5) {
            rx.internal.util.j jVar = cVar.f53284d;
            if (jVar == null) {
                jVar = rx.internal.util.j.j();
                cVar.add(jVar);
                cVar.f53284d = jVar;
            }
            try {
                jVar.P(v.j(t5));
            } catch (IllegalStateException e6) {
                if (cVar.isUnsubscribed()) {
                    return;
                }
                cVar.unsubscribe();
                cVar.onError(e6);
            } catch (MissingBackpressureException e7) {
                cVar.unsubscribe();
                cVar.onError(e7);
            }
        }

        void T(c<T> cVar) {
            rx.internal.util.j jVar = cVar.f53284d;
            if (jVar != null) {
                jVar.S();
            }
            this.f53293f.f(cVar);
            synchronized (this.f53298k) {
                try {
                    c<?>[] cVarArr = this.f53299l;
                    int length = cVarArr.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            i6 = -1;
                            break;
                        } else if (!cVar.equals(cVarArr[i6])) {
                            i6++;
                        }
                    }
                    if (i6 < 0) {
                        return;
                    }
                    if (length == 1) {
                        this.f53299l = f53287r;
                        return;
                    }
                    c<?>[] cVarArr2 = new c[length - 1];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, i6);
                    System.arraycopy(cVarArr, i6 + 1, cVarArr2, i6, (length - i6) - 1);
                    this.f53299l = cVarArr2;
                } finally {
                }
            }
        }

        void W(T t5) {
            long j6 = this.f53291d.get();
            boolean z5 = false;
            if (j6 != 0) {
                synchronized (this) {
                    try {
                        j6 = this.f53291d.get();
                        if (!this.f53296i && j6 != 0) {
                            z5 = true;
                            this.f53296i = true;
                        }
                    } finally {
                    }
                }
            }
            if (!z5) {
                R(t5);
                s();
                return;
            }
            Queue<Object> queue = this.f53292e;
            if (queue == null || queue.isEmpty()) {
                G(t5, j6);
            } else {
                R(t5);
                B();
            }
        }

        void X(c<T> cVar, T t5) {
            long j6 = this.f53291d.get();
            boolean z5 = false;
            if (j6 != 0) {
                synchronized (this) {
                    try {
                        j6 = this.f53291d.get();
                        if (!this.f53296i && j6 != 0) {
                            z5 = true;
                            this.f53296i = true;
                        }
                    } finally {
                    }
                }
            }
            if (!z5) {
                S(cVar, t5);
                s();
                return;
            }
            rx.internal.util.j jVar = cVar.f53284d;
            if (jVar == null || jVar.B()) {
                H(cVar, t5, j6);
            } else {
                S(cVar, t5);
                B();
            }
        }

        boolean j() {
            if (this.f53288a.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f53294g;
            if (this.f53289b || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                U();
                return true;
            } finally {
                unsubscribe();
            }
        }

        public e(rx.l<? super T> lVar, boolean z5, int i6) {
            this.f53288a = lVar;
            this.f53289b = z5;
            this.f53290c = i6;
            if (i6 == Integer.MAX_VALUE) {
                this.f53303p = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
            } else {
                this.f53303p = Math.max(1, i6 >> 1);
                request(i6);
            }
        }

        public void V(long j6) {
            request(j6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g(c<T> cVar) {
            N().a(cVar);
            synchronized (this.f53298k) {
                c<?>[] cVarArr = this.f53299l;
                int length = cVarArr.length;
                c<?>[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                this.f53299l = cVarArr2;
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            P().offer(th);
            this.f53295h = true;
            s();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final o2<Object> f53278a = new o2<>(true, Integer.MAX_VALUE);

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final o2<Object> f53279a = new o2<>(false, Integer.MAX_VALUE);

        b() {
        }
    }

    public static <T> o2<T> a(boolean z5) {
        return z5 ? (o2<T>) a.f53278a : (o2<T>) b.f53279a;
    }

    public static <T> o2<T> b(boolean z5, int i6) {
        if (i6 > 0) {
            return i6 == Integer.MAX_VALUE ? a(z5) : new o2<>(z5, i6);
        }
        throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i6);
    }

    @Override // rx.functions.p
    public rx.l<rx.e<? extends T>> call(rx.l<? super T> lVar) {
        e eVar = new e(lVar, this.f53276a, this.f53277b);
        d<T> dVar = new d<>(eVar);
        eVar.f53291d = dVar;
        lVar.add(eVar);
        lVar.setProducer(dVar);
        return eVar;
    }

    o2(boolean z5, int i6) {
        this.f53276a = z5;
        this.f53277b = i6;
    }
}
