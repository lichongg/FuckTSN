package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableInternalHelper {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class FlatMapIntoIterable<T, U> implements Function<T, Publisher<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> mapper;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((FlatMapIntoIterable<T, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public Publisher<U> apply(T t5) throws Exception {
            return new FlowableFromIterable(this.mapper.apply(t5));
        }

        FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.mapper = function;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;

        /* renamed from: t, reason: collision with root package name */
        private final T f43188t;

        @Override // io.reactivex.functions.Function
        public R apply(U u5) throws Exception {
            return this.combiner.apply(this.f43188t, u5);
        }

        FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t5) {
            this.combiner = biFunction;
            this.f43188t = t5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, Publisher<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final Function<? super T, ? extends Publisher<? extends U>> mapper;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((FlatMapWithCombinerOuter<T, R, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public Publisher<R> apply(T t5) throws Exception {
            return new FlowableMap(this.mapper.apply(t5), new FlatMapWithCombinerInner(this.combiner, t5));
        }

        FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends Publisher<? extends U>> function) {
            this.combiner = biFunction;
            this.mapper = function;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ItemDelayFunction<T, U> implements Function<T, Publisher<T>> {
        final Function<? super T, ? extends Publisher<U>> itemDelay;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((ItemDelayFunction<T, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public Publisher<T> apply(T t5) throws Exception {
            return new FlowableTake(this.itemDelay.apply(t5), 1L).map(Functions.justFunction(t5)).defaultIfEmpty(t5);
        }

        ItemDelayFunction(Function<? super T, ? extends Publisher<U>> function) {
            this.itemDelay = function;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum RequestMax implements Consumer<Subscription> {
        INSTANCE;

        @Override // io.reactivex.functions.Consumer
        public void accept(Subscription subscription) throws Exception {
            subscription.request(Long.MAX_VALUE);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final BiConsumer<S, Emitter<T>> consumer;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiFunction
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            return apply((SimpleBiGenerator<T, S>) obj, (Emitter) obj2);
        }

        public S apply(S s5, Emitter<T> emitter) throws Exception {
            this.consumer.accept(s5, emitter);
            return s5;
        }

        SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.consumer = biConsumer;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final Consumer<Emitter<T>> consumer;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiFunction
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            return apply((SimpleGenerator<T, S>) obj, (Emitter) obj2);
        }

        public S apply(S s5, Emitter<T> emitter) throws Exception {
            this.consumer.accept(emitter);
            return s5;
        }

        SimpleGenerator(Consumer<Emitter<T>> consumer) {
            this.consumer = consumer;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SubscriberOnComplete<T> implements Action {
        final Subscriber<T> subscriber;

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.subscriber.onComplete();
        }

        SubscriberOnComplete(Subscriber<T> subscriber) {
            this.subscriber = subscriber;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SubscriberOnError<T> implements Consumer<Throwable> {
        final Subscriber<T> subscriber;

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) throws Exception {
            this.subscriber.onError(th);
        }

        SubscriberOnError(Subscriber<T> subscriber) {
            this.subscriber = subscriber;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SubscriberOnNext<T> implements Consumer<T> {
        final Subscriber<T> subscriber;

        @Override // io.reactivex.functions.Consumer
        public void accept(T t5) throws Exception {
            this.subscriber.onNext(t5);
        }

        SubscriberOnNext(Subscriber<T> subscriber) {
            this.subscriber = subscriber;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ZipIterableFunction<T, R> implements Function<List<Publisher<? extends T>>, Publisher<? extends R>> {
        private final Function<? super Object[], ? extends R> zipper;

        @Override // io.reactivex.functions.Function
        public Publisher<? extends R> apply(List<Publisher<? extends T>> list) {
            return Flowable.zipIterable(list, this.zipper, false, Flowable.bufferSize());
        }

        ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.zipper = function;
        }
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(final Flowable<T> flowable) {
        return new Callable<ConnectableFlowable<T>>() { // from class: io.reactivex.internal.operators.flowable.FlowableInternalHelper.1
            @Override // java.util.concurrent.Callable
            public ConnectableFlowable<T> call() {
                return Flowable.this.replay();
            }
        };
    }

    public static <T, U> Function<T, Publisher<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, Publisher<R>> flatMapWithCombiner(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, Publisher<T>> itemDelay(Function<? super T, ? extends Publisher<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(final Flowable<T> flowable, final int i6) {
        return new Callable<ConnectableFlowable<T>>() { // from class: io.reactivex.internal.operators.flowable.FlowableInternalHelper.2
            @Override // java.util.concurrent.Callable
            public ConnectableFlowable<T> call() {
                return Flowable.this.replay(i6);
            }
        };
    }

    public static <T, R> Function<Flowable<T>, Publisher<R>> replayFunction(final Function<? super Flowable<T>, ? extends Publisher<R>> function, final Scheduler scheduler) {
        return new Function<Flowable<T>, Publisher<R>>() { // from class: io.reactivex.internal.operators.flowable.FlowableInternalHelper.5
            @Override // io.reactivex.functions.Function
            public Publisher<R> apply(Flowable<T> flowable) throws Exception {
                return Flowable.fromPublisher((Publisher) Function.this.apply(flowable)).observeOn(scheduler);
            }
        };
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T> Action subscriberOnComplete(Subscriber<T> subscriber) {
        return new SubscriberOnComplete(subscriber);
    }

    public static <T> Consumer<Throwable> subscriberOnError(Subscriber<T> subscriber) {
        return new SubscriberOnError(subscriber);
    }

    public static <T> Consumer<T> subscriberOnNext(Subscriber<T> subscriber) {
        return new SubscriberOnNext(subscriber);
    }

    public static <T, R> Function<List<Publisher<? extends T>>, Publisher<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }

    private FlowableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(final Flowable<T> flowable, final int i6, final long j6, final TimeUnit timeUnit, final Scheduler scheduler) {
        return new Callable<ConnectableFlowable<T>>() { // from class: io.reactivex.internal.operators.flowable.FlowableInternalHelper.3
            @Override // java.util.concurrent.Callable
            public ConnectableFlowable<T> call() {
                return Flowable.this.replay(i6, j6, timeUnit, scheduler);
            }
        };
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(final Flowable<T> flowable, final long j6, final TimeUnit timeUnit, final Scheduler scheduler) {
        return new Callable<ConnectableFlowable<T>>() { // from class: io.reactivex.internal.operators.flowable.FlowableInternalHelper.4
            @Override // java.util.concurrent.Callable
            public ConnectableFlowable<T> call() {
                return Flowable.this.replay(j6, timeUnit, scheduler);
            }
        };
    }
}
