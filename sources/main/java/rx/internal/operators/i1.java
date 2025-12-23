package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i1 implements e.a<Long> {

    /* renamed from: a, reason: collision with root package name */
    final long f52926a;

    /* renamed from: b, reason: collision with root package name */
    final long f52927b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f52928c;

    /* renamed from: d, reason: collision with root package name */
    final rx.h f52929d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        long f52930a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.l f52931b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ h.a f52932c;

        a(rx.l lVar, h.a aVar) {
            this.f52931b = lVar;
            this.f52932c = aVar;
        }

        @Override // rx.functions.a
        public void call() {
            try {
                rx.l lVar = this.f52931b;
                long j6 = this.f52930a;
                this.f52930a = 1 + j6;
                lVar.onNext(Long.valueOf(j6));
            } catch (Throwable th) {
                try {
                    this.f52932c.unsubscribe();
                } finally {
                    rx.exceptions.a.f(th, this.f52931b);
                }
            }
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super Long> lVar) {
        h.a a6 = this.f52929d.a();
        lVar.add(a6);
        a6.f(new a(lVar, a6), this.f52926a, this.f52927b, this.f52928c);
    }

    public i1(long j6, long j7, TimeUnit timeUnit, rx.h hVar) {
        this.f52926a = j6;
        this.f52927b = j7;
        this.f52928c = timeUnit;
        this.f52929d = hVar;
    }
}
