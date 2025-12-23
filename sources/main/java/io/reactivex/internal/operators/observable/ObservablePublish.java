package io.reactivex.internal.operators.observable;

import androidx.camera.view.p;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {
    final AtomicReference<PublishObserver<T>> current;
    final ObservableSource<T> onSubscribe;
    final ObservableSource<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class PublishObserver<T> implements Observer<T>, Disposable {
        static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        final AtomicReference<PublishObserver<T>> current;

        /* renamed from: s, reason: collision with root package name */
        final AtomicReference<Disposable> f43334s = new AtomicReference<>();
        final AtomicReference<InnerDisposable<T>[]> observers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                if (innerDisposableArr == TERMINATED) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!p.a(this.observers, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            InnerDisposable<T>[] innerDisposableArr = this.observers.get();
            InnerDisposable<T>[] innerDisposableArr2 = TERMINATED;
            if (innerDisposableArr == innerDisposableArr2 || this.observers.getAndSet(innerDisposableArr2) == innerDisposableArr2) {
                return;
            }
            p.a(this.current, this, null);
            DisposableHelper.dispose(this.f43334s);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            p.a(this.current, this, null);
            for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(TERMINATED)) {
                innerDisposable.child.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            p.a(this.current, this, null);
            InnerDisposable<T>[] andSet = this.observers.getAndSet(TERMINATED);
            if (andSet.length == 0) {
                RxJavaPlugins.onError(th);
                return;
            }
            for (InnerDisposable<T> innerDisposable : andSet) {
                innerDisposable.child.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t5) {
            for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                innerDisposable.child.onNext(t5);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f43334s, disposable);
        }

        void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        i6 = -1;
                        break;
                    } else if (innerDisposableArr[i6].equals(innerDisposable)) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i6 < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = EMPTY;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i6);
                    System.arraycopy(innerDisposableArr, i6 + 1, innerDisposableArr3, i6, (length - i6) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!p.a(this.observers, innerDisposableArr, innerDisposableArr2));
        }

        PublishObserver(AtomicReference<PublishObserver<T>> atomicReference) {
            this.current = atomicReference;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        private static final long serialVersionUID = -1100270633763673112L;
        final Observer<? super T> child;

        void setParent(PublishObserver<T> publishObserver) {
            if (compareAndSet(null, publishObserver)) {
                return;
            }
            publishObserver.remove(this);
        }

        InnerDisposable(Observer<? super T> observer) {
            this.child = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((PublishObserver) andSet).remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == this) {
                return true;
            }
            return false;
        }
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource) {
        final AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableObservable) new ObservablePublish(new ObservableSource<T>() { // from class: io.reactivex.internal.operators.observable.ObservablePublish.1
            @Override // io.reactivex.ObservableSource
            public void subscribe(Observer<? super T> observer) {
                InnerDisposable innerDisposable = new InnerDisposable(observer);
                observer.onSubscribe(innerDisposable);
                while (true) {
                    PublishObserver<T> publishObserver = (PublishObserver) atomicReference.get();
                    if (publishObserver == null || publishObserver.isDisposed()) {
                        PublishObserver<T> publishObserver2 = new PublishObserver<>(atomicReference);
                        if (p.a(atomicReference, publishObserver, publishObserver2)) {
                            publishObserver = publishObserver2;
                        } else {
                            continue;
                        }
                    }
                    if (publishObserver.add(innerDisposable)) {
                        innerDisposable.setParent(publishObserver);
                        return;
                    }
                }
            }
        }, observableSource, atomicReference));
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> consumer) {
        PublishObserver<T> publishObserver;
        while (true) {
            publishObserver = this.current.get();
            if (publishObserver != null && !publishObserver.isDisposed()) {
                break;
            }
            PublishObserver<T> publishObserver2 = new PublishObserver<>(this.current);
            if (p.a(this.current, publishObserver, publishObserver2)) {
                publishObserver = publishObserver2;
                break;
            }
        }
        boolean z5 = false;
        if (!publishObserver.shouldConnect.get() && publishObserver.shouldConnect.compareAndSet(false, true)) {
            z5 = true;
        }
        try {
            consumer.accept(publishObserver);
            if (z5) {
                this.source.subscribe(publishObserver);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.source;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.onSubscribe.subscribe(observer);
    }

    private ObservablePublish(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<PublishObserver<T>> atomicReference) {
        this.onSubscribe = observableSource;
        this.source = observableSource2;
        this.current = atomicReference;
    }
}
