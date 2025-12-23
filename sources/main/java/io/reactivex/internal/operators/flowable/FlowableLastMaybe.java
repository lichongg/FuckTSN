package io.reactivex.internal.operators.flowable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableLastMaybe<T> extends Maybe<T> {
    final Publisher<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class LastSubscriber<T> implements Subscriber<T>, Disposable {
        final MaybeObserver<? super T> actual;
        T item;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43189s;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43189s.cancel();
            this.f43189s = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43189s == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f43189s = SubscriptionHelper.CANCELLED;
            T t5 = this.item;
            if (t5 == null) {
                this.actual.onComplete();
            } else {
                this.item = null;
                this.actual.onSuccess(t5);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f43189s = SubscriptionHelper.CANCELLED;
            this.item = null;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.item = t5;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43189s, subscription)) {
                this.f43189s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        LastSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.actual = maybeObserver;
        }
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new LastSubscriber(maybeObserver));
    }

    public FlowableLastMaybe(Publisher<T> publisher) {
        this.source = publisher;
    }
}
