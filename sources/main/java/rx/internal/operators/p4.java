package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.e;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final e.a<T> f53359a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> {

        /* renamed from: d, reason: collision with root package name */
        static final int f53360d = 0;

        /* renamed from: e, reason: collision with root package name */
        static final int f53361e = 1;

        /* renamed from: f, reason: collision with root package name */
        static final int f53362f = 2;

        /* renamed from: a, reason: collision with root package name */
        final rx.k<? super T> f53363a;

        /* renamed from: b, reason: collision with root package name */
        T f53364b;

        /* renamed from: c, reason: collision with root package name */
        int f53365c;

        @Override // rx.f
        public void onCompleted() {
            int i6 = this.f53365c;
            if (i6 == 0) {
                this.f53363a.onError(new NoSuchElementException());
            } else if (i6 == 1) {
                this.f53365c = 2;
                T t5 = this.f53364b;
                this.f53364b = null;
                this.f53363a.d(t5);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53365c == 2) {
                rx.plugins.c.I(th);
            } else {
                this.f53364b = null;
                this.f53363a.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            int i6 = this.f53365c;
            if (i6 == 0) {
                this.f53365c = 1;
                this.f53364b = t5;
            } else if (i6 == 1) {
                this.f53365c = 2;
                this.f53363a.onError(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }

        a(rx.k<? super T> kVar) {
            this.f53363a = kVar;
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.b(aVar);
        this.f53359a.call(aVar);
    }

    public p4(e.a<T> aVar) {
        this.f53359a = aVar;
    }
}
