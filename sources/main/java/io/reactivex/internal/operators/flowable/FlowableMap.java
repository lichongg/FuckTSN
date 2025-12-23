package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super T, ? extends U> mapper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {
        final Function<? super T, ? extends U> mapper;

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.actual.onNext(null);
                return;
            }
            try {
                this.actual.onNext(ObjectHelper.requireNonNull(this.mapper.apply(t5), "The mapper function returned a null value."));
            } catch (Throwable th) {
                fail(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public U poll() throws Exception {
            T poll = this.qs.poll();
            if (poll != null) {
                return (U) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t5) {
            if (this.done) {
                return false;
            }
            try {
                return this.actual.tryOnNext(ObjectHelper.requireNonNull(this.mapper.apply(t5), "The mapper function returned a null value."));
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }

        MapConditionalSubscriber(ConditionalSubscriber<? super U> conditionalSubscriber, Function<? super T, ? extends U> function) {
            super(conditionalSubscriber);
            this.mapper = function;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            return transitiveBoundaryFusion(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {
        final Function<? super T, ? extends U> mapper;

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.actual.onNext(null);
                return;
            }
            try {
                this.actual.onNext(ObjectHelper.requireNonNull(this.mapper.apply(t5), "The mapper function returned a null value."));
            } catch (Throwable th) {
                fail(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public U poll() throws Exception {
            T poll = this.qs.poll();
            if (poll != null) {
                return (U) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        MapSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends U> function) {
            super(subscriber);
            this.mapper = function;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            return transitiveBoundaryFusion(i6);
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new MapConditionalSubscriber((ConditionalSubscriber) subscriber, this.mapper));
        } else {
            this.source.subscribe(new MapSubscriber(subscriber, this.mapper));
        }
    }

    public FlowableMap(Publisher<T> publisher, Function<? super T, ? extends U> function) {
        super(publisher);
        this.mapper = function;
    }
}
