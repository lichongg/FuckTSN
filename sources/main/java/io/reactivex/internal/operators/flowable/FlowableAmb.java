package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableAmb<T> extends Flowable<T> {
    final Publisher<? extends T>[] sources;
    final Iterable<? extends Publisher<? extends T>> sourcesIterable;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class AmbCoordinator<T> implements Subscription {
        final Subscriber<? super T> actual;
        final AmbInnerSubscriber<T>[] subscribers;
        final AtomicInteger winner = new AtomicInteger();

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.winner.get() != -1) {
                this.winner.lazySet(-1);
                for (AmbInnerSubscriber<T> ambInnerSubscriber : this.subscribers) {
                    ambInnerSubscriber.cancel();
                }
            }
        }

        public void subscribe(Publisher<? extends T>[] publisherArr) {
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.subscribers;
            int length = ambInnerSubscriberArr.length;
            int i6 = 0;
            while (i6 < length) {
                int i7 = i6 + 1;
                ambInnerSubscriberArr[i6] = new AmbInnerSubscriber<>(this, i7, this.actual);
                i6 = i7;
            }
            this.winner.lazySet(0);
            this.actual.onSubscribe(this);
            for (int i8 = 0; i8 < length && this.winner.get() == 0; i8++) {
                publisherArr[i8].subscribe(ambInnerSubscriberArr[i8]);
            }
        }

        public boolean win(int i6) {
            int i7 = 0;
            if (this.winner.get() != 0 || !this.winner.compareAndSet(0, i6)) {
                return false;
            }
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.subscribers;
            int length = ambInnerSubscriberArr.length;
            while (i7 < length) {
                int i8 = i7 + 1;
                if (i8 != i6) {
                    ambInnerSubscriberArr[i7].cancel();
                }
                i7 = i8;
            }
            return true;
        }

        AmbCoordinator(Subscriber<? super T> subscriber, int i6) {
            this.actual = subscriber;
            this.subscribers = new AmbInnerSubscriber[i6];
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                int i6 = this.winner.get();
                if (i6 > 0) {
                    this.subscribers[i6 - 1].request(j6);
                    return;
                }
                if (i6 == 0) {
                    for (AmbInnerSubscriber<T> ambInnerSubscriber : this.subscribers) {
                        ambInnerSubscriber.request(j6);
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class AmbInnerSubscriber<T> extends AtomicReference<Subscription> implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -1185974347409665484L;
        final Subscriber<? super T> actual;
        final int index;
        final AtomicLong missedRequested = new AtomicLong();
        final AmbCoordinator<T> parent;
        boolean won;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else if (!this.parent.win(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.actual.onError(th);
            } else {
                get().cancel();
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.won) {
                this.actual.onNext(t5);
            } else if (!this.parent.win(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.actual.onNext(t5);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.missedRequested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            SubscriptionHelper.deferredRequest(this, this.missedRequested, j6);
        }

        AmbInnerSubscriber(AmbCoordinator<T> ambCoordinator, int i6, Subscriber<? super T> subscriber) {
            this.parent = ambCoordinator;
            this.index = i6;
            this.actual = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.sources;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                length = 0;
                for (Publisher<? extends T> publisher : this.sourcesIterable) {
                    if (publisher == null) {
                        EmptySubscription.error(new NullPointerException("One of the sources is null"), subscriber);
                        return;
                    }
                    if (length == publisherArr.length) {
                        Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                        publisherArr = publisherArr2;
                    }
                    int i6 = length + 1;
                    publisherArr[length] = publisher;
                    length = i6;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        if (length == 0) {
            EmptySubscription.complete(subscriber);
        } else if (length == 1) {
            publisherArr[0].subscribe(subscriber);
        } else {
            new AmbCoordinator(subscriber, length).subscribe(publisherArr);
        }
    }

    public FlowableAmb(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable) {
        this.sources = publisherArr;
        this.sourcesIterable = iterable;
    }
}
