package androidx.camera.core.impl.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class Threads {
    private static final long TIMEOUT_RUN_ON_MAIN_MS = 30000;

    @NonNull
    private static Handler getMainHandler() {
        return new Handler(Looper.getMainLooper());
    }

    private Threads() {
    }

    public static /* synthetic */ void a(Runnable runnable, CountDownLatch countDownLatch) {
        try {
            runnable.run();
        } finally {
            countDownLatch.countDown();
        }
    }

    public static void checkBackgroundThread() {
        Preconditions.checkState(isBackgroundThread(), "In application's main thread");
    }

    public static void checkMainThread() {
        Preconditions.checkState(isMainThread(), "Not in application's main thread");
    }

    public static boolean isBackgroundThread() {
        return !isMainThread();
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public static void runOnMain(@NonNull Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            Preconditions.checkState(getMainHandler().post(runnable), "Unable to post to main thread");
        }
    }

    public static void runOnMainSync(@NonNull final Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Preconditions.checkState(getMainHandler().post(new Runnable() { // from class: androidx.camera.core.impl.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                Threads.a(runnable, countDownLatch);
            }
        }), "Unable to post to main thread");
        try {
            if (countDownLatch.await(30000L, TimeUnit.MILLISECONDS)) {
            } else {
                throw new IllegalStateException("Timeout to wait main thread execution");
            }
        } catch (InterruptedException e6) {
            throw new InterruptedRuntimeException(e6);
        }
    }
}
