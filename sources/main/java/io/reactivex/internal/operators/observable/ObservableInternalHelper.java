package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableInternalHelper {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum ErrorMapperFilter implements Function<Notification<Object>, Throwable>, Predicate<Notification<Object>> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        public Throwable apply(Notification<Object> notification) throws Exception {
            return notification.getError();
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Notification<Object> notification) throws Exception {
            return notification.isOnError();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> mapper;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((FlatMapIntoIterable<T, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<U> apply(T t5) throws Exception {
            return new ObservableFromIterable(this.mapper.apply(t5));
        }

        FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.mapper = function;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;

        /* renamed from: t, reason: collision with root package name */
        private final T f43327t;

        @Override // io.reactivex.functions.Function
        public R apply(U u5) throws Exception {
            return this.combiner.apply(this.f43327t, u5);
        }

        FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t5) {
            this.combiner = biFunction;
            this.f43327t = t5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((FlatMapWithCombinerOuter<T, R, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<R> apply(T t5) throws Exception {
            return new ObservableMap(this.mapper.apply(t5), new FlatMapWithCombinerInner(this.combiner, t5));
        }

        FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.combiner = biFunction;
            this.mapper = function;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {
        final Function<? super T, ? extends ObservableSource<U>> itemDelay;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((ItemDelayFunction<T, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<T> apply(T t5) throws Exception {
            return new ObservableTake(this.itemDelay.apply(t5), 1L).map(Functions.justFunction(t5)).defaultIfEmpty(t5);
        }

        ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
            this.itemDelay = function;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum MapToInt implements Function<Object, Object> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ObserverOnComplete<T> implements Action {
        final Observer<T> observer;

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            this.observer.onComplete();
        }

        ObserverOnComplete(Observer<T> observer) {
            this.observer = observer;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ObserverOnError<T> implements Consumer<Throwable> {
        final Observer<T> observer;

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) throws Exception {
            this.observer.onError(th);
        }

        ObserverOnError(Observer<T> observer) {
            this.observer = observer;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ObserverOnNext<T> implements Consumer<T> {
        final Observer<T> observer;

        @Override // io.reactivex.functions.Consumer
        public void accept(T t5) throws Exception {
            this.observer.onNext(t5);
        }

        ObserverOnNext(Observer<T> observer) {
            this.observer = observer;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class RepeatWhenOuterHandler implements Function<Observable<Notification<Object>>, ObservableSource<?>> {
        private final Function<? super Observable<Object>, ? extends ObservableSource<?>> handler;

        @Override // io.reactivex.functions.Function
        public ObservableSource<?> apply(Observable<Notification<Object>> observable) throws Exception {
            return this.handler.apply(observable.map(MapToInt.INSTANCE));
        }

        RepeatWhenOuterHandler(Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
            this.handler = function;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class RetryWhenInner implements Function<Observable<Notification<Object>>, ObservableSource<?>> {
        private final Function<? super Observable<Throwable>, ? extends ObservableSource<?>> handler;

        @Override // io.reactivex.functions.Function
        public ObservableSource<?> apply(Observable<Notification<Object>> observable) throws Exception {
            ErrorMapperFilter errorMapperFilter = ErrorMapperFilter.INSTANCE;
            return this.handler.apply(observable.takeWhile(errorMapperFilter).map(errorMapperFilter));
        }

        RetryWhenInner(Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
            this.handler = function;
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
    static final class ZipIterableFunction<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {
        private final Function<? super Object[], ? extends R> zipper;

        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends R> apply(List<ObservableSource<? extends T>> list) {
            return Observable.zipIterable(list, this.zipper, false, Observable.bufferSize());
        }

        ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.zipper = function;
        }
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(final Observable<T> observable) {
        return new Callable<ConnectableObservable<T>>() { // from class: io.reactivex.internal.operators.observable.ObservableInternalHelper.1
            @Override // java.util.concurrent.Callable
            public ConnectableObservable<T> call() {
                return Observable.this.replay();
            }
        };
    }

    public static <T, U> Function<T, ObservableSource<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> flatMapWithCombiner(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, ObservableSource<T>> itemDelay(Function<? super T, ? extends ObservableSource<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Action observerOnComplete(Observer<T> observer) {
        return new ObserverOnComplete(observer);
    }

    public static <T> Consumer<Throwable> observerOnError(Observer<T> observer) {
        return new ObserverOnError(observer);
    }

    public static <T> Consumer<T> observerOnNext(Observer<T> observer) {
        return new ObserverOnNext(observer);
    }

    public static Function<Observable<Notification<Object>>, ObservableSource<?>> repeatWhenHandler(Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        return new RepeatWhenOuterHandler(function);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(final Observable<T> observable, final int i6) {
        return new Callable<ConnectableObservable<T>>() { // from class: io.reactivex.internal.operators.observable.ObservableInternalHelper.2
            @Override // java.util.concurrent.Callable
            public ConnectableObservable<T> call() {
                return Observable.this.replay(i6);
            }
        };
    }

    public static <T, R> Function<Observable<T>, ObservableSource<R>> replayFunction(final Function<? super Observable<T>, ? extends ObservableSource<R>> function, final Scheduler scheduler) {
        return new Function<Observable<T>, ObservableSource<R>>() { // from class: io.reactivex.internal.operators.observable.ObservableInternalHelper.5
            @Override // io.reactivex.functions.Function
            public ObservableSource<R> apply(Observable<T> observable) throws Exception {
                return Observable.wrap((ObservableSource) Function.this.apply(observable)).observeOn(scheduler);
            }
        };
    }

    public static <T> Function<Observable<Notification<Object>>, ObservableSource<?>> retryWhenHandler(Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        return new RetryWhenInner(function);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }

    private ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(final Observable<T> observable, final int i6, final long j6, final TimeUnit timeUnit, final Scheduler scheduler) {
        return new Callable<ConnectableObservable<T>>() { // from class: io.reactivex.internal.operators.observable.ObservableInternalHelper.3
            @Override // java.util.concurrent.Callable
            public ConnectableObservable<T> call() {
                return Observable.this.replay(i6, j6, timeUnit, scheduler);
            }
        };
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(final Observable<T> observable, final long j6, final TimeUnit timeUnit, final Scheduler scheduler) {
        return new Callable<ConnectableObservable<T>>() { // from class: io.reactivex.internal.operators.observable.ObservableInternalHelper.4
            @Override // java.util.concurrent.Callable
            public ConnectableObservable<T> call() {
                return Observable.this.replay(j6, timeUnit, scheduler);
            }
        };
    }
}
