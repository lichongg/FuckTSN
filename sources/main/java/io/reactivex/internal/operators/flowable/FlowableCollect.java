package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableCollect<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final BiConsumer<? super U, ? super T> collector;
    final Callable<? extends U> initialSupplier;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements Subscriber<T> {
        private static final long serialVersionUID = -3589550218733891694L;
        final BiConsumer<? super U, ? super T> collector;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43156s;

        /* renamed from: u, reason: collision with root package name */
        final U f43157u;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            complete(this.f43157u);
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
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            try {
                this.collector.accept(this.f43157u, t5);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f43156s.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43156s, subscription)) {
                this.f43156s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        CollectSubscriber(Subscriber<? super U> subscriber, U u5, BiConsumer<? super U, ? super T> biConsumer) {
            super(subscriber);
            this.collector = biConsumer;
            this.f43157u = u5;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f43156s.cancel();
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        try {
            this.source.subscribe(new CollectSubscriber(subscriber, ObjectHelper.requireNonNull(this.initialSupplier.call(), "The initial value supplied is null"), this.collector));
        } catch (Throwable th) {
            EmptySubscription.error(th, subscriber);
        }
    }

    public FlowableCollect(Publisher<T> publisher, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        super(publisher);
        this.initialSupplier = callable;
        this.collector = biConsumer;
    }
}
