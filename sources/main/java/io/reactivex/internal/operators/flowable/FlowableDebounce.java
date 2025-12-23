package io.reactivex.internal.operators.flowable;

import androidx.camera.view.p;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableDebounce<T, U> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, ? extends Publisher<U>> debounceSelector;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DebounceSubscriber<T, U> extends AtomicLong implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = 6725975399620862591L;
        final Subscriber<? super T> actual;
        final Function<? super T, ? extends Publisher<U>> debounceSelector;
        final AtomicReference<Disposable> debouncer = new AtomicReference<>();
        boolean done;
        volatile long index;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43164s;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class DebounceInnerSubscriber<T, U> extends DisposableSubscriber<U> {
            boolean done;
            final long index;
            final AtomicBoolean once = new AtomicBoolean();
            final DebounceSubscriber<T, U> parent;
            final T value;

            void emit() {
                if (this.once.compareAndSet(false, true)) {
                    this.parent.emit(this.index, this.value);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (this.done) {
                    return;
                }
                this.done = true;
                emit();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.done = true;
                    this.parent.onError(th);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(U u5) {
                if (this.done) {
                    return;
                }
                this.done = true;
                cancel();
                emit();
            }

            DebounceInnerSubscriber(DebounceSubscriber<T, U> debounceSubscriber, long j6, T t5) {
                this.parent = debounceSubscriber;
                this.index = j6;
                this.value = t5;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43164s.cancel();
            DisposableHelper.dispose(this.debouncer);
        }

        void emit(long j6, T t5) {
            if (j6 == this.index) {
                if (get() != 0) {
                    this.actual.onNext(t5);
                    BackpressureHelper.produced(this, 1L);
                } else {
                    cancel();
                    this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            Disposable disposable = this.debouncer.get();
            if (DisposableHelper.isDisposed(disposable)) {
                return;
            }
            ((DebounceInnerSubscriber) disposable).emit();
            DisposableHelper.dispose(this.debouncer);
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.debouncer);
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            long j6 = this.index + 1;
            this.index = j6;
            Disposable disposable = this.debouncer.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.debounceSelector.apply(t5), "The publisher supplied is null");
                DebounceInnerSubscriber debounceInnerSubscriber = new DebounceInnerSubscriber(this, j6, t5);
                if (p.a(this.debouncer, disposable, debounceInnerSubscriber)) {
                    publisher.subscribe(debounceInnerSubscriber);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43164s, subscription)) {
                this.f43164s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        DebounceSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<U>> function) {
            this.actual = subscriber;
            this.debounceSelector = function;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this, j6);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DebounceSubscriber(new SerializedSubscriber(subscriber), this.debounceSelector));
    }

    public FlowableDebounce(Publisher<T> publisher, Function<? super T, ? extends Publisher<U>> function) {
        super(publisher);
        this.debounceSelector = function;
    }
}
