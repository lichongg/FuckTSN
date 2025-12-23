package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableConcatArray<T> extends Flowable<T> {
    final boolean delayError;
    final Publisher<? extends T>[] sources;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements Subscriber<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        final Subscriber<? super T> actual;
        final boolean delayError;
        List<Throwable> errors;
        int index;
        long produced;
        final Publisher<? extends T>[] sources;
        final AtomicInteger wip = new AtomicInteger();

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.wip.getAndIncrement() == 0) {
                Publisher<? extends T>[] publisherArr = this.sources;
                int length = publisherArr.length;
                int i6 = this.index;
                while (i6 != length) {
                    Publisher<? extends T> publisher = publisherArr[i6];
                    if (publisher == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (!this.delayError) {
                            this.actual.onError(nullPointerException);
                            return;
                        }
                        List list = this.errors;
                        if (list == null) {
                            list = new ArrayList((length - i6) + 1);
                            this.errors = list;
                        }
                        list.add(nullPointerException);
                        i6++;
                    } else {
                        long j6 = this.produced;
                        if (j6 != 0) {
                            this.produced = 0L;
                            produced(j6);
                        }
                        publisher.subscribe(this);
                        i6++;
                        this.index = i6;
                        if (this.wip.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list2 = this.errors;
                if (list2 == null) {
                    this.actual.onComplete();
                } else if (list2.size() == 1) {
                    this.actual.onError(list2.get(0));
                } else {
                    this.actual.onError(new CompositeException(list2));
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.delayError) {
                this.actual.onError(th);
                return;
            }
            List list = this.errors;
            if (list == null) {
                list = new ArrayList((this.sources.length - this.index) + 1);
                this.errors = list;
            }
            list.add(th);
            onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.produced++;
            this.actual.onNext(t5);
        }

        ConcatArraySubscriber(Publisher<? extends T>[] publisherArr, boolean z5, Subscriber<? super T> subscriber) {
            this.actual = subscriber;
            this.sources = publisherArr;
            this.delayError = z5;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ConcatArraySubscriber concatArraySubscriber = new ConcatArraySubscriber(this.sources, this.delayError, subscriber);
        subscriber.onSubscribe(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }

    public FlowableConcatArray(Publisher<? extends T>[] publisherArr, boolean z5) {
        this.sources = publisherArr;
        this.delayError = z5;
    }
}
