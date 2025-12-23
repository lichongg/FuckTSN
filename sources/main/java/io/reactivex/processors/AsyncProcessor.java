package io.reactivex.processors;

import androidx.camera.view.p;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class AsyncProcessor<T> extends FlowableProcessor<T> {
    static final AsyncSubscription[] EMPTY = new AsyncSubscription[0];
    static final AsyncSubscription[] TERMINATED = new AsyncSubscription[0];
    Throwable error;
    final AtomicReference<AsyncSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    T value;

    public Object[] getValues() {
        T value = getValue();
        return value != null ? new Object[]{value} : new Object[0];
    }

    void nullOnNext() {
        this.value = null;
        NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        this.error = nullPointerException;
        for (AsyncSubscription<T> asyncSubscription : this.subscribers.getAndSet(TERMINATED)) {
            asyncSubscription.onError(nullPointerException);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncProcessor<T> parent;

        AsyncSubscription(Subscriber<? super T> subscriber, AsyncProcessor<T> asyncProcessor) {
            super(subscriber);
            this.parent = asyncProcessor;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            if (super.tryCancel()) {
                this.parent.remove(this);
            }
        }

        void onComplete() {
            if (!isCancelled()) {
                this.actual.onComplete();
            }
        }

        void onError(Throwable th) {
            if (isCancelled()) {
                RxJavaPlugins.onError(th);
            } else {
                this.actual.onError(th);
            }
        }
    }

    public static <T> AsyncProcessor<T> create() {
        return new AsyncProcessor<>();
    }

    boolean add(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = this.subscribers.get();
            if (asyncSubscriptionArr == TERMINATED) {
                return false;
            }
            int length = asyncSubscriptionArr.length;
            asyncSubscriptionArr2 = new AsyncSubscription[length + 1];
            System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr2, 0, length);
            asyncSubscriptionArr2[length] = asyncSubscription;
        } while (!p.a(this.subscribers, asyncSubscriptionArr, asyncSubscriptionArr2));
        return true;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        if (this.subscribers.get() == TERMINATED) {
            return this.error;
        }
        return null;
    }

    public T getValue() {
        if (this.subscribers.get() == TERMINATED) {
            return this.value;
        }
        return null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.subscribers.get() == TERMINATED && this.error == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.subscribers.get().length != 0;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.subscribers.get() == TERMINATED && this.error != null;
    }

    public boolean hasValue() {
        return this.subscribers.get() == TERMINATED && this.value != null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        AsyncSubscription<T>[] asyncSubscriptionArr = this.subscribers.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = TERMINATED;
        if (asyncSubscriptionArr == asyncSubscriptionArr2) {
            return;
        }
        T t5 = this.value;
        AsyncSubscription<T>[] andSet = this.subscribers.getAndSet(asyncSubscriptionArr2);
        int i6 = 0;
        if (t5 == null) {
            int length = andSet.length;
            while (i6 < length) {
                andSet[i6].onComplete();
                i6++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i6 < length2) {
            andSet[i6].complete(t5);
            i6++;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        AsyncSubscription<T>[] asyncSubscriptionArr = this.subscribers.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = TERMINATED;
        if (asyncSubscriptionArr == asyncSubscriptionArr2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.value = null;
        this.error = th;
        for (AsyncSubscription<T> asyncSubscription : this.subscribers.getAndSet(asyncSubscriptionArr2)) {
            asyncSubscription.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t5) {
        if (this.subscribers.get() == TERMINATED) {
            return;
        }
        if (t5 == null) {
            nullOnNext();
        } else {
            this.value = t5;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.subscribers.get() == TERMINATED) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    void remove(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = this.subscribers.get();
            int length = asyncSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    i6 = -1;
                    break;
                } else if (asyncSubscriptionArr[i6] == asyncSubscription) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 < 0) {
                return;
            }
            if (length == 1) {
                asyncSubscriptionArr2 = EMPTY;
            } else {
                AsyncSubscription[] asyncSubscriptionArr3 = new AsyncSubscription[length - 1];
                System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr3, 0, i6);
                System.arraycopy(asyncSubscriptionArr, i6 + 1, asyncSubscriptionArr3, i6, (length - i6) - 1);
                asyncSubscriptionArr2 = asyncSubscriptionArr3;
            }
        } while (!p.a(this.subscribers, asyncSubscriptionArr, asyncSubscriptionArr2));
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        AsyncSubscription<T> asyncSubscription = new AsyncSubscription<>(subscriber, this);
        subscriber.onSubscribe(asyncSubscription);
        if (add(asyncSubscription)) {
            if (asyncSubscription.isCancelled()) {
                remove(asyncSubscription);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            subscriber.onError(th);
            return;
        }
        T t5 = this.value;
        if (t5 != null) {
            asyncSubscription.complete(t5);
        } else {
            asyncSubscription.onComplete();
        }
    }

    AsyncProcessor() {
    }

    public T[] getValues(T[] tArr) {
        T value = getValue();
        if (value == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 1);
        }
        tArr[0] = value;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }
}
