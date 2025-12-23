package rx.observers;

import rx.exceptions.OnErrorNotImplementedException;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class h {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<T> extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.f f54415a;

        a(rx.f fVar) {
            this.f54415a = fVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f54415a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f54415a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f54415a.onNext(t5);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b<T> extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54416a;

        b(rx.functions.b bVar) {
            this.f54416a = bVar;
        }

        @Override // rx.f
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // rx.f
        public final void onNext(T t5) {
            this.f54416a.call(t5);
        }

        @Override // rx.f
        public final void onCompleted() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c<T> extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54417a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54418b;

        c(rx.functions.b bVar, rx.functions.b bVar2) {
            this.f54417a = bVar;
            this.f54418b = bVar2;
        }

        @Override // rx.f
        public final void onError(Throwable th) {
            this.f54417a.call(th);
        }

        @Override // rx.f
        public final void onNext(T t5) {
            this.f54418b.call(t5);
        }

        @Override // rx.f
        public final void onCompleted() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d<T> extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f54419a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54420b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54421c;

        d(rx.functions.a aVar, rx.functions.b bVar, rx.functions.b bVar2) {
            this.f54419a = aVar;
            this.f54420b = bVar;
            this.f54421c = bVar2;
        }

        @Override // rx.f
        public final void onCompleted() {
            this.f54419a.call();
        }

        @Override // rx.f
        public final void onError(Throwable th) {
            this.f54420b.call(th);
        }

        @Override // rx.f
        public final void onNext(T t5) {
            this.f54421c.call(t5);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e<T> extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f54422a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(l lVar, l lVar2) {
            super(lVar);
            this.f54422a = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f54422a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f54422a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f54422a.onNext(t5);
        }
    }

    public static <T> l<T> a(rx.functions.b<? super T> bVar) {
        if (bVar != null) {
            return new b(bVar);
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static <T> l<T> b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 != null) {
            return new c(bVar2, bVar);
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public static <T> l<T> c(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
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

    public static <T> l<T> e(rx.f<? super T> fVar) {
        return new a(fVar);
    }

    public static <T> l<T> f(l<? super T> lVar) {
        return new e(lVar, lVar);
    }

    private h() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> l<T> d() {
        return e(rx.observers.c.d());
    }
}
