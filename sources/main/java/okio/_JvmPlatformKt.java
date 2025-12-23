package okio;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class _JvmPlatformKt {
    @NotNull
    public static final byte[] asUtf8ToByteArray(@NotNull String str) {
        g0.p(str, "<this>");
        byte[] bytes = str.getBytes(kotlin.text.e.f47851b);
        g0.o(bytes, "getBytes(...)");
        return bytes;
    }

    @NotNull
    public static final ReentrantLock newLock() {
        return new ReentrantLock();
    }

    @NotNull
    public static final String toUtf8String(@NotNull byte[] bArr) {
        g0.p(bArr, "<this>");
        return new String(bArr, kotlin.text.e.f47851b);
    }

    public static final <T> T withLock(@NotNull ReentrantLock reentrantLock, @NotNull Function0<? extends T> action) {
        g0.p(reentrantLock, "<this>");
        g0.p(action, "action");
        reentrantLock.lock();
        try {
            return action.invoke();
        } finally {
            d0.d(1);
            reentrantLock.unlock();
            d0.c(1);
        }
    }
}
