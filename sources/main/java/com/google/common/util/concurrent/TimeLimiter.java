package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public interface TimeLimiter {
    @CanIgnoreReturnValue
    <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j6, TimeUnit timeUnit) throws TimeoutException, ExecutionException;

    @CanIgnoreReturnValue
    <T> T callWithTimeout(Callable<T> callable, long j6, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException;

    <T> T newProxy(T t5, Class<T> cls, long j6, TimeUnit timeUnit);

    void runUninterruptiblyWithTimeout(Runnable runnable, long j6, TimeUnit timeUnit) throws TimeoutException;

    void runWithTimeout(Runnable runnable, long j6, TimeUnit timeUnit) throws TimeoutException, InterruptedException;
}
