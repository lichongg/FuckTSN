package androidx.room.concurrent;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ReentrantLockKt {
    public static final <T> T withLock(@NotNull ReentrantLock reentrantLock, @NotNull Function0<? extends T> block) {
        g0.p(reentrantLock, "<this>");
        g0.p(block, "block");
        reentrantLock.lock();
        try {
            return block.invoke();
        } finally {
            d0.d(1);
            reentrantLock.unlock();
            d0.c(1);
        }
    }
}
