package io.reactivex.internal.util;

import io.reactivex.Observer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface ObservableQueueDrain<T, U> {
    void accept(Observer<? super U> observer, T t5);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i6);
}
