package okio.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class _AtomicKt {
    public static final int setBitsOrZero(@NotNull AtomicInteger atomicInteger, int i6) {
        int i7;
        int i8;
        g0.p(atomicInteger, "<this>");
        do {
            i7 = atomicInteger.get();
            if ((i7 & i6) != 0) {
                return 0;
            }
            i8 = i7 | i6;
        } while (!atomicInteger.compareAndSet(i7, i8));
        return i8;
    }
}
