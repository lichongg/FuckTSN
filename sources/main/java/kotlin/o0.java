package kotlin;

import java.util.List;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "TuplesKt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o0 {
    @NotNull
    public static final <A, B> Pair<A, B> a(A a6, B b6) {
        return new Pair<>(a6, b6);
    }

    @NotNull
    public static final <T> List<T> b(@NotNull Pair<? extends T, ? extends T> pair) {
        kotlin.jvm.internal.g0.p(pair, "<this>");
        return kotlin.collections.f0.Q(pair.getFirst(), pair.getSecond());
    }

    @NotNull
    public static final <T> List<T> c(@NotNull Triple<? extends T, ? extends T, ? extends T> triple) {
        kotlin.jvm.internal.g0.p(triple, "<this>");
        return kotlin.collections.f0.Q(triple.getFirst(), triple.getSecond(), triple.getThird());
    }
}
