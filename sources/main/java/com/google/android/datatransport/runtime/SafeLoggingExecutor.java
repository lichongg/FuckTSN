package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class SafeLoggingExecutor implements Executor {
    private final Executor delegate;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SafeLoggingRunnable implements Runnable {
        private final Runnable delegate;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.delegate.run();
            } catch (Exception e6) {
                Logging.e("Executor", "Background execution failure.", e6);
            }
        }

        SafeLoggingRunnable(Runnable runnable) {
            this.delegate = runnable;
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.delegate.execute(new SafeLoggingRunnable(runnable));
    }

    SafeLoggingExecutor(Executor executor) {
        this.delegate = executor;
    }
}
