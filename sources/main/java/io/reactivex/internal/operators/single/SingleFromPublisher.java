package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SingleFromPublisher<T> extends Single<T> {
    final Publisher<? extends T> publisher;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ToSingleObserver<T> implements Subscriber<T>, Disposable {
        final SingleObserver<? super T> actual;
        volatile boolean disposed;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43393s;
        T value;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.f43393s.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t5 = this.value;
            this.value = null;
            if (t5 == null) {
                this.actual.onError(new NoSuchElementException("The source Publisher is empty"));
            } else {
                this.actual.onSuccess(t5);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.value = null;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            if (this.value == null) {
                this.value = t5;
                return;
            }
            this.f43393s.cancel();
            this.done = true;
            this.value = null;
            this.actual.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43393s, subscription)) {
                this.f43393s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        ToSingleObserver(SingleObserver<? super T> singleObserver) {
            this.actual = singleObserver;
        }
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.publisher.subscribe(new ToSingleObserver(singleObserver));
    }

    public SingleFromPublisher(Publisher<? extends T> publisher) {
        this.publisher = publisher;
    }
}
