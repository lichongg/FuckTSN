package i4;

import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "TimingKt")
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b {
    public static final long a(@NotNull Function0<n1> block) {
        g0.p(block, "block");
        long nanoTime = System.nanoTime();
        block.invoke();
        return System.nanoTime() - nanoTime;
    }

    public static final long b(@NotNull Function0<n1> block) {
        g0.p(block, "block");
        long currentTimeMillis = System.currentTimeMillis();
        block.invoke();
        return System.currentTimeMillis() - currentTimeMillis;
    }
}
