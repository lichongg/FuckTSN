package com.google.firebase.events;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface Subscriber {
    <T> void subscribe(Class<T> cls, EventHandler<? super T> eventHandler);

    <T> void subscribe(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler);

    <T> void unsubscribe(Class<T> cls, EventHandler<? super T> eventHandler);
}
