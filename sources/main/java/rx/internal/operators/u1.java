package rx.internal.operators;

import rx.e;
import rx.exceptions.OnErrorThrowable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class u1<T, R> implements e.b<R, T> {

    /* renamed from: a, reason: collision with root package name */
    final Class<R> f53571a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, R> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super R> f53572a;

        /* renamed from: b, reason: collision with root package name */
        final Class<R> f53573b;

        /* renamed from: c, reason: collision with root package name */
        boolean f53574c;

        @Override // rx.f
        public void onCompleted() {
            if (this.f53574c) {
                return;
            }
            this.f53572a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53574c) {
                rx.plugins.c.I(th);
            } else {
                this.f53574c = true;
                this.f53572a.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            try {
                this.f53572a.onNext(this.f53573b.cast(t5));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t5));
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f53572a.setProducer(gVar);
        }

        public a(rx.l<? super R> lVar, Class<R> cls) {
            this.f53572a = lVar;
            this.f53573b = cls;
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super R> lVar) {
        a aVar = new a(lVar, this.f53571a);
        lVar.add(aVar);
        return aVar;
    }

    public u1(Class<R> cls) {
        this.f53571a = cls;
    }
}
