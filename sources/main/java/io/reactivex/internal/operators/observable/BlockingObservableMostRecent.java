package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DefaultObserver;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class BlockingObservableMostRecent<T> implements Iterable<T> {
    final T initialValue;
    final ObservableSource<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MostRecentObserver<T> extends DefaultObserver<T> {
        volatile Object value;

        public Iterator<T> getIterable() {
            return new Iterator<T>() { // from class: io.reactivex.internal.operators.observable.BlockingObservableMostRecent.MostRecentObserver.1
                private Object buf;

                @Override // java.util.Iterator
                public T next() {
                    try {
                        if (this.buf == null) {
                            this.buf = MostRecentObserver.this.value;
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
                    this.buf = MostRecentObserver.this.value;
                    return !NotificationLite.isComplete(r0);
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException("Read only iterator");
                }
            };
        }

        MostRecentObserver(T t5) {
            this.value = NotificationLite.next(t5);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.value = NotificationLite.complete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.value = NotificationLite.error(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            this.value = NotificationLite.next(t5);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        MostRecentObserver mostRecentObserver = new MostRecentObserver(this.initialValue);
        this.source.subscribe(mostRecentObserver);
        return mostRecentObserver.getIterable();
    }

    public BlockingObservableMostRecent(ObservableSource<T> observableSource, T t5) {
        this.source = observableSource;
        this.initialValue = t5;
    }
}
