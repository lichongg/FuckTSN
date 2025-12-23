package kotlinx.coroutines;

import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface e3<S> extends i.b {
    S U(@NotNull kotlin.coroutines.i iVar);

    void n(@NotNull kotlin.coroutines.i iVar, S s5);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static <S, R> R a(@NotNull e3<S> e3Var, R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> function2) {
            return (R) i.b.a.a(e3Var, r5, function2);
        }

        @Nullable
        public static <S, E extends i.b> E b(@NotNull e3<S> e3Var, @NotNull i.c<E> cVar) {
            return (E) i.b.a.b(e3Var, cVar);
        }

        @NotNull
        public static <S> kotlin.coroutines.i c(@NotNull e3<S> e3Var, @NotNull i.c<?> cVar) {
            return i.b.a.c(e3Var, cVar);
        }

        @NotNull
        public static <S> kotlin.coroutines.i d(@NotNull e3<S> e3Var, @NotNull kotlin.coroutines.i iVar) {
            return i.b.a.d(e3Var, iVar);
        }
    }
}
