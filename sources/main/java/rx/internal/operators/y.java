package rx.internal.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.CompositeException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y<T, R> implements e.a<R> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<? extends T>[] f53821a;

    /* renamed from: b, reason: collision with root package name */
    final Iterable<? extends rx.e<? extends T>> f53822b;

    /* renamed from: c, reason: collision with root package name */
    final rx.functions.y<? extends R> f53823c;

    /* renamed from: d, reason: collision with root package name */
    final int f53824d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f53825e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, R> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final b<T, R> f53826a;

        /* renamed from: b, reason: collision with root package name */
        final int f53827b;

        /* renamed from: c, reason: collision with root package name */
        boolean f53828c;

        @Override // rx.f
        public void onCompleted() {
            if (this.f53828c) {
                return;
            }
            this.f53828c = true;
            this.f53826a.d(null, this.f53827b);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53828c) {
                rx.plugins.c.I(th);
                return;
            }
            this.f53826a.f(th);
            this.f53828c = true;
            this.f53826a.d(null, this.f53827b);
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53828c) {
                return;
            }
            this.f53826a.d(v.j(t5), this.f53827b);
        }

        public a(b<T, R> bVar, int i6) {
            this.f53826a = bVar;
            this.f53827b = i6;
            request(bVar.f53833d);
        }

        public void g(long j6) {
            request(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T, R> extends AtomicInteger implements rx.g, rx.m {

        /* renamed from: n, reason: collision with root package name */
        static final Object f53829n = new Object();
        private static final long serialVersionUID = 8567835998786448817L;

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super R> f53830a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.y<? extends R> f53831b;

        /* renamed from: c, reason: collision with root package name */
        final a<T, R>[] f53832c;

        /* renamed from: d, reason: collision with root package name */
        final int f53833d;

        /* renamed from: e, reason: collision with root package name */
        final Object[] f53834e;

        /* renamed from: f, reason: collision with root package name */
        final rx.internal.util.atomic.e<Object> f53835f;

        /* renamed from: g, reason: collision with root package name */
        final boolean f53836g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f53837h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f53838i;

        /* renamed from: j, reason: collision with root package name */
        final AtomicLong f53839j;

        /* renamed from: k, reason: collision with root package name */
        final AtomicReference<Throwable> f53840k;

        /* renamed from: l, reason: collision with root package name */
        int f53841l;

        /* renamed from: m, reason: collision with root package name */
        int f53842m;

        boolean b(boolean z5, boolean z6, rx.l<?> lVar, Queue<?> queue, boolean z7) {
            if (this.f53837h) {
                a(queue);
                return true;
            }
            if (!z5) {
                return false;
            }
            if (z7) {
                if (!z6) {
                    return false;
                }
                Throwable th = this.f53840k.get();
                if (th != null) {
                    lVar.onError(th);
                } else {
                    lVar.onCompleted();
                }
                return true;
            }
            Throwable th2 = this.f53840k.get();
            if (th2 != null) {
                a(queue);
                lVar.onError(th2);
                return true;
            }
            if (!z6) {
                return false;
            }
            lVar.onCompleted();
            return true;
        }

        void d(Object obj, int i6) {
            boolean z5;
            a<T, R> aVar = this.f53832c[i6];
            synchronized (this) {
                try {
                    Object[] objArr = this.f53834e;
                    int length = objArr.length;
                    Object obj2 = objArr[i6];
                    int i7 = this.f53841l;
                    Object obj3 = f53829n;
                    if (obj2 == obj3) {
                        i7++;
                        this.f53841l = i7;
                    }
                    int i8 = this.f53842m;
                    if (obj == null) {
                        i8++;
                        this.f53842m = i8;
                    } else {
                        objArr[i6] = v.e(obj);
                    }
                    z5 = i7 == length;
                    if (i8 != length && (obj != null || obj2 != obj3)) {
                        if (obj != null && z5) {
                            this.f53835f.r(aVar, this.f53834e.clone());
                        } else if (obj == null && this.f53840k.get() != null && (obj2 == obj3 || !this.f53836g)) {
                            this.f53838i = true;
                        }
                    }
                    this.f53838i = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z5 || obj == null) {
                e();
            } else {
                aVar.g(1L);
            }
        }

        void e() {
            if (getAndIncrement() != 0) {
                return;
            }
            rx.internal.util.atomic.e<Object> eVar = this.f53835f;
            rx.l<? super R> lVar = this.f53830a;
            boolean z5 = this.f53836g;
            AtomicLong atomicLong = this.f53839j;
            int i6 = 1;
            while (!b(this.f53838i, eVar.isEmpty(), lVar, eVar, z5)) {
                long j6 = atomicLong.get();
                long j7 = 0;
                while (j7 != j6) {
                    boolean z6 = this.f53838i;
                    a aVar = (a) eVar.peek();
                    boolean z7 = aVar == null;
                    if (b(z6, z7, lVar, eVar, z5)) {
                        return;
                    }
                    if (z7) {
                        break;
                    }
                    eVar.poll();
                    Object[] objArr = (Object[]) eVar.poll();
                    if (objArr == null) {
                        this.f53837h = true;
                        a(eVar);
                        lVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                        return;
                    }
                    try {
                        lVar.onNext(this.f53831b.call(objArr));
                        aVar.g(1L);
                        j7++;
                    } catch (Throwable th) {
                        this.f53837h = true;
                        a(eVar);
                        lVar.onError(th);
                        return;
                    }
                }
                if (j7 != 0 && j6 != Long.MAX_VALUE) {
                    rx.internal.operators.a.i(atomicLong, j7);
                }
                i6 = addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
            }
        }

        void f(Throwable th) {
            Throwable th2;
            Throwable th3;
            AtomicReference<Throwable> atomicReference = this.f53840k;
            do {
                th2 = atomicReference.get();
                if (th2 == null) {
                    th3 = th;
                } else if (th2 instanceof CompositeException) {
                    ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                    arrayList.add(th);
                    th3 = new CompositeException(arrayList);
                } else {
                    th3 = new CompositeException(Arrays.asList(th2, th));
                }
            } while (!androidx.camera.view.p.a(atomicReference, th2, th3));
        }

        public void g(rx.e<? extends T>[] eVarArr) {
            a<T, R>[] aVarArr = this.f53832c;
            int length = aVarArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                aVarArr[i6] = new a<>(this, i6);
            }
            lazySet(0);
            this.f53830a.add(this);
            this.f53830a.setProducer(this);
            for (int i7 = 0; i7 < length && !this.f53837h; i7++) {
                eVarArr[i7].r5(aVarArr[i7]);
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f53837h;
        }

        @Override // rx.g
        public void request(long j6) {
            if (j6 < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j6);
            }
            if (j6 != 0) {
                rx.internal.operators.a.b(this.f53839j, j6);
                e();
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f53837h) {
                return;
            }
            this.f53837h = true;
            if (getAndIncrement() == 0) {
                a(this.f53835f);
            }
        }

        public b(rx.l<? super R> lVar, rx.functions.y<? extends R> yVar, int i6, int i7, boolean z5) {
            this.f53830a = lVar;
            this.f53831b = yVar;
            this.f53833d = i7;
            this.f53836g = z5;
            Object[] objArr = new Object[i6];
            this.f53834e = objArr;
            Arrays.fill(objArr, f53829n);
            this.f53832c = new a[i6];
            this.f53835f = new rx.internal.util.atomic.e<>(i7);
            this.f53839j = new AtomicLong();
            this.f53840k = new AtomicReference<>();
        }

        void a(Queue<?> queue) {
            queue.clear();
            for (a<T, R> aVar : this.f53832c) {
                aVar.unsubscribe();
            }
        }
    }

    public y(Iterable<? extends rx.e<? extends T>> iterable, rx.functions.y<? extends R> yVar) {
        this(null, iterable, yVar, rx.internal.util.j.f54163d, false);
    }

    public y(rx.e<? extends T>[] eVarArr, Iterable<? extends rx.e<? extends T>> iterable, rx.functions.y<? extends R> yVar, int i6, boolean z5) {
        this.f53821a = eVarArr;
        this.f53822b = iterable;
        this.f53823c = yVar;
        this.f53824d = i6;
        this.f53825e = z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004a  */
    @Override // rx.functions.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void call(rx.l<? super R> r8) {
        /*
            r7 = this;
            rx.e<? extends T>[] r0 = r7.f53821a
            if (r0 != 0) goto L46
            java.lang.Iterable<? extends rx.e<? extends T>> r0 = r7.f53822b
            boolean r1 = r0 instanceof java.util.List
            if (r1 == 0) goto L1b
            java.util.List r0 = (java.util.List) r0
            int r1 = r0.size()
            rx.e[] r1 = new rx.e[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            rx.e[] r0 = (rx.e[]) r0
            int r1 = r0.length
        L19:
            r4 = r1
            goto L48
        L1b:
            r1 = 8
            rx.e[] r1 = new rx.e[r1]
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
            r3 = 0
        L25:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L43
            java.lang.Object r4 = r0.next()
            rx.e r4 = (rx.e) r4
            int r5 = r1.length
            if (r3 != r5) goto L3d
            int r5 = r3 >> 2
            int r5 = r5 + r3
            rx.e[] r5 = new rx.e[r5]
            java.lang.System.arraycopy(r1, r2, r5, r2, r3)
            r1 = r5
        L3d:
            int r5 = r3 + 1
            r1[r3] = r4
            r3 = r5
            goto L25
        L43:
            r0 = r1
            r4 = r3
            goto L48
        L46:
            int r1 = r0.length
            goto L19
        L48:
            if (r4 != 0) goto L4e
            r8.onCompleted()
            return
        L4e:
            rx.internal.operators.y$b r1 = new rx.internal.operators.y$b
            rx.functions.y<? extends R> r3 = r7.f53823c
            int r5 = r7.f53824d
            boolean r6 = r7.f53825e
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            r1.g(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.y.call(rx.l):void");
    }
}
