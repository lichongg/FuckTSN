package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class SubscriberExceptionContext {
    private final Object event;
    private final EventBus eventBus;
    private final Object subscriber;
    private final Method subscriberMethod;

    public Object getEvent() {
        return this.event;
    }

    public EventBus getEventBus() {
        return this.eventBus;
    }

    public Object getSubscriber() {
        return this.subscriber;
    }

    public Method getSubscriberMethod() {
        return this.subscriberMethod;
    }

    SubscriberExceptionContext(EventBus eventBus, Object obj, Object obj2, Method method) {
        this.eventBus = (EventBus) Preconditions.checkNotNull(eventBus);
        this.event = Preconditions.checkNotNull(obj);
        this.subscriber = Preconditions.checkNotNull(obj2);
        this.subscriberMethod = (Method) Preconditions.checkNotNull(method);
    }
}
