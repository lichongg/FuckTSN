package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableSkipLast<T> extends AbstractFlowableWithUpstream<T, T> {
    final int skip;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -3807491841935125653L;
        final Subscriber<? super T> actual;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43214s;
        final int skip;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43214s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.skip == size()) {
                this.actual.onNext(poll());
            } else {
                this.f43214s.request(1L);
            }
            offer(t5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43214s, subscription)) {
                this.f43214s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43214s.request(j6);
        }

        SkipLastSubscriber(Subscriber<? super T> subscriber, int i6) {
            super(i6);
            this.actual = subscriber;
            this.skip = i6;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SkipLastSubscriber(subscriber, this.skip));
    }

    public FlowableSkipLast(Publisher<T> publisher, int i6) {
        super(publisher);
        this.skip = i6;
    }
}
