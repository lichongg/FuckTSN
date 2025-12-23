package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableDistinctUntilChanged<T, K> extends AbstractFlowableWithUpstream<T, T> {
    final BiPredicate<? super K, ? super K> comparer;
    final Function<? super T, K> keySelector;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DistinctUntilChangedConditionalSubscriber<T, K> extends BasicFuseableConditionalSubscriber<T, T> {
        final BiPredicate<? super K, ? super K> comparer;
        boolean hasValue;
        final Function<? super T, K> keySelector;
        K last;

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            while (true) {
                T poll = this.qs.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.keySelector.apply(poll);
                if (!this.hasValue) {
                    this.hasValue = true;
                    this.last = apply;
                    return poll;
                }
                if (!this.comparer.test(this.last, apply)) {
                    this.last = apply;
                    return poll;
                }
                this.last = apply;
                if (this.sourceMode != 1) {
                    this.f43400s.request(1L);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t5) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                return this.actual.tryOnNext(t5);
            }
            try {
                K apply = this.keySelector.apply(t5);
                if (this.hasValue) {
                    boolean test = this.comparer.test(this.last, apply);
                    this.last = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.hasValue = true;
                    this.last = apply;
                }
                this.actual.onNext(t5);
                return true;
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }

        DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(conditionalSubscriber);
            this.keySelector = function;
            this.comparer = biPredicate;
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
    static final class DistinctUntilChangedSubscriber<T, K> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        final BiPredicate<? super K, ? super K> comparer;
        boolean hasValue;
        final Function<? super T, K> keySelector;
        K last;

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            while (true) {
                T poll = this.qs.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.keySelector.apply(poll);
                if (!this.hasValue) {
                    this.hasValue = true;
                    this.last = apply;
                    return poll;
                }
                if (!this.comparer.test(this.last, apply)) {
                    this.last = apply;
                    return poll;
                }
                this.last = apply;
                if (this.sourceMode != 1) {
                    this.f43401s.request(1L);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t5) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                this.actual.onNext(t5);
                return true;
            }
            try {
                K apply = this.keySelector.apply(t5);
                if (this.hasValue) {
                    boolean test = this.comparer.test(this.last, apply);
                    this.last = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.hasValue = true;
                    this.last = apply;
                }
                this.actual.onNext(t5);
                return true;
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }

        DistinctUntilChangedSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(subscriber);
            this.keySelector = function;
            this.comparer = biPredicate;
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
            this.source.subscribe(new DistinctUntilChangedConditionalSubscriber((ConditionalSubscriber) subscriber, this.keySelector, this.comparer));
        } else {
            this.source.subscribe(new DistinctUntilChangedSubscriber(subscriber, this.keySelector, this.comparer));
        }
    }

    public FlowableDistinctUntilChanged(Publisher<T> publisher, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(publisher);
        this.keySelector = function;
        this.comparer = biPredicate;
    }
}
