package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class RequestExecutor {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class DefaultThreadFactory implements ThreadFactory {
        private int mPriority;
        private String mThreadName;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static class ProcessPriorityThread extends Thread {
            private final int mPriority;

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.mPriority);
                super.run();
            }

            ProcessPriorityThread(Runnable runnable, String str, int i6) {
                super(runnable, str);
                this.mPriority = i6;
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.mThreadName, this.mPriority);
        }

        DefaultThreadFactory(@NonNull String str, int i6) {
            this.mThreadName = str;
            this.mPriority = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class HandlerExecutor implements Executor {
        private final Handler mHandler;

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }

        HandlerExecutor(@NonNull Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ReplyRunnable<T> implements Runnable {

        @NonNull
        private Callable<T> mCallable;

        @NonNull
        private Consumer<T> mConsumer;

        @NonNull
        private Handler mHandler;

        @Override // java.lang.Runnable
        public void run() {
            final T t5;
            try {
                t5 = this.mCallable.call();
            } catch (Exception unused) {
                t5 = null;
            }
            final Consumer<T> consumer = this.mConsumer;
            this.mHandler.post(new Runnable() { // from class: androidx.core.provider.RequestExecutor.ReplyRunnable.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    consumer.accept(t5);
                }
            });
        }

        ReplyRunnable(@NonNull Handler handler, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
            this.mCallable = callable;
            this.mConsumer = consumer;
            this.mHandler = handler;
        }
    }

    static ThreadPoolExecutor createDefaultExecutor(@NonNull String str, int i6, @IntRange(from = 0) int i7) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i7, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str, i6));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static Executor createHandlerExecutor(@NonNull Handler handler) {
        return new HandlerExecutor(handler);
    }

    private RequestExecutor() {
    }

    static <T> void execute(@NonNull Executor executor, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
        executor.execute(new ReplyRunnable(CalleeHandler.create(), callable, consumer));
    }

    static <T> T submit(@NonNull ExecutorService executorService, @NonNull Callable<T> callable, @IntRange(from = 0) int i6) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i6, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e6) {
            throw e6;
        } catch (ExecutionException e7) {
            throw new RuntimeException(e7);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
