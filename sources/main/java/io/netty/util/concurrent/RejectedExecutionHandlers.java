package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class RejectedExecutionHandlers {
    private static final RejectedExecutionHandler REJECT = new RejectedExecutionHandler() { // from class: io.netty.util.concurrent.RejectedExecutionHandlers.1
        @Override // io.netty.util.concurrent.RejectedExecutionHandler
        public void rejected(Runnable runnable, SingleThreadEventExecutor singleThreadEventExecutor) {
            throw new RejectedExecutionException();
        }
    };

    public static RejectedExecutionHandler backoff(final int i6, long j6, TimeUnit timeUnit) {
        ObjectUtil.checkPositive(i6, "retries");
        final long nanos = timeUnit.toNanos(j6);
        return new RejectedExecutionHandler() { // from class: io.netty.util.concurrent.RejectedExecutionHandlers.2
            @Override // io.netty.util.concurrent.RejectedExecutionHandler
            public void rejected(Runnable runnable, SingleThreadEventExecutor singleThreadEventExecutor) {
                if (!singleThreadEventExecutor.inEventLoop()) {
                    for (int i7 = 0; i7 < i6; i7++) {
                        singleThreadEventExecutor.wakeup(false);
                        LockSupport.parkNanos(nanos);
                        if (singleThreadEventExecutor.offerTask(runnable)) {
                            return;
                        }
                    }
                }
                throw new RejectedExecutionException();
            }
        };
    }

    public static RejectedExecutionHandler reject() {
        return REJECT;
    }

    private RejectedExecutionHandlers() {
    }
}
