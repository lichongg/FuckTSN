package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u2<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.p<? super Throwable, ? extends rx.e<? extends T>> f53575a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements rx.functions.p<Throwable, rx.e<? extends T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.p f53576a;

        a(rx.functions.p pVar) {
            this.f53576a = pVar;
        }

        @Override // rx.functions.p
        public rx.e<? extends T> call(Throwable th) {
            return rx.e.M2(this.f53576a.call(th));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements rx.functions.p<Throwable, rx.e<? extends T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.e f53577a;

        b(rx.e eVar) {
            this.f53577a = eVar;
        }

        @Override // rx.functions.p
        public rx.e<? extends T> call(Throwable th) {
            return this.f53577a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements rx.functions.p<Throwable, rx.e<? extends T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.e f53578a;

        c(rx.e eVar) {
            this.f53578a = eVar;
        }

        @Override // rx.functions.p
        public rx.e<? extends T> call(Throwable th) {
            return th instanceof Exception ? this.f53578a : rx.e.T1(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private boolean f53579a;

        /* renamed from: b, reason: collision with root package name */
        long f53580b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.l f53581c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rx.internal.producers.a f53582d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.e f53583e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends rx.l<T> {
            a() {
            }

            @Override // rx.f
            public void onCompleted() {
                d.this.f53581c.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                d.this.f53581c.onError(th);
            }

            @Override // rx.f
            public void onNext(T t5) {
                d.this.f53581c.onNext(t5);
            }

            @Override // rx.l, rx.observers.a
            public void setProducer(rx.g gVar) {
                d.this.f53582d.c(gVar);
            }
        }

        d(rx.l lVar, rx.internal.producers.a aVar, rx.subscriptions.e eVar) {
            this.f53581c = lVar;
            this.f53582d = aVar;
            this.f53583e = eVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53579a) {
                return;
            }
            this.f53579a = true;
            this.f53581c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53579a) {
                rx.exceptions.a.e(th);
                rx.plugins.c.I(th);
                return;
            }
            this.f53579a = true;
            try {
                unsubscribe();
                a aVar = new a();
                this.f53583e.b(aVar);
                long j6 = this.f53580b;
                if (j6 != 0) {
                    this.f53582d.b(j6);
                }
                u2.this.f53575a.call(th).J6(aVar);
            } catch (Throwable th2) {
                rx.exceptions.a.f(th2, this.f53581c);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53579a) {
                return;
            }
            this.f53580b++;
            this.f53581c.onNext(t5);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f53582d.c(gVar);
        }
    }

    public static <T> u2<T> a(rx.e<? extends T> eVar) {
        return new u2<>(new c(eVar));
    }

    public static <T> u2<T> b(rx.e<? extends T> eVar) {
        return new u2<>(new b(eVar));
    }

    public static <T> u2<T> c(rx.functions.p<? super Throwable, ? extends T> pVar) {
        return new u2<>(new a(pVar));
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        d dVar = new d(lVar, aVar, eVar);
        eVar.b(dVar);
        lVar.add(eVar);
        lVar.setProducer(aVar);
        return dVar;
    }

    public u2(rx.functions.p<? super Throwable, ? extends rx.e<? extends T>> pVar) {
        this.f53575a = pVar;
    }
}
