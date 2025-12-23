package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v {
    public static final int a(@NotNull AtomicInteger atomicInteger) {
        return atomicInteger.get();
    }

    public static final void b(@NotNull AtomicInteger atomicInteger, int i6) {
        atomicInteger.set(i6);
    }
}
