package rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.h;
import rx.internal.schedulers.i;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class d extends h {

    /* renamed from: c, reason: collision with root package name */
    static long f54473c;

    /* renamed from: a, reason: collision with root package name */
    final Queue<c> f54474a = new PriorityQueue(11, new a());

    /* renamed from: b, reason: collision with root package name */
    long f54475b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Comparator<c> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            long j6 = cVar.f54482a;
            long j7 = cVar2.f54482a;
            if (j6 == j7) {
                if (cVar.f54485d < cVar2.f54485d) {
                    return -1;
                }
                return cVar.f54485d > cVar2.f54485d ? 1 : 0;
            }
            if (j6 < j7) {
                return -1;
            }
            return j6 > j7 ? 1 : 0;
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b extends h.a implements i.b {

        /* renamed from: a, reason: collision with root package name */
        private final rx.subscriptions.a f54476a = new rx.subscriptions.a();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f54478a;

            a(c cVar) {
                this.f54478a = cVar;
            }

            @Override // rx.functions.a
            public void call() {
                d.this.f54474a.remove(this.f54478a);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.schedulers.d$b$b, reason: collision with other inner class name */
        class C1076b implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f54480a;

            C1076b(c cVar) {
                this.f54480a = cVar;
            }

            @Override // rx.functions.a
            public void call() {
                d.this.f54474a.remove(this.f54480a);
            }
        }

        @Override // rx.h.a
        public m f(rx.functions.a aVar, long j6, long j7, TimeUnit timeUnit) {
            return i.a(this, aVar, j6, j7, timeUnit, this);
        }

        b() {
        }

        @Override // rx.internal.schedulers.i.b
        public long a() {
            return d.this.f54475b;
        }

        @Override // rx.h.a
        public long b() {
            return d.this.b();
        }

        @Override // rx.h.a
        public m d(rx.functions.a aVar) {
            c cVar = new c(this, 0L, aVar);
            d.this.f54474a.add(cVar);
            return rx.subscriptions.f.a(new C1076b(cVar));
        }

        @Override // rx.h.a
        public m e(rx.functions.a aVar, long j6, TimeUnit timeUnit) {
            c cVar = new c(this, d.this.f54475b + timeUnit.toNanos(j6), aVar);
            d.this.f54474a.add(cVar);
            return rx.subscriptions.f.a(new a(cVar));
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f54476a.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f54476a.unsubscribe();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        final long f54482a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.a f54483b;

        /* renamed from: c, reason: collision with root package name */
        final h.a f54484c;

        /* renamed from: d, reason: collision with root package name */
        private final long f54485d;

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.f54482a), this.f54483b.toString());
        }

        c(h.a aVar, long j6, rx.functions.a aVar2) {
            long j7 = d.f54473c;
            d.f54473c = 1 + j7;
            this.f54485d = j7;
            this.f54482a = j6;
            this.f54483b = aVar2;
            this.f54484c = aVar;
        }
    }

    private void j(long j6) {
        while (!this.f54474a.isEmpty()) {
            c peek = this.f54474a.peek();
            long j7 = peek.f54482a;
            if (j7 > j6) {
                break;
            }
            if (j7 == 0) {
                j7 = this.f54475b;
            }
            this.f54475b = j7;
            this.f54474a.remove();
            if (!peek.f54484c.isUnsubscribed()) {
                peek.f54483b.call();
            }
        }
        this.f54475b = j6;
    }

    @Override // rx.h
    public h.a a() {
        return new b();
    }

    @Override // rx.h
    public long b() {
        return TimeUnit.NANOSECONDS.toMillis(this.f54475b);
    }

    public void e(long j6, TimeUnit timeUnit) {
        f(this.f54475b + timeUnit.toNanos(j6), TimeUnit.NANOSECONDS);
    }

    public void g() {
        j(this.f54475b);
    }

    public void f(long j6, TimeUnit timeUnit) {
        j(timeUnit.toNanos(j6));
    }
}
