package rx.internal.operators;

import rx.e;
import rx.internal.producers.SingleDelayedProducer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n1<T> implements e.b<Boolean, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.p<? super T, Boolean> f53208a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        boolean f53209a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SingleDelayedProducer f53210b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.l f53211c;

        a(SingleDelayedProducer singleDelayedProducer, rx.l lVar) {
            this.f53210b = singleDelayedProducer;
            this.f53211c = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53209a) {
                return;
            }
            this.f53209a = true;
            this.f53210b.setValue(Boolean.TRUE);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53209a) {
                rx.plugins.c.I(th);
            } else {
                this.f53209a = true;
                this.f53211c.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53209a) {
                return;
            }
            try {
                if (n1.this.f53208a.call(t5).booleanValue()) {
                    return;
                }
                this.f53209a = true;
                this.f53210b.setValue(Boolean.FALSE);
                unsubscribe();
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this, t5);
            }
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super Boolean> lVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(lVar);
        a aVar = new a(singleDelayedProducer, lVar);
        lVar.add(aVar);
        lVar.setProducer(singleDelayedProducer);
        return aVar;
    }

    public n1(rx.functions.p<? super T, Boolean> pVar) {
        this.f53208a = pVar;
    }
}
