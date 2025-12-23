package rx.subjects;

import androidx.camera.view.p;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.internal.operators.v;
import rx.internal.util.unsafe.g0;
import rx.internal.util.unsafe.h0;
import rx.internal.util.unsafe.n0;
import rx.l;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class i<T> extends f<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final a<T> f54573b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends AtomicLong implements rx.g, rx.f<T>, e.a<T>, m {
        private static final long serialVersionUID = -9044104859202255786L;

        /* renamed from: a, reason: collision with root package name */
        final AtomicReference<l<? super T>> f54574a = new AtomicReference<>();

        /* renamed from: b, reason: collision with root package name */
        final Queue<Object> f54575b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f54576c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference<rx.functions.a> f54577d;

        /* renamed from: e, reason: collision with root package name */
        Throwable f54578e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f54579f;

        /* renamed from: g, reason: collision with root package name */
        boolean f54580g;

        /* renamed from: h, reason: collision with root package name */
        boolean f54581h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f54582i;

        /* JADX WARN: Code restructure failed: missing block: B:49:0x0084, code lost:
        
            if (r7 == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x008a, code lost:
        
            if (r0.isEmpty() == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008c, code lost:
        
            r15.f54582i = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0091, code lost:
        
            r15.f54580g = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0094, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void f() {
            /*
                r15 = this;
                monitor-enter(r15)
                boolean r0 = r15.f54580g     // Catch: java.lang.Throwable -> La
                r1 = 1
                if (r0 == 0) goto Ld
                r15.f54581h = r1     // Catch: java.lang.Throwable -> La
                monitor-exit(r15)     // Catch: java.lang.Throwable -> La
                return
            La:
                r0 = move-exception
                goto L9c
            Ld:
                r15.f54580g = r1     // Catch: java.lang.Throwable -> La
                monitor-exit(r15)     // Catch: java.lang.Throwable -> La
                java.util.Queue<java.lang.Object> r0 = r15.f54575b
                boolean r2 = r15.f54576c
            L14:
                java.util.concurrent.atomic.AtomicReference<rx.l<? super T>> r3 = r15.f54574a
                java.lang.Object r3 = r3.get()
                rx.l r3 = (rx.l) r3
                r4 = 0
                if (r3 == 0) goto L7e
                boolean r5 = r15.f54579f
                boolean r6 = r0.isEmpty()
                boolean r5 = r15.d(r5, r6, r2, r3)
                if (r5 == 0) goto L2c
                goto L54
            L2c:
                long r5 = r15.get()
                r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 != 0) goto L3b
                r7 = 1
                goto L3c
            L3b:
                r7 = 0
            L3c:
                r8 = 0
                r10 = r8
            L3f:
                int r12 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r12 == 0) goto L73
                boolean r12 = r15.f54579f
                java.lang.Object r13 = r0.poll()
                if (r13 != 0) goto L4d
                r14 = 1
                goto L4e
            L4d:
                r14 = 0
            L4e:
                boolean r12 = r15.d(r12, r14, r2, r3)
                if (r12 == 0) goto L55
            L54:
                return
            L55:
                if (r14 == 0) goto L58
                goto L73
            L58:
                java.lang.Object r12 = rx.internal.operators.v.e(r13)
                r3.onNext(r12)     // Catch: java.lang.Throwable -> L64
                r12 = 1
                long r5 = r5 - r12
                long r10 = r10 + r12
                goto L3f
            L64:
                r1 = move-exception
                r0.clear()
                rx.exceptions.a.e(r1)
                java.lang.Throwable r0 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r12)
                r3.onError(r0)
                return
            L73:
                if (r7 != 0) goto L7f
                int r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r3 == 0) goto L7f
                long r5 = -r10
                r15.addAndGet(r5)
                goto L7f
            L7e:
                r7 = 0
            L7f:
                monitor-enter(r15)
                boolean r3 = r15.f54581h     // Catch: java.lang.Throwable -> L8f
                if (r3 != 0) goto L95
                if (r7 == 0) goto L91
                boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L8f
                if (r0 == 0) goto L91
                r15.f54582i = r1     // Catch: java.lang.Throwable -> L8f
                goto L91
            L8f:
                r0 = move-exception
                goto L9a
            L91:
                r15.f54580g = r4     // Catch: java.lang.Throwable -> L8f
                monitor-exit(r15)     // Catch: java.lang.Throwable -> L8f
                return
            L95:
                r15.f54581h = r4     // Catch: java.lang.Throwable -> L8f
                monitor-exit(r15)     // Catch: java.lang.Throwable -> L8f
                goto L14
            L9a:
                monitor-exit(r15)     // Catch: java.lang.Throwable -> L8f
                throw r0
            L9c:
                monitor-exit(r15)     // Catch: java.lang.Throwable -> La
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.i.a.f():void");
        }

        @Override // rx.functions.b
        public void call(l<? super T> lVar) {
            if (!p.a(this.f54574a, null, lVar)) {
                lVar.onError(new IllegalStateException("Only a single subscriber is allowed"));
            } else {
                lVar.add(this);
                lVar.setProducer(this);
            }
        }

        void e() {
            rx.functions.a aVar;
            AtomicReference<rx.functions.a> atomicReference = this.f54577d;
            if (atomicReference == null || (aVar = atomicReference.get()) == null || !p.a(atomicReference, aVar, null)) {
                return;
            }
            aVar.call();
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f54579f;
        }

        @Override // rx.f
        public void onCompleted() {
            boolean z5;
            if (this.f54579f) {
                return;
            }
            e();
            this.f54579f = true;
            if (!this.f54582i) {
                synchronized (this) {
                    z5 = this.f54582i;
                }
                if (!z5) {
                    f();
                    return;
                }
            }
            this.f54574a.get().onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            boolean z5;
            if (this.f54579f) {
                return;
            }
            e();
            this.f54578e = th;
            this.f54579f = true;
            if (!this.f54582i) {
                synchronized (this) {
                    z5 = this.f54582i;
                }
                if (!z5) {
                    f();
                    return;
                }
            }
            this.f54574a.get().onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            boolean z5;
            if (this.f54579f) {
                return;
            }
            if (!this.f54582i) {
                synchronized (this) {
                    try {
                        if (this.f54582i) {
                            z5 = false;
                        } else {
                            this.f54575b.offer(v.j(t5));
                            z5 = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z5) {
                    f();
                    return;
                }
            }
            l<? super T> lVar = this.f54574a.get();
            try {
                lVar.onNext(t5);
            } catch (Throwable th2) {
                rx.exceptions.a.g(th2, lVar, t5);
            }
        }

        @Override // rx.g
        public void request(long j6) {
            if (j6 < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (j6 > 0) {
                rx.internal.operators.a.b(this, j6);
                f();
            } else if (this.f54579f) {
                f();
            }
        }

        public a(int i6, boolean z5, rx.functions.a aVar) {
            AtomicReference<rx.functions.a> atomicReference;
            Queue<Object> fVar;
            Queue<Object> queue;
            if (aVar != null) {
                atomicReference = new AtomicReference<>(aVar);
            } else {
                atomicReference = null;
            }
            this.f54577d = atomicReference;
            this.f54576c = z5;
            if (i6 > 1) {
                if (n0.f()) {
                    queue = new h0<>(i6);
                } else {
                    queue = new rx.internal.util.atomic.g<>(i6);
                }
            } else {
                if (n0.f()) {
                    fVar = new g0<>();
                } else {
                    fVar = new rx.internal.util.atomic.f<>();
                }
                queue = fVar;
            }
            this.f54575b = queue;
        }

        boolean d(boolean z5, boolean z6, boolean z7, l<? super T> lVar) {
            if (lVar.isUnsubscribed()) {
                this.f54575b.clear();
                return true;
            }
            if (z5) {
                Throwable th = this.f54578e;
                if (th != null && !z7) {
                    this.f54575b.clear();
                    lVar.onError(th);
                    return true;
                }
                if (z6) {
                    if (th != null) {
                        lVar.onError(th);
                    } else {
                        lVar.onCompleted();
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // rx.m
        public void unsubscribe() {
            e();
            this.f54579f = true;
            synchronized (this) {
                try {
                    if (this.f54580g) {
                        return;
                    }
                    this.f54580g = true;
                    this.f54575b.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static <T> i<T> A7(int i6, rx.functions.a aVar) {
        return new i<>(new a(i6, false, aVar));
    }

    public static <T> i<T> B7(int i6, rx.functions.a aVar, boolean z5) {
        return new i<>(new a(i6, z5, aVar));
    }

    public static <T> i<T> C7(boolean z5) {
        return new i<>(new a(16, z5, null));
    }

    public static <T> i<T> y7() {
        return z7(16);
    }

    public static <T> i<T> z7(int i6) {
        return new i<>(new a(i6, false, null));
    }

    @Override // rx.f
    public void onCompleted() {
        this.f54573b.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f54573b.onError(th);
    }

    @Override // rx.f
    public void onNext(T t5) {
        this.f54573b.onNext(t5);
    }

    @Override // rx.subjects.f
    public boolean w7() {
        return this.f54573b.f54574a.get() != null;
    }

    private i(a<T> aVar) {
        super(aVar);
        this.f54573b = aVar;
    }
}
