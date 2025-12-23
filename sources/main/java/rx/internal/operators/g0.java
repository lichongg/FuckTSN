package rx.internal.operators;

import java.util.Arrays;
import rx.e;
import rx.exceptions.CompositeException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class g0<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final rx.f<? super T> f52807a;

    /* renamed from: b, reason: collision with root package name */
    private final rx.e<T> f52808b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private final rx.l<? super T> f52809a;

        /* renamed from: b, reason: collision with root package name */
        private final rx.f<? super T> f52810b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f52811c;

        @Override // rx.f
        public void onCompleted() {
            if (this.f52811c) {
                return;
            }
            try {
                this.f52810b.onCompleted();
                this.f52811c = true;
                this.f52809a.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f52811c) {
                rx.plugins.c.I(th);
                return;
            }
            this.f52811c = true;
            try {
                this.f52810b.onError(th);
                this.f52809a.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                this.f52809a.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f52811c) {
                return;
            }
            try {
                this.f52810b.onNext(t5);
                this.f52809a.onNext(t5);
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this, t5);
            }
        }

        a(rx.l<? super T> lVar, rx.f<? super T> fVar) {
            super(lVar);
            this.f52809a = lVar;
            this.f52810b = fVar;
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        this.f52808b.J6(new a(lVar, this.f52807a));
    }

    public g0(rx.e<T> eVar, rx.f<? super T> fVar) {
        this.f52808b = eVar;
        this.f52807a = fVar;
    }
}
