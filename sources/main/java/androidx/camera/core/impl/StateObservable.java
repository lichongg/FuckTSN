package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class StateObservable<T> implements Observable<T> {
    private static final int INITIAL_VERSION = 0;
    private final AtomicReference<Object> mState;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private int mVersion = 0;

    @GuardedBy("mLock")
    private boolean mUpdating = false;

    @GuardedBy("mLock")
    private final Map<Observable.Observer<? super T>, ObserverWrapper<T>> mWrapperMap = new HashMap();

    @GuardedBy("mLock")
    private final CopyOnWriteArraySet<ObserverWrapper<T>> mNotifySet = new CopyOnWriteArraySet<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class ErrorWrapper {
        @NonNull
        public abstract Throwable getError();

        @NonNull
        static ErrorWrapper wrap(@NonNull Throwable th) {
            return new AutoValue_StateObservable_ErrorWrapper(th);
        }

        ErrorWrapper() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ObserverWrapper<T> implements Runnable {
        private static final Object NOT_SET = new Object();
        private static final int NO_VERSION = -1;
        private final Executor mExecutor;
        private final Observable.Observer<? super T> mObserver;
        private final AtomicReference<Object> mStateRef;
        private final AtomicBoolean mActive = new AtomicBoolean(true);
        private Object mLastState = NOT_SET;

        @GuardedBy("this")
        private int mLatestSignalledVersion = -1;

        @GuardedBy("this")
        private boolean mWrapperUpdating = false;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                try {
                    if (!this.mActive.get()) {
                        this.mWrapperUpdating = false;
                        return;
                    }
                    Object obj = this.mStateRef.get();
                    int i6 = this.mLatestSignalledVersion;
                    while (true) {
                        if (!Objects.equals(this.mLastState, obj)) {
                            this.mLastState = obj;
                            if (obj instanceof ErrorWrapper) {
                                this.mObserver.onError(((ErrorWrapper) obj).getError());
                            } else {
                                this.mObserver.onNewData(obj);
                            }
                        }
                        synchronized (this) {
                            try {
                                if (i6 == this.mLatestSignalledVersion || !this.mActive.get()) {
                                    break;
                                }
                                obj = this.mStateRef.get();
                                i6 = this.mLatestSignalledVersion;
                            } finally {
                            }
                        }
                    }
                    this.mWrapperUpdating = false;
                } finally {
                }
            }
        }

        void update(int i6) {
            synchronized (this) {
                try {
                    if (this.mActive.get()) {
                        if (i6 <= this.mLatestSignalledVersion) {
                            return;
                        }
                        this.mLatestSignalledVersion = i6;
                        if (this.mWrapperUpdating) {
                            return;
                        }
                        this.mWrapperUpdating = true;
                        try {
                            this.mExecutor.execute(this);
                        } catch (Throwable unused) {
                            synchronized (this) {
                                this.mWrapperUpdating = false;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void close() {
            this.mActive.set(false);
        }

        ObserverWrapper(@NonNull AtomicReference<Object> atomicReference, @NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
            this.mStateRef = atomicReference;
            this.mExecutor = executor;
            this.mObserver = observer;
        }
    }

    @GuardedBy("mLock")
    private void removeObserverLocked(@NonNull Observable.Observer<? super T> observer) {
        ObserverWrapper<T> remove = this.mWrapperMap.remove(observer);
        if (remove != null) {
            remove.close();
            this.mNotifySet.remove(remove);
        }
    }

    private void updateStateInternal(@Nullable Object obj) {
        Iterator<ObserverWrapper<T>> it;
        int i6;
        synchronized (this.mLock) {
            try {
                if (Objects.equals(this.mState.getAndSet(obj), obj)) {
                    return;
                }
                int i7 = this.mVersion + 1;
                this.mVersion = i7;
                if (this.mUpdating) {
                    return;
                }
                this.mUpdating = true;
                Iterator<ObserverWrapper<T>> it2 = this.mNotifySet.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        it2.next().update(i7);
                    } else {
                        synchronized (this.mLock) {
                            try {
                                if (this.mVersion == i7) {
                                    this.mUpdating = false;
                                    return;
                                } else {
                                    it = this.mNotifySet.iterator();
                                    i6 = this.mVersion;
                                }
                            } finally {
                            }
                        }
                        it2 = it;
                        i7 = i6;
                    }
                }
            } finally {
            }
        }
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(@NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
        ObserverWrapper<T> observerWrapper;
        synchronized (this.mLock) {
            removeObserverLocked(observer);
            observerWrapper = new ObserverWrapper<>(this.mState, executor, observer);
            this.mWrapperMap.put(observer, observerWrapper);
            this.mNotifySet.add(observerWrapper);
        }
        observerWrapper.update(0);
    }

    @Override // androidx.camera.core.impl.Observable
    @NonNull
    public ListenableFuture<T> fetchData() {
        Object obj = this.mState.get();
        return obj instanceof ErrorWrapper ? Futures.immediateFailedFuture(((ErrorWrapper) obj).getError()) : Futures.immediateFuture(obj);
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(@NonNull Observable.Observer<? super T> observer) {
        synchronized (this.mLock) {
            removeObserverLocked(observer);
        }
    }

    StateObservable(@Nullable Object obj, boolean z5) {
        if (z5) {
            Preconditions.checkArgument(obj instanceof Throwable, "Initial errors must be Throwable");
            this.mState = new AtomicReference<>(ErrorWrapper.wrap((Throwable) obj));
        } else {
            this.mState = new AtomicReference<>(obj);
        }
    }

    void updateState(@Nullable T t5) {
        updateStateInternal(t5);
    }

    void updateStateAsError(@NonNull Throwable th) {
        updateStateInternal(ErrorWrapper.wrap(th));
    }
}
