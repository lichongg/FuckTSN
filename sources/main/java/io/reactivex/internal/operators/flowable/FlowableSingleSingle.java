package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableSingleSingle<T> extends Single<T> implements FuseToFlowable<T> {
    final T defaultValue;
    final Publisher<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SingleElementSubscriber<T> implements Subscriber<T>, Disposable {
        final SingleObserver<? super T> actual;
        final T defaultValue;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43211s;
        T value;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43211s.cancel();
            this.f43211s = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43211s == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.f43211s = SubscriptionHelper.CANCELLED;
            T t5 = this.value;
            this.value = null;
            if (t5 == null) {
                t5 = this.defaultValue;
            }
            if (t5 != null) {
                this.actual.onSuccess(t5);
            } else {
                this.actual.onError(new NoSuchElementException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.f43211s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            if (this.value == null) {
                this.value = t5;
                return;
            }
            this.done = true;
            this.f43211s.cancel();
            this.f43211s = SubscriptionHelper.CANCELLED;
            this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43211s, subscription)) {
                this.f43211s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        SingleElementSubscriber(SingleObserver<? super T> singleObserver, T t5) {
            this.actual = singleObserver;
            this.defaultValue = t5;
        }
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSingle(this.source, this.defaultValue));
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new SingleElementSubscriber(singleObserver, this.defaultValue));
    }

    public FlowableSingleSingle(Publisher<T> publisher, T t5) {
        this.source = publisher;
        this.defaultValue = t5;
    }
}
