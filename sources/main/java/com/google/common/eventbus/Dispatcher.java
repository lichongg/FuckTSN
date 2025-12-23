package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class Dispatcher {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.eventbus.Dispatcher$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ImmediateDispatcher extends Dispatcher {
        private static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();

        private ImmediateDispatcher() {
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                it.next().dispatchEvent(obj);
            }
        }
    }

    abstract void dispatch(Object obj, Iterator<Subscriber> it);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class LegacyAsyncDispatcher extends Dispatcher {
        private final ConcurrentLinkedQueue<EventWithSubscriber> queue;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class EventWithSubscriber {
            private final Object event;
            private final Subscriber subscriber;

            /* synthetic */ EventWithSubscriber(Object obj, Subscriber subscriber, AnonymousClass1 anonymousClass1) {
                this(obj, subscriber);
            }

            private EventWithSubscriber(Object obj, Subscriber subscriber) {
                this.event = obj;
                this.subscriber = subscriber;
            }
        }

        private LegacyAsyncDispatcher() {
            this.queue = Queues.newConcurrentLinkedQueue();
        }

        /* synthetic */ LegacyAsyncDispatcher(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                this.queue.add(new EventWithSubscriber(obj, it.next(), null));
            }
            while (true) {
                EventWithSubscriber poll = this.queue.poll();
                if (poll != null) {
                    poll.subscriber.dispatchEvent(poll.event);
                } else {
                    return;
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class PerThreadQueuedDispatcher extends Dispatcher {
        private final ThreadLocal<Boolean> dispatching;
        private final ThreadLocal<Queue<Event>> queue;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class Event {
            private final Object event;
            private final Iterator<Subscriber> subscribers;

            /* synthetic */ Event(Object obj, Iterator it, AnonymousClass1 anonymousClass1) {
                this(obj, it);
            }

            private Event(Object obj, Iterator<Subscriber> it) {
                this.event = obj;
                this.subscribers = it;
            }
        }

        private PerThreadQueuedDispatcher() {
            this.queue = new ThreadLocal<Queue<Event>>() { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // java.lang.ThreadLocal
                public Queue<Event> initialValue() {
                    return Queues.newArrayDeque();
                }
            };
            this.dispatching = new ThreadLocal<Boolean>() { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.2
                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.lang.ThreadLocal
                public Boolean initialValue() {
                    return Boolean.FALSE;
                }
            };
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(it);
            Queue<Event> queue = this.queue.get();
            queue.offer(new Event(obj, it, null));
            if (!this.dispatching.get().booleanValue()) {
                this.dispatching.set(Boolean.TRUE);
                while (true) {
                    try {
                        Event poll = queue.poll();
                        if (poll != null) {
                            while (poll.subscribers.hasNext()) {
                                ((Subscriber) poll.subscribers.next()).dispatchEvent(poll.event);
                            }
                        } else {
                            return;
                        }
                    } finally {
                        this.dispatching.remove();
                        this.queue.remove();
                    }
                }
            }
        }

        /* synthetic */ PerThreadQueuedDispatcher(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static Dispatcher legacyAsync() {
        return new LegacyAsyncDispatcher(null);
    }

    static Dispatcher perThreadDispatchQueue() {
        return new PerThreadQueuedDispatcher(null);
    }

    Dispatcher() {
    }

    static Dispatcher immediate() {
        return ImmediateDispatcher.INSTANCE;
    }
}
