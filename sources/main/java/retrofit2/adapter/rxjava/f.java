package retrofit2.adapter.rxjava;

import retrofit2.c0;
import rx.e;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class f<T> implements e.a<e<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final e.a<c0<T>> f52039a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a<R> extends l<c0<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final l<? super e<R>> f52040a;

        @Override // rx.f
        public void onCompleted() {
            this.f52040a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.f52040a.onNext(e.b(th));
                this.f52040a.onCompleted();
            } catch (Throwable th2) {
                try {
                    this.f52040a.onError(th2);
                } catch (OnCompletedFailedException e6) {
                    e = e6;
                    rx.plugins.f.c().b().a(e);
                } catch (OnErrorFailedException e7) {
                    e = e7;
                    rx.plugins.f.c().b().a(e);
                } catch (OnErrorNotImplementedException e8) {
                    e = e8;
                    rx.plugins.f.c().b().a(e);
                } catch (Throwable th3) {
                    rx.exceptions.a.e(th3);
                    rx.plugins.f.c().b().a(new CompositeException(th2, th3));
                }
            }
        }

        @Override // rx.f
        public void onNext(c0<R> c0Var) {
            this.f52040a.onNext(e.e(c0Var));
        }

        a(l<? super e<R>> lVar) {
            super(lVar);
            this.f52040a = lVar;
        }
    }

    @Override // rx.functions.b
    public void call(l<? super e<T>> lVar) {
        this.f52039a.call(new a(lVar));
    }

    f(e.a<c0<T>> aVar) {
        this.f52039a = aVar;
    }
}
