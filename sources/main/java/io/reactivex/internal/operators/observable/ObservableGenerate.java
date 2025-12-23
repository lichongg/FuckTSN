package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableGenerate<T, S> extends Observable<T> {
    final Consumer<? super S> disposeState;
    final BiFunction<S, Emitter<T>, S> generator;
    final Callable<S> stateSupplier;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {
        final Observer<? super T> actual;
        volatile boolean cancelled;
        final Consumer<? super S> disposeState;
        final BiFunction<S, ? super Emitter<T>, S> generator;
        S state;
        boolean terminate;

        private void dispose(S s5) {
            try {
                this.disposeState.accept(s5);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            this.terminate = true;
            this.actual.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.terminate = true;
            this.actual.onError(th);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t5) {
            if (t5 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.actual.onNext(t5);
            }
        }

        public void run() {
            S s5 = this.state;
            if (this.cancelled) {
                this.state = null;
                dispose(s5);
                return;
            }
            BiFunction<S, ? super Emitter<T>, S> biFunction = this.generator;
            while (!this.cancelled) {
                try {
                    s5 = biFunction.apply(s5, this);
                    if (this.terminate) {
                        this.cancelled = true;
                        this.state = null;
                        dispose(s5);
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.state = null;
                    this.cancelled = true;
                    this.actual.onError(th);
                    return;
                }
            }
            this.state = null;
            dispose(s5);
        }

        GeneratorDisposable(Observer<? super T> observer, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s5) {
            this.actual = observer;
            this.generator = biFunction;
            this.disposeState = consumer;
            this.state = s5;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            GeneratorDisposable generatorDisposable = new GeneratorDisposable(observer, this.generator, this.disposeState, this.stateSupplier.call());
            observer.onSubscribe(generatorDisposable);
            generatorDisposable.run();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }

    public ObservableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.stateSupplier = callable;
        this.generator = biFunction;
        this.disposeState = consumer;
    }
}
