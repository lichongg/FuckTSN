package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n3<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final long f53221a;

    /* renamed from: b, reason: collision with root package name */
    final rx.h f53222b;

    /* renamed from: c, reason: collision with root package name */
    final int f53223c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f53224a;

        a(b bVar) {
            this.f53224a = bVar;
        }

        @Override // rx.g
        public void request(long j6) {
            this.f53224a.j(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends rx.l<T> implements rx.functions.p<Object, T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f53226a;

        /* renamed from: b, reason: collision with root package name */
        final long f53227b;

        /* renamed from: c, reason: collision with root package name */
        final rx.h f53228c;

        /* renamed from: d, reason: collision with root package name */
        final int f53229d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicLong f53230e = new AtomicLong();

        /* renamed from: f, reason: collision with root package name */
        final ArrayDeque<Object> f53231f = new ArrayDeque<>();

        /* renamed from: g, reason: collision with root package name */
        final ArrayDeque<Long> f53232g = new ArrayDeque<>();

        protected void g(long j6) {
            long j7 = j6 - this.f53227b;
            while (true) {
                Long peek = this.f53232g.peek();
                if (peek == null || peek.longValue() >= j7) {
                    return;
                }
                this.f53231f.poll();
                this.f53232g.poll();
            }
        }

        void j(long j6) {
            rx.internal.operators.a.h(this.f53230e, j6, this.f53231f, this.f53226a, this);
        }

        @Override // rx.f
        public void onCompleted() {
            g(this.f53228c.b());
            this.f53232g.clear();
            rx.internal.operators.a.e(this.f53230e, this.f53231f, this.f53226a, this);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53231f.clear();
            this.f53232g.clear();
            this.f53226a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53229d != 0) {
                long b6 = this.f53228c.b();
                if (this.f53231f.size() == this.f53229d) {
                    this.f53231f.poll();
                    this.f53232g.poll();
                }
                g(b6);
                this.f53231f.offer(v.j(t5));
                this.f53232g.offer(Long.valueOf(b6));
            }
        }

        public b(rx.l<? super T> lVar, int i6, long j6, rx.h hVar) {
            this.f53226a = lVar;
            this.f53229d = i6;
            this.f53227b = j6;
            this.f53228c = hVar;
        }

        @Override // rx.functions.p
        public T call(Object obj) {
            return (T) v.e(obj);
        }
    }

    public n3(long j6, TimeUnit timeUnit, rx.h hVar) {
        this.f53221a = timeUnit.toMillis(j6);
        this.f53222b = hVar;
        this.f53223c = -1;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar, this.f53223c, this.f53221a, this.f53222b);
        lVar.add(bVar);
        lVar.setProducer(new a(bVar));
        return bVar;
    }

    public n3(int i6, long j6, TimeUnit timeUnit, rx.h hVar) {
        if (i6 >= 0) {
            this.f53221a = timeUnit.toMillis(j6);
            this.f53222b = hVar;
            this.f53223c = i6;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }
}
