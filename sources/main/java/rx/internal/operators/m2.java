package rx.internal.operators;

import rx.e;
import rx.exceptions.OnErrorThrowable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m2<T, U, R> implements e.b<rx.e<? extends R>, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.e<? extends U>> f53175a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.q<? super T, ? super U, ? extends R> f53176b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements rx.functions.p<T, rx.e<U>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.p f53177a;

        @Override // rx.functions.p
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((a) obj);
        }

        a(rx.functions.p pVar) {
            this.f53177a = pVar;
        }

        @Override // rx.functions.p
        public rx.e<U> call(T t5) {
            return rx.e.u2((Iterable) this.f53177a.call(t5));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T, U, R> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super rx.e<? extends R>> f53178a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends rx.e<? extends U>> f53179b;

        /* renamed from: c, reason: collision with root package name */
        final rx.functions.q<? super T, ? super U, ? extends R> f53180c;

        /* renamed from: d, reason: collision with root package name */
        boolean f53181d;

        @Override // rx.f
        public void onCompleted() {
            if (this.f53181d) {
                return;
            }
            this.f53178a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53181d) {
                rx.plugins.c.I(th);
            } else {
                this.f53181d = true;
                this.f53178a.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            try {
                this.f53178a.onNext(this.f53179b.call(t5).c3(new c(t5, this.f53180c)));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t5));
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f53178a.setProducer(gVar);
        }

        public b(rx.l<? super rx.e<? extends R>> lVar, rx.functions.p<? super T, ? extends rx.e<? extends U>> pVar, rx.functions.q<? super T, ? super U, ? extends R> qVar) {
            this.f53178a = lVar;
            this.f53179b = pVar;
            this.f53180c = qVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T, U, R> implements rx.functions.p<U, R> {

        /* renamed from: a, reason: collision with root package name */
        final T f53182a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.q<? super T, ? super U, ? extends R> f53183b;

        @Override // rx.functions.p
        public R call(U u5) {
            return this.f53183b.call(this.f53182a, u5);
        }

        public c(T t5, rx.functions.q<? super T, ? super U, ? extends R> qVar) {
            this.f53182a = t5;
            this.f53183b = qVar;
        }
    }

    public static <T, U> rx.functions.p<T, rx.e<U>> a(rx.functions.p<? super T, ? extends Iterable<? extends U>> pVar) {
        return new a(pVar);
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super rx.e<? extends R>> lVar) {
        b bVar = new b(lVar, this.f53175a, this.f53176b);
        lVar.add(bVar);
        return bVar;
    }

    public m2(rx.functions.p<? super T, ? extends rx.e<? extends U>> pVar, rx.functions.q<? super T, ? super U, ? extends R> qVar) {
        this.f53175a = pVar;
        this.f53176b = qVar;
    }
}
