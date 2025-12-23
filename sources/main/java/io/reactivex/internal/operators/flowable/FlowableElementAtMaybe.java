package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableElementAtMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {
    final long index;
    final Publisher<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ElementAtSubscriber<T> implements Subscriber<T>, Disposable {
        final MaybeObserver<? super T> actual;
        long count;
        boolean done;
        final long index;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43174s;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43174s.cancel();
            this.f43174s = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43174s == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f43174s = SubscriptionHelper.CANCELLED;
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
                return;
            }
            this.done = true;
            this.f43174s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            long j6 = this.count;
            if (j6 != this.index) {
                this.count = j6 + 1;
                return;
            }
            this.done = true;
            this.f43174s.cancel();
            this.f43174s = SubscriptionHelper.CANCELLED;
            this.actual.onSuccess(t5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43174s, subscription)) {
                this.f43174s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        ElementAtSubscriber(MaybeObserver<? super T> maybeObserver, long j6) {
            this.actual = maybeObserver;
            this.index = j6;
        }
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableElementAt(this.source, this.index, null));
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new ElementAtSubscriber(maybeObserver, this.index));
    }

    public FlowableElementAtMaybe(Publisher<T> publisher, long j6) {
        this.source = publisher;
        this.index = j6;
    }
}
