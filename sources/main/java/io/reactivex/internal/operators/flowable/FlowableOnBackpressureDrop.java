package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableOnBackpressureDrop<T> extends AbstractFlowableWithUpstream<T, T> implements Consumer<T> {
    final Consumer<? super T> onDrop;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BackpressureDropSubscriber<T> extends AtomicLong implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -6246093802440953054L;
        final Subscriber<? super T> actual;
        boolean done;
        final Consumer<? super T> onDrop;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43194s;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43194s.cancel();
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
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            if (get() != 0) {
                this.actual.onNext(t5);
                BackpressureHelper.produced(this, 1L);
                return;
            }
            try {
                this.onDrop.accept(t5);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43194s, subscription)) {
                this.f43194s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        BackpressureDropSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            this.actual = subscriber;
            this.onDrop = consumer;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this, j6);
            }
        }
    }

    public FlowableOnBackpressureDrop(Publisher<T> publisher) {
        super(publisher);
        this.onDrop = this;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new BackpressureDropSubscriber(subscriber, this.onDrop));
    }

    public FlowableOnBackpressureDrop(Publisher<T> publisher, Consumer<? super T> consumer) {
        super(publisher);
        this.onDrop = consumer;
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(T t5) {
    }
}
