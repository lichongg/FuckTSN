package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.h;
import rx.internal.subscriptions.SequentialSubscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final long f54041a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        long f54042a;

        /* renamed from: b, reason: collision with root package name */
        long f54043b;

        /* renamed from: c, reason: collision with root package name */
        long f54044c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f54045d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f54046e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f54047f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ SequentialSubscription f54048g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ b f54049h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ h.a f54050i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f54051j;

        a(long j6, long j7, rx.functions.a aVar, SequentialSubscription sequentialSubscription, b bVar, h.a aVar2, long j8) {
            this.f54045d = j6;
            this.f54046e = j7;
            this.f54047f = aVar;
            this.f54048g = sequentialSubscription;
            this.f54049h = bVar;
            this.f54050i = aVar2;
            this.f54051j = j8;
            this.f54043b = j6;
            this.f54044c = j7;
        }

        @Override // rx.functions.a
        public void call() {
            long j6;
            this.f54047f.call();
            if (this.f54048g.isUnsubscribed()) {
                return;
            }
            b bVar = this.f54049h;
            long a6 = bVar != null ? bVar.a() : TimeUnit.MILLISECONDS.toNanos(this.f54050i.b());
            long j7 = i.f54041a;
            long j8 = a6 + j7;
            long j9 = this.f54043b;
            if (j8 >= j9) {
                long j10 = this.f54051j;
                if (a6 < j9 + j10 + j7) {
                    long j11 = this.f54044c;
                    long j12 = this.f54042a + 1;
                    this.f54042a = j12;
                    j6 = j11 + (j12 * j10);
                    this.f54043b = a6;
                    this.f54048g.replace(this.f54050i.e(this, j6 - a6, TimeUnit.NANOSECONDS));
                }
            }
            long j13 = this.f54051j;
            long j14 = a6 + j13;
            long j15 = this.f54042a + 1;
            this.f54042a = j15;
            this.f54044c = j14 - (j13 * j15);
            j6 = j14;
            this.f54043b = a6;
            this.f54048g.replace(this.f54050i.e(this, j6 - a6, TimeUnit.NANOSECONDS));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        long a();
    }

    public static rx.m a(h.a aVar, rx.functions.a aVar2, long j6, long j7, TimeUnit timeUnit, b bVar) {
        long nanos = timeUnit.toNanos(j7);
        long a6 = bVar != null ? bVar.a() : TimeUnit.MILLISECONDS.toNanos(aVar.b());
        long nanos2 = timeUnit.toNanos(j6) + a6;
        SequentialSubscription sequentialSubscription = new SequentialSubscription();
        SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
        sequentialSubscription.replace(aVar.e(new a(a6, nanos2, aVar2, sequentialSubscription2, bVar, aVar, nanos), j6, timeUnit));
        return sequentialSubscription2;
    }

    private i() {
        throw new IllegalStateException("No instances!");
    }
}
