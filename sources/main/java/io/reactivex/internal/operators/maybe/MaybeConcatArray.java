package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class MaybeConcatArray<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] sources;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;
        final Subscriber<? super T> actual;
        int index;
        long produced;
        final MaybeSource<? extends T>[] sources;
        final AtomicLong requested = new AtomicLong();
        final SequentialDisposable disposables = new SequentialDisposable();
        final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.disposables.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.current.lazySet(NotificationLite.COMPLETE);
            drain();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.disposables.replace(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t5) {
            this.current.lazySet(t5);
            drain();
        }

        ConcatMaybeObserver(Subscriber<? super T> subscriber, MaybeSource<? extends T>[] maybeSourceArr) {
            this.actual = subscriber;
            this.sources = maybeSourceArr;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                AtomicReference<Object> atomicReference = this.current;
                Subscriber<? super T> subscriber = this.actual;
                while (!this.disposables.isDisposed()) {
                    Object obj = atomicReference.get();
                    if (obj != null) {
                        if (obj != NotificationLite.COMPLETE) {
                            long j6 = this.produced;
                            if (j6 != this.requested.get()) {
                                this.produced = j6 + 1;
                                atomicReference.lazySet(null);
                                subscriber.onNext(obj);
                            }
                        } else {
                            atomicReference.lazySet(null);
                        }
                        int i6 = this.index;
                        MaybeSource<? extends T>[] maybeSourceArr = this.sources;
                        if (i6 == maybeSourceArr.length) {
                            subscriber.onComplete();
                            return;
                        } else {
                            this.index = i6 + 1;
                            maybeSourceArr[i6].subscribe(this);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                atomicReference.lazySet(null);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this.requested, j6);
                drain();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, this.sources);
        subscriber.onSubscribe(concatMaybeObserver);
        concatMaybeObserver.drain();
    }

    public MaybeConcatArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.sources = maybeSourceArr;
    }
}
