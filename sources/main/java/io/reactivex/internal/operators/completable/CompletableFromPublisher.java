package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CompletableFromPublisher<T> extends Completable {
    final Publisher<T> flowable;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class FromPublisherSubscriber<T> implements Subscriber<T>, Disposable {
        final CompletableObserver cs;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43138s;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43138s.cancel();
            this.f43138s = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43138s == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.cs.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.cs.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43138s, subscription)) {
                this.f43138s = subscription;
                this.cs.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        FromPublisherSubscriber(CompletableObserver completableObserver) {
            this.cs = completableObserver;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
        }
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.flowable.subscribe(new FromPublisherSubscriber(completableObserver));
    }

    public CompletableFromPublisher(Publisher<T> publisher) {
        this.flowable = publisher;
    }
}
