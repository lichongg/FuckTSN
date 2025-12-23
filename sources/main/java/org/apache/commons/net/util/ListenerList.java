package org.apache.commons.net.util;

import java.io.Serializable;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ListenerList implements Serializable, Iterable<EventListener> {
    private static final long serialVersionUID = -1934227607974228213L;
    private final CopyOnWriteArrayList<EventListener> __listeners = new CopyOnWriteArrayList<>();

    public void addListener(EventListener eventListener) {
        this.__listeners.add(eventListener);
    }

    public int getListenerCount() {
        return this.__listeners.size();
    }

    @Override // java.lang.Iterable
    public Iterator<EventListener> iterator() {
        return this.__listeners.iterator();
    }

    public void removeListener(EventListener eventListener) {
        this.__listeners.remove(eventListener);
    }
}
