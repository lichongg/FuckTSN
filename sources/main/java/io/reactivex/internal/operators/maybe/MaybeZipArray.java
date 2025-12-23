package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class MaybeZipArray<T, R> extends Maybe<R> {
    final MaybeSource<? extends T>[] sources;
    final Function<? super Object[], ? extends R> zipper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -5556924161382950569L;
        final MaybeObserver<? super R> actual;
        final ZipMaybeObserver<T>[] observers;
        final Object[] values;
        final Function<? super Object[], ? extends R> zipper;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipMaybeObserver<T> zipMaybeObserver : this.observers) {
                    zipMaybeObserver.dispose();
                }
            }
        }

        void innerComplete(int i6) {
            if (getAndSet(0) > 0) {
                disposeExcept(i6);
                this.actual.onComplete();
            }
        }

        void innerError(Throwable th, int i6) {
            if (getAndSet(0) <= 0) {
                RxJavaPlugins.onError(th);
            } else {
                disposeExcept(i6);
                this.actual.onError(th);
            }
        }

        void disposeExcept(int i6) {
            ZipMaybeObserver<T>[] zipMaybeObserverArr = this.observers;
            int length = zipMaybeObserverArr.length;
            for (int i7 = 0; i7 < i6; i7++) {
                zipMaybeObserverArr[i7].dispose();
            }
            while (true) {
                i6++;
                if (i6 >= length) {
                    return;
                } else {
                    zipMaybeObserverArr[i6].dispose();
                }
            }
        }

        void innerSuccess(T t5, int i6) {
            this.values[i6] = t5;
            if (decrementAndGet() == 0) {
                try {
                    this.actual.onSuccess(ObjectHelper.requireNonNull(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.actual.onError(th);
                }
            }
        }

        ZipCoordinator(MaybeObserver<? super R> maybeObserver, int i6, Function<? super Object[], ? extends R> function) {
            super(i6);
            this.actual = maybeObserver;
            this.zipper = function;
            ZipMaybeObserver<T>[] zipMaybeObserverArr = new ZipMaybeObserver[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                zipMaybeObserverArr[i7] = new ZipMaybeObserver<>(this, i7);
            }
            this.observers = zipMaybeObserverArr;
            this.values = new Object[i6];
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() <= 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ZipMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final ZipCoordinator<T, ?> parent;

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.parent.innerError(th, this.index);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t5) {
            this.parent.innerSuccess(t5, this.index);
        }

        ZipMaybeObserver(ZipCoordinator<T, ?> zipCoordinator, int i6) {
            this.parent = zipCoordinator;
            this.index = i6;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeSource<? extends T>[] maybeSourceArr = this.sources;
        int length = maybeSourceArr.length;
        if (length == 1) {
            maybeSourceArr[0].subscribe(new MaybeMap.MapMaybeObserver(maybeObserver, new Function<T, R>() { // from class: io.reactivex.internal.operators.maybe.MaybeZipArray.1
                /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
                @Override // io.reactivex.functions.Function
                public R apply(T t5) throws Exception {
                    return MaybeZipArray.this.zipper.apply(new Object[]{t5});
                }
            }));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(maybeObserver, length, this.zipper);
        maybeObserver.onSubscribe(zipCoordinator);
        for (int i6 = 0; i6 < length && !zipCoordinator.isDisposed(); i6++) {
            maybeSourceArr[i6].subscribe(zipCoordinator.observers[i6]);
        }
    }

    public MaybeZipArray(MaybeSource<? extends T>[] maybeSourceArr, Function<? super Object[], ? extends R> function) {
        this.sources = maybeSourceArr;
        this.zipper = function;
    }
}
