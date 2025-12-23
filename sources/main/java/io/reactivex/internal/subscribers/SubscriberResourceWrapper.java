package io.reactivex.internal.subscribers;

import androidx.camera.view.p;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements Subscriber<T>, Disposable, Subscription {
    private static final long serialVersionUID = -8612022020200669122L;
    final Subscriber<? super T> actual;
    final AtomicReference<Subscription> subscription = new AtomicReference<>();

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this.subscription);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.subscription.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t5) {
        this.actual.onNext(t5);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        do {
            Subscription subscription2 = this.subscription.get();
            if (subscription2 == SubscriptionHelper.CANCELLED) {
                subscription.cancel();
                return;
            } else if (subscription2 != null) {
                subscription.cancel();
                SubscriptionHelper.reportSubscriptionSet();
                return;
            }
        } while (!p.a(this.subscription, null, subscription));
        this.actual.onSubscribe(this);
    }

    public SubscriberResourceWrapper(Subscriber<? super T> subscriber) {
        this.actual = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        dispose();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        dispose();
        this.actual.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        dispose();
        this.actual.onError(th);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j6) {
        if (SubscriptionHelper.validate(j6)) {
            this.subscription.get().request(j6);
        }
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }
}
