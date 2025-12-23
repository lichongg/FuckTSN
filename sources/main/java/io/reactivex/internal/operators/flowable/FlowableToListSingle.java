package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToFlowable<U> {
    final Callable<U> collectionSupplier;
    final Publisher<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ToListSubscriber<T, U extends Collection<? super T>> implements Subscriber<T>, Disposable {
        final SingleObserver<? super U> actual;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43233s;
        U value;

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.value = null;
            this.f43233s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f43233s.cancel();
            this.f43233s = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f43233s == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f43233s = SubscriptionHelper.CANCELLED;
            this.actual.onSuccess(this.value);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.value.add(t5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43233s, subscription)) {
                this.f43233s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        ToListSubscriber(SingleObserver<? super U> singleObserver, U u5) {
            this.actual = singleObserver;
            this.value = u5;
        }
    }

    public FlowableToListSingle(Publisher<T> publisher) {
        this(publisher, ArrayListSupplier.asCallable());
    }

    public FlowableToListSingle(Publisher<T> publisher, Callable<U> callable) {
        this.source = publisher;
        this.collectionSupplier = callable;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<U> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableToList(this.source, this.collectionSupplier));
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.source.subscribe(new ToListSubscriber(singleObserver, (Collection) ObjectHelper.requireNonNull(this.collectionSupplier.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
