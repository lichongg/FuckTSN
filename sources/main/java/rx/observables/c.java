package rx.observables;

import rx.e;
import rx.internal.operators.OnSubscribeAutoConnect;
import rx.internal.operators.z0;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class c<T> extends rx.e<T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.b<m> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m[] f54377a;

        a(m[] mVarArr) {
            this.f54377a = mVarArr;
        }

        @Override // rx.functions.b
        public void call(m mVar) {
            this.f54377a[0] = mVar;
        }
    }

    public abstract void A7(rx.functions.b<? super m> bVar);

    public rx.e<T> w7() {
        return x7(1);
    }

    public final m z7() {
        m[] mVarArr = new m[1];
        A7(new a(mVarArr));
        return mVarArr[0];
    }

    public rx.e<T> B7() {
        return rx.e.I6(new z0(this));
    }

    public rx.e<T> y7(int i6, rx.functions.b<? super m> bVar) {
        if (i6 > 0) {
            return rx.e.I6(new OnSubscribeAutoConnect(this, i6, bVar));
        }
        A7(bVar);
        return this;
    }

    protected c(e.a<T> aVar) {
        super(aVar);
    }

    public rx.e<T> x7(int i6) {
        return y7(i6, rx.functions.m.a());
    }
}
