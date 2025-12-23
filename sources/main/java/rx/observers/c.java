package rx.observers;

import rx.exceptions.OnErrorNotImplementedException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final rx.f<Object> f54396a = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements rx.f<Object> {
        @Override // rx.f
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        a() {
        }

        @Override // rx.f
        public final void onCompleted() {
        }

        @Override // rx.f
        public final void onNext(Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b<T> implements rx.f<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54397a;

        b(rx.functions.b bVar) {
            this.f54397a = bVar;
        }

        @Override // rx.f
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // rx.f
        public final void onNext(T t5) {
            this.f54397a.call(t5);
        }

        @Override // rx.f
        public final void onCompleted() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.observers.c$c, reason: collision with other inner class name */
    static class C1074c<T> implements rx.f<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54398a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54399b;

        C1074c(rx.functions.b bVar, rx.functions.b bVar2) {
            this.f54398a = bVar;
            this.f54399b = bVar2;
        }

        @Override // rx.f
        public final void onError(Throwable th) {
            this.f54398a.call(th);
        }

        @Override // rx.f
        public final void onNext(T t5) {
            this.f54399b.call(t5);
        }

        @Override // rx.f
        public final void onCompleted() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d<T> implements rx.f<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f54400a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54401b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54402c;

        d(rx.functions.a aVar, rx.functions.b bVar, rx.functions.b bVar2) {
            this.f54400a = aVar;
            this.f54401b = bVar;
            this.f54402c = bVar2;
        }

        @Override // rx.f
        public final void onCompleted() {
            this.f54400a.call();
        }

        @Override // rx.f
        public final void onError(Throwable th) {
            this.f54401b.call(th);
        }

        @Override // rx.f
        public final void onNext(T t5) {
            this.f54402c.call(t5);
        }
    }

    public static <T> rx.f<T> a(rx.functions.b<? super T> bVar) {
        if (bVar != null) {
            return new b(bVar);
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static <T> rx.f<T> b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 != null) {
            return new C1074c(bVar2, bVar);
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public static <T> rx.f<T> c(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        if (aVar != null) {
            return new d(aVar, bVar2, bVar);
        }
        throw new IllegalArgumentException("onComplete can not be null");
    }

    public static <T> rx.f<T> d() {
        return (rx.f<T>) f54396a;
    }

    private c() {
        throw new IllegalStateException("No instances!");
    }
}
