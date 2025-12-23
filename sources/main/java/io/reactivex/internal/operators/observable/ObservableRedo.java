package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.ToNotificationObserver;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableRedo<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Observable<Notification<Object>>, ? extends ObservableSource<?>> manager;
    final boolean retryMode;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class RedoObserver<T> extends AtomicBoolean implements Observer<T> {
        private static final long serialVersionUID = -1151903143112844287L;
        final Observer<? super T> actual;
        final boolean retryMode;
        final ObservableSource<? extends T> source;
        final Subject<Notification<Object>> subject;
        final AtomicInteger wip = new AtomicInteger();
        final SequentialDisposable arbiter = new SequentialDisposable();

        void handle(Notification<Object> notification) {
            int i6 = 1;
            if (compareAndSet(true, false)) {
                if (notification.isOnError()) {
                    this.arbiter.dispose();
                    this.actual.onError(notification.getError());
                    return;
                }
                if (!notification.isOnNext()) {
                    this.arbiter.dispose();
                    this.actual.onComplete();
                } else if (this.wip.getAndIncrement() == 0) {
                    while (!this.arbiter.isDisposed()) {
                        this.source.subscribe(this);
                        i6 = this.wip.addAndGet(-i6);
                        if (i6 == 0) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (compareAndSet(false, true)) {
                if (this.retryMode) {
                    this.subject.onComplete();
                } else {
                    this.subject.onNext(Notification.createOnComplete());
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                if (this.retryMode) {
                    this.subject.onNext(Notification.createOnError(th));
                } else {
                    this.subject.onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            this.actual.onNext(t5);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.arbiter.replace(disposable);
        }

        RedoObserver(Observer<? super T> observer, Subject<Notification<Object>> subject, ObservableSource<? extends T> observableSource, boolean z5) {
            this.actual = observer;
            this.subject = subject;
            this.source = observableSource;
            this.retryMode = z5;
            lazySet(true);
        }
    }

    public ObservableRedo(ObservableSource<T> observableSource, Function<? super Observable<Notification<Object>>, ? extends ObservableSource<?>> function, boolean z5) {
        super(observableSource);
        this.manager = function;
        this.retryMode = z5;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Subject<T> serialized = BehaviorSubject.create().toSerialized();
        final RedoObserver redoObserver = new RedoObserver(observer, serialized, this.source, this.retryMode);
        ToNotificationObserver toNotificationObserver = new ToNotificationObserver(new Consumer<Notification<Object>>() { // from class: io.reactivex.internal.operators.observable.ObservableRedo.1
            @Override // io.reactivex.functions.Consumer
            public void accept(Notification<Object> notification) {
                redoObserver.handle(notification);
            }
        });
        observer.onSubscribe(new ListCompositeDisposable(redoObserver.arbiter, toNotificationObserver));
        try {
            ((ObservableSource) ObjectHelper.requireNonNull(this.manager.apply(serialized), "The function returned a null ObservableSource")).subscribe(toNotificationObserver);
            redoObserver.handle(Notification.createOnNext(0));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            observer.onError(th);
        }
    }
}
