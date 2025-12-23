package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subscribers.DefaultSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class BlockingFlowableMostRecent<T> implements Iterable<T> {
    final T initialValue;
    final Publisher<? extends T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MostRecentSubscriber<T> extends DefaultSubscriber<T> {
        volatile Object value;

        public Iterator<T> getIterable() {
            return new Iterator<T>() { // from class: io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent.MostRecentSubscriber.1
                private Object buf;

                @Override // java.util.Iterator
                public T next() {
                    try {
                        if (this.buf == null) {
                            this.buf = MostRecentSubscriber.this.value;
                        }
                        if (NotificationLite.isComplete(this.buf)) {
                            throw new NoSuchElementException();
                        }
                        if (NotificationLite.isError(this.buf)) {
                            throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.buf));
                        }
                        T t5 = (T) NotificationLite.getValue(this.buf);
                        this.buf = null;
                        return t5;
                    } catch (Throwable th) {
                        this.buf = null;
                        throw th;
                    }
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    this.buf = MostRecentSubscriber.this.value;
                    return !NotificationLite.isComplete(r0);
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException("Read only iterator");
                }
            };
        }

        MostRecentSubscriber(T t5) {
            this.value = NotificationLite.next(t5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.value = NotificationLite.complete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.value = NotificationLite.error(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.value = NotificationLite.next(t5);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        MostRecentSubscriber mostRecentSubscriber = new MostRecentSubscriber(this.initialValue);
        this.source.subscribe(mostRecentSubscriber);
        return mostRecentSubscriber.getIterable();
    }

    public BlockingFlowableMostRecent(Publisher<? extends T> publisher, T t5) {
        this.source = publisher;
        this.initialValue = t5;
    }
}
