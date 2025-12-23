package io.reactivex.internal.operators.maybe;

import androidx.camera.view.p;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class MaybeCache<T> extends Maybe<T> implements MaybeObserver<T> {
    static final CacheDisposable[] EMPTY = new CacheDisposable[0];
    static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
    Throwable error;
    final AtomicReference<CacheDisposable<T>[]> observers = new AtomicReference<>(EMPTY);
    final AtomicReference<MaybeSource<T>> source;
    T value;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements Disposable {
        private static final long serialVersionUID = -5791853038359966195L;
        final MaybeObserver<? super T> actual;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            MaybeCache<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.remove(this);
            }
        }

        CacheDisposable(MaybeObserver<? super T> maybeObserver, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.actual = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == null) {
                return true;
            }
            return false;
        }
    }

    boolean add(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.observers.get();
            if (cacheDisposableArr == TERMINATED) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!p.a(this.observers, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(TERMINATED)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onComplete();
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        this.error = th;
        for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(TERMINATED)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onError(th);
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t5) {
        this.value = t5;
        for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(TERMINATED)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.actual.onSuccess(t5);
            }
        }
    }

    void remove(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.observers.get();
            int length = cacheDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    i6 = -1;
                    break;
                } else if (cacheDisposableArr[i6] == cacheDisposable) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 < 0) {
                return;
            }
            if (length == 1) {
                cacheDisposableArr2 = EMPTY;
            } else {
                CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i6);
                System.arraycopy(cacheDisposableArr, i6 + 1, cacheDisposableArr3, i6, (length - i6) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!p.a(this.observers, cacheDisposableArr, cacheDisposableArr2));
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(maybeObserver, this);
        maybeObserver.onSubscribe(cacheDisposable);
        if (add(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                remove(cacheDisposable);
                return;
            }
            MaybeSource<T> andSet = this.source.getAndSet(null);
            if (andSet != null) {
                andSet.subscribe(this);
                return;
            }
            return;
        }
        if (cacheDisposable.isDisposed()) {
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            maybeObserver.onError(th);
            return;
        }
        T t5 = this.value;
        if (t5 != null) {
            maybeObserver.onSuccess(t5);
        } else {
            maybeObserver.onComplete();
        }
    }

    public MaybeCache(MaybeSource<T> maybeSource) {
        this.source = new AtomicReference<>(maybeSource);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable disposable) {
    }
}
