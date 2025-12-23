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
final class a<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final e.a<c0<T>> f52022a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: retrofit2.adapter.rxjava.a$a, reason: collision with other inner class name */
    private static class C1008a<R> extends l<c0<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final l<? super R> f52023a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f52024b;

        @Override // rx.f
        public void onCompleted() {
            if (this.f52024b) {
                return;
            }
            this.f52023a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!this.f52024b) {
                this.f52023a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a Retrofit bug with the full stacktrace.");
            assertionError.initCause(th);
            rx.plugins.f.c().b().a(assertionError);
        }

        @Override // rx.f
        public void onNext(c0<R> c0Var) {
            if (c0Var.g()) {
                this.f52023a.onNext(c0Var.a());
                return;
            }
            this.f52024b = true;
            HttpException httpException = new HttpException(c0Var);
            try {
                this.f52023a.onError(httpException);
            } catch (OnCompletedFailedException e6) {
                e = e6;
                rx.plugins.f.c().b().a(e);
            } catch (OnErrorFailedException e7) {
                e = e7;
                rx.plugins.f.c().b().a(e);
            } catch (OnErrorNotImplementedException e8) {
                e = e8;
                rx.plugins.f.c().b().a(e);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                rx.plugins.f.c().b().a(new CompositeException(httpException, th));
            }
        }

        C1008a(l<? super R> lVar) {
            super(lVar);
            this.f52023a = lVar;
        }
    }

    @Override // rx.functions.b
    public void call(l<? super T> lVar) {
        this.f52022a.call(new C1008a(lVar));
    }

    a(e.a<c0<T>> aVar) {
        this.f52022a = aVar;
    }
}
