package rx.internal.util;

import rx.functions.p;
import rx.h;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class l<T> extends rx.i<T> {

    /* renamed from: b, reason: collision with root package name */
    final T f54187b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements i.t<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f54188a;

        a(Object obj) {
            this.f54188a = obj;
        }

        @Override // rx.functions.b
        public void call(rx.k<? super T> kVar) {
            kVar.d((Object) this.f54188a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b<R> implements i.t<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f54189a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends rx.k<R> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ rx.k f54191b;

            a(rx.k kVar) {
                this.f54191b = kVar;
            }

            @Override // rx.k
            public void d(R r5) {
                this.f54191b.d(r5);
            }

            @Override // rx.k
            public void onError(Throwable th) {
                this.f54191b.onError(th);
            }
        }

        b(p pVar) {
            this.f54189a = pVar;
        }

        @Override // rx.functions.b
        public void call(rx.k<? super R> kVar) {
            rx.i iVar = (rx.i) this.f54189a.call(l.this.f54187b);
            if (iVar instanceof l) {
                kVar.d(((l) iVar).f54187b);
                return;
            }
            a aVar = new a(kVar);
            kVar.b(aVar);
            iVar.j0(aVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> implements i.t<T> {

        /* renamed from: a, reason: collision with root package name */
        private final rx.internal.schedulers.b f54193a;

        /* renamed from: b, reason: collision with root package name */
        private final T f54194b;

        @Override // rx.functions.b
        public void call(rx.k<? super T> kVar) {
            kVar.b(this.f54193a.e(new e(kVar, this.f54194b)));
        }

        c(rx.internal.schedulers.b bVar, T t5) {
            this.f54193a = bVar;
            this.f54194b = t5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d<T> implements i.t<T> {

        /* renamed from: a, reason: collision with root package name */
        private final rx.h f54195a;

        /* renamed from: b, reason: collision with root package name */
        private final T f54196b;

        @Override // rx.functions.b
        public void call(rx.k<? super T> kVar) {
            h.a a6 = this.f54195a.a();
            kVar.b(a6);
            a6.d(new e(kVar, this.f54196b));
        }

        d(rx.h hVar, T t5) {
            this.f54195a = hVar;
            this.f54196b = t5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e<T> implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        private final rx.k<? super T> f54197a;

        /* renamed from: b, reason: collision with root package name */
        private final T f54198b;

        @Override // rx.functions.a
        public void call() {
            try {
                this.f54197a.d(this.f54198b);
            } catch (Throwable th) {
                this.f54197a.onError(th);
            }
        }

        e(rx.k<? super T> kVar, T t5) {
            this.f54197a = kVar;
            this.f54198b = t5;
        }
    }

    protected l(T t5) {
        super(new a(t5));
        this.f54187b = t5;
    }

    public static <T> l<T> P0(T t5) {
        return new l<>(t5);
    }

    public T Q0() {
        return this.f54187b;
    }

    public <R> rx.i<R> R0(p<? super T, ? extends rx.i<? extends R>> pVar) {
        return rx.i.n(new b(pVar));
    }

    public rx.i<T> S0(rx.h hVar) {
        return hVar instanceof rx.internal.schedulers.b ? rx.i.n(new c((rx.internal.schedulers.b) hVar, this.f54187b)) : rx.i.n(new d(hVar, this.f54187b));
    }
}
