package com.google.android.datatransport.runtime.retries;

import java.lang.Throwable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface Function<TInput, TResult, TException extends Throwable> {
    TResult apply(TInput tinput) throws Throwable;
}
