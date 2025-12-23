package io.reactivex.internal.operators.flowable;

import androidx.camera.view.p;
import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> {
    final AtomicBoolean once;
    final CacheState<T> state;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class CacheState<T> extends LinkedArrayList implements Subscriber<T> {
        static final ReplaySubscription[] EMPTY = new ReplaySubscription[0];
        static final ReplaySubscription[] TERMINATED = new ReplaySubscription[0];
        final AtomicReference<Subscription> connection;
        volatile boolean isConnected;
        final Flowable<? extends T> source;
        boolean sourceDone;
        final AtomicReference<ReplaySubscription<T>[]> subscribers;

        public void addChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.subscribers.get();
                if (replaySubscriptionArr == TERMINATED) {
                    return;
                }
                int length = replaySubscriptionArr.length;
                replaySubscriptionArr2 = new ReplaySubscription[length + 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
                replaySubscriptionArr2[length] = replaySubscription;
            } while (!p.a(this.subscribers, replaySubscriptionArr, replaySubscriptionArr2));
        }

        public void connect() {
            this.source.subscribe(this);
            this.isConnected = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.sourceDone) {
                return;
            }
            this.sourceDone = true;
            add(NotificationLite.complete());
            SubscriptionHelper.cancel(this.connection);
            for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
                replaySubscription.replay();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.sourceDone) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.sourceDone = true;
            add(NotificationLite.error(th));
            SubscriptionHelper.cancel(this.connection);
            for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
                replaySubscription.replay();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.sourceDone) {
                return;
            }
            add(NotificationLite.next(t5));
            for (ReplaySubscription<T> replaySubscription : this.subscribers.get()) {
                replaySubscription.replay();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.connection, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void removeChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.subscribers.get();
                int length = replaySubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        i6 = -1;
                        break;
                    } else if (replaySubscriptionArr[i6].equals(replaySubscription)) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i6 < 0 || length == 1) {
                    return;
                }
                replaySubscriptionArr2 = new ReplaySubscription[length - 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, i6);
                System.arraycopy(replaySubscriptionArr, i6 + 1, replaySubscriptionArr2, i6, (length - i6) - 1);
            } while (!p.a(this.subscribers, replaySubscriptionArr, replaySubscriptionArr2));
        }

        CacheState(Flowable<? extends T> flowable, int i6) {
            super(i6);
            this.connection = new AtomicReference<>();
            this.source = flowable;
            this.subscribers = new AtomicReference<>(EMPTY);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long CANCELLED = -1;
        private static final long serialVersionUID = -2557562030197141021L;
        final Subscriber<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final AtomicLong requested = new AtomicLong();
        final CacheState<T> state;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.requested.getAndSet(-1L) != -1) {
                this.state.removeChild(this);
            }
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.child;
            AtomicLong atomicLong = this.requested;
            int i6 = 1;
            int i7 = 1;
            while (true) {
                long j6 = atomicLong.get();
                if (j6 < 0) {
                    return;
                }
                int size = this.state.size();
                if (size != 0) {
                    Object[] objArr = this.currentBuffer;
                    if (objArr == null) {
                        objArr = this.state.head();
                        this.currentBuffer = objArr;
                    }
                    int length = objArr.length - i6;
                    int i8 = this.index;
                    int i9 = this.currentIndexInBuffer;
                    int i10 = 0;
                    while (i8 < size && j6 > 0) {
                        if (atomicLong.get() == -1) {
                            return;
                        }
                        if (i9 == length) {
                            objArr = (Object[]) objArr[length];
                            i9 = 0;
                        }
                        if (NotificationLite.accept(objArr[i9], subscriber)) {
                            return;
                        }
                        i9++;
                        i8++;
                        j6--;
                        i10++;
                    }
                    if (atomicLong.get() == -1) {
                        return;
                    }
                    if (j6 == 0) {
                        Object obj = objArr[i9];
                        if (NotificationLite.isComplete(obj)) {
                            subscriber.onComplete();
                            return;
                        } else if (NotificationLite.isError(obj)) {
                            subscriber.onError(NotificationLite.getError(obj));
                            return;
                        }
                    }
                    if (i10 != 0) {
                        BackpressureHelper.producedCancel(atomicLong, i10);
                    }
                    this.index = i8;
                    this.currentIndexInBuffer = i9;
                    this.currentBuffer = objArr;
                }
                i7 = addAndGet(-i7);
                if (i7 == 0) {
                    return;
                } else {
                    i6 = 1;
                }
            }
        }

        ReplaySubscription(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            this.child = subscriber;
            this.state = cacheState;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            long j7;
            if (SubscriptionHelper.validate(j6)) {
                do {
                    j7 = this.requested.get();
                    if (j7 != -1) {
                    } else {
                        return;
                    }
                } while (!this.requested.compareAndSet(j7, BackpressureHelper.addCap(j7, j6)));
                replay();
            }
        }
    }

    int cachedEventCount() {
        return this.state.size();
    }

    boolean hasSubscribers() {
        return this.state.subscribers.get().length != 0;
    }

    boolean isConnected() {
        return this.state.isConnected;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(subscriber, this.state);
        this.state.addChild(replaySubscription);
        subscriber.onSubscribe(replaySubscription);
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            return;
        }
        this.state.connect();
    }

    public FlowableCache(Flowable<T> flowable, int i6) {
        super(flowable);
        this.state = new CacheState<>(flowable, i6);
        this.once = new AtomicBoolean();
    }
}
