package io.reactivex.internal.operators.flowable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableLastSingle<T> extends Single<T> {
    final T defaultItem;
    final Publisher<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class LastSubscriber<T> implements Subscriber<T>, Disposable {
        final SingleObserver<? super T> actual;
        final T defaultItem;
        T item;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43190s;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43190s.cancel();
            this.f43190s = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43190s == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f43190s = SubscriptionHelper.CANCELLED;
            T t5 = this.item;
            if (t5 != null) {
                this.item = null;
                this.actual.onSuccess(t5);
                return;
            }
            T t6 = this.defaultItem;
            if (t6 != null) {
                this.actual.onSuccess(t6);
            } else {
                this.actual.onError(new NoSuchElementException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f43190s = SubscriptionHelper.CANCELLED;
            this.item = null;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.item = t5;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43190s, subscription)) {
                this.f43190s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        LastSubscriber(SingleObserver<? super T> singleObserver, T t5) {
            this.actual = singleObserver;
            this.defaultItem = t5;
        }
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new LastSubscriber(singleObserver, this.defaultItem));
    }

    public FlowableLastSingle(Publisher<T> publisher, T t5) {
        this.source = publisher;
        this.defaultItem = t5;
    }
}
