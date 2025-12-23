package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import org.reactivestreams.Publisher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> implements HasUpstreamPublisher<T> {
    protected final Publisher<T> source;

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public final Publisher<T> source() {
        return this.source;
    }

    AbstractFlowableWithUpstream(Publisher<T> publisher) {
        this.source = (Publisher) ObjectHelper.requireNonNull(publisher, "source is null");
    }
}
