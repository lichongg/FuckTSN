package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class FastThreadLocalRunnable implements Runnable {
    private final Runnable runnable;

    static Runnable wrap(Runnable runnable) {
        return runnable instanceof FastThreadLocalRunnable ? runnable : new FastThreadLocalRunnable(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.runnable.run();
        } finally {
            FastThreadLocal.removeAll();
        }
    }

    private FastThreadLocalRunnable(Runnable runnable) {
        this.runnable = (Runnable) ObjectUtil.checkNotNull(runnable, "runnable");
    }
}
