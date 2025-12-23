package io.reactivex.internal.util;

import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface QueueDrain<T, U> {
    boolean accept(Subscriber<? super U> subscriber, T t5);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i6);

    long produced(long j6);

    long requested();
}
