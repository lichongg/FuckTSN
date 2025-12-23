package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableFromObservable<T> extends Flowable<T> {
    private final Observable<T> upstream;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SubscriberObserver<T> implements Observer<T>, Subscription {

        /* renamed from: d, reason: collision with root package name */
        private Disposable f43182d;

        /* renamed from: s, reason: collision with root package name */
        private final Subscriber<? super T> f43183s;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43182d.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f43183s.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f43183s.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            this.f43183s.onNext(t5);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f43182d = disposable;
            this.f43183s.onSubscribe(this);
        }

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.f43183s = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.upstream.subscribe(new SubscriberObserver(subscriber));
    }

    public FlowableFromObservable(Observable<T> observable) {
        this.upstream = observable;
    }
}
