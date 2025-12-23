package io.reactivex.internal.operators.flowable;

import io.reactivex.Notification;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableMaterialize<T> extends AbstractFlowableWithUpstream<T, Notification<T>> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, Notification<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
        public void onDrop(Notification<T> notification) {
            if (notification.isOnError()) {
                RxJavaPlugins.onError(notification.getError());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.produced++;
            this.actual.onNext(Notification.createOnNext(t5));
        }

        MaterializeSubscriber(Subscriber<? super Notification<T>> subscriber) {
            super(subscriber);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            complete(Notification.createOnComplete());
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            complete(Notification.createOnError(th));
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Notification<T>> subscriber) {
        this.source.subscribe(new MaterializeSubscriber(subscriber));
    }

    public FlowableMaterialize(Publisher<T> publisher) {
        super(publisher);
    }
}
