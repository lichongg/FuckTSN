package okhttp3.internal.concurrent;

import com.bykv.vk.component.ttvideo.player.C;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import okhttp3.internal._UtilJvmKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class LockableKt {
    public static final void assertLockHeld(@NotNull Lockable lockable) {
        g0.p(lockable, "<this>");
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(lockable)) {
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + lockable);
    }

    public static final void assertLockNotHeld(@NotNull Lockable lockable) {
        g0.p(lockable, "<this>");
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(lockable)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + lockable);
        }
    }

    public static final void awaitNanos(@NotNull Lockable lockable, long j6) {
        g0.p(lockable, "<this>");
        long j7 = j6 / C.MICROS_PER_SECOND;
        long j8 = j6 - (C.MICROS_PER_SECOND * j7);
        if (j7 > 0 || j6 > 0) {
            lockable.wait(j7, (int) j8);
        }
    }

    public static final void notify(@NotNull Lockable lockable) {
        g0.p(lockable, "<this>");
        lockable.notify();
    }

    public static final void notifyAll(@NotNull Lockable lockable) {
        g0.p(lockable, "<this>");
        lockable.notifyAll();
    }

    public static final void wait(@NotNull Lockable lockable) {
        g0.p(lockable, "<this>");
        lockable.wait();
    }

    public static final <T> T withLock(@NotNull Lockable lockable, @NotNull Function0<? extends T> action) {
        T invoke;
        g0.p(lockable, "<this>");
        g0.p(action, "action");
        synchronized (lockable) {
            try {
                invoke = action.invoke();
                d0.d(1);
            } catch (Throwable th) {
                d0.d(1);
                d0.c(1);
                throw th;
            }
        }
        d0.c(1);
        return invoke;
    }
}
