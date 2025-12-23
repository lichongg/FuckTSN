package io.reactivex;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.observers.BlockingFirstObserver;
import io.reactivex.internal.observers.BlockingLastObserver;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.FutureObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.BlockingObservableLatest;
import io.reactivex.internal.operators.observable.BlockingObservableMostRecent;
import io.reactivex.internal.operators.observable.BlockingObservableNext;
import io.reactivex.internal.operators.observable.ObservableAllSingle;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableAnySingle;
import io.reactivex.internal.operators.observable.ObservableBlockingSubscribe;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableBufferExactBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferTimed;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCollectSingle;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableCountSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounce;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDelay;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.observable.ObservableDematerialize;
import io.reactivex.internal.operators.observable.ObservableDetach;
import io.reactivex.internal.operators.observable.ObservableDistinct;
import io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.internal.operators.observable.ObservableDoAfterNext;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableDoOnLifecycle;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableFlattenIterable;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.internal.operators.observable.ObservableFromFuture;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.internal.operators.observable.ObservableGenerate;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableHide;
import io.reactivex.internal.operators.observable.ObservableIgnoreElements;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.internal.operators.observable.ObservableLastSingle;
import io.reactivex.internal.operators.observable.ObservableLift;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableMapNotification;
import io.reactivex.internal.operators.observable.ObservableMaterialize;
import io.reactivex.internal.operators.observable.ObservableNever;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableOnErrorNext;
import io.reactivex.internal.operators.observable.ObservableOnErrorReturn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableRedo;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableScan;
import io.reactivex.internal.operators.observable.ObservableScanSeed;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSerialized;
import io.reactivex.internal.operators.observable.ObservableSingleMaybe;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.observable.ObservableSkip;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSkipUntil;
import io.reactivex.internal.operators.observable.ObservableSkipWhile;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTake;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastOne;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate;
import io.reactivex.internal.operators.observable.ObservableTakeWhile;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableTimeInterval;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableToList;
import io.reactivex.internal.operators.observable.ObservableToListSingle;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.operators.observable.ObservableZipIterable;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.observers.SafeObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class Observable<T> implements ObservableSource<T> {
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(Function<? super Object[], ? extends R> function, int i6, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatest(observableSourceArr, function, i6);
    }

    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(observableSourceArr, function, bufferSize());
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concat(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.identity(), bufferSize(), false);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concatArray(ObservableSource<? extends T>... observableSourceArr) {
        return observableSourceArr.length == 0 ? empty() : observableSourceArr.length == 1 ? wrap(observableSourceArr[0]) : RxJavaPlugins.onAssembly(new ObservableConcatMap(fromArray(observableSourceArr), Functions.identity(), bufferSize(), ErrorMode.BOUNDARY));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concatArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        return observableSourceArr.length == 0 ? empty() : observableSourceArr.length == 1 ? wrap(observableSourceArr[0]) : concatDelayError(fromArray(observableSourceArr));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concatArrayEager(ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEager(bufferSize(), bufferSize(), observableSourceArr);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concatDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatEager(observableSource, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    private Observable<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(action2, "onAfterTerminate is null");
        return RxJavaPlugins.onAssembly(new ObservableDoOnEach(this, consumer, consumer2, action, action2));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableError(callable));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.requireNonNull(future, "future is null");
        return RxJavaPlugins.onAssembly(new ObservableFromFuture(future, 0L, null));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> generate(Consumer<Emitter<T>> consumer) {
        ObjectHelper.requireNonNull(consumer, "generator  is null");
        return generate(Functions.nullSupplier(), ObservableInternalHelper.simpleGenerator(consumer), Functions.emptyConsumer());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public static Observable<Long> interval(long j6, long j7, TimeUnit timeUnit) {
        return interval(j6, j7, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public static Observable<Long> intervalRange(long j6, long j7, long j8, long j9, TimeUnit timeUnit) {
        return intervalRange(j6, j7, j8, j9, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t5) {
        ObjectHelper.requireNonNull(t5, "The item is null");
        return RxJavaPlugins.onAssembly(new ObservableJust(t5));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i6, int i7) {
        return fromIterable(iterable).flatMap(Functions.identity(), false, i6, i7);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> mergeArray(int i6, int i7, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.identity(), false, i6, i7);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> mergeArrayDelayError(int i6, int i7, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.identity(), true, i6, i7);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.identity(), true);
    }

    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.equalsPredicate(), bufferSize());
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i6) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMap(observableSource, Functions.identity(), i6, false));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNextDelayError(observableSource, bufferSize());
    }

    private Observable<T> timeout0(long j6, TimeUnit timeUnit, ObservableSource<? extends T> observableSource, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "timeUnit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableTimeoutTimed(this, j6, timeUnit, scheduler, observableSource));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public static Observable<Long> timer(long j6, TimeUnit timeUnit) {
        return timer(j6, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("none")
    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    @SchedulerSupport("none")
    public static <T, R> Observable<R> zip(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableZip(null, iterable, function, bufferSize(), false));
    }

    @SchedulerSupport("none")
    public static <T, R> Observable<R> zipArray(Function<? super Object[], ? extends R> function, boolean z5, int i6, ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableZip(observableSourceArr, null, function, i6, z5));
    }

    @SchedulerSupport("none")
    public final T blockingFirst() {
        BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T blockingGet = blockingFirstObserver.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    @SchedulerSupport("none")
    public final T blockingLast() {
        BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
        subscribe(blockingLastObserver);
        T blockingGet = blockingLastObserver.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    public final T blockingSingle() {
        T blockingGet = singleElement().blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe() {
        ObservableBlockingSubscribe.subscribe(this);
    }

    @SchedulerSupport("none")
    public final Observable<List<T>> buffer(int i6) {
        return buffer(i6, i6);
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMap(function, 2);
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapDelayError(function, bufferSize(), true);
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapEager(function, Integer.MAX_VALUE, bufferSize());
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z5) {
        return concatMapEagerDelayError(function, Integer.MAX_VALUE, bufferSize(), z5);
    }

    @SchedulerSupport("none")
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlattenIterable(this, function));
    }

    @SchedulerSupport("none")
    public final <U> Observable<T> debounce(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.requireNonNull(function, "debounceSelector is null");
        return RxJavaPlugins.onAssembly(new ObservableDebounce(this, function));
    }

    @SchedulerSupport("none")
    public final <U> Observable<T> delay(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.requireNonNull(function, "itemDelay is null");
        return (Observable<T>) flatMap(ObservableInternalHelper.itemDelay(function));
    }

    @SchedulerSupport("none")
    public final <U> Observable<T> delaySubscription(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableDelaySubscriptionOther(this, observableSource));
    }

    @SchedulerSupport("none")
    public final Observable<T> distinct() {
        return distinct(Functions.identity(), Functions.createHashSet());
    }

    @SchedulerSupport("none")
    public final Observable<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.identity());
    }

    @SchedulerSupport("none")
    public final Maybe<T> elementAt(long j6) {
        if (j6 >= 0) {
            return RxJavaPlugins.onAssembly(new ObservableElementAtMaybe(this, j6));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j6);
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return flatMap((Function) function, false);
    }

    @SchedulerSupport("none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return flatMapCompletable(function, false);
    }

    @SchedulerSupport("none")
    public final <U> Observable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlattenIterable(this, function));
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return flatMapMaybe(function, false);
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return flatMapSingle(function, false);
    }

    @SchedulerSupport("none")
    public final Disposable forEachWhile(Predicate<? super T> predicate) {
        return forEachWhile(predicate, Functions.ERROR_CONSUMER, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return (Observable<GroupedObservable<K, T>>) groupBy(function, Functions.identity(), false, bufferSize());
    }

    @SchedulerSupport("custom")
    public final Observable<T> observeOn(Scheduler scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    @SchedulerSupport("none")
    public final Observable<T> onErrorResumeNext(Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        ObjectHelper.requireNonNull(function, "resumeFunction is null");
        return RxJavaPlugins.onAssembly(new ObservableOnErrorNext(this, function, false));
    }

    @SchedulerSupport("none")
    public final ConnectableObservable<T> publish() {
        return ObservablePublish.create(this);
    }

    @SchedulerSupport("none")
    public final Maybe<T> reduce(BiFunction<T, T, T> biFunction) {
        return scan(biFunction).takeLast(1).singleElement();
    }

    @SchedulerSupport("none")
    public final Observable<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    @SchedulerSupport("none")
    public final ConnectableObservable<T> replay() {
        return ObservableReplay.createFrom(this);
    }

    @SchedulerSupport("none")
    public final Observable<T> retry() {
        return retry(Long.MAX_VALUE, Functions.alwaysTrue());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<T> sample(long j6, TimeUnit timeUnit) {
        return sample(j6, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("none")
    public final Observable<T> scan(BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "accumulator is null");
        return RxJavaPlugins.onAssembly(new ObservableScan(this, biFunction));
    }

    @SchedulerSupport("none")
    public final Observable<T> skip(long j6) {
        return j6 <= 0 ? RxJavaPlugins.onAssembly(this) : RxJavaPlugins.onAssembly(new ObservableSkip(this, j6));
    }

    @SchedulerSupport("none")
    public final Observable<T> skipLast(int i6) {
        if (i6 >= 0) {
            return i6 == 0 ? RxJavaPlugins.onAssembly(this) : RxJavaPlugins.onAssembly(new ObservableSkipLast(this, i6));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i6);
    }

    @SchedulerSupport("none")
    public final Observable<T> sorted() {
        return toList().toObservable().map(Functions.listSorter(Functions.naturalComparator())).flatMapIterable(Functions.identity());
    }

    @SchedulerSupport("none")
    public final Observable<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ERROR_CONSUMER, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    protected abstract void subscribeActual(Observer<? super T> observer);

    @SchedulerSupport("none")
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMap(function, bufferSize());
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMapDelayError(function, bufferSize());
    }

    @SchedulerSupport("none")
    public final Observable<T> take(long j6) {
        if (j6 >= 0) {
            return RxJavaPlugins.onAssembly(new ObservableTake(this, j6));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j6);
    }

    @SchedulerSupport("none")
    public final Observable<T> takeLast(int i6) {
        if (i6 >= 0) {
            return i6 == 0 ? RxJavaPlugins.onAssembly(new ObservableIgnoreElements(this)) : i6 == 1 ? RxJavaPlugins.onAssembly(new ObservableTakeLastOne(this)) : RxJavaPlugins.onAssembly(new ObservableTakeLast(this, i6));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i6);
    }

    @SchedulerSupport("none")
    public final <U> Observable<T> takeUntil(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableTakeUntil(this, observableSource));
    }

    @SchedulerSupport("none")
    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<T> throttleFirst(long j6, TimeUnit timeUnit) {
        return throttleFirst(j6, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<T> throttleLast(long j6, TimeUnit timeUnit) {
        return sample(j6, timeUnit);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<T> throttleWithTimeout(long j6, TimeUnit timeUnit) {
        return debounce(j6, timeUnit);
    }

    @SchedulerSupport("none")
    public final Observable<Timed<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @SchedulerSupport("none")
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function) {
        return timeout0(null, function, null);
    }

    @SchedulerSupport("none")
    public final Observable<Timed<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @SchedulerSupport("none")
    public final Single<List<T>> toList() {
        return toList(16);
    }

    @SchedulerSupport("none")
    public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> function) {
        return (Single<Map<K, T>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeySelector(function));
    }

    @SchedulerSupport("none")
    public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> function) {
        return (Single<Map<K, Collection<T>>>) toMultimap(function, Functions.identity(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList() {
        return toSortedList(Functions.naturalOrder());
    }

    @SchedulerSupport("none")
    public final Observable<Observable<T>> window(long j6) {
        return window(j6, j6, bufferSize());
    }

    @SchedulerSupport("none")
    public final <U, R> Observable<R> withLatestFrom(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        ObjectHelper.requireNonNull(biFunction, "combiner is null");
        return RxJavaPlugins.onAssembly(new ObservableWithLatestFrom(this, biFunction, observableSource));
    }

    @SchedulerSupport("none")
    public final <U, R> Observable<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(iterable, "other is null");
        ObjectHelper.requireNonNull(biFunction, "zipper is null");
        return RxJavaPlugins.onAssembly(new ObservableZipIterable(this, iterable, biFunction));
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.reactivex.Observable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$BackpressureStrategy;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            $SwitchMap$io$reactivex$BackpressureStrategy = iArr;
            try {
                iArr[BackpressureStrategy.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> amb(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableAmb(null, iterable));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> ambArray(ObservableSource<? extends T>... observableSourceArr) {
        ObjectHelper.requireNonNull(observableSourceArr, "sources is null");
        int length = observableSourceArr.length;
        return length == 0 ? empty() : length == 1 ? wrap(observableSourceArr[0]) : RxJavaPlugins.onAssembly(new ObservableAmb(observableSourceArr, null));
    }

    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatest(iterable, function, bufferSize());
    }

    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int i6, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatestDelayError(observableSourceArr, function, i6);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concatArrayEager(int i6, int i7, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(Functions.identity(), i6, i7, false);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i6, int i7) {
        return wrap(observableSource).concatMapEager(Functions.identity(), i6, i7);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        ObjectHelper.requireNonNull(observableOnSubscribe, "source is null");
        return RxJavaPlugins.onAssembly(new ObservableCreate(observableOnSubscribe));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> defer(Callable<? extends ObservableSource<? extends T>> callable) {
        ObjectHelper.requireNonNull(callable, "supplier is null");
        return RxJavaPlugins.onAssembly(new ObservableDefer(callable));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> empty() {
        return RxJavaPlugins.onAssembly(ObservableEmpty.INSTANCE);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> fromArray(T... tArr) {
        ObjectHelper.requireNonNull(tArr, "items is null");
        return tArr.length == 0 ? empty() : tArr.length == 1 ? just(tArr[0]) : RxJavaPlugins.onAssembly(new ObservableFromArray(tArr));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, "supplier is null");
        return RxJavaPlugins.onAssembly(new ObservableFromCallable(callable));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> fromIterable(Iterable<? extends T> iterable) {
        ObjectHelper.requireNonNull(iterable, "source is null");
        return RxJavaPlugins.onAssembly(new ObservableFromIterable(iterable));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public static <T> Observable<T> fromPublisher(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "publisher is null");
        return RxJavaPlugins.onAssembly(new ObservableFromPublisher(publisher));
    }

    @SchedulerSupport("custom")
    public static Observable<Long> interval(long j6, long j7, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableInterval(Math.max(0L, j6), Math.max(0L, j7), timeUnit, scheduler));
    }

    @SchedulerSupport("custom")
    public static Observable<Long> intervalRange(long j6, long j7, long j8, long j9, TimeUnit timeUnit, Scheduler scheduler) {
        if (j7 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j7);
        }
        if (j7 == 0) {
            return empty().delay(j8, timeUnit, scheduler);
        }
        long j10 = (j7 - 1) + j6;
        if (j6 > 0 && j10 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableIntervalRange(j6, j10, Math.max(0L, j8), Math.max(0L, j9), timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.identity());
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> mergeArray(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.identity(), observableSourceArr.length);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> mergeArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.identity(), true, observableSourceArr.length);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i6, int i7) {
        return fromIterable(iterable).flatMap(Functions.identity(), true, i6, i7);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> never() {
        return RxJavaPlugins.onAssembly(ObservableNever.INSTANCE);
    }

    @SchedulerSupport("none")
    public static Observable<Integer> range(int i6, int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i7);
        }
        if (i7 == 0) {
            return empty();
        }
        if (i7 == 1) {
            return just(Integer.valueOf(i6));
        }
        if (i6 + (i7 - 1) <= 2147483647L) {
            return RxJavaPlugins.onAssembly(new ObservableRange(i6, i7));
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    @SchedulerSupport("none")
    public static Observable<Long> rangeLong(long j6, long j7) {
        if (j7 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j7);
        }
        if (j7 == 0) {
            return empty();
        }
        if (j7 == 1) {
            return just(Long.valueOf(j6));
        }
        long j8 = (j7 - 1) + j6;
        if (j6 <= 0 || j8 >= 0) {
            return RxJavaPlugins.onAssembly(new ObservableRangeLong(j6, j7));
        }
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    }

    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(observableSource, observableSource2, biPredicate, bufferSize());
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i6) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        ObjectHelper.verifyPositive(i6, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMap(observableSource, Functions.identity(), i6, true));
    }

    @SchedulerSupport("custom")
    public static Observable<Long> timer(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableTimer(Math.max(j6, 0L), timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> unsafeCreate(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "source is null");
        ObjectHelper.requireNonNull(observableSource, "onSubscribe is null");
        if (observableSource instanceof Observable) {
            throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        }
        return RxJavaPlugins.onAssembly(new ObservableFromUnsafeSource(observableSource));
    }

    @SchedulerSupport("none")
    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z5) {
        ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        ObjectHelper.requireNonNull(function, "sourceSupplier is null");
        ObjectHelper.requireNonNull(consumer, "disposer is null");
        return RxJavaPlugins.onAssembly(new ObservableUsing(callable, function, consumer, z5));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> wrap(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "source is null");
        return observableSource instanceof Observable ? RxJavaPlugins.onAssembly((Observable) observableSource) : RxJavaPlugins.onAssembly(new ObservableFromUnsafeSource(observableSource));
    }

    @SchedulerSupport("none")
    public static <T, R> Observable<R> zipIterable(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean z5, int i6) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableZip(null, iterable, function, i6, z5));
    }

    @SchedulerSupport("none")
    public final Single<Boolean> all(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableAllSingle(this, predicate));
    }

    @SchedulerSupport("none")
    public final Observable<T> ambWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return ambArray(this, observableSource);
    }

    @SchedulerSupport("none")
    public final Single<Boolean> any(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableAnySingle(this, predicate));
    }

    @SchedulerSupport("none")
    public final Iterable<T> blockingIterable(int i6) {
        ObjectHelper.verifyPositive(i6, "bufferSize");
        return new BlockingObservableIterable(this, i6);
    }

    @SchedulerSupport("none")
    public final Iterable<T> blockingLatest() {
        return new BlockingObservableLatest(this);
    }

    @SchedulerSupport("none")
    public final Iterable<T> blockingMostRecent(T t5) {
        return new BlockingObservableMostRecent(this, t5);
    }

    @SchedulerSupport("none")
    public final Iterable<T> blockingNext() {
        return new BlockingObservableNext(this);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer) {
        ObservableBlockingSubscribe.subscribe(this, consumer, Functions.ERROR_CONSUMER, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    public final Observable<List<T>> buffer(int i6, int i7) {
        return (Observable<List<T>>) buffer(i6, i7, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    public final <U> Observable<U> cast(Class<U> cls) {
        ObjectHelper.requireNonNull(cls, "clazz is null");
        return (Observable<U>) map(Functions.castFunction(cls));
    }

    @SchedulerSupport("none")
    public final <U> Single<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(callable, "initialValueSupplier is null");
        ObjectHelper.requireNonNull(biConsumer, "collector is null");
        return RxJavaPlugins.onAssembly(new ObservableCollectSingle(this, callable, biConsumer));
    }

    @SchedulerSupport("none")
    public final <U> Single<U> collectInto(U u5, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(u5, "initialValue is null");
        return collect(Functions.justCallable(u5), biConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i6) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i6, "prefetch");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(this, function, i6, ErrorMode.IMMEDIATE));
        }
        Object call = ((ScalarCallable) this).call();
        return call == null ? empty() : ObservableScalarXMap.scalarXMap(call, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i6, boolean z5) {
        ObjectHelper.verifyPositive(i6, "prefetch");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(this, function, i6, z5 ? ErrorMode.END : ErrorMode.BOUNDARY));
        }
        Object call = ((ScalarCallable) this).call();
        return call == null ? empty() : ObservableScalarXMap.scalarXMap(call, function);
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function, int i6, int i7) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i6, "maxConcurrency");
        ObjectHelper.verifyPositive(i7, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableConcatMapEager(this, function, ErrorMode.IMMEDIATE, i6, i7));
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i6, int i7, boolean z5) {
        return RxJavaPlugins.onAssembly(new ObservableConcatMapEager(this, function, z5 ? ErrorMode.END : ErrorMode.BOUNDARY, i6, i7));
    }

    @SchedulerSupport("none")
    public final Observable<T> concatWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return concat(this, observableSource);
    }

    @SchedulerSupport("none")
    public final Single<Boolean> contains(Object obj) {
        ObjectHelper.requireNonNull(obj, "element is null");
        return any(Functions.equalsWith(obj));
    }

    @SchedulerSupport("none")
    public final Single<Long> count() {
        return RxJavaPlugins.onAssembly(new ObservableCountSingle(this));
    }

    @SchedulerSupport("none")
    public final Observable<T> defaultIfEmpty(T t5) {
        ObjectHelper.requireNonNull(t5, "defaultItem is null");
        return switchIfEmpty(just(t5));
    }

    @SchedulerSupport("none")
    public final <T2> Observable<T2> dematerialize() {
        return RxJavaPlugins.onAssembly(new ObservableDematerialize(this));
    }

    @SchedulerSupport("none")
    public final <K> Observable<T> distinct(Function<? super T, K> function) {
        return distinct(function, Functions.createHashSet());
    }

    @SchedulerSupport("none")
    public final <K> Observable<T> distinctUntilChanged(Function<? super T, K> function) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        return RxJavaPlugins.onAssembly(new ObservableDistinctUntilChanged(this, function, ObjectHelper.equalsPredicate()));
    }

    @SchedulerSupport("none")
    @Experimental
    public final Observable<T> doAfterNext(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onAfterNext is null");
        return RxJavaPlugins.onAssembly(new ObservableDoAfterNext(this, consumer));
    }

    @SchedulerSupport("none")
    public final Observable<T> doAfterTerminate(Action action) {
        ObjectHelper.requireNonNull(action, "onFinally is null");
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, action);
    }

    @SchedulerSupport("none")
    @Experimental
    public final Observable<T> doFinally(Action action) {
        ObjectHelper.requireNonNull(action, "onFinally is null");
        return RxJavaPlugins.onAssembly(new ObservableDoFinally(this, action));
    }

    @SchedulerSupport("none")
    public final Observable<T> doOnLifecycle(Consumer<? super Disposable> consumer, Action action) {
        ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        ObjectHelper.requireNonNull(action, "onDispose is null");
        return RxJavaPlugins.onAssembly(new ObservableDoOnLifecycle(this, consumer, action));
    }

    @SchedulerSupport("none")
    public final Observable<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        return doOnLifecycle(consumer, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    public final Observable<T> doOnTerminate(Action action) {
        ObjectHelper.requireNonNull(action, "onTerminate is null");
        return doOnEach(Functions.emptyConsumer(), Functions.actionConsumer(action), action, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    public final Single<T> elementAtOrError(long j6) {
        if (j6 >= 0) {
            return RxJavaPlugins.onAssembly(new ObservableElementAtSingle(this, j6, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j6);
    }

    @SchedulerSupport("none")
    public final Observable<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableFilter(this, predicate));
    }

    @SchedulerSupport("none")
    public final Single<T> first(T t5) {
        return elementAt(0L, t5);
    }

    @SchedulerSupport("none")
    public final Maybe<T> firstElement() {
        return elementAt(0L);
    }

    @SchedulerSupport("none")
    public final Single<T> firstOrError() {
        return elementAtOrError(0L);
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z5) {
        return flatMap(function, z5, Integer.MAX_VALUE);
    }

    @SchedulerSupport("none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean z5) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlatMapCompletableCompletable(this, function, z5));
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z5) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlatMapMaybe(this, function, z5));
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z5) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlatMapSingle(this, function, z5));
    }

    @SchedulerSupport("none")
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer) {
        return forEachWhile(predicate, consumer, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function, boolean z5) {
        return (Observable<GroupedObservable<K, T>>) groupBy(function, Functions.identity(), z5, bufferSize());
    }

    @SchedulerSupport("none")
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> groupJoin(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super Observable<TRight>, ? extends R> biFunction) {
        return RxJavaPlugins.onAssembly(new ObservableGroupJoin(this, observableSource, function, function2, biFunction));
    }

    @SchedulerSupport("none")
    public final Observable<T> hide() {
        return RxJavaPlugins.onAssembly(new ObservableHide(this));
    }

    @SchedulerSupport("none")
    public final Completable ignoreElements() {
        return RxJavaPlugins.onAssembly(new ObservableIgnoreElementsCompletable(this));
    }

    @SchedulerSupport("none")
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> join(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        return RxJavaPlugins.onAssembly(new ObservableJoin(this, observableSource, function, function2, biFunction));
    }

    @SchedulerSupport("none")
    public final Single<T> last(T t5) {
        ObjectHelper.requireNonNull(t5, "defaultItem is null");
        return RxJavaPlugins.onAssembly(new ObservableLastSingle(this, t5));
    }

    @SchedulerSupport("none")
    public final Maybe<T> lastElement() {
        return RxJavaPlugins.onAssembly(new ObservableLastMaybe(this));
    }

    @SchedulerSupport("none")
    public final Single<T> lastOrError() {
        return RxJavaPlugins.onAssembly(new ObservableLastSingle(this, null));
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> lift(ObservableOperator<? extends R, ? super T> observableOperator) {
        ObjectHelper.requireNonNull(observableOperator, "onLift is null");
        return RxJavaPlugins.onAssembly(new ObservableLift(this, observableOperator));
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableMap(this, function));
    }

    @SchedulerSupport("none")
    public final Observable<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly(new ObservableMaterialize(this));
    }

    @SchedulerSupport("none")
    public final Observable<T> mergeWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return merge(this, observableSource);
    }

    @SchedulerSupport("custom")
    public final Observable<T> observeOn(Scheduler scheduler, boolean z5) {
        return observeOn(scheduler, z5, bufferSize());
    }

    @SchedulerSupport("none")
    public final <U> Observable<U> ofType(Class<U> cls) {
        ObjectHelper.requireNonNull(cls, "clazz is null");
        return filter(Functions.isInstanceOf(cls)).cast(cls);
    }

    @SchedulerSupport("none")
    public final Observable<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.requireNonNull(function, "valueSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableOnErrorReturn(this, function));
    }

    @SchedulerSupport("none")
    public final Observable<T> onErrorReturnItem(T t5) {
        ObjectHelper.requireNonNull(t5, "item is null");
        return onErrorReturn(Functions.justFunction(t5));
    }

    @SchedulerSupport("none")
    public final Observable<T> onExceptionResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "next is null");
        return RxJavaPlugins.onAssembly(new ObservableOnErrorNext(this, Functions.justFunction(observableSource), true));
    }

    @SchedulerSupport("none")
    public final Observable<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly(new ObservableDetach(this));
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> publish(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.requireNonNull(function, "selector is null");
        return new ObservablePublishSelector(this, function);
    }

    @SchedulerSupport("none")
    public final <R> Single<R> reduce(R r5, BiFunction<R, ? super T, R> biFunction) {
        return RxJavaPlugins.onAssembly(new ObservableSingleSingle(scan(r5, biFunction).takeLast(1), null));
    }

    @SchedulerSupport("none")
    public final <R> Single<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        return RxJavaPlugins.onAssembly(new ObservableSingleSingle(scanWith(callable, biFunction).takeLast(1), null));
    }

    @SchedulerSupport("none")
    public final Observable<T> repeat(long j6) {
        if (j6 >= 0) {
            return j6 == 0 ? empty() : RxJavaPlugins.onAssembly(new ObservableRepeat(this, j6));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j6);
    }

    @SchedulerSupport("none")
    public final Observable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return RxJavaPlugins.onAssembly(new ObservableRepeatUntil(this, booleanSupplier));
    }

    @SchedulerSupport("none")
    public final Observable<T> repeatWhen(Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        ObjectHelper.requireNonNull(function, "handler is null");
        return RxJavaPlugins.onAssembly(new ObservableRedo(this, ObservableInternalHelper.repeatWhenHandler(function), false));
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.requireNonNull(function, "selector is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this), function);
    }

    @SchedulerSupport("none")
    public final Observable<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        ObjectHelper.requireNonNull(biPredicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableRetryBiPredicate(this, biPredicate));
    }

    @SchedulerSupport("none")
    public final Observable<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return retry(Long.MAX_VALUE, Functions.predicateReverseFor(booleanSupplier));
    }

    @SchedulerSupport("none")
    public final Observable<T> retryWhen(Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        ObjectHelper.requireNonNull(function, "handler is null");
        return RxJavaPlugins.onAssembly(new ObservableRedo(this, ObservableInternalHelper.retryWhenHandler(function), true));
    }

    @SchedulerSupport("none")
    public final void safeSubscribe(Observer<? super T> observer) {
        ObjectHelper.requireNonNull(observer, "s is null");
        if (observer instanceof SafeObserver) {
            subscribe(observer);
        } else {
            subscribe(new SafeObserver(observer));
        }
    }

    @SchedulerSupport("custom")
    public final Observable<T> sample(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableSampleTimed(this, j6, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, "seedSupplier is null");
        ObjectHelper.requireNonNull(biFunction, "accumulator is null");
        return RxJavaPlugins.onAssembly(new ObservableScanSeed(this, callable, biFunction));
    }

    @SchedulerSupport("none")
    public final Observable<T> serialize() {
        return RxJavaPlugins.onAssembly(new ObservableSerialized(this));
    }

    @SchedulerSupport("none")
    public final Single<T> single(T t5) {
        ObjectHelper.requireNonNull(t5, "defaultItem is null");
        return RxJavaPlugins.onAssembly(new ObservableSingleSingle(this, t5));
    }

    @SchedulerSupport("none")
    public final Maybe<T> singleElement() {
        return RxJavaPlugins.onAssembly(new ObservableSingleMaybe(this));
    }

    @SchedulerSupport("none")
    public final Single<T> singleOrError() {
        return RxJavaPlugins.onAssembly(new ObservableSingleSingle(this, null));
    }

    @SchedulerSupport("none")
    public final <U> Observable<T> skipUntil(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableSkipUntil(this, observableSource));
    }

    @SchedulerSupport("none")
    public final Observable<T> skipWhile(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableSkipWhile(this, predicate));
    }

    @SchedulerSupport("none")
    public final Observable<T> sorted(Comparator<? super T> comparator) {
        return toList().toObservable().map(Functions.listSorter(comparator)).flatMapIterable(Functions.identity());
    }

    @SchedulerSupport("none")
    public final Observable<T> startWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return concatArray(observableSource, this);
    }

    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.ERROR_CONSUMER, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    @SchedulerSupport("custom")
    public final Observable<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableSubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    public final Observable<T> switchIfEmpty(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchIfEmpty(this, observableSource));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i6) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.onAssembly(new ObservableSwitchMap(this, function, i6, false));
        }
        Object call = ((ScalarCallable) this).call();
        return call == null ? empty() : ObservableScalarXMap.scalarXMap(call, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i6) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.onAssembly(new ObservableSwitchMap(this, function, i6, true));
        }
        Object call = ((ScalarCallable) this).call();
        return call == null ? empty() : ObservableScalarXMap.scalarXMap(call, function);
    }

    @SchedulerSupport("none")
    public final Observable<T> takeWhile(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableTakeWhile(this, predicate));
    }

    @SchedulerSupport("custom")
    public final Observable<T> throttleFirst(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableThrottleFirstTimed(this, j6, timeUnit, scheduler));
    }

    @SchedulerSupport("custom")
    public final Observable<T> throttleLast(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return sample(j6, timeUnit, scheduler);
    }

    @SchedulerSupport("custom")
    public final Observable<T> throttleWithTimeout(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return debounce(j6, timeUnit, scheduler);
    }

    @SchedulerSupport("none")
    public final Observable<Timed<T>> timeInterval(Scheduler scheduler) {
        return timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    @SchedulerSupport("none")
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return timeout0(null, function, observableSource);
    }

    @SchedulerSupport("none")
    public final Observable<Timed<T>> timestamp(Scheduler scheduler) {
        return timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    public final Flowable<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        FlowableFromObservable flowableFromObservable = new FlowableFromObservable(this);
        int i6 = AnonymousClass1.$SwitchMap$io$reactivex$BackpressureStrategy[backpressureStrategy.ordinal()];
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? flowableFromObservable.onBackpressureBuffer() : RxJavaPlugins.onAssembly(new FlowableOnBackpressureError(flowableFromObservable)) : flowableFromObservable : flowableFromObservable.onBackpressureLatest() : flowableFromObservable.onBackpressureDrop();
    }

    @SchedulerSupport("none")
    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureObserver());
    }

    @SchedulerSupport("none")
    public final Single<List<T>> toList(int i6) {
        ObjectHelper.verifyPositive(i6, "capacityHint");
        return RxJavaPlugins.onAssembly(new ObservableToListSingle(this, i6));
    }

    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        return (Single<Map<K, V>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeyValueSelector(function, function2));
    }

    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        return (Single<List<T>>) toList().map(Functions.listSorter(comparator));
    }

    @SchedulerSupport("custom")
    public final Observable<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableUnsubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    public final Observable<Observable<T>> window(long j6, long j7) {
        return window(j6, j7, bufferSize());
    }

    public static int bufferSize() {
        return Flowable.bufferSize();
    }

    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i6) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableCombineLatest(null, iterable, function, i6 << 1, false));
    }

    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i6) {
        ObjectHelper.verifyPositive(i6, "bufferSize");
        ObjectHelper.requireNonNull(function, "combiner is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        return RxJavaPlugins.onAssembly(new ObservableCombineLatest(observableSourceArr, null, function, i6 << 1, true));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concat(observableSource, bufferSize());
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatDelayError(observableSource, bufferSize(), true);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> error(Throwable th) {
        ObjectHelper.requireNonNull(th, "e is null");
        return error((Callable<? extends Throwable>) Functions.justCallable(th));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j6, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(future, "future is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return RxJavaPlugins.onAssembly(new ObservableFromFuture(future, j6, timeUnit));
    }

    @SchedulerSupport("none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, "generator  is null");
        return generate(callable, ObservableInternalHelper.simpleBiGenerator(biConsumer), Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t5, T t6) {
        ObjectHelper.requireNonNull(t5, "The first item is null");
        ObjectHelper.requireNonNull(t6, "The second item is null");
        return fromArray(t5, t6);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i6) {
        return fromIterable(iterable).flatMap(Functions.identity(), i6);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i6) {
        return fromIterable(iterable).flatMap(Functions.identity(), true, i6);
    }

    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i6) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(biPredicate, "isEqual is null");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableSequenceEqualSingle(observableSource, observableSource2, biPredicate, i6));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNext(observableSource, bufferSize());
    }

    @SchedulerSupport("none")
    public final void blockingForEach(Consumer<? super T> consumer) {
        Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                consumer.accept(it.next());
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                ((Disposable) it).dispose();
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
    }

    @SchedulerSupport("none")
    public final T blockingSingle(T t5) {
        return single(t5).blockingGet();
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObservableBlockingSubscribe.subscribe(this, consumer, consumer2, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    public final <U extends Collection<? super T>> Observable<U> buffer(int i6, int i7, Callable<U> callable) {
        ObjectHelper.verifyPositive(i6, "count");
        ObjectHelper.verifyPositive(i7, "skip");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBuffer(this, i6, i7, callable));
    }

    @SchedulerSupport("none")
    public final Observable<T> cache() {
        return ObservableCache.from(this);
    }

    @SchedulerSupport("none")
    public final Observable<T> cacheWithInitialCapacity(int i6) {
        return ObservableCache.from(this, i6);
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> compose(ObservableTransformer<T, R> observableTransformer) {
        return wrap(observableTransformer.apply(this));
    }

    @SchedulerSupport("none")
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i6) {
        return (Observable<U>) concatMap(ObservableInternalHelper.flatMapIntoIterable(function), i6);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<T> debounce(long j6, TimeUnit timeUnit) {
        return debounce(j6, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<T> delay(long j6, TimeUnit timeUnit) {
        return delay(j6, timeUnit, Schedulers.computation(), false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<T> delaySubscription(long j6, TimeUnit timeUnit) {
        return delaySubscription(j6, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("none")
    public final <K> Observable<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        return new ObservableDistinct(this, function, callable);
    }

    @SchedulerSupport("none")
    public final Observable<T> doOnComplete(Action action) {
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), action, Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    public final Observable<T> doOnDispose(Action action) {
        return doOnLifecycle(Functions.emptyConsumer(), action);
    }

    @SchedulerSupport("none")
    public final Observable<T> doOnError(Consumer<? super Throwable> consumer) {
        Consumer<? super T> emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnEach(emptyConsumer, consumer, action, action);
    }

    @SchedulerSupport("none")
    public final Observable<T> doOnNext(Consumer<? super T> consumer) {
        Consumer<? super Throwable> emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnEach(consumer, emptyConsumer, action, action);
    }

    @SchedulerSupport("none")
    public final Single<T> elementAt(long j6, T t5) {
        if (j6 >= 0) {
            ObjectHelper.requireNonNull(t5, "defaultItem is null");
            return RxJavaPlugins.onAssembly(new ObservableElementAtSingle(this, j6, t5));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j6);
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z5, int i6) {
        return flatMap(function, z5, i6, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    public final <U, V> Observable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        return (Observable<V>) flatMap(ObservableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    public final Disposable forEach(Consumer<? super T> consumer) {
        return subscribe(consumer);
    }

    @SchedulerSupport("none")
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        ObjectHelper.requireNonNull(predicate, "onNext is null");
        ObjectHelper.requireNonNull(consumer, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(predicate, consumer, action);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    @SchedulerSupport("none")
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, false, bufferSize());
    }

    @SchedulerSupport("none")
    public final Single<Boolean> isEmpty() {
        return all(Functions.alwaysFalse());
    }

    @SchedulerSupport("custom")
    public final Observable<T> observeOn(Scheduler scheduler, boolean z5, int i6) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableObserveOn(this, scheduler, z5, i6));
    }

    @SchedulerSupport("none")
    public final Observable<T> onErrorResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "next is null");
        return onErrorResumeNext(Functions.justFunction(observableSource));
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> scan(R r5, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(r5, "seed is null");
        return scanWith(Functions.justCallable(r5), biFunction);
    }

    @SchedulerSupport("none")
    public final Observable<T> share() {
        return publish().refCount();
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<T> skip(long j6, TimeUnit timeUnit) {
        return skipUntil(timer(j6, timeUnit));
    }

    @SchedulerSupport("none")
    public final Observable<T> startWithArray(T... tArr) {
        Observable fromArray = fromArray(tArr);
        if (fromArray == empty()) {
            return RxJavaPlugins.onAssembly(this);
        }
        return concatArray(fromArray, this);
    }

    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    public final <E extends Observer<? super T>> E subscribeWith(E e6) {
        subscribe(e6);
        return e6;
    }

    @SchedulerSupport("none")
    public final Observable<T> take(long j6, TimeUnit timeUnit) {
        return takeUntil(timer(j6, timeUnit));
    }

    @SchedulerSupport("none")
    public final Observable<T> takeUntil(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableTakeUntilPredicate(this, predicate));
    }

    @SchedulerSupport("none")
    public final TestObserver<T> test(boolean z5) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z5) {
            testObserver.dispose();
        }
        subscribe(testObserver);
        return testObserver;
    }

    @SchedulerSupport("none")
    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("none")
    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("none")
    public final <R> R to(Function<? super Observable<T>, R> function) {
        try {
            return function.apply(this);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @SchedulerSupport("none")
    public final Observable<Observable<T>> window(long j6, long j7, int i6) {
        ObjectHelper.verifyPositive(j6, "count");
        ObjectHelper.verifyPositive(j7, "skip");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableWindow(this, j6, j7, i6));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i6) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableConcatMap(observableSource, Functions.identity(), i6, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i6, boolean z5) {
        return RxJavaPlugins.onAssembly(new ObservableConcatMap(observableSource, Functions.identity(), i6, z5 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable, int i6, int i7) {
        return fromIterable(iterable).concatMapEagerDelayError(Functions.identity(), i6, i7, false);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), false, Integer.MAX_VALUE, bufferSize()));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), true, Integer.MAX_VALUE, bufferSize()));
    }

    private <U, V> Observable<T> timeout0(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(function, "itemTimeoutIndicator is null");
        return RxJavaPlugins.onAssembly(new ObservableTimeout(this, observableSource, function, observableSource2));
    }

    @SchedulerSupport("none")
    public static <T, R> Observable<R> zip(ObservableSource<? extends ObservableSource<? extends T>> observableSource, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableToList(observableSource, 16).flatMap(ObservableInternalHelper.zipIterable(function)));
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObservableBlockingSubscribe.subscribe(this, consumer, consumer2, action);
    }

    @SchedulerSupport("custom")
    public final Observable<T> debounce(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableDebounceTimed(this, j6, timeUnit, scheduler));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<T> delay(long j6, TimeUnit timeUnit, boolean z5) {
        return delay(j6, timeUnit, Schedulers.computation(), z5);
    }

    @SchedulerSupport("custom")
    public final Observable<T> delaySubscription(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(timer(j6, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    public final Observable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.requireNonNull(biPredicate, "comparer is null");
        return RxJavaPlugins.onAssembly(new ObservableDistinctUntilChanged(this, Functions.identity(), biPredicate));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z5, int i6, int i7) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i6, "maxConcurrency");
        ObjectHelper.verifyPositive(i7, "bufferSize");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.scalarXMap(call, function);
        }
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(this, function, z5, i6, i7));
    }

    @SchedulerSupport("none")
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z5) {
        return groupBy(function, function2, z5, bufferSize());
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i6) {
        ObjectHelper.requireNonNull(function, "selector is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i6), function);
    }

    @SchedulerSupport("none")
    public final Observable<T> retry(long j6) {
        return retry(j6, Functions.alwaysTrue());
    }

    @SchedulerSupport("custom")
    public final Observable<T> skip(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return skipUntil(timer(j6, timeUnit, scheduler));
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    public final Observable<T> skipLast(long j6, TimeUnit timeUnit) {
        return skipLast(j6, timeUnit, Schedulers.trampoline(), false, bufferSize());
    }

    @SchedulerSupport("none")
    public final Observable<T> startWith(T t5) {
        ObjectHelper.requireNonNull(t5, "item is null");
        return concatArray(just(t5), this);
    }

    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return subscribe(consumer, consumer2, action, Functions.emptyConsumer());
    }

    @SchedulerSupport("custom")
    public final Observable<T> take(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return takeUntil(timer(j6, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableTimeInterval(this, timeUnit, scheduler));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<T> timeout(long j6, TimeUnit timeUnit) {
        return timeout0(j6, timeUnit, null, Schedulers.computation());
    }

    @SchedulerSupport("none")
    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return (Observable<Timed<T>>) map(Functions.timestampWith(timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> callable) {
        ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableToListSingle(this, callable));
    }

    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator, int i6) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        return (Single<List<T>>) toList(i6).map(Functions.listSorter(comparator));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    public final <T1, T2, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, Function3<? super T, ? super T1, ? super T2, R> function3) {
        ObjectHelper.requireNonNull(observableSource, "o1 is null");
        ObjectHelper.requireNonNull(observableSource2, "o2 is null");
        ObjectHelper.requireNonNull(function3, "combiner is null");
        return withLatestFrom((ObservableSource<?>[]) new ObservableSource[]{observableSource, observableSource2}, Functions.toFunction(function3));
    }

    @SchedulerSupport("none")
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return zip(this, observableSource, biFunction);
    }

    @SchedulerSupport("none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        ObjectHelper.requireNonNull(biConsumer, "generator  is null");
        return generate(callable, ObservableInternalHelper.simpleBiGenerator(biConsumer), consumer);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public static Observable<Long> interval(long j6, TimeUnit timeUnit) {
        return interval(j6, j6, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i6) {
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), false, i6, bufferSize()));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i6) {
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), true, i6, bufferSize()));
    }

    @SchedulerSupport("none")
    public final T blockingFirst(T t5) {
        BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T blockingGet = blockingFirstObserver.blockingGet();
        return blockingGet != null ? blockingGet : t5;
    }

    @SchedulerSupport("none")
    public final T blockingLast(T t5) {
        BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
        subscribe(blockingLastObserver);
        T blockingGet = blockingLastObserver.blockingGet();
        return blockingGet != null ? blockingGet : t5;
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Observer<? super T> observer) {
        ObservableBlockingSubscribe.subscribe(this, observer);
    }

    @SchedulerSupport("custom")
    public final Observable<T> delay(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j6, timeUnit, scheduler, false);
    }

    @SchedulerSupport("none")
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z5, int i6) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableGroupBy(this, function, function2, i6, z5));
    }

    @SchedulerSupport("none")
    public final Observable<T> retry(long j6, Predicate<? super Throwable> predicate) {
        if (j6 >= 0) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new ObservableRetryPredicate(this, j6, predicate));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j6);
    }

    @SchedulerSupport("none")
    public final <U> Observable<T> sample(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "sampler is null");
        return RxJavaPlugins.onAssembly(new ObservableSampleWithObservable(this, observableSource));
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    public final Observable<T> skipLast(long j6, TimeUnit timeUnit, boolean z5) {
        return skipLast(j6, timeUnit, Schedulers.trampoline(), z5, bufferSize());
    }

    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(consumer3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2, action, consumer3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    public final Observable<T> takeLast(long j6, long j7, TimeUnit timeUnit) {
        return takeLast(j6, j7, timeUnit, Schedulers.trampoline(), false, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<T> timeout(long j6, TimeUnit timeUnit, ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return timeout0(j6, timeUnit, observableSource, Schedulers.computation());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, V>> callable) {
        return (Single<Map<K, V>>) collect(callable, Functions.toMapKeyValueSelector(function, function2));
    }

    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return toMultimap(function, function2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        return concatArray(observableSource, observableSource2);
    }

    @SchedulerSupport("custom")
    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j6, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return fromFuture(future, j6, timeUnit).subscribeOn(scheduler);
    }

    @SchedulerSupport("custom")
    public static Observable<Long> interval(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return interval(j6, j6, timeUnit, scheduler);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t5, T t6, T t7) {
        ObjectHelper.requireNonNull(t5, "The first item is null");
        ObjectHelper.requireNonNull(t6, "The second item is null");
        ObjectHelper.requireNonNull(t7, "The third item is null");
        return fromArray(t5, t6, t7);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.identity(), false, 2);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.identity(), true, 2);
    }

    @SchedulerSupport("custom")
    public final Observable<T> delay(long j6, TimeUnit timeUnit, Scheduler scheduler, boolean z5) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableDelay(this, j6, timeUnit, scheduler, z5));
    }

    @SchedulerSupport("none")
    public final Observable<T> doOnEach(Consumer<? super Notification<T>> consumer) {
        ObjectHelper.requireNonNull(consumer, "consumer is null");
        return doOnEach(Functions.notificationOnNext(consumer), Functions.notificationOnError(consumer), Functions.notificationOnComplete(consumer), Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i6, long j6, TimeUnit timeUnit) {
        return replay(function, i6, j6, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    public final Observable<T> skipLast(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return skipLast(j6, timeUnit, scheduler, false, bufferSize());
    }

    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j6, long j7, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j6, j7, timeUnit, scheduler, false, bufferSize());
    }

    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList(int i6) {
        return toSortedList(Functions.naturalOrder(), i6);
    }

    @SchedulerSupport("none")
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z5) {
        return zip(this, observableSource, biFunction, z5);
    }

    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatest(observableSourceArr, function, bufferSize());
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        return concatArray(observableSource, observableSource2, observableSource3);
    }

    @SchedulerSupport("none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        return generate(callable, biFunction, Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        return zipArray(Functions.toFunction(biFunction), false, bufferSize(), observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    public final <U extends Collection<? super T>> Observable<U> buffer(int i6, Callable<U> callable) {
        return buffer(i6, i6, callable);
    }

    @SchedulerSupport("custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i6, long j6, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.verifyPositive(i6, "bufferSize");
        ObjectHelper.requireNonNull(function, "selector is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i6, j6, timeUnit, scheduler), function);
    }

    @SchedulerSupport("custom")
    public final Observable<T> skipLast(long j6, TimeUnit timeUnit, Scheduler scheduler, boolean z5) {
        return skipLast(j6, timeUnit, scheduler, z5, bufferSize());
    }

    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j6, long j7, TimeUnit timeUnit, Scheduler scheduler, boolean z5, int i6) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        if (j6 >= 0) {
            return RxJavaPlugins.onAssembly(new ObservableTakeLastTimed(this, j6, j7, timeUnit, scheduler, i6, z5));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j6);
    }

    @SchedulerSupport("custom")
    public final Observable<T> timeout(long j6, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return timeout0(j6, timeUnit, observableSource, scheduler);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<Observable<T>> window(long j6, long j7, TimeUnit timeUnit) {
        return window(j6, j7, timeUnit, Schedulers.computation(), bufferSize());
    }

    @SchedulerSupport("none")
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z5, int i6) {
        return zip(this, observableSource, biFunction, z5, i6);
    }

    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i6) {
        ObjectHelper.requireNonNull(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableCombineLatest(observableSourceArr, null, function, i6 << 1, false));
    }

    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(iterable, function, bufferSize());
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        return concatArray(observableSource, observableSource2, observableSource3, observableSource4);
    }

    @SchedulerSupport("none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        ObjectHelper.requireNonNull(callable, "initialState is null");
        ObjectHelper.requireNonNull(biFunction, "generator  is null");
        ObjectHelper.requireNonNull(consumer, "disposeState is null");
        return RxJavaPlugins.onAssembly(new ObservableGenerate(callable, biFunction, consumer));
    }

    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, int i6) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.equalsPredicate(), i6);
    }

    @SchedulerSupport("none")
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z5) {
        return zipArray(Functions.toFunction(biFunction), z5, bufferSize(), observableSource, observableSource2);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<List<T>> buffer(long j6, long j7, TimeUnit timeUnit) {
        return (Observable<List<T>>) buffer(j6, j7, timeUnit, Schedulers.computation(), ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    public final Observable<T> doOnEach(Observer<? super T> observer) {
        ObjectHelper.requireNonNull(observer, "observer is null");
        return doOnEach(ObservableInternalHelper.observerOnNext(observer), ObservableInternalHelper.observerOnError(observer), ObservableInternalHelper.observerOnComplete(observer), Functions.EMPTY_ACTION);
    }

    @SchedulerSupport("none")
    public final Observable<T> retry(Predicate<? super Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    @SchedulerSupport("custom")
    public final Observable<T> skipLast(long j6, TimeUnit timeUnit, Scheduler scheduler, boolean z5, int i6) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableSkipLastTimed(this, j6, timeUnit, scheduler, i6 << 1, z5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, Collection<V>>> callable, Function<? super K, ? extends Collection<? super V>> function3) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.requireNonNull(callable, "mapSupplier is null");
        ObjectHelper.requireNonNull(function3, "collectionFactory is null");
        return (Single<Map<K, Collection<V>>>) collect(callable, Functions.toMultimapKeyValueSelector(function, function2, function3));
    }

    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j6, long j7, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j6, j7, timeUnit, scheduler, bufferSize());
    }

    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i6) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableCombineLatest(null, iterable, function, i6 << 1, true));
    }

    @SchedulerSupport("custom")
    public static <T> Observable<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return fromFuture(future).subscribeOn(scheduler);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.identity(), false, 3);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.identity(), true, 3);
    }

    @SchedulerSupport("none")
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z5, int i6) {
        return zipArray(Functions.toFunction(biFunction), z5, i6, observableSource, observableSource2);
    }

    @SchedulerSupport("custom")
    public final Observable<List<T>> buffer(long j6, long j7, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<List<T>>) buffer(j6, j7, timeUnit, scheduler, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    public final <U, V> Observable<T> delay(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        return delaySubscription(observableSource).delay(function);
    }

    @SchedulerSupport("custom")
    public final Observable<T> timeout(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j6, timeUnit, null, scheduler);
    }

    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j6, long j7, TimeUnit timeUnit, Scheduler scheduler, int i6) {
        ObjectHelper.verifyPositive(j6, "timespan");
        ObjectHelper.verifyPositive(j7, "timeskip");
        ObjectHelper.verifyPositive(i6, "bufferSize");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return RxJavaPlugins.onAssembly(new ObservableWindowTimed(this, j6, j7, timeUnit, scheduler, Long.MAX_VALUE, i6, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    public final <T1, T2, T3, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        ObjectHelper.requireNonNull(observableSource, "o1 is null");
        ObjectHelper.requireNonNull(observableSource2, "o2 is null");
        ObjectHelper.requireNonNull(observableSource3, "o3 is null");
        ObjectHelper.requireNonNull(function4, "combiner is null");
        return withLatestFrom((ObservableSource<?>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3}, Functions.toFunction(function4));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t5, T t6, T t7, T t8) {
        ObjectHelper.requireNonNull(t5, "The first item is null");
        ObjectHelper.requireNonNull(t6, "The second item is null");
        ObjectHelper.requireNonNull(t7, "The third item is null");
        ObjectHelper.requireNonNull(t8, "The fourth item is null");
        return fromArray(t5, t6, t7, t8);
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        return zipArray(Functions.toFunction(function3), false, bufferSize(), observableSource, observableSource2, observableSource3);
    }

    @SchedulerSupport("custom")
    public final <U extends Collection<? super T>> Observable<U> buffer(long j6, long j7, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBufferTimed(this, j6, j7, timeUnit, scheduler, callable, Integer.MAX_VALUE, false));
    }

    @SchedulerSupport("custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i6, Scheduler scheduler) {
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i6), ObservableInternalHelper.replayFunction(function, scheduler));
    }

    @SchedulerSupport("none")
    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        ObjectHelper.requireNonNull(observableSource, "firstTimeoutIndicator is null");
        return timeout0(observableSource, function, null);
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        return zipArray(Functions.toFunction(function4), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j6, TimeUnit timeUnit) {
        return replay(function, j6, timeUnit, Schedulers.computation());
    }

    @Override // io.reactivex.ObservableSource
    @SchedulerSupport("none")
    public final void subscribe(Observer<? super T> observer) {
        ObjectHelper.requireNonNull(observer, "observer is null");
        try {
            Observer<? super T> onSubscribe = RxJavaPlugins.onSubscribe(this, observer);
            ObjectHelper.requireNonNull(onSubscribe, "Plugin returned null Observer");
            subscribeActual(onSubscribe);
        } catch (NullPointerException e6) {
            throw e6;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        return zipArray(Functions.toFunction(function5), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        ObjectHelper.requireNonNull(function, "onNextMapper is null");
        ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable));
    }

    @SchedulerSupport("custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j6, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, j6, timeUnit, scheduler), function);
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    public final Observable<T> takeLast(long j6, TimeUnit timeUnit) {
        return takeLast(j6, timeUnit, Schedulers.trampoline(), false, bufferSize());
    }

    @SchedulerSupport("none")
    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, "firstTimeoutIndicator is null");
        ObjectHelper.requireNonNull(observableSource2, "other is null");
        return timeout0(observableSource, function, observableSource2);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.identity(), false, 4);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.identity(), true, 4);
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        return zipArray(Functions.toFunction(function6), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    public final Observable<T> takeLast(long j6, TimeUnit timeUnit, boolean z5) {
        return takeLast(j6, timeUnit, Schedulers.trampoline(), z5, bufferSize());
    }

    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(function, function2, callable, ArrayListSupplier.asFunction());
    }

    @SchedulerSupport("none")
    public static <T1, T2, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        return combineLatest(Functions.toFunction(biFunction), bufferSize(), observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        return zipArray(Functions.toFunction(function7), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<List<T>> buffer(long j6, TimeUnit timeUnit) {
        return buffer(j6, timeUnit, Schedulers.computation(), Integer.MAX_VALUE);
    }

    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j6, timeUnit, scheduler, false, bufferSize());
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        return combineLatest(Functions.toFunction(function3), bufferSize(), observableSource, observableSource2, observableSource3);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t5, T t6, T t7, T t8, T t9) {
        ObjectHelper.requireNonNull(t5, "The first item is null");
        ObjectHelper.requireNonNull(t6, "The second item is null");
        ObjectHelper.requireNonNull(t7, "The third item is null");
        ObjectHelper.requireNonNull(t8, "The fourth item is null");
        ObjectHelper.requireNonNull(t9, "The fifth item is null");
        return fromArray(t5, t6, t7, t8, t9);
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        return zipArray(Functions.toFunction(function8), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<List<T>> buffer(long j6, TimeUnit timeUnit, int i6) {
        return buffer(j6, timeUnit, Schedulers.computation(), i6);
    }

    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j6, TimeUnit timeUnit, Scheduler scheduler, boolean z5) {
        return takeLast(j6, timeUnit, scheduler, z5, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<Observable<T>> window(long j6, TimeUnit timeUnit) {
        return window(j6, timeUnit, Schedulers.computation(), Long.MAX_VALUE, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, ObservableSource<T4> observableSource4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        ObjectHelper.requireNonNull(observableSource, "o1 is null");
        ObjectHelper.requireNonNull(observableSource2, "o2 is null");
        ObjectHelper.requireNonNull(observableSource3, "o3 is null");
        ObjectHelper.requireNonNull(observableSource4, "o4 is null");
        ObjectHelper.requireNonNull(function5, "combiner is null");
        return withLatestFrom((ObservableSource<?>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4}, Functions.toFunction(function5));
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        return combineLatest(Functions.toFunction(function4), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        return zipArray(Functions.toFunction(function9), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }

    @SchedulerSupport("custom")
    public final Observable<List<T>> buffer(long j6, TimeUnit timeUnit, Scheduler scheduler, int i6) {
        return (Observable<List<T>>) buffer(j6, timeUnit, scheduler, i6, ArrayListSupplier.asCallable(), false);
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable, int i6) {
        ObjectHelper.requireNonNull(function, "onNextMapper is null");
        ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable), i6);
    }

    @SchedulerSupport("custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this), ObservableInternalHelper.replayFunction(function, scheduler));
    }

    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j6, TimeUnit timeUnit, Scheduler scheduler, boolean z5, int i6) {
        return takeLast(Long.MAX_VALUE, j6, timeUnit, scheduler, z5, i6);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<Observable<T>> window(long j6, TimeUnit timeUnit, long j7) {
        return window(j6, timeUnit, Schedulers.computation(), j7, false);
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        return combineLatest(Functions.toFunction(function5), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    @SchedulerSupport("custom")
    public final <U extends Collection<? super T>> Observable<U> buffer(long j6, TimeUnit timeUnit, Scheduler scheduler, int i6, Callable<U> callable, boolean z5) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        ObjectHelper.verifyPositive(i6, "count");
        return RxJavaPlugins.onAssembly(new ObservableBufferTimed(this, j6, j6, timeUnit, scheduler, callable, i6, z5));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final Observable<Observable<T>> window(long j6, TimeUnit timeUnit, long j7, boolean z5) {
        return window(j6, timeUnit, Schedulers.computation(), j7, z5);
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        return combineLatest(Functions.toFunction(function6), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j6, timeUnit, scheduler, Long.MAX_VALUE, false);
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        return combineLatest(Functions.toFunction(function7), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    @SchedulerSupport("none")
    public final ConnectableObservable<T> replay(int i6) {
        return ObservableReplay.create(this, i6);
    }

    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j6, TimeUnit timeUnit, Scheduler scheduler, long j7) {
        return window(j6, timeUnit, scheduler, j7, false);
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        return combineLatest(Functions.toFunction(function8), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i6) {
        return flatMap((Function) function, false, i6, bufferSize());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final ConnectableObservable<T> replay(int i6, long j6, TimeUnit timeUnit) {
        return replay(i6, j6, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j6, TimeUnit timeUnit, Scheduler scheduler, long j7, boolean z5) {
        return window(j6, timeUnit, scheduler, j7, z5, bufferSize());
    }

    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        return combineLatest(Functions.toFunction(function9), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t5, T t6, T t7, T t8, T t9, T t10) {
        ObjectHelper.requireNonNull(t5, "The first item is null");
        ObjectHelper.requireNonNull(t6, "The second item is null");
        ObjectHelper.requireNonNull(t7, "The third item is null");
        ObjectHelper.requireNonNull(t8, "The fourth item is null");
        ObjectHelper.requireNonNull(t9, "The fifth item is null");
        ObjectHelper.requireNonNull(t10, "The sixth item is null");
        return fromArray(t5, t6, t7, t8, t9, t10);
    }

    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return flatMap(function, biFunction, false, bufferSize(), bufferSize());
    }

    @SchedulerSupport("custom")
    public final ConnectableObservable<T> replay(int i6, long j6, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.verifyPositive(i6, "bufferSize");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.create(this, j6, timeUnit, scheduler, i6);
    }

    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j6, TimeUnit timeUnit, Scheduler scheduler, long j7, boolean z5, int i6) {
        ObjectHelper.verifyPositive(i6, "bufferSize");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.verifyPositive(j7, "count");
        return RxJavaPlugins.onAssembly(new ObservableWindowTimed(this, j6, j6, timeUnit, scheduler, j7, i6, z5));
    }

    @SchedulerSupport("custom")
    public final Observable<List<T>> buffer(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<List<T>>) buffer(j6, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z5) {
        return flatMap(function, biFunction, z5, bufferSize(), bufferSize());
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> withLatestFrom(ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        ObjectHelper.requireNonNull(observableSourceArr, "others is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        return RxJavaPlugins.onAssembly(new ObservableWithLatestFromMany(this, observableSourceArr, function));
    }

    @SchedulerSupport("none")
    public final <TOpening, TClosing> Observable<List<T>> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function) {
        return (Observable<List<T>>) buffer(observableSource, function, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z5, int i6) {
        return flatMap(function, biFunction, z5, i6, bufferSize());
    }

    @SchedulerSupport("none")
    public final <TOpening, TClosing, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function, Callable<U> callable) {
        ObjectHelper.requireNonNull(observableSource, "openingIndicator is null");
        ObjectHelper.requireNonNull(function, "closingIndicator is null");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBufferBoundary(this, observableSource, function, callable));
    }

    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z5, int i6, int i7) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.requireNonNull(biFunction, "combiner is null");
        return flatMap(ObservableInternalHelper.flatMapWithCombiner(function, biFunction), z5, i6, i7);
    }

    @SchedulerSupport("custom")
    public final ConnectableObservable<T> replay(int i6, Scheduler scheduler) {
        return ObservableReplay.observeOn(replay(i6), scheduler);
    }

    @SchedulerSupport("none")
    public final <R> Observable<R> withLatestFrom(Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        ObjectHelper.requireNonNull(iterable, "others is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        return RxJavaPlugins.onAssembly(new ObservableWithLatestFromMany(this, iterable, function));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    public final ConnectableObservable<T> replay(long j6, TimeUnit timeUnit) {
        return replay(j6, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("none")
    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource) {
        return window(observableSource, bufferSize());
    }

    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i6) {
        return flatMap(function, biFunction, false, i6, bufferSize());
    }

    @SchedulerSupport("custom")
    public final ConnectableObservable<T> replay(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.create(this, j6, timeUnit, scheduler);
    }

    @SchedulerSupport("none")
    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource, int i6) {
        ObjectHelper.requireNonNull(observableSource, "boundary is null");
        return RxJavaPlugins.onAssembly(new ObservableWindowBoundary(this, observableSource, i6));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t5, T t6, T t7, T t8, T t9, T t10, T t11) {
        ObjectHelper.requireNonNull(t5, "The first item is null");
        ObjectHelper.requireNonNull(t6, "The second item is null");
        ObjectHelper.requireNonNull(t7, "The third item is null");
        ObjectHelper.requireNonNull(t8, "The fourth item is null");
        ObjectHelper.requireNonNull(t9, "The fifth item is null");
        ObjectHelper.requireNonNull(t10, "The sixth item is null");
        ObjectHelper.requireNonNull(t11, "The seventh item is null");
        return fromArray(t5, t6, t7, t8, t9, t10, t11);
    }

    @SchedulerSupport("none")
    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource) {
        return (Observable<List<T>>) buffer(observableSource, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource, int i6) {
        return (Observable<List<T>>) buffer(observableSource, Functions.createArrayList(i6));
    }

    @SchedulerSupport("none")
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function) {
        return window(observableSource, function, bufferSize());
    }

    @SchedulerSupport("none")
    public final <B, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<B> observableSource, Callable<U> callable) {
        ObjectHelper.requireNonNull(observableSource, "boundary is null");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBufferExactBoundary(this, observableSource, callable));
    }

    @SchedulerSupport("custom")
    public final ConnectableObservable<T> replay(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.observeOn(replay(), scheduler);
    }

    @SchedulerSupport("none")
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function, int i6) {
        ObjectHelper.requireNonNull(observableSource, "openingIndicator is null");
        ObjectHelper.requireNonNull(function, "closingIndicator is null");
        return RxJavaPlugins.onAssembly(new ObservableWindowBoundarySelector(this, observableSource, function, i6));
    }

    @SchedulerSupport("none")
    public final <B> Observable<List<T>> buffer(Callable<? extends ObservableSource<B>> callable) {
        return (Observable<List<T>>) buffer(callable, ArrayListSupplier.asCallable());
    }

    @SchedulerSupport("none")
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable) {
        return window(callable, bufferSize());
    }

    @SchedulerSupport("none")
    public final <B, U extends Collection<? super T>> Observable<U> buffer(Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        ObjectHelper.requireNonNull(callable, "boundarySupplier is null");
        ObjectHelper.requireNonNull(callable2, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBufferBoundarySupplier(this, callable, callable2));
    }

    @SchedulerSupport("none")
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable, int i6) {
        ObjectHelper.requireNonNull(callable, "boundary is null");
        return RxJavaPlugins.onAssembly(new ObservableWindowBoundarySupplier(this, callable, i6));
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t5, T t6, T t7, T t8, T t9, T t10, T t11, T t12) {
        ObjectHelper.requireNonNull(t5, "The first item is null");
        ObjectHelper.requireNonNull(t6, "The second item is null");
        ObjectHelper.requireNonNull(t7, "The third item is null");
        ObjectHelper.requireNonNull(t8, "The fourth item is null");
        ObjectHelper.requireNonNull(t9, "The fifth item is null");
        ObjectHelper.requireNonNull(t10, "The sixth item is null");
        ObjectHelper.requireNonNull(t11, "The seventh item is null");
        ObjectHelper.requireNonNull(t12, "The eighth item is null");
        return fromArray(t5, t6, t7, t8, t9, t10, t11, t12);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t5, T t6, T t7, T t8, T t9, T t10, T t11, T t12, T t13) {
        ObjectHelper.requireNonNull(t5, "The first item is null");
        ObjectHelper.requireNonNull(t6, "The second item is null");
        ObjectHelper.requireNonNull(t7, "The third item is null");
        ObjectHelper.requireNonNull(t8, "The fourth item is null");
        ObjectHelper.requireNonNull(t9, "The fifth item is null");
        ObjectHelper.requireNonNull(t10, "The sixth item is null");
        ObjectHelper.requireNonNull(t11, "The seventh item is null");
        ObjectHelper.requireNonNull(t12, "The eighth item is null");
        ObjectHelper.requireNonNull(t13, "The ninth item is null");
        return fromArray(t5, t6, t7, t8, t9, t10, t11, t12, t13);
    }

    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t5, T t6, T t7, T t8, T t9, T t10, T t11, T t12, T t13, T t14) {
        ObjectHelper.requireNonNull(t5, "The first item is null");
        ObjectHelper.requireNonNull(t6, "The second item is null");
        ObjectHelper.requireNonNull(t7, "The third item is null");
        ObjectHelper.requireNonNull(t8, "The fourth item is null");
        ObjectHelper.requireNonNull(t9, "The fifth item is null");
        ObjectHelper.requireNonNull(t10, "The sixth item is null");
        ObjectHelper.requireNonNull(t11, "The seventh item is null");
        ObjectHelper.requireNonNull(t12, "The eighth item is null");
        ObjectHelper.requireNonNull(t13, "The ninth item is null");
        ObjectHelper.requireNonNull(t14, "The tenth item is null");
        return fromArray(t5, t6, t7, t8, t9, t10, t11, t12, t13, t14);
    }
}
