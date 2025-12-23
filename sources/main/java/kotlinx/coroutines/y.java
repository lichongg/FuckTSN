package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface y<T> extends x0<T> {
    boolean c(@NotNull Throwable th);

    boolean p(T t5);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static <T, R> R b(@NotNull y<T> yVar, R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> function2) {
            return (R) x0.a.b(yVar, r5, function2);
        }

        @Nullable
        public static <T, E extends i.b> E c(@NotNull y<T> yVar, @NotNull i.c<E> cVar) {
            return (E) x0.a.c(yVar, cVar);
        }

        @NotNull
        public static <T> kotlin.coroutines.i d(@NotNull y<T> yVar, @NotNull i.c<?> cVar) {
            return x0.a.d(yVar, cVar);
        }

        @NotNull
        public static <T> kotlin.coroutines.i e(@NotNull y<T> yVar, @NotNull kotlin.coroutines.i iVar) {
            return x0.a.e(yVar, iVar);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        public static <T> e2 f(@NotNull y<T> yVar, @NotNull e2 e2Var) {
            return x0.a.f(yVar, e2Var);
        }
    }
}
