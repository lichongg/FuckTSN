package kotlinx.coroutines;

import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.e3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public interface j0<S> extends e3<S> {
    @NotNull
    kotlin.coroutines.i e(@NotNull i.b bVar);

    @NotNull
    j0<S> l();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static <S, R> R a(@NotNull j0<S> j0Var, R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> function2) {
            return (R) e3.a.a(j0Var, r5, function2);
        }

        @Nullable
        public static <S, E extends i.b> E b(@NotNull j0<S> j0Var, @NotNull i.c<E> cVar) {
            return (E) e3.a.b(j0Var, cVar);
        }

        @NotNull
        public static <S> kotlin.coroutines.i c(@NotNull j0<S> j0Var, @NotNull i.c<?> cVar) {
            return e3.a.c(j0Var, cVar);
        }

        @NotNull
        public static <S> kotlin.coroutines.i d(@NotNull j0<S> j0Var, @NotNull kotlin.coroutines.i iVar) {
            return e3.a.d(j0Var, iVar);
        }
    }
}
