package io.reactivex.processors;

import io.reactivex.Flowable;
import org.reactivestreams.Processor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class FlowableProcessor<T> extends Flowable<T> implements Processor<T, T> {
    public abstract Throwable getThrowable();

    public abstract boolean hasComplete();

    public abstract boolean hasSubscribers();

    public abstract boolean hasThrowable();

    public final FlowableProcessor<T> toSerialized() {
        return this instanceof SerializedProcessor ? this : new SerializedProcessor(this);
    }
}
