package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Executor f16326a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final Executor f16327b = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            l.x(runnable);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f16327b;
    }

    public static Executor b() {
        return f16326a;
    }

    private e() {
    }

    @VisibleForTesting
    public static void c(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!executorService.awaitTermination(5L, timeUnit)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(5L, timeUnit)) {
                    throw new RuntimeException("Failed to shutdown");
                }
            }
        } catch (InterruptedException e6) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e6);
        }
    }
}
