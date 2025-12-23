package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h3<T, U> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<U> f52893a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<U> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f52894a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.observers.g f52895b;

        a(AtomicBoolean atomicBoolean, rx.observers.g gVar) {
            this.f52894a = atomicBoolean;
            this.f52895b = gVar;
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52895b.onError(th);
            this.f52895b.unsubscribe();
        }

        @Override // rx.f
        public void onNext(U u5) {
            this.f52894a.set(true);
            unsubscribe();
        }

        @Override // rx.f
        public void onCompleted() {
            unsubscribe();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f52897a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.observers.g f52898b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.l lVar, AtomicBoolean atomicBoolean, rx.observers.g gVar) {
            super(lVar);
            this.f52897a = atomicBoolean;
            this.f52898b = gVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52898b.onCompleted();
            unsubscribe();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52898b.onError(th);
            unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f52897a.get()) {
                this.f52898b.onNext(t5);
            } else {
                request(1L);
            }
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        a aVar = new a(atomicBoolean, gVar);
        lVar.add(aVar);
        this.f52893a.J6(aVar);
        return new b(lVar, atomicBoolean, gVar);
    }

    public h3(rx.e<U> eVar) {
        this.f52893a = eVar;
    }
}
