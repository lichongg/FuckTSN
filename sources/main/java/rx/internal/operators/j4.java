package rx.internal.operators;

import rx.exceptions.CompositeException;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.i<T> f53058a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.b<? super T> f53059b;

    /* renamed from: c, reason: collision with root package name */
    final rx.functions.b<Throwable> f53060c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.k<T> {

        /* renamed from: b, reason: collision with root package name */
        final rx.k<? super T> f53061b;

        /* renamed from: c, reason: collision with root package name */
        final rx.functions.b<? super T> f53062c;

        /* renamed from: d, reason: collision with root package name */
        final rx.functions.b<Throwable> f53063d;

        @Override // rx.k
        public void d(T t5) {
            try {
                this.f53062c.call(t5);
                this.f53061b.d(t5);
            } catch (Throwable th) {
                rx.exceptions.a.i(th, this, t5);
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            try {
                this.f53063d.call(th);
                this.f53061b.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                this.f53061b.onError(new CompositeException(th, th2));
            }
        }

        a(rx.k<? super T> kVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
            this.f53061b = kVar;
            this.f53062c = bVar;
            this.f53063d = bVar2;
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar, this.f53059b, this.f53060c);
        kVar.b(aVar);
        this.f53058a.j0(aVar);
    }

    public j4(rx.i<T> iVar, rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        this.f53058a = iVar;
        this.f53059b = bVar;
        this.f53060c = bVar2;
    }
}
