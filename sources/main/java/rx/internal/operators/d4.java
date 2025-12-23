package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d4<T, U, R> implements e.b<R, T> {

    /* renamed from: c, reason: collision with root package name */
    static final Object f52712c = new Object();

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.q<? super T, ? super U, ? extends R> f52713a;

    /* renamed from: b, reason: collision with root package name */
    final rx.e<? extends U> f52714b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f52715a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.observers.g f52716b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, boolean z5, AtomicReference atomicReference, rx.observers.g gVar) {
            super(lVar, z5);
            this.f52715a = atomicReference;
            this.f52716b = gVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52716b.onCompleted();
            this.f52716b.unsubscribe();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52716b.onError(th);
            this.f52716b.unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t5) {
            Object obj = this.f52715a.get();
            if (obj != d4.f52712c) {
                try {
                    this.f52716b.onNext(d4.this.f52713a.call(t5, obj));
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, this);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.l<U> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f52718a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.observers.g f52719b;

        b(AtomicReference atomicReference, rx.observers.g gVar) {
            this.f52718a = atomicReference;
            this.f52719b = gVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f52718a.get() == d4.f52712c) {
                this.f52719b.onCompleted();
                this.f52719b.unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52719b.onError(th);
            this.f52719b.unsubscribe();
        }

        @Override // rx.f
        public void onNext(U u5) {
            this.f52718a.set(u5);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super R> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar, false);
        lVar.add(gVar);
        AtomicReference atomicReference = new AtomicReference(f52712c);
        a aVar = new a(gVar, true, atomicReference, gVar);
        b bVar = new b(atomicReference, gVar);
        gVar.add(aVar);
        gVar.add(bVar);
        this.f52714b.J6(bVar);
        return aVar;
    }

    public d4(rx.e<? extends U> eVar, rx.functions.q<? super T, ? super U, ? extends R> qVar) {
        this.f52714b = eVar;
        this.f52713a = qVar;
    }
}
