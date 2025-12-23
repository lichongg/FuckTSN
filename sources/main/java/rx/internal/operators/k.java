package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;
import rx.exceptions.MissingBackpressureException;
import rx.internal.subscriptions.SequentialSubscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k implements b.j0 {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<rx.b> f53064a;

    /* renamed from: b, reason: collision with root package name */
    final int f53065b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends rx.l<rx.b> {

        /* renamed from: a, reason: collision with root package name */
        final rx.d f53066a;

        /* renamed from: b, reason: collision with root package name */
        final SequentialSubscription f53067b;

        /* renamed from: c, reason: collision with root package name */
        final rx.internal.util.unsafe.z<rx.b> f53068c;

        /* renamed from: d, reason: collision with root package name */
        final C1039a f53069d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicBoolean f53070e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f53071f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f53072g;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.k$a$a, reason: collision with other inner class name */
        final class C1039a extends AtomicInteger implements rx.d {
            private static final long serialVersionUID = 7233503139645205620L;

            C1039a() {
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                a.this.f53067b.set(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                a.this.j();
            }

            @Override // rx.d
            public void onError(Throwable th) {
                a.this.s(th);
            }
        }

        void j() {
            this.f53072g = false;
            g();
        }

        @Override // rx.f
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public void onNext(rx.b bVar) {
            if (this.f53068c.offer(bVar)) {
                g();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        void g() {
            C1039a c1039a = this.f53069d;
            if (c1039a.getAndIncrement() != 0) {
                return;
            }
            while (!isUnsubscribed()) {
                if (!this.f53072g) {
                    boolean z5 = this.f53071f;
                    rx.b poll = this.f53068c.poll();
                    boolean z6 = poll == null;
                    if (z5 && z6) {
                        this.f53066a.onCompleted();
                        return;
                    } else if (!z6) {
                        this.f53072g = true;
                        poll.q0(c1039a);
                        request(1L);
                    }
                }
                if (c1039a.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53071f) {
                return;
            }
            this.f53071f = true;
            g();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53070e.compareAndSet(false, true)) {
                this.f53066a.onError(th);
            } else {
                rx.plugins.c.I(th);
            }
        }

        public a(rx.d dVar, int i6) {
            this.f53066a = dVar;
            this.f53068c = new rx.internal.util.unsafe.z<>(i6);
            SequentialSubscription sequentialSubscription = new SequentialSubscription();
            this.f53067b = sequentialSubscription;
            this.f53069d = new C1039a();
            this.f53070e = new AtomicBoolean();
            add(sequentialSubscription);
            request(i6);
        }

        void s(Throwable th) {
            unsubscribe();
            onError(th);
        }
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        a aVar = new a(dVar, this.f53065b);
        dVar.a(aVar);
        this.f53064a.J6(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(rx.e<? extends rx.b> eVar, int i6) {
        this.f53064a = eVar;
        this.f53065b = i6;
    }
}
