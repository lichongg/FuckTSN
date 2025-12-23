package io.reactivex.processors;

import androidx.camera.view.p;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class PublishProcessor<T> extends FlowableProcessor<T> {
    Throwable error;
    final AtomicReference<PublishSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
    static final PublishSubscription[] TERMINATED = new PublishSubscription[0];
    static final PublishSubscription[] EMPTY = new PublishSubscription[0];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class PublishSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 3562861878281475070L;
        final Subscriber<? super T> actual;
        final PublishProcessor<T> parent;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }

        PublishSubscription(Subscriber<? super T> subscriber, PublishProcessor<T> publishProcessor) {
            this.actual = subscriber;
            this.parent = publishProcessor;
        }

        public boolean isCancelled() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.actual.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.actual.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        public void onNext(T t5) {
            long j6 = get();
            if (j6 != Long.MIN_VALUE) {
                if (j6 != 0) {
                    this.actual.onNext(t5);
                    if (j6 != Long.MAX_VALUE) {
                        decrementAndGet();
                        return;
                    }
                    return;
                }
                cancel();
                this.actual.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.addCancel(this, j6);
            }
        }
    }

    public static <T> PublishProcessor<T> create() {
        return new PublishProcessor<>();
    }

    boolean add(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = this.subscribers.get();
            if (publishSubscriptionArr == TERMINATED) {
                return false;
            }
            int length = publishSubscriptionArr.length;
            publishSubscriptionArr2 = new PublishSubscription[length + 1];
            System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr2, 0, length);
            publishSubscriptionArr2[length] = publishSubscription;
        } while (!p.a(this.subscribers, publishSubscriptionArr, publishSubscriptionArr2));
        return true;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        if (this.subscribers.get() == TERMINATED) {
            return this.error;
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

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        PublishSubscription<T>[] publishSubscriptionArr = this.subscribers.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = TERMINATED;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            return;
        }
        for (PublishSubscription<T> publishSubscription : this.subscribers.getAndSet(publishSubscriptionArr2)) {
            publishSubscription.onComplete();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        PublishSubscription<T>[] publishSubscriptionArr = this.subscribers.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = TERMINATED;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            RxJavaPlugins.onError(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.error = th;
        for (PublishSubscription<T> publishSubscription : this.subscribers.getAndSet(publishSubscriptionArr2)) {
            publishSubscription.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t5) {
        if (this.subscribers.get() == TERMINATED) {
            return;
        }
        if (t5 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        for (PublishSubscription<T> publishSubscription : this.subscribers.get()) {
            publishSubscription.onNext(t5);
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

    void remove(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = this.subscribers.get();
            if (publishSubscriptionArr == TERMINATED || publishSubscriptionArr == EMPTY) {
                return;
            }
            int length = publishSubscriptionArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    i6 = -1;
                    break;
                } else if (publishSubscriptionArr[i6] == publishSubscription) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 < 0) {
                return;
            }
            if (length == 1) {
                publishSubscriptionArr2 = EMPTY;
            } else {
                PublishSubscription[] publishSubscriptionArr3 = new PublishSubscription[length - 1];
                System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr3, 0, i6);
                System.arraycopy(publishSubscriptionArr, i6 + 1, publishSubscriptionArr3, i6, (length - i6) - 1);
                publishSubscriptionArr2 = publishSubscriptionArr3;
            }
        } while (!p.a(this.subscribers, publishSubscriptionArr, publishSubscriptionArr2));
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        PublishSubscription<T> publishSubscription = new PublishSubscription<>(subscriber, this);
        subscriber.onSubscribe(publishSubscription);
        if (add(publishSubscription)) {
            if (publishSubscription.isCancelled()) {
                remove(publishSubscription);
            }
        } else {
            Throwable th = this.error;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        }
    }

    PublishProcessor() {
    }
}
