package q3;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a extends kotlin.random.a {
    @Override // kotlin.random.Random
    public long nextLong(long j6) {
        return ThreadLocalRandom.current().nextLong(j6);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j6, long j7) {
        return ThreadLocalRandom.current().nextLong(j6, j7);
    }

    @Override // kotlin.random.a
    @NotNull
    public Random a() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        g0.o(current, "current(...)");
        return current;
    }

    @Override // kotlin.random.Random
    public double nextDouble(double d6) {
        return ThreadLocalRandom.current().nextDouble(d6);
    }

    @Override // kotlin.random.Random
    public int nextInt(int i6, int i7) {
        return ThreadLocalRandom.current().nextInt(i6, i7);
    }
}
