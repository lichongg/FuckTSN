package io.reactivex.subjects;

import androidx.camera.view.p;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class PublishSubject<T> extends Subject<T> {
    Throwable error;
    final AtomicReference<PublishDisposable<T>[]> subscribers = new AtomicReference<>(EMPTY);
    static final PublishDisposable[] TERMINATED = new PublishDisposable[0];
    static final PublishDisposable[] EMPTY = new PublishDisposable[0];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        final Observer<? super T> actual;
        final PublishSubject<T> parent;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }

        PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.actual = observer;
            this.parent = publishSubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (!get()) {
                this.actual.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.onError(th);
            } else {
                this.actual.onError(th);
            }
        }

        public void onNext(T t5) {
            if (!get()) {
                this.actual.onNext(t5);
            }
        }
    }

    public static <T> PublishSubject<T> create() {
        return new PublishSubject<>();
    }

    boolean add(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.subscribers.get();
            if (publishDisposableArr == TERMINATED) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!p.a(this.subscribers, publishDisposableArr, publishDisposableArr2));
        return true;
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        if (this.subscribers.get() == TERMINATED) {
            return this.error;
        }
        return null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return this.subscribers.get() == TERMINATED && this.error == null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.subscribers.get().length != 0;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return this.subscribers.get() == TERMINATED && this.error != null;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.subscribers.get();
        PublishDisposable<T>[] publishDisposableArr2 = TERMINATED;
        if (publishDisposableArr == publishDisposableArr2) {
            return;
        }
        for (PublishDisposable<T> publishDisposable : this.subscribers.getAndSet(publishDisposableArr2)) {
            publishDisposable.onComplete();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        PublishDisposable<T>[] publishDisposableArr = this.subscribers.get();
        PublishDisposable<T>[] publishDisposableArr2 = TERMINATED;
        if (publishDisposableArr == publishDisposableArr2) {
            RxJavaPlugins.onError(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.error = th;
        for (PublishDisposable<T> publishDisposable : this.subscribers.getAndSet(publishDisposableArr2)) {
            publishDisposable.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t5) {
        if (this.subscribers.get() == TERMINATED) {
            return;
        }
        if (t5 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        for (PublishDisposable<T> publishDisposable : this.subscribers.get()) {
            publishDisposable.onNext(t5);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.subscribers.get() == TERMINATED) {
            disposable.dispose();
        }
    }

    void remove(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.subscribers.get();
            if (publishDisposableArr == TERMINATED || publishDisposableArr == EMPTY) {
                return;
            }
            int length = publishDisposableArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    i6 = -1;
                    break;
                } else if (publishDisposableArr[i6] == publishDisposable) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 < 0) {
                return;
            }
            if (length == 1) {
                publishDisposableArr2 = EMPTY;
            } else {
                PublishDisposable[] publishDisposableArr3 = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i6);
                System.arraycopy(publishDisposableArr, i6 + 1, publishDisposableArr3, i6, (length - i6) - 1);
                publishDisposableArr2 = publishDisposableArr3;
            }
        } while (!p.a(this.subscribers, publishDisposableArr, publishDisposableArr2));
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(observer, this);
        observer.onSubscribe(publishDisposable);
        if (add(publishDisposable)) {
            if (publishDisposable.isDisposed()) {
                remove(publishDisposable);
            }
        } else {
            Throwable th = this.error;
            if (th != null) {
                observer.onError(th);
            } else {
                observer.onComplete();
            }
        }
    }

    PublishSubject() {
    }
}
