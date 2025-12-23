package retrofit2.adapter.rxjava;

import java.util.concurrent.atomic.AtomicInteger;
import retrofit2.c0;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.l;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class b<T> extends AtomicInteger implements m, rx.g {

    /* renamed from: e, reason: collision with root package name */
    private static final int f52025e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static final int f52026f = 1;

    /* renamed from: g, reason: collision with root package name */
    private static final int f52027g = 2;

    /* renamed from: h, reason: collision with root package name */
    private static final int f52028h = 3;

    /* renamed from: a, reason: collision with root package name */
    private final retrofit2.b<T> f52029a;

    /* renamed from: b, reason: collision with root package name */
    private final l<? super c0<T>> f52030b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f52031c;

    /* renamed from: d, reason: collision with root package name */
    private volatile c0<T> f52032d;

    b(retrofit2.b<T> bVar, l<? super c0<T>> lVar) {
        super(0);
        this.f52029a = bVar;
        this.f52030b = lVar;
    }

    void b(Throwable th) {
        set(3);
        if (isUnsubscribed()) {
            return;
        }
        try {
            this.f52030b.onError(th);
        } catch (OnCompletedFailedException e6) {
            e = e6;
            rx.plugins.f.c().b().a(e);
        } catch (OnErrorFailedException e7) {
            e = e7;
            rx.plugins.f.c().b().a(e);
        } catch (OnErrorNotImplementedException e8) {
            e = e8;
            rx.plugins.f.c().b().a(e);
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            rx.plugins.f.c().b().a(new CompositeException(th, th2));
        }
    }

    @Override // rx.m
    public void unsubscribe() {
        this.f52031c = true;
        this.f52029a.cancel();
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f52031c;
    }

    @Override // rx.g
    public void request(long j6) {
        if (j6 == 0) {
            return;
        }
        while (true) {
            int i6 = get();
            if (i6 != 0) {
                if (i6 == 1) {
                    return;
                }
                if (i6 != 2) {
                    if (i6 == 3) {
                        return;
                    }
                    throw new IllegalStateException("Unknown state: " + i6);
                }
                if (compareAndSet(2, 3)) {
                    a(this.f52032d);
                    return;
                }
            } else if (compareAndSet(0, 1)) {
                return;
            }
        }
    }

    private void a(c0<T> c0Var) {
        try {
            if (!isUnsubscribed()) {
                this.f52030b.onNext(c0Var);
            }
            try {
                if (!isUnsubscribed()) {
                    this.f52030b.onCompleted();
                }
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
                rx.plugins.f.c().b().a(th);
            }
        } catch (OnCompletedFailedException e9) {
            e = e9;
            rx.plugins.f.c().b().a(e);
        } catch (OnErrorFailedException e10) {
            e = e10;
            rx.plugins.f.c().b().a(e);
        } catch (OnErrorNotImplementedException e11) {
            e = e11;
            rx.plugins.f.c().b().a(e);
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            try {
                this.f52030b.onError(th2);
            } catch (OnCompletedFailedException e12) {
                e = e12;
                rx.plugins.f.c().b().a(e);
            } catch (OnErrorFailedException e13) {
                e = e13;
                rx.plugins.f.c().b().a(e);
            } catch (OnErrorNotImplementedException e14) {
                e = e14;
                rx.plugins.f.c().b().a(e);
            } catch (Throwable th3) {
                rx.exceptions.a.e(th3);
                rx.plugins.f.c().b().a(new CompositeException(th2, th3));
            }
        }
    }

    void d(c0<T> c0Var) {
        while (true) {
            int i6 = get();
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 != 2 && i6 != 3) {
                        throw new IllegalStateException("Unknown state: " + i6);
                    }
                    throw new AssertionError();
                }
                if (compareAndSet(1, 3)) {
                    a(c0Var);
                    return;
                }
            } else {
                this.f52032d = c0Var;
                if (compareAndSet(0, 2)) {
                    return;
                }
            }
        }
    }
}
