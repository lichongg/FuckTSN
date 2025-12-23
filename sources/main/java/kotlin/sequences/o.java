package kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import kotlin.SinceKotlin;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
@RestrictsSuspension
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class o<T> {
    @Nullable
    public abstract Object c(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Nullable
    public abstract Object f(@NotNull Iterator<? extends T> it, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Nullable
    public final Object e(@NotNull Iterable<? extends T> iterable, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return n1.f44123a;
        }
        Object f6 = f(iterable.iterator(), eVar);
        return f6 == kotlin.coroutines.intrinsics.a.l() ? f6 : n1.f44123a;
    }

    @Nullable
    public final Object g(@NotNull m<? extends T> mVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object f6 = f(mVar.iterator(), eVar);
        if (f6 == kotlin.coroutines.intrinsics.a.l()) {
            return f6;
        }
        return n1.f44123a;
    }
}
