package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableAllSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final Predicate<? super T> predicate;
    final Publisher<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class AllSubscriber<T> implements Subscriber<T>, Disposable {
        final SingleObserver<? super Boolean> actual;
        boolean done;
        final Predicate<? super T> predicate;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43142s;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43142s.cancel();
            this.f43142s = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43142s == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.f43142s = SubscriptionHelper.CANCELLED;
            this.actual.onSuccess(Boolean.TRUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.f43142s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            try {
                if (this.predicate.test(t5)) {
                    return;
                }
                this.done = true;
                this.f43142s.cancel();
                this.f43142s = SubscriptionHelper.CANCELLED;
                this.actual.onSuccess(Boolean.FALSE);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f43142s.cancel();
                this.f43142s = SubscriptionHelper.CANCELLED;
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43142s, subscription)) {
                this.f43142s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        AllSubscriber(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.actual = singleObserver;
            this.predicate = predicate;
        }
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableAll(this.source, this.predicate));
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe(new AllSubscriber(singleObserver, this.predicate));
    }

    public FlowableAllSingle(Publisher<T> publisher, Predicate<? super T> predicate) {
        this.source = publisher;
        this.predicate = predicate;
    }
}
