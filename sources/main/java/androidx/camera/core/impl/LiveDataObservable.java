package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class LiveDataObservable<T> implements Observable<T> {
    final MutableLiveData<Result<T>> mLiveData = new MutableLiveData<>();

    @GuardedBy("mObservers")
    private final Map<Observable.Observer<? super T>, LiveDataObserverAdapter<T>> mObservers = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class LiveDataObserverAdapter<T> implements Observer<Result<T>> {
        final AtomicBoolean mActive = new AtomicBoolean(true);
        final Executor mExecutor;
        final Observable.Observer<? super T> mObserver;

        public static /* synthetic */ void a(LiveDataObserverAdapter liveDataObserverAdapter, Result result) {
            if (liveDataObserverAdapter.mActive.get()) {
                if (result.completedSuccessfully()) {
                    liveDataObserverAdapter.mObserver.onNewData((Object) result.getValue());
                } else {
                    Preconditions.checkNotNull(result.getError());
                    liveDataObserverAdapter.mObserver.onError(result.getError());
                }
            }
        }

        void disable() {
            this.mActive.set(false);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@NonNull final Result<T> result) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.impl.e0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveDataObservable.LiveDataObserverAdapter.a(LiveDataObservable.LiveDataObserverAdapter.this, result);
                }
            });
        }

        LiveDataObserverAdapter(@NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
            this.mExecutor = executor;
            this.mObserver = observer;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Result<T> {

        @Nullable
        private final Throwable mError;

        @Nullable
        private final T mValue;

        static <T> Result<T> fromError(@NonNull Throwable th) {
            return new Result<>(null, (Throwable) Preconditions.checkNotNull(th));
        }

        static <T> Result<T> fromValue(@Nullable T t5) {
            return new Result<>(t5, null);
        }

        public boolean completedSuccessfully() {
            return this.mError == null;
        }

        @Nullable
        public Throwable getError() {
            return this.mError;
        }

        @NonNull
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[Result: <");
            if (completedSuccessfully()) {
                str = "Value: " + this.mValue;
            } else {
                str = "Error: " + this.mError;
            }
            sb.append(str);
            sb.append(">]");
            return sb.toString();
        }

        private Result(@Nullable T t5, @Nullable Throwable th) {
            this.mValue = t5;
            this.mError = th;
        }

        @Nullable
        public T getValue() {
            if (completedSuccessfully()) {
                return this.mValue;
            }
            throw new IllegalStateException("Result contains an error. Does not contain a value.");
        }
    }

    public static /* synthetic */ void c(LiveDataObservable liveDataObservable, CallbackToFutureAdapter.Completer completer) {
        Result<T> value = liveDataObservable.mLiveData.getValue();
        if (value == null) {
            completer.setException(new IllegalStateException("Observable has not yet been initialized with a value."));
        } else if (value.completedSuccessfully()) {
            completer.set(value.getValue());
        } else {
            Preconditions.checkNotNull(value.getError());
            completer.setException(value.getError());
        }
    }

    public static /* synthetic */ void d(LiveDataObservable liveDataObservable, LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObserverAdapter liveDataObserverAdapter2) {
        if (liveDataObserverAdapter != null) {
            liveDataObservable.mLiveData.removeObserver(liveDataObserverAdapter);
        }
        liveDataObservable.mLiveData.observeForever(liveDataObserverAdapter2);
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(@NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
        synchronized (this.mObservers) {
            try {
                final LiveDataObserverAdapter<T> liveDataObserverAdapter = this.mObservers.get(observer);
                if (liveDataObserverAdapter != null) {
                    liveDataObserverAdapter.disable();
                }
                final LiveDataObserverAdapter<T> liveDataObserverAdapter2 = new LiveDataObserverAdapter<>(executor, observer);
                this.mObservers.put(observer, liveDataObserverAdapter2);
                CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.impl.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveDataObservable.d(LiveDataObservable.this, liveDataObserverAdapter, liveDataObserverAdapter2);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.Observable
    @NonNull
    public ListenableFuture<T> fetchData() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.impl.d0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return LiveDataObservable.a(LiveDataObservable.this, completer);
            }
        });
    }

    @NonNull
    public LiveData<Result<T>> getLiveData() {
        return this.mLiveData;
    }

    public void postError(@NonNull Throwable th) {
        this.mLiveData.postValue(Result.fromError(th));
    }

    public void postValue(@Nullable T t5) {
        this.mLiveData.postValue(Result.fromValue(t5));
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(@NonNull Observable.Observer<? super T> observer) {
        synchronized (this.mObservers) {
            try {
                final LiveDataObserverAdapter<T> remove = this.mObservers.remove(observer);
                if (remove != null) {
                    remove.disable();
                    CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.impl.a0
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveDataObservable.this.mLiveData.removeObserver(remove);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ Object a(final LiveDataObservable liveDataObservable, final CallbackToFutureAdapter.Completer completer) {
        liveDataObservable.getClass();
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.impl.c0
            @Override // java.lang.Runnable
            public final void run() {
                LiveDataObservable.c(LiveDataObservable.this, completer);
            }
        });
        return liveDataObservable + " [fetch@" + SystemClock.uptimeMillis() + "]";
    }
}
