package rx.observers;

import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class d implements rx.d, m {

    /* renamed from: a, reason: collision with root package name */
    final rx.d f54403a;

    /* renamed from: b, reason: collision with root package name */
    m f54404b;

    /* renamed from: c, reason: collision with root package name */
    boolean f54405c;

    @Override // rx.d
    public void a(m mVar) {
        this.f54404b = mVar;
        try {
            this.f54403a.a(this);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            mVar.unsubscribe();
            onError(th);
        }
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f54405c || this.f54404b.isUnsubscribed();
    }

    @Override // rx.d
    public void onCompleted() {
        if (this.f54405c) {
            return;
        }
        this.f54405c = true;
        try {
            this.f54403a.onCompleted();
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // rx.d
    public void onError(Throwable th) {
        if (this.f54405c) {
            rx.plugins.c.I(th);
            return;
        }
        this.f54405c = true;
        try {
            this.f54403a.onError(th);
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            throw new OnErrorFailedException(new CompositeException(th, th2));
        }
    }

    @Override // rx.m
    public void unsubscribe() {
        this.f54404b.unsubscribe();
    }

    public d(rx.d dVar) {
        this.f54403a = dVar;
    }
}
