package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.internal.util.ExceptionsUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j0<T, R> implements e.a<R> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f52985a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.i<? extends R>> f52986b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f52987c;

    /* renamed from: d, reason: collision with root package name */
    final int f52988d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, R> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super R> f52989a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends rx.i<? extends R>> f52990b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f52991c;

        /* renamed from: d, reason: collision with root package name */
        final int f52992d;

        /* renamed from: i, reason: collision with root package name */
        final Queue<Object> f52997i;

        /* renamed from: k, reason: collision with root package name */
        volatile boolean f52999k;

        /* renamed from: l, reason: collision with root package name */
        volatile boolean f53000l;

        /* renamed from: e, reason: collision with root package name */
        final AtomicInteger f52993e = new AtomicInteger();

        /* renamed from: h, reason: collision with root package name */
        final AtomicReference<Throwable> f52996h = new AtomicReference<>();

        /* renamed from: j, reason: collision with root package name */
        final a<T, R>.b f52998j = new b();

        /* renamed from: g, reason: collision with root package name */
        final rx.subscriptions.b f52995g = new rx.subscriptions.b();

        /* renamed from: f, reason: collision with root package name */
        final AtomicInteger f52994f = new AtomicInteger();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.j0$a$a, reason: collision with other inner class name */
        final class C1036a extends rx.k<R> {
            C1036a() {
            }

            @Override // rx.k
            public void d(R r5) {
                a.this.s(this, r5);
            }

            @Override // rx.k
            public void onError(Throwable th) {
                a.this.j(this, th);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class b extends AtomicLong implements rx.g, rx.m {
            private static final long serialVersionUID = -887187595446742742L;

            b() {
            }

            @Override // rx.m
            public boolean isUnsubscribed() {
                return a.this.f53000l;
            }

            @Override // rx.g
            public void request(long j6) {
                if (j6 > 0) {
                    rx.internal.operators.a.b(this, j6);
                    a.this.g();
                }
            }

            @Override // rx.m
            public void unsubscribe() {
                a.this.f53000l = true;
                a.this.unsubscribe();
                if (a.this.f52993e.getAndIncrement() == 0) {
                    a.this.f52997i.clear();
                }
            }

            void a(long j6) {
                rx.internal.operators.a.i(this, j6);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52999k = true;
            g();
        }

        void g() {
            if (this.f52993e.getAndIncrement() != 0) {
                return;
            }
            rx.l<? super R> lVar = this.f52989a;
            Queue<Object> queue = this.f52997i;
            boolean z5 = this.f52991c;
            AtomicInteger atomicInteger = this.f52994f;
            int i6 = 1;
            do {
                long j6 = this.f52998j.get();
                long j7 = 0;
                while (j7 != j6) {
                    if (this.f53000l) {
                        queue.clear();
                        return;
                    }
                    boolean z6 = this.f52999k;
                    if (!z5 && z6 && this.f52996h.get() != null) {
                        queue.clear();
                        lVar.onError(ExceptionsUtils.terminate(this.f52996h));
                        return;
                    }
                    Object poll = queue.poll();
                    boolean z7 = poll == null;
                    if (z6 && atomicInteger.get() == 0 && z7) {
                        if (this.f52996h.get() != null) {
                            lVar.onError(ExceptionsUtils.terminate(this.f52996h));
                            return;
                        } else {
                            lVar.onCompleted();
                            return;
                        }
                    }
                    if (z7) {
                        break;
                    }
                    lVar.onNext((Object) v.e(poll));
                    j7++;
                }
                if (j7 == j6) {
                    if (this.f53000l) {
                        queue.clear();
                        return;
                    }
                    if (this.f52999k) {
                        if (z5) {
                            if (atomicInteger.get() == 0 && queue.isEmpty()) {
                                if (this.f52996h.get() != null) {
                                    lVar.onError(ExceptionsUtils.terminate(this.f52996h));
                                    return;
                                } else {
                                    lVar.onCompleted();
                                    return;
                                }
                            }
                        } else if (this.f52996h.get() != null) {
                            queue.clear();
                            lVar.onError(ExceptionsUtils.terminate(this.f52996h));
                            return;
                        } else if (atomicInteger.get() == 0 && queue.isEmpty()) {
                            lVar.onCompleted();
                            return;
                        }
                    }
                }
                if (j7 != 0) {
                    this.f52998j.a(j7);
                    if (!this.f52999k && this.f52992d != Integer.MAX_VALUE) {
                        request(j7);
                    }
                }
                i6 = this.f52993e.addAndGet(-i6);
            } while (i6 != 0);
        }

        void j(a<T, R>.C1036a c1036a, Throwable th) {
            if (this.f52991c) {
                ExceptionsUtils.addThrowable(this.f52996h, th);
                this.f52995g.f(c1036a);
                if (!this.f52999k && this.f52992d != Integer.MAX_VALUE) {
                    request(1L);
                }
            } else {
                this.f52995g.unsubscribe();
                unsubscribe();
                if (!androidx.camera.view.p.a(this.f52996h, null, th)) {
                    rx.plugins.c.I(th);
                    return;
                }
                this.f52999k = true;
            }
            this.f52994f.decrementAndGet();
            g();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f52991c) {
                ExceptionsUtils.addThrowable(this.f52996h, th);
            } else {
                this.f52995g.unsubscribe();
                if (!androidx.camera.view.p.a(this.f52996h, null, th)) {
                    rx.plugins.c.I(th);
                    return;
                }
            }
            this.f52999k = true;
            g();
        }

        @Override // rx.f
        public void onNext(T t5) {
            try {
                rx.i<? extends R> call = this.f52990b.call(t5);
                if (call == null) {
                    throw new NullPointerException("The mapper returned a null Single");
                }
                C1036a c1036a = new C1036a();
                this.f52995g.a(c1036a);
                this.f52994f.incrementAndGet();
                call.j0(c1036a);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(th);
            }
        }

        void s(a<T, R>.C1036a c1036a, R r5) {
            this.f52997i.offer(v.j(r5));
            this.f52995g.f(c1036a);
            this.f52994f.decrementAndGet();
            g();
        }

        a(rx.l<? super R> lVar, rx.functions.p<? super T, ? extends rx.i<? extends R>> pVar, boolean z5, int i6) {
            long j6;
            this.f52989a = lVar;
            this.f52990b = pVar;
            this.f52991c = z5;
            this.f52992d = i6;
            if (rx.internal.util.unsafe.n0.f()) {
                this.f52997i = new rx.internal.util.unsafe.o();
            } else {
                this.f52997i = new rx.internal.util.atomic.c();
            }
            if (i6 != Integer.MAX_VALUE) {
                j6 = i6;
            } else {
                j6 = Long.MAX_VALUE;
            }
            request(j6);
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super R> lVar) {
        a aVar = new a(lVar, this.f52986b, this.f52987c, this.f52988d);
        lVar.add(aVar.f52995g);
        lVar.add(aVar.f52998j);
        lVar.setProducer(aVar.f52998j);
        this.f52985a.J6(aVar);
    }

    public j0(rx.e<T> eVar, rx.functions.p<? super T, ? extends rx.i<? extends R>> pVar, boolean z5, int i6) {
        if (pVar != null) {
            if (i6 > 0) {
                this.f52985a = eVar;
                this.f52986b = pVar;
                this.f52987c = z5;
                this.f52988d = i6;
                return;
            }
            throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i6);
        }
        throw new NullPointerException("mapper is null");
    }
}
