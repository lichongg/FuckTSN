package io.reactivex.internal.operators.flowable;

import io.reactivex.Notification;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableDematerialize<T> extends AbstractFlowableWithUpstream<Notification<T>, T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DematerializeSubscriber<T> implements Subscriber<Notification<T>>, Subscription {
        final Subscriber<? super T> actual;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43168s;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43168s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Notification<T> notification) {
            if (this.done) {
                if (notification.isOnError()) {
                    RxJavaPlugins.onError(notification.getError());
                }
            } else if (notification.isOnError()) {
                this.f43168s.cancel();
                onError(notification.getError());
            } else if (!notification.isOnComplete()) {
                this.actual.onNext(notification.getValue());
            } else {
                this.f43168s.cancel();
                onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43168s, subscription)) {
                this.f43168s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43168s.request(j6);
        }

        DematerializeSubscriber(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DematerializeSubscriber(subscriber));
    }

    public FlowableDematerialize(Publisher<Notification<T>> publisher) {
        super(publisher);
    }
}
