package com.google.android.datatransport.runtime.retries;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Retries {
    public static <TInput, TResult, TException extends Throwable> TResult retry(int i6, TInput tinput, Function<TInput, TResult, TException> function, RetryStrategy<TInput, TResult> retryStrategy) throws Throwable {
        TResult apply;
        if (i6 < 1) {
            return function.apply(tinput);
        }
        do {
            apply = function.apply(tinput);
            tinput = retryStrategy.shouldRetry(tinput, apply);
            if (tinput == null) {
                break;
            }
            i6--;
        } while (i6 >= 1);
        return apply;
    }

    private Retries() {
    }
}
