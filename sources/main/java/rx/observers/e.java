package rx.observers;

import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class e<T> extends l<T> {

    /* renamed from: a, reason: collision with root package name */
    private final l<? super T> f54406a;

    /* renamed from: b, reason: collision with root package name */
    boolean f54407b;

    public l<? super T> j() {
        return this.f54406a;
    }

    @Override // rx.f
    public void onCompleted() {
        UnsubscribeFailedException unsubscribeFailedException;
        if (this.f54407b) {
            return;
        }
        this.f54407b = true;
        try {
            this.f54406a.onCompleted();
            try {
                unsubscribe();
            } finally {
            }
        } catch (Throwable th) {
            try {
                rx.exceptions.a.e(th);
                rx.plugins.c.I(th);
                throw new OnCompletedFailedException(th.getMessage(), th);
            } catch (Throwable th2) {
                try {
                    unsubscribe();
                    throw th2;
                } finally {
                }
            }
        }
    }

    @Override // rx.f
    public void onNext(T t5) {
        try {
            if (this.f54407b) {
                return;
            }
            this.f54406a.onNext(t5);
        } catch (Throwable th) {
            rx.exceptions.a.f(th, this);
        }
    }

    public e(l<? super T> lVar) {
        super(lVar);
        this.f54406a = lVar;
    }

    protected void g(Throwable th) {
        rx.plugins.f.c().b().a(th);
        try {
            this.f54406a.onError(th);
            try {
                unsubscribe();
            } catch (Throwable th2) {
                rx.plugins.c.I(th2);
                throw new OnErrorFailedException(th2);
            }
        } catch (OnErrorNotImplementedException e6) {
            try {
                unsubscribe();
                throw e6;
            } catch (Throwable th3) {
                rx.plugins.c.I(th3);
                throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th, th3)));
            }
        } catch (Throwable th4) {
            rx.plugins.c.I(th4);
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th, th4)));
            } catch (Throwable th5) {
                rx.plugins.c.I(th5);
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th, th4, th5)));
            }
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        rx.exceptions.a.e(th);
        if (!this.f54407b) {
            this.f54407b = true;
            g(th);
        }
    }
}
