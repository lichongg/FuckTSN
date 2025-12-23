package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
class ListFuture<V> implements ListenableFuture<List<V>> {
    private final boolean mAllMustSucceed;

    @Nullable
    List<? extends ListenableFuture<? extends V>> mFutures;

    @NonNull
    private final AtomicInteger mRemaining;

    @NonNull
    private final ListenableFuture<List<V>> mResult = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<List<V>>() { // from class: androidx.camera.core.impl.utils.futures.ListFuture.1
        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
        public Object attachCompleter(@NonNull CallbackToFutureAdapter.Completer<List<V>> completer) {
            Preconditions.checkState(ListFuture.this.mResultNotifier == null, "The result can only set once!");
            ListFuture.this.mResultNotifier = completer;
            return "ListFuture[" + this + "]";
        }
    });
    CallbackToFutureAdapter.Completer<List<V>> mResultNotifier;

    @Nullable
    List<V> mValues;

    private void callAllGets() throws InterruptedException {
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        if (list == null || isDone()) {
            return;
        }
        for (ListenableFuture<? extends V> listenableFuture : list) {
            while (!listenableFuture.isDone()) {
                try {
                    listenableFuture.get();
                } catch (Error e6) {
                    throw e6;
                } catch (InterruptedException e7) {
                    throw e7;
                } catch (Throwable unused) {
                    if (this.mAllMustSucceed) {
                        return;
                    }
                }
            }
        }
    }

    private void init(@NonNull Executor executor) {
        addListener(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.ListFuture.2
            @Override // java.lang.Runnable
            public void run() {
                ListFuture listFuture = ListFuture.this;
                listFuture.mValues = null;
                listFuture.mFutures = null;
            }
        }, CameraXExecutors.directExecutor());
        if (this.mFutures.isEmpty()) {
            this.mResultNotifier.set(new ArrayList(this.mValues));
            return;
        }
        for (int i6 = 0; i6 < this.mFutures.size(); i6++) {
            this.mValues.add(null);
        }
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        for (final int i7 = 0; i7 < list.size(); i7++) {
            final ListenableFuture<? extends V> listenableFuture = list.get(i7);
            listenableFuture.addListener(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.ListFuture.3
                @Override // java.lang.Runnable
                public void run() {
                    ListFuture.this.setOneValue(i7, listenableFuture);
                }
            }, executor);
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.mResult.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        if (list != null) {
            Iterator<? extends ListenableFuture<? extends V>> it = list.iterator();
            while (it.hasNext()) {
                it.next().cancel(z5);
            }
        }
        return this.mResult.cancel(z5);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mResult.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mResult.isDone();
    }

    void setOneValue(int i6, @NonNull Future<? extends V> future) {
        CallbackToFutureAdapter.Completer<List<V>> completer;
        ArrayList arrayList;
        List<V> list = this.mValues;
        if (isDone() || list == null) {
            Preconditions.checkState(this.mAllMustSucceed, "Future was done before all dependencies completed");
            return;
        }
        try {
            try {
                try {
                    try {
                        try {
                            Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
                            list.set(i6, Futures.getUninterruptibly(future));
                            int decrementAndGet = this.mRemaining.decrementAndGet();
                            Preconditions.checkState(decrementAndGet >= 0, "Less than 0 remaining futures");
                            if (decrementAndGet == 0) {
                                List<V> list2 = this.mValues;
                                if (list2 != null) {
                                    this.mResultNotifier.set(new ArrayList(list2));
                                } else {
                                    Preconditions.checkState(isDone());
                                }
                            }
                        } catch (RuntimeException e6) {
                            if (this.mAllMustSucceed) {
                                this.mResultNotifier.setException(e6);
                            }
                            int decrementAndGet2 = this.mRemaining.decrementAndGet();
                            Preconditions.checkState(decrementAndGet2 >= 0, "Less than 0 remaining futures");
                            if (decrementAndGet2 == 0) {
                                List<V> list3 = this.mValues;
                                if (list3 != null) {
                                    completer = this.mResultNotifier;
                                    arrayList = new ArrayList(list3);
                                    completer.set(arrayList);
                                    return;
                                }
                                Preconditions.checkState(isDone());
                            }
                        }
                    } catch (Error e7) {
                        this.mResultNotifier.setException(e7);
                        int decrementAndGet3 = this.mRemaining.decrementAndGet();
                        Preconditions.checkState(decrementAndGet3 >= 0, "Less than 0 remaining futures");
                        if (decrementAndGet3 == 0) {
                            List<V> list4 = this.mValues;
                            if (list4 != null) {
                                completer = this.mResultNotifier;
                                arrayList = new ArrayList(list4);
                                completer.set(arrayList);
                                return;
                            }
                            Preconditions.checkState(isDone());
                        }
                    }
                } catch (CancellationException unused) {
                    if (this.mAllMustSucceed) {
                        cancel(false);
                    }
                    int decrementAndGet4 = this.mRemaining.decrementAndGet();
                    Preconditions.checkState(decrementAndGet4 >= 0, "Less than 0 remaining futures");
                    if (decrementAndGet4 == 0) {
                        List<V> list5 = this.mValues;
                        if (list5 != null) {
                            completer = this.mResultNotifier;
                            arrayList = new ArrayList(list5);
                            completer.set(arrayList);
                            return;
                        }
                        Preconditions.checkState(isDone());
                    }
                }
            } catch (ExecutionException e8) {
                if (this.mAllMustSucceed) {
                    this.mResultNotifier.setException(e8.getCause());
                }
                int decrementAndGet5 = this.mRemaining.decrementAndGet();
                Preconditions.checkState(decrementAndGet5 >= 0, "Less than 0 remaining futures");
                if (decrementAndGet5 == 0) {
                    List<V> list6 = this.mValues;
                    if (list6 != null) {
                        completer = this.mResultNotifier;
                        arrayList = new ArrayList(list6);
                        completer.set(arrayList);
                        return;
                    }
                    Preconditions.checkState(isDone());
                }
            }
        } catch (Throwable th) {
            int decrementAndGet6 = this.mRemaining.decrementAndGet();
            Preconditions.checkState(decrementAndGet6 >= 0, "Less than 0 remaining futures");
            if (decrementAndGet6 == 0) {
                List<V> list7 = this.mValues;
                if (list7 != null) {
                    this.mResultNotifier.set(new ArrayList(list7));
                } else {
                    Preconditions.checkState(isDone());
                }
            }
            throw th;
        }
    }

    ListFuture(@NonNull List<? extends ListenableFuture<? extends V>> list, boolean z5, @NonNull Executor executor) {
        this.mFutures = (List) Preconditions.checkNotNull(list);
        this.mValues = new ArrayList(list.size());
        this.mAllMustSucceed = z5;
        this.mRemaining = new AtomicInteger(list.size());
        init(executor);
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public List<V> get() throws InterruptedException, ExecutionException {
        callAllGets();
        return this.mResult.get();
    }

    @Override // java.util.concurrent.Future
    public List<V> get(long j6, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mResult.get(j6, timeUnit);
    }
}
