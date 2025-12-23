package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableCollectSingle<T, U> extends Single<U> implements FuseToFlowable<U> {
    final BiConsumer<? super U, ? super T> collector;
    final Callable<? extends U> initialSupplier;
    final Publisher<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class CollectSubscriber<T, U> implements Subscriber<T>, Disposable {
        final SingleObserver<? super U> actual;
        final BiConsumer<? super U, ? super T> collector;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43158s;

        /* renamed from: u, reason: collision with root package name */
        final U f43159u;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43158s.cancel();
            this.f43158s = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43158s == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.f43158s = SubscriptionHelper.CANCELLED;
            this.actual.onSuccess(this.f43159u);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.f43158s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            try {
                this.collector.accept(this.f43159u, t5);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f43158s.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43158s, subscription)) {
                this.f43158s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        CollectSubscriber(SingleObserver<? super U> singleObserver, U u5, BiConsumer<? super U, ? super T> biConsumer) {
            this.actual = singleObserver;
            this.collector = biConsumer;
            this.f43159u = u5;
        }
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<U> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableCollect(this.source, this.initialSupplier, this.collector));
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.source.subscribe(new CollectSubscriber(singleObserver, ObjectHelper.requireNonNull(this.initialSupplier.call(), "The initialSupplier returned a null value"), this.collector));
        } catch (Throwable th) {
            EmptyDisposable.error(th, singleObserver);
        }
    }

    public FlowableCollectSingle(Publisher<T> publisher, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        this.source = publisher;
        this.initialSupplier = callable;
        this.collector = biConsumer;
    }
}
