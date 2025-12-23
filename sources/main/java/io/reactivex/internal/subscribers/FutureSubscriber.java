package io.reactivex.internal.subscribers;

import androidx.camera.view.p;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FutureSubscriber<T> extends CountDownLatch implements Subscriber<T>, Future<T>, Subscription {
    Throwable error;

    /* renamed from: s, reason: collision with root package name */
    final AtomicReference<Subscription> f43405s;
    T value;

    public FutureSubscriber() {
        super(1);
        this.f43405s = new AtomicReference<>();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.error;
        if (th == null) {
            return this.value;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        Subscription subscription;
        SubscriptionHelper subscriptionHelper;
        do {
            subscription = this.f43405s.get();
            if (subscription == this || subscription == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
                return false;
            }
        } while (!p.a(this.f43405s, subscription, subscriptionHelper));
        if (subscription != null) {
            subscription.cancel();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return SubscriptionHelper.isCancelled(this.f43405s.get());
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription subscription;
        if (this.value == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            subscription = this.f43405s.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                return;
            }
        } while (!p.a(this.f43405s, subscription, this));
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Subscription subscription;
        do {
            subscription = this.f43405s.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
        } while (!p.a(this.f43405s, subscription, this));
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t5) {
        if (this.value == null) {
            this.value = t5;
        } else {
            this.f43405s.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f43405s, subscription)) {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        if (getCount() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get(long j6, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0 && !await(j6, timeUnit)) {
            throw new TimeoutException();
        }
        if (!isCancelled()) {
            Throwable th = this.error;
            if (th == null) {
                return this.value;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j6) {
    }
}
