package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.e;
import rx.exceptions.CompositeException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m1<T, Resource> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final rx.functions.o<Resource> f53169a;

    /* renamed from: b, reason: collision with root package name */
    private final rx.functions.p<? super Resource, ? extends rx.e<? extends T>> f53170b;

    /* renamed from: c, reason: collision with root package name */
    private final rx.functions.b<? super Resource> f53171c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f53172d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<Resource> extends AtomicBoolean implements rx.functions.a, rx.m {
        private static final long serialVersionUID = 4262875056400218316L;

        /* renamed from: a, reason: collision with root package name */
        private rx.functions.b<? super Resource> f53173a;

        /* renamed from: b, reason: collision with root package name */
        private Resource f53174b;

        /* JADX WARN: Type inference failed for: r0v2, types: [Resource, rx.functions.b<? super Resource>] */
        @Override // rx.functions.a
        public void call() {
            if (compareAndSet(false, true)) {
                ?? r02 = (Resource) null;
                try {
                    this.f53173a.call(this.f53174b);
                } finally {
                    this.f53174b = null;
                    this.f53173a = null;
                }
            }
        }

        a(rx.functions.b<? super Resource> bVar, Resource resource) {
            this.f53173a = bVar;
            this.f53174b = resource;
            lazySet(false);
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // rx.m
        public void unsubscribe() {
            call();
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        try {
            Resource call = this.f53169a.call();
            a aVar = new a(this.f53171c, call);
            lVar.add(aVar);
            try {
                rx.e<? extends T> call2 = this.f53170b.call(call);
                try {
                    (this.f53172d ? call2.O1(aVar) : call2.G1(aVar)).J6(rx.observers.h.f(lVar));
                } catch (Throwable th) {
                    Throwable a6 = a(aVar);
                    rx.exceptions.a.e(th);
                    rx.exceptions.a.e(a6);
                    if (a6 != null) {
                        lVar.onError(new CompositeException(th, a6));
                    } else {
                        lVar.onError(th);
                    }
                }
            } catch (Throwable th2) {
                Throwable a7 = a(aVar);
                rx.exceptions.a.e(th2);
                rx.exceptions.a.e(a7);
                if (a7 != null) {
                    lVar.onError(new CompositeException(th2, a7));
                } else {
                    lVar.onError(th2);
                }
            }
        } catch (Throwable th3) {
            rx.exceptions.a.f(th3, lVar);
        }
    }

    public m1(rx.functions.o<Resource> oVar, rx.functions.p<? super Resource, ? extends rx.e<? extends T>> pVar, rx.functions.b<? super Resource> bVar, boolean z5) {
        this.f53169a = oVar;
        this.f53170b = pVar;
        this.f53171c = bVar;
        this.f53172d = z5;
    }

    private Throwable a(rx.functions.a aVar) {
        try {
            aVar.call();
            return null;
        } catch (Throwable th) {
            return th;
        }
    }
}
