package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.MissingBackpressureException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r1<T> implements e.b<List<T>, T> {

    /* renamed from: a, reason: collision with root package name */
    final int f53419a;

    /* renamed from: b, reason: collision with root package name */
    final int f53420b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super List<T>> f53421a;

        /* renamed from: b, reason: collision with root package name */
        final int f53422b;

        /* renamed from: c, reason: collision with root package name */
        List<T> f53423c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.r1$a$a, reason: collision with other inner class name */
        class C1047a implements rx.g {
            C1047a() {
            }

            @Override // rx.g
            public void request(long j6) {
                if (j6 < 0) {
                    throw new IllegalArgumentException("n >= required but it was " + j6);
                }
                if (j6 != 0) {
                    a.this.request(rx.internal.operators.a.c(j6, a.this.f53422b));
                }
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53423c = null;
            this.f53421a.onError(th);
        }

        rx.g j() {
            return new C1047a();
        }

        @Override // rx.f
        public void onCompleted() {
            List<T> list = this.f53423c;
            if (list != null) {
                this.f53421a.onNext(list);
            }
            this.f53421a.onCompleted();
        }

        @Override // rx.f
        public void onNext(T t5) {
            List list = this.f53423c;
            if (list == null) {
                list = new ArrayList(this.f53422b);
                this.f53423c = list;
            }
            list.add(t5);
            if (list.size() == this.f53422b) {
                this.f53423c = null;
                this.f53421a.onNext(list);
            }
        }

        public a(rx.l<? super List<T>> lVar, int i6) {
            this.f53421a = lVar;
            this.f53422b = i6;
            request(0L);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super List<T>> f53425a;

        /* renamed from: b, reason: collision with root package name */
        final int f53426b;

        /* renamed from: c, reason: collision with root package name */
        final int f53427c;

        /* renamed from: d, reason: collision with root package name */
        long f53428d;

        /* renamed from: e, reason: collision with root package name */
        final ArrayDeque<List<T>> f53429e = new ArrayDeque<>();

        /* renamed from: f, reason: collision with root package name */
        final AtomicLong f53430f = new AtomicLong();

        /* renamed from: g, reason: collision with root package name */
        long f53431g;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class a extends AtomicBoolean implements rx.g {
            private static final long serialVersionUID = -4015894850868853147L;

            a() {
            }

            @Override // rx.g
            public void request(long j6) {
                b bVar = b.this;
                if (!rx.internal.operators.a.g(bVar.f53430f, j6, bVar.f53429e, bVar.f53425a) || j6 == 0) {
                    return;
                }
                if (get() || !compareAndSet(false, true)) {
                    bVar.request(rx.internal.operators.a.c(bVar.f53427c, j6));
                } else {
                    bVar.request(rx.internal.operators.a.a(rx.internal.operators.a.c(bVar.f53427c, j6 - 1), bVar.f53426b));
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            long j6 = this.f53431g;
            if (j6 != 0) {
                if (j6 > this.f53430f.get()) {
                    this.f53425a.onError(new MissingBackpressureException("More produced than requested? " + j6));
                    return;
                }
                this.f53430f.addAndGet(-j6);
            }
            rx.internal.operators.a.d(this.f53430f, this.f53429e, this.f53425a);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53429e.clear();
            this.f53425a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            long j6 = this.f53428d;
            if (j6 == 0) {
                this.f53429e.offer(new ArrayList(this.f53426b));
            }
            long j7 = j6 + 1;
            if (j7 == this.f53427c) {
                this.f53428d = 0L;
            } else {
                this.f53428d = j7;
            }
            Iterator<List<T>> it = this.f53429e.iterator();
            while (it.hasNext()) {
                it.next().add(t5);
            }
            List<T> peek = this.f53429e.peek();
            if (peek == null || peek.size() != this.f53426b) {
                return;
            }
            this.f53429e.poll();
            this.f53431g++;
            this.f53425a.onNext(peek);
        }

        rx.g s() {
            return new a();
        }

        public b(rx.l<? super List<T>> lVar, int i6, int i7) {
            this.f53425a = lVar;
            this.f53426b = i6;
            this.f53427c = i7;
            request(0L);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super List<T>> f53433a;

        /* renamed from: b, reason: collision with root package name */
        final int f53434b;

        /* renamed from: c, reason: collision with root package name */
        final int f53435c;

        /* renamed from: d, reason: collision with root package name */
        long f53436d;

        /* renamed from: e, reason: collision with root package name */
        List<T> f53437e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class a extends AtomicBoolean implements rx.g {
            private static final long serialVersionUID = 3428177408082367154L;

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
                        cVar.request(rx.internal.operators.a.c(j6, cVar.f53435c));
                    } else {
                        cVar.request(rx.internal.operators.a.a(rx.internal.operators.a.c(j6, cVar.f53434b), rx.internal.operators.a.c(cVar.f53435c - cVar.f53434b, j6 - 1)));
                    }
                }
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53437e = null;
            this.f53433a.onError(th);
        }

        @Override // rx.f
        public void onCompleted() {
            List<T> list = this.f53437e;
            if (list != null) {
                this.f53437e = null;
                this.f53433a.onNext(list);
            }
            this.f53433a.onCompleted();
        }

        @Override // rx.f
        public void onNext(T t5) {
            long j6 = this.f53436d;
            List list = this.f53437e;
            if (j6 == 0) {
                list = new ArrayList(this.f53434b);
                this.f53437e = list;
            }
            long j7 = j6 + 1;
            if (j7 == this.f53435c) {
                this.f53436d = 0L;
            } else {
                this.f53436d = j7;
            }
            if (list != null) {
                list.add(t5);
                if (list.size() == this.f53434b) {
                    this.f53437e = null;
                    this.f53433a.onNext(list);
                }
            }
        }

        rx.g s() {
            return new a();
        }

        public c(rx.l<? super List<T>> lVar, int i6, int i7) {
            this.f53433a = lVar;
            this.f53434b = i6;
            this.f53435c = i7;
            request(0L);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super List<T>> lVar) {
        int i6 = this.f53420b;
        int i7 = this.f53419a;
        if (i6 == i7) {
            a aVar = new a(lVar, i7);
            lVar.add(aVar);
            lVar.setProducer(aVar.j());
            return aVar;
        }
        if (i6 > i7) {
            c cVar = new c(lVar, i7, i6);
            lVar.add(cVar);
            lVar.setProducer(cVar.s());
            return cVar;
        }
        b bVar = new b(lVar, i7, i6);
        lVar.add(bVar);
        lVar.setProducer(bVar.s());
        return bVar;
    }

    public r1(int i6, int i7) {
        if (i6 > 0) {
            if (i7 > 0) {
                this.f53419a = i6;
                this.f53420b = i7;
                return;
            }
            throw new IllegalArgumentException("skip must be greater than 0");
        }
        throw new IllegalArgumentException("count must be greater than 0");
    }
}
