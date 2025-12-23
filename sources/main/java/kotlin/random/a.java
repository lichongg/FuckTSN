package kotlin.random;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPlatformRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformRandom.kt\nkotlin/random/AbstractPlatformRandom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1#2:94\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a extends Random {
    @NotNull
    public abstract java.util.Random a();

    @Override // kotlin.random.Random
    public int nextInt() {
        return a().nextInt();
    }

    @Override // kotlin.random.Random
    @NotNull
    public byte[] nextBytes(@NotNull byte[] array) {
        g0.p(array, "array");
        a().nextBytes(array);
        return array;
    }

    @Override // kotlin.random.Random
    public int nextInt(int i6) {
        return a().nextInt(i6);
    }

    @Override // kotlin.random.Random
    public int nextBits(int i6) {
        return f.j(a().nextInt(), i6);
    }

    @Override // kotlin.random.Random
    public boolean nextBoolean() {
        return a().nextBoolean();
    }

    @Override // kotlin.random.Random
    public double nextDouble() {
        return a().nextDouble();
    }

    @Override // kotlin.random.Random
    public float nextFloat() {
        return a().nextFloat();
    }

    @Override // kotlin.random.Random
    public long nextLong() {
        return a().nextLong();
    }
}
