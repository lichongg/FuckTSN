package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q2<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    private final rx.h f53384a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f53385b;

    /* renamed from: c, reason: collision with root package name */
    private final int f53386c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements e.b<T, T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f53387a;

        a(int i6) {
            this.f53387a = i6;
        }

        @Override // rx.functions.p
        public rx.l<? super T> call(rx.l<? super T> lVar) {
            b bVar = new b(rx.schedulers.c.d(), lVar, false, this.f53387a);
            bVar.j();
            return bVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f53388a;

        /* renamed from: b, reason: collision with root package name */
        final h.a f53389b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f53390c;

        /* renamed from: d, reason: collision with root package name */
        final Queue<Object> f53391d;

        /* renamed from: e, reason: collision with root package name */
        final int f53392e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f53393f;

        /* renamed from: g, reason: collision with root package name */
        final AtomicLong f53394g = new AtomicLong();

        /* renamed from: h, reason: collision with root package name */
        final AtomicLong f53395h = new AtomicLong();

        /* renamed from: i, reason: collision with root package name */
        Throwable f53396i;

        /* renamed from: j, reason: collision with root package name */
        long f53397j;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.g {
            a() {
            }

            @Override // rx.g
            public void request(long j6) {
                if (j6 > 0) {
                    rx.internal.operators.a.b(b.this.f53394g, j6);
                    b.this.s();
                }
            }
        }

        @Override // rx.functions.a
        public void call() {
            long j6 = this.f53397j;
            Queue<Object> queue = this.f53391d;
            rx.l<? super T> lVar = this.f53388a;
            long j7 = 1;
            do {
                long j8 = this.f53394g.get();
                while (j8 != j6) {
                    boolean z5 = this.f53393f;
                    Object poll = queue.poll();
                    boolean z6 = poll == null;
                    if (g(z5, z6, lVar, queue)) {
                        return;
                    }
                    if (z6) {
                        break;
                    }
                    lVar.onNext((Object) v.e(poll));
                    j6++;
                    if (j6 == this.f53392e) {
                        long i6 = rx.internal.operators.a.i(this.f53394g, j6);
                        request(j6);
                        j8 = i6;
                        j6 = 0;
                    }
                }
                if (j8 == j6 && g(this.f53393f, queue.isEmpty(), lVar, queue)) {
                    return;
                }
                this.f53397j = j6;
                j7 = this.f53395h.addAndGet(-j7);
            } while (j7 != 0);
        }

        void j() {
            rx.l<? super T> lVar = this.f53388a;
            lVar.setProducer(new a());
            lVar.add(this.f53389b);
            lVar.add(this);
        }

        protected void s() {
            if (this.f53395h.getAndIncrement() == 0) {
                this.f53389b.d(this);
            }
        }

        public b(rx.h hVar, rx.l<? super T> lVar, boolean z5, int i6) {
            this.f53388a = lVar;
            this.f53389b = hVar.a();
            this.f53390c = z5;
            i6 = i6 <= 0 ? rx.internal.util.j.f54163d : i6;
            this.f53392e = i6 - (i6 >> 2);
            if (rx.internal.util.unsafe.n0.f()) {
                this.f53391d = new rx.internal.util.unsafe.z(i6);
            } else {
                this.f53391d = new rx.internal.util.atomic.d(i6);
            }
            request(i6);
        }

        boolean g(boolean z5, boolean z6, rx.l<? super T> lVar, Queue<Object> queue) {
            if (lVar.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (z5) {
                if (this.f53390c) {
                    if (z6) {
                        Throwable th = this.f53396i;
                        try {
                            if (th != null) {
                                lVar.onError(th);
                            } else {
                                lVar.onCompleted();
                            }
                            return false;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return false;
                }
                Throwable th3 = this.f53396i;
                if (th3 != null) {
                    queue.clear();
                    try {
                        lVar.onError(th3);
                        return true;
                    } finally {
                    }
                }
                if (z6) {
                    try {
                        lVar.onCompleted();
                        return true;
                    } finally {
                    }
                }
                return false;
            }
            return false;
        }

        @Override // rx.f
        public void onCompleted() {
            if (!isUnsubscribed() && !this.f53393f) {
                this.f53393f = true;
                s();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!isUnsubscribed() && !this.f53393f) {
                this.f53396i = th;
                this.f53393f = true;
                s();
                return;
            }
            rx.plugins.c.I(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (!isUnsubscribed() && !this.f53393f) {
                if (!this.f53391d.offer(v.j(t5))) {
                    onError(new MissingBackpressureException());
                } else {
                    s();
                }
            }
        }
    }

    public q2(rx.h hVar, boolean z5) {
        this(hVar, z5, rx.internal.util.j.f54163d);
    }

    public q2(rx.h hVar, boolean z5, int i6) {
        this.f53384a = hVar;
        this.f53385b = z5;
        this.f53386c = i6 <= 0 ? rx.internal.util.j.f54163d : i6;
    }

    public static <T> e.b<T, T> a(int i6) {
        return new a(i6);
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.h hVar = this.f53384a;
        if ((hVar instanceof rx.internal.schedulers.f) || (hVar instanceof rx.internal.schedulers.m)) {
            return lVar;
        }
        b bVar = new b(hVar, lVar, this.f53385b, this.f53386c);
        bVar.j();
        return bVar;
    }
}
