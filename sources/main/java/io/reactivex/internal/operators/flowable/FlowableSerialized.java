package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.subscribers.SerializedSubscriber;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableSerialized<T> extends AbstractFlowableWithUpstream<T, T> {
    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SerializedSubscriber(subscriber));
    }

    public FlowableSerialized(Flowable<T> flowable) {
        super(flowable);
    }
}
