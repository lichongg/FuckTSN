package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableFilter<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class FilterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Predicate<? super T> filter;

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            QueueSubscription<T> queueSubscription = this.qs;
            Predicate<? super T> predicate = this.filter;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.sourceMode == 2) {
                    queueSubscription.request(1L);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t5) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                return this.actual.tryOnNext(null);
            }
            try {
                return this.filter.test(t5) && this.actual.tryOnNext(t5);
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }

        FilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(conditionalSubscriber);
            this.filter = predicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (!tryOnNext(t5)) {
                this.f43400s.request(1L);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            return transitiveBoundaryFusion(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class FilterSubscriber<T> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        final Predicate<? super T> filter;

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            QueueSubscription<T> queueSubscription = this.qs;
            Predicate<? super T> predicate = this.filter;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.sourceMode == 2) {
                    queueSubscription.request(1L);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t5) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                this.actual.onNext(null);
                return true;
            }
            try {
                boolean test = this.filter.test(t5);
                if (test) {
                    this.actual.onNext(t5);
                }
                return test;
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }

        FilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.filter = predicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (!tryOnNext(t5)) {
                this.f43401s.request(1L);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            return transitiveBoundaryFusion(i6);
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new FilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.predicate));
        } else {
            this.source.subscribe(new FilterSubscriber(subscriber, this.predicate));
        }
    }

    public FlowableFilter(Publisher<T> publisher, Predicate<? super T> predicate) {
        super(publisher);
        this.predicate = predicate;
    }
}
