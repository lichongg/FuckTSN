package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final /* synthetic */ class EventBus$$Lambda$1 implements Runnable {
    private final Map.Entry arg$1;
    private final Event arg$2;

    public static Runnable lambdaFactory$(Map.Entry entry, Event event) {
        return new EventBus$$Lambda$1(entry, event);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((EventHandler) this.arg$1.getKey()).handle(this.arg$2);
    }

    private EventBus$$Lambda$1(Map.Entry entry, Event event) {
        this.arg$1 = entry;
        this.arg$2 = event;
    }
}
