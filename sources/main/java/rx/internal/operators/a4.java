package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a4<T> implements e.b<rx.e<T>, T> {

    /* renamed from: a, reason: collision with root package name */
    final int f52534a;

    /* renamed from: b, reason: collision with root package name */
    final int f52535b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super rx.e<T>> f52536a;

        /* renamed from: b, reason: collision with root package name */
        final int f52537b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicInteger f52538c = new AtomicInteger(1);

        /* renamed from: d, reason: collision with root package name */
        final rx.m f52539d;

        /* renamed from: e, reason: collision with root package name */
        int f52540e;

        /* renamed from: f, reason: collision with root package name */
        rx.subjects.f<T, T> f52541f;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.a4$a$a, reason: collision with other inner class name */
        class C1026a implements rx.g {
            C1026a() {
            }

            @Override // rx.g
            public void request(long j6) {
                if (j6 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j6);
                }
                if (j6 != 0) {
                    a.this.request(rx.internal.operators.a.c(a.this.f52537b, j6));
                }
            }
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f52538c.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        rx.g j() {
            return new C1026a();
        }

        @Override // rx.f
        public void onCompleted() {
            rx.subjects.f<T, T> fVar = this.f52541f;
            if (fVar != null) {
                this.f52541f = null;
                fVar.onCompleted();
            }
            this.f52536a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            rx.subjects.f<T, T> fVar = this.f52541f;
            if (fVar != null) {
                this.f52541f = null;
                fVar.onError(th);
            }
            this.f52536a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            int i6 = this.f52540e;
            rx.subjects.i iVar = this.f52541f;
            if (i6 == 0) {
                this.f52538c.getAndIncrement();
                iVar = rx.subjects.i.A7(this.f52537b, this);
                this.f52541f = iVar;
                this.f52536a.onNext(iVar);
            }
            int i7 = i6 + 1;
            iVar.onNext(t5);
            if (i7 != this.f52537b) {
                this.f52540e = i7;
                return;
            }
            this.f52540e = 0;
            this.f52541f = null;
            iVar.onCompleted();
        }

        public a(rx.l<? super rx.e<T>> lVar, int i6) {
            this.f52536a = lVar;
            this.f52537b = i6;
            rx.m a6 = rx.subscriptions.f.a(this);
            this.f52539d = a6;
            add(a6);
            request(0L);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super rx.e<T>> f52543a;

        /* renamed from: b, reason: collision with root package name */
        final int f52544b;

        /* renamed from: c, reason: collision with root package name */
        final int f52545c;

        /* renamed from: e, reason: collision with root package name */
        final rx.m f52547e;

        /* renamed from: i, reason: collision with root package name */
        final Queue<rx.subjects.f<T, T>> f52551i;

        /* renamed from: j, reason: collision with root package name */
        Throwable f52552j;

        /* renamed from: k, reason: collision with root package name */
        volatile boolean f52553k;

        /* renamed from: l, reason: collision with root package name */
        int f52554l;

        /* renamed from: m, reason: collision with root package name */
        int f52555m;

        /* renamed from: d, reason: collision with root package name */
        final AtomicInteger f52546d = new AtomicInteger(1);

        /* renamed from: f, reason: collision with root package name */
        final ArrayDeque<rx.subjects.f<T, T>> f52548f = new ArrayDeque<>();

        /* renamed from: h, reason: collision with root package name */
        final AtomicInteger f52550h = new AtomicInteger();

        /* renamed from: g, reason: collision with root package name */
        final AtomicLong f52549g = new AtomicLong();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class a extends AtomicBoolean implements rx.g {
            private static final long serialVersionUID = 4625807964358024108L;

            a() {
            }

            @Override // rx.g
            public void request(long j6) {
                if (j6 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j6);
                }
                if (j6 != 0) {
                    b bVar = b.this;
                    if (get() || !compareAndSet(false, true)) {
                        b.this.request(rx.internal.operators.a.c(bVar.f52545c, j6));
                    } else {
                        bVar.request(rx.internal.operators.a.a(rx.internal.operators.a.c(bVar.f52545c, j6 - 1), bVar.f52544b));
                    }
                    rx.internal.operators.a.b(bVar.f52549g, j6);
                    bVar.B();
                }
            }
        }

        rx.g A() {
            return new a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void B() {
            AtomicInteger atomicInteger = this.f52550h;
            if (atomicInteger.getAndIncrement() != 0) {
                return;
            }
            rx.l<? super rx.e<T>> lVar = this.f52543a;
            Queue<rx.subjects.f<T, T>> queue = this.f52551i;
            int i6 = 1;
            do {
                long j6 = this.f52549g.get();
                long j7 = 0;
                while (j7 != j6) {
                    boolean z5 = this.f52553k;
                    rx.subjects.f<T, T> poll = queue.poll();
                    boolean z6 = poll == null;
                    if (s(z5, z6, lVar, queue)) {
                        return;
                    }
                    if (z6) {
                        break;
                    }
                    lVar.onNext(poll);
                    j7++;
                }
                if (j7 == j6 && s(this.f52553k, queue.isEmpty(), lVar, queue)) {
                    return;
                }
                if (j7 != 0 && j6 != Long.MAX_VALUE) {
                    this.f52549g.addAndGet(-j7);
                }
                i6 = atomicInteger.addAndGet(-i6);
            } while (i6 != 0);
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f52546d.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            Iterator<rx.subjects.f<T, T>> it = this.f52548f.iterator();
            while (it.hasNext()) {
                it.next().onCompleted();
            }
            this.f52548f.clear();
            this.f52553k = true;
            B();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            Iterator<rx.subjects.f<T, T>> it = this.f52548f.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.f52548f.clear();
            this.f52552j = th;
            this.f52553k = true;
            B();
        }

        @Override // rx.f
        public void onNext(T t5) {
            int i6 = this.f52554l;
            ArrayDeque<rx.subjects.f<T, T>> arrayDeque = this.f52548f;
            if (i6 == 0 && !this.f52543a.isUnsubscribed()) {
                this.f52546d.getAndIncrement();
                rx.subjects.i A7 = rx.subjects.i.A7(16, this);
                arrayDeque.offer(A7);
                this.f52551i.offer(A7);
                B();
            }
            Iterator<rx.subjects.f<T, T>> it = this.f52548f.iterator();
            while (it.hasNext()) {
                it.next().onNext(t5);
            }
            int i7 = this.f52555m + 1;
            if (i7 == this.f52544b) {
                this.f52555m = i7 - this.f52545c;
                rx.subjects.f<T, T> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.onCompleted();
                }
            } else {
                this.f52555m = i7;
            }
            int i8 = i6 + 1;
            if (i8 == this.f52545c) {
                this.f52554l = 0;
            } else {
                this.f52554l = i8;
            }
        }

        public b(rx.l<? super rx.e<T>> lVar, int i6, int i7) {
            this.f52543a = lVar;
            this.f52544b = i6;
            this.f52545c = i7;
            rx.m a6 = rx.subscriptions.f.a(this);
            this.f52547e = a6;
            add(a6);
            request(0L);
            this.f52551i = new rx.internal.util.atomic.e((i6 + (i7 - 1)) / i7);
        }

        boolean s(boolean z5, boolean z6, rx.l<? super rx.subjects.f<T, T>> lVar, Queue<rx.subjects.f<T, T>> queue) {
            if (lVar.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (z5) {
                Throwable th = this.f52552j;
                if (th != null) {
                    queue.clear();
                    lVar.onError(th);
                    return true;
                }
                if (z6) {
                    lVar.onCompleted();
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super rx.e<T>> f52557a;

        /* renamed from: b, reason: collision with root package name */
        final int f52558b;

        /* renamed from: c, reason: collision with root package name */
        final int f52559c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicInteger f52560d = new AtomicInteger(1);

        /* renamed from: e, reason: collision with root package name */
        final rx.m f52561e;

        /* renamed from: f, reason: collision with root package name */
        int f52562f;

        /* renamed from: g, reason: collision with root package name */
        rx.subjects.f<T, T> f52563g;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class a extends AtomicBoolean implements rx.g {
            private static final long serialVersionUID = 4625807964358024108L;

            a() {
            }

            @Override // rx.g
            public void request(long j6) {
                if (j6 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j6);
                }
                if (j6 != 0) {
                    c cVar = c.this;
                    if (get() || !compareAndSet(false, true)) {
                        cVar.request(rx.internal.operators.a.c(j6, cVar.f52559c));
                    } else {
                        cVar.request(rx.internal.operators.a.a(rx.internal.operators.a.c(j6, cVar.f52558b), rx.internal.operators.a.c(cVar.f52559c - cVar.f52558b, j6 - 1)));
                    }
                }
            }
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f52560d.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            rx.subjects.f<T, T> fVar = this.f52563g;
            if (fVar != null) {
                this.f52563g = null;
                fVar.onCompleted();
            }
            this.f52557a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            rx.subjects.f<T, T> fVar = this.f52563g;
            if (fVar != null) {
                this.f52563g = null;
                fVar.onError(th);
            }
            this.f52557a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            int i6 = this.f52562f;
            rx.subjects.i iVar = this.f52563g;
            if (i6 == 0) {
                this.f52560d.getAndIncrement();
                iVar = rx.subjects.i.A7(this.f52558b, this);
                this.f52563g = iVar;
                this.f52557a.onNext(iVar);
            }
            int i7 = i6 + 1;
            if (iVar != null) {
                iVar.onNext(t5);
            }
            if (i7 == this.f52558b) {
                this.f52562f = i7;
                this.f52563g = null;
                iVar.onCompleted();
            } else if (i7 == this.f52559c) {
                this.f52562f = 0;
            } else {
                this.f52562f = i7;
            }
        }

        rx.g s() {
            return new a();
        }

        public c(rx.l<? super rx.e<T>> lVar, int i6, int i7) {
            this.f52557a = lVar;
            this.f52558b = i6;
            this.f52559c = i7;
            rx.m a6 = rx.subscriptions.f.a(this);
            this.f52561e = a6;
            add(a6);
            request(0L);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super rx.e<T>> lVar) {
        int i6 = this.f52535b;
        int i7 = this.f52534a;
        if (i6 == i7) {
            a aVar = new a(lVar, i7);
            lVar.add(aVar.f52539d);
            lVar.setProducer(aVar.j());
            return aVar;
        }
        if (i6 > i7) {
            c cVar = new c(lVar, i7, i6);
            lVar.add(cVar.f52561e);
            lVar.setProducer(cVar.s());
            return cVar;
        }
        b bVar = new b(lVar, i7, i6);
        lVar.add(bVar.f52547e);
        lVar.setProducer(bVar.A());
        return bVar;
    }

    public a4(int i6, int i7) {
        this.f52534a = i6;
        this.f52535b = i7;
    }
}
