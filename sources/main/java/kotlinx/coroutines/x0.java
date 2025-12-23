package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface x0<T> extends e2 {
    @ExperimentalCoroutinesApi
    @Nullable
    Throwable F();

    @NotNull
    kotlinx.coroutines.selects.g<T> L();

    @ExperimentalCoroutinesApi
    T d();

    @Nullable
    Object f(@NotNull kotlin.coroutines.e<? super T> eVar);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static <T, R> R b(@NotNull x0<? extends T> x0Var, R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> function2) {
            return (R) e2.a.d(x0Var, r5, function2);
        }

        @Nullable
        public static <T, E extends i.b> E c(@NotNull x0<? extends T> x0Var, @NotNull i.c<E> cVar) {
            return (E) e2.a.e(x0Var, cVar);
        }

        @NotNull
        public static <T> kotlin.coroutines.i d(@NotNull x0<? extends T> x0Var, @NotNull i.c<?> cVar) {
            return e2.a.h(x0Var, cVar);
        }

        @NotNull
        public static <T> kotlin.coroutines.i e(@NotNull x0<? extends T> x0Var, @NotNull kotlin.coroutines.i iVar) {
            return e2.a.i(x0Var, iVar);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        public static <T> e2 f(@NotNull x0<? extends T> x0Var, @NotNull e2 e2Var) {
            return e2.a.j(x0Var, e2Var);
        }
    }
}
