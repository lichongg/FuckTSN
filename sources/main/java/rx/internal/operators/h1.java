package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h1 implements e.a<Long> {

    /* renamed from: a, reason: collision with root package name */
    final long f52881a;

    /* renamed from: b, reason: collision with root package name */
    final TimeUnit f52882b;

    /* renamed from: c, reason: collision with root package name */
    final rx.h f52883c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f52884a;

        a(rx.l lVar) {
            this.f52884a = lVar;
        }

        @Override // rx.functions.a
        public void call() {
            try {
                this.f52884a.onNext(0L);
                this.f52884a.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this.f52884a);
            }
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super Long> lVar) {
        h.a a6 = this.f52883c.a();
        lVar.add(a6);
        a6.e(new a(lVar), this.f52881a, this.f52882b);
    }

    public h1(long j6, TimeUnit timeUnit, rx.h hVar) {
        this.f52881a = j6;
        this.f52882b = timeUnit;
        this.f52883c = hVar;
    }
}
