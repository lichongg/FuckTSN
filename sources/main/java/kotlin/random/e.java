package kotlin.random;

import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {
    public static final double d(int i6, int i7) {
        return ((i6 << 27) + i7) / 9.007199254740992E15d;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final java.util.Random a(@NotNull Random random) {
        java.util.Random a6;
        g0.p(random, "<this>");
        a aVar = random instanceof a ? (a) random : null;
        return (aVar == null || (a6 = aVar.a()) == null) ? new c(random) : a6;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final Random b(@NotNull java.util.Random random) {
        Random a6;
        g0.p(random, "<this>");
        c cVar = random instanceof c ? (c) random : null;
        return (cVar == null || (a6 = cVar.a()) == null) ? new d(random) : a6;
    }

    @InlineOnly
    private static final Random c() {
        return kotlin.internal.b.f43804a.b();
    }
}
