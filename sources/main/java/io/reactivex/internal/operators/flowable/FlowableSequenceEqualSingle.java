package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final BiPredicate<? super T, ? super T> comparer;
    final Publisher<? extends T> first;
    final int prefetch;
    final Publisher<? extends T> second;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable, FlowableSequenceEqual.EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;
        final SingleObserver<? super Boolean> actual;
        final BiPredicate<? super T, ? super T> comparer;
        final AtomicThrowable error = new AtomicThrowable();
        final FlowableSequenceEqual.EqualSubscriber<T> first;
        final FlowableSequenceEqual.EqualSubscriber<T> second;

        /* renamed from: v1, reason: collision with root package name */
        T f43207v1;

        /* renamed from: v2, reason: collision with root package name */
        T f43208v2;

        void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.first.cancel();
            this.second.cancel();
            if (getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void innerError(Throwable th) {
            if (this.error.addThrowable(th)) {
                drain();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(this.first.get());
        }

        void subscribe(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
            publisher.subscribe(this.first);
            publisher2.subscribe(this.second);
        }

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i6, BiPredicate<? super T, ? super T> biPredicate) {
            this.actual = singleObserver;
            this.comparer = biPredicate;
            this.first = new FlowableSequenceEqual.EqualSubscriber<>(this, i6);
            this.second = new FlowableSequenceEqual.EqualSubscriber<>(this, i6);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void drain() {
            boolean z5;
            if (getAndIncrement() == 0) {
                int i6 = 1;
                do {
                    SimpleQueue<T> simpleQueue = this.first.queue;
                    SimpleQueue<T> simpleQueue2 = this.second.queue;
                    if (simpleQueue != null && simpleQueue2 != null) {
                        while (!isDisposed()) {
                            if (this.error.get() != null) {
                                cancelAndClear();
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                            boolean z6 = this.first.done;
                            T t5 = this.f43207v1;
                            if (t5 == null) {
                                try {
                                    t5 = simpleQueue.poll();
                                    this.f43207v1 = t5;
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    cancelAndClear();
                                    this.error.addThrowable(th);
                                    this.actual.onError(this.error.terminate());
                                    return;
                                }
                            }
                            boolean z7 = false;
                            if (t5 == null) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            boolean z8 = this.second.done;
                            T t6 = this.f43208v2;
                            if (t6 == null) {
                                try {
                                    t6 = simpleQueue2.poll();
                                    this.f43208v2 = t6;
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    cancelAndClear();
                                    this.error.addThrowable(th2);
                                    this.actual.onError(this.error.terminate());
                                    return;
                                }
                            }
                            if (t6 == null) {
                                z7 = true;
                            }
                            if (z6 && z8 && z5 && z7) {
                                this.actual.onSuccess(Boolean.TRUE);
                                return;
                            }
                            if (z6 && z8 && z5 != z7) {
                                cancelAndClear();
                                this.actual.onSuccess(Boolean.FALSE);
                                return;
                            }
                            if (!z5 && !z7) {
                                try {
                                    if (!this.comparer.test(t5, t6)) {
                                        cancelAndClear();
                                        this.actual.onSuccess(Boolean.FALSE);
                                        return;
                                    } else {
                                        this.f43207v1 = null;
                                        this.f43208v2 = null;
                                        this.first.request();
                                        this.second.request();
                                    }
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    cancelAndClear();
                                    this.error.addThrowable(th3);
                                    this.actual.onError(this.error.terminate());
                                    return;
                                }
                            }
                        }
                        this.first.clear();
                        this.second.clear();
                        return;
                    }
                    if (isDisposed()) {
                        this.first.clear();
                        this.second.clear();
                        return;
                    } else if (this.error.get() != null) {
                        cancelAndClear();
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    i6 = addAndGet(-i6);
                } while (i6 != 0);
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSequenceEqual(this.first, this.second, this.comparer, this.prefetch));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.prefetch, this.comparer);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe(this.first, this.second);
    }

    public FlowableSequenceEqualSingle(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i6) {
        this.first = publisher;
        this.second = publisher2;
        this.comparer = biPredicate;
        this.prefetch = i6;
    }
}
