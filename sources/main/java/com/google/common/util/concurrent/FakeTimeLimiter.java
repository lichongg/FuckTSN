package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@CanIgnoreReturnValue
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class FakeTimeLimiter implements TimeLimiter {
    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j6, TimeUnit timeUnit) throws ExecutionException {
        return (T) callWithTimeout(callable, j6, timeUnit);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callWithTimeout(Callable<T> callable, long j6, TimeUnit timeUnit) throws ExecutionException {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        try {
            return callable.call();
        } catch (Error e6) {
            throw new ExecutionError(e6);
        } catch (RuntimeException e7) {
            throw new UncheckedExecutionException(e7);
        } catch (Exception e8) {
            throw new ExecutionException(e8);
        } catch (Throwable th) {
            throw new ExecutionException(th);
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T t5, Class<T> cls, long j6, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t5);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        return t5;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable runnable, long j6, TimeUnit timeUnit) {
        runWithTimeout(runnable, j6, timeUnit);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable runnable, long j6, TimeUnit timeUnit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        try {
            runnable.run();
        } catch (Error e6) {
            throw new ExecutionError(e6);
        } catch (RuntimeException e7) {
            throw new UncheckedExecutionException(e7);
        } catch (Throwable th) {
            throw new UncheckedExecutionException(th);
        }
    }
}
