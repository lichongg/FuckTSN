package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y2<T, U> implements e.b<T, T> {

    /* renamed from: b, reason: collision with root package name */
    static final Object f53854b = new Object();

    /* renamed from: a, reason: collision with root package name */
    final rx.e<U> f53855a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<U> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f53856a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.observers.g f53857b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicReference f53858c;

        @Override // rx.f
        public void onCompleted() {
            onNext(null);
            this.f53857b.onCompleted();
            ((rx.m) this.f53858c.get()).unsubscribe();
        }

        a(AtomicReference atomicReference, rx.observers.g gVar, AtomicReference atomicReference2) {
            this.f53856a = atomicReference;
            this.f53857b = gVar;
            this.f53858c = atomicReference2;
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53857b.onError(th);
            ((rx.m) this.f53858c.get()).unsubscribe();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.f
        public void onNext(U u5) {
            AtomicReference atomicReference = this.f53856a;
            Object obj = y2.f53854b;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                this.f53857b.onNext(andSet);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f53860a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.observers.g f53861b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.l f53862c;

        b(AtomicReference atomicReference, rx.observers.g gVar, rx.l lVar) {
            this.f53860a = atomicReference;
            this.f53861b = gVar;
            this.f53862c = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53862c.onNext(null);
            this.f53861b.onCompleted();
            this.f53862c.unsubscribe();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53861b.onError(th);
            this.f53862c.unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53860a.set(t5);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar);
        AtomicReference atomicReference = new AtomicReference(f53854b);
        AtomicReference atomicReference2 = new AtomicReference();
        a aVar = new a(atomicReference, gVar, atomicReference2);
        b bVar = new b(atomicReference, gVar, aVar);
        atomicReference2.lazySet(bVar);
        lVar.add(bVar);
        lVar.add(aVar);
        this.f53855a.J6(aVar);
        return bVar;
    }

    public y2(rx.e<U> eVar) {
        this.f53855a = eVar;
    }
}
