package com.trello.rxlifecycle2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import javax.annotation.ParametersAreNonnullByDefault;
import org.reactivestreams.Publisher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ParametersAreNonnullByDefault
/* loaded from: D:\Downloads\app\classes7.dex */
public final class c<T> implements ObservableTransformer<T, T>, FlowableTransformer<T, T>, SingleTransformer<T, T>, MaybeTransformer<T, T>, CompletableTransformer {

    /* renamed from: a, reason: collision with root package name */
    final Observable<?> f40714a;

    @Override // io.reactivex.ObservableTransformer
    public ObservableSource<T> apply(Observable<T> observable) {
        return observable.takeUntil(this.f40714a);
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return flowable.takeUntil(this.f40714a.toFlowable(BackpressureStrategy.LATEST));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f40714a.equals(((c) obj).f40714a);
    }

    public int hashCode() {
        return this.f40714a.hashCode();
    }

    public String toString() {
        return "LifecycleTransformer{observable=" + this.f40714a + '}';
    }

    c(Observable<?> observable) {
        a3.a.a(observable, "observable == null");
        this.f40714a = observable;
    }

    @Override // io.reactivex.SingleTransformer
    public SingleSource<T> apply(Single<T> single) {
        return single.takeUntil(this.f40714a.firstOrError());
    }

    @Override // io.reactivex.MaybeTransformer
    public MaybeSource<T> apply(Maybe<T> maybe) {
        return maybe.takeUntil(this.f40714a.firstElement());
    }

    @Override // io.reactivex.CompletableTransformer
    public CompletableSource apply(Completable completable) {
        return Completable.ambArray(completable, this.f40714a.flatMapCompletable(a.f40699c));
    }
}
