package io.netty.util.concurrent;

import io.netty.util.concurrent.Future;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class PromiseAggregator<V, F extends Future<V>> implements GenericFutureListener<F> {
    private final Promise<?> aggregatePromise;
    private final boolean failPending;
    private Set<Promise<V>> pendingPromises;

    public PromiseAggregator(Promise<Void> promise, boolean z5) {
        if (promise == null) {
            throw new NullPointerException("aggregatePromise");
        }
        this.aggregatePromise = promise;
        this.failPending = z5;
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public synchronized void operationComplete(F f6) throws Exception {
        try {
            Set<Promise<V>> set = this.pendingPromises;
            if (set == null) {
                this.aggregatePromise.setSuccess(null);
            } else {
                set.remove(f6);
                if (!f6.isSuccess()) {
                    Throwable cause = f6.cause();
                    this.aggregatePromise.setFailure(cause);
                    if (this.failPending) {
                        Iterator<Promise<V>> it = this.pendingPromises.iterator();
                        while (it.hasNext()) {
                            it.next().setFailure(cause);
                        }
                    }
                } else if (this.pendingPromises.isEmpty()) {
                    this.aggregatePromise.setSuccess(null);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @SafeVarargs
    public final PromiseAggregator<V, F> add(Promise<V>... promiseArr) {
        if (promiseArr == null) {
            throw new NullPointerException("promises");
        }
        if (promiseArr.length == 0) {
            return this;
        }
        synchronized (this) {
            try {
                if (this.pendingPromises == null) {
                    this.pendingPromises = new LinkedHashSet(promiseArr.length > 1 ? promiseArr.length : 2);
                }
                for (Promise<V> promise : promiseArr) {
                    if (promise != null) {
                        this.pendingPromises.add(promise);
                        promise.addListener((GenericFutureListener) this);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    public PromiseAggregator(Promise<Void> promise) {
        this(promise, true);
    }
}
