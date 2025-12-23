package rx.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m extends rx.h {

    /* renamed from: a, reason: collision with root package name */
    public static final m f54074a = new m();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends h.a implements rx.m {

        /* renamed from: a, reason: collision with root package name */
        final AtomicInteger f54075a = new AtomicInteger();

        /* renamed from: b, reason: collision with root package name */
        final PriorityBlockingQueue<b> f54076b = new PriorityBlockingQueue<>();

        /* renamed from: c, reason: collision with root package name */
        private final rx.subscriptions.a f54077c = new rx.subscriptions.a();

        /* renamed from: d, reason: collision with root package name */
        private final AtomicInteger f54078d = new AtomicInteger();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.schedulers.m$a$a, reason: collision with other inner class name */
        class C1068a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f54079a;

            C1068a(b bVar) {
                this.f54079a = bVar;
            }

            @Override // rx.functions.a
            public void call() {
                a.this.f54076b.remove(this.f54079a);
            }
        }

        private rx.m g(rx.functions.a aVar, long j6) {
            if (this.f54077c.isUnsubscribed()) {
                return rx.subscriptions.f.e();
            }
            b bVar = new b(aVar, Long.valueOf(j6), this.f54075a.incrementAndGet());
            this.f54076b.add(bVar);
            if (this.f54078d.getAndIncrement() != 0) {
                return rx.subscriptions.f.a(new C1068a(bVar));
            }
            do {
                b poll = this.f54076b.poll();
                if (poll != null) {
                    poll.f54081a.call();
                }
            } while (this.f54078d.decrementAndGet() > 0);
            return rx.subscriptions.f.e();
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f54077c.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f54077c.unsubscribe();
        }

        a() {
        }

        @Override // rx.h.a
        public rx.m d(rx.functions.a aVar) {
            return g(aVar, b());
        }

        @Override // rx.h.a
        public rx.m e(rx.functions.a aVar, long j6, TimeUnit timeUnit) {
            long b6 = b() + timeUnit.toMillis(j6);
            return g(new l(aVar, this, b6), b6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b implements Comparable<b> {

        /* renamed from: a, reason: collision with root package name */
        final rx.functions.a f54081a;

        /* renamed from: b, reason: collision with root package name */
        final Long f54082b;

        /* renamed from: c, reason: collision with root package name */
        final int f54083c;

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int compareTo = this.f54082b.compareTo(bVar.f54082b);
            return compareTo == 0 ? m.e(this.f54083c, bVar.f54083c) : compareTo;
        }

        b(rx.functions.a aVar, Long l6, int i6) {
            this.f54081a = aVar;
            this.f54082b = l6;
            this.f54083c = i6;
        }
    }

    static int e(int i6, int i7) {
        if (i6 < i7) {
            return -1;
        }
        return i6 == i7 ? 0 : 1;
    }

    @Override // rx.h
    public h.a a() {
        return new a();
    }

    private m() {
    }
}
