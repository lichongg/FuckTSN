package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x1<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final long f53785a;

    /* renamed from: b, reason: collision with root package name */
    final TimeUnit f53786b;

    /* renamed from: c, reason: collision with root package name */
    final rx.h f53787c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        boolean f53788a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h.a f53789b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.l f53790c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.x1$a$a, reason: collision with other inner class name */
        class C1054a implements rx.functions.a {
            C1054a() {
            }

            @Override // rx.functions.a
            public void call() {
                a aVar = a.this;
                if (aVar.f53788a) {
                    return;
                }
                aVar.f53788a = true;
                aVar.f53790c.onCompleted();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Throwable f53793a;

            b(Throwable th) {
                this.f53793a = th;
            }

            @Override // rx.functions.a
            public void call() {
                a aVar = a.this;
                if (aVar.f53788a) {
                    return;
                }
                aVar.f53788a = true;
                aVar.f53790c.onError(this.f53793a);
                a.this.f53789b.unsubscribe();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class c implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f53795a;

            c(Object obj) {
                this.f53795a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.functions.a
            public void call() {
                a aVar = a.this;
                if (aVar.f53788a) {
                    return;
                }
                aVar.f53790c.onNext(this.f53795a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, h.a aVar, rx.l lVar2) {
            super(lVar);
            this.f53789b = aVar;
            this.f53790c = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            h.a aVar = this.f53789b;
            C1054a c1054a = new C1054a();
            x1 x1Var = x1.this;
            aVar.e(c1054a, x1Var.f53785a, x1Var.f53786b);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53789b.d(new b(th));
        }

        @Override // rx.f
        public void onNext(T t5) {
            h.a aVar = this.f53789b;
            c cVar = new c(t5);
            x1 x1Var = x1.this;
            aVar.e(cVar, x1Var.f53785a, x1Var.f53786b);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        h.a a6 = this.f53787c.a();
        lVar.add(a6);
        return new a(lVar, a6, lVar);
    }

    public x1(long j6, TimeUnit timeUnit, rx.h hVar) {
        this.f53785a = j6;
        this.f53786b = timeUnit;
        this.f53787c = hVar;
    }
}
