package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g2<T, R> implements e.b<R, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.e<? extends R>> f52831a;

    /* renamed from: b, reason: collision with root package name */
    final int f52832b;

    /* renamed from: c, reason: collision with root package name */
    private final int f52833c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final c<?, T> f52834a;

        /* renamed from: b, reason: collision with root package name */
        final Queue<Object> f52835b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f52836c;

        /* renamed from: d, reason: collision with root package name */
        Throwable f52837d;

        @Override // rx.f
        public void onCompleted() {
            this.f52836c = true;
            this.f52834a.j();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52837d = th;
            this.f52836c = true;
            this.f52834a.j();
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f52835b.offer(v.j(t5));
            this.f52834a.j();
        }

        public a(c<?, T> cVar, int i6) {
            Queue<Object> dVar;
            this.f52834a = cVar;
            if (rx.internal.util.unsafe.n0.f()) {
                dVar = new rx.internal.util.unsafe.z<>(i6);
            } else {
                dVar = new rx.internal.util.atomic.d<>(i6);
            }
            this.f52835b = dVar;
            request(i6);
        }

        void g(long j6) {
            request(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends AtomicLong implements rx.g {
        private static final long serialVersionUID = -657299606803478389L;

        /* renamed from: a, reason: collision with root package name */
        final c<?, ?> f52838a;

        @Override // rx.g
        public void request(long j6) {
            if (j6 < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j6);
            }
            if (j6 > 0) {
                rx.internal.operators.a.b(this, j6);
                this.f52838a.j();
            }
        }

        public b(c<?, ?> cVar) {
            this.f52838a = cVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T, R> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends rx.e<? extends R>> f52839a;

        /* renamed from: b, reason: collision with root package name */
        final int f52840b;

        /* renamed from: c, reason: collision with root package name */
        final rx.l<? super R> f52841c;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f52843e;

        /* renamed from: f, reason: collision with root package name */
        Throwable f52844f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f52845g;

        /* renamed from: i, reason: collision with root package name */
        private b f52847i;

        /* renamed from: d, reason: collision with root package name */
        final Queue<a<R>> f52842d = new LinkedList();

        /* renamed from: h, reason: collision with root package name */
        final AtomicInteger f52846h = new AtomicInteger();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                c.this.f52845g = true;
                if (c.this.f52846h.getAndIncrement() == 0) {
                    c.this.g();
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52843e = true;
            j();
        }

        void g() {
            ArrayList arrayList;
            synchronized (this.f52842d) {
                arrayList = new ArrayList(this.f52842d);
                this.f52842d.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((rx.m) it.next()).unsubscribe();
            }
        }

        void j() {
            a<R> peek;
            if (this.f52846h.getAndIncrement() != 0) {
                return;
            }
            b bVar = this.f52847i;
            rx.l<? super R> lVar = this.f52841c;
            int i6 = 1;
            while (!this.f52845g) {
                boolean z5 = this.f52843e;
                synchronized (this.f52842d) {
                    peek = this.f52842d.peek();
                }
                boolean z6 = false;
                boolean z7 = peek == null;
                if (z5) {
                    Throwable th = this.f52844f;
                    if (th != null) {
                        g();
                        lVar.onError(th);
                        return;
                    } else if (z7) {
                        lVar.onCompleted();
                        return;
                    }
                }
                if (!z7) {
                    long j6 = bVar.get();
                    Queue<Object> queue = peek.f52835b;
                    long j7 = 0;
                    while (true) {
                        boolean z8 = peek.f52836c;
                        Object peek2 = queue.peek();
                        boolean z9 = peek2 == null;
                        if (z8) {
                            Throwable th2 = peek.f52837d;
                            if (th2 == null) {
                                if (z9) {
                                    synchronized (this.f52842d) {
                                        this.f52842d.poll();
                                    }
                                    peek.unsubscribe();
                                    request(1L);
                                    z6 = true;
                                    break;
                                }
                            } else {
                                g();
                                lVar.onError(th2);
                                return;
                            }
                        }
                        if (z9 || j6 == j7) {
                            break;
                        }
                        queue.poll();
                        try {
                            lVar.onNext((Object) v.e(peek2));
                            j7++;
                        } catch (Throwable th3) {
                            rx.exceptions.a.g(th3, lVar, peek2);
                            return;
                        }
                    }
                    if (j7 != 0) {
                        if (j6 != Long.MAX_VALUE) {
                            rx.internal.operators.a.i(bVar, j7);
                        }
                        if (!z6) {
                            peek.g(j7);
                        }
                    }
                    if (z6) {
                        continue;
                    }
                }
                i6 = this.f52846h.addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
            }
            g();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52844f = th;
            this.f52843e = true;
            j();
        }

        @Override // rx.f
        public void onNext(T t5) {
            try {
                rx.e<? extends R> call = this.f52839a.call(t5);
                if (this.f52845g) {
                    return;
                }
                a<R> aVar = new a<>(this, this.f52840b);
                synchronized (this.f52842d) {
                    try {
                        if (this.f52845g) {
                            return;
                        }
                        this.f52842d.add(aVar);
                        if (this.f52845g) {
                            return;
                        }
                        call.J6(aVar);
                        j();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                rx.exceptions.a.g(th2, this.f52841c, t5);
            }
        }

        void s() {
            this.f52847i = new b(this);
            add(rx.subscriptions.f.a(new a()));
            this.f52841c.add(this);
            this.f52841c.setProducer(this.f52847i);
        }

        public c(rx.functions.p<? super T, ? extends rx.e<? extends R>> pVar, int i6, int i7, rx.l<? super R> lVar) {
            long j6;
            this.f52839a = pVar;
            this.f52840b = i6;
            this.f52841c = lVar;
            if (i7 == Integer.MAX_VALUE) {
                j6 = Long.MAX_VALUE;
            } else {
                j6 = i7;
            }
            request(j6);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super R> lVar) {
        c cVar = new c(this.f52831a, this.f52832b, this.f52833c, lVar);
        cVar.s();
        return cVar;
    }

    public g2(rx.functions.p<? super T, ? extends rx.e<? extends R>> pVar, int i6, int i7) {
        this.f52831a = pVar;
        this.f52832b = i6;
        this.f52833c = i7;
    }
}
