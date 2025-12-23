package com.google.firebase.events;

import com.google.firebase.components.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class Event<T> {
    private final T payload;
    private final Class<T> type;

    public T getPayload() {
        return this.payload;
    }

    public Class<T> getType() {
        return this.type;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.type, this.payload);
    }

    public Event(Class<T> cls, T t5) {
        this.type = (Class) Preconditions.checkNotNull(cls);
        this.payload = (T) Preconditions.checkNotNull(t5);
    }
}
