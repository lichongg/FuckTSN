package rx.internal.operators;

import java.util.Iterator;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g4<T1, T2, R> implements e.b<R, T1> {

    /* renamed from: a, reason: collision with root package name */
    final Iterable<? extends T2> f52854a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.q<? super T1, ? super T2, ? extends R> f52855b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T1> {

        /* renamed from: a, reason: collision with root package name */
        boolean f52856a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.l f52857b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Iterator f52858c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2, Iterator it) {
            super(lVar);
            this.f52857b = lVar2;
            this.f52858c = it;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f52856a) {
                return;
            }
            this.f52856a = true;
            this.f52857b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f52856a) {
                rx.exceptions.a.e(th);
            } else {
                this.f52856a = true;
                this.f52857b.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T1 t12) {
            if (this.f52856a) {
                return;
            }
            try {
                this.f52857b.onNext(g4.this.f52855b.call(t12, (Object) this.f52858c.next()));
                if (this.f52858c.hasNext()) {
                    return;
                }
                onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T1> call(rx.l<? super R> lVar) {
        Iterator<? extends T2> it = this.f52854a.iterator();
        try {
            if (it.hasNext()) {
                return new a(lVar, lVar, it);
            }
            lVar.onCompleted();
            return rx.observers.h.d();
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
            return rx.observers.h.d();
        }
    }

    public g4(Iterable<? extends T2> iterable, rx.functions.q<? super T1, ? super T2, ? extends R> qVar) {
        this.f52854a = iterable;
        this.f52855b = qVar;
    }
}
