package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableOnBackpressureLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = 163080509307634843L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43196s;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<T> current = new AtomicReference<>();

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f43196s.cancel();
            if (getAndIncrement() == 0) {
                this.current.lazySet(null);
            }
        }

        boolean checkTerminated(boolean z5, boolean z6, Subscriber<?> subscriber, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z5) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                atomicReference.lazySet(null);
                subscriber.onError(th);
                return true;
            }
            if (!z6) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.current.lazySet(t5);
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43196s, subscription)) {
                this.f43196s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        BackpressureLatestSubscriber(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        void drain() {
            boolean z5;
            boolean z6;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.actual;
                AtomicLong atomicLong = this.requested;
                AtomicReference<T> atomicReference = this.current;
                int i6 = 1;
                do {
                    long j6 = 0;
                    while (true) {
                        z5 = false;
                        if (j6 == atomicLong.get()) {
                            break;
                        }
                        boolean z7 = this.done;
                        T andSet = atomicReference.getAndSet(null);
                        if (andSet == null) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (!checkTerminated(z7, z6, subscriber, atomicReference)) {
                            if (z6) {
                                break;
                            }
                            subscriber.onNext(andSet);
                            j6++;
                        } else {
                            return;
                        }
                    }
                    if (j6 == atomicLong.get()) {
                        boolean z8 = this.done;
                        if (atomicReference.get() == null) {
                            z5 = true;
                        }
                        if (checkTerminated(z8, z5, subscriber, atomicReference)) {
                            return;
                        }
                    }
                    if (j6 != 0) {
                        BackpressureHelper.produced(atomicLong, j6);
                    }
                    i6 = addAndGet(-i6);
                } while (i6 != 0);
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
        this.source.subscribe(new BackpressureLatestSubscriber(subscriber));
    }

    public FlowableOnBackpressureLatest(Publisher<T> publisher) {
        super(publisher);
    }
}
