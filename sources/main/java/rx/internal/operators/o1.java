package rx.internal.operators;

import rx.e;
import rx.internal.producers.SingleDelayedProducer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o1<T> implements e.b<Boolean, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.p<? super T, Boolean> f53269a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f53270b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        boolean f53271a;

        /* renamed from: b, reason: collision with root package name */
        boolean f53272b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ SingleDelayedProducer f53273c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rx.l f53274d;

        a(SingleDelayedProducer singleDelayedProducer, rx.l lVar) {
            this.f53273c = singleDelayedProducer;
            this.f53274d = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53272b) {
                return;
            }
            this.f53272b = true;
            if (this.f53271a) {
                this.f53273c.setValue(Boolean.FALSE);
            } else {
                this.f53273c.setValue(Boolean.valueOf(o1.this.f53270b));
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53272b) {
                rx.plugins.c.I(th);
            } else {
                this.f53272b = true;
                this.f53274d.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53272b) {
                return;
            }
            this.f53271a = true;
            try {
                if (o1.this.f53269a.call(t5).booleanValue()) {
                    this.f53272b = true;
                    this.f53273c.setValue(Boolean.valueOf(true ^ o1.this.f53270b));
                    unsubscribe();
                }
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

    public o1(rx.functions.p<? super T, Boolean> pVar, boolean z5) {
        this.f53269a = pVar;
        this.f53270b = z5;
    }
}
