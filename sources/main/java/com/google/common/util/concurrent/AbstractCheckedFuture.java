package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.Exception;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
@Deprecated
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class AbstractCheckedFuture<V, X extends Exception> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements CheckedFuture<V, X> {
    @Override // com.google.common.util.concurrent.CheckedFuture
    @CanIgnoreReturnValue
    public V checkedGet() throws Exception {
        try {
            return get();
        } catch (InterruptedException e6) {
            Thread.currentThread().interrupt();
            throw mapException(e6);
        } catch (CancellationException e7) {
            e = e7;
            throw mapException(e);
        } catch (ExecutionException e8) {
            e = e8;
            throw mapException(e);
        }
    }

    protected abstract X mapException(Exception exc);

    protected AbstractCheckedFuture(ListenableFuture<V> listenableFuture) {
        super(listenableFuture);
    }

    @Override // com.google.common.util.concurrent.CheckedFuture
    @CanIgnoreReturnValue
    public V checkedGet(long j6, TimeUnit timeUnit) throws TimeoutException, Exception {
        try {
            return get(j6, timeUnit);
        } catch (InterruptedException e6) {
            Thread.currentThread().interrupt();
            throw mapException(e6);
        } catch (CancellationException e7) {
            e = e7;
            throw mapException(e);
        } catch (ExecutionException e8) {
            e = e8;
            throw mapException(e);
        }
    }
}
